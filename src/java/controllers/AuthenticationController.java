/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import entities.User;
import java.sql.Date;
import javax.ejb.EJB;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import sessionbeans.UserFacade;

/**
 *
 * @author ASUS
 */
@Controller
public class AuthenticationController {

    @EJB(mappedName = "java:global/Shoes-Shopping-Web/UserFacade")
    private UserFacade userFacade;

    @RequestMapping("/login")
    public ModelAndView login() {
        return new ModelAndView("authentication/login");
    }

    @RequestMapping("/register")
    public ModelAndView register() {
        return new ModelAndView("authentication/register");
    }

    @RequestMapping(value = "/doLogin", method = RequestMethod.POST)
    public ModelAndView doLogin(HttpServletRequest request, HttpSession session) {
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        User user = userFacade.findByEmail(email);

        if (user != null && BCrypt.checkpw(password, user.getHashPassword())) {
            session.setAttribute("currentUser", user);
            return new ModelAndView("redirect:/home");
        }

        ModelAndView mv = new ModelAndView("authentication/login");
        mv.addObject("error", "Email hoặc mật khẩu không đúng.");
        return mv;
    }

    @RequestMapping(value = "/doRegister", method = RequestMethod.POST)
    public ModelAndView doRegister(HttpServletRequest request) {
        User user = new User();
        user.setFullName(request.getParameter("fullName"));
        user.setEmail(request.getParameter("email"));
        user.setPhoneNumber(request.getParameter("phone"));
        user.setGender(request.getParameter("gender"));
        user.setDateOfBirth(Date.valueOf(request.getParameter("dob")));
        user.setRole("customer");

        String plainPassword = request.getParameter("password");
        user.setHashPassword(BCrypt.hashpw(plainPassword, BCrypt.gensalt()));

        user.setCreatedAt(new Date(System.currentTimeMillis()));
        user.setUpdatedAt(new Date(System.currentTimeMillis()));

        userFacade.create(user);
        return new ModelAndView("redirect:/login");
    }

    @RequestMapping("/logout")
    public ModelAndView logout(HttpSession session) {
        session.invalidate();
        return new ModelAndView("redirect:/home");
    }
}