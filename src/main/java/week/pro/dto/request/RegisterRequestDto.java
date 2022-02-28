package week.pro.dto.request;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Getter
@Setter
@NoArgsConstructor
public class RegisterRequestDto {

    @NotBlank(message = "닉네임을 적어주세요")
    @Size(min = 3)
    private String account_name;

    @Email(message = "이메일 형식에 맞춰주세요")
    private String account_email;

    @NotBlank(message = "비밀번호를 4자 이상 입력해 주세요.")
    @Size(min = 4)
    private String password;

    @NotBlank(message = "비밀번호를 4자 이상 입력해 주세요.")
    @Size(min = 4)
    private String password_check;
}
