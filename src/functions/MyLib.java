package functions;

import java.time.LocalDateTime;

public class MyLib {


    public static void mostraMenu() {
        System.out.println("MENU:");
        System.out.println("0 - Sortir");
        System.out.println("1 - Afegir peli");
    }

    public static LocalDateTime getLocalDateTimeByString(String dataProjeccio) { // dd/mm/yyyy-hh:mm
        String[] arrayData = dataProjeccio.split("-");
        String[] arrayDataPartida = arrayData[0].split("/");
        String[] arrayHoraPartida = arrayData[1].split(":");

        LocalDateTime ldt = LocalDateTime.of(Integer.parseInt(arrayDataPartida[2]),
                Integer.parseInt(arrayDataPartida[1]),
                Integer.parseInt(arrayDataPartida[0]),
                Integer.parseInt(arrayHoraPartida[0]),
                Integer.parseInt(arrayHoraPartida[1])
                );

        return ldt;


    }

    public static LocalDateTime getLocalDateEnd(LocalDateTime ldtInici, int durada) {

        LocalDateTime ldt = ldtInici.plusMinutes(durada);
        return ldt;

    }

    public static boolean checkRoomMovieFree(LocalDateTime ldtInici, LocalDateTime ldtFi, LocalDateTime[][] llistaIniciFi, int comptaror_pelis, String[][] llistaPelis, String sala) {

        for(int i=0; i<comptaror_pelis; i++){

            if(sala.equalsIgnoreCase(llistaPelis[i][1])){
                if(ldtInici.isAfter(llistaIniciFi[i][0]) && ldtInici.isBefore(llistaIniciFi[i][1])){
                    return false;
                }else if(ldtFi.isAfter(llistaIniciFi[i][0]) && ldtFi.isBefore(llistaIniciFi[i][1])){
                    return false;
                }else if(ldtInici.isEqual(llistaIniciFi[i][0])){
                    return false;
                }else if(ldtInici.isBefore(llistaIniciFi[i][0]) && ldtFi.isAfter(llistaIniciFi[i][1])){
                    return false;
                }
            }

        }

        return true;

    }
}
