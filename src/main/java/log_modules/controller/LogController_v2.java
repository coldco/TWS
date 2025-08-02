package log_modules.controller;

import log_modules.en.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

import static java.lang.Thread.sleep;


@Slf4j
@RestController
public class LogController_v2 {

    public int getTime(int max,int min ){
        Random random = new Random();
        return random.nextInt(max-min+1)+min;
    }

    public int getTime(){
        return getTime(29,10);
    }

    @GetMapping("/大屏")
    public String startScreenLog() throws InterruptedException {
        long startTime = System.currentTimeMillis();
        log.info("开始大屏信息统计");
        // 获取设备状态
        long deviceStatusStartTime = System.currentTimeMillis();
        List<DeviceStatus> deviceStatusList = fetchDeviceStatus();
        long deviceStatusEndTime = System.currentTimeMillis();
        log.info("获取设备状态耗时: {}ms", deviceStatusEndTime - deviceStatusStartTime);
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
        log.info("大屏信息统计耗时" + (endTime - startTime) + "ms");
        return "ok";
    }

    /**
     * 获取设备状态
     */
    public List<DeviceStatus> fetchDeviceStatus() {
        return Arrays.asList(new DeviceStatus("设备1", "运行中"), new DeviceStatus("设备2", "异常"));
    }

    @GetMapping("/主机漏洞发现")
    public String printHostInfo() throws InterruptedException {
        long startTime = System.currentTimeMillis();
        log.info("主机漏洞发现查找开始");

        // 查询主机列表
        long hostListStartTime = System.currentTimeMillis();
        List<HostInfo> hostList = getAllHosts();
        long hostListEndTime = System.currentTimeMillis();
        log.info("获取主机列表耗时: {}ms", hostListEndTime - hostListStartTime);

        int time = getTime();
        sleep(time);
        log.info("序号\t主机名称\t主机类型\t操作系统\tIP地址\tMAC地址\t所属网络层级\t所属厂站/单元\t是否复用渗透路径\t是否开始渗透");
        // 简化输出
        for (HostInfo host : hostList) {
            log.info(host.toString());
        }
        log.info("主机漏洞发现查找完毕");
        long endTime = System.currentTimeMillis();
        log.info("主机漏洞发现查找耗时" + (endTime - startTime) + "ms");
        return "ok";
    }

    /**
     * 获取所有主机信息
     */
    public List<HostInfo> getAllHosts() {
        return Arrays.asList(
                new HostInfo("EWS-01", "Windows 10", "192.168.0.10"),
                new HostInfo("PLC-01", "Embedded OS", "192.168.1.100")
        );
    }

    @GetMapping("/控制逻辑检测")
    public String jiekou1() throws InterruptedException {
        long startTime = System.currentTimeMillis();
        log.info("控制逻辑检测开始");
        log.info("调用控制逻辑接口: /api/control/logic");

        // 获取已识别攻击模式
        long patternsStartTime = System.currentTimeMillis();
        List<ControlAttackPattern> patterns = getControlLogicThreats();
        long patternsEndTime = System.currentTimeMillis();
        log.info("获取控制逻辑攻击模式耗时: {}ms", patternsEndTime - patternsStartTime);

        int time = getTime();
        sleep(time);
        for (ControlAttackPattern pattern : patterns) {
            log.info(pattern.toString());
        }
        log.info("控制逻辑检测结束");
        long endTime = System.currentTimeMillis();
        log.info("控制逻辑检测耗时" + (endTime - startTime) + "ms");
        return "ok";
    }

    /**
     * 获取控制逻辑攻击模式
     */
    public List<ControlAttackPattern> getControlLogicThreats() {
        return Arrays.asList(
                new ControlAttackPattern("LogicLocker", "PLC逻辑勒索"),
                new ControlAttackPattern("LLB", "梯形逻辑炸弹")
        );
    }

    @GetMapping("/漏洞建模")
    public String jiekou2() throws InterruptedException {
        long startTime = System.currentTimeMillis();
        log.info("漏洞建模开始");

        // 漏洞查询
        long vulnerabilityStartTime = System.currentTimeMillis();
        Vulnerability v = getVulnerabilityByCVE("CVE-2025-2223");
        long vulnerabilityEndTime = System.currentTimeMillis();
        log.info("获取漏洞信息耗时: {}ms", vulnerabilityEndTime - vulnerabilityStartTime);

        log.info("调用控制逻辑接口: /api/control/logic");
        int time = getTime();
        sleep(time);
        log.info(v.toString());
        log.info("漏洞建模结束");
        long endTime = System.currentTimeMillis();
        log.info("漏洞建模耗时" + (endTime - startTime) + "ms");
        return "ok";
    }

