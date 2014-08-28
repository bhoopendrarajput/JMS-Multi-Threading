package jms.spring.topic;

import javax.jms.ConnectionFactory;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.ObjectMessage;
import javax.jms.Session;
import javax.jms.Topic;

import org.springframework.beans.factory.annotation.Required;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;

/**
 * This is for {@link TopicPublisher} witch publish {@link Topic} by
 * {@link #publish(MyMessage)}
 * 
 * @author shyam.pareek
 * @version 29/10/2013
 */
public class TopicPublisher {

	private JmsTemplate jmsTemplate;
	private Topic topic;

	/**
	 * publish {@link Message} for {@link Topic}
	 * 
	 * @param myMessage
	 *            {@link Message} format that you want to publish.
	 */
	public void publish(final MyMessage myMessage) {
		this.jmsTemplate.send(this.topic, new MessageCreator() {
			public Message createMessage(Session session) throws JMSException {
				ObjectMessage om = session.createObjectMessage();
				om.setObject(myMessage);
				System.out.println("Your message is published for Topic.");
				return om;
			}
		});
	}

	/**
	 * Setter for {@link Topic} mentioned it {@link Required} for publish
	 * {@link Topic}
	 */
	@Required
	public void setTopic(Topic topic) {
		this.topic = topic;
	}

	/**
	 * Setter for {@link JmsTemplate} mentioned it {@link Required} for
	 * {@link ConnectionFactory}
	 */
	@Required
	public void setJmsTemplate(JmsTemplate jmsTemplate) {
		this.jmsTemplate = jmsTemplate;
	}
}