package org.jaden.jpa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

//这里只是简单地使用，详细配置和封装可参见：https://blog.csdn.net/javaloveiphone/article/details/52355180
@Controller
public class JedisController {

    @Autowired
    private JedisPool jedisPool;//注入JedisPool

    @RequestMapping(value = "/demo_set",method = RequestMethod.GET)
    @ResponseBody
    public String demo_set(){
        //获取ShardedJedis对象
        Jedis jedis = jedisPool.getResource();  //// TODO: 2018/5/13 这里redis密码设置不成功！
        //存入键值对
        jedis.set("key2","hello jedis! My name is JadenOliver.");
        //回收ShardedJedis实例
        jedis.close();

        return "set";
    }

    @RequestMapping(value = "/demo_get",method = RequestMethod.GET)
    @ResponseBody
    public String demo_get(){
        Jedis jedis = jedisPool.getResource();
        //根据键值获得数据
        String result = jedis.get("key2");
        jedis.close();

        return result;
    }
}
