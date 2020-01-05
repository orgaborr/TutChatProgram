package server;

import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class Server {

	private static DatagramSocket socket;
	private static boolean running;
	
	public static void start(int port) {
		try {
			socket = new DatagramSocket(port);			
			running = true;
			listen();			
			System.out.println("Server started on port " + port);
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	private static void broadcast() {
		
	}
	
	private static void send() {
		
	}
	
	private static void listen() {
		Thread listenThread = new Thread("Chatprogram Listener") {
			
			public void run() {
				try {
					while(running) {
						
						byte[] data = new byte[1024];
						DatagramPacket packet = new DatagramPacket(data, data.length);
						socket.receive(packet);
						
						String message = new String(data);
						message = message.substring(0, message.indexOf("\\e"));
						
						//manage message
						
					}				
				} catch(Exception e) {
					e.printStackTrace();
				}
			}
			
		}; listenThread.start();
	}
	
	public static void stop() {
		
	}
}
