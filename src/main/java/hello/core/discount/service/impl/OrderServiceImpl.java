package hello.core.discount.service.impl;

import hello.core.discount.policy.DiscountPolicy;
import hello.core.discount.model.Order;
import hello.core.discount.policy.impl.FixDiscountPolicy;
import hello.core.discount.policy.impl.RateDiscountPolicy;
import hello.core.discount.service.OrderService;
import hello.core.member.model.Member;
import hello.core.member.repository.MemberRepository;
import hello.core.member.repository.impl.MemberRepositoryImpl;

public class OrderServiceImpl implements OrderService {

    private final MemberRepository memberRepository;
    private final DiscountPolicy discountPolicy;

    public OrderServiceImpl(MemberRepository memberRepository, DiscountPolicy discountPolicy) {
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
    }

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member findMember = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(findMember, itemPrice);
        return new Order(memberId, itemName, itemPrice, discountPrice);
    }
}
