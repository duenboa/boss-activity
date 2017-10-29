package com.boa.entity;

import java.util.Date;

public class TPriceConfig {

    /**
     * 主键
     */
    private Long id;
    /**
     * 创建时间
     */
    private Date createAt;
    /**
     * 更新时间
     */
    private Date updateAt;
    /**
     * 中奖等级
     */
    private Integer level;
    /**
     * 中奖概率 整数,百分比
     */
    private Integer probability;
    /**
     * 中奖描述
     */
    private String description;
    /**
     * 删除状态 0)未删除, 1)已删除
     */
    private Integer deleted;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getCreateAt() {
        return createAt;
    }

    public void setCreateAt(Date createAt) {
        this.createAt = createAt;
    }

    public Date getUpdateAt() {
        return updateAt;
    }

    public void setUpdateAt(Date updateAt) {
        this.updateAt = updateAt;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public Integer getProbability() {
        return probability;
    }

    public void setProbability(Integer probability) {
        this.probability = probability;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getDeleted() {
        return deleted;
    }

    public void setDeleted(Integer deleted) {
        this.deleted = deleted;
    }

    @Override
    public String toString() {
        return "TPriceConfig{" +
                "id=" + id +
                ", createAt=" + createAt +
                ", updateAt=" + updateAt +
                ", level='" + level + "\'" +
                ", probability=" + probability +
                ", description='" + description + "\'" +
                ", deleted=" + deleted +
                "}";
    }
}