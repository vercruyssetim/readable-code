package code.kunlabora.v1.internet;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("next")
public class Entrypoint {
    private int[] IA_gm;
    private int I_ro = 0;

    @GetMapping(path = "do")
    public String DONEXT(@RequestParam int next) {
        return CALCULATE(next, 7, 4);
    }

    private String CALCULATE(int I_next, int I_s, int I_wc) {
        int I_i = 0;
        int I_j = 0;
        int I_c = 0;
        int I_P = 0;
        String S_r = "false";
        I_next = I_next - 1;
        I_ro++;
        if (IA_gm == null) {
            IA_gm = new int[I_s * (I_s - 1)];
        }

        while (I_i < IA_gm.length) {
            if (IA_gm[I_i + I_next] != 0) {
                if (I_ro % 2 == 1) {
                    IA_gm[I_i + I_next - I_s] = 1;
                } else {
                    IA_gm[I_i + I_next - I_s] = 2;
                }
                break;
            } else if (I_i == I_s * (I_s - 2)) {
                if (I_ro % 2 == 1) {
                    IA_gm[I_i + I_next] = 1;
                } else {
                    IA_gm[I_i + I_next] = 2;
                }
                break;
            }
            I_i += I_s;
        }

        I_i = 0;
        while (I_i < I_s - 1) {
            while (I_j < I_s) {
                if (1 == IA_gm[I_s * I_i + I_j]) {
                    if (1 != I_P) {
                        I_P = 1;
                        I_c = 1;
                    } else {
                        I_c++;
                    }
                }
                if (2 == IA_gm[I_s * I_i + I_j]) {
                    if (2 != I_P) {
                        I_P = 2;
                        I_c = 1;
                    } else {
                        I_c++;
                    }
                }
                if (I_c == I_wc) {
                    S_r = "true";
                }
                I_j++;
            }
            I_j = 0;
            I_i++;
        }

        return S_r;
    }
}
