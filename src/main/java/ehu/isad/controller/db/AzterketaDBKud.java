package ehu.isad.controller.db;

import ehu.isad.model.URLModel;

import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.NoSuchAlgorithmException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.security.MessageDigest;

public class AzterketaDBKud {

    private static final AzterketaDBKud instance = new AzterketaDBKud();
    public static AzterketaDBKud getInstance() {
        return instance;
    }

    private AzterketaDBKud() {
    }



    public URLModel datuBaseanDago(String url) throws NoSuchAlgorithmException {
        String md5 = md5Lortu(url);
        String query = "SELECT * FROM checsums WHERE md5='" + md5 + "'";
        DBKudeatzailea dbKudeatzailea = DBKudeatzailea.getInstance();
        ResultSet rs = dbKudeatzailea.execSQL(query);
        URLModel emaitza = null;
        try {
            if (rs.next() && md5.equals(rs.getString("md5"))) {
                int id = rs.getInt("idCMS");
                String version = rs.getString("version");
                String path = rs.getString("path");
                emaitza = new URLModel(id, version, md5, path, url);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return emaitza;
    }

    public String md5Lortu(String url) {
        //url * "/README" pasatu eta md5 itzultzen du
        String hash = "";
        return hash;
    }
}