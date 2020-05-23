package com.cn.monitoring.computer.memory.serviceImpl;

import ch.ethz.ssh2.Connection;
import com.alibaba.fastjson.JSONObject;
import com.cn.monitoring.computer.memory.service.MemoryService;
import com.cn.util.RemoteCommandUtil;
import org.springframework.web.bind.annotation.PathVariable;

public class MemoryServiceImpl implements MemoryService {

   private String ip = "10.10.133.14";
   private int port = 22;
   private String userName = "root";
   private String userPwd = "css123123";
   private JSONObject jsonObject;
   public MemoryServiceImpl(){
       jsonObject = new JSONObject();
   }

    @Override
    public String executeCmd(@PathVariable String cmd) {
        String result = jsonObject.toString();
        //创建连接
        Connection connection = RemoteCommandUtil.login(ip, port, userName, userPwd);
        if(connection == null)
            return  result;
        String executeResult = RemoteCommandUtil.execute(connection, cmd);

        return result;
    }
}
