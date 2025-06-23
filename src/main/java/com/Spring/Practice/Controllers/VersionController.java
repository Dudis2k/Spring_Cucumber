package com.Spring.Practice.Controllers;

import com.Spring.Practice.dto.Member;
import org.springframework.web.bind.annotation.*;

@RestController
public class VersionController {
    public static volatile int version = 0;
    @GetMapping("/version")
    public int get_version(){
        version=version+1;
        return version;
    }

//    @PostMapping("/add-member")
//    public String addMember(@RequestBody Member member) {
//        // Logic to add a member would go here
//        System.out.println("%s added with status %s".formatted(member.getName(), member.getMember_status()));
//        return "Member added successfully";
//    }
}
