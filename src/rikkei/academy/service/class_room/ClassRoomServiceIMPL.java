package rikkei.academy.service.class_room;

import rikkei.academy.model.ClassRoom;

import java.util.ArrayList;
import java.util.List;

public class ClassRoomServiceIMPL implements IClassRoomService {
    public static List<ClassRoom> classroomList = new ArrayList<ClassRoom>() {
        @Override
        public String toString() {
            String list = "Classroom List:\n";
            list += "==================================\n";
            for (ClassRoom classroom : this) {
                list += classroom.toString() + "\n";
            }
            list += "==================================\n";
            return list;
        }
    };
    static {
        classroomList.add(new ClassRoom(1,"JV062022"));
        classroomList.add(new ClassRoom(2,"JS072022"));
    }
    @Override
    public void create(ClassRoom classRoom) {
        classroomList.add(classRoom);
    }
    @Override
    public List<ClassRoom> findAll() {
        return classroomList;
    }

    @Override
    public void save(ClassRoom classRoom) {
        classroomList.add(classRoom);
    }
    public void edit(ClassRoom classRoom){
        classroomList.get(classRoom.getId()-1).setName(classRoom.getName());
    }
    public void delete(int index){
        classroomList.remove(index);
    }
}
