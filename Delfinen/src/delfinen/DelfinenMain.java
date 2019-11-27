package delfinen;

import delfinen.Controllers.Controller;
import delfinen.DataMapper.DataMapperKonkurrence;
import delfinen.DataMapper.DataMapperMedlem;
import delfinen.DataMapper.DataMapperRestance;
import delfinen.DataMapper.DataMapperResultat;
import delfinen.Model.KonkurrenceResultat;
import delfinen.Model.Medlem;
import delfinen.Model.Resultat;
import delfinen.ResultatI.ResultatI;
import java.sql.SQLException;


public class DelfinenMain {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        //DataMapperRestance.visRestancer();
        //DataMapperResultat.visResultater();
        //String konkurrence, int placering, String tid, String medlemNavn) {
        //KonkurrenceResultat kr = new KonkurrenceResultat("NSJ cup", 1, "10:20", "Timmy");
        //DataMapperKonkurrence.konkurrenceInsert(kr);
        //ResultatI res1 = new Resultat("20:20", "27-11-2019", "John", "Crawl", 200);
        //res1.gemIDB();
        //DataMapperResultat.visResultater();
        Controller.runProgram();
        
    }

}
