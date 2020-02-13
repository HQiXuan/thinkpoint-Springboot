package com.hy.springboot.util;

import org.springframework.web.bind.annotation.GetMapping;

import java.io.*;

public class AddTextToPPT {

    public static void save(String title,String path) throws Exception{
        //获取文件下载路径
        //String path = "F:/ppt/毕业答辩.ppt";
        //String path = "F:/ppt/" + name + ".ppt";
        File file = new File(path);
        InputStream inputStream = new FileInputStream(file);
        String filename = title + ".ppt";
        SaveFile.savePPT(inputStream, filename);
    }

    //分析文本并返回PPT
    public static String[] text(String text){
        String[] arguments = new String[] {"python", "/classif/FenJu/simple.py",text};
        String line = null;
        int i = 0;
        String result[] = new String[100];
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
        return result;
    }

    //分类聚类
    public static String classifyPPT(String text) throws Exception{
        String[] arguments = new String[] {"python", "/classif/TopicClassify.py",text};
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
}
