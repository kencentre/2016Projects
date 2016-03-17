package cn.edu.tju.scs.fm.domain;

import org.springframework.format.annotation.NumberFormat;

import java.math.BigDecimal;

/**
 * 项目
 * Created by jack on 2015/12/5.
 */
public class CardItem extends BaseDomain{

    //项目 id
    private int itemId;

    // 项目名称
    private String itemName;

    // 项目归属人
    private String itemOwner;

    // 项目金额
    // 钱的数量
    @NumberFormat(style= NumberFormat.Style.CURRENCY)
    private BigDecimal itemCount;

    public CardItem(){

    }

    public int getItemId() {
        return itemId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getItemOwner() {
        return itemOwner;
    }

    public void setItemOwner(String itemOwner) {
        this.itemOwner = itemOwner;
    }

    public BigDecimal getItemCount() {
        return itemCount;
    }

    public void setItemCount(BigDecimal itemCount) {
        this.itemCount = itemCount;
    }
}
