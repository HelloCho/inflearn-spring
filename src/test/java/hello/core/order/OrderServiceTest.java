package hello.core.order;

import hello.core.discount.conf.AppConfig;
import hello.core.discount.model.Order;
import hello.core.discount.service.OrderService;
import hello.core.discount.service.impl.OrderServiceImpl;
import hello.core.member.model.Grade;
import hello.core.member.model.Member;
import hello.core.member.service.MemberService;
import hello.core.member.service.impl.MemberServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
@DisplayName("오더 서비스 테스타!!")
public class OrderServiceTest {

    MemberService memberService;
    OrderService orderService;

    @BeforeEach
    public void before() {
        AppConfig config = new AppConfig();

        memberService = config.memberService();
        orderService = config.orderService();

    }
    @Test
    @DisplayName("오더 생성!")
    public void createOder() {
        long memberId = 1L;

        Member foo = new Member(memberId, "foo", Grade.VIP);
        memberService.join(foo);

        Order order = orderService.createOrder(memberId, "itemA", 10000);
        Assertions.assertThat(order.getDiscountPrice()).isEqualTo(1000);
    }
}
