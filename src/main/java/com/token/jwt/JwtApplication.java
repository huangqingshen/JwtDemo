package com.token.jwt;

import com.token.jwt.config.ApplicationStartup;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@EnableScheduling
@EnableCaching
@EnableAsync
@SpringBootApplication
@Controller
@MapperScan(basePackages = "com.token.jwt.mapper")
public class JwtApplication {
	public static void main(String[] args) {
		SpringApplication springApplication = new SpringApplication(JwtApplication.class);
		springApplication.addListeners(new ApplicationStartup());
//        springApplication.addListeners((ApplicationListener<ContextRefreshedEvent>) event -> {
//            new Thread(() -> {
//                log.info("netty server start at port:8084");
//                SyncServer syncServer = event.getApplicationContext().getBean(SyncServer.class);
//                syncServer.start(8084);
//            }).start();
//
//        });
		springApplication.run(args);
	}

	@RequestMapping(path = "/", method = RequestMethod.GET)
	public String index() {
		return "index";
	}

}
