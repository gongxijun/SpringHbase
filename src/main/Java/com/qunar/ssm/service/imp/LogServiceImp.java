package com.qunar.ssm.service.imp;
import com.qunar.ssm.dao.LogDao;
import com.qunar.ssm.model.LogModel;
import com.qunar.ssm.service.LogService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * author: 龚细军
 * class-aim:
 */
@Service
public class LogServiceImp implements LogService {

    @Resource
    private LogDao logDao;

    @Override
    public List<LogModel> quesyUser() {
        return logDao.queryLog();
    }
}
