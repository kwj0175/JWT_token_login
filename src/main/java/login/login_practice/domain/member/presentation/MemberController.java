package login.login_practice.domain.member.presentation;


import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import login.login_practice.domain.member.application.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@ResponseBody
@Tag(name = "Member", description = "회원")
@RequestMapping("/")
public class MemberController {

    private final MemberService memberService;

    @PostMapping("/login")
    @Operation(summary = "[U] 로그인", description = "로그인")
    public String login(
            @RequestParam String id,
            @RequestParam String password
    ) {

        String msg = memberService.login(id, password);

        return "ok " + msg;
    }



}
