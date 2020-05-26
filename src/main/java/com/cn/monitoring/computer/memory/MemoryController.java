package com.cn.monitoring.computer.memory;

import com.cn.monitoring.computer.memory.dao.model.User;
import com.cn.monitoring.computer.memory.service.MemoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 电脑内存controller
 */

@RestController
@RequestMapping("/memory/")
public class MemoryController {

    @Autowired
    private MemoryService memoryService;

    @RequestMapping(value = "test",method = RequestMethod.GET)
    public String testMemory(){
        return  "ok";
    }

    @PostMapping(value = "testPost")
    @ResponseBody
    public String testPost(){
        return  "ok2222";
    }

    @GetMapping(value = "execCmdInLinux/{cmd}")
    public String execCmdInLinux(String cmd){
        return memoryService.executeCmd(cmd);
    }

    @GetMapping(value = "selectUserByUuid/{cmd}")
    public String selectUserByUuid(@PathVariable  int cmd){
        User user = memoryService.selectUserByUuid(cmd);
        return user.toString();
    }


}
