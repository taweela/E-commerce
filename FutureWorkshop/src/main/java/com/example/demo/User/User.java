package com.example.demo.User;


import com.example.demo.CustomExceptions.Exception.CantPurchaseException;
import com.example.demo.CustomExceptions.Exception.StorePolicyViolatedException;
import com.example.demo.CustomExceptions.Exception.SupplyManagementException;
import com.example.demo.ExternalConnections.ExternalConnectionHolder;
import com.example.demo.ShoppingCart.InventoryProtector;
import com.example.demo.ShoppingCart.ShoppingCart;

public abstract class User {
    public String name;
    private ShoppingCart shoppingCart;

 public User(String name){
    shoppingCart = new ShoppingCart(name);

    }


    public ShoppingCart getShoppingCart() {
        return shoppingCart;
    }
    public void setShoppingCart(ShoppingCart shoppingCart) {
     this.shoppingCart = shoppingCart;
    }


    public boolean containsStore(String storeID){
     return shoppingCart.containsStore(storeID);
 }

    public void removeProduct(String productID, String storeID, int amount){
         shoppingCart.removeProduct(productID,storeID,amount);
    }

    public void addProduct(String productID, String storeID, int amount, InventoryProtector inventoryProtector, boolean auctionOrBid) {
     shoppingCart.addProduct(productID,storeID,amount,inventoryProtector,auctionOrBid);
 }
    public String getCartInventory() {
     return shoppingCart.getCartInventory();
 }
    public float purchaseCart(ExternalConnectionHolder externalConnectionHolder) throws SupplyManagementException, StorePolicyViolatedException, CantPurchaseException {
     float a = shoppingCart.purchaseCart(externalConnectionHolder);
     return a;
 }





    }