package cn.ak.gc.domain.repository;

import com.alibaba.fastjson.JSONObject;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface CommonRepository<T> {
    int insertVOWithPK(@Param("tableName") String tableName, @Param("primaryKey") String primaryKey, @Param("columns") JSONObject columns);
    int insertVOWithoutPK(@Param("tableName") String tableName, @Param("primaryKey") String primaryKey, @Param("columns") JSONObject columns);
    int deleteVO(@Param("tableName") String tableName, @Param("primaryKey") String primaryKey, @Param("columns") JSONObject columns);
    int updateVO(@Param("tableName") String tableName, @Param("primaryKey") String primaryKey, @Param("columns") JSONObject columns);
    List<T> getEntities(@Param("tableName")String tableName, @Param("primaryKey") String primaryKey, @Param("columns")JSONObject columns, @Param("params") JSONObject params);
}
