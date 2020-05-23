package com.cn.monitoring.computer.memory;

import com.cn.monitoring.computer.memory.service.MemoryService;
import org.springframework.web.bind.annotation.*;

/**
 * 电脑内存controller
 */

@RestController
@RequestMapping("/memory/")
public class MemoryController {

    private MemoryService memoryService;

    @RequestMapping(value = "test",method = RequestMethod.GET)
    public String testMemory(){
        return  "ok";
    }

    @PostMapping(value = "testPost")
    @ResponseBody
    public String testPost(){
        return  "ok";
    }

    @GetMapping(value = "execCmdInLinux/{name}")
    public String execCmdInLinux(String cmd){
        return memoryService.executeCmd(cmd);
    }


}
