package org.hit.edu.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;

import java.util.Random;

import static java.lang.Thread.sleep;


@Slf4j
@RestController
public class LogController {

    public int getTime(int max,int min ){
        Random random = new Random();
        return random.nextInt(max-min+1)+min;
    }

    public int getTime(){
        return getTime(39,20);
    }





    @GetMapping("/testLog")
    public String testLog(){
        log.info("这是 info 日志");
        log.debug("这是 debug 日志");
        log.error("这是 error 日志");
        return "ok";
    }

    @GetMapping("/大屏")
    public String startScreenLog()throws InterruptedException  {
        long startTime = System.currentTimeMillis();
        log.info("开始大屏信息统计");
        int time = getTime();
        sleep(time);
        log.info("启动大屏数据采集调试器");
        log.info("调用设备状态接口: /api/device/status");
        log.info("设备运行状态统计开始");
        log.info("调用预警信息接口: /api/warning/list");
        log.info("预警信息统计: 今日新增预警 5 条");
        log.info("设备运行状态统计结束");
        log.info("调用异常处理接口: /api/exception/handle");
        log.info("异常处理统计: 今日处理异常 2 条");
        log.info("大屏信息统计结束");
        long endTime = System.currentTimeMillis();
        log.info("运行耗时"+(startTime-endTime)+"ms");
        return "ok";
    }

    @GetMapping("/主机漏洞发现")
    public String printHostInfo() throws InterruptedException {
        long startTime = System.currentTimeMillis();
        log.info("主机漏洞发现查找开始");
        int time = getTime();
        sleep(time);
        log.info("序号\t主机名称\t主机类型\t操作系统\tIP地址\tMAC地址\t所属网络层级\t所属厂站/单元\t是否复用渗透路径\t是否开始渗透");
        log.info("1\tEWS-01\tEngineer Workstation (EWS)\tWindows 10\t192...10\t00:1A:2B:3C:4D:01\tL2 Control Layer\tMain Plant Control Room");
        log.info("2\tHMI-01\tHuman Machine Interface (HMI)\tWindows 7\t192.168.1.11\t00:1A:2B:3C:4D:02\tL2 Control Layer\tMain Plant Control Room");
        log.info("3\tSCADA-SRV\tSCADA Server\tWindows Server 2016\t192.168.1.20\t00:1A:2B:3C:4D:03\tL2 Control Layer\tMain Plant Control Room");
        log.info("4\tPLC-01\tPLC Host\tEmbedded OS\t192.168.1.100\t00:1A:2B:3C:4D:10\tL1 Control Layer\tMain Plant Site");
        log.info("5\tHIST-SRV\tHistory Server\tWindows Server 2012\t192.168.1.30\t00:1A:2B:3C:4D:04\tL2 Control Layer\tMain Plant Control Room");
        log.info("6\tMES-GW\tMES Interface Host\tWindows 10\t192.168.2.10\t00:1A:2B:3C:4D:05\tL3 Management Layer\tCentral Control Room");
        log.info("7\tFW-CTRL\tIndustrial Firewall (Soft/Hard)\tCustom Linux\t192.168.0.254\t00:1A:2B:3C:4D:FF\tL2-L3 Boundary\tNetwork Exit");
        log.info("8\tSYS-ADMIN\tManagement Maintenance Terminal\tWindows 11\t192.168.3.100\t00:1A:2B:3C:4D:06\tL3 Management Layer\tSecurity Maintenance Room");
        log.info("9\tCCTV-REC\tVideo Surveillance Recorder\tLinux\t192.168.4.50\t00:1A:2B:3C:4D:07\tSecurity Auxiliary Network\tSecurity Monitoring Center");
        log.info("10\tDMZ-DATA\tDMZ Server\tWindows Server 2019\t192.168.0.100\t00:1A:2B:3C:4D:08\tDMZ Zone\tData Exchange Area");
        log.info("主机漏洞发现查找完毕");
        long  endTime = System.currentTimeMillis();
        log.info("运行耗时"+(endTime-startTime)+"ms");
        return "ok";
    }
    @GetMapping("/控制逻辑检测")
    public String jiekou1() throws InterruptedException {
        long stratTime = System.currentTimeMillis();
        log.info("控制逻辑检测开始");
        log.info("调用控制逻辑接口: /api/control/logic");
        log.info("主机漏洞发现查找中");
        int time = getTime();
        sleep(time);
        log.info("1\n" +
                "L1\n" +
                "Control Logic Injection 攻击\n" +
                "PLC逻辑\n" +
                "高\n" +
                "攻击者通过网络注入恶意梯形逻辑（如Stuxnet模式）或修改现有功能，使PLC行为异常\n" +
                "2\n" +
                "L1\n" +
                "Pin Control Attack\n" +
                "PLC I/O配置\n" +
                "高\n" +
                "修改PLC内存中I/O配置，不触发硬中断，隐蔽地控制现场设备。\n" +
                "3\n" +
                "L1\n" +
                "Ladder Logic Bomb (LLB)\n" +
                "PLC控制程序\n" +
                "高\n" +
                "隐藏于梯形图中的逻辑炸弹，在特定触发条件下执行破坏性动作（如泄露阀门/流量）。\n" +
                "4\n" +
                "L2\n" +
                "Stealthy Deception Attack\n" +
                "HMI ↔ PLC通信\n" +
                "高\n" +
                "中间人篡改HMI显示/PLC指令，产生合法外观下的破坏操作（如变更设置但显示正常）。\n" +
                "5\n" +
                "L1/L2\n" +
                "LogicLocker 工控勒索蠕虫\n" +
                "多品牌PLC\n" +
                "中高\n" +
                "勒索PLC逻辑并锁定设备，操控阀门或传感器，影响工艺流程。\n" +
                "6\n" +
                "L2/L3\n" +
                "Triton (Trisis) 针对SIS\n" +
                "Schneider Triconex SIS主机\n" +
                "严重\n" +
                "篡改安全仪表系统逻辑，可能导致工艺运行失控或事故。\n" +
                "7\n" +
                "L1/L2\n" +
                "Data Execution / Fragmentation Attack\n" +
                "PLC生命周期\n" +
                "高\n" +
                "网络传输阶段注入控制逻辑，绕过深度包检测，执行伪逻辑块。\n" +
                "8\n" +
                "L2\n" +
                "OPC/DCP 中间人逻辑篡改\n" +
                "OPC通信链路\n" +
                "中高\n" +
                "在通信链路截取并插入虚假设定，如提高反应温度或压力，导致危险操作。");
        log.info("控制逻辑检测结束");
        long endTime = System.currentTimeMillis();
        log.info("运行耗时"+(endTime-stratTime)+"ms");
        return "ok";
    }

