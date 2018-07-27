package com.ridelr.crol.config;

import com.ridelr.crol.scheduler.StatisticLogger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;


@Configuration
@EnableScheduling
public class ScheduleConfiguration {

    @Bean
    public StatisticLogger statisticLogger() {
        return new StatisticLogger();
    }
}
