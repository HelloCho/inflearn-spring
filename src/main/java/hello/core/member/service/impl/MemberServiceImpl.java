package hello.core.member.service.impl;

import hello.core.member.model.Member;
import hello.core.member.repository.MemberRepository;
import hello.core.member.repository.impl.MemberRepositoryImpl;
import hello.core.member.service.MemberService;

public class MemberServiceImpl implements MemberService {

    // Repository
    private final MemberRepository memberRepository;

    public MemberServiceImpl(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Override
    public void join(Member member) {
        memberRepository.save(member);
    }

    @Override
    public Member findMember(Long memberId) {
        return memberRepository.findById(memberId);
    }
}
