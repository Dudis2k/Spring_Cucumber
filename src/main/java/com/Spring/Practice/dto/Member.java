package com.Spring.Practice.dto;

import io.cucumber.java.mk_latn.No;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Member {
    private int id;
    private String name;
    private String member_status;

    public Member(int id, String name, String memberStatus) {
        this.id = id;
        this.name = name;
        this.member_status = memberStatus;
    }

    public Object getName() {
        return name;
    }

    public String getMember_status() {
        return member_status;
    }
}
