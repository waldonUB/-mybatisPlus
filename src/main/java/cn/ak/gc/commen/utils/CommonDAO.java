package cn.ak.gc.commen.utils;

import cn.ak.gc.commen.annotation.Entity;
import cn.ak.gc.commen.model.Page;
import cn.ak.gc.domain.repository.CommonRepository;
import com.alibaba.fastjson.JSON;
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

    public int insertVOWithTB(T vo, String tableName) {
        JSONObject json = (JSONObject) JSONObject.toJSON(vo);
        JSONObject columns = new JSONObject();
        json.forEach((k, v) -> columns.put(TranslateCase.lowerCase(k), v));
        return repository.insertVOWithPK(tableName, null, columns);
    }

    public int deleteVO(T vo) {
        return getVO(vo, "deleteVO");
    }

    public int deleteVOWithTB(T vo, String tableName) {
        Entity entity = vo.getClass().getAnnotation(Entity.class);
        String primaryKey = entity.primaryKey();
        JSONObject json = (JSONObject) JSONObject.toJSON(vo);
        JSONObject columns = new JSONObject();
        json.forEach((k, v) -> columns.put(TranslateCase.lowerCase(k), v));
        return repository.deleteVO(tableName, primaryKey, columns);
    }

    public int deleteWithParams(String tableName, JSONObject params) {
        return repository.deleteWithParams(tableName, params);
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

    public List<T> getEntitiesWithTB(String tableName, T vo, JSONObject params) {
        JSONObject columns = (JSONObject) JSONObject.toJSON(vo);
        columns.forEach((k, v) -> columns.put(k, TranslateCase.lowerCase(k)));
        return repository.getEntities(tableName, null, columns, params);
    }

    public T getEntity(T vo) throws Exception{
        Entity entity = vo.getClass().getAnnotation(Entity.class);
        String tableName = entity.tableName();
        String primaryKey = entity.primaryKey();
        JSONObject columns = (JSONObject) JSONObject.toJSON(vo);
        JSONObject params = new JSONObject();
        columns.forEach((k, v) -> params.put(TranslateCase.lowerCase(k), v));
        columns.forEach((k, v) -> columns.put(k, TranslateCase.lowerCase(k)));
        try {
            JSONObject ReturnVO = repository.getEntity(tableName, primaryKey, columns, params);
            if (ReturnVO == null) {
                return null;
            } else {
                return JSON.toJavaObject(ReturnVO, (Class<T>)vo.getClass());
            }
        } catch (Exception e) {
            throw new Exception("只能获取一个对象" + e);
        }
    }

    public Page<T> getPageEntities(T vo, JSONObject params, int current, int size) {
        Entity entity = vo.getClass().getAnnotation(Entity.class);
        String tableName = entity.tableName();
        String primaryKey = entity.primaryKey();
        JSONObject columns = (JSONObject) JSONObject.toJSON(vo);
        columns.forEach((k, v) -> columns.put(k, TranslateCase.lowerCase(k)));
        List<T> list = repository.getPageEntities(tableName, primaryKey, columns, params, current, size);
        int total = repository.getPageCount(tableName);
        int pageNum = 0;
        Page<T> page = new Page<>();
        page.setCurrent(current);
        page.setSize(size);
        page.setTotal(total);
        page.setData(list);
        if (total % size == 0) {
            pageNum = total/size;
        } else {
            pageNum = total/size + 1;
        }
        page.setPageNum(pageNum);
        return page;
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
