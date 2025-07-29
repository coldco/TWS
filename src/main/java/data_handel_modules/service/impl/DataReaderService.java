package data_handel_modules.service.impl;

import data_handel_modules.entity.DatabaseConnection;
import exception_finding_modules.device.entity.DTO.Device;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

// 处理模块
class ProcessingModule {
    public void processData(Device device) {
        //
        System.out.println("Processing device: " + device.getName());
    }
}

@Service
public class DataReaderService {

    @Autowired
    private SwatDispatchService dispatchService;

    private final DatabaseConnection dbConnection = new DatabaseConnection();
    private final List<ProcessingModule> modules = new ArrayList<>();
    private final ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
    private final ExecutorService threadPool = Executors.newFixedThreadPool(4);

    public DataReaderService() {
        // 处理模块
        modules.add(new ProcessingModule());
        modules.add(new ProcessingModule());
    }

    public void startReading() {
        scheduler.scheduleAtFixedRate(() -> {
            List<Device> data = dbConnection.readData();
            processData(data);
        }, 0, 5, TimeUnit.SECONDS); // 每 5 秒读取一次数据
    }

    private void processData(List<Device> data) {
        //处理数据
        dispatchService.dispatchData();
        //处理设备数据
        for (Device device : data) {
            if ("Active".equals(device.getStatus())) {
                threadPool.submit(() -> {
                    for (ProcessingModule module : modules) {
                        module.processData(device);
                    }
                });
            }
        }
    }

    public void shutdown() {
        scheduler.shutdown();
        threadPool.shutdown();
    }
}