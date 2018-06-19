package com.cryptohash.springreddisexample;

import com.cryptohash.springreddisexample.model.User;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.connection.RedisClusterConfiguration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class SpringReddisExampleApplication {


    @Bean
    public RedisConnectionFactory jedisConnectionFactory()
    {


        /*List<String> nodes = new ArrayList<String>();
        nodes.add("10.113.59.186:6379");
        RedisClusterConfiguration conf = new RedisClusterConfiguration(nodes);
        conf.setMaxRedirects(1000);*/
        return new JedisConnectionFactory();
    }

    @Bean
    RedisTemplate<String,User>redisTemplate(){
        try {
            RedisTemplate<String,User>redisTemplate = new RedisTemplate<String, User>();
            redisTemplate.setConnectionFactory(jedisConnectionFactory());
            return redisTemplate;
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;

    }


    public static void main(String[] args) {

        SpringApplication.run(SpringReddisExampleApplication.class, args);
    }
}
