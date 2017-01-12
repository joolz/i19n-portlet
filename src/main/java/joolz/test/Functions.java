package joolz.test;

import com.liferay.portal.kernel.util.StringPool;

/**
 * Functions for use in el.
 * 
 * @see http 
 *      ://stackoverflow.com/questions/7079978/how-to-create-a-custom-el-function
 * 
 * @author jal
 *
 */
public final class Functions {

	private Functions() {
	}

	public static String hello() {
		return "hello";
	}

	public static String upme(final String in) {
		return in == null ? StringPool.BLANK : in.toUpperCase();
	}

}
