package data_handel_modules.service.impl;

import data_handel_modules.entity.SwatRecord;
import data_handel_modules.mapper.SwatRecordMapper;
import data_handel_modules.service.SwatRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SwatRecordServiceImpl implements SwatRecordService {

    @Autowired
    private SwatRecordMapper mapper;

    public SwatRecord getByTimestamp(String timestamp) {
        return mapper.selectByTimestamp(timestamp);
    }

    public List<SwatRecord> getAll() {
        return mapper.selectAll();
    }

    public boolean add(SwatRecord record) {
        return mapper.insertRecord(record) > 0;
    }

    public boolean update(SwatRecord record) {
        return mapper.updateRecord(record) > 0;
    }

    public boolean delete(String timestamp) {
        return mapper.deleteByTimestamp(timestamp) > 0;
    }






}
