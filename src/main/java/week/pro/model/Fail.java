package week.pro.model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Fail {

    private boolean success;
    private String msg;

    public Fail(String msg) {
        this.success = false;
        this.msg = msg;
    }

}

