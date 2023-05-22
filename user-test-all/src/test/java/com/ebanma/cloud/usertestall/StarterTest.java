package com.ebanma.cloud.usertestall;

import com.ebanma.cloud.config.EnableRegisterServer;
import com.ebanma.cloud.config.SimpleBean;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author 黄贵龙
 * @version $ Id: StarterTest, v 0.1 2023/04/13 22:20 86139 Exp $
 */
@SpringBootTest
@EnableRegisterServer
public class StarterTest {
    // 测试自定义starter
    @Autowired
    private SimpleBean simpleBean;

    @Test
    public void myStarterTest(){
        System.out.println(simpleBean);
    }

}
