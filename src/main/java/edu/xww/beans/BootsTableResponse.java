package edu.xww.beans;

import com.github.pagehelper.PageInfo;
import edu.xww.db.model.BaseModel;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@ToString
public class BootsTableResponse<T extends BaseModel> {
    private long total;//记录了系统数据总条数
    private List<T> rows;//返回的真实数据列表

    public BootsTableResponse(List<T> rows) {
        PageInfo<T> info = new PageInfo<>(rows);
        this.total = info.getTotal();
        this.rows = rows;
    }
}
