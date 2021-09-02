/*
 * Copyright (c) 2011-2021, baomidou (jobob@qq.com).
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.bingo.autoconfigure;

import com.example.bingo.core.config.GlobalConfig;
import com.example.bingo.core.incrementer.DefaultIdentifierGenerator;
import com.example.bingo.core.incrementer.IdentifierGenerator;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.commons.util.InetUtils;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author nieqiurong 2021/1/29
 * @since 3.4.3
 */
@Configuration
@SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
@EnableConfigurationProperties(MybatisPlusProperties.class)
public class IdentifierGeneratorAutoConfiguration {

    @Configuration
    @ConditionalOnClass(InetUtils.class)
    public static class InetUtilsAutoConfig {

        private final InetUtils inetUtils;

        private final MybatisPlusProperties properties;

        public InetUtilsAutoConfig(InetUtils inetUtils, MybatisPlusProperties properties) {
            this.inetUtils = inetUtils;
            this.properties = properties;
        }

        @Bean
        @ConditionalOnMissingBean
        public IdentifierGenerator identifierGenerator() {
            GlobalConfig globalConfig = properties.getGlobalConfig();
            Long workerId = globalConfig.getWorkerId();
            Long datacenterId = globalConfig.getDatacenterId();
            if (workerId != null && datacenterId != null) {
                return new DefaultIdentifierGenerator(workerId, datacenterId);
            } else {
                return new DefaultIdentifierGenerator(inetUtils.findFirstNonLoopbackAddress());
            }
        }

    }

}
