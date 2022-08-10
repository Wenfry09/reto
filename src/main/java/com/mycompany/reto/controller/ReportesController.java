package com.mycompany.reto.controller;

import com.mycompany.reto.model.dao.ComprasDeLiderDao;
import com.mycompany.reto.model.dao.Consulta1Dao;
import com.mycompany.reto.model.dao.Consulta2Dao;
import com.mycompany.reto.model.dao.Consulta3Dao;
import com.mycompany.reto.model.dao.DeudasPorProyectoDao;
import com.mycompany.reto.model.dao.ProyectoBancoDao;
import com.mycompany.reto.model.vo.ComprasDeLiderVo;
import com.mycompany.reto.model.vo.Consulta1Vo;
import com.mycompany.reto.model.vo.Consulta2Vo;
import com.mycompany.reto.model.vo.Consulta3Vo;
import com.mycompany.reto.model.vo.DeudasPorProyectoVo;
import com.mycompany.reto.model.vo.ProyectoBancoVo;
import java.sql.SQLException;
import java.util.List;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Jhon Rodríguez
 */
public class ReportesController {
    private ProyectoBancoDao proyectoBancoDao;
    private DeudasPorProyectoDao deudasPorProyectoDao;
    private ComprasDeLiderDao comprasDeLiderDao;
    private Consulta1Dao consulta1Dao;
    private Consulta2Dao consulta2Dao;
    private Consulta3Dao consulta3Dao;

    public ReportesController(){
        proyectoBancoDao = new ProyectoBancoDao();
        deudasPorProyectoDao = new DeudasPorProyectoDao();
        comprasDeLiderDao = new ComprasDeLiderDao();
        consulta1Dao = new Consulta1Dao();
        consulta2Dao = new Consulta2Dao();
        consulta3Dao = new Consulta3Dao();
    }
    public List<ProyectoBancoVo> listaTotalProyectoBanco(String banco) throws SQLException{
        return proyectoBancoDao.listar(banco);
    }
    public List<DeudasPorProyectoVo> listaTotalDeudasProyecto(Double limite) throws SQLException{
        return deudasPorProyectoDao.listar(limite);
    }
    public List<ComprasDeLiderVo> listaTotalComprasLider() throws SQLException{
        return comprasDeLiderDao.listar();
    }
    public List<Consulta1Vo> listaTotalLider() throws SQLException{
        return consulta1Dao.listar();
    }
    public List<Consulta2Vo> listaTotalProyecto() throws SQLException{
        return consulta2Dao.listar();
    }
    public List<Consulta3Vo> listaTotalCompra() throws SQLException{
        return consulta3Dao.listar();
    }
}
