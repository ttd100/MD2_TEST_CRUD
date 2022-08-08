package rikkei.academy.controller;

import rikkei.academy.model.ClassRoom;
import rikkei.academy.model.Student;
import rikkei.academy.service.MyList;
import rikkei.academy.service.class_room.ClassRoomServiceIMPL;
import rikkei.academy.service.student.StudentServiceIMPL;
import rikkei.academy.service.student.IStudentService;

import java.util.List;

public class StudentController {
    StudentServiceIMPL studentService = new StudentServiceIMPL();
    public List<Student> showListStudent(){
        return new StudentServiceIMPL().findAll();
    }
    public void createStudent( Student student){
       new StudentServiceIMPL().save(student);
    }
    public List<Student> getStudentList() {
        return StudentServiceIMPL.studentList;
    }

    public Student getStudent(int id) {

        return getStudentList().get(id - 1);
    }
    public void createStudent(String studentName, int classroomId) {
        studentService.create(
                new Student(
                        StudentServiceIMPL.studentList.size() + 1,
                        studentName,
                        new ClassRoom(classroomId, ClassRoomServiceIMPL.classroomList.get(classroomId - 1).getName()
                        )
                )
        );
    }
    public void editStudentName(int id, String name) {
        studentService.edit(
                new Student(
                        id,
                        name,
                        StudentServiceIMPL.studentList.get(id - 1).getClassRoom()
                )
        );
    }

    public void editStudentClass(int id, int classroomId) {
        studentService.edit(
                new Student(
                        id,
                        StudentServiceIMPL.studentList.get(id - 1).getName(),
                        ClassRoomServiceIMPL.classroomList.get(classroomId - 1)
                )
        );
    }

    public void deleteStudent(int id) {
        studentService.delete(id - 1);
        updateList(id - 1);
    }

    private void updateList(int index) {
        for (int i = index; i < StudentServiceIMPL.studentList.size(); i++) {
            StudentServiceIMPL.studentList.get(i).setId(i + 1);
        }
    }

    public List<Student> searchStudentByName(String name) {
        List<Student> nameSearch = new MyList<>();
        for (Student student : StudentServiceIMPL.studentList) {
            if (student.getName().equalsIgnoreCase(name)) {
                nameSearch.add(student);
            }
        }
        return nameSearch;
    }

    public List<Student> searchStudentByClassroom(int classroomId) {
        List<Student> classroomSearch = new MyList<>();
        for (Student student : StudentServiceIMPL.studentList) {
            if (student.getClassRoom().getId() == classroomId) {
                classroomSearch.add(student);
            }
        }
        return classroomSearch;
    }

}
