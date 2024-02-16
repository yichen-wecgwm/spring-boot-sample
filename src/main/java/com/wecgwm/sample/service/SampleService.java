package com.wecgwm.sample.service;

import com.wecgwm.sample.model.Entity.SampleEntity;
import com.wecgwm.sample.model.req.SampleRequest;

import java.util.List;


public interface SampleService {

    SampleEntity query(SampleRequest request);

    List<SampleEntity> query(List<Integer> idList);

}