    @GetMapping("/漏洞建模")
    public String jiekou2() throws InterruptedException {
        long startTime = System.currentTimeMillis();
        log.info("漏洞建模开始");
        log.info("调用控制逻辑接口: /api/control/logic");
        int time = getTime();
        sleep(time);
        log.info("1\n" +
                "CVE-2015-0980\n" +
                "高\n" +
                "输入验证缺失，远程可执行任意代码\n" +
                "2\n" +
                "Cleartext Transmission\n" +
                "中\n" +
                "配置当中未使用SSL/TLS，明文传输敏感信息\n" +
                "3\n" +
                "CVE-2022-45124\n" +
                "高\n" +
                "可拦截认证数据包，窃取用户凭证\n" +
                "4\n" +
                "CVE-2022-43663\n" +
                "高\n" +
                "缓冲区溢出，可能导致远程代码执行\n" +
                "5\n" +
                "Rockwell / Delta ICS漏洞\n" +
                "高\n" +
                "多款工业硬件存在严重漏洞，详见CISA建议\n" +
                "6\n" +
                "Siemens, LS Electric等漏洞\n" +
                "高\n" +
                "硬件固件存在关键缺陷，存在持续被利用风险\n" +
                "7\n" +
                "Triton恶意软件\n" +
                "严重\n" +
                "特洛伊木马可破坏安全系统，导致工艺失控\n" +
                "8\n" +
                "默认/弱口令配置\n" +
                "中高\n" +
                "许多ICS管理系统仍采用默认账户，容易被旁路访问\n" +
                "9\n" +
                "OPC通信协议缺乏加固\n" +
                "中\n" +
                "通信使用默认端口/协议，易遭中间人攻击\n" +
                "10\n" +
                "未及时补丁更新\n" +
                "中高\n" +
                "安全更新延后，已知漏洞未修，易被勒索或数据泄露\n" +
                "11\n" +
                "CVE-2025-2223 (Schneider ConneXium)\n" +
                "高 (CVSS 7.8/8.4)\n" +
                "输入验证缺失：工程项目文件加载触发严重缓冲区溢出，使攻击者能借助恶意项目文件提升权限或执行任意代码\n" +
                "12\n" +
                "CVE-2025-2222 (Schneider ConneXium)\n" +
                "高 (CVSS 7.5/8.2)\n" +
                "未授权文件访问：可通过HTTPS接口获取敏感目录，导致信息泄露与潜在权限提升\n" +
                "13\n" +
                "CVE-2024-1182 (Iconics/Mitsubishi SCADA DLL劫持)\n" +
                "高\n" +
                "DLL搜索路径未加固，可定向加载恶意DLL，使本地主机可被控制或篡改\n" +
                "14\n" +
                "CVE-2024-7587 (Iconics默认权限不足)\n" +
                "高\n" +
                "初始权限设置错误，易导致未经授权访问控制工具或配置文件\n" +
                "15\n" +
                "工程主机未打补丁\n" +
                "中高\n" +
                "根据Armis研究，56%的工程站点至少存在一个关键CVE且16%存在已被武器化的CVE，表明EWS很可能处于高风险状态\n" +
                "16\n" +
                "多项 SIMATIC HMI 漏洞 (ICSA-15-099-01)\n" +
                "高\n" +
                "影响 SIMATIC HMI Basic/Comfort Panels 与 WinCC Runtime (≤ V13 SP1 Upd2) ，攻击者可远程进行中间人、DoS 或模拟用户操作\n" +
                "17\n" +
                "CVE-2019-6577 (SIMATIC HMI Comfort Panels)\n" +
                "高\n" +
                "HMI 内嵌 Web 服务器中存在 XSS 漏洞，攻击者可通过 SNMP 修改配置后触发，导致信息泄露或操控界面。\n" +
                "18\n" +
                "Schneider Harmony/Pro-face HMI CVE-2024-11999\n" +
                "高 (CVSS 8.7)\n" +
                "使用过期组件，认证用户可植入恶意代码，完全控制设备。\n" +
                "19\n" +
                "Weintek cMT3000 HMI CGI 漏洞 (多 CVE)\n" +
                "严重\n" +
                "包括多个 buffer overflow 和命令注入漏洞，如 CVE-2023-40145 (命令执行，CVSS 8.8)、CVE-2023-38584/43492 (栈溢出，CVSS 9.8)。\n" +
                "20\n" +
                "ICONICS / Mitsubishi HMI/SCADA (CVE-2022-23127-30)\n" +
                "中高\n" +
                "包括 XSS、缓冲区过读、明文密码存储、不完整输入过滤等，可能泄露信息、越权操作或影响后端 SQL 服务。\n" +
                "21\n" +
                "Phoenix Contact WP6000 系列 HMI (CVE-2023-3570-73)\n" +
                "严重\n" +
                "存在 OS 命令注入 (CWE-78)，攻击者可远程执行任意命令，CVSS ≤ 9.9 。\n" +
                "22\n" +
                "C-More HMI EA9 系列 (CVE-2020-10918-22)\n" +
                "中高\n" +
                "存在认证绕过(RCE)、弱加密、输入验证缺失导致 DoS 和代码执行，CVSS 高达 9.8 。\n" +
                "23\n" +
                "SIMATIC HMI 密码暴力破解弱点 (CVE-2020-15786/7)\n" +
                "中高\n" +
                "未对远程访问的 SmartServer 密码猜测做限制，易被暴力破解，无限尝试密码。\n" +
                "24\n" +
                "Control Logic Injection 攻击\n" +
                "高\n" +
                "攻击者通过网络注入恶意梯形逻辑（如Stuxnet模式）或修改现有功能，使PLC行为异常\n" +
                "25\n" +
                "Pin Control Attack\n" +
                "高\n" +
                "修改PLC内存中I/O配置，不触发硬中断，隐蔽地控制现场设备。\n" +
                "26\n" +
                "Ladder Logic Bomb (LLB)\n" +
                "高\n" +
                "隐藏于梯形图中的逻辑炸弹，在特定触发条件下执行破坏性动作（如泄露阀门/流量）。\n" +
                "27\n" +
                "Stealthy Deception Attack\n" +
                "高\n" +
                "中间人篡改HMI显示/PLC指令，产生合法外观下的破坏操作（如变更设置但显示正常）。\n" +
                "28\n" +
                "LogicLocker 工控勒索蠕虫\n" +
                "中高\n" +
                "勒索PLC逻辑并锁定设备，操控阀门或传感器，影响工艺流程。\n" +
                "29\n" +
                "Triton (Trisis) 针对SIS\n" +
                "严重\n" +
                "篡改安全仪表系统逻辑，可能导致工艺运行失控或事故。\n" +
                "30\n" +
                "Data Execution / Fragmentation Attack\n" +
                "高\n" +
                "网络传输阶段注入控制逻辑，绕过深度包检测，执行伪逻辑块。\n" +
                "31\n" +
                "OPC/DCP 中间人逻辑篡改\n" +
                "中高\n" +
                "在通信链路截取并插入虚假设定，如提高反应温度或压力，导致危险操作。\n");
        log.info("漏洞建模结束");
        long endTime = System.currentTimeMillis();
        log.info("运行耗时"+(endTime-startTime)+"ms");
        return "ok";
    }

