/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.backing;

/**
 *
 * @author kuadam
 */
public class Student {

    private String name;
    private String surname;
    private double avg;

    public Student(String name, String surname, double avg) {
        this.name = name;
        this.surname = surname;
        this.avg = avg;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the surname
     */
    public String getSurname() {
        return surname;
    }

    /**
     * @param surname the surname to set
     */
    public void setSurname(String surname) {
        this.surname = surname;
    }

    /**
     * @return the avg
     */
    public double getAvg() {
        return avg;
    }

    /**
     * @param avg the avg to set
     */
    public void setAvg(double avg) {
        this.avg = avg;
    }

}
