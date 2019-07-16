package com.hanma.config;

/*
*
 * Created by zhaoyumeng on 2019/6/3.
*/


import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;

@Component
@EnableSwagger2
public class SwaggerConfig {


    private String swaggerPackage = "com.hanma";

    @Bean
    public Docket docket() {

        return new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo())
                // 通过.select()方法，去配置扫描接口
                .select()
                // RequestHandlerSelectors配置如何扫描接口
                .apis(RequestHandlerSelectors.basePackage(swaggerPackage)).build();

    }


    private ApiInfo apiInfo() {
        Contact contact = new Contact("订单接口",
                "http://www.baidu.com","");
        return new ApiInfo("订单接口", // 标题
                "订单接口", // 描述
                "v1.0", // 版本
                "http://terms.service.url/组织链接", // 组织链接
                contact, // 联系人信息
                "Apach 2.0 许可", // 许可
                "许可链接", // 许可连接
                new ArrayList<>()); // 扩展
    }
}