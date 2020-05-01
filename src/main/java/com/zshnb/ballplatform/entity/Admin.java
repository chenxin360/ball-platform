package com.zshnb.ballplatform.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author zsh
 * @since 2020-05-01
 */
public class Admin extends Model<Admin> {

    private static final long serialVersionUID = 1L;

    private String username;

    private String password;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

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
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

    @Override
    public String toString() {
        return "Admin{" +
            "username=" + username +
            ", password=" + password +
            ", id=" + id +
        "}";
    }
}
