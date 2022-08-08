package rikkei.academy.service.student;

import rikkei.academy.model.Student;
import rikkei.academy.service.IGeneric;

public interface IStudentService extends IGeneric<Student> {
    public void delete(int index);

}
