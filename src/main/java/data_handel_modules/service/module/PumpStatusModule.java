package data_handel_modules.service.module;

import data_handel_modules.entity.SwatRecord;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PumpStatusModule {

    /**
     * 业务目标：分析P101泵在“攻击场景”中是否被强制启动或关闭
     */
    public void analyzePumpStatus(List<SwatRecord> records) {
        System.out.println("[PumpStatusModule] 开始分析P101状态...");

        records.stream()
                .filter(r -> "Attack".equalsIgnoreCase(r.getAttack()) && r.getP101() != null)
                .limit(5)
                .forEach(r -> {
                    System.out.println("攻击期间泵状态：时间 = " + r.getTimestamp() +
                            "，P101 = " + (r.getP101() == 1 ? "开启" : "关闭"));
                });

        System.out.println("[PumpStatusModule] 分析完成。\n");
    }
}
