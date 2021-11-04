package mbg;


import org.junit.Test;
import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.internal.DefaultShellCallback;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class MyBatisGeneratorTest {
    @Test
    public void generate(){
        testGenerate("/mybatis-generator-config.xml");
        testGenerate("/generator-config.xml");
    }

    private void testGenerate(String path){
        //用于承载返回信息
        List<String> warnings = new ArrayList<>();
        try(InputStream inputStream = MyBatisGeneratorTest.class.getResourceAsStream(path)) {
            ConfigurationParser parser = new ConfigurationParser(warnings);
            Configuration configuration = parser.parseConfiguration(inputStream);
            MyBatisGenerator generator = new MyBatisGenerator(configuration, new DefaultShellCallback(true), warnings);
            generator.generate(null);
        }catch (Exception e){
            e.printStackTrace();
        }
            //打印返回信息
            warnings.forEach(System.out::println);
        }
    }