package com.zshnb.ballplatform.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author zsh
 * @since 2020-04-28
 */
public class Companion extends Model<Companion> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    private Integer sportItemId;

    private String sportLevel;

    private Integer sportSiteId;

    private String sex;

    private LocalDateTime time;

    private Integer userId;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    public Integer getSportItemId() {
        return sportItemId;
    }

    public void setSportItemId(Integer sportItemId) {
        this.sportItemId = sportItemId;
    }
    public String getSportLevel() {
        return sportLevel;
    }

    public void setSportLevel(String sportLevel) {
        this.sportLevel = sportLevel;
    }
    public Integer getSportSiteId() {
        return sportSiteId;
    }

    public void setSportSiteId(Integer sportSiteId) {
        this.sportSiteId = sportSiteId;
    }
    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }
    public LocalDateTime getTime() {
        return time;
    }

    public void setTime(LocalDateTime time) {
        this.time = time;
    }

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

    @Override
    public String toString() {
        return "Companion{" +
            "id=" + id +
            ", sportItemId=" + sportItemId +
            ", sportLevel=" + sportLevel +
            ", sportSiteId=" + sportSiteId +
            ", sex=" + sex +
            ", time=" + time +
        "}";
    }
}
