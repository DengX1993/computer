package com.cn.monitoring.computer.memory.dao.mapper;

import com.cn.monitoring.computer.memory.dao.model.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserMapper {

    User selectUserByUuid(int uuid);
}
