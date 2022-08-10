/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.reto.model.dao;

import com.mycompany.reto.model.vo.Consulta1Vo;
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
public class Consulta1Dao {
    public List<Consulta1Vo> listar() throws SQLException{
        ArrayList<Consulta1Vo> respuesta = new ArrayList<Consulta1Vo>();
        Connection conn = JDBCUtilities.getConnection();
        Statement stmt = null;
        ResultSet rs=null;
        String consulta = "SELECT ID_Lider as ID, Nombre as Nombre, Primer_Apellido as Apellido, Ciudad_Residencia as Ciudad"
                            +" FROM Lider l"
                            +" ORDER BY Ciudad_Residencia ASC;";
        try{
            stmt = conn.createStatement();
            rs=stmt.executeQuery(consulta);
            while(rs.next()){
                Consulta1Vo objeto = new Consulta1Vo();
                objeto.setId(rs.getInt("id"));
                objeto.setNombre(rs.getString("nombre"));
                objeto.setApellido(rs.getString("apellido"));
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
