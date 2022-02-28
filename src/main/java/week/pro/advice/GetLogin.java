package week.pro.advice;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import week.pro.dto.response.LoginResponseDto;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class GetLogin {

    private boolean success;

    private String msg;

    private LoginResponseDto data;
}
