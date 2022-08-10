/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.reto.view;

import com.mycompany.reto.controller.ReportesController;
import com.mycompany.reto.model.vo.ComprasDeLiderVo;
import com.mycompany.reto.model.vo.Consulta1Vo;
import com.mycompany.reto.model.vo.Consulta2Vo;
import com.mycompany.reto.model.vo.Consulta3Vo;
import com.mycompany.reto.model.vo.DeudasPorProyectoVo;
import com.mycompany.reto.model.vo.ProyectoBancoVo;
import java.util.List;

/**
 *
 * @author Jhon Rodríguez
 */
public class ReportesView {
    private static ReportesController controller;
    public ReportesView(){
        controller = new ReportesController();
    }
    private String repitaCaracter(Character caracter, Integer veces) {
        String respuesta = "";
        for (int i = 0; i < veces; i++) {
            respuesta += caracter;
        }
        return respuesta;
    }

    public void proyectosFinanciadosPorBanco(String banco) {
        System.out.println(repitaCaracter('=', 36) + " LISTADO DE PROYECTOS POR BANCO "
                + repitaCaracter('=', 37));
        if (banco != null && !banco.isBlank()) {
            System.out.println(String.format("%3s %-25s %-20s %-15s %-7s %-30s",
            "ID", "CONSTRUCTORA", "CIUDAD", "CLASIFICACION", "ESTRATO", "LIDER"));
            System.out.println(repitaCaracter('-', 105));
            try{
                List<ProyectoBancoVo> proyectos = controller.listaTotalProyectoBanco(banco);
                for(ProyectoBancoVo proyecto: proyectos){
                    System.out.println(proyecto);
                }
            }catch(Exception ex){
                System.err.println("Error: "+ex);
            }
        }
    }

    public void totalAdeudadoPorProyectosSuperioresALimite(Double limiteInferior) {
        System.out.println(repitaCaracter('=', 1) + " TOTAL DEUDAS POR PROYECTO "
                + repitaCaracter('=', 1));
        if (limiteInferior != null) {
            System.out.println(String.format("%3s %15s", "ID", "VALOR "));
            System.out.println(repitaCaracter('-', 29));
            try{
                List<DeudasPorProyectoVo> deudas = controller.listaTotalDeudasProyecto(limiteInferior);
                for(DeudasPorProyectoVo deuda: deudas){
                    System.out.println(deuda);
                }
            }catch(Exception ex){
                System.err.println("Error: "+ex);
            }
        }
    }

    public void lideresQueMasGastan() {
        System.out.println(repitaCaracter('=', 6) + " 10 LIDERES MAS COMPRADORES "
                + repitaCaracter('=', 7));
        System.out.println(String.format("%-25s %15s", "LIDER", "VALOR "));
        System.out.println(repitaCaracter('-', 41));
        try{
            List<ComprasDeLiderVo> compras = controller.listaTotalComprasLider();
            for(ComprasDeLiderVo compra: compras){
                System.out.println(compra);
            }
        }catch(Exception ex){
            System.err.println("Error: "+ex);
        }
    }
    public void lideres() {
        System.out.println(repitaCaracter('=', 6) + "  Lideres "
                + repitaCaracter('=', 7));
        System.out.println(repitaCaracter('-', 41));
        try{
            List<Consulta1Vo> lideres = controller.listaTotalLider();
            for(Consulta1Vo lider: lideres){
                System.out.println(lider);
            }
        }catch(Exception ex){
            System.err.println("Error: "+ex);
        }
    }
    public void proyectos() {
        System.out.println(repitaCaracter('=', 6) + "  Proyectos "
                + repitaCaracter('=', 7));
        System.out.println(repitaCaracter('-', 41));
        try{
            List<Consulta2Vo> proyectos = controller.listaTotalProyecto();
            for(Consulta2Vo proyecto: proyectos){
                System.out.println(proyecto);
            }
        }catch(Exception ex){
            System.err.println("Error: "+ex);
        }
    }
    public void compras() {
        System.out.println(repitaCaracter('=', 6) + "  Compras "
                + repitaCaracter('=', 7));
        System.out.println(repitaCaracter('-', 41));
        try{
            List<Consulta3Vo> compras = controller.listaTotalCompra();
            for(Consulta3Vo compra: compras){
                System.out.println(compra);
            }
        }catch(Exception ex){
            System.err.println("Error: "+ex);
        }
    }
}
