/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Tienda.demo.controller;

import Tienda.demo.service.PersonaService;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.HashMap;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author valer
 */
@RestController
public class ReportController {
      @Autowired
    private PersonaService personaservice;

    @GetMapping("/Report")
    public String generatedPdf() throws FileNotFoundException, JRException{

        JRBeanCollectionDataSource beanCollectionDataSource = new JRBeanCollectionDataSource(personaservice.getAllPersona());
        JasperReport compileReport = JasperCompileManager.compileReport(new FileInputStream("C:\\Users\\valer\\OneDrive\\Documents\\NetBeansProjects\\Tienda1\\src\\main\\resources\\TiendaInvoice.jrxm.jrxml"));

        HashMap<String,Object> map=new HashMap<>();
        JasperPrint report = JasperFillManager.fillReport(compileReport, map, beanCollectionDataSource);
        JasperExportManager.exportReportToPdfFile(report,"Report.pdf");

        return "El reporte se generó";
    }

    
}

