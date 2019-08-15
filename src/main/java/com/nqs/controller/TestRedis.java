package com.nqs.controller;

import redis.clients.jedis.Jedis;

public class TestRedis {
    public static void main(String[] args) {
        Jedis jedis = new Jedis("127.0.0.1",6379);
        System.out.println(jedis.set("k1","聂启松"));
        System.out.println(jedis.get("k1"));
//        System.out.println(jedis);

    }
}
