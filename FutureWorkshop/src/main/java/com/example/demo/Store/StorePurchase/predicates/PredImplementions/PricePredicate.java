package com.example.demo.Store.StorePurchase.predicates.PredImplementions;


import com.example.demo.ExternalConnections.ExternalConnectionHolder;
import com.example.demo.ShoppingCart.UserInfo;
import com.example.demo.Store.StorePurchase.PurchasableProduct;
import com.example.demo.Store.StorePurchase.predicates.DiscountPredicate;
import com.example.demo.Store.StorePurchase.predicates.PolicyPredicate;


import java.util.List;

public class PricePredicate implements DiscountPredicate, PolicyPredicate {
    private float price;

    public PricePredicate(float price) {
        this.price = price;
    }

    @Override
    public boolean predicateStands(List<PurchasableProduct> ProductAmount, ExternalConnectionHolder externalConnectionHolder, UserInfo userInfo) {
        float totalPrice = 0 ;
        for(PurchasableProduct pp: ProductAmount){
            totalPrice += (pp.getPrice()*(float) pp.getAmount());
        }
        return price<totalPrice;
    }
}