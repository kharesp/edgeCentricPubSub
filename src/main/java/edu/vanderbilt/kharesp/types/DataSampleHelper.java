package edu.vanderbilt.kharesp.types;

import com.google.flatbuffers.FlatBufferBuilder;
import edu.vanderbilt.kharesp.types.DataSample;

public class DataSampleHelper {

	/**
	 * Serialize DataSample type using FlatBuffers
	 * @param sampleId DataSample's unique id 
	 * @param regionId DataSample's originating domain/region id
	 * @param runId  Experiment runId
	 * @param priority DataSample's priority 
	 * @param ts   
	 * @param payloadSize size of payload to create in addition to the header(24 Bytes)
	 * @return
	 */
	public static byte[] serialize(int sampleId, int regionId, int runId,int priority, long ts,int payloadSize){
		FlatBufferBuilder builder= new FlatBufferBuilder(64);
		int payloadOffset= DataSample.createPayloadVector(builder, new int[payloadSize]);
		int sample=DataSample.createDataSample(builder, sampleId, regionId, runId, priority, ts, payloadOffset);
		builder.finish(sample);
		return builder.sizedByteArray();
	}
	
	/**
	 * De-serialize byte array into DataSample type using FlatBuffers 
	 * @param data  
	 * @return
	 */
	public static DataSample deserialize(byte[] data){
		java.nio.ByteBuffer buf= java.nio.ByteBuffer.wrap(data);
		return DataSample.getRootAsDataSample(buf);
	}

}
