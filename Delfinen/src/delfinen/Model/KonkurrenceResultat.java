package delfinen.Model;

import delfinen.DataMapper.DataMapperKonkurrence;
import delfinen.DataMapper.DataMapperResultat;
import delfinen.ResultatI.ResultatI;
import java.sql.SQLException;


public class KonkurrenceResultat implements ResultatI{
    private String konkurrence;
    private int placering;
    private String tid;
    private String medlemNavn;

    public KonkurrenceResultat(String konkurrence, int placering, String tid, String medlemNavn) {
        this.konkurrence = konkurrence;
        this.placering = placering;
        this.tid = tid;
        this.medlemNavn = medlemNavn;
    }

    @Override
    public void gemIDB() {
           try {
            DataMapperKonkurrence.konkurrenceInsert(this);
        } catch (SQLException ex) {
            System.out.println("SQLException");
        } catch (ClassNotFoundException ex) {
            System.out.println("ClassNotFoundException");
        }
    }

    public String getKonkurrence() {
        return konkurrence;
    }

    public void setKonkurrence(String konkurrence) {
        this.konkurrence = konkurrence;
    }

    public int getPlacering() {
        return placering;
    }

    public void setPlacering(int placering) {
        this.placering = placering;
    }

    public String getTid() {
        return tid;
    }

    public void setTid(String tid) {
        this.tid = tid;
    }

    public String getMedlemNavn() {
        return medlemNavn;
    }

    public void setMedlemNavn(String medlemNavn) {
        this.medlemNavn = medlemNavn;
    }

    
}
