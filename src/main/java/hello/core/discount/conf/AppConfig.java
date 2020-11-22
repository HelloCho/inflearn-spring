package hello.core.discount.conf;

import hello.core.discount.policy.DiscountPolicy;
import hello.core.discount.policy.impl.FixDiscountPolicy;
import hello.core.discount.policy.impl.RateDiscountPolicy;
import hello.core.discount.service.OrderService;
import hello.core.discount.service.impl.OrderServiceImpl;
import hello.core.member.repository.MemberRepository;
import hello.core.member.repository.impl.MemberRepositoryImpl;
import hello.core.member.service.MemberService;
import hello.core.member.service.impl.MemberServiceImpl;

public class AppConfig {

    public MemberService memberService() {
        return new MemberServiceImpl(memberRepository());
    }

    private MemberRepository memberRepository() {
        return new MemberRepositoryImpl();
    }

    public OrderService orderService() {
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }

    public DiscountPolicy discountPolicy() {
        // return new FixDiscountPolicy();
        return new RateDiscountPolicy();
    }
}
