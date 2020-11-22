package hello.core.member.controller;

import hello.core.discount.conf.AppConfig;
import hello.core.member.model.Grade;
import hello.core.member.model.Member;
import hello.core.member.service.MemberService;
import hello.core.member.service.impl.MemberServiceImpl;

public class MemberApp {

    public static void main(String[] args) {
        AppConfig config = new AppConfig();

        MemberService service = config.memberService();

        Member member = new Member(1L, "Member", Grade.VIP);
        service.join(member);

        Member findMember = service.findMember(1L);

        System.out.println("new member = " + member.getName());
        System.out.println("find member = " + findMember.getName());
    }
}
