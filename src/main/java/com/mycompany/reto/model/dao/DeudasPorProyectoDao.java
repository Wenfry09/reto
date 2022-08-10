/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.reto.model.dao;

import com.mycompany.reto.model.vo.DeudasPorProyectoVo;
import com.mycompany.reto.util.JDBCUtilities;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Jhon Rodríguez
 */
public class DeudasPorProyectoDao {
    public List<DeudasPorProyectoVo> listar(Double limite) throws SQLException{
        ArrayList<DeudasPorProyectoVo> respuesta = new ArrayList<DeudasPorProyectoVo>();
        Connection conn = JDBCUtilities.getConnection();
        PreparedStatement pstmt = null;
        ResultSet rs=null;
        String consulta = "SELECT C.ID_PROYECTO AS ID, SUM(C.CANTIDAD*MC.PRECIO_UNIDAD) AS VALOR"
                            +" FROM COMPRA C"
                            +" JOIN MATERIALCONSTRUCCION MC ON C.ID_MATERIALCONSTRUCCION = MC.ID_MATERIALCONSTRUCCION"
                            +" WHERE C.PAGADO IS 'No'"
                            +" GROUP BY C.ID_PROYECTO"
                            +" HAVING VALOR>?"
                            +" ORDER BY VALOR DESC;";
        try{
            pstmt = conn.prepareStatement(consulta);
            pstmt.setDouble(1, limite);
            rs=pstmt.executeQuery();
            while(rs.next()){
                DeudasPorProyectoVo objeto = new DeudasPorProyectoVo();
                objeto.setId(rs.getInt("id"));
                objeto.setValor(rs.getDouble("valor"));
                respuesta.add(objeto);
            }

        }finally{
            if(rs!=null){
                rs.close();
            }
            if(pstmt!=null){
                pstmt.close();
            }
            if(conn!=null){
                conn.close();
            }
        }
        return respuesta;
    }
}
