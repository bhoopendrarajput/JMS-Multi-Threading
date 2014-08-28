package jms.spring.queue;

import java.io.Serializable;

/**
 * Message for sending/publishing in a Queue/Topic.
 * 
 * @author shyam.pareek
 * @version 29/10/2013
 */
public final class MyMessage implements Serializable {

	private static final long serialVersionUID = 1L;
	private final String content;

	public MyMessage(String content) {
		this.content = content;
	}

	/**
	 * @return content of {@link MyMessage}.
	 */
	public String getContent() {
		return content;
	}

	/**
	 * Override {@link Object#toString()} for generating custom message.
	 */
	@Override
	public String toString() {
		return "Message [content=" + content + "]";
	}
}