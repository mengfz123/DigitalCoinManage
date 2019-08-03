/**
 * @author 懒猴子CG
 * @date 2019-07-29 16:11:44
 * @email http://cg.lazy-monkey.com
 */
package com.ivan.digitalCoinInvest.entity;

import lombok.Data;
import lombok.ToString;

import java.math.BigDecimal;
import java.util.Date;

@Data
@ToString
public class PublicTrade {

    private Integer tradeId;

    private BigDecimal price;

    private BigDecimal size;

    private String side;

    private Date timestamp;

    private Integer instrumentId;

}