package com.scoot.murphy.mvc.bussiness.conf;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:db.properties")
public class DbConf {
    @Value("${db1}")
    private String db1;

    @Value("${db2}")
    private String db2;

    @Value("${db3}")
    private String db3;

    public String getDb1() {
        return db1;
    }

    public void setDb1(String db1) {
        this.db1 = db1;
    }

    public String getDb2() {
        return db2;
    }

    public void setDb2(String db2) {
        this.db2 = db2;
    }

    public String getDb3() {
        return db3;
    }

    public void setDb3(String db3) {
        this.db3 = db3;
    }
}
