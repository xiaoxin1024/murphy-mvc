package com.scoot.murphy;

import com.alibaba.fastjson.JSON;
import com.scoot.murphy.mvc.bussiness.services.WebDemoService;
import com.scoot.murphy.shell.MurphyApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = MurphyApplication.class)
public class TestDubbo {

    @Autowired
    private WebDemoService webDemoService;

    @Test
    public void tstRead() {
        try {
            System.out.println(" >>>>> " + JSON.toJSONString(webDemoService.getServiceVersion()));
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
