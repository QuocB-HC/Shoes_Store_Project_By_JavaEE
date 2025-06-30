package controllers;

import entities.OrderDetails;
import entities.Orders;
import entities.Product;
import entities.ProductVariant;
import entities.User;
import java.util.Date;
import java.util.Map;
import javax.ejb.EJB;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import sessionbeans.OrderDetailsFacade;
import sessionbeans.OrdersFacade;
import sessionbeans.ProductVariantFacade;

@Controller
public class OrderController {

    @EJB(mappedName = "java:global/Shoes-Shopping-Web/OrdersFacade")
    private OrdersFacade ordersFacade;

    @EJB(mappedName = "java:global/Shoes-Shopping-Web/OrderDetailsFacade")
    private OrderDetailsFacade orderDetailFacade;

    @EJB(mappedName = "java:global/Shoes-Shopping-Web/ProductVariantFacade")
    private ProductVariantFacade productVariantFacade;

    @RequestMapping("/order")
    public ModelAndView showOrderPage(HttpSession session) {
        User user = (User) session.getAttribute("currentUser");
        if (user == null) {
            return new ModelAndView("redirect:/login");
        }

        ModelAndView mv = new ModelAndView("layout");
        mv.addObject("folder", "order");
        mv.addObject("view", "index");
        mv.addObject("user", user);
        return mv;
    }

    @RequestMapping(value = "/placeOrder", method = RequestMethod.POST)
    public ModelAndView placeOrder(HttpServletRequest request, HttpSession session) {
        User user = (User) session.getAttribute("currentUser");
        if (user == null) {
            return new ModelAndView("redirect:/login");
        }

        String address = request.getParameter("address");
        String paymentType = request.getParameter("paymentType");

        if (!("cash".equals(paymentType) || "bank transfer".equals(paymentType))) {
            ModelAndView mv = new ModelAndView("layout");
            mv.addObject("folder", "order");
            mv.addObject("view", "index");
            mv.addObject("user", user);
            mv.addObject("error", "Phương thức thanh toán không hợp lệ.");
            return mv;
        }

        Map<String, Map<String, Object>> cart = (Map<String, Map<String, Object>>) session.getAttribute("cart");

        if (cart == null || cart.isEmpty()) {
            ModelAndView mv = new ModelAndView("layout");
            mv.addObject("folder", "order");
            mv.addObject("view", "index");
            mv.addObject("user", user);
            mv.addObject("error", "Giỏ hàng trống!");
            return mv;
        }

        // Tạo đơn hàng
        Orders order = new Orders();
        order.setUserId(user);
        order.setAddress(address);
        order.setPaymentType(paymentType);
        order.setStatus("Success");
        order.setCreatedAt(new Date());
        ordersFacade.create(order);

        int totalPrice = 0;

        for (Map<String, Object> item : cart.values()) {
            Product product = (Product) item.get("product");
            String size = (String) item.get("size");
            String color = (String) item.get("color");
            int quantity = (int) item.get("quantity");

            // Tìm đúng variant từ DB
            ProductVariant variant = productVariantFacade.findByProductIdAndSizeAndColor(product.getId(), size, color);
            if (variant == null || variant.getStockQuantity() < quantity) {
                continue; // bỏ qua nếu không đủ hàng hoặc không tồn tại
            }

            // Tạo chi tiết đơn hàng
            OrderDetails detail = new OrderDetails();
            detail.setOrderId(order);
            detail.setProductVariantId(variant);
            detail.setQuantity(quantity);
            detail.setPrice(product.getPrice());
            orderDetailFacade.create(detail);

            totalPrice += product.getPrice() * quantity;

            // Trừ kho
            variant.setStockQuantity(variant.getStockQuantity() - quantity);
            productVariantFacade.edit(variant);
        }

        order.setTotalPrice(totalPrice);
        ordersFacade.edit(order);

        // Xoá giỏ hàng sau khi đặt hàng
        session.removeAttribute("cart");

        return new ModelAndView("redirect:/order/confirmation");
    }
    
    @RequestMapping("/order/confirmation")
    public ModelAndView Confirmation() {
        ModelAndView modelAV = new ModelAndView("layout", "folder", "confirmation");
        
        modelAV.addObject("view", "index");
        
        return modelAV;
    }
}