    /**
     * 获取漏洞信息
     */
    public Vulnerability getVulnerabilityByCVE(String cveId) {
        return new Vulnerability(cveId, "远程代码执行", "高");
    }

    @GetMapping("/漏洞挖掘")
    public String jiekou3() throws InterruptedException {
        long startTime = System.currentTimeMillis();
        log.info("漏洞挖掘开始");

        // 漏洞扫描模拟
        long discoveredStartTime = System.currentTimeMillis();
        List<DiscoveredVulnerability> discovered = discoverVulnerabilities(new SystemTarget("控制网络"));
        long discoveredEndTime = System.currentTimeMillis();
        log.info("漏洞扫描模拟耗时: {}ms", discoveredEndTime - discoveredStartTime);

        int time1 = getTime(10, 1);
        sleep(time1);
        log.info("挖掘成功");
        log.info("结果计算中");
        log.info("方法调用" + "/api/control/logic");

        int time2 = getTime(10, 1);
        sleep(time2);
        for (DiscoveredVulnerability v : discovered) {
            log.info(v.toString());
        }
        log.info("漏洞挖掘结束");
        long endTime = System.currentTimeMillis();
        log.info("漏洞挖掘耗时" + (endTime - startTime) + "ms");
        return "ok";
    }

    /**
     * 漏洞挖掘
     */
    public List<DiscoveredVulnerability> discoverVulnerabilities(SystemTarget target) {
        return Arrays.asList(new DiscoveredVulnerability("ICS-2025-H01", "HMI弱口令破解"));
    }

    @GetMapping("本体模型")
    public String jiekou4() throws InterruptedException {
        long startTime = System.currentTimeMillis();
        log.info("本体模型开始");

        // 加载本体模型
        long modelStartTime = System.currentTimeMillis();
        OntologyModel model = loadOntologyModel();
        long modelEndTime = System.currentTimeMillis();
        log.info("加载本体模型耗时: {}ms", modelEndTime - modelStartTime);

        int time1 = getTime(10, 1);
        sleep(time1);
        log.info("调用本体模型接口" + "/api/control/model");
        log.info("节点加载成功");

        int time2 = getTime(10, 1);
        sleep(time2);
        log.info("关系加载成功");
        log.info("本体模型结束");
        long endTime2 = System.currentTimeMillis();
        log.info("本体模型运行耗时" + (endTime2 - startTime) + "ms");
        return "ok";
    }

    /**
     * 加载本体模型
     */
    public OntologyModel loadOntologyModel() {
        return new OntologyModel("节点模型已加载", "关系图构建完成");
    }

    @GetMapping("设备关联")
    public String jiekou5() throws InterruptedException {
        long startTime = System.currentTimeMillis();
        log.info("设备关联开始");
        log.info("获取设备关联关系");
        // 获取设备关联关系
        long deviceMapStartTime = System.currentTimeMillis();
        Map<String, List<String>> deviceMap = getDeviceRelations();
        long deviceMapEndTime = System.currentTimeMillis();
        log.info("获取设备关联关系耗时: {}ms", deviceMapEndTime - deviceMapStartTime);

        int time = getTime();
        log.info("调用设备关联接口" + "/api/control/device");
        log.info("设备节点查找开始");
        sleep(time);
        log.info("设备节点查找结束");

        log.info("节点输出: " + deviceMap.keySet());
        log.info("设备关系查找开始");
        log.info("设备关系查找结束");
        log.info("设备关联结束");

        return "ok";
    }

    /**
     * 获取设备之间的关联
     */
    public Map<String, List<String>> getDeviceRelations() {
        Map<String, List<String>> map = new HashMap<>();
        map.put("HMI", Arrays.asList("PLC", "传感器"));
        return map;
    }

    @GetMapping("过程关联")
    public String jiekou6() throws InterruptedException {
        long startTime = System.currentTimeMillis();
        log.info("过程关联开始");
        log.info("加载过程模型");
        // 加载过程模型
        long nodesStartTime = System.currentTimeMillis();
        List<ProcedureNode> nodes = getProcedureNodes();
        long nodesEndTime = System.currentTimeMillis();
        log.info("加载过程模型耗时: {}ms", nodesEndTime - nodesStartTime);

        int time = getTime();
        log.info("调用过程关联接口" + "/api/control/device/procedure");
        log.info("过程节点查找开始");
        log.info("过程节点查找结束");
        log.info("节点输出:" + nodes);
        log.info("过程关系查找开始");
        sleep(time);
        log.info("过程关系查找结束");
        log.info("过程关联结束");

        return "ok";
    }

