package hello.core.discount.policy.impl;

import hello.core.discount.conf.AppConfig;
import hello.core.member.model.Grade;
import hello.core.member.model.Member;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

public class RateDiscountPolicyTest {

    RateDiscountPolicy discountPolicy = new RateDiscountPolicy();

    @Test
    @DisplayName("VIP는 10% 할인이 적용되어야 한다.")
    public void vio_o() {
        // given
        Member foo = new Member(1L, "Foo", Grade.VIP);
        // when
        int discount = discountPolicy.discount(foo, 10000);
        // then
        assertThat(discount).isEqualTo(1000);
    }

    @Test
    @DisplayName("VIP가 아니면 할인이 적용되지 않아야 한다")
    public void vip_x() {
        // given
        Member bar = new Member(2L, "Bar", Grade.BASIC);
        // when
        int discount = discountPolicy.discount(bar, 10000);
        // then
        assertThat(discount).isEqualTo(1000);
    }
}