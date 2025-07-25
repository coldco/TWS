package exception_finding_modules.device.mapper;

import org.apache.ibatis.annotations.Mapper;
import exception_finding_modules.device.entity.DTO.Device;

import java.util.List;

@Mapper
public interface DeviceMapper {

    public List<Device> getDeviceConnectInfo();




}
