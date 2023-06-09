package kopo.poly.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class NlpDTO {

    private String text; // 분석할 문장
    private String result; // 분석된 품사 결과

}