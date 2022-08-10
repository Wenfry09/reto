/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.reto.model.dao;

import com.mycompany.reto.model.vo.ProyectoBancoVo;
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
public class ProyectoBancoDao {
    public List<ProyectoBancoVo> listar(String banco) throws SQLException{
        ArrayList<ProyectoBancoVo> respuesta = new ArrayList<ProyectoBancoVo>();
        Connection conn = JDBCUtilities.getConnection();
        PreparedStatement pstmt = null;
        ResultSet rs=null;
        String consulta = "SELECT P.ID_PROYECTO AS ID, P.CONSTRUCTORA, P.CIUDAD, P.CLASIFICACION, T.ESTRATO, L.NOMBRE ||' '|| L.PRIMER_APELLIDO ||' '|| L.SEGUNDO_APELLIDO AS LIDER"
                            +" FROM PROYECTO P"
                            +" JOIN TIPO T ON P.ID_TIPO = T.ID_TIPO"
                            +" JOIN LIDER L ON L.ID_LIDER =P.ID_LIDER"
                            +" WHERE P.BANCO_VINCULADO = ?"
                            +" ORDER BY P.FECHA_INICIO DESC, P.CIUDAD, P.CONSTRUCTORA;";
        try{
            pstmt = conn.prepareStatement(consulta);
            pstmt.setString(1, banco);
            rs=pstmt.executeQuery();
            while(rs.next()){
                ProyectoBancoVo objeto = new ProyectoBancoVo();
                objeto.setId(rs.getInt("id"));
                objeto.setConstructora(rs.getString("constructora"));
                objeto.setCiudad(rs.getString("ciudad"));
                objeto.setClasificacion(rs.getString("clasificacion"));
                objeto.setEstrato(rs.getInt("estrato"));
                objeto.setLider(rs.getString("lider"));
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
