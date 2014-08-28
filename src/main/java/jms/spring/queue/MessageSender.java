package jms.spring.queue;

import javax.jms.ConnectionFactory;
import javax.jms.Message;
import javax.jms.Queue;

import org.springframework.beans.factory.annotation.Required;
import org.springframework.jms.core.JmsTemplate;

/**
 * {@link MessageSender} class sends {@link Message} on {@link Queue}
 * 
 * @author shyam.pareek
 * @version 29/10/2013
 */
public class MessageSender {

	private JmsTemplate jmsTemplate;

	/**
	 * Setter for {@link JmsTemplate} mentioned it {@link Required} for
	 * {@link ConnectionFactory}
	 */
	@Required
	public void setJmsTemplate(JmsTemplate jmsTemplate) {
		this.jmsTemplate = jmsTemplate;
	}

	/**
	 * Simple method for sending {@link Message} sends {@link Message} to
	 * {@link JmsTemplate} on registered {@link Queue}
	 * 
	 * @param message
	 *            {@link Message} format that you want to send.
	 */
	public void send(MyMessage myMessage) {
		try {

			jmsTemplate.convertAndSend(myMessage);
			System.out.println("Message send :"+myMessage);

		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}