package pubsub;

import pubsub.publisher.Publisher;
import pubsub.publisher.PublisherImpl;
import pubsub.service.PubSubService;
import pubsub.subscriber.Subscriber;
import pubsub.subscriber.SubscriberImpl;

public class DriverClass {
	public static void main(String[] args) {
		// declare the common payload syntax
    	String POST = "as:announce";
		String ASK = "as:question";
		String OFFER = "as:offer";
		String REJECT = "as:reject";
	    String ACCEPT = "as:accept";
		
				
		
		//Instantiate publishers, subscribers and PubSubService 
		Publisher room1_Publisher = new PublisherImpl();
		Publisher room2_Publisher = new PublisherImpl();
		
		Subscriber room1_Subscriber = new SubscriberImpl();
		Subscriber room2_Subscriber = new SubscriberImpl();
		
		PubSubService pubSubService = new PubSubService(); // server instance is added here
		
		//Declare Messages and Publish Messages to PubSubService
		Message room1Msg = new Message("room1", ASK,"MAS activity put here");
		System.out.println("ROOM 1 Activity " + room1Msg.getactivity()); //print the activity of agents
		
		
		room1_Publisher.publish(room1Msg, pubSubService);
	
		
		Message room2Msg = new Message("room2", REJECT, "MAS Activity put here");
		
		
		room2_Publisher.publish(room2Msg, pubSubService);
		
		//Declare Subscribers 
		room1_Subscriber.addSubscriber("room1",pubSubService);		//room1 subscriber only subscribes to room1 topics
		room2_Subscriber.addSubscriber("room2",pubSubService);   //room2 subscriber only subscribes to room2 topics
		
		//Trying unSubscribing a subscriber
		//pythonSubscriber.unSubscribe("room1", pubSubService);
		
		//Broadcast message to all subscribers. After broadcast, messageQueue will be empty in PubSubService
		pubSubService.broadcast();
		
		//Print messages of each subscriber to see which messages they got
		System.out.println("Messages of room1_Subscriber are: ");
		room1_Subscriber.printMessages();
		
		System.out.println("\nMessages of room2_Subscriber are: ");
		room2_Subscriber.printMessages();
		
		
	}
}