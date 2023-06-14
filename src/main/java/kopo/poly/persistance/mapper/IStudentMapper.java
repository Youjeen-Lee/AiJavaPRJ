package kopo.poly.persistance.mapper;

import kopo.poly.dto.StudentDTO;
import org.apache.ibatis.annotations.Mapper;


import java.util.List;


@Mapper
public interface IStudentMapper {
    void insertStudent(StudentDTO pDTO) throws Exception;

    List<StudentDTO> getStudentList() throws Exception;

    StudentDTO getStudent(StudentDTO pDTO) throws Exception;

    // 학생 삭제 쿼리
    void deleteStudent(StudentDTO pDTO) throws Exception;
    // 학생 수정 쿼리
    void updateStudent(StudentDTO pDTO) throws Exception;
}

// 자바에서 바로 xml을 연결시킬 수 없기 때문에 mapper 인터페이스(자바)와 xml파일(sql쿼리가 들어있음)을
// 연결해서 사용한다.
