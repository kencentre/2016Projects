package cn.edu.tju.scs.fm.web;

import cn.edu.tju.scs.fm.service.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by jack on 2016/3/9.
 */

@Controller
@RequestMapping("/cards")
public class CardController {

    @Autowired
    CardService cardService;

    @RequestMapping(value = {"","/"},method = RequestMethod.GET)
    public String getCards(ModelMap map){
        map.addAttribute("cards",cardService.getAllCards());
        return "cardManage/cards";
    }

    @RequestMapping(value = "/new",method = RequestMethod.GET)
    public String addCard(){
        return "cardManage/add";
    }

    @RequestMapping(value = "/{cardNumber}",method = RequestMethod.GET)
    public String viewCard(@PathVariable String cardNumber){
        return "cardManage/add";
    }
}
