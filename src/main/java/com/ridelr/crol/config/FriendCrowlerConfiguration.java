package com.ridelr.crol.config;

import com.ridelr.crol.queue.friends.FriendDao;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

/**
 * Created by rfk on 30.10.2017.
 */
@Configuration
public class FriendCrowlerConfiguration {

    @Bean
    public FriendDao friendDao(DataSource dataSource) {
        return new FriendDao(dataSource);
    }

}
