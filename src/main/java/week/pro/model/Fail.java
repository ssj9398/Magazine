package week.pro.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
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

