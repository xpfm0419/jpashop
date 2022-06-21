package jpabook.jpashop.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import jpabook.jpashop.domain.Member;
import jpabook.jpashop.domain.embedded.Address;
import jpabook.jpashop.service.MemberService;
import lombok.RequiredArgsConstructor;

/**
 * 회원 Controller
 */
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

    /**
     * 회원 가입 화면
     * @param model Model
     * @return member/form
     */
    @GetMapping("/member/insert")
    public String memberInsertForm(Model model) {
        model.addAttribute("memberForm", new MemberForm());
        return "member/form";
    }

    /**
     * 회원 가입 처리
     * @param memberForm
     * @param result
     * @return
     */
    @PostMapping("/member/insert")
    public String memberInsertProc(@Valid MemberForm memberForm, BindingResult result) {

        if (result.hasErrors()) {
            return "member/form";
        }

        Member member = new Member();
        member.setMemberName(memberForm.getMemberName());
        member.setAddress(new Address(memberForm.getAddress1(), memberForm.getAddress2(), memberForm.getZipcode()));

        memberService.insertMember(member);
        return "redirect:/";
    }
}
