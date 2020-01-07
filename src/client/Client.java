package client;

import java.net.DatagramSocket;
import java.net.InetAddress;

public class Client {
	
	private DatagramSocket socket;
	private InetAddress address;
	private int port;

	public Client(String address, int port) {
		try {
			this.address = InetAddress.getByName(address);
			this.port = port;
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

}
