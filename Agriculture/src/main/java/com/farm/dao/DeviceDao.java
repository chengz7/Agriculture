package com.farm.dao;
import com.farm.entity.ControlFrame;
import org.springframework.stereotype.Repository;
/**
 * @Author: Rain
 * @Description:
 * @Date: Created on 2019-05-07 14:44
 */
@Repository
public interface DeviceDao {
    ControlFrame findFrameById(Integer frameId);
}
