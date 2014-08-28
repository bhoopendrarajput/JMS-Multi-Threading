package jms.spring.topic;

import javax.jms.Message;
import javax.jms.Topic;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Main class for load Spring-AMQ-JMS Application. {@link Topic} publish
 * example
 * 
 * @author shyam.pareek
 * @version 29/10/2013
 */
public class JmsMain {
	/**
	 * Main method, execution entry point. Load {@link ApplicationContext} and
	 * publish two {@link Message}
	 * 
	 * @param args
	 *            command line parameter
	 */
	public static void main(String args[]) {
		ApplicationContext app = new ClassPathXmlApplicationContext(
				"jms-spring-topic.xml");
		System.out.println("ApplicationContext loaded..........");
		TopicPublisher topicPublisher = (TopicPublisher) app
				.getBean("topicPublisher");
		MyMessage myMessage1 = new MyMessage("Hi...1");
		//MyMessage myMessage2 = new MyMessage("Hi...2");
		topicPublisher.publish(myMessage1);
		//topicPublisher.publish(myMessage2);
		
	}
}
