/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.backing;

import java.util.ArrayList;
import java.util.List;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;

/**
 *
 * @author kuadam
 */
@Named(value = "tableBean")
@RequestScoped
public class TableBean {

    private final List<Student> students = new ArrayList<>();

    /**
     * Creates a new instance of TableBean
     */
    public TableBean() {
        students.add(new Student("Jan", "Kowalski", 4.5));
        students.add(new Student("Marek", "Nowak", 4.2));
        students.add(new Student("Bartek", "P", 4.3));
        students.add(new Student("Mateusz", "W", 4.12));
        students.add(new Student("Jan", "B", 4.12));
        students.add(new Student("Marek", "A", 4.12));
    }

    /**
     * @return the students
     */
    public List<Student> getStudents() {
        return students;
    }

}
