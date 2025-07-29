package data_handel_modules.entity;

import exception_finding_modules.device.entity.DTO.Device;

import java.util.ArrayList;
import java.util.List;

// 模拟数据库连接
public class DatabaseConnection {
    public List<Device> readData() {
        // 模拟从数据库读取数据
        List<Device> devices = new ArrayList<>();
        Device device1 = new Device();
        device1.setName("Device1");
        device1.setLevel(1);
        device1.setType("TypeA");
        device1.setStatus("Active");
        devices.add(device1);

        Device device2 = new Device();
        device2.setName("Device2");
        device2.setLevel(2);
        device2.setType("TypeB");
        device2.setStatus("Inactive");
        devices.add(device2);

        return devices;
    }
}
