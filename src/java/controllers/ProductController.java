package controllers;

import entities.Product;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import sessionbeans.ProductFacade;

import java.util.List;
import javax.ejb.EJB;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ProductController {

    @EJB(mappedName = "java:global/Shoes-Shopping-Web/ProductFacade")
    private ProductFacade productFacade;

    @RequestMapping("/products/products")
    public ModelAndView products() {
        ModelAndView mv = new ModelAndView("layout", "folder", "products");
        mv.addObject("view", "products");

        List<Product> list = productFacade.findAll();
        mv.addObject("list", list);

        return mv;
    }

    @RequestMapping(value = "/products/detail", method = RequestMethod.GET)
    public ModelAndView productDetail(@RequestParam("id") int id) {
        ModelAndView mv = new ModelAndView("layout", "folder", "products");
        mv.addObject("view", "product-detail");

        Product product = productFacade.find(id);
        mv.addObject("product", product);

        return mv;
    }
}
