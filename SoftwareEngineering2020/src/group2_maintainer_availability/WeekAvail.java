package group2_maintainer_availability;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Pierluigi Giangiacomi 
 * 
 */
public class WeekAvail { //Classe contenente le disponibilità giornaliere dei maintainer

    private String nameM;
    private Map<Integer, Integer[]> map = new HashMap<>();

    public WeekAvail(String nameM) {
        this.nameM = nameM;

        for (int i = 0; i < 7; i++) {
            map.put(i, new Integer[]{60, 60, 60, 60, 60, 60, 60, 60, 60});
        }
    }

    public Map<Integer, Integer[]> getMap() {
        return map;
    }

    public void setMap(Map<Integer, Integer[]> map) {
        this.map = map;
    }

    public String getNameM() {
        return nameM;
    }

    public void setNameM(String nameM) {
        this.nameM = nameM;
    }

}
