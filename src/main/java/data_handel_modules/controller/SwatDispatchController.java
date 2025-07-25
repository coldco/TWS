package data_handel_modules.controller;

import data_handel_modules.service.impl.SwatDispatchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/swat")
public class SwatDispatchController {

    @Autowired
    private SwatDispatchService dispatchService;

    /**
     * 触发数据调度逻辑
     */
    @GetMapping("/dispatch")
    public String dispatch() {
        dispatchService.dispatchData();
        return "数据已读取并分发至模块处理。请查看控制台日志。";
    }
}
