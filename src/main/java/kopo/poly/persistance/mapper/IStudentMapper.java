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
}
