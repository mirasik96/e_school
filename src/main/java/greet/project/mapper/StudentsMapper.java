package greet.project.mapper;

import greet.project.model.Student;
import org.apache.ibatis.annotations.*;

import javax.websocket.server.PathParam;
import java.util.List;

@Mapper
public interface StudentsMapper {

    @Select("select * from students")
    public List<Student> findAll();

    @Insert("insert into students(name,school) values(#{name},#{school})")
    @SelectKey(statement = "CALL SCOPE_IDENTITY()", keyProperty = "id",
            before = false, resultType = Long.class)
    void insert(Student student);

    @Delete("delete from students where id=#{id}")
    void delete(@PathParam("id") Long id);
}
