package exception_finding_modules.device.entity.DTO;

public class Process {
    private String name; // 设备名称
    private int level; // 设备层级
    private String type; // 设备类型
    private String status; // 设备状态

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getNeibor() {
        return "";
    }
}