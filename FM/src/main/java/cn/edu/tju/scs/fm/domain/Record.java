package cn.edu.tju.scs.fm.domain;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.NumberFormat;

import java.math.BigDecimal;
import java.sql.Timestamp;

/**
 * 报销记录
 * Created by jack on 2016/1/2.
 */
public class Record extends BaseDomain{

    // 钱的ID
    private Long recordId;

    // 钱的数量
    @NumberFormat(style= NumberFormat.Style.CURRENCY)
    private BigDecimal count;

    // --------测试货币格式化-------------
//            CurrencyFormatter currencyFormatter = new CurrencyFormatter();
//            BigDecimal money = new BigDecimal(1234567.890);
//            System.out.println(currencyFormatter.print(money, Locale.CHINA));//￥1,234,567.89
//            conversionService.addFormatter(currencyFormatter);
//            System.out.println(conversionService.convert(money, String.class));//$1,234,567.89

    // 时间
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Timestamp timestamp;

    // 所属卡
    private Card card;

    // 0 入账， 1 出账
    private int type = 0;

    // 原因
    private String reason;

    // 属于 item
    private int itemIndex;

    // 执行人
    private String executor;

    public Record(){

    }

    public Long getRecordId() {
        return recordId;
    }

    public void setRecordId(Long recordId) {
        this.recordId = recordId;
    }

    public BigDecimal getCount() {
        return count;
    }

    public void setCount(BigDecimal count) {
        this.count = count;
    }

    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    public Timestamp getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public Card getCard() {
        return card;
    }

    public void setCard(Card card) {
        this.card = card;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public int getItemIndex() {
        return itemIndex;
    }

    public void setItemIndex(int itemIndex) {
        this.itemIndex = itemIndex;
    }

    public String getExecutor() {
        return executor;
    }

    public void setExecutor(String executor) {
        this.executor = executor;
    }
}
