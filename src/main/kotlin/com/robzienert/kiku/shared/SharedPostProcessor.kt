/*
 * Copyright 2020 Netflix, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.robzienert.kiku.shared

import com.robzienert.kiku.core.Attire
import com.robzienert.kiku.core.Collar
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.config.BeanDefinition
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory
import org.springframework.beans.factory.support.BeanDefinitionRegistry
import org.springframework.beans.factory.support.BeanDefinitionRegistryPostProcessor
import org.springframework.beans.factory.support.RootBeanDefinition


class SharedPostProcessor(private val context: String) : BeanDefinitionRegistryPostProcessor {
  private val log by lazy { LoggerFactory.getLogger(javaClass) }

  override fun postProcessBeanFactory(beanFactory: ConfigurableListableBeanFactory) {
    log.info("postProcessBeanFactory for $context")
  }

  override fun postProcessBeanDefinitionRegistry(registry: BeanDefinitionRegistry) {
    log.info("postProcessBeanDefinitionRegistry for $context")

    if (context == "core") {
      val beanDefinition = RootBeanDefinition(Collar::class.java)
      beanDefinition.targetType = Attire::class.java
      beanDefinition.role = BeanDefinition.ROLE_APPLICATION
      registry.registerBeanDefinition("collar", beanDefinition)
    }
  }
}
