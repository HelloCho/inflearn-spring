package hello.core.member.controller;

import hello.core.discount.conf.AppConfig;
import hello.core.discount.service.OrderService;
import hello.core.member.model.Grade;
import hello.core.member.model.Member;
import hello.core.member.service.MemberService;
import hello.core.member.service.impl.MemberServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MemberApp {

    public static void main(String[] args) {

        ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);
        MemberService memberService = ac.getBean("memberService", MemberService.class);

        Member member = new Member(1L, "Member", Grade.VIP);
        memberService.join(member);

        Member findMember = memberService.findMember(1L);

        System.out.println("new member = " + member.getName());
        System.out.println("find member = " + findMember.getName());
    }
}
