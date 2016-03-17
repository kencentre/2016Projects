package cn.edu.tju.scs.fm.dao;

import cn.edu.tju.scs.fm.domain.Card;

import java.util.List;

/**
 * Created by jack on 2016/3/9.
 */
public interface CardDao {

    public List<String> getAllCards();

    public Card getCard(String cardNumber);

    public boolean addCard(Card card);

    public boolean updateCard(Card card);

    public boolean deleteCard(Card card);
}
