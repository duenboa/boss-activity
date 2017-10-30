package com.boa.entity;

import java.util.Date;

public class TAdmin{

    /** 主键 */
    private Long id;
    /** 创建时间 */
    private Date createAt;
    /** 更新时间 */
    private Date updateAt;
    /** 用户名 */
    private String username;
    /** 密码 */
    private String password;
    /** 删除状态 0)未删除, 1)已删除 */
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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getDeleted() {
        return deleted;
    }

    public void setDeleted(Integer deleted) {
        this.deleted = deleted;
    }

    @Override
    public String toString() {
        return "TAdmin{" +
                    "id=" + id +
                    ", createAt=" + createAt +
                    ", updateAt=" + updateAt +
                    ", username='" + username + "\'" +
                    ", password='" + password + "\'" +
                    ", deleted=" + deleted +
                    "}";
    }
}