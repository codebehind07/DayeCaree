package com.example.daycaree.Teacher;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TeacherRepository extends JpaRepository<Teacher, Long> {

    @Query(nativeQuery = true, value = "Select COUNT(*) from Teacher where firstname = :firstname AND lastname = :lastname")
    Integer findByFirstnameAndLastname(@Param("firstname")String firstname, @Param("lastname")String lastname);

    @Query(nativeQuery = true, value = "Select * from Teacher ")
    List<Teacher> FindAllTeacher();

    @Query(nativeQuery = true, value = "Select Firstname as TFirstname,Lastname as TLastname,Phone as TPhone,Program as Tprogram , Address as TAddress from Teacher t inner join teacher_program tp on t.teacher_id = tp.teacher_id_fk   ")
    List<TeacherPrograms> FindAllTeachers();


    @Query(nativeQuery = true, value = "Select * from Teacher where Teacher_id = :TeacherId   ")
    Teacher findByTeacherId(@Param("TeacherId")Integer TeacherId);

}