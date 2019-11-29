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
        
        Controller.runProgram();
        
    }

}
