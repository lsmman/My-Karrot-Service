package com.lsmman.mykarrotservice.member;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

@Controller
@RequiredArgsConstructor
public class MemberController {

    private final MemberRepository memberRepository;

    private final PasswordEncoder passwordEncoder;

    @GetMapping("/")
    public String homePage(@AuthenticationPrincipal User user,
                           Map<String, Object> model) {
        List<Member> members = memberRepository.findAll();
        model.put("members", members);
        return "homepage";
    }

    @GetMapping("/member/admin")
    public String adminPage(@AuthenticationPrincipal User user,
                            Map<String, Object> model) {
        model.put("currentAdminId", user.getUsername());
        return "adminpage";
    }

    @GetMapping("/member/new")
    public String memberJoinForm(Member memberForm) {
        return "memberJoinForm";
    }

    @PostMapping("/member/new")
    public String memberJoin(Member memberForm, Model model) {
        if (memberRepository.findByMemberId(memberForm.getMemberId()).isPresent()){
            model.addAttribute("error", true);
            return "memberJoinForm";
        }
        memberForm.encodePassword(passwordEncoder.encode(memberForm.getPassword()));
        memberRepository.save(memberForm);
        return "redirect:/login";
    }

    @GetMapping("/login")
    public String memberLogin(
            @RequestParam(value = "error", required = false) String error,
            Model model){
        model.addAttribute("error", error);
        return "loginpage";
    }
}
