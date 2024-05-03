package org.example.maker.cli.command;

import cn.hutool.core.util.ReflectUtil;
import org.example.maker.model.DataModel;
import picocli.CommandLine;

import java.lang.reflect.Field;
@CommandLine.Command(name = "config", description = "查看参数信息", mixinStandardHelpOptions = true)
public class ConfigCommand implements Runnable{


    @Override
    public void run() {

        Field[] fields= ReflectUtil.getFields(DataModel.class);
        for (Field field:fields){
            System.out.println("字段名称：" + field.getName());
            System.out.println("字段类型：" + field.getType());
//            System.out.println("Modifiers: " + java.lang.reflect.Modifier.toString(field.getModifiers()));
            System.out.println("---");
        }
    }
}
