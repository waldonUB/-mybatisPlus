package cn.ak.gc.domain.repository;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Mapper
@Repository
public interface EssayRepository {
    List<Map<String, Object>> getEssays(@Param("userName") String userName);
}
