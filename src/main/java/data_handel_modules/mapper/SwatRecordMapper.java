package data_handel_modules.mapper;

import data_handel_modules.entity.SwatRecord;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface SwatRecordMapper {

    // 查询单条记录（按 timestamp）
    @Select("SELECT * FROM SWaT_Dataset_Attack_v0 WHERE Timestamp = #{timestamp}")
    SwatRecord selectByTimestamp(@Param("timestamp") String timestamp);

    // 查询全部
    @Select("SELECT * FROM SWaT_Dataset_Attack_v0 ORDER BY Timestamp DESC")
    List<SwatRecord> selectAll();

    // 插入
    @Insert("""
        INSERT INTO SWaT_Dataset_Attack_v0 (
          Timestamp, FIT101, LIT101, MV101, P101, P102, AIT201, AIT202, AIT203,
          FIT201, MV201, P201, P202, P203, P204, P205, P206,
          DPIT301, FIT301, LIT301, MV301, MV302, MV303, MV304,
          P301, P302, AIT401, AIT402, FIT401, LIT401, P401, P402, P403, P404,
          UV401, AIT501, AIT502, AIT503, AIT504,
          FIT501, FIT502, FIT503, FIT504, P501, P502, PIT501, PIT502, PIT503,
          FIT601, P601, P602, P603, attack
        ) VALUES (
          #{timestamp}, #{fit101}, #{lit101}, #{mv101}, #{p101}, #{p102}, #{ait201}, #{ait202}, #{ait203},
          #{fit201}, #{mv201}, #{p201}, #{p202}, #{p203}, #{p204}, #{p205}, #{p206},
          #{dpit301}, #{fit301}, #{lit301}, #{mv301}, #{mv302}, #{mv303}, #{mv304},
          #{p301}, #{p302}, #{ait401}, #{ait402}, #{fit401}, #{lit401}, #{p401}, #{p402}, #{p403}, #{p404},
          #{uv401}, #{ait501}, #{ait502}, #{ait503}, #{ait504},
          #{fit501}, #{fit502}, #{fit503}, #{fit504}, #{p501}, #{p502}, #{pit501}, #{pit502}, #{pit503},
          #{fit601}, #{p601}, #{p602}, #{p603}, #{attack}
        )
    """)
    int insertRecord(SwatRecord record);

    // 更新（根据 timestamp 主键更新）
    @Update("""
        UPDATE SWaT_Dataset_Attack_v0 SET
          FIT101 = #{fit101}, LIT101 = #{lit101}, MV101 = #{mv101}, P101 = #{p101}, P102 = #{p102},
          AIT201 = #{ait201}, AIT202 = #{ait202}, AIT203 = #{ait203}, FIT201 = #{fit201}, MV201 = #{mv201},
          P201 = #{p201}, P202 = #{p202}, P203 = #{p203}, P204 = #{p204}, P205 = #{p205}, P206 = #{p206},
          DPIT301 = #{dpit301}, FIT301 = #{fit301}, LIT301 = #{lit301}, MV301 = #{mv301}, MV302 = #{mv302},
          MV303 = #{mv303}, MV304 = #{mv304}, P301 = #{p301}, P302 = #{p302}, AIT401 = #{ait401},
          AIT402 = #{ait402}, FIT401 = #{fit401}, LIT401 = #{lit401}, P401 = #{p401}, P402 = #{p402},
          P403 = #{p403}, P404 = #{p404}, UV401 = #{uv401}, AIT501 = #{ait501}, AIT502 = #{ait502},
          AIT503 = #{ait503}, AIT504 = #{ait504}, FIT501 = #{fit501}, FIT502 = #{fit502}, FIT503 = #{fit503},
          FIT504 = #{fit504}, P501 = #{p501}, P502 = #{p502}, PIT501 = #{pit501}, PIT502 = #{pit502},
          PIT503 = #{pit503}, FIT601 = #{fit601}, P601 = #{p601}, P602 = #{p602}, P603 = #{p603},
          attack = #{attack}
        WHERE Timestamp = #{timestamp}
    """)
    int updateRecord(SwatRecord record);

    // 删除
    @Delete("DELETE FROM SWaT_Dataset_Attack_v0 WHERE Timestamp = #{timestamp}")
    int deleteByTimestamp(@Param("timestamp") String timestamp);
}