    public List<ProcedureNode> getProcedureNodes() {
        return Arrays.asList(new ProcedureNode("安全"), new ProcedureNode("工程"));
    }

    @GetMapping("全局语义感知")
    public String jiekou7() throws InterruptedException {
        long startTime = System.currentTimeMillis();
        log.info("语义感知开始");

        // 执行语义分析
        long resultStartTime = System.currentTimeMillis();
        SemanticResult result = runSemanticAnalysis();
        long resultEndTime = System.currentTimeMillis();
        log.info("执行语义分析耗时: {}ms", resultEndTime - resultStartTime);

        sleep(8);
        log.info("调用关联接口" + "/api/control/device/feeling");
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
        log.info("语义感知耗时" + (endTime - startTime) + "ms");
        return "ok";
    }

    public SemanticResult runSemanticAnalysis() {
        return new SemanticResult("节点查找", "语义渲染");
    }

    @GetMapping("异常检测")
    public String jiekou8() throws InterruptedException {
        long startTime = System.currentTimeMillis();
        log.info("异常检测开始");

        // 检测控制逻辑异常
        long patternsStartTime = System.currentTimeMillis();
        List<AbnormalPattern> patterns = detectAbnormalPatterns();
        long patternsEndTime = System.currentTimeMillis();
        log.info("检测控制逻辑异常耗时: {}ms", patternsEndTime - patternsStartTime);

        log.info("处理语义感知结果");
        log.info("调用接口" + "/api/control/device/error");
        for (AbnormalPattern p : patterns) {
            log.info(p.toString());
        }
        log.info("异常检测结束");
        sleep(25);
        long endTime = System.currentTimeMillis();
        log.info("异常检测耗时: {}ms", endTime - startTime);
        return "ok";
    }

    public List<AbnormalPattern> detectAbnormalPatterns() {
        return Arrays.asList(
                new AbnormalPattern("L1", "Logic Injection", "高"),
                new AbnormalPattern("L2", "Stealth Attack", "高")
        );
    }

    @GetMapping("时许因果表征")
    public String jiekou9() throws InterruptedException {
        log.info("时许因果表征开始");
        long startTime = System.currentTimeMillis();

        // 加载因果图谱
        long graphStartTime = System.currentTimeMillis();
        CausalGraph graph = loadCausalGraph();
        long graphEndTime = System.currentTimeMillis();
        log.info("加载因果图谱耗时: {}ms", graphEndTime - graphStartTime);

        log.info("开始加载资源");
        sleep(2);
        log.info("资源加载完成");
        long endTime = System.currentTimeMillis();
        log.info("资源加载耗时" + (endTime - startTime) + "ms");
        return "ok";
    }

    public CausalGraph loadCausalGraph() {

        return new CausalGraph("因果节点加载"
                , "时序因果边关联");

    }

    @GetMapping("漏洞级度量")
    public String jiekou10() throws InterruptedException {
        long startTime = System.currentTimeMillis();
        log.info("漏洞级度量开始");

        // 执行漏洞风险评分
        long scoreStartTime = System.currentTimeMillis();
        RiskScore score = computeGlobalRisk();
        long scoreEndTime = System.currentTimeMillis();
        log.info("执行漏洞风险评分耗时: {}ms", scoreEndTime - scoreStartTime);

        log.info("加载全局语义感知");
        log.info("调用关联接口" + "/api/control/device/feeling");
        sleep(10);
        log.info("语义感知结束");
        log.info("耗时10ms");
        log.info("漏洞度量开始");
        sleep(10);
        log.info("漏洞度量结束");
        log.info("高风险漏洞数：" + score.high);
        log.info("中高风险漏洞数：" + score.mediumHigh);
        log.info("中风险漏洞数：" + score.medium);
        long endTime = System.currentTimeMillis();
        log.info("漏洞级度量耗时" + (endTime - startTime) + "ms");
        return "ok";
    }

    public RiskScore computeGlobalRisk() {
        return new RiskScore(8,
                6, 11);
    }

