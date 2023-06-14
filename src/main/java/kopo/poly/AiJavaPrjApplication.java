package kopo.poly;

import kopo.poly.dto.StudentDTO;
import kopo.poly.service.INlpService;
import kopo.poly.service.IOcrService;
import kopo.poly.service.IStudentService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@RequiredArgsConstructor
@SpringBootApplication
public class AiJavaPrjApplication implements CommandLineRunner {

    // @Service 정의된 자바 파일
    // Spring Frameworks 실행될 때, @Service 정의한 자바는 자동으로 메모리에 올림
    // 메모리에 올라간 OcrService 객체를 ocrService 변수에 객체를 넣어주기
    private final IOcrService ocrService; // 이미지 인식

    private final INlpService nlpService; // 자연어처리

    private final IStudentService studentService;



    public static void main(String[] args) {

        SpringApplication.run(AiJavaPrjApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        log.info("자바 프로그래밍 시작!!");
//
//        String filePath = "image"; // 문자열을 인식할 이미지 파일 경로
//        String fileName = "sample01.jpg"; // 문자열을 인식할 이미지 파일 이름
//
//        // 전달할 값(Parameter) 약자로 보통 변수명 앞에 p를 붙임 => pDTO
//        OcrDTO pDTO = new OcrDTO(); // OcrService의 함수에 정보를 전달할 DTO를 메모리에 올리기
//
//        pDTO.setFilePath(filePath);
//        pDTO.setFileName(fileName);
//
//        // 실행 결과(Result) 약자로 보통 변수명 앞에 r를 붙임 => rDTO
//        OcrDTO rDTO = ocrService.getReadforImageText(pDTO);
//
//        String result = rDTO.getResult(); // 인식된 문자열
//
//        log.info("인식된 문자열");
//        log.info(result);
//
//        log.info("---------------------------------------------------------------------------");
//        NlpDTO nlpDTO = nlpService.getPlainText(result);
//        log.info("형태소별 품사 분석 결과 : \n" + nlpDTO.getResult());
//
//        // 명사 추출 결과
//        nlpDTO = nlpService.getNouns(result);
//
//        List<String> nouns = nlpDTO.getNouns();
//
//        Set<String> distinct = new HashSet<>(nouns); // disdinct라고 오타냄 주의!!!
//
//        log.info("중복 제거 수행 전 단어 수 : " + nouns.size());
//        log.info("중복 제거 수행 후 단어 수 : " + distinct.size());
//
//        Map<String, Integer> rMap = new HashMap<>();
//
//        // 중복제거된 전체 단어마다 반복하기
//        for (String s : distinct) {
//            int count = Collections.frequency(nouns, s); // 단어 빈도수
//            rMap.put(s, count); // 단어, 빈도수를 Map 구조로 저장
//
//            log.info(s + " : " + count); // 저장된 결과 출력하기
//
//        }
//
//        List<Map.Entry<String, Integer>> sortResult = new LinkedList<>(rMap.entrySet());
//
//        Collections.sort(sortResult, (o1, o2) -> o2.getValue().compareTo(o1.getValue()));
//
//        log.info("가장 많이 사용된 단어는? : \n" + sortResult);



        // 학생 등록하기
        StudentDTO pDTO;
        List<StudentDTO> rList;

        pDTO = new StudentDTO();

        pDTO.setUserId("hglee67"); // hg'1'ee67라고 오타나서 에러 와우.... l => 1로....omg
        pDTO.setUserName("이협건");
        pDTO.setEmail("hglee67@kopo.ac.kr");
        pDTO.setAddr("서울");

        rList = studentService.insertStudent(pDTO);

        rList.forEach(dto -> {
            log.info("DB에 저장된 아이디 : " + dto.getUserId());
            log.info("DB에 저장된 이름 : " + dto.getUserName());
            log.info("DB에 저장된 이메일 : " + dto.getEmail());
            log.info("DB에 저장된 주소 : " + dto.getAddr()); // getUserAddr이라고 오타!!

        });


        // 학생 수정하기

        pDTO = new StudentDTO();

        pDTO.setUserId("hglee67"); // PK 컬럼인 회원 아이디를 기준으로 데이터를 수정함
        pDTO.setUserName("이협건_수정");
        pDTO.setEmail("hglee67@kopo.ac.kr_수정");
        pDTO.setAddr("서울_수정");

        rList = studentService.updateStudent(pDTO);

        rList.forEach(dto -> {
            log.info("DB에 저장된 아이디 : " + dto.getUserId());
            log.info("DB에 저장된 이름 : " + dto.getUserName());
            log.info("DB에 저장된 이메일 : " + dto.getEmail());
            log.info("DB에 저장된 주소 : " + dto.getAddr());

        });


        // 여러명의 학생 한꺼번에 등록하기 (과제)
        List<StudentDTO> pList = new ArrayList<>();

        for (int i = 0; i < 5; i++) {
            StudentDTO myDTO = new StudentDTO();

            myDTO.setUserId("이유진"+String.valueOf(i));
            myDTO.setUserName(String.valueOf(i));
            myDTO.setEmail(String.valueOf(i));
            myDTO.setAddr(String.valueOf(i));

            pList.add(myDTO);
        }

        studentService.insertStudentList(pList);

        pList.forEach(dto -> {
            log.info("DB에 저장된 아이디 : " + dto.getUserId());
            log.info("DB에 저장된 이름 : " + dto.getUserName());
            log.info("DB에 저장된 이메일 : " + dto.getEmail());
            log.info("DB에 저장된 주소 : " + dto.getAddr());

        });






        // 학생 삭제하기

//        pDTO = new StudentDTO();
//
//        pDTO.setUserId("hglee67");
//
//        rList = studentService.deleteStudent(pDTO);
//
//        rList.forEach(dto -> {
//            log.info("DB에 저장된 아이디 : " + dto.getUserId());
//            log.info("DB에 저장된 이름 : " + dto.getUserName());
//            log.info("DB에 저장된 이메일 : " + dto.getEmail());
//            log.info("DB에 저장된 주소 : " + dto.getAddr());
//
//        });
        log.info("자바 프로그래밍 종료!!");

    }

}
