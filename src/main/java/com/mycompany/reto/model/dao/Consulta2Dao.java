/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.reto.model.dao;

import com.mycompany.reto.model.vo.Consulta2Vo;
import com.mycompany.reto.util.JDBCUtilities;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Jhon Rodríguez
 */
public class Consulta2Dao {
    public List<Consulta2Vo> listar() throws SQLException{
        ArrayList<Consulta2Vo> respuesta = new ArrayList<Consulta2Vo>();
        Connection conn = JDBCUtilities.getConnection();
        Statement stmt = null;
        ResultSet rs=null;
        String consulta = "SELECT ID_Proyecto as ID, Constructora as Constructora, Numero_Habitaciones as Habitaciones, Ciudad as Ciudad"
                            +" FROM Proyecto p"
                            +" WHERE Ciudad IN ('Santa Marta', 'Cartagena', 'Barranquilla') AND Clasificacion = 'Casa Campestre';";
        try{
            stmt = conn.createStatement();
            rs=stmt.executeQuery(consulta);
            while(rs.next()){
                Consulta2Vo objeto = new Consulta2Vo();
                objeto.setId(rs.getInt("id"));
                objeto.setConstructora(rs.getString("constructora"));
                objeto.setHabitaciones(rs.getInt("habitaciones"));
                objeto.setCiudad(rs.getString("ciudad"));
                respuesta.add(objeto);
            }

        }finally{
            if(rs!=null){
                rs.close();
            }
            if(stmt!=null){
                stmt.close();
            }
            if(conn!=null){
                conn.close();
            }
        }
        return respuesta;
    }
}
