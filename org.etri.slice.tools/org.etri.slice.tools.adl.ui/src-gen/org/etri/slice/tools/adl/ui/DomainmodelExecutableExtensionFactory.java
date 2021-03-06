/*
 * generated by Xtext
 */
package org.etri.slice.tools.adl.ui;

import com.google.inject.Injector;
import org.eclipse.core.runtime.Platform;
import org.eclipse.xtext.ui.guice.AbstractGuiceAwareExecutableExtensionFactory;
import org.etri.slice.tools.adl.ui.internal.AdlActivator;
import org.osgi.framework.Bundle;

/**
 * This class was generated. Customizations should only happen in a newly
 * introduced subclass. 
 */
public class DomainmodelExecutableExtensionFactory extends AbstractGuiceAwareExecutableExtensionFactory {

	@Override
	protected Bundle getBundle() {
		return Platform.getBundle(AdlActivator.PLUGIN_ID);
	}
	
	@Override
	protected Injector getInjector() {
		AdlActivator activator = AdlActivator.getInstance();
		return activator != null ? activator.getInjector(AdlActivator.ORG_ETRI_SLICE_TOOLS_ADL_DOMAINMODEL) : null;
	}

}
