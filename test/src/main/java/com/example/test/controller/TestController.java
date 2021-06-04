package com.example.test.controller;

import com.example.test.model.ProdClass;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.redis.connection.DataType;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.*;
import java.util.concurrent.TimeUnit;

@RequestMapping("test")
@RestController
public class TestController {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private StringRedisTemplate redisTemplate;
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
       //String[] array =  new String[prodClassList.size()];
        ProdClass[] array =  new ProdClass[prodClassList.size()];
        redisTemplate.opsForSet().add("prodClassList", prodClassList.toString());
        redisTemplate.expire("prodClassList",60, TimeUnit.SECONDS);
        return prodClassList;
    }

    @GetMapping("testString")
    public Object testString() throws ParseException {
        //key exists?
            //插入key
//         redisTemplate.opsForValue().set("testString","testString",1L); testString
//        redisTemplate.opsForValue().set("testString","testString"); //testString
        //删除
//         redisTemplate.delete("testString");
        //插入key并设置过期时长
//        redisTemplate.opsForValue().set("testString","testString", Duration.ofSeconds(60));
//        redisTemplate.opsForValue().set("testString1","testString1", 120,TimeUnit.SECONDS);
        //获取key的值
//        String testString = redisTemplate.opsForValue().get("testString");
        //key是否存在
//        boolean flag = redisTemplate.hasKey("testString");
//        String testString1 = redisTemplate.opsForValue().get("testString1");
//        boolean flag1 = redisTemplate.hasKey("testString1");
//        Map<Object,Object> map = new HashMap<>(3);
//        map.put(testString,flag);
//        map.put(testString1,flag1);
        //删除多个key
//        Collection<String> keys = Arrays.asList(new String[]{"testString1","testString"});
//        map.put("keys",redisTemplate.delete(keys));//返回删除数量
        Map<Object,Object> map = new HashMap<>(3);
//        redisTemplate.opsForValue().set("testString","1111111", Duration.ofSeconds(60));
        //获取key的byte数组
//        byte[]byteArray =  redisTemplate.dump("testString");
        redisTemplate.opsForValue().set("testString","1234567890",Duration.ofSeconds(120));
//        redisTemplate.expireAt("testString",new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse("2021-06-04 16:05:00"));
        //获取和partten匹配的值,*在后面则表示后面匹配
//        Set<String> set = redisTemplate.keys("test*");
//        map.put("set",set);
        //重命名key
        //redisTemplate.rename("test","test1");//io.lettuce.core.RedisCommandExecutionException: ERR no such key
        redisTemplate.rename("testString","testString1");
        //redisTemplate.renameIfAbsent("test","test1");io.lettuce.core.RedisCommandExecutionException: ERR no such key
        Set<String> set = redisTemplate.keys("test*");
        Set<String> set1 = redisTemplate.keys("t*");
        Set<String> set2 = redisTemplate.keys("1*");
        Set<String> set3 = redisTemplate.keys("*1");
        map.put("set",set);
        map.put("set1",set1);
        map.put("set2",set2);
        map.put("set3",set3);
        //key的类型
       // DataType dataType  = redisTemplate.type("testString1");
        //随机获取key
       // String key = redisTemplate.randomKey();
        //key的剩余过期时长
        //Long time = redisTemplate.getExpire("testString1");
       // Long time = redisTemplate.getExpire("testString1",TimeUnit.SECONDS);
        //持久化key
//        boolean flag = redisTemplate.persist("testString1");
        //将当前数据库的key移动到指定redis中数据库当中
//        flag = redisTemplate.move("testString1",2);
//        return redisTemplate.opsForValue().get("testString1");
        //索引从0开始,并且包含开始和结尾
        //String test =  redisTemplate.opsForValue().get("testString1",0,2);//123
        //将key设置为新value，并且返回key的新value
//        String result = redisTemplate.opsForValue().getAndSet("testString1", "abcdefghijk");
//        redisTemplate.opsForValue().set("testString2","-9ajipfja",Duration.ofSeconds(120));
//        redisTemplate.opsForValue().set("testString3","zhangsan",Duration.ofSeconds(120));
//        redisTemplate.opsForValue().set("testString4","list",Duration.ofSeconds(120));
        //根据多个key获取这些key的值
//        Collection<String> keys = Arrays.asList(new String[]{"testString1","testString2"});
//        List<String> list = redisTemplate.opsForValue().multiGet(keys);
        //在key的value后面追加字符串.返回总长度
        //Integer a = redisTemplate.opsForValue().append("testString1", "value");
       // Double a =  redisTemplate.opsForValue().increment("testString1",2.0);
       // String value = redisTemplate.opsForValue().get("testString1");//1234567890qqq,io.lettuce.core.RedisCommandExecutionException: ERR value is not an integer or out of range
      //  map.put(a,value);
        //map插入集合，map中的一对key-value在redis中对应一对key-value
//        Map valueMap = new HashMap();
//        valueMap.put("valueMap1","map1");
//        valueMap.put("valueMap2","map2");
//        valueMap.put("valueMap3","map3");
////        redisTemplate.opsForValue().multiSetIfAbsent(valueMap);
//        redisTemplate.opsForValue().multiSet(valueMap);
//        Collection<String> keys = Arrays.asList(new String[]{"valueMap1","valueMap1","valueMap3"});
//
//        List<String> values =  redisTemplate.opsForValue().multiGet(keys);
        //获取字符串的长度
      //  Long a = redisTemplate.opsForValue().size("valueMap1");
        //从指定索引开始替换值，索引从0开始，若超出则拼接，若超出部分大于总长度则空格替代
//        redisTemplate.opsForValue().set("testString1", "value", 0);value67890
        //redisTemplate.opsForValue().set("testString1", "value", 1);//1value7890
       // redisTemplate.opsForValue().set("testString1", "value", 9);//123456789value
       // redisTemplate.opsForValue().set("testString1", "value", 11);//1234567890 value
       // String test =  redisTemplate.opsForValue().get("testString1");
        redisTemplate.opsForValue().set("k1","v1",60,TimeUnit.SECONDS);
        boolean test = redisTemplate.opsForValue().setIfAbsent("k1", "testString1");
        String test1 =  redisTemplate.opsForValue().get("k1");
        System.out.println(test);
        return test1;
    }
}
