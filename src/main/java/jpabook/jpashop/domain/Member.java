package jpabook.jpashop.domain;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

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

	/*
	@JsonIgnore
    @OneToMany(mappedBy = "member")
    private List<Order> orders = new ArrayList<>();
    */
}
