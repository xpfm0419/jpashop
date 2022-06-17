package jpabook.jpashop.domain;

import jpabook.jpashop.domain.embedded.Address;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * 회원
 * @author User
 *
 */
@Entity
@Getter @Setter
public class Member {

	/**
	 * 회원 고유번호
	 */
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long memberIdx;

	/**
	 * 회원 이름
	 */
	private String memberName;

	/**
	 * 회원 주소
	 */
	@Embedded
	private Address address;

	// =================================== 양방향 연관관계 ===================================

	/**
	 * 회원 주문 목록
	 */
	//@JsonIgnore
	@OneToMany(mappedBy = "member")
	private List<MemberOrder> memberOrderList = new ArrayList<>();


	// =================================== 연관관계 메소드 ===================================

	// =================================== 생성 메소드 ===================================

	// =================================== 비즈니스 로직 ===================================

}
