package com.example.jobsearch.service.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

@Service
public class RedisServiceImpl implements RedisService{
    private RedisTemplate<String, Object> redisTemplate;
    private static final String SEARCH_KEY_TEMPLATE = "&q=%s&gl=%s&start=%s";

    @Autowired
    public RedisServiceImpl(RedisTemplate<String, Object> redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    @Override
    public void setValue(String query, String country, String start, String searchResult) {
        String key = String.format(SEARCH_KEY_TEMPLATE, query, country, start);
        redisTemplate.opsForValue().set(key, searchResult);
    }

    @Override
    public String getValue(String query, String country, String start) {
        String key = String.format(SEARCH_KEY_TEMPLATE, query, country, start);
        return (String) redisTemplate.opsForValue().get(key);
    }
}
