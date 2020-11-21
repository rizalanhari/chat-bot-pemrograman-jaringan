/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Server;

import DBConnection.Connect;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author rizal
 */
public class Answer {

    String answer;

    String setAnswer(String question) {
        try {
            String query = "SELECT * FROM answer where question = '" + question + "'";
            Connection conn = (Connection) Connect.koneksiDB();
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(query);
            if (rs.next()) {
                answer = rs.getString("answer");
            } else {
                answer = "???";
            }
            st.close();
        } catch (SQLException e) {
            System.out.println(e);
        }
        return answer;
    }

}
