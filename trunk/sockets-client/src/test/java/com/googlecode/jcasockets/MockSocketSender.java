package com.googlecode.jcasockets;


public class MockSocketSender implements SocketSenderFactory, SocketSender {

	@Override
	public String send(String send) {
		return send;
	}

	@Override
	public SocketSender createSocketSender(String ipAddress, Integer port) {
		return new MockSocketSender();
	}
}