package com.pwk.springboot.config;

import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.autoconfigure.data.elasticsearch.ElasticsearchAutoConfiguration;
import org.springframework.context.annotation.Configuration;

@Configuration
@AutoConfigureAfter(ElasticsearchAutoConfiguration.class)
public class ElasticSearchConfig {

}
