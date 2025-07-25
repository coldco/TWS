package log_modules.controller;

import exception_finding_modules.device.entity.CommonResult;
import exception_finding_modules.device.entity.VO.DeviceConnectVO;
import exception_finding_modules.device.entity.VO.ProcessVO;
import exception_finding_modules.device.service.DeviceWaringService;
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
