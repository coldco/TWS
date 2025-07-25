package org.hit.edu.controller;

import org.hit.edu.entity.CommonResult;
import org.hit.edu.entity.VO.DeviceConnectVO;
import org.hit.edu.entity.VO.ProcessVO;
import org.hit.edu.service.DeviceWaringService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DeviceController {

    @Autowired
    private DeviceWaringService deviceWaringService;

    public CommonResult<DeviceConnectVO> getDeviceConnectInfo(){
        DeviceConnectVO deviceConnectVO = deviceWaringService.getDeviceConnectInfo().getData();
        return CommonResult.success(deviceConnectVO);
    }


    public CommonResult<ProcessVO> getDeviceConnectInfoWithLog(){
        ProcessVO deviceConnectVO = deviceWaringService.getProcessConnect().getData();
        return CommonResult.success(deviceConnectVO);
    }


}
