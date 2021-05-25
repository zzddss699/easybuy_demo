package com.zds.easybuy_demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@MapperScan("com.zds.easybuy_demo.mapper")//注意MapperScan要导tk的包，不然会报NoSuchMethodException
public class EasybuyDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(EasybuyDemoApplication.class, args);
    }

}
