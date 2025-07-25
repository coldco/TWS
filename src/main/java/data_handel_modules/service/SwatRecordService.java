package data_handel_modules.service;

import data_handel_modules.entity.SwatRecord;

import java.util.List;

public interface SwatRecordService {
    SwatRecord getByTimestamp(String timestamp);
    List<SwatRecord> getAll();
    boolean add(SwatRecord record);
    boolean update(SwatRecord record);
    boolean delete(String timestamp);
}
