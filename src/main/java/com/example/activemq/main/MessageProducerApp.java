package com.example.activemq.main;

import com.example.activemq.ActivemqApplication;
import com.example.activemq.service.MessageSender;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

public class MessageProducerApp {

  public static void main(String[] args) {
    AbstractApplicationContext context = new AnnotationConfigApplicationContext(
        ActivemqApplication.class);
    MessageSender bean = context.getBean(MessageSender.class);
    bean.sendMessage("Hi, Zhakhongir, How are you?");
    System.out.println("Message has been sent successfully...");
    context.close();
  }

}