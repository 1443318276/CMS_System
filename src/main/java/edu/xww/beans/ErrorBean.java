package edu.xww.beans;

import com.alibaba.fastjson.JSONArray;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;
import org.apache.log4j.Logger;


import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 统一规范ajax请求的返回数据格式
 */
@Getter
@Setter
@ToString
@Accessors(chain = true) //使得生成的setter方法返回对象本身，类似于builder模式
public class ErrorBean implements Cloneable {
    private static final Logger LOG = Logger.getLogger(ErrorBean.class);
    private int code; //返回的错误码，0表示没有错误，请求成功，其余数字都表示请求失败，有错误信息
    private String title; //请求后返回的状态标题
    private String msg; //请求后返回的状态详细描述信息
    private String url; //返回后希望前端跳转的页面
    private Object extra;//返回信息额外携带的数据参数，可以是集合

    private static Map<Integer, ErrorBean> errorBeanMap;

    /**
     * 私有化构造方法，不允许在类的外部直接new对象
     */
    private ErrorBean() {
    }

    public static ErrorBean getInstance(int code) {
        if (errorBeanMap == null) {
            synchronized (ErrorBean.class) {
                if (errorBeanMap == null) {
                    errorBeanMap = new HashMap<>();
                    loadDataFromFile();
                }
            }
        }
        if (errorBeanMap.containsKey(code)) {
            return (ErrorBean) errorBeanMap.get(code).clone();
        }
        return new ErrorBean().setCode(code);
    }

    @Override
    protected Object clone() {
        try {
            ErrorBean errorBean = (ErrorBean) super.clone();
            errorBean.extra = null;
            return errorBean;
        } catch (Exception e) {
            LOG.error("克隆ErrorBean失败",e);
            return new ErrorBean()
                    .setCode(this.code)
                    .setUrl(this.url)
                    .setMsg(this.msg)
                    .setTitle(this.title);
        }
    }

    private static void loadDataFromFile() {
        InputStream stream = null;
        BufferedReader reader = null;
        try {
            // 初始化
            stream = ErrorBean.class.getClassLoader().getResourceAsStream("ErrorMsg.json");

            assert stream != null;
            reader = new BufferedReader(new InputStreamReader(stream));

            // 按行读
            String line;
            StringBuilder builder = new StringBuilder();
            while ((line = reader.readLine()) != null) {
                builder.append(line);
            }

            // 阿里 FastJSON
            List<ErrorBean> list = JSONArray.parseArray(builder.toString(), ErrorBean.class);
            for (ErrorBean it: list) {
                errorBeanMap.put(it.code, it);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            if (stream != null) {
                try {
                    stream.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

}
