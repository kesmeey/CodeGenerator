package org.example.generator;

import cn.hutool.core.io.FileUtil;

import java.io.File;

/*
* 静态文件
* */
public class StaticGenerator {

    public static void main(String[] args) {
        // 获取整个项目的根路径
        String projectPath = System.getProperty("user.dir");
        File parentFile = new File(projectPath).getParentFile();
        // 输入路径：ACM 示例代码模板目录
        String inputPath = new File(projectPath, "demo/acm-template").getAbsolutePath();
        // 输出路径：直接输出到项目的根目录
        String outputPath = projectPath;
      //  System.out.println(outputPath);
       // System.out.println(inputPath);
        copyFilesByHutool(inputPath, outputPath);

    }


    public static void copyFilesByHutool(String inputPath, String outputPath) {
        FileUtil.copy(inputPath, outputPath, false);
    }
}
