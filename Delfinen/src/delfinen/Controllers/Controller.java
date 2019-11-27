package delfinen.Controllers;

import delfinen.DataMapper.DataMapperMedlem;
import delfinen.DataMapper.DataMapperResultat;
import delfinen.Model.Medlem;
import static delfinen.View.MainMenu.visFormandMenu;
import static delfinen.View.MainMenu.visHovedMenu;
import static delfinen.View.MainMenu.visKasserMenu;
import static delfinen.View.MainMenu.visTraenerMenu;
import java.sql.SQLException;
import java.util.Scanner;

public class Controller {

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
                    System.out.println("Noget gik galt... Systemet gik ned.");
                }
            }
        }
    }
    
    public static void runDirectorProgram() throws SQLException, ClassNotFoundException {
        boolean quit = false;
        while(quit == false) {
            visFormandMenu();
            String brugerInput = scan.nextLine();
            
            switch(brugerInput) {
                case "1":
                    Medlem medlem = Medlem.makeMedlem();
                    DataMapperMedlem.medlemInsert(medlem);
                    break;
                    
                case "2":
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
                    System.out.println("Noget gik galt... Systemet gik ned.");
                }
            }
        }
    }
    
    public static void runCashierProgram() {
        boolean quit = false;
        while(quit == false) {
            visKasserMenu();
            String brugerInput = scan.nextLine();
            
            switch(brugerInput) {
                case "1":
                    break;
                case "2":
                    break;
                case "3":
                    break;
                case "4":
                    quit = true;
                    System.out.println("Programmet er lukket ned.");
                    break;
                default: {
                    System.out.println("Noget gik galt... Systemet gik ned.");
                }
            }
        }
    }
    
    public static void runTrainerProgram() throws ClassNotFoundException, SQLException {
        boolean quit = false;
        while(quit == false) {
            visTraenerMenu();
            String brugerInput = scan.nextLine();
            boolean isOn = true;
            switch(brugerInput) {
                case "1":
                    break;
                case "2":
                    while(isOn){
                        System.out.println("Navnet på medlemmet du vil opdatere?:");
                        String navn = scan.nextLine();
                        System.out.println("Hvilken disciplin?:");
                        String disciplin = scan.nextLine();
                        System.out.println("");
                    }
                    break;
                case "3":
                    break;
                case "4":
                    break;
                case "5":
                    DataMapperResultat.visResultater();
                    break;
                case "6":
                    break;
                case "7":
                    quit = true;
                    System.out.println("Programmet er lukket ned.");
                    break;
                default: {
                    System.out.println("Noget gik galt... Systemet gik ned.");
                }
            }
        }
    }

}
