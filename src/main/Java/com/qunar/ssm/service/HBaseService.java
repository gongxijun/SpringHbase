package com.qunar.ssm.service;

import org.apache.hadoop.hbase.client.Result;

/**
 * *********************************************************
 * <p/>
 * Created with IntelliJ IDEA.
 *
 * @Package: com.qunar.ssm.service
 * @Author: XiJun.Gong(Vipgxjun@163.com)
 * @Date: 2016-07-27 15:40
 * @Version: default 1.0.0
 * @Class description：
 * <p/>
 * *********************************************************
 */
public interface HBaseService {

    public String add(final String tableName, final String row, final String cfInfo,
                      final String colName, final String value);

    public Result get(final String tableName, final String row);

}
