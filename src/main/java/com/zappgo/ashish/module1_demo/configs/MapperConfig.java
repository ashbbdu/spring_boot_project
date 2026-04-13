package com.zappgo.ashish.module1_demo.configs;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;

public class MapperConfig {
    @Bean
    public ModelMapper getModelMapper () {
        return new ModelMapper();
    }
}
