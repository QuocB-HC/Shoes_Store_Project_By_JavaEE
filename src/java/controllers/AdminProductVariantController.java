/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this tproductlate file, choose Tools | Tproductlates
 * and open the tproductlate in the editor.
 */
package controllers;

import entities.ProductVariant;
import java.io.File;
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import sessionbeans.ProductVariantFacade;

/**
 *
 * @author ASUS
 */
@Controller
public class AdminProductVariantController {

    ModelAndView modelAV = new ModelAndView("layout", "folder", "admin");

    @EJB(mappedName = "java:global/Shoes-Shopping-Web/ProductVariantFacade")
    private ProductVariantFacade productVariantFacade;

    @RequestMapping("/admin/product_variant")
    public ModelAndView index(@RequestParam("productId") int productId) {
        modelAV.addObject("view", "product_variant/index");

        List<ProductVariant> productVariantList = productVariantFacade.getProductVariantByProductId(productId);
        modelAV.addObject("productVariantList", productVariantList);

        return modelAV;
    }

    @RequestMapping("/admin/product_variant/create")
    public ModelAndView create() {
        modelAV.addObject("view", "product_variant/create");

        return modelAV;
    }

    @RequestMapping(value = "/admin/product_variant/create", method = RequestMethod.POST)
    public ModelAndView create(ProductVariant productVariant) {
        productVariantFacade.create(productVariant);

        return new ModelAndView("redirect:/admin/product_variant?productId=" + productVariant.getProductId());
    }
//
//    @RequestMapping("/admin/product/edit")
//    public ModelAndView edit(int id) {
//        Product product = productFacade.find(id);
//
//        modelAV.addObject("view", "/product/edit");
//        modelAV.addObject("product", product);
//
//        return modelAV;
//    }
//
//    @RequestMapping(value = "/admin/product/edit", method = RequestMethod.POST)
//    public ModelAndView edit(@RequestParam("newImageFile") MultipartFile imageFile, Product product, HttpServletRequest request) {
//        try {
//            if (!imageFile.isEmpty()) {
//                String originalFilename = imageFile.getOriginalFilename();
//                String uploadPath = request.getServletContext().getRealPath("/images/product-images/");
//                File uploadDir = new File(uploadPath);
//                if (!uploadDir.exists()) {
//                    uploadDir.mkdirs();
//                }
//                File savedFile = new File(uploadDir, originalFilename);
//                imageFile.transferTo(savedFile);
//                product.setImages(originalFilename);
//
//                product.setUpdatedAt(new Date());
//                productFacade.edit(product);
//            } else {
//                productFacade.updateProductWithoutImage(product);
//            }
//
//            return new ModelAndView("redirect:/admin/product");
//        } catch (Exception e) {
//            e.printStackTrace();
//            return new ModelAndView("error");
//        }
//    }
//
//    @RequestMapping("/admin/product/delete")
//    public ModelAndView delete(int id) {
//        ModelAndView modeAV = new ModelAndView("/admin/product/delete");
//
//        modeAV.addObject("id", id);
//
//        return modeAV;
//    }
//
//    @RequestMapping(value = "/admin/product/delete", method = RequestMethod.POST)
//    public ModelAndView delete(int id, String op) {
//        if (op.equals("yes")) {
//            Product product = productFacade.find(id);
//
//            productFacade.remove(product);
//        }
//        return new ModelAndView("redirect:/admin/product");
//    }
}