package com.cn.monitoring.computer.memory.service;


import com.cn.monitoring.computer.memory.dao.model.User;

public interface MemoryService {

    public String executeCmd(String cmd);

    public User selectUserByUuid(int uuid);
}
