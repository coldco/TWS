package data_handel_modules.event;

import data_handel_modules.entity.SwatRecord;
import org.springframework.context.ApplicationListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import java.util.List;

// 模块A监听器
@Component
public class FlowControlListener implements ApplicationListener<SwatDataEvent> {
    @Async
    @Override
    public void onApplicationEvent(SwatDataEvent event) {
        List<SwatRecord> data = event.getRecords();
        // 复杂业务逻辑: 例如计算统计指标，检测异常，分页处理等
        // 打印部分结果示例：
        long abnormalCount = data.stream().filter(r -> r.getFit101() != null && r.getFit101() > 5.0).count();
        System.out.println("[FlowControlListener] 异常流量计记录数：" + abnormalCount);
    }
}
