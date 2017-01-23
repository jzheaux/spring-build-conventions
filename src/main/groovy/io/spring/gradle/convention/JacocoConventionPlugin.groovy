/*
 * Copyright 2002-2016 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */

package io.spring.gradle.convention;

import org.gradle.api.Project;

/**
 * @author Rob Winch
 */
public class JacocoConventionPlugin extends AbstractSpringJavaPlugin {

	@Override
	public void additionalPlugins(Project project) {
		project.configurations {
			jacoco //Configuration Group used by Sonar to provide Code Coverage using JaCoCo
		}

		project.dependencies {
			jacoco "org.jacoco:org.jacoco.agent:0.7.5.201505241946:runtime"
		}
		project.test {
			jvmArgs "-javaagent:${project.configurations.jacoco.asPath}=destfile=${project.buildDir}/jacoco.exec,includes=${project.group}.*"
		}
	}
}