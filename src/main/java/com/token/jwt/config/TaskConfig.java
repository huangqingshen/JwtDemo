package com.token.jwt.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;

/**
 *
 * @author haort
 * @date 17/11/16
 */
@Configuration
public class TaskConfig {

    @Bean(name="taskExecutor")
    public Executor getAsyncExecutor(){
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(10);
        executor.setMaxPoolSize(15);
        executor.setQueueCapacity(500);
        executor.setThreadNamePrefix("AsyncTask-");
        executor.initialize();
        return executor;
    }

}
