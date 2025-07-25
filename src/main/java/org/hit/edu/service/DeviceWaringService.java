package org.hit.edu.service;

import org.hit.edu.entity.CommonResult;
import org.hit.edu.entity.VO.DeviceConnectVO;
import org.hit.edu.entity.VO.ProcessVO;

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
