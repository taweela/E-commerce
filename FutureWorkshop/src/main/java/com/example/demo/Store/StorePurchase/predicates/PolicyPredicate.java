package com.example.demo.Store.StorePurchase.predicates;

import com.example.demo.ExternalConnections.Old.ExternalConnectionHolder;
import com.example.demo.ShoppingCart.UserInfo;
import com.example.demo.Store.StorePurchase.PurchasableProduct;

import java.util.List;

public interface PolicyPredicate extends Predicate{

    boolean predicateStands(List<PurchasableProduct> ProductAmount, ExternalConnectionHolder externalConnectionHolder, UserInfo userInfo);
}
