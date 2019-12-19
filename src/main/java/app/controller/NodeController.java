package app.controller;

import app.config.ApplicationPaths;
import app.process.ProcessExecutor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/" + ApplicationPaths.NODE_PAGE)
public class NodeController {

    @Autowired
    private ProcessExecutor processExecutor;

    @GetMapping
    public String getNode(){
        return ApplicationPaths.NODE_PAGE;
    }

    @PostMapping
    public String installApexCore() {
        new Thread(() -> {
            processExecutor.installCore("master", "0.9.2");
        }).start();
        return ApplicationPaths.NODE_PATH;
    }

}