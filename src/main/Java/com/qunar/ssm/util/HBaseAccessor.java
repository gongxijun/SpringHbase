package com.qunar.ssm.util;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.client.*;
import org.apache.hadoop.hbase.util.Bytes;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.io.IOException;

/**
 * *********************************************************
 * <p/>
 * Created with IntelliJ IDEA.
 *
 * @Package: com.qunar.ssm.util
 * @Author: XiJun.Gong(Vipgxjun@163.com)
 * @Date: 2016-07-27 09:37
 * @Version: default 1.0.0
 * @Class description：
 * <p/>
 * *********************************************************
 */

@Component
public class HBaseAccessor implements InitializingBean {

    protected final Logger logger = LoggerFactory.getLogger(getClass());

    @Resource(name = "hbaseConfiguration")
    private Configuration configuration;

    private HConnection connection;


    public Result getRecord(String tableName, String rowKey) {
        HTableInterface table;
        Result result = null;
        try {
            table = connection.getTable(tableName);
            Get get = new Get(Bytes.toBytes(rowKey));
            result = table.get(get);
        } catch (IOException e) {
            logger.error("Get record {} from table {} error", rowKey, tableName);
        } finally {
            return result;
        }
    }

    public Result getRecord(String tableName, Get get, long startTimestamp, long endTimestamp) {
        HTableInterface table;
        Result result = null;
        String rowKey = Bytes.toString(get.getRow());
        try {
            table = connection.getTable(tableName);
            get.setTimeRange(startTimestamp, endTimestamp + 1);
            get.setMaxVersions(Integer.MAX_VALUE);
            result = table.get(get);
        } catch (IOException e) {
            logger.error("Get record {} from table {} error", rowKey, tableName);
        } finally {
            return result;
        }
    }


    public Result getRecord(String tableName, Get get) {
        return getRecord(tableName, get, 0, Long.MAX_VALUE - 1);
    }


    @Override
    public void afterPropertiesSet() {
        logger.info("最先运行....");
        try {
            connection = HConnectionManager.createConnection(configuration);
        } catch (IOException e) {
            logger.error("Create connection error.");
        }
    }
}
