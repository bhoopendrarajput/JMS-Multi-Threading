package uk.co.jemos.experiments;

import java.io.Serializable;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;

import org.springframework.jms.core.MessageCreator;

public class HelloWorldMessageCreator  implements Serializable,MessageCreator{

	public Message createMessage(Session session) throws JMSException {
		// TODO Auto-generated method stub
		return null;
	}
	
}
