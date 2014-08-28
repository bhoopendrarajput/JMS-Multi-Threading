package jms.spring.queue;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.Queue;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;

import service.Controller1;
import service.Service1;

/**
 * This is {@link MessageConsumer} class that consume your {@link Message}. When
 * {@link Message} is received call {@link QueueReceiver1}#
 * {@link #receive(MyMessage)}
 * 
 * @author shyam.pareek
 * @version 29/10/2013
 */
public class QueueReceiver1 {

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
	private List<MyMessage> messages = new ArrayList<MyMessage>();

	/**
	 * It receives {@link Message} that Send to {@link Queue} Wait here your
	 * {@link Message}
	 * 
	 * @param myMessage
	 *            {@link Message} format that you send to {@link Queue}
	 */
	public void receive(MyMessage myMessage) {
		try {

			System.out.println("1.QueueReceiver1 your message reveied : "
					+ myMessage);
			System.out.println("service1 : " + service1);
			System.out.println("controller1 : " + controller1);
			messages.add(myMessage);
			Thread.sleep(2000);

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	/**
	 * Returns an unmodifiable view of the specified list. This method allows
	 * modules to provide users with "read-only" access to internal lists.
	 * 
	 * @return List<MyMessage> return list of mess
	 */
	public List<MyMessage> getMessages() {
		return Collections.unmodifiableList(messages);
	}
}
