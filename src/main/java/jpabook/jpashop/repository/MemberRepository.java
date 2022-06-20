package jpabook.jpashop.repository;

import jpabook.jpashop.domain.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

/**
 * 회원 Repository
 * @author User
 *
 */
@Repository
@RequiredArgsConstructor
public class MemberRepository {

	/**
	 * EntityManager
	 */
	private final EntityManager em;

	/**
	 * 회원 목록 조회
	 *
	 * @return 회원 목록
	 */
	public List<Member> selectMemberList() {
		return em.createQuery("select m from Member m", Member.class)
				.getResultList();
	}

	/**
	 * 회원 전체 목록 조회 (회원이름 검색)
	 *
	 * @param memberName 회원 이름
	 * @return 회원 전체 목록
	 */
	public List<Member> selectAllMemberListByMemberName(String memberName) {
		return em.createQuery("select m from Member m where m.memberName = :memberName", Member.class)
				.setParameter("memberName", memberName)
				.getResultList();
	}

	/**
	 * 회원 조회
	 *
	 * @param memberIdx 회원 고유번호
	 * @return 회원
	 */
	public Member selectMember(Long memberIdx) {
		return em.find(Member.class, memberIdx);
	}

	/**
	 * 회원 입력
	 *
	 * @param member 입력 정보가 담긴 Member
	 */
	public void insertMember(Member member) {
		em.persist(member);
	}
}
