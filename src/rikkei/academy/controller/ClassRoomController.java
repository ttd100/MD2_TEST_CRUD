package rikkei.academy.controller;

import rikkei.academy.model.ClassRoom;
import rikkei.academy.service.class_room.ClassRoomServiceIMPL;
import rikkei.academy.service.class_room.IClassRoomService;


import java.util.List;

public class ClassRoomController {
    IClassRoomService classRoomService = new ClassRoomServiceIMPL();
    public List<ClassRoom> getClassroomList() {
        return ClassRoomServiceIMPL.classroomList;
    }
    public List<ClassRoom> showListClassRoom(){
        return classRoomService.findAll();
    }
    public void createClassRoom(ClassRoom classRoom){
        classRoomService.save(classRoom);
    }
    public void editClassRoom(int id , String classRoomName){
        classRoomService.edit(new ClassRoom(id,classRoomName));
    }

    public void delete(int id){
        classRoomService.delete(id -1);
        updateList(id -1);
    }
    private void updateList(int index){
        for (int i = 0; i<ClassRoomServiceIMPL.classroomList.size();i++){
            ClassRoomServiceIMPL.classroomList.get(i).setId(i+1);
        }
    }
    public boolean contains(String name){
        for (ClassRoom classroom:classRoomService.findAll()) {
            if (classroom.getName().equals(name))return true;
        }
        return false;
    }
    public void createClassRoom(String classroomName) {
        classRoomService.create(new ClassRoom(ClassRoomServiceIMPL.classroomList.size() + 1, classroomName));
    }


}
