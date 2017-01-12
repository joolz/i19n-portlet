package joolz.test.i19n;

import com.liferay.faces.util.client.BrowserSniffer;
import com.liferay.faces.util.client.BrowserSnifferFactory;
import com.liferay.faces.util.el.ExtELResolver;
import com.liferay.faces.util.el.I18N;
import com.liferay.faces.util.factory.FactoryExtensionFinder;
import com.liferay.faces.util.logging.Logger;
import com.liferay.faces.util.logging.LoggerFactory;

import javax.el.ELContext;
import javax.el.ELException;
import javax.el.PropertyNotWritableException;
import javax.faces.context.FacesContext;

/**
 * Extend the i18n resolver to facilitate i19n (custom translations with
 * fallback to LiferayFaces i18n)
 * 
 * @see com.liferay.faces.util.el.ExtELResolver
 * 
 * @author Joolz
 */
public class ExtExtElResolver extends ExtELResolver {
	public static final String I19N = "i19n";

	private static final Logger logger = LoggerFactory.getLogger(ExtExtElResolver.class);

	static {

		// Initialize the list of static feature descriptors.
		addFeatureDescriptor(BROWSER_SNIFFER, BrowserSniffer.class);
		addFeatureDescriptor(I18N, String.class);
		addFeatureDescriptor(I19N, String.class);
	}

	private I19N i19n;
	private I18N i18n;

	@Override
	protected Object resolveProperty(ELContext elContext, Object base, String property) {

		return null;
	}

	@Override
	protected Object resolveVariable(ELContext elContext, String varName) {

		Object value = null;

		try {

			if (varName.equals(I18N)) {

				if (i18n == null) {
					i18n = new I18N();
				}

				value = i18n;

			} else if (varName.equals(I19N)) {

				if (i19n == null) {
					i19n = new I19N();
				}

				value = i19n;

			} else if (varName.equals(BROWSER_SNIFFER)) {

				FacesContext currentInstance = FacesContext.getCurrentInstance();
				BrowserSnifferFactory browserSnifferFactory = (BrowserSnifferFactory) FactoryExtensionFinder
						.getFactory(BrowserSnifferFactory.class);
				value = browserSnifferFactory.getBrowserSniffer(currentInstance.getExternalContext());
			}
		} catch (Exception e) {
			throw new ELException("Failed to resolve variable [" + varName + "]", e);
		}

		if (value == null) {

			if (logger.isDebugEnabled()) {
				logger.debug("Unable to resolve variable [" + varName + "] value=" + value);
			}
		} else {

			if (logger.isDebugEnabled()) {
				logger.debug("Resolved variable [" + varName + "] value=" + value);
			}
		}

		return value;
	}

	@Override
	public Class<?> getCommonPropertyType(ELContext elContext, Object base) {

		Class<?> commonPropertyType = null;

		return commonPropertyType;
	}

	@Override
	public void setValue(ELContext elContext, Object base, Object property, Object value) {

		if (elContext == null) {

			// Throw an exception as directed by the JavaDoc for ELContext.
			throw new NullPointerException("elContext may not be null");
		}

		if ((property != null) && (property instanceof String)) {
			String propertyAsString = (String) property;

			if (propertyAsString.equals(I18N)) {
				throw new PropertyNotWritableException(propertyAsString);
			} else if (propertyAsString.equals(I19N)) {
				throw new PropertyNotWritableException(propertyAsString);
			} else if (propertyAsString.equals(BROWSER_SNIFFER)) {
				throw new PropertyNotWritableException(propertyAsString);
			}
		}
	}

	@Override
	public boolean isReadOnly(ELContext elContext, Object base, Object property) {

		return true;
	}

}
