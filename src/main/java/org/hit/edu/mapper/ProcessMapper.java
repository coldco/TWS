package org.hit.edu.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.hit.edu.entity.DTO.Process;

import java.util.List;

@Mapper
public interface ProcessMapper {

    public List<Process> getProcessConnect();




}
