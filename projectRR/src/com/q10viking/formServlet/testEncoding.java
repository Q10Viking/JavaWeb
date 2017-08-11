package com.q10viking.formServlet;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

public class testEncoding {

	public static void main(String[] args) throws Exception {
		String username="十维君";
		//使用utf-8进行编码
		String encode=URLEncoder.encode(username, "utf-8");
		//使用iso-8859-1进行解码
		String decode=URLDecoder.decode(encode, "iso-8859-1");
		System.out.println(decode);
		System.out.println("==========");
		
		String decodeUtf8 = URLDecoder.decode(encode, "utf-8");
		System.out.println(decodeUtf8);
	}

}
