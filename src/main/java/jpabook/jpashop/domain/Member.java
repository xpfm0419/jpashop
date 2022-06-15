package jpabook.jpashop.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import jpabook.jpashop.domain.embedded.Address;
import lombok.Getter;
import lombok.Setter;

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
	@Id @GeneratedValue
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

	//@JsonIgnore
	@OneToMany(mappedBy = "member")
	private List<MemberOrder> memberOrderList = new ArrayList<>();


	// =================================== 연관관계 메소드 ===================================

	// =================================== 생성 메소드 ===================================

	// =================================== 비즈니스 로직 ===================================

}
