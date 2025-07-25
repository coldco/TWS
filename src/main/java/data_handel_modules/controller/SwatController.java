package data_handel_modules.controller;

import data_handel_modules.entity.SwatRecord;
import data_handel_modules.service.SwatRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/swat")
public class SwatController {

    @Autowired
    private SwatRecordService service;

    @GetMapping("/all")
    public List<SwatRecord> getAll() {
        return service.getAll();
    }

    @GetMapping("/{timestamp}")
    public SwatRecord getByTimestamp(@PathVariable String timestamp) {
        return service.getByTimestamp(timestamp);
    }

    @PostMapping("/add")
    public boolean addRecord(@RequestBody SwatRecord record) {
        return service.add(record);
    }

    @PutMapping("/update")
    public boolean updateRecord(@RequestBody SwatRecord record) {
        return service.update(record);
    }

    @DeleteMapping("/delete/{timestamp}")
    public boolean deleteRecord(@PathVariable String timestamp) {
        return service.delete(timestamp);
    }
}

