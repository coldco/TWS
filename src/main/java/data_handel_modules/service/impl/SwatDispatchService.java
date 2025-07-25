package data_handel_modules.service.impl;

import data_handel_modules.entity.SwatRecord;
import data_handel_modules.event.SwatDataEvent;
import data_handel_modules.mapper.SwatRecordMapper;
import data_handel_modules.service.module.FlowControlModule;
import data_handel_modules.service.module.PumpStatusModule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SwatDispatchService {

    @Autowired
    private SwatRecordMapper swatRecordMapper;

    @Autowired
    private FlowControlModule flowControlModule;

    @Autowired
    private PumpStatusModule pumpStatusModule;

    @Autowired
    private ApplicationEventPublisher eventPublisher;
    /**
     * 主流程：读取数据 -> 处理 -> 分发
     */
    public void dispatchData() {
        System.out.println("[SwatDispatchService] 开始从数据库读取数据...");

        List<SwatRecord> allRecords = swatRecordMapper.selectAll();
        System.out.println("总共读取到记录数：" + allRecords.size());

        // ① 数据预处理：剔除空时间戳或关键字段为null的记录
        List<SwatRecord> cleaned = allRecords.stream()
                .filter(r -> r.getTimestamp() != null && r.getLit101() != null)
                .collect(Collectors.toList());
        System.out.println("清洗后记录数：" + cleaned.size());

        // ② 分发模块1：流量分析模块
        flowControlModule.analyzeFlow(cleaned);

        // ③ 分发模块2：泵状态分析模块
        pumpStatusModule.analyzePumpStatus(cleaned);

        System.out.println("[SwatDispatchService] 所有模块处理完毕。\n");
    }
    @Transactional(readOnly = true)
    public void fetchProcessAndPublish() {
        System.out.println("[SwatDispatchService] 读取数据库数据...");
        List<SwatRecord> records = swatRecordMapper.selectAll();

        // 复杂预处理:
        // 补充计算字段、转化格式等
        List<SwatRecord> filtered = records.stream()
                .filter(r -> r.getTimestamp() != null && r.getLit101() != null)
                .peek(this::setSomeCalculatedField)
                .collect(Collectors.toList());

        System.out.println("[SwatDispatchService] 预处理完成，记录数：" + filtered.size());

        // 异步发布事件，模块监听器并发处理
        eventPublisher.publishEvent(new SwatDataEvent(this, filtered));
    }
    public void setSomeCalculatedField(SwatRecord r){
        return;
    }
}
