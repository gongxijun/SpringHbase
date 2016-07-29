package com.qunar.ssm.controll;

import com.qunar.ssm.model.LogModel;
import com.qunar.ssm.service.HBaseService;
import com.qunar.ssm.service.LogService;
import org.apache.hadoop.hbase.Cell;
import org.apache.hadoop.hbase.CellUtil;
import org.apache.hadoop.hbase.client.Result;
import org.apache.hadoop.hbase.util.Bytes;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import qunar.web.spring.annotation.JsonBody;

import javax.annotation.Resource;
import java.util.List;

/**
 * author: 龚细军
 * class-aim:
 */
@Controller
public class TmpController {

    @Resource
    private LogService logService;

    @Resource
    private HBaseService hbaseService;

    @RequestMapping("login.json")
    public
    @JsonBody
    List<LogModel> tmpQuery() {
        List<LogModel> logModels = logService.quesyUser();
        System.out.println(logModels);
        return logModels;
    }


    @RequestMapping("tmp.json")
    public
    @JsonBody
    List<LogModel> Query() {
        return logService.quesyUser();
    }


    @RequestMapping(value = "insert.json", method = RequestMethod.POST)
    public
    @JsonBody
    String tmpInsert(@RequestParam(value = "id", defaultValue = "12", required = true) final String id,
                     @RequestParam(value = "name", defaultValue = "gongxijun", required = false) final String name,
                     @RequestParam(value = "url", defaultValue = "www.qunar.com", required = false) final String url) {
        hbaseService.add("Log", id, "property", "name", name);
        hbaseService.add("Log", id, "property", "url", url);
        return "成功了";
    }

    @RequestMapping(value = "ask.json")
    public
    @JsonBody
    String tmpQuery(@RequestParam(value = "tableName", defaultValue = "Log", required = true) String tableName,
                    @RequestParam(value = "row", defaultValue = "1", required = true) String row) {

        Result result = hbaseService.get(tableName, row);
        LogModel logModel = new LogModel();
        Cell[] cell = result.rawCells();
        for (int i = 0; i < cell.length; i += 2) {
            logModel.setName(Bytes.toString(CellUtil.cloneValue(cell[0])));
            logModel.setUrl(Bytes.toString(CellUtil.cloneValue(cell[1])));
            logModel.setId(Integer.valueOf(Bytes.toString(CellUtil.cloneRow(cell[0]))));
        }
        return logModel.toString();
    }
}
