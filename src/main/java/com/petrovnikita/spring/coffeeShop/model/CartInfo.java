package com.petrovnikita.spring.coffeeShop.model;

import java.util.ArrayList;
import java.util.List;

public class CartInfo {

    private final List<CartLineInfo> cartLines = new ArrayList<CartLineInfo>();

    private ClientInfo clientInfo;

    public CartInfo() {
    }

    public List<CartLineInfo> getCartLines() {
        return cartLines;
    }

    public CartLineInfo findLineById(int id){
        for(CartLineInfo line : cartLines){
            if(line.getCoffeeInfo().getId() == id){
                return line;
            }
        }
        return null;
    }

    public void addCoffee(CoffeeInfo coffeeInfo, int quantity){
        CartLineInfo cartLineInfo = this.findLineById(coffeeInfo.getId());

        if(cartLineInfo == null){
            cartLineInfo = new CartLineInfo();
            cartLineInfo.setCoffeeInfo(coffeeInfo);
            cartLines.add(cartLineInfo);
        }
        int newQuantity = cartLineInfo.getQuantity() + quantity;
        if (newQuantity <= 0){
            cartLines.remove(cartLineInfo);
        } else {
            cartLineInfo.setQuantity(newQuantity);
        }
    }

    public void updateCartLineInfoQuantity(int id, int quantity){
        CartLineInfo line = this.findLineById(id);
        if (line != null) {
            if (quantity <= 0) {
                this.cartLines.remove(line);
            } else {
                line.setQuantity(quantity);
            }
        }
    }

    public void updateQuantity(CartInfo newQuantityCartInfo) {
        if (newQuantityCartInfo != null) {
            List<CartLineInfo> newQuantityLines = newQuantityCartInfo.getCartLines();
            for (CartLineInfo line : newQuantityLines) {
                this.updateCartLineInfoQuantity(line.getCoffeeInfo().getId(), line.getQuantity());
            }
        }

    }

    public void removeCoffee(int id){
        CartLineInfo line = this.findLineById(id);
        if(line != null){
            cartLines.remove(line);
        }
    }

    public float getAmountTotal(){
        float total = 0;
        for(CartLineInfo line : cartLines){
            total += line.getAmount();
        }
        return total;
    }

    public ClientInfo getClientInfo() {
        return clientInfo;
    }

    public void setClientInfo(ClientInfo clientInfo) {
        this.clientInfo = clientInfo;
    }
}
