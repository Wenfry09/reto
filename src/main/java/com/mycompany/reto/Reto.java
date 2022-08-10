/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.mycompany.reto;

import com.mycompany.reto.view.ReportesView;

/**
 *
 * @author Jhon Rodríguez
 */
public class Reto {

    public static void main(String[] args) {
        System.out.println("Requerimiento");
        ReportesView reportesView = new ReportesView();
        String banco = "Conavi";
        reportesView.proyectosFinanciadosPorBanco(banco);
        
        System.out.println("Requerimiento 2");
        ReportesView reportesView2 = new ReportesView();
        reportesView2.totalAdeudadoPorProyectosSuperioresALimite(50000.0);

        System.out.println("Requerimiento 3");
        ReportesView reportesView3 = new ReportesView();
        reportesView3.lideresQueMasGastan();
        
        System.out.println("Requerimiento 4");
        ReportesView reportesView4 = new ReportesView();
        reportesView4.lideres();
        
        System.out.println("Requerimiento 5");
        ReportesView reportesView5 = new ReportesView();
        reportesView5.proyectos();

    }
}
