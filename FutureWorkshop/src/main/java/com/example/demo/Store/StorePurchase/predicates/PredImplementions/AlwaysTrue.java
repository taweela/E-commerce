package com.example.demo.Store.StorePurchase.predicates.PredImplementions;





import com.example.demo.ExternalConnections.Old.ExternalConnectionHolder;
import com.example.demo.ShoppingCart.UserInfo;
import com.example.demo.Store.StorePurchase.PurchasableProduct;
import com.example.demo.Store.StorePurchase.predicates.DiscountPredicate;
import com.example.demo.Store.StorePurchase.predicates.PolicyPredicate;


import java.util.List;

public class AlwaysTrue implements PolicyPredicate, DiscountPredicate {
    @Override
    public boolean predicateStands(List<PurchasableProduct> ProductAmount, ExternalConnectionHolder externalConnectionHolder, UserInfo userInfo) {
        return true;
    }


    @Override
    public boolean predicateStandsForProduct(PurchasableProduct ProductAmount) {
        return true;
    }

    @Override
    public String toString() {
        return "AlwaysTruePred{}";
    }
}
