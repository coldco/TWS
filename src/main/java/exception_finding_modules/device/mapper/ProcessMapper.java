package exception_finding_modules.device.mapper;

import org.apache.ibatis.annotations.Mapper;
import exception_finding_modules.device.entity.DTO.Process;

import java.util.List;

@Mapper
public interface ProcessMapper {

    public List<Process> getProcessConnect();




}