    @GetMapping("设备级度量")
    public String jiekou11() throws InterruptedException {
        long startTime = System.currentTimeMillis();
        log.info("设备级度量开始");

        // 度量设备风险
        long deviceScoreStartTime = System.currentTimeMillis();
        RiskScore score = computeDeviceRisk();
        long deviceScoreEndTime = System.currentTimeMillis();
        log.info("度量设备风险耗时: {}ms", deviceScoreEndTime - deviceScoreStartTime);

        log.info("加载全局语义感知");
        log.info("调用关联接口" + "/api/control/device/feeling");
        sleep(10);
        log.info("语义感知结束");
        log.info("耗时10ms");
        log.info("设备级度量开始");
        sleep(12);
        log.info("漏洞度量结束");
        log.info("高风险漏洞数：" + score.high);
        log.info("中高风险漏洞数：" + score.mediumHigh);
        log.info("中风险漏洞数：" + score.medium);
        long endTime = System.currentTimeMillis();
        log.info("设备级度量耗时" + (endTime - startTime) + "ms");
        return "ok";
    }

    public RiskScore computeDeviceRisk() {
        return new RiskScore(6,
                8, 11);
    }

    @GetMapping("系统级度量")
    public String jiekou12() throws InterruptedException {
        long startTime = System.currentTimeMillis();
        log.info("系统级度量开始");

        // 系统级漏洞分析
        long systemScoreStartTime = System.currentTimeMillis();
        RiskScore score = computeSystemRisk();
        long systemScoreEndTime = System.currentTimeMillis();
        log.info("系统级漏洞分析耗时: {}ms", systemScoreEndTime - systemScoreStartTime);

        log.info("加载全局语义感知");
        log.info("调用关联接口" + "/api/control/device/feeling");
        sleep(11);
        log.info("语义感知结束");
        log.info("耗时11ms");
        log.info("系统级度量开始");
        sleep(10);
        log.info("漏洞度量结束");
        log.info("高风险漏洞数：" + score.high);
        log.info("中高风险漏洞数：" + score.mediumHigh);
        log.info("中风险漏洞数：" + score.medium);
        long endTime = System.currentTimeMillis();
        log.info("系统级度量耗时" + (endTime - startTime) + "ms");
        return "ok";
    }

    public RiskScore computeSystemRisk() {
        return new RiskScore(8,
                7, 10);
    }

    @GetMapping("威胁阻断方案")
    public String jiekou13() throws InterruptedException {
        long startTime = System.currentTimeMillis();
        log.info("威胁阻断方案开始");

        // 执行阻断策略生成
        long mitigationStartTime = System.currentTimeMillis();
        String result = runThreatMitigationPlan();
        long mitigationEndTime = System.currentTimeMillis();
        log.info("执行阻断策略生成耗时: {}ms", mitigationEndTime - mitigationStartTime);

        int time = getTime(40, 30);
        sleep(time);
        log.info("资源加载完成");
        long endTime = System.currentTimeMillis();
        log.info("资源加载耗时" + (endTime - startTime) + "ms");
        return "ok";
    }

    public String runThreatMitigationPlan() {
        return "阻断策" +
                "略已生成";
    }

    @GetMapping("资源调配")
    public String jiekou15()throws InterruptedException{
        long startTime = System.currentTimeMillis();
        long time = getTime();
        log.info("资源调配开始");
        log.info("安全分数计算中");
        log.info("漏洞密度计算中");
        log.info("漏洞密度 10");
        log.info("告警准确率计算中");
        log.info("异常解决率计算中");
        log.info("告警准确率 85");
        log.info("异常解决率 90");
        sleep(time);
        log.info("资源调配完成");
        long endTime = System.currentTimeMillis();
        log.info("资源调配耗时"+(endTime-startTime)+"ms");
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
        log.info("渗透耗时"+(endTime-startTime)+"ms");
        return "ok";
    }

    @GetMapping("login")
    public String jiekou17() {
        long startTime = System.currentTimeMillis();
        log.info("登陆成功");
        long endTime = System.currentTimeMillis();
        log.info("登陆操作耗时: {}ms", endTime - startTime);
        return "ok";
    }

    @GetMapping("logout")
    public String jiekou18() {
        long startTime = System.currentTimeMillis();
        log.info("退出成功");
        long endTime = System.currentTimeMillis();
        log.info("退出操作耗时: {}ms", endTime - startTime);
        return "ok";
    }

    @GetMapping("login_error")
    public String jiekou19() {
        long startTime = System.currentTimeMillis();
        log.info("登陆失败");
        long endTime = System.currentTimeMillis();
        log.info("登陆失败操作耗时: {}ms", endTime - startTime);
        return "ok";
    }

}