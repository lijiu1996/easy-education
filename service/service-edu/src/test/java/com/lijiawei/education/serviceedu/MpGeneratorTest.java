package com.lijiawei.education.serviceedu;

import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.config.OutputFile;
import com.baomidou.mybatisplus.generator.config.rules.DateType;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Collections;

@SpringBootTest
public class MpGeneratorTest {

    @Test
    public void test() {
        FastAutoGenerator.create("jdbc:mysql://localhost:3306/glxy", "root", "123456")
                .globalConfig(builder -> {
                    builder.author("lijiawei") // 设置作者
//                            .enableSwagger() // 开启 swagger 模式
                            .dateType(DateType.TIME_PACK) // 时间类型选择java8时间类型
                            .outputDir("D:\\Classes\\项目\\3 尚硅谷谷粒学院\\myProject\\service\\service-edu\\src\\main\\java"); // 指定输出目录

                })
                .packageConfig(builder -> {
                    builder.parent("com.lijiawei.education") // 设置父包名
                            .moduleName("serviceedu") // 设置父包模块名
                            .pathInfo(Collections.singletonMap(OutputFile.xml, "D:\\Classes\\项目\\3 尚硅谷谷粒学院\\myProject\\service\\service-edu\\src\\main\\resources\\mapper")); // 设置mapperXml生成路径
                })
                .strategyConfig(builder -> {
                    builder.addInclude("edu_teacher")// 设置需要生成的表名
                            .addTablePrefix("edu_") // 设置过滤表前缀
                            .entityBuilder()
                            .enableLombok()
                            .controllerBuilder()
                            .enableRestStyle();  // ze
                })
//                .templateEngine(new FreemarkerTemplateEngine()) // 使用Freemarker引擎模板，默认的是Velocity引擎模板
                .execute();
    }
}
