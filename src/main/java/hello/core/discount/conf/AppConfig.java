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
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public MemberService memberService() {
        return new MemberServiceImpl(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository() {
        return new MemberRepositoryImpl();
    }

    @Bean
    public OrderService orderService() {
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }

    @Bean
    public DiscountPolicy discountPolicy() {
        // return new FixDiscountPolicy();
        return new RateDiscountPolicy();
    }
}
