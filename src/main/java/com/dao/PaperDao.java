package com.dao;

import com.pojo.Paper;

import java.util.List;

/**
 * 数据库层接口：定义增删改查方法
 */
public interface PaperDao {
    int addPaper(Paper paper);

    int deletePaperById(long id);

    int updatePaper(Paper paper);

    Paper queryById(long id);

    List<Paper> queryAllPaper();
}
