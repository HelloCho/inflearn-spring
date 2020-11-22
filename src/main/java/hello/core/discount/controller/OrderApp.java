package hello.core.discount.controller;

import hello.core.discount.conf.AppConfig;
import hello.core.discount.model.Order;
import hello.core.discount.service.OrderService;
import hello.core.discount.service.impl.OrderServiceImpl;
import hello.core.member.model.Grade;
import hello.core.member.model.Member;
import hello.core.member.service.MemberService;
import hello.core.member.service.impl.MemberServiceImpl;

public class OrderApp {

    public static void main(String[] args) {
        AppConfig config = new AppConfig();

        MemberService memberService = config.memberService();
        OrderService orderService = config.orderService();

        Long memberId = 1L;
        Member memberA = new Member(memberId, "memberA", Grade.VIP);
        memberService.join(memberA);

        Order order = orderService.createOrder(memberId, memberA.getName(), 12000);

        System.out.println("order = " + order);
        System.out.println("discount = " + order.calculatePrice());

    }
}
