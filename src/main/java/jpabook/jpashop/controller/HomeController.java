package jpabook.jpashop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Home Controller
 * @author User
 *
 */
@Controller
public class HomeController {

	/**
	 * Home으로 이동
	 * @return home
	 */
    @RequestMapping("/")
    public String home() {
        return "home";
    }
}
