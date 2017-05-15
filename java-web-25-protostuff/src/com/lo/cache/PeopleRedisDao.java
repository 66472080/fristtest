package com.lo.cache;

import com.dyuproject.protostuff.LinkedBuffer;
import com.dyuproject.protostuff.ProtostuffIOUtil;
import com.dyuproject.protostuff.runtime.RuntimeSchema;
import com.lo.entity.People;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

public class PeopleRedisDao {
	//链接连接池
	private final JedisPool jedisPool;

	//构造  接收id  ip
	public PeopleRedisDao(String id,int ip){
		jedisPool=new JedisPool(id,ip);
	}
	//用schema格式 来排序实体类的class文件的序列
	private RuntimeSchema<People> schema =RuntimeSchema.createFrom(People.class);
	
	public String xulie(People p){
		
		Jedis jedis = jedisPool.getResource();
		String key="People"+p.getPid();
		byte[] bytes=ProtostuffIOUtil.toByteArray(p,schema,
				LinkedBuffer.allocate(LinkedBuffer.DEFAULT_BUFFER_SIZE));
		 int timeout=60*60;
		 String result =jedis.setex(key.getBytes(), timeout, bytes);
		return result;
		
	}
	
}
