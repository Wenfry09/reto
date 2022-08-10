/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.reto.model.dao;

import com.mycompany.reto.model.vo.ComprasDeLiderVo;
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
public class ComprasDeLiderDao {
    public List<ComprasDeLiderVo> listar() throws SQLException{
        ArrayList<ComprasDeLiderVo> respuesta = new ArrayList<ComprasDeLiderVo>();
        Connection conn = JDBCUtilities.getConnection();
        Statement stmt = null;
        ResultSet rs=null;
        String consulta = "SELECT L.NOMBRE ||' '|| L.PRIMER_APELLIDO ||' '|| L.SEGUNDO_APELLIDO AS LIDER, SUM(C.CANTIDAD*MC.PRECIO_UNIDAD) AS VALOR"
                            +" FROM LIDER L"
                            +" JOIN PROYECTO P ON L.ID_LIDER = P.ID_LIDER" 
                            +" JOIN COMPRA C ON C.ID_PROYECTO = P.ID_PROYECTO" 
                            +" JOIN MATERIALCONSTRUCCION MC ON MC.ID_MATERIALCONSTRUCCION = C.ID_MATERIALCONSTRUCCION"
                            +" GROUP BY LIDER"
                            +" ORDER BY VALOR DESC"
                            +" LIMIT 10;";
        try{
            stmt = conn.createStatement();
            rs=stmt.executeQuery(consulta);
            while(rs.next()){
                ComprasDeLiderVo objeto = new ComprasDeLiderVo();
                objeto.setLider(rs.getString("lider"));
                objeto.setValor(rs.getDouble("valor"));
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
