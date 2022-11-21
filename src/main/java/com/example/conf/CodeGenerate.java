//package com.example.conf;
//
//import com.baomidou.mybatisplus.annotation.IdType;
//import com.baomidou.mybatisplus.generator.AutoGenerator;
//import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
//import com.baomidou.mybatisplus.generator.config.GlobalConfig;
//import com.baomidou.mybatisplus.generator.config.PackageConfig;
//import com.baomidou.mybatisplus.generator.config.StrategyConfig;
//import com.baomidou.mybatisplus.generator.config.rules.DateType;
//import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
//
///**
// * @Author twt
// * @Date 2021/4/9 9:47
// */
//public class CodeGenerate {
//    public static void main(String[] args) {
//        // Step1：代码生成器
//        AutoGenerator mpg = new AutoGenerator();
//
//        // Step2：全局配置
//        GlobalConfig gc = new GlobalConfig();
//
//        String projectPath = "C:\\Users\\tao511221\\IdeaProjects\\demo";// 填写代码生成的目录(需要修改)
//        gc.setOutputDir(projectPath + "/src/main/java");// 拼接出代码最终输出的目录
//        gc.setAuthor("twt");// 配置开发者信息（可选）（需要修改）
//        gc.setOpen(false);// 配置是否打开目录，false 为不打开（可选）
//        gc.setSwagger2(false);// 实体属性 Swagger2 注解，添加 Swagger 依赖，开启 Swagger2 模式（可选）
////        gc.setFileOverride(true); //重新生成文件时是否覆盖，false 表示不覆盖（可选）
//        gc.setIdType(IdType.ASSIGN_ID);// 配置主键生成策略，此处为 ASSIGN_ID（可选）
//        gc.setDateType(DateType.ONLY_DATE);// 配置日期类型，此处为 ONLY_DATE（可选）
//        // 默认生成的 service 会有 I 前缀
//        gc.setServiceName("%sService"); // 去掉可以默认IService
//        mpg.setGlobalConfig(gc);
//
//        // Step3：数据源配置（需要修改）
//        DataSourceConfig dsc = new DataSourceConfig();
//        // 配置数据库 url 地址
//        dsc.setUrl("jdbc:mysql://localhost:3306/javaweb?allowMultiQueries=true&useUnicode=true&characterEncoding=UTF-8&useSSL=false");
//        // dsc.setSchemaName("testMyBatisPlus"); // 可以直接在 url 中指定数据库名
//        dsc.setDriverName("com.mysql.jdbc.Driver");// 配置数据库驱动
//        dsc.setUsername("root");// 配置数据库连接用户名
//        dsc.setPassword("123456");// 配置数据库连接密码
//        mpg.setDataSource(dsc);
//
//        // Step:4：包配置
//        PackageConfig pc = new PackageConfig();
//
//        pc.setParent("com.example");// 配置父包名（需要修改）
//        pc.setModuleName("");// 配置模块名（需要修改）
//        pc.setEntity("entity");// 配置 entity 包名
//        pc.setMapper("mapper");// 配置 mapper 包名
//        pc.setService("service");// 配置 service 包名
//        pc.setController("controller");// 配置 controller 包名
//        mpg.setPackageInfo(pc);
//
//        // Step5：策略配置（数据库表配置）
//        StrategyConfig strategy = new StrategyConfig();
//        strategy.setInclude("user");//指定表名（可以同时操作多个表，使用 , 隔开）（需要修改）
//
//        strategy.setNaming(NamingStrategy.underline_to_camel);// 配置数据表与实体类名之间映射的策略
//        strategy.setColumnNaming(NamingStrategy.underline_to_camel);// 配置数据表的字段与实体类的属性名之间映射的策略
//        strategy.setLogicDeleteFieldName("is_deleted");//配置逻辑删除字段
//        strategy.setEntityBooleanColumnRemoveIsPrefix(true); //去掉布尔值的is_前缀
//        strategy.setEntityLombokModel(true);// 配置 lombok 模式
//        strategy.setRestControllerStyle(true);// 配置 rest 风格的控制器（@RestController）
//        strategy.setControllerMappingHyphenStyle(true);// 配置驼峰转连字符
//        mpg.setStrategy(strategy);
//
//        // Step6：执行代码生成操作
//        mpg.execute();
//    }
//}