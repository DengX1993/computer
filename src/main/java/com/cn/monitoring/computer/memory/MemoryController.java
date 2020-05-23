package com.cn.monitoring.computer.memory;

import com.cn.monitoring.computer.memory.service.MemoryService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import sun.util.logging.resources.logging;

/**
 * 电脑内存controller
 */

@RestController
@RequestMapping("/memory")
public class MemoryController {

    private MemoryService memoryService;

    @RequestMapping(value = "/test",method = RequestMethod.GET)
    public String testMemory(){
        return  "ok";
    }

    public String execCmdInLinux(String cmd){
        return memoryService.executeCmd(cmd);
    }


}
