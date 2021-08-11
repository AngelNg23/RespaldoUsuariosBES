package com.telcel.dashboard.controller;

import com.telcel.dashboard.entity.GruposBES;
import java.io.IOException;
import javax.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.springframework.web.bind.annotation.RequestParam;
import com.telcel.dashboard.service.UsersBESService;
import java.util.List;
import org.springframework.web.bind.annotation.ModelAttribute;

/**
 *
 * @author Angel Nuñez
 */
@Controller
@Slf4j
public class DashboardController {

    @Autowired
    private UsersBESService foliosSDService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index(Model model) {
        List<GruposBES> ttsinatencion = foliosSDService.findAllGroupsInBES();
        model.addAttribute("ttsinatencion", ttsinatencion);
        return "dashboard";
    }

    @RequestMapping(path = "/download", produces = MediaType.APPLICATION_OCTET_STREAM_VALUE)
    @ResponseBody
    public void descargaExcel(HttpServletResponse response, @RequestParam("lesson") List<GruposBES> lesson) throws IOException {
        for(GruposBES grupo : lesson){
            System.out.println(grupo.toString());
        }
//        response.setContentType("application/octet-stream");
//        DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd");
//        String currentDateTime = dateFormatter.format(new Date());
//        String headerKey = "Content-Disposition";
//        String headerValue = "attachment; filename=RespaldoUsuarios-" + currentDateTime + ".xlsx";
//        response.setHeader(headerKey, headerValue);
//        foliosSDService.getDetalleXLSX(response);
    }

}
