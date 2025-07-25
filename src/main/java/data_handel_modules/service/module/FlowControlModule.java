package data_handel_modules.service.module;

import data_handel_modules.entity.SwatRecord;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class FlowControlModule {

    /**
     * 业务目标：监控FIT101流量计是否有异常波动
     */
    public void analyzeFlow(List<SwatRecord> records) {
        System.out.println("[FlowControlModule] 开始分析流量计FIT101数据...");

        records.stream()
                .filter(r -> r.getFit101() != null && r.getFit101() > 5.0)  // 假设正常值 < 5.0
                .limit(5)
                .forEach(r -> {
                    System.out.println("异常流量检测：时间 = " + r.getTimestamp() +
                            "，FIT101 = " + r.getFit101());
                });

        System.out.println("[FlowControlModule] 分析完成。\n");
    }
}
