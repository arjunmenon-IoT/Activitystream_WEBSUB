package pubsub;

public class Message {
	private String topic;
	private String payload;
	private String activity;
	
	public Message(){}	
	public Message(String topic, String payload,String activity) {
		this.topic = topic;
		this.payload = payload;
		this.activity = activity;
	}
	public String getTopic() {
		return topic;
	}
	public void setTopic(String topic) {
		this.topic = topic;
	}
	public String getPayload() {
		return payload;
	}
	public void setPayload(String payload) {
		this.payload = payload;
	}
	public String getactivity() {
		return activity;
	}
	public void setactivity(String activity) {
		this.activity = activity;
	}
}
