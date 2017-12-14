package com.turing.util;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.EOFException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class StringTranscoder {

	// 序列化对象为String字符串，先对序列化后的结果进行BASE64编码，否则不能直接进行反序列化
	public static byte[] writeObject(Object o) throws Exception {
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		ObjectOutputStream oos = new ObjectOutputStream(bos);
		oos.writeObject(o);
		oos.flush();
		oos.close();
		bos.close();
		// return new BASE64Encoder().encode(bos.toByteArray());
		
		return bos.toByteArray();
	}

	// 反序列化String字符串为对象

	public static Object readObject(String object) throws Exception {
		// ByteArrayInputStream bis = new ByteArrayInputStream(new
		// BASE64Decoder().decodeBuffer(object));
		ByteArrayInputStream bis = new ByteArrayInputStream(object.getBytes("ISO-8859-1"));
		ObjectInputStream ois = new ObjectInputStream(bis);
		Object o = null;
		try {
			o = ois.readObject();
		} catch (EOFException e) {
			System.err.print("read finished");
		}
		bis.close();
		ois.close();
		return o;
	}

}