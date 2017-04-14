package com.scoot.murphy;

import com.scoot.murphy.mvc.bussiness.conf.DefaultConf;
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
    private DefaultConf defaultConf;

    @Test
    public void tstRead() {
        try {
            System.out.println("----------------------------------------------------------------------");

            System.out.println(defaultConf.getMark());

        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