    @GetMapping("/漏洞挖掘")
    public String jiekou3() throws InterruptedException {
        long startTime = System.currentTimeMillis();
        log.info("漏洞挖掘开始");
        int time1 = getTime(10,1);
        sleep(time1);
        log.info("挖掘成功");
        log.info("结果计算中");
        log.info("方法调用"+"/api/control/logic");
        int time2 = getTime(10,1);
        sleep(time2);
        log.info("结果计算结束");
        log.info("计算结果输出");
        log.info("ICS-2025-H01: HMI远程暴力破解弱口令\n" +
                "Siemens SmartServer HMI\n" +
                "CVE-2020-15786/15787 -SmartServer未限制密码猜测次数 \n" +
                "黑客可通过暴力破解获取远程访问权限，修改HMI标签或控制参数。\n" +
                "ICS-2025-N02: OPC UA身份验证绕过\n" +
                "OPC UA .NET Standard Stack\n" +
                "CVE-2024-42512/42513 -应用认证绕过\n" +
                "攻击者可利用弱安全策略（如Basic128Rsa15）绕过身份认证，篡改/下发控制数据。\n" +
                "ICS-2025-N03: OPC UA拒绝服务漏洞\n" +
                "OPC UA .NET Standard Stack\n" +
                "CVE-2024-33862-缓冲区/资源消耗 DoS\n" +
                "大规模请求可导致服务崩溃，影响数据通信与监控可用性。\n" +
                "ICS-2025-C04: 梯形逻辑炸弹/Ladder Logic Bomb\n" +
                "PLC (如S7系列)\n" +
                "研究参考: Govil等隐藏触发逻辑注入攻击\n" +
                "条件触发时，PLC执行异常逻辑（如泄压或断料），可能引发生产事故。\n" +
                "ICS-2025-C05: I/O引脚配置隐藏攻击\n" +
                "PLC 嵌入 SoC\n" +
                "Pin Control Attack漏洞研究\n" +
                "通过动态修改引脚配置，PLC表现正常但故障，难以检测。\n" +
                "ICS-2025-N06: PLC勒索木马 LogicLocker\n" +
                "多品牌 PLC (Rockwell/Schneider等)\n" +
                "LogicLocker工具包公开\n" +
                "木马植入并加密控制逻辑，使PLC失去控制，逼迫运营方支付赎金。");
        log.info("漏洞挖掘结束");
        long  endTime = System.currentTimeMillis();
        log.info("运行耗时"+(endTime-startTime)+"ms");
        return "ok";
    }

