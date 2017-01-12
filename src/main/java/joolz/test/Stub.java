package joolz.test;

import java.util.HashMap;
import java.util.Map;

/**
 * Stub containing values that will prefer over anything found in the regular
 * language files.
 * 
 * @author joolz
 *
 */
public final class Stub {
	public static final String PREFIX = "myprefix.";

	public static String get(final String key) {
		Map<String, String> translations = new HashMap<String, String>();

		translations.put(PREFIX + "stubvalue1", "value 1 from stub");
		translations.put(PREFIX + "stubvalue2", "value 2 from stub");
		translations.put(PREFIX + "stubvalue3", "value 3 from stub");
		
		return translations.get(key);
	}

}
