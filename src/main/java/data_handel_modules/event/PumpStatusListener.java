package data_handel_modules.event;

import data_handel_modules.entity.SwatRecord;
import org.springframework.context.ApplicationListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import java.util.List;

// 模块B监听器
@Component
public class PumpStatusListener implements ApplicationListener<SwatDataEvent> {
    @Async
    @Override
    public void onApplicationEvent(SwatDataEvent event) {
        List<SwatRecord> data = event.getRecords();
        long attackPumpOn = data.stream()
                .filter(r -> "attack".equalsIgnoreCase(r.getAttack()) && r.getP101() != null && r.getP101() == 1)
                .count();
        System.out.println("[PumpStatusListener] 攻击期间泵开启次数：" + attackPumpOn);
    }
}
