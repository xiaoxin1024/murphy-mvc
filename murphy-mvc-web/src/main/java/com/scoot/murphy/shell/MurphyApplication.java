package com.scoot.murphy.shell;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import java.util.Arrays;

@SpringBootApplication
@ComponentScan(basePackages = {"${murphy.component.package}"})
public class MurphyApplication {

    private static final org.slf4j.Logger LOG = org.slf4j.LoggerFactory.getLogger(MurphyApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(MurphyApplication.class, args);

        LOG.info("Spring boot startup success!");
    }

    /**
     * 在启动时打印出所有可用service
     * @param ctx
     * @return
     */
    @Bean
    public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
        return args -> {

            LOG.debug("Let's inspect the beans provided by Spring Boot:");

            StringBuilder sb = new StringBuilder();

            String[] beanNames = ctx.getBeanDefinitionNames();
            Arrays.sort(beanNames);
            for (String beanName : beanNames) {
                sb.append(beanName).append("\r\n");
            }

            LOG.debug(sb.toString());
        };
    }
}
