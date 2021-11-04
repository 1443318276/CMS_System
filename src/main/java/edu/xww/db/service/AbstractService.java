package edu.xww.db.service;

import edu.xww.db.model.BaseModel;
import org.mybatis.dynamic.sql.SqlTable;
import org.mybatis.dynamic.sql.select.QueryExpressionDSL;
import org.mybatis.dynamic.sql.select.SelectModel;
import edu.xww.beans.BootsTableRequest;

import java.sql.JDBCType;

public abstract class AbstractService {

    protected void sortByOrder(BootsTableRequest tableRequest, QueryExpressionDSL<SelectModel> entity, SqlTable sqlTable) {
        if (tableRequest.getSort() == null) {
            entity.orderBy(sqlTable.column("add_time", JDBCType.TIMESTAMP).descending());
        } else if ("ASC".equals(tableRequest.getOrder())) {
            entity.orderBy(sqlTable.column(tableRequest.getSort(), JDBCType.TIMESTAMP));
        } else {
            entity.orderBy(sqlTable.column(tableRequest.getSort(), JDBCType.TIMESTAMP).descending());
        }
    }

    protected static <T extends BaseModel> T newDelInstance(Class<T> tClass) {
        try {
            T t = tClass.newInstance();
            t.setDelTime((int) (System.currentTimeMillis() / 1000));
            return t;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
