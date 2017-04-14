package com.scoot.murphy.mvc.bussiness.services.impl;

import com.alibaba.dubbo.config.annotation.Reference;
import com.scoot.murphy.api.demo.inter.DemoService;
import com.scoot.murphy.mvc.bussiness.services.WebDemoService;
import org.springframework.stereotype.Service;

/**
 * Created by TDUser on 2017/4/6.
 */
@Service
public class WebDemoServiceImpl implements WebDemoService{

    @Reference
    private DemoService demoService;

    @Override
    public String getServiceVersion() {
        return demoService.getDemoVersion();
    }
}
