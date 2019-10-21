package br.com.ifrs.SGRU.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SgruConfig {

    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }

}
