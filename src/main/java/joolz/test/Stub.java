package joolz.test;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

/**
 * Stub containing values that will prefer over anything found in the regular
 * language files.
 * 
 * @author joolz
 *
 */
public final class Stub {

	public static String get(final String key, final Locale locale) {
		String result = null;
		Map<Locale, Map<String, String>> translationsBundle = new HashMap<>();

		System.out.println("Translate key " + key + " for locale " + locale.getDisplayName());

		// some dummy values. This will be a model later on
		Locale loc = new Locale("en", "US");
		Map<String, String> translations1 = new HashMap<>();
		translations1.put("stubvalue1", "value 1 from stub, locale is " + loc.getDisplayName());
		translations1.put("stubvalue2", "value 2 from stub, locale is " + loc.getDisplayName());
		translations1.put("stubvalue3", "value 3 from stub, locale is " + loc.getDisplayName());
		translationsBundle.put(loc, translations1);

		loc = new Locale("en", "GB");
		Map<String, String> translations2 = new HashMap<>();
		translations2.put("stubvalue1", "value 1 from stub, locale is " + loc.getDisplayName());
		translations2.put("stubvalue2", "value 2 from stub, locale is " + loc.getDisplayName());
		translations2.put("stubvalue3", "value 3 from stub, locale is " + loc.getDisplayName());
		translationsBundle.put(loc, translations2);

		loc = new Locale("nl", "NL");
		Map<String, String> translations3 = new HashMap<>();
		translations3.put("stubvalue1", "waarde 1 van de stub, locale is " + loc.getDisplayName());
		translations3.put("stubvalue2", "waarde 2 van de stub, locale is " + loc.getDisplayName());
		translations3.put("stubvalue3", "waarde 3 van de stub, locale is " + loc.getDisplayName());
		translationsBundle.put(loc, translations3);

		Map<String, String> requestedTranslations = translationsBundle.get(locale);
		if (requestedTranslations != null) {
			result = requestedTranslations.get(key);
		}

		return result;
	}

}