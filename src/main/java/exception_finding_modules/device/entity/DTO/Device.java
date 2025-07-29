package exception_finding_modules.device.entity.DTO;

import lombok.Data;

@Data
public class Device {
    private String name; // 设备名称
    private int level; // 设备层级
    private String type; // 设备类型
    private String status; // 设备状态


    public String getNeibor() {
        return name;
    }
}