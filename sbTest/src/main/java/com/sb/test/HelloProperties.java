package com.sb.test;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * 配置文件实体映射
 * 相当于在application.propertis配置文件里
 * msg = "HengYu";
 * show = true;
 */
// 该属性配置了读取参数的前缀，根据上面的实体属性对应配置文件内的配置则是hello.msg、hello.show，
// 当然我们提供了默认值，配置文件内不进行配置时则是使用默认值。
@ConfigurationProperties(prefix = "hello")
public class HelloProperties {
    //消息内容
    private String msg = "jiajai";
    //是否显示消息内容
    private boolean show = true;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public boolean isShow() {
        return show;
    }

    public void setShow(boolean show) {
        this.show = show;
    }
}