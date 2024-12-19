package login.login_practice.domain.member.presentation;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import login.login_practice.domain.member.application.JoinService;
import login.login_practice.domain.member.presentation.dto.MemberDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@ResponseBody
@RequiredArgsConstructor
@Tag(name = "Join", description = "가입")
@RequestMapping("/")
public class JoinController {

    private final JoinService joinService;

    @PostMapping("/join")
    @Operation(summary = "[U] 회원가입", description = "회원 생성")
    public String join(
            @RequestBody MemberDto memberDto
    ) {
        String id = joinService.join(memberDto);

        return "ok " + id;
    }

}
