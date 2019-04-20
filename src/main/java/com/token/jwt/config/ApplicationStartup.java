package com.token.jwt.config;

import com.token.jwt.service.IAuthService;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;

/**
 * @author haort
 * @date 2018/3/15
 */
public class ApplicationStartup implements ApplicationListener<ContextRefreshedEvent> {
    @Override
    public void onApplicationEvent(ContextRefreshedEvent e) {
        IAuthService authService = e.getApplicationContext().getBean(IAuthService.class);
        authService.init();
    }
}
