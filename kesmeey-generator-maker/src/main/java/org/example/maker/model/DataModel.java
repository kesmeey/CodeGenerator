package org.example.maker.model;


import lombok.Data;
/*
*
* 静态模板配置*/
@Data
public class DataModel {
    private String author;

    private String outputText;

    /*是否循环*/

    private boolean isLoop;



}
