package hello.servlet.domain.member;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

class MemberRepositoryTest {    //Test는 public 없어도 됨 (내가 지움)

    MemberRepository memberRepository = MemberRepository.getInstance();

    @AfterEach  //하나의 메서드가 끝날떄마다 호출함
    void afterEach() {
        memberRepository.clearStore();
    }

    @Test
    void save() {
        //given (이런게 주어졌을떄)
        Member member = new Member("hello", 20);

        //when (이런걸 실행했을떄)
        Member savedMember = memberRepository.save(member); //위 member를 save메서드 적용하고 그걸 savedMember에 저장
                                                            //save할떄마다 sequence +1됨 그게 id

        //then (결과가 이거여야해)
        Member findMember = memberRepository.findById(savedMember.getId()); //한개 save했으니 위 member의 id=1 그걸 가져와서 findmember로 저장
        Assertions.assertThat(findMember).isEqualTo(savedMember);   //위에 찾은 멤버 id 즉 1이랑 savedMeber의 id가 같은지 비교
    }
}
