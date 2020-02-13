package com.hy.springboot.util;

import java.awt.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.xslf.usermodel.*;

public class ModifyPPT {
    public static String modity(String[] result, String path) throws  Exception
    {
        //复制一份
        //测试用的
        //path = "F:\\工作总结.ppt";
        System.out.println("path：" + path);
        String targetPath = FileUtils.copyFile(path, "/temp/ppt");
        System.out.println(targetPath);
        poiUtil(result, targetPath);
        return targetPath;
    }
    public static void poiUtil(String[] text, String location) throws Exception {
        // File file = new File("F:/工作总结.pptx");
        File file = new File(location);
        XMLSlideShow ppt = new XMLSlideShow(new FileInputStream(file));

        List<XSLFSlide> slides = ppt.getSlides();

        int i=0;
        // 3
        XSLFSlide selectesdslide = slides.get(2);
        XSLFTextBox shape1 = selectesdslide.createTextBox();
        Rectangle anchor1 = new Rectangle(30, 230, 200, 100);
        Rectangle anchor2 = new Rectangle(360, 150, 200, 100);
        Rectangle anchor3 = new Rectangle(600, 230, 200, 100);

        shape1.setAnchor(anchor1);
        XSLFTextParagraph paragraph1 = shape1.addNewTextParagraph();
        XSLFTextRun run1 = paragraph1.addNewTextRun();
        run1.setText(text[i]);
        System.out.println(text[i]);
        run1.setFontSize((double) 20);
        run1.setFontColor(Color.WHITE);

        i++;
        XSLFTextBox shape2 = selectesdslide.createTextBox();
        shape2.setAnchor(anchor2);
        XSLFTextParagraph paragraph2 = shape2.addNewTextParagraph();
        XSLFTextRun run2 = paragraph2.addNewTextRun();
        run2.setText(text[i]);
        System.out.println(text[i]);
        run2.setFontSize((double) 20);
        run2.setFontColor(Color.WHITE);

        i++;
        XSLFTextBox shape3 = selectesdslide.createTextBox();
        shape3.setAnchor(anchor3);
        XSLFTextParagraph paragraph3 = shape3.addNewTextParagraph();
        XSLFTextRun run3 = paragraph3.addNewTextRun();
        run3.setText(text[i]);
        System.out.println(text[i]);
        run3.setFontSize((double) 20);
        run3.setFontColor(Color.WHITE);

        i++;
        // 4
        selectesdslide = slides.get(3);
        Rectangle anchor4 = new Rectangle(2, 400, 150, 100);
        Rectangle anchor5 = new Rectangle(160, 400, 150, 100);
        Rectangle anchor6 = new Rectangle(370, 400, 150, 100);
        XSLFTextBox shape4 = selectesdslide.createTextBox();
        shape4.setAnchor(anchor4);
        XSLFTextParagraph paragraph4 = shape4.addNewTextParagraph();
        XSLFTextRun run4 = paragraph4.addNewTextRun();
        run4.setText(text[i]);
        System.out.println(text[i]);
        run4.setFontSize((double) 12);

        i++;
        XSLFTextBox shape5 = selectesdslide.createTextBox();
        shape5.setAnchor(anchor5);
        XSLFTextParagraph paragraph5 = shape5.addNewTextParagraph();
        XSLFTextRun run5 = paragraph5.addNewTextRun();
        run5.setText(text[i]);
        System.out.println(text[i]);
        run5.setFontSize((double) 12);

        i++;
        XSLFTextBox shape6 = selectesdslide.createTextBox();
        shape6.setAnchor(anchor6);
        XSLFTextParagraph paragraph6 = shape6.addNewTextParagraph();
        XSLFTextRun run6 = paragraph6.addNewTextRun();
        run6.setText(text[i]);
        System.out.println(text[i]);
        run6.setFontSize((double) 12);

        i++;
        // 6
        selectesdslide = slides.get(5);
        XSLFTextBox shape7 = selectesdslide.createTextBox();
        Rectangle anchor7 = new Rectangle(20, 150, 260, 100);
        Rectangle anchor8 = new Rectangle(600, 150, 260, 100);
        Rectangle anchor9 = new Rectangle(20, 400, 260, 100);
        Rectangle anchor10 = new Rectangle(600, 400, 260, 100);
        shape7.setAnchor(anchor7);
        XSLFTextParagraph paragraph7 = shape7.addNewTextParagraph();
        XSLFTextRun run7 = paragraph7.addNewTextRun();
        run7.setText(text[i]);
        System.out.println(text[i]);
        run7.setFontSize((double) 12);
        run7.setFontColor(Color.WHITE);

        i++;
        XSLFTextBox shape8 = selectesdslide.createTextBox();
        shape8.setAnchor(anchor8);
        XSLFTextParagraph paragraph8 = shape8.addNewTextParagraph();
        XSLFTextRun run8 = paragraph8.addNewTextRun();
        run8.setText(text[i]);
        System.out.println(text[i]);
        run8.setFontSize((double) 12);
        run8.setFontColor(Color.WHITE);

        i++;
        XSLFTextBox shape9 = selectesdslide.createTextBox();
        shape9.setAnchor(anchor9);
        XSLFTextParagraph paragraph9 = shape9.addNewTextParagraph();
        XSLFTextRun run9 = paragraph9.addNewTextRun();
        run9.setText(text[i]);
        System.out.println(text[i]);
        run9.setFontSize((double) 12);
        run9.setFontColor(Color.WHITE);

        i++;
        XSLFTextBox shape10 = selectesdslide.createTextBox();
        shape10.setAnchor(anchor10);
        XSLFTextParagraph paragraph10 = shape10.addNewTextParagraph();
        XSLFTextRun run10 = paragraph10.addNewTextRun();
        run10.setText(text[i]);
        System.out.println(text[i]);
        run10.setFontSize((double) 12);
        run10.setFontColor(Color.WHITE);

        i++;
        // 7
        XSLFTextBox shape11 = selectesdslide.createTextBox();
        XSLFTextParagraph paragraph11 = shape11.addNewTextParagraph();
        Rectangle anchor11 = new Rectangle(2, 400, 60, 100);
        Rectangle anchor12 = new Rectangle(70, 400, 60, 100);
        Rectangle anchor13 = new Rectangle(120, 400, 60, 100);
        shape11.setAnchor(anchor11);
        paragraph11 = shape11.addNewTextParagraph();
        XSLFTextRun run11 = paragraph11.addNewTextRun();
        run11.setText(text[i]);
        System.out.println(text[i]);
        run11.setFontSize((double) 12);

        i++;
        XSLFTextBox shape12 = selectesdslide.createTextBox();
        shape12.setAnchor(anchor12);
        XSLFTextParagraph paragraph12 = shape12.addNewTextParagraph();
        XSLFTextRun run12 = paragraph2.addNewTextRun();
        run12.setText(text[i]);
        System.out.println(text[i]);
        run12.setFontSize((double) 12);

        i++;
        XSLFTextBox shape13 = selectesdslide.createTextBox();
        shape13.setAnchor(anchor13);
        XSLFTextParagraph paragraph13 = shape13.addNewTextParagraph();
        XSLFTextRun run13 = paragraph13.addNewTextRun();
        run13.setText(text[i]);
        System.out.println(text[i]);
        run13.setFontSize((double) 12);

        i++;
        // 9
        selectesdslide = slides.get(8);
        XSLFTextBox shape14 = selectesdslide.createTextBox();
        Rectangle anchor14 = new Rectangle(10, 240, 260, 100);

        shape14.setAnchor(anchor14);
        XSLFTextParagraph paragraph14 = shape14.addNewTextParagraph();
        XSLFTextRun run14 = paragraph14.addNewTextRun();
        run14.setText(text[i]+text[i+1]+text[i+2]);
        System.out.println(text[i]);
        run14.setFontSize((double) 12);
        run14.setFontColor(Color.WHITE);

        i = i+3;
        System.out.println(i);
        // 10
        selectesdslide = slides.get(9);
        XSLFTextBox shape15 = selectesdslide.createTextBox();
        Rectangle anchor15 = new Rectangle(50, 300, 260, 100);

        shape15.setAnchor(anchor15);
        XSLFTextParagraph paragraph15 = shape15.addNewTextParagraph();
        XSLFTextRun run15 = paragraph15.addNewTextRun();
        run15.setText(text[i]+text[i+1]+text[i+2]);
        System.out.println(text[i]);
        run15.setFontSize((double) 16);
        run15.setFontColor(Color.WHITE);

        i = i+3;
        System.out.println(i);
        // 12
        selectesdslide = slides.get(11);
        XSLFTextBox shape16 = selectesdslide.createTextBox();
        Rectangle anchor16 = new Rectangle(80, 200, 120, 100);
        Rectangle anchor17 = new Rectangle(680, 200, 120, 100);
        Rectangle anchor18 = new Rectangle(80, 400, 120, 100);
        Rectangle anchor19 = new Rectangle(680, 400, 120, 100);
        shape16.setAnchor(anchor16);
        XSLFTextParagraph paragraph16 = shape16.addNewTextParagraph();
        XSLFTextRun run16 = paragraph16.addNewTextRun();
        run16.setText(text[i]);
        System.out.println(text[i]);
        run16.setFontSize((double) 12);
        run16.setFontColor(Color.WHITE);

        i++;
        XSLFTextBox shape17 = selectesdslide.createTextBox();
        shape17.setAnchor(anchor17);
        XSLFTextParagraph paragraph17 = shape17.addNewTextParagraph();
        XSLFTextRun run17 = paragraph17.addNewTextRun();
        run17.setText(text[i]);
        System.out.println(text[i]);
        run17.setFontSize((double) 12);
        run17.setFontColor(Color.WHITE);

        i++;
        XSLFTextBox shape18 = selectesdslide.createTextBox();
        shape18.setAnchor(anchor18);
        XSLFTextParagraph paragraph18 = shape18.addNewTextParagraph();
        XSLFTextRun run18 = paragraph18.addNewTextRun();
        run18.setText(text[i]);
        System.out.println(text[i]);
        run18.setFontSize((double) 12);
        run18.setFontColor(Color.WHITE);

        i++;
        XSLFTextBox shape19 = selectesdslide.createTextBox();
        shape19.setAnchor(anchor19);
        XSLFTextParagraph paragraph19 = shape19.addNewTextParagraph();
        XSLFTextRun run19 = paragraph19.addNewTextRun();
        run19.setText(text[i]);
        System.out.println(text[i]);
        run19.setFontSize((double) 12);
        run19.setFontColor(Color.WHITE);

        i++;
        // 13
        selectesdslide = slides.get(12);
        XSLFTextBox shape20 = selectesdslide.createTextBox();
        Rectangle anchor20 = new Rectangle(80, 370, 200, 100);
        Rectangle anchor21 = new Rectangle(370, 370, 200, 100);
        Rectangle anchor22 = new Rectangle(670, 370, 200, 100);

        shape20.setAnchor(anchor20);
        XSLFTextParagraph paragraph20 = shape20.addNewTextParagraph();
        XSLFTextRun run20 = paragraph20.addNewTextRun();
        run20.setText(text[i]);
        System.out.println(text[i]);
        run20.setFontSize((double) 12);
        run20.setFontColor(Color.WHITE);

        i++;
        XSLFTextBox shape21 = selectesdslide.createTextBox();
        shape21.setAnchor(anchor21);
        XSLFTextParagraph paragraph21 = shape21.addNewTextParagraph();
        XSLFTextRun run21 = paragraph21.addNewTextRun();
        run21.setText(text[i]);
        System.out.println(text[i]);
        run21.setFontSize((double) 12);
        run21.setFontColor(Color.WHITE);

        i++;
        XSLFTextBox shape22 = selectesdslide.createTextBox();
        shape22.setAnchor(anchor22);
        XSLFTextParagraph paragraph22 = shape22.addNewTextParagraph();
        XSLFTextRun run22 = paragraph22.addNewTextRun();
        run22.setText(text[i]);
        System.out.println(text[i]);
        run22.setFontSize((double) 12);
        run22.setFontColor(Color.WHITE);

        // creating an file object
        FileOutputStream out = new FileOutputStream(file);
        System.out.println("test2执行完毕。。。。");
        // saving the changes to a file
        ppt.write(out);
        out.close();
    }
}
