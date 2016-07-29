package com.qunar.ssm.service.imp;

import com.google.common.base.Preconditions;
import com.google.common.base.Strings;
import com.qunar.ssm.service.HBaseService;
import org.apache.hadoop.hbase.client.HTableInterface;
import org.apache.hadoop.hbase.client.Put;
import org.apache.hadoop.hbase.client.Result;
import org.apache.hadoop.hbase.util.Bytes;
import org.springframework.data.hadoop.hbase.HbaseTemplate;
import org.springframework.data.hadoop.hbase.RowMapper;
import org.springframework.data.hadoop.hbase.TableCallback;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * *********************************************************
 * <p/>
 * <p/>
 * Author: XiJun.Gong
 * Date: 2016-07-27 15:41
 * Version: default 1.0.0
 * Class description：
 * <p/>
 * *********************************************************
 */
@Service
public class HBaseServiceImp implements HBaseService {

    @Resource
    private HbaseTemplate hbaseTemplate;

    /**
     * <p>add element by cf_info one by one <p/>
     *
     * @param tableName table
     * @param row       row
     * @param cfInfo    column family information
     * @param colName   column name
     * @param value     the value of the element
     * @return the value of the element
     */
    @Override
    public String add(final String tableName, final String row,
                      final String cfInfo, final String colName,
                      final String value) {

        Preconditions.checkArgument(Strings.isNullOrEmpty(tableName), "table name is null or empty");
        Preconditions.checkArgument(Strings.isNullOrEmpty(row), "row is null or empty");
        Preconditions.checkArgument(Strings.isNullOrEmpty(cfInfo), "column family information is null or empty");
        Preconditions.checkArgument(Strings.isNullOrEmpty(colName), "column name is null or empty");
        Preconditions.checkArgument(Strings.isNullOrEmpty(value), "value of element is null or empty");

        return hbaseTemplate.execute(tableName, new TableCallback<String>() {
            @Override
            public String doInTable(HTableInterface table) throws Throwable {
                Put put = new Put(row.getBytes());
                put.add(Bytes.toBytes(cfInfo), Bytes.toBytes(colName), Bytes.toBytes(value));
                table.put(put);
                return value;
            }
        });

    }

    /**
     * <p>to get a set by Row include all kinds of column family<p/>
     *
     * @param tableName table name
     * @param row       row
     * @return group of the result
     */
    @Override
    public Result get(final String tableName, final String row) {

        Preconditions.checkArgument(Strings.isNullOrEmpty(tableName), "table name is null or empty");
        Preconditions.checkArgument(Strings.isNullOrEmpty(row), "row is null or empty");

        return hbaseTemplate.get(tableName, row, new RowMapper<Result>() {

            @Override
            public Result mapRow(Result result, int rowNum) throws Exception {
                return result;
            }
        });
    }
}
