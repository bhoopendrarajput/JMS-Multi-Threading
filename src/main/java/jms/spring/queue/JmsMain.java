package jms.spring.queue;

import javax.jms.Message;
import javax.jms.Queue;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Main class for load Spring-AMQ-JMS Application and send {@link Message} to
 * {@link Queue}
 * 
 * @author shyam.pareek
 * @version 29/10/2013
 */
public class JmsMain {

	/**
	 * Main method, execution entry point. Load {@link ApplicationContext} and
	 * send two {@link Message} in {@link Queue}
	 * 
	 * @param args
	 *            command line parameter
	 */
	public static void main(String s[]) {

		ApplicationContext app = new ClassPathXmlApplicationContext(
				"jms-spring-queue.xml");
		MessageSender messageSender=(MessageSender)app.getBean("messageSender");
		QueueReceiver1 queueReceiver1=(QueueReceiver1)app.getBean("messageReceiver1");
		QueueReceiver2 queueReceiver2=(QueueReceiver2)app.getBean("messageReceiver2");
		MyMessage myMessage1 = new MyMessage("Hi...1");
		MyMessage myMessage2 = new MyMessage("Hi...2");
		messageSender.send(myMessage1);
		messageSender.send(myMessage2);
		
		/**
		 * Wait here to see message after queue receives message 
		 * its not sure because we pass millis by assuming.
		 */
		try {
			Thread.sleep(4000);
			System.out.println("1. QueueReceiver1 recevied : " +
					queueReceiver1.getMessages().size());
			System.out.println("2. QueueReceiver2 recevied : " +
					queueReceiver2.getMessages().size());
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}
}
