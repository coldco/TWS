package exception_finding_modules.device.service.impl;

import exception_finding_modules.device.entity.CommonResult;
import exception_finding_modules.device.entity.DTO.Device;
import exception_finding_modules.device.entity.DTO.Process;
import exception_finding_modules.device.entity.GraphEntity;
import exception_finding_modules.device.entity.VO.DeviceConnectVO;
import exception_finding_modules.device.entity.VO.ProcessVO;
import exception_finding_modules.device.mapper.DeviceMapper;
import exception_finding_modules.device.mapper.ProcessMapper;
import exception_finding_modules.device.service.DeviceWaringService;
import log_modules.annotation.LogExecution;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import exception_finding_modules.device.util.SecurityUtils;


import java.util.ArrayList;
import java.util.List;

@Service
public class DeviceWaringServiceImpl implements DeviceWaringService {
    @Autowired
    private DeviceMapper deviceMapper;
    @Autowired
    private ProcessMapper processMapper;

    @Autowired
    private RedisTemplate<String, List<Device>> deviceRedis;

    @Autowired
    private RedisTemplate<String, List<Process>> processRedis;

    @Autowired
    SecurityUtils securityUtils ;

    /**
     * 设备关联
     * @return
     */
    @Override
    @LogExecution("设备发现")
    public CommonResult<DeviceConnectVO> getDeviceConnectInfo() {
        //1. 判断用户权限
        if (!securityUtils.getSubject().isPermitted("device:connect")) {
            return CommonResult.fail("权限不足");
        }

        //1. 从数据库加载设备信息
        //1.1 先从缓存中寻找设备信息

        List<Device> device = deviceRedis.opsForValue().get("device");
        //1.2 如果缓存中没有设备信息，则从数据库中加载
        if (device == null) {
            device = deviceMapper.getDeviceConnectInfo();
            //1.3 将设备信息存入缓存
            deviceRedis.opsForValue().set("device", device);
        }

        //2. 计算点边结构
        DeviceConnectVO deviceConnectVO = new DeviceConnectVO();
        List<GraphEntity.Node> nodes = new ArrayList<>();
        List<GraphEntity.Edge> edges = new ArrayList<>();
       //渲染点集
        for(int i = 0;i<device.size();i++){
            GraphEntity.Node node = new GraphEntity.Node();
            node.setId(String.valueOf(i));
            node.setLabel(device.get(i).getName());
            nodes.add(node);
        }
        //渲染边集
        for(GraphEntity.Node node : nodes){
            GraphEntity.Edge edge = new GraphEntity.Edge();
            edge.setSource(node.getId());
            edge.setTarget(device.get(Integer.valueOf(node.getId())).getNeibor());
            edges.add(edge);
        }

        return CommonResult.success(deviceConnectVO);
    }
    /**
     * 过程关联
     * @return
     */
    @LogExecution("过程关联")
    @Override
    public CommonResult<ProcessVO> getProcessConnect() {
        //1. 判断用户权限
        if (!securityUtils.getSubject().isPermitted("device:connect")) {
            return CommonResult.fail("权限不足");
        }

        //1. 从数据库加载过程信息
        //1.1 先从缓存中寻找过程信息

        List<Process> processes = processRedis.opsForValue().get("processes");
        //1.2 如果缓存中没有设备信息，则从数据库中加载
        if (processes == null) {
            processes = processMapper.getProcessConnect();
            //1.3 将设备信息存入缓存
            processRedis.opsForValue().set("processes", processes);
        }

        //2. 计算点边结构
        ProcessVO process = new ProcessVO();
        List<GraphEntity.Node> nodes = new ArrayList<>();
        List<GraphEntity.Edge> edges = new ArrayList<>();
        //渲染点集
        for(int i = 0;i<processes.size();i++){
            GraphEntity.Node node = new GraphEntity.Node();
            node.setId(String.valueOf(i));
            node.setLabel(processes.get(i).getName());
            nodes.add(node);
        }
        //渲染边集
        for(GraphEntity.Node node : nodes){
            GraphEntity.Edge edge = new GraphEntity.Edge();
            edge.setSource(node.getId());
            edge.setTarget(processes.get(Integer.valueOf(node.getId())).getNeibor());
            edges.add(edge);
        }
        //点边
        return CommonResult.success(process);
    }


}
