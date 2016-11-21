package org.lindl.utils;

import java.util.ResourceBundle;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

public final class JedisUtil {
	// private static final Logger LOGGER = Logger.getLogger(JedisUtil.class);
	private static int DEFAULT_DB_INDEX = 0;

	private static JedisPool jedisPool = null;

	private JedisUtil() {
		// private constructor
	}

	private static void initialPool() {
		try {
			ResourceBundle bundle = ResourceBundle.getBundle("redis");
			if (bundle == null) {
				throw new IllegalArgumentException(
						"[redis.properties] is not found!");
			}
			// 创建jedis池配置实例
			JedisPoolConfig config = new JedisPoolConfig();
			// 设置池配置项值
			String address = bundle.getString("redis.ip");
			int port = Integer.valueOf(bundle.getString("redis.port"));
			// LOGGER.info("Redis server info: " + address + ":" + port);

			String strDbIndex = bundle.getString("redis.db_index");
			if (strDbIndex != null) {
				DEFAULT_DB_INDEX = Integer.valueOf(strDbIndex);
			}

			String strMaxActive = bundle.getString("redis.pool.maxActive");
			if (strMaxActive != null) {
				config.setMaxActive(Integer.valueOf(strMaxActive));
			}

			String strMaxIdle = bundle.getString("redis.pool.maxIdle");
			if (strMaxIdle != null) {
				config.setMaxIdle(Integer.valueOf(strMaxIdle));
			}

			String strMaxWait = bundle.getString("redis.pool.maxWait");
			if (strMaxWait != null) {
				config.setMaxWait(Long.valueOf(strMaxWait));
			}

			String strTestOnBorrow = bundle
					.getString("redis.pool.testOnBorrow");
			if (strTestOnBorrow != null) {
				config.setTestOnBorrow(Boolean.valueOf(strTestOnBorrow));
			}

			String strTestOnReturn = bundle
					.getString("redis.pool.testOnReturn");
			if (strTestOnReturn != null) {
				config.setTestOnReturn(Boolean.valueOf(strTestOnReturn));
			}

			String strTimeout = bundle.getString("redis.pool.timeout");
			int timeout = 2000;// 默认2000
			if (strTimeout != null) {
				timeout = Integer.valueOf(strTimeout);
			}
			// 根据配置实例化jedis池
			jedisPool = new JedisPool(config, address, port, timeout);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {

		}

	}

	public synchronized static Jedis getJedisInstance() {
		if (jedisPool == null) {
			initialPool();
		}
		try {
			if (jedisPool != null) {
				Jedis resource = jedisPool.getResource();
				resource.select(DEFAULT_DB_INDEX);
				return resource;
			} else {
				return null;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public synchronized static Jedis getJedisInstance(final int dbIndex) {
		if (jedisPool == null) {
			initialPool();
		}
		try {
			if (jedisPool != null) {
				Jedis resource = jedisPool.getResource();
				resource.select(dbIndex);
				return resource;
			} else {
				return null;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public static void returnResource(final Jedis jedis) {
		if (jedis != null) {
			jedisPool.returnResource(jedis);
		}
	}

}