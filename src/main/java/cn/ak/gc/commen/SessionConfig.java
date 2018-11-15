package cn.ak.gc.commen;

import cn.ak.gc.commen.session.SessionListener;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;
import org.springframework.session.web.http.SessionEventHttpSessionListenerAdapter;

import javax.servlet.http.HttpSessionListener;
import java.util.ArrayList;
import java.util.List;

@EnableRedisHttpSession
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

    @Bean
    public SessionEventHttpSessionListenerAdapter sessionEventHttpSessionListenerAdapter() {
        List<HttpSessionListener> httpSessionListeners = new ArrayList<>();
        httpSessionListeners.add(new SessionListener());
        return new SessionEventHttpSessionListenerAdapter(httpSessionListeners);
    }
}
