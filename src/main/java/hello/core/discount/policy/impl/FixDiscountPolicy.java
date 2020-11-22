package hello.core.discount.policy.impl;

import hello.core.discount.policy.DiscountPolicy;
import hello.core.member.model.Grade;
import hello.core.member.model.Member;

public class FixDiscountPolicy implements DiscountPolicy {

    // 1000원 할인
    private final int discountFIxAmount = 1000;

    @Override
    public int discount(Member member, int price) {
        if (member.getGrade() == Grade.VIP) {
            return discountFIxAmount;
        } else {
            return 0;
        }
    }
}
