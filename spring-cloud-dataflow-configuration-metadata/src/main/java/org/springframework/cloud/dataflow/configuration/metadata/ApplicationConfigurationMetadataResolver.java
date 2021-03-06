/*
 * Copyright 2015 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.springframework.cloud.dataflow.configuration.metadata;

import java.util.List;

import org.springframework.boot.configurationmetadata.ConfigurationMetadataProperty;
import org.springframework.core.io.Resource;

/**
 * Used to retrieve metadata about the configuration properties that can alter an application's behavior.
 *
 * @author Eric Bottard
 */
public abstract class ApplicationConfigurationMetadataResolver {

	/**
	 * Returns whether this resolver supports the given app.
	 */
	public abstract boolean supports(Resource app);


	public List<ConfigurationMetadataProperty> listProperties(Resource app) {
		return listProperties(app, false);
	}

	/**
	 * Return metadata about configuration properties that are documented via
	 * <a href="http://docs.spring.io/spring-boot/docs/current/reference/html/configuration-metadata.html">
	 * Spring Boot configuration metadata</a> and visible in an app.
	 * @param app a Spring Cloud Stream app; typically a Boot uberjar,
	 *            but directories are supported as well
	 */
	public abstract List<ConfigurationMetadataProperty> listProperties(Resource app, boolean exhaustive);
}
