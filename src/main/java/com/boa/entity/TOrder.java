package com.boa.entity;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class TOrder{

    /** 主键 */
    private Long id;
    /** 创建时间,即用户点击参与活动时间 */
    private Date createAt;
    /** 最后一次更新时间 */
    private Date updateAt;
    /** 电话 */
    private Long phone;
    /** 奖品等级 关联t_price_config.level */
    private Integer giftLevel;
    /** 奖品名称 */
    private String gift;
    /** browe)浏览, visit)入店, taked)已领取奖品, other)其他状态 */
    private String state;
    /** 入店时间 */
    private Date visitDate;
    /** 领取奖品时间 */
    private Date takedDate;
    /** 删除状态 0)未删除, 1)已删除 */
    private Integer deleted;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    public Date getCreateAt() {
        return createAt;
    }

    public void setCreateAt(Date createAt) {
        this.createAt = createAt;
    }

    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    public Date getUpdateAt() {
        return updateAt;
    }

    public void setUpdateAt(Date updateAt) {
        this.updateAt = updateAt;
    }

    public Long getPhone() {
        return phone;
    }

    public void setPhone(Long phone) {
        this.phone = phone;
    }

    public Integer getGiftLevel() {
        return giftLevel;
    }

    public void setGiftLevel(Integer giftLevel) {
        this.giftLevel = giftLevel;
    }

    public String getGift() {
        return gift;
    }

    public void setGift(String gift) {
        this.gift = gift;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    public Date getVisitDate() {
        return visitDate;
    }

    public void setVisitDate(Date visitDate) {
        this.visitDate = visitDate;
    }
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    public Date getTakedDate() {
        return takedDate;
    }

    public void setTakedDate(Date takedDate) {
        this.takedDate = takedDate;
    }

    public Integer getDeleted() {
        return deleted;
    }

    public void setDeleted(Integer deleted) {
        this.deleted = deleted;
    }

    @Override
    public String toString() {
        return "TOrder{" +
                    "id=" + id +
                    ", createAt=" + createAt +
                    ", updateAt=" + updateAt +
                    ", phone=" + phone +
                    ", giftLevel=" + giftLevel +
                    ", gift='" + gift + "\'" +
                    ", state='" + state + "\'" +
                    ", visitDate=" + visitDate +
                    ", takedDate=" + takedDate +
                    ", deleted=" + deleted +
                    "}";
    }
}