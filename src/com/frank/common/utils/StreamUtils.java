package com.frank.common.utils;

import java.io.Closeable;

public class StreamUtils {
	
	public static void close(Closeable s) {
		try {
			s.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
