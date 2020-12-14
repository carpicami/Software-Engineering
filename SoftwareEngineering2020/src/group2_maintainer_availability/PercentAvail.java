package group2_maintainer_availability;

/**
 *
 * @author Pierluigi Giangiacomi
 */
public class PercentAvail {//Classe contenente le percentuali per giorno della settimana
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
