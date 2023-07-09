package com.wecgcm.config;

import io.micrometer.core.instrument.Meter;
import io.micrometer.core.instrument.config.MeterFilter;
import lombok.NonNull;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author ：wecgwm
 * @date ：2023/07/10 3:21
 */
@Configuration(proxyBeanMethods = false)
public class MyMetricsFilterConfiguration {

    @Bean
    public MeterFilter renameRegionTagMeterFilter() {
        return new MeterFilter() {
            @NonNull
            @Override
            public Meter.Id map(@NonNull Meter.Id id) {
                return id.withName("java." + id.getName());
            }
        };
    }

}