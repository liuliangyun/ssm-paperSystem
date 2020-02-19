package com.pojo;

import lombok.Getter;
import lombok.Setter;

/**
 * 定义普通Java对象
 */
@Getter
@Setter
public class Paper {
    private long paperId;
    private String paperName;
    private int paperNum;
    private String paperDetail;
}
