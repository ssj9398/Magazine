package week.pro.advice;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class Fail {

    private boolean success;
    private String msg;

    @Builder
    public Fail(String msg) {
        this.success = false;
        this.msg = msg;
    }
}