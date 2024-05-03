package org.example.maker.generator;

import java.io.*;
import java.util.Map;

public class JarGenerator {

    public static void doGenerate(String projectDir) throws IOException, InterruptedException {
        String winMavenCommand = "mvn.cmd clean package -DskipTest=true";
        String otherMavenCommand = "mvn clean package  -DskipTest=true";
        String mavenCommand =winMavenCommand;

        ProcessBuilder processBuilder=new ProcessBuilder(mavenCommand.split(" "));
        processBuilder.directory(new File(projectDir));
        Map<String,String> environment=processBuilder.environment();
        System.out.println(environment);
        Process process = processBuilder.start();

        InputStream inputStream = process.getInputStream();
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
        String line = null;
        while ( (line=reader.readLine())!=null){
            System.out.println(line);
        }

        int exitCode =process.waitFor();
        System.out.println("命令执行结束"+exitCode);

    }

    public static void main(String[] args) throws IOException, InterruptedException {
        doGenerate("E:\\java\\kesmeeyGenerator\\kesmeey-generator-maker\\generated");

    }
}
