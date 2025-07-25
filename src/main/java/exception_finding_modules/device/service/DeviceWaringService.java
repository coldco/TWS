package exception_finding_modules.device.service;

import exception_finding_modules.device.entity.CommonResult;
import exception_finding_modules.device.entity.VO.DeviceConnectVO;
import exception_finding_modules.device.entity.VO.ProcessVO;

public interface DeviceWaringService {
    /**
     * 加载设备关联
     * @return
     */
     public CommonResult<DeviceConnectVO> getDeviceConnectInfo();

    /**
     * 加载过程关联
     * @return
     */
    public CommonResult<ProcessVO> getProcessConnect();

}
