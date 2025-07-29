package log_modules.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import java.io.IOException;
import java.util.Random;

@Slf4j
public class LogWebSocketHandler extends TextWebSocketHandler {
    
    private Random random = new Random();
    
    private int getTime(int max, int min) {
        return random.nextInt(max - min + 1) + min;
    }
    
    private int getTime() {
        return getTime(39, 20);
    }

    private static LogController logController = new LogController();
    
    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage message) throws IOException, InterruptedException {


        String request = message.getPayload();
        
        switch (request) {
            case "/testLog":
                sendTestLog(session);
                break;
            case "/大屏":
                sendStartScreenLog(session);
                break;
            case "/主机漏洞发现":
                sendPrintHostInfo(session);
                break;
            case "/控制逻辑检测":
                sendJiekou1(session);
                break;
            case "/漏洞建模":
                sendJiekou2(session);
                break;
            case "/漏洞挖掘":
                sendJiekou3(session);
                break;
            case "本体模型":
                sendJiekou4(session);
                break;
            case "设备关联":
                sendJiekou5(session);
                break;
            case "过程关联":
                sendJiekou6(session);
                break;
            case "全局语义感知":
                sendJiekou7(session);
                break;
            case "异常检测":
                sendJiekou8(session);
                break;
            // 添加更多请求处理分支
            case "时许因果表征":
                sendJiekou9(session);
                break;
            case "漏洞级度量":
                sendJiekou10(session);
                break;
            case "设备级度量":
                sendJiekou11(session);
                break;
            case "系统级度量":
                sendJiekou12(session);
                break;
            case "威胁阻断方案":
                sendJiekou13(session);
                break;
            case "资源调配":
                sendJiekou15(session);
                break;
            case "开始渗透":
                sendJiekou16(session);
                break;
            default:
                session.sendMessage(new TextMessage("未知请求"));
        }
    }

    private void sendJiekou16(WebSocketSession session) throws InterruptedException, IOException {
        session.sendMessage(new TextMessage(logController.jiekou16()));
    }

    private void sendJiekou15(WebSocketSession session) throws InterruptedException, IOException {
        session.sendMessage(new TextMessage(logController.jiekou15()));
    }

    private void sendJiekou13(WebSocketSession session) throws IOException, InterruptedException {
        session.sendMessage(new TextMessage(logController.jiekou13()));
    }

    private void sendJiekou12(WebSocketSession session) throws IOException, InterruptedException {
        session.sendMessage(new TextMessage(logController.jiekou12()));
    }

    private void sendJiekou11(WebSocketSession session) throws IOException, InterruptedException {
        session.sendMessage(new TextMessage(logController.jiekou11()));
    }

    private void sendJiekou10(WebSocketSession session) throws InterruptedException, IOException {
        session.sendMessage(new TextMessage(logController.jiekou10()));
    }

    private void sendJiekou9(WebSocketSession session) throws InterruptedException, IOException {
        session.sendMessage(new TextMessage(logController.jiekou9()));
    }

    private void sendJiekou8(WebSocketSession session) throws InterruptedException, IOException {
        session.sendMessage(new TextMessage(logController.jiekou8()));
    }

    private void sendJiekou7(WebSocketSession session) throws InterruptedException, IOException {
        session.sendMessage(new TextMessage(logController.jiekou7()));
    }

    private void sendJiekou6(WebSocketSession session) throws InterruptedException, IOException {
        session.sendMessage(new TextMessage(logController.jiekou6()));
    }

    private void sendJiekou5(WebSocketSession session) throws InterruptedException, IOException {
        session.sendMessage(new TextMessage(logController.jiekou5()));
    }

    private void sendJiekou4(WebSocketSession session) throws InterruptedException, IOException {
        session.sendMessage(new TextMessage(logController.jiekou4()));
    }

    private void sendJiekou3(WebSocketSession session) throws IOException, InterruptedException {
        session.sendMessage(new TextMessage(logController.jiekou3()));
    }

    private void sendJiekou2(WebSocketSession session) throws IOException, InterruptedException {
        session.sendMessage(new TextMessage(logController.jiekou2()));
    }

    private void sendJiekou1(WebSocketSession session) throws IOException, InterruptedException {
        session.sendMessage(new TextMessage(logController.jiekou1()));
    }

    private void sendPrintHostInfo(WebSocketSession session) throws InterruptedException, IOException {
        session.sendMessage(new TextMessage(logController.printHostInfo()));
    }

    private void sendTestLog(WebSocketSession session) throws IOException {
        log.info("这是 info 日志");

        
        log.debug("这是 debug 日志");

        
        log.error("这是 error 日志");
        session.sendMessage(new TextMessage("这是 测试 日志"));
    }
    
    private void sendStartScreenLog(WebSocketSession session) throws IOException, InterruptedException {
        session.sendMessage(new TextMessage(logController.startScreenLog()));
    }


    
    // 为其他方法添加类似的 WebSocket 处理逻辑
    // ...
}