package com.noint.shelterzoo.domain.abandoned.vo.res;

import lombok.Data;

@Data
public class AbandonedListResponseVO {
    private long seq;
    private String thumbnail;
    private String kind;
    private String kindDetail;
    private String birth;
    private String gender;
    private String neuter;
    private String noticeEnd;
    private boolean isPin;
}
