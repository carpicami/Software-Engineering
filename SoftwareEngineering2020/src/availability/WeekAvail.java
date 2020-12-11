/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package availability;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author GiangiacomPi Classe contenente le disponibilità giornaliere dei
 * maintainer
 */
public class WeekAvail {

    private String nameM;
    private Map<Integer, Integer[]> map = new HashMap<>();
    private Map<String, Float[]> percentage = new HashMap<>();

    public WeekAvail(String nameM) {
        this.nameM = nameM;

        for (int i = 1; i < 8; i++) {
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
