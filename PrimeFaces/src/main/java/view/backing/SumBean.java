/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.backing;

import java.text.SimpleDateFormat;
import java.util.Date;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

/**
 *
 * @author kuadam
 */
@Named(value = "sumBean")
@RequestScoped
public class SumBean {

    private int number1;
    private int number2;
    private String sum = "=0";
    private String date;

    public SumBean() {
    }

    public void sum() {
        sum = "=" + Integer.toString(number1 + number2);

        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage("Growl", number1 + "+" + number2 + "=" + sum));
    }

    /**
     * @return the number1
     */
    public Integer getNumber1() {
        return number1;
    }

    /**
     * @param number1 the number1 to set
     */
    public void setNumber1(Integer number1) {
        this.number1 = number1;
    }

    /**
     * @return the number2
     */
    public Integer getNumber2() {
        return number2;
    }

    /**
     * @param number2 the number2 to set
     */
    public void setNumber2(Integer number2) {
        this.number2 = number2;
    }

    /**
     * @return the sum
     */
    public String getSum() {
        return sum;
    }

    /**
     * @return the date
     */
    public String getDate() {
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        Date date = new Date();
        return formatter.format(date);
    }

}
