package com.naka.rabbitmqproducer;

import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.Channel;

public class Send
{
    private final static String QUEUE_NAME = "hello";
    public static void main(String[] argv) throws Exception {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost(System.getenv().getOrDefault("RABBITMQ_HOST", "localhost"));
        factory.setUsername(System.getenv().getOrDefault("RABBITMQ_USERNAME", "guest"));
        factory.setPassword(System.getenv().getOrDefault("RABBITMQ_PASSWORD", "guest"));

        int numOfMessages = Integer.parseInt(System.getenv().getOrDefault("NUM_OF_MESSAGES", "10"));
        try (Connection connection = factory.newConnection();
             Channel channel = connection.createChannel()) {
                channel.queueDeclare(QUEUE_NAME, false, false, false, null);
                for (int n = 1; n<=numOfMessages; n++) {
                    String message = String.format("Message [%d/%d]", n, numOfMessages);
                    channel.basicPublish("", QUEUE_NAME, null, message.getBytes());
                    System.out.println("[x] Sent '" + message + "'");
                }
        }
    }
}
