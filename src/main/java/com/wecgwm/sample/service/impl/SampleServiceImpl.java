package com.wecgwm.sample.service.impl;

import com.wecgwm.sample.mapper.SampleMapper;
import com.wecgwm.sample.model.Entity.SampleEntity;
import com.wecgwm.sample.model.req.SampleRequest;
import com.wecgwm.sample.service.SampleService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.Collections;
import java.util.List;


/**
 * @author ：wecgwm
 * @date ：2024/02/16 18:12
 */
@Service
@RequiredArgsConstructor(onConstructor_= @Autowired)
public class SampleServiceImpl implements SampleService {
    private final SampleMapper sampleMapper;

    @Override
    public SampleEntity query(SampleRequest request) {
        return sampleMapper.selectById(request.id());
    }

    @Override
    public List<SampleEntity> query(List<Integer> idList) {
        if (CollectionUtils.isEmpty(idList)) {
            return Collections.emptyList();
        }
        return sampleMapper.selectByIdList(idList);
    }

}
