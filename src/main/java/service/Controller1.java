package service;

import javax.jms.MessageListener;
import javax.naming.Context;

import jms.spring.topic.TopicListener1;
import jms.spring.topic.TopicListener2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * This is simple {@link Component} to test, inject component in
 * {@link TopicListener1} and {@link TopicListener2}. I had faced problem with
 * {@link Autowired} in {@link MessageListener} Because of Some {@link Context}
 * issues. But here you don't face any of problem.
 * 
 * @author shyam.pareek
 * @version 29/10/2013
 */
@Component
public class Controller1 {
	
}
