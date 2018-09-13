package com.tlw.spring.stomp.demo;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

/**
 * Created by 唐力伟 on 2017/5/12 22:06.
 */
@Configuration
@EnableWebSocketMessageBroker
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer {

    @Override
    public void registerStompEndpoints(StompEndpointRegistry stompEndpointRegistry) {
        //endpoint的名称可以换，而且多种消息可以通过一个endpoint来连接，为什么需要多个EndPoint有待于研究
        stompEndpointRegistry.addEndpoint("/endpoint").withSockJS();
    }

    public void configureMessageBroker(MessageBrokerRegistry registry){
        //点对点消息，必须名为/queue
        //广播消息，必须名为/topic
        registry.enableSimpleBroker("/queue", "/topic");
    }
}
