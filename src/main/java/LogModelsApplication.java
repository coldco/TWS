import data_handel_modules.task.DataCollectionTask;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class LogModelsApplication {
    public static void main(String[] args) {

        DataCollectionTask dataCollectionTask = new DataCollectionTask();
        dataCollectionTask.startTask();
        SpringApplication.run(LogModelsApplication.class, args);


    }
}
