package edu.vanderbilt.kharesp.clients;

import org.zeromq.ZMQ;
import org.zeromq.ZMQ.Context;
import org.zeromq.ZMQ.Socket;

public class Publisher {
	public static void main(String args[]){
		Context context= ZMQ.context(1);
		Socket publisher= context.socket(ZMQ.PUB);
		
		
		
	}
}
