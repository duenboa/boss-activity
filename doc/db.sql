

CREATE TABLE t_order(
 id BIGINT(20) NOT NULL COMMENT '主键' AUTO_INCREMENT PRIMARY KEY,
 create_at DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间,即用户点击参与活动时间',
 update_at DATETIME ON UPDATE CURRENT_TIMESTAMP COMMENT '最后一次更新时间',
 phone BIGINT(20) NOT NULL COMMENT '电话',
 gift VARCHAR(20) NOT NULL COMMENT '奖品名称',
 state VARCHAR(20) NOT NULL DEFAULT 'browse' COMMENT 'browe)浏览, visit)入店, taked)已领取奖品, other)其他状态',
 visit_date DATETIME COMMENT '入店时间',
 taked_date DATETIME COMMENT '领取奖品时间',
 deleted TINYINT(1) COMMENT '删除状态 0)未删除, 1)已删除',
 KEY idx_phone (`phone`)
)ENGINE INNODB DEFAULT CHARSET 'utf8' COMMENT '活动表';
