package com.if1007.kscore.config;

import com.if1007.kscore.store.Storage;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class StorageConfig {
    @Bean
    public Storage initStorage(){
        return new Storage();
    }
}
