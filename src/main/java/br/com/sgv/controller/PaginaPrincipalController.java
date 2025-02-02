/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.sgv.controller;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import java.time.LocalTime;
import org.springframework.security.core.userdetails.User;

@Controller
public class PaginaPrincipalController {

    @GetMapping("/index")
    public String paginaPrincipal(Model model, @AuthenticationPrincipal User user) {
        String saudacao = "";
        int hora = LocalTime.now().getHour();

        if (hora < 12) {
            saudacao = "Bom dia";
        } else if (hora < 18) {
            saudacao = "Boa tarde";
        } else {
            saudacao = "Boa noite";
        }

        model.addAttribute("mensagem", saudacao + ", " + user.getUsername() + "!");
        return "index";  // Nome do template .html
    }
}
