package com.petrovnikita.spring.coffeeShop.controller;


import com.petrovnikita.spring.coffeeShop.dao.CoffeeDao;
import com.petrovnikita.spring.coffeeShop.entity.Client;
import com.petrovnikita.spring.coffeeShop.entity.Coffee;
import com.petrovnikita.spring.coffeeShop.entity.Task;
import com.petrovnikita.spring.coffeeShop.form.CoffeeForm;
import com.petrovnikita.spring.coffeeShop.model.*;
import com.petrovnikita.spring.coffeeShop.service.AllService;
import com.petrovnikita.spring.coffeeShop.utils.ShoppingCart;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class ClientController {

    @Autowired
    private AllService allService;

    @GetMapping()
    public String ShowAllCoffee(Model model){
        List<CoffeeInfo> allCoffee = allService.getAllCoffee();
        model.addAttribute("allCoffee", allCoffee);
        return "all-coffee";
    }

    @GetMapping("/{id}")
    public String ShowCoffee(Model model, @PathVariable("id") int id){
        Coffee coffee = allService.getCoffee(id);
        model.addAttribute("coffee", coffee);
        return "getCoffee";
    }

    @RequestMapping ("/add-to-order")
    public String AddToOrder(HttpServletRequest request, @RequestParam("coffeeId") int id, Model model){
        Coffee coffee = allService.getCoffee(id);
        if(coffee != null){

            CartInfo cartInfo = ShoppingCart.getCartInSession(request);
            CoffeeInfo coffeeInfo = new CoffeeInfo(coffee);
            cartInfo.addCoffee(coffeeInfo, 1);
        }
        return "redirect:/";
    }

    @GetMapping("/order")
    public  String Order(HttpServletRequest request, Model model){
        CartInfo myCart = ShoppingCart.getCartInSession(request);
        model.addAttribute("myCart", myCart);
        return "order";
    }

    @PostMapping("/saveTaskClient")
    public String SaveTaskClient(HttpServletRequest request, @ModelAttribute("myCart") CartInfo cartInfo){
        CartInfo cart = ShoppingCart.getCartInSession(request);
        cart.setClientInfo(cartInfo.getClientInfo());
        allService.saveTask(cart);
        ShoppingCart.removeCartInSession(request);
        return "redirect:/";
    }

}
