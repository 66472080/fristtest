package com.lo.cache;

import com.dyuproject.protostuff.LinkedBuffer;
import com.dyuproject.protostuff.ProtostuffIOUtil;
import com.dyuproject.protostuff.runtime.RuntimeSchema;
import com.lo.entity.Product;
import com.lo.entity.User;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

public class ProductRedisDao {

	// 连接池
	private final JedisPool jedisPool;

	// schema对象 RuntimeSchema是基于class拿到这个class的属性,创建schema对象
	private RuntimeSchema<User> schema = RuntimeSchema.createFrom(User.class);

	// 实体类自身的有参构造(传入 IP 和 端口号 )
	public ProductRedisDao(String ip, int port) {
		jedisPool = new JedisPool(ip, port);
	}

	public String saveProduct(User user) {
		try {
			String key = "product:" + user.getId();
			// redis操作
			Jedis jedis = jedisPool.getResource();// 分配一个资源
			// 序列化 object<Product> → byte[]
			// 使用ProtostuffIOUtil.toByteArray() 方法进行序列化
			// (传进来的对象数据,schema模板,缓冲区)内有三个参数
			byte[] bytes = ProtostuffIOUtil.toByteArray(user, schema,
					LinkedBuffer.allocate(LinkedBuffer.DEFAULT_BUFFER_SIZE));
			// 如果传的对象太大的话 我们设置一个超时时间
			int timeout = 60 * 60;// 设置为1小时

			String result = jedis.setex(key.getBytes(), timeout, bytes);
			jedis.close();
			return result;
		} catch (Exception e) {

		}
		return null;
	}

	public User getproduct(int id) {
		// redis操作

		try {
			String key = "product:" + id;
			Jedis jedis = jedisPool.getResource();
			byte[] bytes = jedis.get(key.getBytes());
			// 反序列化 由 byte[]数组 → Object<product>对象
			if (bytes != null) {
				User user = schema.newMessage();// 新对象
				ProtostuffIOUtil.mergeFrom(bytes, user, schema);
				return user;
				
			}
			jedis.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
