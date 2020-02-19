package com.service;

import com.pojo.Paper;

import java.util.List;

/**
 * 业务层接口：定义增删改查方法
 */
public interface PaperService {
    int addPaper(Paper paper);

    int deletePaperById(long id);

    int updatePaper(Paper paper);

    Paper queryById(long id);

    List<Paper> queryAllPaper();
}
