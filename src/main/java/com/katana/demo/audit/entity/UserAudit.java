package com.katana.demo.audit.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;

/**
 * <p>
 * 用户审核表
 * </p>
 *
 * @author baomidou
 * @since 2023-11-10
 */
@TableName("AUDIT.USER_AUDIT")
public class UserAudit implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 用户ID
     */
    @TableId("USERID")
    private Long userid;

    /**
     * 用户名
     */
    private String name;

    /**
     * 审核状态，0表示审核通过，1表示审核中，2表示审核拒绝，5待提交至审核(搁置)
     */
    private Integer auditState;

    /**
     * 审核员id
     */
    private Long auditorId;

    /**
     * 拒绝理由
     */
    private String reasonCode;

    /**
     * 拒绝原因
     */
    private String refuseReason;

    /**
     * 环境标
     */
    private String env;

    public Long getUserid() {
        return userid;
    }

    public void setUserid(Long userid) {
        this.userid = userid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAuditState() {
        return auditState;
    }

    public void setAuditState(Integer auditState) {
        this.auditState = auditState;
    }

    public Long getAuditorId() {
        return auditorId;
    }

    public void setAuditorId(Long auditorId) {
        this.auditorId = auditorId;
    }

    public String getReasonCode() {
        return reasonCode;
    }

    public void setReasonCode(String reasonCode) {
        this.reasonCode = reasonCode;
    }

    public String getRefuseReason() {
        return refuseReason;
    }

    public void setRefuseReason(String refuseReason) {
        this.refuseReason = refuseReason;
    }

    public String getEnv() {
        return env;
    }

    public void setEnv(String env) {
        this.env = env;
    }

    @Override
    public String toString() {
        return "UserAudit{" +
        "userid = " + userid +
        ", name = " + name +
        ", auditState = " + auditState +
        ", auditorId = " + auditorId +
        ", reasonCode = " + reasonCode +
        ", refuseReason = " + refuseReason +
        ", env = " + env +
        "}";
    }
}
