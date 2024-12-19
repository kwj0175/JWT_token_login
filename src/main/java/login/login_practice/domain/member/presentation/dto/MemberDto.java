package login.login_practice.domain.member.presentation.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MemberDto {

    @Schema(description = "학번", example = "202211403")
    private String student_no;

    @Schema(description = "이름", example = "권우진")
    private String name;

    @Schema(description = "비밀번호", example = "1234")
    private String password;

    @Schema(description = "학과", example = "컴퓨터공학과")
    private String major;

    @Schema(description = "단과대", example = "소경대")
    private String department;

}
