package com.scoot.murphy;

import com.alibaba.fastjson.JSON;
import com.scoot.murphy.mvc.bussiness.conf.CommonConf;
import com.scoot.murphy.mvc.bussiness.conf.DbConf;
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
    private CommonConf commonConf;
    @Autowired
    private DbConf dbConf;

    @Test
    public void tstRead() {
        try {
            System.out.println("----------------------------------------------------------------------");

            System.out.println(commonConf.getTest1());
            System.out.println(commonConf.getTest2());
            System.out.println(commonConf.getTest3());

            System.out.println(dbConf.getDb1());
            System.out.println(dbConf.getDb2());
            System.out.println(dbConf.getDb3());

        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
