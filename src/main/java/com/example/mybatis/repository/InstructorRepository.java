package com.example.mybatis.repository;


import com.example.mybatis.model.Instructor;
import org.apache.ibatis.annotations.*;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;

import javax.management.MXBean;
import java.util.List;

@Mapper
public interface InstructorRepository {
    @Select("select * from instructors ")
    @Results(id = "instructorMapper", value = {
            @Result(property = "instructorId",column = "instructor_id"),
            @Result(property = "instructorName",column = "instructor_name"),
            @Result(property = "instructorEmail",column = "email")
    })
    List<Instructor> findAllInstructors();

    @Select("""
        select * from instructors 
        where instructor_id = #{id}
""")

    @ResultMap("instructorMapper")
    Instructor findInstructorById(Integer id);


    @Select("""
    insert into instructors(instructor_name, email)
    values (#{instructor.instructorName}, #{instructor.email} )
    returning *

""")

    @ResultMap("instructorMapper")
    Instructor insertinstructor(@Param("instructor") Instructor instructor);


//    @Select("""
//    select * from instructor
//    where instructorId ==?
//""")
    @Delete("""
        DELETE FROM instructors WHERE instructor_id = #{id}
    """)
    void deleteInstructorById(@Param("id") Integer id);

//    @PutMapping("/{id}")
//    public default Instructor updateInstructorById(@PathVariable Integer id){
//        for(Instructor instructor : insertinstructor(@Param("instructor"))){
//            if(instructor.getInstructorId() == id){
//                instructor.setInstructorId(instructor.getInstructorId());
//                return instructor;
//            }
//        }
//        return null;
//    }

    @Update("""
        UPDATE instructors
        SET instructor_name = #{instructor.instructorName}, 
            email = #{instructor.instructorEmail}
        WHERE instructor_id = #{instructor.instructorId}
    """)
    void updateInstructorById(@Param("instructor") Instructor instructor);
}
