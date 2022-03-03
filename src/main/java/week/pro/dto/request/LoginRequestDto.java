package week.pro.dto.request;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class LoginRequestDto {

    private String account_email;
    private String password;

    @Builder
    public LoginRequestDto(String account_email, String password){
        this.account_email = account_email;
        this.password = password;
    }
}
