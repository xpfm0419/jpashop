package jpabook.jpashop.domain.embedded;

import javax.persistence.Embeddable;

import lombok.Getter;

@Embeddable
@Getter
public class Address {
	/**
	 * 주소
	 */
	private String address;

	/**
	 * 주소 상세
	 */
	private String addressDetail;

	/**
	 * 우편번호
	 */
	private String zipcode;
}