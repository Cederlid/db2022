package se.iths;

import java.util.ArrayList;
import java.util.Collection;

public class School {
    private final int schoolId;
    private String name;
    private String city;
    private Collection<Student> students = new ArrayList<>();


    public School(int schoolId, String name, String city) {
        this.schoolId = schoolId;
        this.name = name;
        this.city = city;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public long getSchoolId() {
        return schoolId;
    }

    public Collection<Student> getStudents() {
        return students;
    }

    public void setStudents(Collection<Student> students) {
        this.students = students;
    }

    public String toString(){
        return String.format("%d %s", schoolId, name, city);
    }



}
