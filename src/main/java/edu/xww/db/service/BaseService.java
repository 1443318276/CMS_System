package edu.xww.db.service;

import edu.xww.db.model.BaseModel;
import edu.xww.beans.BootsTableRequest;
import edu.xww.beans.BootsTableResponse;

import java.lang.reflect.ParameterizedType;
import java.util.List;

public interface BaseService<T extends BaseModel> {

    T findByPrimaryKey(Integer key);

    int insertSelective(T record);

    int updateByPrimaryKey(T record);

    int delElementByIdList(List<Integer> idList);

    BootsTableResponse<T> bootsData(BootsTableRequest tableRequest);

    default T newDelInstance() {
        try {
            ParameterizedType parameterizedType = (ParameterizedType) this.getClass().getGenericSuperclass();
            Class<T> tClass = (Class<T>) parameterizedType.getActualTypeArguments()[0];
            T t = tClass.newInstance();
            t.setDelTime((int) (System.currentTimeMillis() / 1000));
            return t;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