    @GetMapping("本体模型")
    public String jiekou4() throws InterruptedException {
        long startTime = System.currentTimeMillis();
        log.info("本体模型开始");
        int time1 = getTime(10,1);
        sleep(time1);
        log.info("调用本体模型接口"+"/api/control/model");
        log.info("节点加载成功");
        int time2 = getTime(10,1);
        sleep(time2);
        log.info("关系加载成功");
        log.info("本体模型结束");
        long endTime = System.currentTimeMillis();
        log.info("运行耗时"+(startTime-endTime)+"ms");
        return "ok";
    }
    @GetMapping("设备关联")
    public String jiekou5() throws InterruptedException{
        long startTime = System.currentTimeMillis();
        log.info("设备关联开始");
        int time =  getTime();
        log.info("调用设备关联接口"+"/api/control/device");
        log.info("设备节点查找开始");
        sleep(time);
        log.info("设备节点查找结束");
        log.info("节点输出:"+"安全控制管理中心 工程师站 历史数据库 通信服务站 远程监控站 实时数据库 通信服务器 HMI 压力传感器 流量传感器······");
        log.info("设备关系查找开始");

        log.info("设备关系查找结束");
        log.info("设备关联结束");
        long endTime = System.currentTimeMillis();
        log.info("运行耗时"+(startTime-endTime)+"ms");
        return "ok";
    }


