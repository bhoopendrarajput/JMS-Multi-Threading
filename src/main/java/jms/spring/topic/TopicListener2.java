package jms.spring.topic;

import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.MessageListener;
import javax.jms.ObjectMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;

import service.Controller1;
import service.Service1;

/**
 * This is {@link MessageConsumer} class that consume your {@link Message}. When
 * {@link Message} is received it notify event to {@link MessageListener}
 * {@link #onMessage(Message)}
 * 
 * @author shyam.pareek
 * @version 29/10/2013
 */
public class TopicListener2 implements MessageListener {

	/**
	 * {@link Service1} is nothing just for test {@link Autowired} is injected
	 * using your {@link ApplicationContext}.
	 */
	@Autowired
	Service1 service1;
	/**
	 * {@link Controller1} is nothing just for test {@link Autowired} is
	 * injected using your {@link ApplicationContext}.
	 */
	@Autowired
	Controller1 controller1;

	/**
	 * This for second {@link TopicListener} I am little bit confusing here why
	 * {@link Override} not working. But this method is {@link Override} for
	 * {@link MessageListener} and called when {@link MessageConsumer} receives
	 * any {@link Message}
	 * 
	 */
	// @Override
	public void onMessage(Message message) {
		try {

			if (message instanceof ObjectMessage) {
				ObjectMessage mapMessage = (ObjectMessage) message;
				jms.spring.topic.MyMessage obj = (jms.spring.topic.MyMessage) mapMessage
						.getObject();
				System.out.println("2. TopicListener received your Message "
						+ obj);
				System.out
						.println("Test injected Component and Service service1= "
								+ service1 + ", controller1=  " + controller1);
				// wait here for clarification and judge your message.
				Thread.sleep(3000);
			}
		} catch (Exception e) {
			e.printStackTrace();
			// logger.error(e);
		}
	}
}
