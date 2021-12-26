package hello.core.member;
/*
회원저장소 역할 interface
 */
public interface MemberRepository {

    void save(Member member);
    //저장하는 기능
    Member findById(Long memberId);
    //아이디별로 조회하는 기능
}
