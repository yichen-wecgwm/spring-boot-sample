package com.wecgcm.util;

import com.wecgcm.config.SpringApplicationContext;
import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.MeterRegistry;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

/**
 * @author ：wecgwm
 * @date ：2023/07/10 2:01
 */
@Component
public class MetricsUtil {
    private static final MeterRegistry REGISTRY = SpringApplicationContext.getBean(MeterRegistry.class);

    public static BuilderWrap counter(String name){
        return new BuilderWrap(Counter.builder(name));
    }

    @AllArgsConstructor
    public static class BuilderWrap{
        private final Counter.Builder builder;

        public BuilderWrap tag(String key, String value){
            builder.tag(key, value);
            return this;
        }

        public void increment(){
            builder.register(REGISTRY).increment();
        }
    }

}
