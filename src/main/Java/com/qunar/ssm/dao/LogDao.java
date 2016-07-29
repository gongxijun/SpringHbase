package com.qunar.ssm.dao;

import com.qunar.ssm.model.LogModel;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * author: 龚细军
 * class-aim:
 */

@Repository
public interface LogDao {

    public List<LogModel> queryLog();
}
