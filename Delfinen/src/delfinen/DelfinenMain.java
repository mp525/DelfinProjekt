package delfinen;

import delfinen.Controllers.Controller;
import delfinen.DataMapper.DataMapperMedlem;
import delfinen.DataMapper.DataMapperResultat;
import delfinen.Model.Medlem;
import delfinen.Model.Resultat;
import delfinen.ResultatI.ResultatI;
import java.sql.SQLException;


public class DelfinenMain {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        DataMapperResultat.visResultater();
        //ResultatI res1 = new Resultat("20:20", "27-11-2019", "John", "Crawl", 200);
        //res1.gemIDB();
        //DataMapperResultat.visResultater();
        //Controller.runProgram();
        
    }

}
