package com.example.activemq.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

@Service
public class MessageSenderService implements MessageSender {

  private JmsTemplate jmsTemplate;

  @Autowired
  public void setMessageSenderServiceAutowired(JmsTemplate jmsTemplate) {
    this.jmsTemplate = jmsTemplate;
  }

  @Override
  public void sendMessage(final String message) {
    jmsTemplate.send(session -> session.createObjectMessage(message));
  }

}