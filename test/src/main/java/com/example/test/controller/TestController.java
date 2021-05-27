package com.example.test.controller;

import com.example.test.model.ProdClass;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RequestMapping("test")
@RestController
public class TestController {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private RedisTemplate redisTemplate;
//    @GetMapping
//    public String test(){
//        return "hello world";
//    }

    @GetMapping
   // @Cacheable(value = "prodCLass",key = "#root.methodName")
  // @Cacheable(key = "#root.methodName")
    public List<ProdClass> testCache(){
        String sql = "SELECT * FROM PROD_CLASS WHERE PROD_CLASS_LEVEL = 1";
        RowMapper<ProdClass> rowMapper = new BeanPropertyRowMapper<ProdClass>(ProdClass.class);
        List<ProdClass> prodClassList =  jdbcTemplate.query(sql,rowMapper);
        redisTemplate.opsForSet().add("prodClassList",prodClassList);
        return prodClassList;
    }
}
