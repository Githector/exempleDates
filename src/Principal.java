import functions.MyLib;

import java.time.LocalDateTime;
import java.util.Scanner;

public class Principal {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        final int MAX_PELIS = 100;

        String[][] llistaPelis = new String[MAX_PELIS][2];
        LocalDateTime[][] llistaIniciFi = new LocalDateTime[MAX_PELIS][2];

        int comptaror_pelis=0;

        boolean bucle = true;

        while(bucle){
            MyLib.mostraMenu();
            int opcio = sc.nextInt();
            sc.nextLine();

            switch (opcio){

                case 0:
                    System.out.println("Adeu");
                    bucle = false;
                    break;

                case 1:
                    System.out.print("Introdueix el nom de la peli: ");
                    String titol = sc.nextLine();

                    System.out.print("Introdueix la sala: ");
                    String sala = sc.nextLine();

                    System.out.print("Introdueix la durada de la película (minuts): ");
                    int durada = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Introdueix dia i hora de projecció (dd/mm/yyyy - hh:mm)");
                    String dataProjeccio = sc.nextLine();

                    LocalDateTime ldtInici = MyLib.getLocalDateTimeByString(dataProjeccio);
                    LocalDateTime ldtFi = MyLib.getLocalDateEnd(ldtInici,durada);

                    boolean free = MyLib.checkRoomMovieFree(ldtInici,ldtFi, llistaIniciFi, comptaror_pelis, llistaPelis,sala);

                    if(free){
                        llistaPelis[comptaror_pelis][0] = titol;
                        llistaPelis[comptaror_pelis][1] = sala;
                        llistaIniciFi[comptaror_pelis][0] = ldtInici;
                        llistaIniciFi[comptaror_pelis][1] = ldtFi;
                        comptaror_pelis++;

                    }else{
                        System.out.println("La sala està ocupada");
                    }




                    break;
            }
        }


    }

}
