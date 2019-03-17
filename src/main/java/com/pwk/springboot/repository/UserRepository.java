package com.pwk.springboot.repository;

import com.pwk.springboot.domain.UserElasticSearch;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Component;

@Component
public interface UserRepository extends ElasticsearchRepository<UserElasticSearch,Long> {

}
