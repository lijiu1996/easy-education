package com.lijiawei.education.serviceedu.lang;

import lombok.SneakyThrows;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.type.AnnotationMetadata;
import org.springframework.core.type.classreading.CachingMetadataReaderFactory;
import org.springframework.core.type.classreading.MetadataReader;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

public class MetaDataTest2 {

    @Service
    @Configuration
    public class Config {

        @RequestMapping
        public void a() {

        }
    }

    @SneakyThrows
    @Test
    public void test1() {
        String component = "org.springframework.stereotype.Component";
        String configuration = "org.springframework.context.annotation.Configuration";

        CachingMetadataReaderFactory factory = new CachingMetadataReaderFactory();
        MetadataReader metadataReader = factory.getMetadataReader("com.lijiawei.education.serviceedu.lang.MetaDataTest2.Config");
        AnnotationMetadata meta = metadataReader.getAnnotationMetadata();

        boolean annotated = meta.isAnnotated(component);
        System.out.println(annotated);

    }
}
