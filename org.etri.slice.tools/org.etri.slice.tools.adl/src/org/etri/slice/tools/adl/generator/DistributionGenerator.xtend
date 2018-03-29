package org.etri.slice.tools.adl.generator

import com.google.inject.Inject
import org.eclipse.emf.ecore.resource.Resource
import org.eclipse.xtext.generator.IFileSystemAccess
import org.eclipse.xtext.generator.IGenerator
import org.eclipse.xtext.naming.IQualifiedNameProvider
import org.etri.slice.tools.adl.domainmodel.AgentDeclaration
import org.etri.slice.tools.adl.domainmodel.DomainDeclaration

class DistributionGenerator implements IGenerator {	

	@Inject extension IQualifiedNameProvider
		
	override doGenerate(Resource resource, IFileSystemAccess fsa) {
		fsa.generateFile(OutputPathUtils.sliceDistribution + "/pom.xml", compileDistributionPOM(resource))
		fsa.generateFile(OutputPathUtils.sliceDistribution + "/run_slice.bat", compileRunBatch)
		fsa.generateFile(OutputPathUtils.sliceDistribution + "/run_slice.sh", compileRunShell)		
	}
	
	def compileDistributionPOM(Resource resource) '''
		<project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
			xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
		
			<modelVersion>4.0.0</modelVersion>
			<parent>
				<groupId>org.etri.slice</groupId>
				<artifactId>org.etri.slice</artifactId>
				<version>0.9.1</version>
				<relativePath>../pom.xml</relativePath>
			</parent>
		
			<artifactId>org.etri.slice.distribution</artifactId>
			<name>The SLICE distribution</name>
			<description>org.etri.slice.distribution :: distribution</description>
		
			<dependencies>
				<dependency>
					<groupId>org.apache.felix</groupId>
					<artifactId>org.apache.felix.ipojo.distribution.quickstart</artifactId>
					<version>${felix.ipojo.version}</version>
					<type>zip</type>
				</dependency>
				<dependency>
					<groupId>org.apache.felix</groupId>
					<artifactId>org.apache.felix.ipojo.handler.eventadmin</artifactId>
					<version>1.8.0</version>
				</dependency>
				<dependency>
					<groupId>org.apache.felix</groupId>
					<artifactId>org.apache.felix.eventadmin</artifactId>
					<version>1.4.10</version>
				</dependency>
				<dependency>
					<groupId>org.apache.felix</groupId>
					<artifactId>org.apache.felix.main</artifactId>
					<version>5.6.8</version>
				</dependency>
				<dependency>
					<groupId>org.etri.slice</groupId>
					<artifactId>org.etri.slice.api</artifactId>
					<version>0.9.1</version>
				</dependency>
				<dependency>
					<groupId>org.etri.slice</groupId>
					<artifactId>org.etri.slice.commons</artifactId>
					<version>0.9.1</version>
				</dependency>
				<dependency>
					<groupId>org.etri.slice</groupId>
					<artifactId>org.etri.slice.core</artifactId>
					<version>0.9.1</version>
				</dependency>						
				«FOR e: resource.allContents.toIterable.filter(typeof(DomainDeclaration))»
					<dependency>
						<groupId>org.etri.slice.commons</groupId>
						<artifactId>org.etri.slice.commons.«e.fullyQualifiedName»</artifactId>
						<version>0.9.1</version>
					</dependency>
				«ENDFOR»
				«FOR e: resource.allContents.toIterable.filter(typeof(AgentDeclaration))»	
					<dependency>
						<groupId>org.etri.slice</groupId>
						<artifactId>org.etri.slice.agents.«e.eContainer.fullyQualifiedName».«e.name.toLowerCase»</artifactId>
						<version>0.9.1</version>
					</dependency>
					<dependency>
						<groupId>org.etri.slice</groupId>
						<artifactId>org.etri.slice.devices.«e.eContainer.fullyQualifiedName».«e.name.toLowerCase»</artifactId>
						<version>0.9.1</version>
					</dependency>										
				«ENDFOR»				
			</dependencies>
		
			<build>
				<plugins>
					<plugin>
						<groupId>org.apache.maven.plugins</groupId>
						<artifactId>maven-dependency-plugin</artifactId>
						<version>3.0.1</version>
						<executions>
							<execution>
								<id>unpack-felix</id>
								<phase>compile</phase>
								<goals>
									<goal>unpack-dependencies</goal>
								</goals>
								<configuration>
									<includeArtifactIds>org.apache.felix.ipojo.distribution.quickstart</includeArtifactIds>
									<outputDirectory>${project.build.directory}/tmp</outputDirectory>
								</configuration>
							</execution>
							<execution>
								<id>copy-felix</id>
								<phase>package</phase>
								<goals>
									<goal>copy-dependencies</goal>
								</goals>
								<configuration>
									<includeArtifactIds>org.apache.felix.ipojo.handler.eventadmin,org.apache.felix.eventadmin</includeArtifactIds>
									<outputDirectory>${project.build.directory}/bundle</outputDirectory>
								</configuration>
							</execution>					
							<execution>
								<id>copy-bundles</id>
								<phase>package</phase>
								<goals>
									<goal>copy-dependencies</goal>
								</goals>
								<configuration>
									<includeGroupIds>${project.groupId}</includeGroupIds>
									<excludeArtifactIds>dependencies</excludeArtifactIds>
									<outputDirectory>${project.build.directory}/bundle</outputDirectory>
								</configuration>
							</execution>
						</executions>
					</plugin>
					<plugin>
						<artifactId>maven-resources-plugin</artifactId>
						<version>3.0.2</version>
						<executions>
							<execution>
								<goals>
									<goal>copy-resources</goal>
								</goals>
								<phase>compile</phase>
								<id>copy-distribution</id>
								<configuration>
									<outputDirectory>${project.build.directory}</outputDirectory>
									<resources>
										<resource>
											<directory>${project.build.directory}/tmp/ipojo-distribution-${felix.ipojo.version}</directory>
											<filtering>false</filtering>
										</resource>
										<resource>
											<directory>${project.basedir}</directory>
											<includes>
												<include>run_slice.bat</include>
												<include>run_slice.sh</include>
											</includes>
										</resource>
									</resources>
								</configuration>
							</execution>
						</executions>
					</plugin>
				</plugins>
			</build>
		</project>
	'''	

	def compileRunBatch() '''
		@echo off
		java -jar -Dcom.sun.management.jmxremote.port=3403 -Dcom.sun.management.jmxremote.authenticate=false -Dcom.sun.management.jmxremote.ssl=false ./bin/felix.jar
	'''
	
	def compileRunShell() '''
		java -jar -Dcom.sun.management.jmxremote.port=3403 -Dcom.sun.management.jmxremote.authenticate=false -Dcom.sun.management.jmxremote.ssl=false ./bin/felix.jar
	'''	
}