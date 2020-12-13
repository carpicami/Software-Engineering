/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package group2_maintainer_availability;

import group2_JDBC.ConnectionPostgreSQLSingleton;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class ServiceAvailability {

    private Connection connection;

    public ServiceAvailability() {
        ConnectionPostgreSQLSingleton conn = ConnectionPostgreSQLSingleton.getInstance(); //chiamata al singleton
        connection = conn.getConnection();
    }

    public List<WeekAvail> getAvailability(Integer settimana) throws SQLException, Exception {
        PreparedStatement pstm = null;
        ResultSet rs = null;
        pstm = connection.prepareStatement("select DISP.orario_inizio,DISP.orario_fine, DISP.giorno, MAN.nome "
                + "from disponibilita_p DISP, planned PL, mantainer MAN "
                + "where MAN.id_mantainer=DISP.id_mantainer and DISP.id_attivita_p=PL.id_attivita_p and PL.settimana=?");
        pstm.setInt(1, settimana);
        rs = pstm.executeQuery();
        List<String> names = new ArrayList<>();
        List<WeekAvail> allAvail = new ArrayList<>();
        while (rs.next()) {
            String name = rs.getString("nome");
            if (!names.contains(name)) {
                names.add(name);
                WeekAvail avail = new WeekAvail(name);
                allAvail.add(avail);
            }
            Integer giorno = rs.getInt("giorno");
            Time time1 = rs.getTime("orario_inizio");
            LocalTime start = LocalTime.of(time1.getHours(), time1.getMinutes());
            int a = getIndex(start.getHour());
            int minutoStart = start.getMinute();
            int time = getTimeBeetween(time1, rs.getTime("orario_fine"));

            allAvail.stream().filter(avail -> (avail.getNameM().equals(name))).forEachOrdered(avail -> {
                if (time > 60) {
                    avail.getMap().get(giorno)[a] = minutoStart;
                    int time2 = time - (60 - minutoStart);
                    if (time2 > 60) {
                        int oreFull = time2 / 60;
                        int i = a;
                        for (; i < a + oreFull; i++) {
                            avail.getMap().get(giorno)[i] = 0;
                        }
                        avail.getMap().get(giorno)[i] = time2 - (60 * oreFull);
                    } else {
                        avail.getMap().get(giorno)[a + 1] = avail.getMap().get(giorno)[a + 1] - time2;
                    }
                } else {
                    avail.getMap().get(giorno)[a] = avail.getMap().get(giorno)[a] - time;
                }
            });
        }
        allAvail.addAll(getOtherMaintainerAvailability(names));
        return allAvail;
    }
    
    public List<PercentAvail> getAvailabilityPercent(int settimana) throws Exception{
        List<PercentAvail> percentList = new ArrayList<>();
        List<WeekAvail> availabilityMin = getAvailability(settimana);
        availabilityMin.forEach((element) -> {
            PercentAvail pa = new PercentAvail();
            pa.setNameM(element.getNameM());
            element.getMap().forEach((k, v) -> {
                int somma=0;
                for (Integer v1 : v) {
                    somma += v1;
                }
                float i = (60*v.length);
                float res=(somma/i);
                float res2 = res * 100;
                pa.getPercent()[k]=(int)res2;
                });
                percentList.add(pa);
        });
        return percentList;
    }

    private int getIndex(int orario) throws Exception {
        int index = orario - 8;
        if ((index >= 0) && (index <= 8)) {
            return index;
        }
        throw new Exception("L'orario di inizio attività non è incluso nel range");
    }

    private int getTimeBeetween(Time time1, Time time2) {
        String time11 = time1.toString();
        String time22 = time2.toString();
        String[] split1 = time11.split(":");
        String[] split2 = time22.split(":");
        Integer minutiIniziali = (Integer.parseInt(split1[0]) * 60) + Integer.parseInt(split1[1]);
        Integer minutiFinali = (Integer.parseInt(split2[0]) * 60) + Integer.parseInt(split2[1]);
        Integer differenzaMinuti = minutiFinali - minutiIniziali;
        return differenzaMinuti;
    }

    private List<WeekAvail> getOtherMaintainerAvailability(List<String> busyMaintainer) throws SQLException {
        PreparedStatement pstm = null;
        ResultSet rs = null;
        pstm = connection.prepareStatement("select distinct nome from mantainer");
        rs = pstm.executeQuery();
        List<String> names = new ArrayList<>();
        List<WeekAvail> avails = new ArrayList<>();
        while (rs.next()) {
            if (!busyMaintainer.contains(rs.getString("nome"))) {
                avails.add(new WeekAvail(rs.getString("nome")));
            }
        }
        return avails;
    }
}
