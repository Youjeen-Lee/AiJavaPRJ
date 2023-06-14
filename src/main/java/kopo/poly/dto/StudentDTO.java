package kopo.poly.dto;


import lombok.Getter;
import lombok.Setter;

@Setter
@Getter

public class StudentDTO { // Data Transmission Object
    private String userId;
    private String userName;
    private String email;
    private String addr;


}
// dto class를 사용하는 이유 : 컨트롤러-서비스-매퍼 사이에서 발생하는 데이터의 교환을 용이하게 함
// 어떻게? ==> 여러 데이터를 하나의 객체로 묶어서 주고받을 수 있게하는 전달객체임.