package com.wecgwm.sample.controller;

import com.wecgwm.sample.model.Entity.SampleEntity;
import com.wecgwm.sample.model.req.SampleRequest;
import com.wecgwm.sample.model.resp.Response;
import com.wecgwm.sample.service.SampleService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * @author ：wecgwm
 * @date ：2024/02/16 18:04
 */
@RestController
@RequestMapping("${spring.application.name}")
@RequiredArgsConstructor(onConstructor_ = @Autowired)
public class SampleController {
    private final SampleService sampleService;

    @GetMapping("/sample")
    public Response<SampleEntity> query( @Valid SampleRequest request){
        return Response.from(sampleService.query(request));
    }

    @PostMapping("/getSamples")
    public Response<List<SampleEntity>> query(@RequestBody List<Integer> idList){
        return Response.from(sampleService.query(idList));
    }

}
