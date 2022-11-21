package com.example.conf;

import io.swagger.annotations.ApiOperation;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


/**
 * Swagger2配置类
 * 在与spring boot集成时，放在与Application.java同级的目录下。
 * 或者通过 @Import 导入配置
 */
@Configuration
@EnableSwagger2 //开启swagger2,若启动类上添加了该注解，则配置类可以不添加
public class SwaggerConfig {

    /**
     * 创建API应用
     * apiInfo() 增加API相关信息
     * 通过select()函数返回一个ApiSelectorBuilder实例,用来控制哪些接口暴露给Swagger来展现，
     * 本例采用指定扫描的包路径来定义指定要建立API的目录。
     * @return
     */
    @Bean
    public Docket createRestApi() {
        // Docket是swagger全局配置对象
        // DocumentationType：指定文档类型为swagger2
        return new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo()).groupName("student")
                .select().apis(RequestHandlerSelectors.withMethodAnnotation(ApiOperation.class)).build();
    }

    /**
     * 创建该API的基本信息（这些基本信息会展现在文档页面中）
     * 访问地址：http://项目实际地址/swagger-ui.html
     * @return
     */
    private ApiInfo apiInfo() {
        // 作者信息
        Contact contact = new Contact(
                // 文档发布者的名称
                "zhangsan",
                // 文档发布者的网站地址
                "https://iqiuq.gitee.io/qiuqblogs/",
                // 文档发布者的电子邮箱
                "qiuyonghui258@163.com"
        );
        return new ApiInfoBuilder()
                //标题
                .title("swagger测试用例")
                //文本描述
                .description("swagger测试用例")
                //服务组url地址
                .termsOfServiceUrl("")
                //执照
                .license("个人版权")
                //作者信息
                .contact(contact)
                //版本号
                .version("1.0")
                .build();
    }

}
