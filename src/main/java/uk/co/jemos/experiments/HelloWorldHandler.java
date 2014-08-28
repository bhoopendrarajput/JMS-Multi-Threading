package uk.co.jemos.experiments;

public class HelloWorldHandler {

    /** The application logger */
    private static final org.apache.log4j.Logger LOG = org.apache.log4j.Logger
            .getLogger(HelloWorldHandler.class);

    public void handleHelloWorld(String msg) {

        LOG.info("Received message: " + msg);

    }

}