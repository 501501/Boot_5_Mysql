package com.sol.b5.board.qna;

import com.sol.b5.board.BoardVO;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=false)
// Hashcode 메서드가 충돌 가능성이 있음
// 또는
// @Getter
// @Setter
public class QnaVO extends BoardVO {
	private Integer ref;
	private Integer step;
	private Integer depth;
	
}
