/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author ASUS
 */

@Controller
public class HomeController {
    ModelAndView modelAV = new ModelAndView("layout", "folder", "home");
    
    @RequestMapping({"", "/index"})
    public ModelAndView index() {
        modelAV.addObject("view", "index");
        return modelAV;
    }
}
