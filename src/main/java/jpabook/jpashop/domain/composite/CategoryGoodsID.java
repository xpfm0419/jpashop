package jpabook.jpashop.domain.composite;

import java.io.Serializable;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * CategoryGoods PK
 * @author User
 *
 */
@NoArgsConstructor
@EqualsAndHashCode
@Getter
public class CategoryGoodsID implements Serializable {
	private static final long serialVersionUID = 2796125250634176239L;

	private Long category;
	private Long goods;
}
