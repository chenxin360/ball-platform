package com.zshnb.ballplatform.entity;

import com.baomidou.mybatisplus.extension.activerecord.Model;
import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author zsh
 * @since 2020-04-27
 */
public class Coach extends Model<Coach> {

    private static final long serialVersionUID = 1L;

    private Integer id;

    private String name;

    private String sportItem;

    private String sportLevel;

    private Double price;

    private String description;

    private Integer credit;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public String getSportItem() {
        return sportItem;
    }

    public void setSportItem(String sportItem) {
        this.sportItem = sportItem;
    }
    public String getSportLevel() {
        return sportLevel;
    }

    public void setSportLevel(String sportLevel) {
        this.sportLevel = sportLevel;
    }
    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    public Integer getCredit() {
        return credit;
    }

    public void setCredit(Integer credit) {
        this.credit = credit;
    }

    @Override
    protected Serializable pkVal() {
        return null;
    }

    @Override
    public String toString() {
        return "Coach{" +
            "id=" + id +
            ", name=" + name +
            ", sportItem=" + sportItem +
            ", sportLevel=" + sportLevel +
            ", price=" + price +
            ", description=" + description +
            ", credit=" + credit +
        "}";
    }
}
