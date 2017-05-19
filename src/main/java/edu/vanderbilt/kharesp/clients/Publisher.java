package edu.vanderbilt.kharesp.clients;

import org.zeromq.ZMQ;
import org.zeromq.ZMQ.Context;
import org.zeromq.ZMQ.Socket;

import edu.vanderbilt.kharesp.types.DataSampleHelper;

public class Publisher {
	public static void main(String args[]) throws InterruptedException{
		Context context= ZMQ.context(1);
		Socket publisher= context.socket(ZMQ.PUB);
		publisher.bind("tcp://*:5556");
		Thread.sleep(1000);
		for(int i=0;i<10;i++){
			publisher.sendMore("alerts");
			publisher.send(DataSampleHelper.serialize(i, 1, 1, 0, 11111, 10),0,0);
			System.out.println("sent msg:"+i);
			Thread.sleep(100);
		}
		publisher.close();
		context.term();
	}
}
