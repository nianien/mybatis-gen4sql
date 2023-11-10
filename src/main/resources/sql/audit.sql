-- -- noinspection SqlNoDataSourceInspectionForFile
-- -- (.*)(<.*>)(.*),  ==> $1$3 COMMENT'$2',
CREATE SCHEMA IF NOT EXISTS `audit`;
SET SCHEMA `audit`;

CREATE TABLE `user_audit`
(
    `userid`        bigint      NOT NULL COMMENT '用户ID',
    `name`          varchar(64) NOT NULL COMMENT '用户名',
    `audit_state`   int         NOT NULL DEFAULT '5' COMMENT '审核状态，0表示审核通过，1表示审核中，2表示审核拒绝，5待提交至审核(搁置)',
    `auditor_id`    bigint      NOT NULL DEFAULT '-1' COMMENT '审核员id',
    `reason_code`   varchar(256)         DEFAULT NULL COMMENT '拒绝理由',
    `refuse_reason` varchar(1024)        DEFAULT NULL COMMENT '拒绝原因',
    `env`           varchar(8)  NOT NULL DEFAULT '' COMMENT '环境标',
    PRIMARY KEY (`userid`)
) /*ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户审核表'*/ ;
COMMENT ON TABLE `user_audit` IS '用户审核表';
