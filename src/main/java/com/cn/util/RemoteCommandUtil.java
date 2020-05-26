package com.cn.util;

import ch.ethz.ssh2.Connection;
import ch.ethz.ssh2.Session;
import ch.ethz.ssh2.StreamGobbler;
import com.alibaba.fastjson.JSONObject;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;


public class RemoteCommandUtil {

    private static final Logger log = LoggerFactory.getLogger(RemoteCommandUtil.class);
    private static String  DEFAULTCHART="UTF-8";

    public static void main(String[] args) {
        String ip = "10.10.133.14";
        int port = 22;
        String userName = "root";
        String userPwd = "css123123";

        String cmd = "top -bn 1 -i -c";
        Connection connection = login(ip,port,userName, userPwd);
        String result = execute(connection, cmd);
        System.out.println(result);
        connection.close();

    }


    /**
     * 登录
     * 成功返回true
     * 失败返回false
     */
    public static boolean checkConnection(String ip,int port,String userName,String userPwd){
        boolean result =false;
        Connection conn = null;
        try {
            conn = new Connection(ip,port);
            conn.connect();//连接
            result=conn.authenticateWithPassword(userName, userPwd);//认证
            if(result){
                return result;
            }
        } catch (IOException e) {
            log.error("=========登录失败========="+e.getMessage());
            e.printStackTrace();
        }
        conn.close();
        return result;
    }

    /**
     * ping + telnet 命令
     * @retur JSONObject {"ping":"1","telnet":"2"}
     */
    public static JSONObject checkNetwotk(String ip, int port,String userName,String userPwd){
        JSONObject result = null;
        //登录主机
        Connection con = login(ip, port, userName, userPwd);
        if(con!=null){
            result.put("ping", execute(con, "ping " + ip));
            result.put("telnet",execute(con,"telnet "+ip+port));
        }
        return result;
    }

    /**
     * 登录主机
     * @return
     *      登录成功返回Connection，否则返回null
     */
    public static Connection login(String ip,int port,String userName,String userPwd){

        boolean flg=false;
        Connection conn = null;
        try {
            conn = new Connection(ip,port);
            conn.connect();//连接
            flg=conn.authenticateWithPassword(userName, userPwd);//认证
            if(flg){
                log.info("=========登录成功========="+conn);
                return conn;
            }
        } catch (IOException e) {
            log.error("=========登录失败========="+e.getMessage());
            e.printStackTrace();
        }
        return conn;
    }

    /**
     * 远程执行shll脚本或者命令
     * @param cmd
     *      即将执行的命令
     * @return
     *      命令执行完后返回的结果值
     */
    public static String execute(Connection conn,String cmd){
        String result="";
        Session session = null;

        if(StringUtils.isBlank(cmd))
            return result;

        try {
            if(conn !=null){
                session= conn.openSession();//打开一个会话
                session.execCommand(cmd);//执行命令
                result=processStdout(session.getStdout(),DEFAULTCHART);
                //如果为得到标准输出为空，说明脚本执行出错了
                if(StringUtils.isBlank(result)){
                    log.info("得到标准输出为空,链接conn:"+conn+",执行的命令："+cmd);
                    result=processStdout(session.getStderr(),DEFAULTCHART);
                }else{
                    log.info("执行命令成功,链接conn:"+conn+",执行的命令："+cmd);
                }
            }
        } catch (IOException e) {
            log.info("执行命令失败,链接conn:"+conn+",执行的命令："+cmd+"  "+e.getMessage());
            e.printStackTrace();
        }finally {
            if(conn!=null)
                conn.close();
            if(session !=null)
                session.close();
        }
        return result;
    }
    /**
     * 解析脚本执行返回的结果集
     * @param in 输入流对象
     * @param charset 编码
     * @return
     *       以纯文本的格式返回
     */
    private static String processStdout(InputStream in, String charset) throws IOException {
        InputStream  stdout = new StreamGobbler(in);
        StringBuffer buffer = new StringBuffer();
        BufferedReader br = null;
        try {
            br = new BufferedReader(new InputStreamReader(stdout,charset));
            String line=null;
            while((line=br.readLine()) != null){
                if(line.length() > 0 && line != null)
                    buffer.append(line+";\n");
            }
        } catch (UnsupportedEncodingException e) {
            log.error("解析脚本出错："+e.getMessage());
            e.printStackTrace();
        } catch (IOException e) {
            log.error("解析脚本出错："+e.getMessage());
            e.printStackTrace();
        }finally {
            if(br!=null)
                br.close();
            stdout.close();
        }
        return buffer.toString();
    }
}
