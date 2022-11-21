package com.example.utils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.DriverManager;


@Component
public class MySQLConnectUtils {

    @Value("${spring.datasource.url}")
    private String url;
    @Value("${spring.datasource.username}")
    private String username;
    @Value("${spring.datasource.password}")
    private String password;
    @Value("${spring.datasource.driver-class-name}")
    private String driver;


    public void getConnect() {
        try {
            Class driverObject = Class.forName(driver);
            System.out.println("驱动连接结果为：" + driverObject);
            Connection con = DriverManager.getConnection(url, username, password);
            System.out.println("数据库连接成功：" + con);
        } catch (Exception e) {
            System.out.println("数据库连接失败：" + e.getMessage());
        }
    }

}
