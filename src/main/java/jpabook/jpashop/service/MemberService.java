package jpabook.jpashop.service;

import jpabook.jpashop.domain.Member;
import jpabook.jpashop.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 회원 Service
 * @author User
 *
 */
@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MemberService {

	/**
	 * 회원 Repository
	 */
    private final MemberRepository memberRepository;

	/**
	 * 회원 전체 목록 조회
	 *
	 * @return 회원 전체 목록
	 */
	public List<Member> selectMemberList() {
		return memberRepository.selectMemberList();
	}

	/**
	 * 회원 조회
	 *
	 * @param memberIdx 회원 고유번호
	 * @return 회원
	 */
	public Member selectMember(Long memberIdx) {
		return memberRepository.selectMember(memberIdx);
	}

	/**
	 * 회원 입력
	 *
	 * @param member 입력 정보가 담긴 Member
	 * @return 회원 고유번호
	 */
	@Transactional
	public Long insertMember(Member member) {
		// 중복 회원 확인
		validateDuplicateMember(member.getMemberName());

		// 회원 입력
		memberRepository.insertMember(member);

		return member.getMemberIdx();
	}

	/**
	 * 회원 이름 중복 확인
	 *
	 * @param memberName 회원 이름
	 */
	private void validateDuplicateMember(String memberName) {
		if(!memberRepository.selectAllMemberListByMemberName(memberName).isEmpty()) {
			throw new IllegalStateException("이미 존재하는 회원 입니다.");
		}
	}
}
