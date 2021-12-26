package hello.core.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MemberServiceImpl implements MemberService{

    private final MemberRepository memberRepository;
    //의존관계 자동 주입
    @Autowired
    public MemberServiceImpl(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }
    //memberRepository에서 구현객체로 MemoryMemberRepository를 선택




    @Override
    public void join(Member member) {
        memberRepository.save(member);
        //회원 가입
    }

    @Override
    public Member findMember(Long memberId) {
        return memberRepository.findById(memberId);
    } //회원조회

    public MemberRepository getMemberRepository() {
        return memberRepository;


    }
}
