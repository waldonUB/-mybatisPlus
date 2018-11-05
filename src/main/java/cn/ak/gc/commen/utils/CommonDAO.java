package cn.ak.gc.commen.utils;

import cn.ak.gc.commen.annotation.Entity;
import cn.ak.gc.domain.repository.CommonRepository;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CommonDAO<T> {

    @Autowired
    CommonRepository<T> repository;

    public int insertVOWithPK(T vo) {
        return getVO(vo, "insertVOWithPK");
    }

    public int insertVOWithoutPK(T vo) {
        return getVO(vo, "insertVOWithoutPK");
    }

    public int deleteVO(T vo) {
        return getVO(vo, "deleteVO");
    }

    public int updateVO(T vo) {
        return getVO(vo, "updateVO");
    }

    public List<T> getEntities(T vo, JSONObject params) {
        Entity entity = vo.getClass().getAnnotation(Entity.class);
        String tableName = entity.tableName();
        String primaryKey = entity.primaryKey();
        JSONObject columns = (JSONObject) JSONObject.toJSON(vo);
        columns.forEach((k, v) -> columns.put(k, TranslateCase.lowerCase(k)));
        return repository.getEntities(tableName, primaryKey, columns, params);
    }

    public List<T> getPageEntities(T vo, JSONObject params) {
        Entity entity = vo.getClass().getAnnotation(Entity.class);
        String tableName = entity.tableName();
        String primaryKey = entity.primaryKey();
        JSONObject columns = (JSONObject) JSONObject.toJSON(vo);
        columns.forEach((k, v) -> columns.put(k, TranslateCase.lowerCase(k)));
        return repository.getEntities(tableName, primaryKey, columns, params);
    }

    private int getVO(T vo, String type) {
        Entity entity = vo.getClass().getAnnotation(Entity.class);
        String tableName = entity.tableName();
        String primaryKey = entity.primaryKey();
        JSONObject json = (JSONObject) JSONObject.toJSON(vo);
        JSONObject columns = new JSONObject();
        json.forEach((k, v) -> columns.put(TranslateCase.lowerCase(k), v));
        switch (type) {
            case "insertVOWithPK" :
                return repository.insertVOWithPK(tableName, primaryKey, columns);
            case "insertVOWithoutPK" :
                return repository.insertVOWithoutPK(tableName, primaryKey, columns);
            case "deleteVO" :
                return repository.deleteVO(tableName, primaryKey, columns);
            case "updateVO" :
                return repository.updateVO(tableName, primaryKey, columns);
        }
        return 0;
    }
}
