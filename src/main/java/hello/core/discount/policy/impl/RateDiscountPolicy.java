package hello.core.discount.policy.impl;

import hello.core.discount.policy.DiscountPolicy;
import hello.core.member.model.Grade;
import hello.core.member.model.Member;

public class RateDiscountPolicy implements DiscountPolicy {

    private int discountPercent = 10;

    @Override
    public int discount(Member member, int price) {
        if (member.getGrade() == Grade.VIP) {
            return price * discountPercent / 100;
        } else {
            return 0;
        }
    }
}
