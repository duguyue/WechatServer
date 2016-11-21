package org.lindl.utils;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
@SuppressWarnings( { "unused", "unchecked", "serial" })
public class Md5 {
	public static String getVal_UTF8(String plainText) {
		// System.out.println("plainText:"+plainText);
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			md.update(plainText.getBytes("UTF-8"));
			byte b[] = md.digest();

			int i;
			StringBuffer buf = new StringBuffer("");
			for (int offset = 0; offset < b.length; offset++) {
				i = b[offset];
				if (i < 0)
					i += 256;
				if (i < 16)
					buf.append("0");
				buf.append(Integer.toHexString(i));
			}

			return buf.toString();

		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}

		catch (UnsupportedEncodingException e) {
			e.printStackTrace();
			return null;
		}
	}
}
