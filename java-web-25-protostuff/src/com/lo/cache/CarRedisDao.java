package com.lo.cache;

import com.dyuproject.protostuff.LinkedBuffer;
import com.dyuproject.protostuff.ProtostuffIOUtil;
import com.dyuproject.protostuff.runtime.RuntimeSchema;
import com.lo.entity.Car;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

public class CarRedisDao {

	//连接池
	private JedisPool jedisPool;
	
	//构造
	private CarRedisDao(String id,int ip){
		jedisPool=new JedisPool(id,ip);
	}
	
	RuntimeSchema<Car> schema = RuntimeSchema.createFrom(Car.class);
	
	//保存方法
	public String xuliehua(Car car){
		Jedis jedis = new Jedis();//获取jedis数据库链接
		String key = "car"+car.getCid();//设置储存的key
		byte[] bytes = ProtostuffIOUtil.toByteArray(car, schema, //设置要储存的value
				LinkedBuffer.allocate(LinkedBuffer.DEFAULT_BUFFER_SIZE));
		int timeout= 60 *60;//设置最大连接时间
		String resule = jedis.setex(key.getBytes(), timeout, bytes);//吧key和value存到redis里
		jedis.close();//关闭
		return resule;//返回 ok  或者是 no
		
	}
}
