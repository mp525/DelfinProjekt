package delfinen.Controllers;

import static delfinen.DataMapper.DataMapperKonkurrence.konkurrenceInsert;
import static delfinen.DataMapper.DataMapperKonkurrence.seKonkurrenceTabel;
import delfinen.DataMapper.DataMapperMedlem;
import delfinen.DataMapper.DataMapperRestance;
import delfinen.DataMapper.DataMapperResultat;
import delfinen.Model.KonkurrenceResultat;
import delfinen.Model.Medlem;
import delfinen.Model.Resultat;

import delfinen.ResultatI.ResultatI;
import static delfinen.View.MainMenu.visFormandMenu;
import static delfinen.View.MainMenu.visHovedMenu;
import static delfinen.View.MainMenu.visKasserMenu;
import static delfinen.View.MainMenu.visTraenerMenu;
import java.sql.SQLException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Controller {

    /*
    @Vibeke, @Mathias og @Matti
     */
    private static Scanner scan = new Scanner(System.in);

    public static void runProgram() throws SQLException, ClassNotFoundException {
        boolean quit = false;
        while (quit == false) {
            visHovedMenu();
            String brugerInput = scan.nextLine();

            switch (brugerInput) {
                case "1":
                    runDirectorProgram();
                    break;

                case "2":
                    runCashierProgram();
                    break;

                case "3":
                    runTrainerProgram();
                    break;

                case "4":
                    quit = true;
                    System.out.println("Programmet er lukket ned.");
                    break;

                default: {
                    System.out.println("Vælg venligst en af valgmulighederne.");
                }
            }
        }
    }

    public static void runDirectorProgram() throws SQLException, ClassNotFoundException {
        boolean quit = false;
        while (quit == false) {
            visFormandMenu();
            String brugerInput = scan.nextLine();

            switch (brugerInput) {
                case "1":
                    Medlem medlem = Medlem.makeMedlem();
                    try {
                        DataMapperMedlem.medlemInsert(medlem);
                    } catch (NullPointerException e) {
                        break;
                    }
                    break;

                case "2":
                    DataMapperMedlem.medlemUpdate();
                    break;

                case "3":
                    DataMapperMedlem.medlemDelete();
                    break;

                case "4":
                    DataMapperMedlem.medlemListe();
                    break;

                case "5":
                    quit = true;
                    System.out.println("Programmet er lukket ned.");
                    break;

                default: {
                    System.out.println("Vælg venligst en af valgmulighederne.");
                }
            }
        }
    }

    public static void runCashierProgram() throws ClassNotFoundException, SQLException {
        boolean quit = false;
        while (quit == false) {
            visKasserMenu();
            String brugerInput = scan.nextLine();

            switch (brugerInput) {
                case "1":
                    DataMapperRestance.visRestancer();
                    break;

                case "2":
                    boolean isOn = true;
                    while (isOn) {

                        System.out.println("For at gå tilbage tast 0");
                        System.out.println("For at tilføje restance på medlem tast 1.");
                        System.out.println("For at fjerne restance på medlem tast 2.");
                        int next = 0;
                        try {
                            next = scan.nextInt();
                            if (next == 0) {
                                throw new NullPointerException();
                            }
                            scan.nextLine();
                            isOn = false;
                        } catch (InputMismatchException e) {
                            System.out.println("Venligst tast enten 1 eller 2.");
                            scan.nextLine();

                        } catch (NullPointerException e) {
                            scan.nextLine();
                            isOn = false;
                        }

                        switch (next) {
                            case 1:
                                DataMapperRestance.visUdenRestancer();
                                DataMapperRestance.addRestance();
                                isOn = false;
                                break;

                            case 2:
                                isOn = false;
                                DataMapperRestance.removeRestance();
                                break;
                        }
                    }
                    break;
                case "3":
                    quit = true;
                    System.out.println("Programmet er lukket ned.");
                    break;
                default:
                    System.out.println("Vælg venligst en af valgmulighederne.");

            }
        }
    }

    public static void runTrainerProgram() throws ClassNotFoundException, SQLException {
        boolean quit = false;
        while (quit == false) {
            visTraenerMenu();
            String brugerInput = scan.nextLine();
            boolean isOn = true;
            switch (brugerInput) {
                case "1":
                    DataMapperMedlem.medlemListe();
                    break;
                case "2":
                    try {
                        ResultatI resultat = Resultat.makeResultat();
                        resultat.gemIDB();
                    } catch (NullPointerException e) {
                        break;
                    }
                    break;
                case "3":
                    try {
                        ResultatI k = KonkurrenceResultat.makekonkurrence();
                        k.gemIDB();
                        System.out.println("Konkurrence resultat er gemt!");
                    } catch (NullPointerException e) {
                        break;
                    }
                    break;
                case "4":
                    DataMapperResultat.visTop5();
                    break;
                case "5":
                    DataMapperResultat.visResultater();
                    break;
                case "6":
                    seKonkurrenceTabel();
                    break;
                case "7":
                    quit = true;
                    System.out.println("Programmet er lukket ned.");
                    break;
                default: {
                    System.out.println("Vælg venligst en af valgmulighederne.");
                }
            }
        }
    }

}
