package rikkei.academy.service.class_room;

import rikkei.academy.model.ClassRoom;
import rikkei.academy.service.IGeneric;

import java.util.List;

public interface IClassRoomService extends IGeneric<ClassRoom> {
    void create(ClassRoom classRoom);

    //    List<ClassRoom> findAll();
//    void save(ClassRoom classRoom);
    void delete(int index);
}
