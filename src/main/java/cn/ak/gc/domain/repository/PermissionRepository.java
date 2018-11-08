package cn.ak.gc.domain.repository;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Mapper
@Repository
public interface PermissionRepository {
    List<Map<String, Object>> queryPermissionTree(@Param("groupCode") String groupCode);
}
