package jpabook.jpashop.domain.embedded;

import javax.persistence.Embeddable;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * 주소
 * @author User
 *
 */
@Embeddable
@Getter
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Address {
	/**
	 * 주소 1
	 */
	private String address1;

	/**
	 * 주소 2
	 */
	private String address2;

	/**
	 * 우편번호
	 */
	private String zipcode;
}