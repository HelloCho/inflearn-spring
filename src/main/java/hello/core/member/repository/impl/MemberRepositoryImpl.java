package hello.core.member.repository.impl;

import hello.core.member.model.Member;
import hello.core.member.repository.MemberRepository;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class MemberRepositoryImpl implements MemberRepository {

    //     private static Map<Long, Member> store = new HashMap<>();
    private static Map<Long, Member> store = new ConcurrentHashMap<>();

    @Override
    public void save(Member member) {
        store.put(member.getId(), member);
    }

    @Override
    public Member findById(Long memberId) {
        return store.get(memberId);
    }
}
