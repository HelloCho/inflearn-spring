package hello.core.member;

import hello.core.discount.conf.AppConfig;
import hello.core.member.model.Grade;
import hello.core.member.model.Member;
import hello.core.member.service.impl.MemberServiceImpl;
import hello.core.member.service.MemberService;
import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class MemberServiceTest {

    MemberService memberService;

    @BeforeEach
    public void beforeEach() {
        AppConfig config = new AppConfig();
        memberService = config.memberService();
    }

    @Test
    public void join() {
        // given
        Member member = new Member(1L, "Foo", Grade.VIP);
        Member member2 = new Member(2L, "Bar", Grade.BASIC);

        // when
        memberService.join(member);
        memberService.join(member2);

        // Member findMember = memberService.findMember(member.getId());
        Member findMember = memberService.findMember(1L);
        // then
        Assertions.assertThat(member).isEqualTo(findMember);
    }
}
