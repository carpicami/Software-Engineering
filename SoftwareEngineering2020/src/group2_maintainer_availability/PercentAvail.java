/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package group2_maintainer_availability;

/**
 *
 * @author GiangiacomPi
 */
public class PercentAvail {
    private String nameM;
    private int[] percent;

    public PercentAvail(String nameM, int[] percent) {
        this.nameM = nameM;
        this.percent = percent;
    }

    public PercentAvail() {
        percent = new int[7];
    }

    public String getNameM() {
        return nameM;
    }

    public void setNameM(String nameM) {
        this.nameM = nameM;
    }

    public int[] getPercent() {
        return percent;
    }

    public void setPercent(int[] percent) {
        this.percent = percent;
    }
    
}
