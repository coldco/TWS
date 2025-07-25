package data_handel_modules.event;

import data_handel_modules.entity.SwatRecord;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import java.util.List;

// 事件：包含预处理后的数据
public class SwatDataEvent extends ApplicationEvent {
    private final List<SwatRecord> records;

    public SwatDataEvent(Object source, List<SwatRecord> records) {
        super(source);
        this.records = records;
    }

    public List<SwatRecord> getRecords() {
        return records;
    }
}

