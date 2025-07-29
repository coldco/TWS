package data_handel_modules.task;

import data_handel_modules.service.impl.DataReaderService;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class DataCollectionTask {
    private final ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
    private final DataReaderService dataReaderService = new DataReaderService();



    public void startTask() {
        scheduler.scheduleAtFixedRate(() -> {
            dataReaderService.startReading();
        }, 0, 5, TimeUnit.SECONDS);
    }

    public void stopTask() {
        scheduler.shutdown();
        dataReaderService.shutdown();
    }
}