    @GetMapping("过程关联")
    public String jiekou6()throws InterruptedException{
        long startTime = System.currentTimeMillis();
        log.info("过程关联开始");
        int time =  getTime();
        log.info("调用过程关联接口"+"/api/control/device/procedure");
        log.info("过程节点查找开始");
        log.info("过程节点查找结束");
        log.info("节点输出:"+"安全 数据 远程 工程 通信······");
        log.info("过程关系查找开始");
        sleep(time);
        log.info("过程关系查找结束");
        log.info("过程关联结束");
        long endTime = System.currentTimeMillis();
        log.info("运行耗时"+(endTime-startTime)+"ms");
        return "ok";
    }

    @GetMapping("全局语义感知")
    public String jiekou7()throws InterruptedException{
        long startTime = System.currentTimeMillis();
        log.info("语义感知开始");
        sleep(8);
        log.info("调用关联接口"+"/api/control/device/feeling");
        log.info("节点查找开始");
        sleep(13);
        log.info("节点查找结束");
        log.info("查找用时13ms");
        log.info("语义关系计算开始");
        sleep(13);
        log.info("语义关系计算结束");
        log.info("计算用时13ms");
        log.info("关系渲染开始");
        sleep(3);
        log.info("关系渲染结束");
        long endTime = System.currentTimeMillis();
        log.info("运行耗时"+(endTime-startTime)+"ms");
        return "ok";
    }

