package com.lijiawei.education.serviceedu;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.type.ClassMetadata;
import org.springframework.core.type.StandardAnnotationMetadata;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.HashMap;

@Repository("repositoryName")
@Service("serviceName")
class MetaDemo extends HashMap<String,String> implements Serializable {

    private static class InnerClass {

    }

    @Autowired
    private String getName() {
        return "demo";
    }
}

public class MetaDataTest {

    public static void main(String[] args) {

        StandardAnnotationMetadata metadata = new StandardAnnotationMetadata(MetaDemo.class,true);
        System.out.println("=====ClassMetaData===");
        ClassMetadata classMetadata = metadata;
        System.out.println(classMetadata.getClassName());
        System.out.println(classMetadata.getEnclosingClassName());
    }
}
