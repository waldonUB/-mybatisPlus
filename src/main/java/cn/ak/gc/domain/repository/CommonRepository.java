package cn.ak.gc.domain.repository;

import cn.ak.gc.commen.model.Page;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Mapper
@Repository
public interface CommonRepository<T> {
    int insertVOWithPK(@Param("tableName") String tableName, @Param("primaryKey") String primaryKey, @Param("columns") JSONObject columns);
    int insertVOWithoutPK(@Param("tableName") String tableName, @Param("primaryKey") String primaryKey, @Param("columns") JSONObject columns);
    int deleteVO(@Param("tableName") String tableName, @Param("primaryKey") String primaryKey, @Param("columns") JSONObject columns);
    int updateVO(@Param("tableName") String tableName, @Param("primaryKey") String primaryKey, @Param("columns") JSONObject columns);
    List<T> getEntities(@Param("tableName")String tableName, @Param("primaryKey") String primaryKey, @Param("columns")JSONObject columns, @Param("params") JSONObject params);
    JSONObject getEntity(@Param("tableName")String tableName, @Param("primaryKey") String primaryKey, @Param("columns")JSONObject columns, @Param("params") JSONObject params);
    List<T> getPageEntities(@Param("tableName")String tableName, @Param("primaryKey") String primaryKey, @Param("columns")JSONObject columns, @Param("params") JSONObject params, @Param("current") int current, @Param("size") int size);
    int getPageCount(@Param("tableName")String tableName);
}
