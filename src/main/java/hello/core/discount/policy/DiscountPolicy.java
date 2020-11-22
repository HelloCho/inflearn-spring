package hello.core.discount.policy;

import hello.core.member.model.Member;

public interface DiscountPolicy {

    /**
     *
     * @param member
     * @param price
     * @return 할인 대상 금액
     */
    int discount(Member member, int price);
}
