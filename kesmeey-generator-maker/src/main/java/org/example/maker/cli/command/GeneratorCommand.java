package org.example.maker.cli.command;

import cn.hutool.core.bean.BeanUtil;
import freemarker.template.TemplateException;
import lombok.Data;
import org.example.maker.generator.file.FileGenerator;
import org.example.maker.model.DataModel;
import picocli.CommandLine;

import java.io.IOException;
import java.util.concurrent.Callable;

@CommandLine.Command(name = "generate",mixinStandardHelpOptions = true)
@Data
public class GeneratorCommand implements Callable<Integer> {
    @CommandLine.Option(names = {"-a","--author"},arity = "0..1",description = "作者名称",interactive = true, echo = true)
    private String author="nine";

    @CommandLine.Option(names = {"-o","--outputText"},arity = "0..1",description = "输出文本",interactive = true, echo = true)
    private String outputText="smee";

    /*是否循环*/
     @CommandLine.Option(names = {"-l","--loop"},arity = "0..1",description = "是否循环",interactive = true, echo = true)
    private boolean isLoop;



    @Override
    public Integer call() throws Exception {
        DataModel dataModel =new DataModel();
        BeanUtil.copyProperties(this, dataModel);
        try {
            FileGenerator.doGenerate(dataModel);
        } catch (TemplateException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return null;
    }
}