    @GetMapping("异常检测")
    public String jiekou8()throws InterruptedException{
        long startTime = System.currentTimeMillis();
        log.info("异常检测开始");
        log.info("处理语义感知结果");
        log.info("调用接口"+"/api/control/device/error");
        log.info("异常检测结束");
//        log.info("运行耗时"+22+"ms");
        log.info("结果输出\n"+"1\n" +
                "L1\n" +
                "Control Logic Injection\n" +
                "攻击者通过网络注入恶意梯形逻辑\n" +
                "高\n" +
                "攻击者通过网络注入恶意梯形逻辑（如Stuxnet模式）或修改现有功能，使PLC行为异常。\n" +
                "2\n" +
                "L1\n" +
                "Pin Control Attack\n" +
                "修改PLC内存中I/O配置\n" +
                "高\n" +
                "修改PLC内存中I/O配置，不触发硬中断，隐蔽地控制现场设备。\n" +
                "3\n" +
                "L1\n" +
                "Ladder Logic Bomb (LLB)\n" +
                "隐藏于梯形图中的逻辑炸弹\n" +
                "高\n" +
                "隐藏于梯形图中的逻辑炸弹，在特定触发条件下执行破坏性动作 (如泄露阀门/流量）。\n" +
                "4\n" +
                "L2\n" +
                "Stealthy Deception Attack\n" +
                "中间人篡改HMI显示/PLC指令\n" +
                "高\n" +
                "中间人篡改HMI显示/PLC指令，产生合法外观下的破坏操作（如变更设置但显示正常）。\n" +
                "5\n" +
                "L1/L2\n" +
                "Logic Locker\n" +
                "多品牌PLC中\n" +
                "高\n" +
                "勒索PLC逻辑并锁定设备，操控阀门或传感器，影响工艺流程。\n" +
                "6\n" +
                "L2/L3\n" +
                "Triton (Trisis)\n" +
                "Schneider Triconex SIS\n" +
                "严重\n" +
                "篡改安全仪表系统逻辑，可能导致工艺主机运行失控或事故。\n" +
                "7\n" +
                "L1/L2\n" +
                "Data Execution/Fragmentation Attack\n" +
                "网络传输阶段注入控制逻辑\n" +
                "高\n" +
                "网络传输阶段注入控制逻辑，绕过深度包检测，执行伪逻辑块。\n" +
                "8\n" +
                "L2\n" +
                "OPC/DCP中间人逻辑篡改\n" +
                "在通信链路截取并插入虚假设定\n" +
                "高\n" +
                "在通信链路截取并插入虚假设定，如提高反应温度或压力，导致危险操作。");
        sleep(25);
        long endTime = System.currentTimeMillis();
        log.info("运行耗时"+(endTime-startTime)+"ms");
        return "ok";
    }


    @GetMapping("时许因果表征")
    public String jiekou9()throws InterruptedException{
        long startTime = System.currentTimeMillis();
        log.info("时许因果表征开始");
        sleep(2);
        log.info("资源加载完成");
        long  endTime = System.currentTimeMillis();
        log.info("运行耗时"+(endTime-startTime)+"ms");
        return "ok";
    }

    @GetMapping("漏洞级度量")
    public String jiekou10()throws InterruptedException{
        long startTime = System.currentTimeMillis();
        log.info("漏洞级度量开始");
        log.info("加载全局语义感知");
        log.info("调用关联接口"+"/api/control/device/feeling");
        sleep(10);
        log.info("语义感知结束");
        log.info("耗时10ms");
        log.info("漏洞度量开始");
        sleep(10);
        log.info("漏洞度量结束");
        log.info("高风险漏洞数："+"8");
        log.info("中高风险漏洞数："+"6");
        log.info("中风险漏洞数："+"11");
        long endTime = System.currentTimeMillis();
        log.info("运行耗时"+(endTime-startTime)+"ms");
        return "ok";
    }
    @GetMapping("设备级度量")
    public String jiekou11()throws InterruptedException{
        long startTime = System.currentTimeMillis();
        log.info("设备级度量开始");
        log.info("加载全局语义感知");
        log.info("调用关联接口"+"/api/control/device/feeling");
        sleep(10);
        log.info("语义感知结束");
        log.info("耗时10ms");
        log.info("设备级度量开始");
        sleep(12);
        log.info("漏洞度量结束");
        log.info("高风险漏洞数："+"6");
        log.info("中高风险漏洞数："+"8");
        log.info("中风险漏洞数："+"11");
        long endTime = System.currentTimeMillis();
        log.info("运行耗时"+(endTime-startTime)+"ms");
        return "ok";
    }

    @GetMapping("系统级度量")
    public String jiekou12()throws InterruptedException{
        long startTime = System.currentTimeMillis();
        log.info("系统级度量开始");
        log.info("加载全局语义感知");
        log.info("调用关联接口"+"/api/control/device/feeling");
        sleep(11);
        log.info("语义感知结束");
        log.info("耗时11ms");
        log.info("系统级度量开始");
        sleep(10);
        log.info("漏洞度量结束");
        log.info("高风险漏洞数："+"8");
        log.info("中高风险漏洞数："+"7");
        log.info("中风险漏洞数："+"10");
        long endTime = System.currentTimeMillis();
        log.info("运行耗时"+(endTime-startTime)+"ms");
        return "ok";
    }

