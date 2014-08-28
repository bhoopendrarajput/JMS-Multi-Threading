package uk.co.jemos.experiments;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jms.core.JmsTemplate;

public class JmsTest {

    /** The application logger */
    private static final org.apache.log4j.Logger LOG = org.apache.log4j.Logger
            .getLogger(JmsTest.class);

    /**
     * @param args
     */
    public static void main(String[] args) {

        ApplicationContext ctx = new ClassPathXmlApplicationContext(
                "classpath:jemosJms-appContextImpl.xml");

        JmsTemplate jmsTemplate = ctx.getBean(JmsTemplate.class);

        jmsTemplate.send("jemos.tests", new HelloWorldMessageCreator());

        LOG.info("Message sent successfully");

    }
   
}