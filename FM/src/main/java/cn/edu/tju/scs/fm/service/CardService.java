package cn.edu.tju.scs.fm.service;

import cn.edu.tju.scs.fm.domain.Card;

import java.util.List;

/**
 * Created by jack on 2016/3/9.
 */

public interface CardService {

    public List<String> getAllCards();

    public boolean addCard(Card card);

    public boolean updateCard(Card card);

    public boolean deleteCard(Card card);
}
