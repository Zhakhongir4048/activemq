package com.example.activemq.config;

import java.util.List;
import javax.jms.ConnectionFactory;
import org.apache.activemq.ActiveMQConnectionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.support.converter.MessageConverter;
import org.springframework.jms.support.converter.SimpleMessageConverter;

@Configuration
public class MessagingConfiguration {

  private static final String DEFAULT_BROKER_URL = "tcp://localhost:61616";
  private static final String MESSAGE_QUEUE = "message_queue";

  @Bean
  public ConnectionFactory connectionFactory() {
    ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory();
    connectionFactory.setBrokerURL(DEFAULT_BROKER_URL);
    connectionFactory.setTrustedPackages(List.of("com.example"));
    return connectionFactory;
  }

  @Bean
  public JmsTemplate jmsTemplate() {
    JmsTemplate jmsTemplate = new JmsTemplate();
    jmsTemplate.setConnectionFactory(connectionFactory());
    jmsTemplate.setDefaultDestinationName(MESSAGE_QUEUE);
    return jmsTemplate;
  }

  @Bean
  public MessageConverter converter() {
    return new SimpleMessageConverter();
  }

}