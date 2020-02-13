package com.hy.springboot.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class FileUtils {
    /**
     * 文件复制
     *
     * @param srcPath    源文件路径
     * @param targetPath 复制后存放路径
     * @throws Exception
     */
    public static String copyFile(String srcPath, String targetPath) throws Exception {
        File srcFile = new File(srcPath);
        File target = new File(targetPath);
        if (!srcFile.exists()) {
            throw new Exception("文件不存在！");
        }
        if (!srcFile.isFile()) {
            throw new Exception("不是文件！");
        }
        //判断目标路径是否是目录
        if (!target.isDirectory()) {
            throw new Exception("文件路径不存在！");
        }

        // 获取源文件的文件名
        String fileName = srcPath.substring(srcPath.lastIndexOf("/") + 1);
        //TODO:判断是否存在相同的文件名的文件
        File[] listFiles = target.listFiles();
        for (File file : listFiles) {
            if (fileName.equals(file.getName())) {
                fileName += "_1";
            }
        }
        String newFileName = targetPath + File.separator + fileName;
        File targetFile = new File(newFileName);
        FileInputStream in = null;
        FileOutputStream out = null;
        try {
            in = new FileInputStream(srcFile);
            out = new FileOutputStream(targetFile);
            //从in中批量读取字节，放入到buf这个字节数组中，
            // 从第0个位置开始放，最多放buf.length个 返回的是读到的字节的个数
            byte[] buf = new byte[8 * 1024];
            int len = 0;
            while ((len = in.read(buf)) != -1) {
                out.write(buf, 0, len);
                out.flush();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (in != null) {
                    in.close();
                }
            } catch (Exception e) {
                System.out.println("关闭输入流错误！");
            }
            try {
                if (out != null) {
                    out.close();
                }
            } catch (Exception e) {
                System.out.println("关闭输出流错误！");
            }
        }
        System.out.println(targetPath +":---" + fileName);
        return targetPath +"/" + fileName;
    }

    //测试
    public static void main(String[] args) throws Exception {
        copyFile("F:\\工作总结.ppt", "E:\\");
    }

}
