/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import entities.Product;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import sessionbeans.ProductFacade;

/**
 *
 * @author ASUS
 */
@Controller
public class HomeController {
    ModelAndView modelAV = new ModelAndView("layout", "folder", "home");
    @EJB(mappedName = "java:global/Shoes-Shopping-Web/ProductFacade")
    private ProductFacade pf;

    @RequestMapping({"", "/home"})
    public ModelAndView index(HttpSession session) {
        if (session.getAttribute("currentUser") == null) {
            return new ModelAndView("authentication/login");
        }

        modelAV.addObject("view", "index");

        List<Product> list = pf.findAll();
        modelAV.addObject("list", list);

        return modelAV;
    }
}
