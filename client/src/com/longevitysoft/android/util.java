package com.longevitysoft.android;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class util {
	private final static int BUFFER_SIZE = 10240;
	public static byte[] convertStreamToByteArray(InputStream is) {
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		byte[] buffer = new byte[BUFFER_SIZE];
		byte[] result = null;
		int b;
		try {
			while ((b = is.read(buffer, 0, buffer.length)) != -1) {
				baos.write(buffer, 0, b);
			}
			result = baos.toByteArray();

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				baos.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return result;
	}
}
