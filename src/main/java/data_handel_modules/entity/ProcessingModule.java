package data_handel_modules.entity;

import exception_finding_modules.device.entity.DTO.Device;

// 模拟处理模块
public class ProcessingModule {
    public void processData(Device device) {
        // 模拟数据处理
        System.out.println("Processing device: " + device.getName());
    }
}
