package com.hy.springboot.controller;

import com.hy.springboot.bean.PPT;
import com.hy.springboot.mapper.PPTMapper;
import com.hy.springboot.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.*;

@RestController
public class MainController {

    @Autowired
    PPTMapper pptMapper;

    //方式一：获取所有文件列表,返回的是JSON数组
    @GetMapping("/allList")
    public List<PPT> getAll(){
        //返回文件名数组，返回文件ID，返回文件路径
        System.out.println("allList: " + pptMapper.getAll());
        return pptMapper.getAll();
    }

    //下载文件 需要返回什么，流？
    //分句
    @GetMapping(value = "/download")
    public void fileDownLoad(HttpServletResponse response) {
        String sourcePath = "";
        String fileName = "";
        System.out.println(sourcePath + " : " + fileName);
        try {
            DownloadKit.download(response,sourcePath,fileName);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @GetMapping("/text")
    public void text(String inputFilename,String[] inputTitle,String[] inputContent) throws Exception{
        // 1.利用文本(将内容拼接)，分类
        String text = "";
        for(int i=0; i<inputContent.length; i++){
            text += inputContent[i];
        }
        String classity = AddTextToPPT.classifyPPT(text);

        //找PPT路径
        int pptNumber = inputTitle.length;
        // pptNumber = label2
        String location = pptMapper.findName(classity, pptNumber);
        System.out.println("location: " + location);
        System.out.println("MainController-text-location: " + location);

        // 2.分词
        String[] result = AddTextToPPT.text(text);
        System.out.println("MainController-text-result: " + result);

        // 3.将分词的结果插入PPT中
        String path = ModifyPPT.modity(result, location);
        System.out.println("MainController-text-path: " + path);

        //4.将ppt保存在ppt文件下
        AddTextToPPT.save(inputFilename,path);

        //将ppt插入数据库
        String id = UUID.randomUUID().toString();
        String name = "科技";
        String loc = "/ppt/" + name + ".pptx";
        PPT ppt = new PPT("1", name, loc, 4,4);
        pptMapper.addPPT(ppt);
    }

    //分析文本并返回PPT
    @GetMapping("/textbak")
    public void textbak(String text,String title) throws Exception{
        // 1.利用文本，分类
        String classity = AddTextToPPT.classifyPPT(text);
        //找PPT路径
        //String location = "F:/科技.pptx";
        //String classity = "科技";
        String location = pptMapper.findNamebak(classity);
        System.out.println("location: " + location);
        //String location = "/ppt/科技.pptx";
        System.out.println("MainController-text-location: " + location);

        // 2.分词
        String[] result = AddTextToPPT.text(text);
        System.out.println("MainController-text-result: " + result);

        // 3.将分词的结果插入PPT中
        String path = ModifyPPT.modity(result, location);
        System.out.println("MainController-text-path: " + path);

        //4.将ppt保存在ppt文件下
        AddTextToPPT.save(title,path);

        //将ppt插入数据库
        String id = UUID.randomUUID().toString();
        String name = "科技";
        String loc = "/ppt/" + name + ".pptx";
        PPT ppt = new PPT("1", name, loc, 4,4);
        pptMapper.addPPT(ppt);
    }

    @GetMapping("/upload")
    public void uploadttp(String name) throws Exception{
        //获取文件下载路径
        //String path = "F:/ppt/毕业答辩.ppt";
        String path = "/ppt/" + name + ".ppt";
        File file = new File(path);
        InputStream inputStream = new FileInputStream(file);
        String filename = "1111.ppt";
        SaveFile.savePPT(inputStream, filename);
    }

    //分类
    @GetMapping("/createPPT")
    public String createPPT(String text) throws Exception{
        String[] arguments = new String[] {"python", "/snownlp/predict.py",text};
        String line = null;
        String result = "";
        try {
            Process process = Runtime.getRuntime().exec(arguments);
            BufferedReader in = new BufferedReader(new InputStreamReader(process.getInputStream(),"GBK"));
            while ((line = in.readLine()) != null) {
                result += line;
                System.out.println(line);
            }
            in.close();
            //java代码中的process.waitFor()返回值为0表示我们调用python脚本成功，
            //返回值为1表示调用python脚本失败，这和我们通常意义上见到的0与1定义正好相反
            int re = process.waitFor();
            System.out.println(re);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    @CrossOrigin    //实现跨域请求
    //下面是编写接口名和请求方式
    @RequestMapping(value = "/pictrue", method = RequestMethod.POST)
    //注意参数的类型和第一个参数的"file",之后会用到的
    public String uploadImg(@RequestParam("takePhoto") MultipartFile takePhoto, HttpServletRequest request, HttpServletResponse response) throws IllegalStateException, IOException {

        //设置文件的保存路径
        //把接口放到服务器上面的话，就改成指定的目录下面
        //String path = "E:/image/";
        String path = "/pptimage/";
        System.out.println(path);

        //文件命名  我这里上传之后的图片就使用了原图
        String originalFilename = takePhoto.getOriginalFilename();
        System.out.println(originalFilename);
        //获取文件的后缀名
        String extendName = originalFilename.substring(originalFilename.lastIndexOf("."), originalFilename.length());

        //判断文件是否是图片
        Map<String, String> map = new HashMap<>();
        String[] imagType = {".jpg", ".png", ".bmp", ".gif"};
        List<String> imageTyepLists = Arrays.asList(imagType);
        if (imageTyepLists.contains(extendName)) {
            File dir = new File(path, originalFilename);
            //并接图片路径
            String ImgPath=path+originalFilename;
            File filepath = new File(path);
            //创建存放图片的文件夹
            if (!filepath.exists()) {
                filepath.mkdirs();
            }
            //把图片放进文件夹中
            takePhoto.transferTo(dir);

            //把图片的路径写入数据库
            //imageService.addImagePath(ImgPath);
            String result = BaiDuInterface.general(ImgPath);

            return result;
        }
        return "400";
    }

    //分析文本并返回PPT
    //分类
    @GetMapping("/analyse")
    public static String[] text(String text){
        String splittext[] = text.split("。");
        System.out.println("splittext.length : " + splittext.length);
        String[] result = new String[100];
        int i = 0;
        for(int j=0; j<splittext.length; j++){
            //String[] arguments = new String[] {"python", "F:/snownlp/snownlp/simple.py",splittext[j]};
            String[] arguments = new String[] {"python", "/classif/FenJu/simple.py ",splittext[j]};
            String line = null;
            try {
                Process process = Runtime.getRuntime().exec(arguments);
                BufferedReader in = new BufferedReader(new InputStreamReader(process.getInputStream(),"GBK"));

                while ((line = in.readLine()) != null) {
                    result[i]= line;
                    i++;
                    System.out.println(line);
                }
                in.close();
                //java代码中的process.waitFor()返回值为0表示我们调用python脚本成功，
                //返回值为1表示调用python脚本失败，这和我们通常意义上见到的0与1定义正好相反
                int re = process.waitFor();
                System.out.println(re);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        System.out.println(i);
        return result;
    }

    @GetMapping("/add")
    public List<PPT> add(){
        //将ppt插入数据库
        //String id = UUID.randomUUID().toString();
        String id = "1";
        String name = "科技";
        String loc = "/ppt/" + name + ".pptx";
        PPT ppt = new PPT(id, name, loc, 4,4);
        pptMapper.addPPT(ppt);

        //返回文件名数组，返回文件ID，返回文件路径
        System.out.println("allList: " + pptMapper.getAll());
        return pptMapper.getAll();
    }
}
