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
public class SportTrack extends Model<SportTrack> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    private Integer userId;

    private String sportItem;

    private Integer sportTime;

    private String afterStatus;

    private Integer afterWeight;

    private String sleepStatus;

    private LocalDateTime createAt = LocalDateTime.now();

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }
    public String getSportItem() {
        return sportItem;
    }

    public void setSportItem(String sportItem) {
        this.sportItem = sportItem;
    }
    public Integer getSportTime() {
        return sportTime;
    }

    public void setSportTime(Integer sportTime) {
        this.sportTime = sportTime;
    }
    public String getAfterStatus() {
        return afterStatus;
    }

    public void setAfterStatus(String afterStatus) {
        this.afterStatus = afterStatus;
    }
    public Integer getAfterWeight() {
        return afterWeight;
    }

    public void setAfterWeight(Integer afterWeight) {
        this.afterWeight = afterWeight;
    }
    public String getSleepStatus() {
        return sleepStatus;
    }

    public void setSleepStatus(String sleepStatus) {
        this.sleepStatus = sleepStatus;
    }
    public LocalDateTime getCreateAt() {
        return createAt;
    }

    public void setCreateAt(LocalDateTime createAt) {
        this.createAt = createAt;
    }

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

    @Override
    public String toString() {
        return "SportTrack{" +
            "id=" + id +
            ", userId=" + userId +
            ", sportItem=" + sportItem +
            ", sportTime=" + sportTime +
            ", afterStatus=" + afterStatus +
            ", afterWeight=" + afterWeight +
            ", sleepStatus=" + sleepStatus +
            ", createAt=" + createAt +
        "}";
    }
}
