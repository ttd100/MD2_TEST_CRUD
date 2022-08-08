package rikkei.academy.service.student;

import rikkei.academy.model.Student;
import rikkei.academy.service.class_room.ClassRoomServiceIMPL;

import java.util.ArrayList;
import java.util.List;

public class StudentServiceIMPL implements IStudentService{
    public static List<Student> studentList = (new ArrayList<Student>() {
        @Override
        public String toString() {
            String list = "Student List:\n";
            list += "=================================================\n";
            for (Student student : this) {
                list += student.toString() + "\n";
            }
            list += "=================================================\n";
            return list;
        }
    });

    static {
        studentList.add(new Student(1,"Dat", ClassRoomServiceIMPL.classroomList.get(0)));
        studentList.add(new Student(1,"Khanh", ClassRoomServiceIMPL.classroomList.get(1)));
    }
    @Override
    public List<Student> findAll() {
        return studentList;
    }

    @Override
    public void save(Student student) {
        studentList.add(student);
    }
    @Override
    public void create(Student student) {
        studentList.add(student);
    }

    @Override
    public void edit(Student student) {
        studentList.get(student.getId() - 1).setName(student.getName());
        studentList.get(student.getId() - 1).setClassRoom(student.getClassRoom());
    }

    public void delete(int index){
        studentList.remove(index);
    }
}
