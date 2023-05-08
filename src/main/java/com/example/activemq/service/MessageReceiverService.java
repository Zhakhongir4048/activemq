package com.example.activemq.service;

import javax.jms.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.support.converter.MessageConverter;
import org.springframework.stereotype.Service;

@Service
public class MessageReceiverService implements MessageReceiver {

  private JmsTemplate jmsTemplate;
  private MessageConverter messageConverter;

  @Autowired
  public void setMessageReceiverServiceAutowired(
      JmsTemplate jmsTemplate,
      MessageConverter messageConverter) {
    this.jmsTemplate = jmsTemplate;
    this.messageConverter = messageConverter;
  }

  @Override
  public String receiveMessage() {
    Message message = jmsTemplate.receive();
    if (message == null) {
      throw new IllegalStateException("Null message");
    }
    try {
      return (String) messageConverter.fromMessage(message);
    } catch (Exception e) {
      e.printStackTrace();
    }
    return "";
  }

}