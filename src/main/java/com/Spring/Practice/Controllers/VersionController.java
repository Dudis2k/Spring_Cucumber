package com.Spring.Practice.Controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VersionController {
    public static volatile int version = 0;
    @GetMapping("/version")
    public int get_version(){
        version=version+1;
        return version;
    }
}
