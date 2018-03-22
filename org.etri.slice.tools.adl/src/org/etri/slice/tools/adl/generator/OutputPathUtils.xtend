/*******************************************************************************
 * Copyright (c) 2018 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.etri.slice.tools.adl.generator

import com.google.inject.Inject
import org.eclipse.xtext.naming.IQualifiedNameProvider
import org.etri.slice.tools.adl.domainmodel.AgentDeclaration

/**
 * @author yhsuh - Initial contribution and API
 */
class OutputPathUtils {
	
	static val sliceDevice = "org.etri.slice.devices."
	static val sliceRule = "org.etri.slice.rules."
	@Inject extension IQualifiedNameProvider	
	
	def getDeviceFullyQualifiedName(AgentDeclaration it) {
		return sliceDevice + eContainer.fullyQualifiedName + "." + name.toLowerCase
	}
	
	def getDeviceMavenHome(AgentDeclaration it) {
		deviceFullyQualifiedName + "/"
	}
	
	def getDeviceMavenSrcHome(AgentDeclaration it) {
		deviceFullyQualifiedName + "/src/main/java/"
	}

	def getDeviceMavenResHome(AgentDeclaration it) {
		deviceFullyQualifiedName + "/src/main/resources/"
	}
	
	def getRuleFullyQualifiedName(AgentDeclaration it) {
		return sliceRule + eContainer.fullyQualifiedName + "." + name.toLowerCase
	}
		
	def getRuleMavenHome(AgentDeclaration it) {
		ruleFullyQualifiedName + "/"
	}
	
	def getRuleMavenResHome(AgentDeclaration it) {
		it.ruleFullyQualifiedName + "/src/main/resources/"
	}			
}