package com.cn.monitoring.computer.memory;

import com.sun.javafx.tools.packager.Log;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sun.util.logging.resources.logging;

/**
 * 电脑内存controller
 */

@RestController
@RequestMapping("/memory")
public class memoryController {

    @RequestMapping("test")
    public String testMemory(){
        return  "oks";
    }
}
