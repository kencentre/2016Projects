package cn.edu.tju.scs.fm.service.impl;

import cn.edu.tju.scs.fm.dao.CardDao;
import cn.edu.tju.scs.fm.domain.Card;
import cn.edu.tju.scs.fm.service.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by jack on 2016/3/9.
 */
@Service(value = "cardService")
public class CardServiceImpl implements CardService {
    @Autowired
    CardDao cardDao;
    @Override
    public List<String> getAllCards() {
        return cardDao.getAllCards();
    }

    @Override
    public boolean addCard(Card card) {
        return false;
    }

    @Override
    public boolean updateCard(Card card) {
        return false;
    }

    @Override
    public boolean deleteCard(Card card) {
        return false;
    }
}
