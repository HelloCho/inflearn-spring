package hello.core.member.service;

import hello.core.member.model.Member;

public interface MemberService {

    void join(Member member);

    Member findMember(Long memberId);
}
