package com.cn.monitoring.computer.memory.service;

import org.springframework.stereotype.Service;

@Service
public interface MemoryService {

    public String executeCmd(String cmd);
}
