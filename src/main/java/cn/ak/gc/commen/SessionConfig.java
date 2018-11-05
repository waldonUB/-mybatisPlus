package cn.ak.gc.commen;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;

@EnableRedisHttpSession(maxInactiveIntervalInSeconds = 60)
public class SessionConfig {
    @Value("${spring.redis.host}")
    String hostName;
    @Value("${spring.redis.port}")
    int port;
    @Bean
    public JedisConnectionFactory connectionFactory() {
        RedisStandaloneConfiguration configuration = new RedisStandaloneConfiguration();
        configuration.setHostName(hostName);
        configuration.setPort(port);
        return new JedisConnectionFactory(configuration);
    }
}
