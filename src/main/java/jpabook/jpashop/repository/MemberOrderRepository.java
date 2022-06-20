package jpabook.jpashop.repository;

import jpabook.jpashop.domain.MemberOrder;
import jpabook.jpashop.domain.search.MemberOrderSearch;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.*;
import java.util.ArrayList;
import java.util.List;

/**
 * 회원 주문 Repository
 * @author User
 *
 */
@Repository
@RequiredArgsConstructor
public class MemberOrderRepository {

	/**
	 * EntityManager
	 */
	private final EntityManager em;

	/**
	 * 회원 주문 목록 조회
	 * @param memberOrderSearch 조회할 정보가 담긴 MemberOrderSearch
	 * @return
	 */
	public List<MemberOrder> selectMemberOrderList(MemberOrderSearch memberOrderSearch) {

		String jpql = "select mo from MemberOrder mo join mo.member m where 1=1";

		//주문 상태 검색
		if (memberOrderSearch.getOrderStatus() != null) {
			jpql += " and mo.status = :status";
		}

		//회원 이름 검색
		if (StringUtils.hasText(memberOrderSearch.getMemberName())) {
			jpql += " and mo.name like :name";
		}

		TypedQuery<MemberOrder> query = em.createQuery(jpql, MemberOrder.class)
				.setMaxResults(1000);

		if (memberOrderSearch.getOrderStatus() != null) {
			query = query.setParameter("status", memberOrderSearch.getOrderStatus());
		}
		if (StringUtils.hasText(memberOrderSearch.getMemberName())) {
			query = query.setParameter("name", memberOrderSearch.getMemberName());
		}

		return query.getResultList();
	}

	/**
	 * JPA Criteria
	 */
	public List<MemberOrder> findAllByCriteria(MemberOrderSearch memberOrderSearch) {
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<MemberOrder> cq = cb.createQuery(MemberOrder.class);
		Root<MemberOrder> o = cq.from(MemberOrder.class);
		Join<Object, Object> m = o.join("member", JoinType.INNER);

		List<Predicate> criteria = new ArrayList<>();

		//주문 상태 검색
		if (memberOrderSearch.getOrderStatus() != null) {
			Predicate status = cb.equal(o.get("status"), memberOrderSearch.getOrderStatus());
			criteria.add(status);
		}
		//회원 이름 검색
		if (StringUtils.hasText(memberOrderSearch.getMemberName())) {
			Predicate name =
					cb.like(m.<String>get("name"), "%" + memberOrderSearch.getMemberName() + "%");
			criteria.add(name);
		}

		cq.where(cb.and(criteria.toArray(new Predicate[criteria.size()])));
		TypedQuery<MemberOrder> query = em.createQuery(cq).setMaxResults(1000);
		return query.getResultList();
	}

	/**
	 * 회원 주문 조회
	 *
	 * @param moIdx 회원 주문 고유번호
	 * @return 회원 주문
	 */
	public MemberOrder selectMemberOrder(Long moIdx) {
		return em.find(MemberOrder.class, moIdx);
	}

	/**
	 * 회원 주문 입력
	 *
	 * @param memberOrder 입력 정보가 담긴 MemberOrder
	 */
	public void insertMemberOrder(MemberOrder memberOrder) {
		em.persist(memberOrder);
	}
}
