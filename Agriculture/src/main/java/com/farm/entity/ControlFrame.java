package com.farm.entity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
/**
 * @Author: Rain
 * @Description:
 * @Date: Created on 2019-05-04 21:54
 */
@Getter
@Setter
@NoArgsConstructor
@ToString
public class ControlFrame {
    private Integer id;
    //置1
    private String code1;
    //置0
    private String code0;
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getCode1() {
        return code1;
    }
    public void setCode1(String code1) {
        this.code1 = code1;
    }
    public String getCode0() {
        return code0;
    }
    public void setCode0(String code0) {
        this.code0 = code0;
    }
}
