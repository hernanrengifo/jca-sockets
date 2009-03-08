package com.googlecode.jcasockets;


public class ExecutionStatistics {
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append( "Total messages=" + messagesReceived );
		return sb.toString();
	}
	private int minimumMessageSize = Integer.MAX_VALUE;
	private int maximumMessageSize = Integer.MIN_VALUE;;  
	private long bytesReceived;
	private long bytesSent;
	private int messagesSent;
	private int messagesReceived;

	public void recordSend( String send ){
		int bytes = send.length() * 2;
		if( bytes < minimumMessageSize){
			minimumMessageSize = bytes;
		}
		if( bytes > maximumMessageSize){
			maximumMessageSize = bytes;
		}
		bytesSent += bytes;
		messagesSent++;
	}
	public void recordReceive( String receive ){
		bytesReceived += receive.length() * 2;
		messagesReceived++;
	}
	public int getMinimumMessageSize() {
		return minimumMessageSize;
	}
	public int getMaximumMessageSize() {
		return maximumMessageSize;
	}
	public long getBytesReceived() {
		return bytesReceived;
	}
	public long getBytesSent() {
		return bytesSent;
	}
	public int getMessagesSent() {
		return messagesSent;
	}
	public int getMessagesReceived() {
		return messagesReceived;
	}
	public void combine(ExecutionStatistics that) {
		this.minimumMessageSize = Math.min(this.minimumMessageSize, that.minimumMessageSize);
		this.maximumMessageSize = Math.max(this.maximumMessageSize, that.maximumMessageSize);
		this.bytesReceived += that.bytesReceived;
		this.bytesSent += that.bytesSent;
		this.messagesSent += that.messagesSent;
		this.messagesReceived += that.messagesReceived;
	}
}