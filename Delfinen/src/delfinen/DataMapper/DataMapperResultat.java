package delfinen.DataMapper;

import delfinen.Model.Resultat;
import delfinen.Util.DBConnector;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class DataMapperResultat {
    
    /*
    @Mathias
    */

    public static void resultatInsert(Resultat resultat) throws SQLException, ClassNotFoundException {
        Connection myConnector = null;
        PreparedStatement pstmt = null;

        myConnector = DBConnector.getConnector();

        String query = "insert into resultater (Navn, Tid, Dato, Disciplin, Længde) values (?, ?, ?, ?, ?);";
        pstmt = myConnector.prepareStatement(query);
        pstmt.setString(1, resultat.getMedlemNavn());
        pstmt.setDouble(2, resultat.getTid());
        pstmt.setString(3, resultat.getDato());
        pstmt.setString(4, resultat.getDiciplin());
        pstmt.setInt(5, resultat.getLængde());

        pstmt.execute();

        pstmt.close();
        myConnector.close();
    }

    public static void visResultater() throws ClassNotFoundException, SQLException {
        ArrayList<Resultat> resultater = new ArrayList();
        Connection myConnector = null;
        Statement statement = null;
        ResultSet resultSet = null;

        myConnector = DBConnector.getConnector();
        String query = "select * from Resultater";

        statement = myConnector.createStatement();
        resultSet = statement.executeQuery(query);
        while (resultSet.next()) {
            String navn = resultSet.getString("Navn");
            double tid = resultSet.getDouble("Tid");
            String dato = resultSet.getString("Dato");
            String disciplin = resultSet.getString("Disciplin");
            int længde = resultSet.getInt("Længde");
            Resultat resultat = new Resultat(tid, dato, navn, disciplin, længde);
            resultater.add(resultat);
        }
        for (Resultat resultat1 : resultater) {
            System.out.println(resultat1.toString());
        }

        statement.close();
        resultSet.close();
        myConnector.close();

    }

    public static void visTop5() throws ClassNotFoundException, SQLException {
        boolean isOn = true;
        while (isOn) {
            Scanner myScan = new Scanner(System.in);
            ArrayList<String> top5 = new ArrayList();
            Connection myConnector = null;
            //PreparedStatement pstmt = null;
            Statement statement = null;
            ResultSet resultSet = null;
            String query = "";
            boolean isOn2 = true;
            String disc = "";
            while(isOn2){
            System.out.println("Hvilen disciplin vil du se top 5 i? (Crawl, Butterfly, Rygcrawl eller Brystsvoemning):");
            disc = myScan.nextLine();
            
            if(disc.equals("Crawl")){    
                isOn2 = false;
            }
            else if(disc.equals("Butterfly")){       
                isOn2 = false;
            }
            else if(disc.equals("Rygcrawl")){   
                isOn2 = false;
            }
            else if(disc.equals("Brystsvoemning")){  
                isOn2 = false;
            }
            
            }
            boolean isOn3 = true;
            while (isOn3) {
                System.out.println("Hvilket hold vil du se?\n 1) Junior\n 2) Senior:");
                try {
                    int hold = myScan.nextInt();
                    myScan.nextLine();
                    isOn3 = false;

                    switch (hold) {
                        case 1:
                            query = "select r.Navn, r.Tid, r.Disciplin, m.alder from resultater as r join medlemmer as m on r.Navn = m.Navn where disciplin = \"" + disc + "\" and alder < 18 order by tid asc";
                            break;
                        case 2:
                            query = "select r.Navn, r.Tid, r.Disciplin, m.alder from resultater as r join medlemmer as m on r.Navn = m.Navn where disciplin = \"" + disc + "\" and alder >= 18 order by tid asc";
                            break;
                    }
                } catch (InputMismatchException e) {
                    System.out.println("Tast enten 1 eller 2.");
                    myScan.nextLine();
                }
            }
            myConnector = DBConnector.getConnector();

            statement = myConnector.createStatement();
            resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                String navn = resultSet.getString("Navn");
                double tid = resultSet.getDouble("Tid");
                String disciplin = resultSet.getString("Disciplin");
                String topMedlem = "Navn: " + navn + ", Tid: " + tid + ", Disciplin: " + disciplin;
                top5.add(topMedlem);

            }
            for (String topmedlem : top5) {
                System.out.println(topmedlem);
            }

            resultSet.close();
            myConnector.close();
            isOn = false;

        }
    }

}
