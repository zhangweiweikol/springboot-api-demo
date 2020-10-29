package com.demo.platform.component.okhttp;

import okhttp3.ConnectionPool;
import okhttp3.OkHttpClient;

import java.util.concurrent.TimeUnit;

/**
 * 自定义Ok http 构建类
 */
public class OkHttpBuilder {
    private OkHttpClient.Builder builder = new OkHttpClient.Builder();

    /**
     * 连接池
     */
    private ConnectionPool connectionPool;

    /**
     * 为新连接设置默认连接超时，单位毫秒
     */
    private long connectTimeout = 10000;

    /**
     * 构建客户端
     * @return okhttp client
     */
    public OkHttpClient build(){
        if (connectionPool != null) {
            builder.connectionPool(connectionPool);
        }
        if (connectTimeout != 10000) {
            builder.connectTimeout(connectTimeout, TimeUnit.MILLISECONDS);
        }
        return builder.build();
    }

    public ConnectionPool getConnectionPool() {
        return connectionPool;
    }

    public void setConnectionPool(ConnectionPool connectionPool) {
        this.connectionPool = connectionPool;
    }

    public long getConnectTimeout() {
        return connectTimeout;
    }

    public void setConnectTimeout(long connectTimeout) {
        this.connectTimeout = connectTimeout;
    }

    public void test(String s) {
        System.out.println(s);
    }
}
