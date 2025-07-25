package org.hit.edu.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.hit.edu.entity.DTO.Device;
import org.hit.edu.entity.VO.DeviceConnectVO;

import java.util.List;

@Mapper
public interface DeviceMapper {

    public List<Device> getDeviceConnectInfo();




}
