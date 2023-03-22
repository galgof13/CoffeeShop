package com.petrovnikita.spring.coffeeShop.utils;

import com.petrovnikita.spring.coffeeShop.model.CartInfo;
import javax.servlet.http.HttpServletRequest;


public class ShoppingCart {

    public static CartInfo getCartInSession(HttpServletRequest request){

        CartInfo cartInfo = (CartInfo) request.getSession().getAttribute("myCart");

        if (cartInfo == null){
            cartInfo = new CartInfo();
            request.getSession().setAttribute("myCart", cartInfo);
        }
        return cartInfo;
    }

    public static void removeCartInSession(HttpServletRequest request) {
        request.getSession().removeAttribute("myCart");
    }
}
