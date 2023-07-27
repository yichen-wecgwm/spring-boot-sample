package com.wecgwm.sample;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

/**
 * @author ：wecgwm
 * @date ：2023/07/21 15:52
 */
@Slf4j
public class SampleTest {

    @Test
    public void test(){
        log.info(Thread.currentThread().toString());
    }

}
