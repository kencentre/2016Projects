package cn.edu.tju.scs.fm.dao.impl;

import cn.edu.tju.scs.fm.dao.CardDao;
import cn.edu.tju.scs.fm.domain.Card;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by jack on 2016/3/9.
 */
@Repository(value = "cardDao")
public class CardDaoImpl implements CardDao {

    private static Logger logger = LoggerFactory.getLogger(CardDaoImpl.class);

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public List<String> getAllCards() {
        String query = "select cardNumber from cards";
//        logger.info(ToStringBuilder.reflectionToString(jdbcTemplate.queryForList(query).get(0).get("cardId")));
        return jdbcTemplate.queryForList(query,String.class);
    }

    @Override
    public Card getCard(String cardNumber) {
        String qu = "select cardId from cards where cardNumber = ?";
        int cardId = jdbcTemplate.queryForObject(qu, Integer.class,cardNumber);

        String query = "select * from cardItems  where cardNumber = ?";
        String query2 = "select  from cards and cardItems where cardNumber = ? and cardId = refCardId";
        Card  card = jdbcTemplate.queryForObject(query,Card.class,cardNumber);
        logger.info(ToStringBuilder.reflectionToString(card));
        return null;
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
