/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.reto.model.dao;

import com.mycompany.reto.model.vo.Consulta1Vo;
import com.mycompany.reto.model.vo.Consulta3Vo;
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
public class Consulta3Dao {
    public List<Consulta3Vo> listar() throws SQLException{
        ArrayList<Consulta3Vo> respuesta = new ArrayList<Consulta3Vo>();
        Connection conn = JDBCUtilities.getConnection();
        Statement stmt = null;
        ResultSet rs=null;
        String consulta = "SELECT ID_Compra as ID, Proveedor as Proveedor, p.Constructora as Constructora, p.Banco_Vinculado as Banco"
                            +" FROM Compra c"
                            +" INNER JOIN Proyecto p ON c.ID_Proyecto = p.ID_Proyecto"
                            +" WHERE p.Ciudad = 'Salento' AND c.Proveedor = 'Homecenter';";
        try{
            stmt = conn.createStatement();
            rs=stmt.executeQuery(consulta);
            while(rs.next()){
                Consulta3Vo objeto = new Consulta3Vo();
                objeto.setId(rs.getInt("id"));
                objeto.setProveedor(rs.getString("proveedor"));
                objeto.setConstructora(rs.getString("constructora"));
                objeto.setBanco(rs.getString("banco"));
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