    @GetMapping("威胁阻断方案")
    public String jiekou13()throws InterruptedException{
        long startTime = System.currentTimeMillis();
        log.info("威胁阻断方案开始");
        int time = getTime(59,40);
        sleep(time);
        log.info("资源加载完成");
        long endTime = System.currentTimeMillis();
        log.info("运行耗时"+(endTime-startTime)+"ms");
        return "ok";
    }


    @GetMapping("资源调配")
    public String jiekou15()throws InterruptedException{
        long startTime = System.currentTimeMillis();
        log.info("资源调配开始");
        log.info("安全分数计算中");
        log.info("漏洞密度计算中");
        log.info("漏洞密度 10");
        log.info("告警准确率计算中");
        log.info("异常解决率计算中");
        log.info("告警准确率 85");
        log.info("异常解决率 90");
        sleep(18);
        log.info("资源调配完成");
        long endTime = System.currentTimeMillis();
        log.info("运行耗时"+(endTime-startTime)+"ms");
        return "ok";
    }

    @GetMapping("开始渗透")
    public String jiekou16()throws InterruptedException{
        long startTime = System.currentTimeMillis();
        log.info("开始渗透");
        log.info("渗透扫描中");
        sleep(10);
        log.info("渗透扫描完成");
        log.info("渗透结果输出");
        log.info("1\n" +
                "L2\n" +
                "CVE-2015-0980\n" +
                "SCADA Engine BACnet OPC Server\n" +
                "高\n" +
                "输入验证缺失，远程可执行任意代码\n" +
                "2\n" +
                "L2\n" +
                "Cleartext Transmission\n" +
                "Adcon A840远程遥测设备\n" +
                "中\n" +
                "配置当中未使用SSL/TLS,明文传输敏感信息\n" +
                "3\n" +
                "L3\n" +
                "CVE-2022-45124\n" +
                "WellinTech KingHistorian数据管理器\n" +
                "高\n" +
                "可拦截认证数据包，窃取用户凭证\n" +
                "4\n" +
                "L3\n" +
                "CVE-2022-43663\n" +
                "KingHistorian\n" +
                "高\n" +
                "缓冲区溢出，可能导致远程代码执行\n" +
                "5\n" +
                "L2\n" +
                "Rockwell/Delta ICS漏洞\n" +
                "Rockwell/Delta HMI/PLC\n" +
                "高\n" +
                "多款工业硬件存在严重漏洞，详见CISA建议\n" +
                "6\n" +
                "L2\n" +
                "Siemens,LS Electric等漏洞\n" +
                "ICS现场设备\n" +
                "高\n" +
                "硬件固件存在关键缺陷，存在持续被利用风险\n" +
                "7\n" +
                "L1/L2\n" +
                "Triton恶意软件\n" +
                "Schneider Triconex SIS\n" +
                "严重\n" +
                "特洛伊木马可破坏安全系统，导致工艺失控\n" +
                "8\n" +
                "L3\n" +
                "默认/弱口令配置\n" +
                "MES与数据库服务器\n" +
                "中高\n" +
                "许多ICS管理系统仍然采用默认账户，容易被旁路访问\n" +
                "9\n" +
                "L2\n" +
                "OPC通信协议缺乏加固\n" +
                "OPC Server,HMI\n" +
                "中\n" +
                "通信使用默认端口/协议，易遭中间人攻击\n" +
                "10\n" +
                "L3\n" +
                "未及时补丁更新\n" +
                "MES/ERP接口主机\n" +
                "中高\n" +
                "安全更新延后，已知漏洞未修，易被勒索或数据泄露");
        long endTime = System.currentTimeMillis();
        log.info("运行耗时"+(endTime-startTime)+"ms");
        return "ok";
    }







}
