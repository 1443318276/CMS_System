package edu.xww.beans;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.apache.log4j.Logger;
import edu.xww.utils.Tools;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.regex.Pattern;

@Getter
@Setter
@ToString
public class BootsTableRequest {
    private static final Logger LOG = Logger.getLogger(BootsTableRequest.class);
    private Integer limit; //限制每次查询获取到的数据条数
    private Integer offset; //从第几条数据开始查询
    private String order; //排序方式ASC DESC
    private String search; //参与排序的字段
    private String sort; //参与搜索的字段
    private Map<String, Object> extras; //额外的请求参数

    public void setLimit(Integer limit) {
        this.limit = limit == null ? 1 : limit > 1 ? limit : 1; //限定最少查询一条数据
    }

    public void setOffset(Integer offset) {
        this.offset = offset == null ? 0 : offset > 0 ? offset : 0;//限定最小值为0
    }

    public void setOrder(String order) {
        this.order = "ASC".equalsIgnoreCase(order) ? "ASC" : "DESC";//排序方式只有两种
    }

    public void setSort(String sort) {
        //参与排序的字段只允许出现数字 字母 下划线
        this.sort = sort;
        if (Pattern.matches("[0-9a-zA-Z_]+", sort)) {
            this.sort = Tools.humpToLine(sort);
        } else {
            this.sort = null;
        }
    }

    public void setSearch(String search) {
        //只能输入数字 字母 下划线 中文字符
        if (Pattern.matches("[0-9a-zA-Z_\u4300-\u9fa5]+", search)) {
            //如果是模糊查询需要拼接%%
            this.search = "%" + search + "%";
        } else {
            this.search = null;
        }
    }

    public Integer getInteger(String key) {
        return this.getExtra(key, Integer.class);
    }

    public String getString(String key) {
        return this.getExtra(key, String.class);
    }

    public <T> T getExtra(String key, Class<T> targetClass) {
        if (this.extras == null) return null;
        Object value = this.extras.get(key);
        if (value == null) return null;
        if (Objects.equals(value.getClass(), targetClass)) {
            return (T) value;
        }
        LOG.error(
                String.format("数据类型转换失败，原始类型是:%s,目标数据类型是:%s,原始数据类型是: ",
                        value.getClass().getName(),
                        targetClass.getName())
                        + value);
        return null;
    }

    public void setExtra(String key, Object value) {
        if (this.extras == null) this.extras = new HashMap<>();
        this.extras.put(key, value);
    }
}
