package com.jxshen.task.manager.api;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.jxshen.task.manager.service.event.UserContentEvent;

@RunWith(SpringJUnit4ClassRunner.class) 
@SpringBootTest(classes=Application.class)// 指定spring-boot的启动类
public class UserContentEventListenerTest {

    @Autowired
    private ApplicationContext ac;
    
    @Test
    public void doTest() {
        ac.publishEvent(new UserContentEvent("event"));
    }
}
