package jpabook.jpashop.controller;

import jpabook.jpashop.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class MemberController {
    private final MemberService memberService;

    /**
     * 회원 목록 조회
     * @param model Model
     * @return member/list
     */
    @GetMapping("/member/list")
    public String memberList(Model model) {
        model.addAttribute(memberService.selectMemberList());

        return "member/list";
    }
}
