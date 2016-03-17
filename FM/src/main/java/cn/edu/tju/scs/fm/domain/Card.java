package cn.edu.tju.scs.fm.domain;

/**
 * Created by jack on 2015/11/13.
 */


import org.springframework.format.annotation.NumberFormat;

import java.math.BigDecimal;
import java.util.List;

/**
 *  金额卡
 *  报销与卡的关系是单向多对一映射
 */
public class Card extends BaseDomain {

    // 卡 id
    private int cardId;

    // 卡号
    private String cardNumber;


    // 钱的数量
    @NumberFormat(style= NumberFormat.Style.CURRENCY)
    private BigDecimal totalCount;

    private List<CardItem> items;


    public Card(){
    }

    public int getCardId() {
        return cardId;
    }

    public void setCardId(int cardId) {
        this.cardId = cardId;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public BigDecimal getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(BigDecimal totalCount) {
        this.totalCount = totalCount;
    }

    public List<CardItem> getItems() {
        return items;
    }

    public void setItems(List<CardItem> items) {
        this.items = items;
    }



}
