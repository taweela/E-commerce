package com.example.demo.Store.StorePurchase.predicates.PredImplementions.composite;


import com.example.demo.Store.StorePurchase.PurchasableProduct;
import com.example.demo.Store.StorePurchase.predicates.DiscountPredicate;

public class DiscountPredicateOr implements DiscountPredicate {

    DiscountPredicate left;
    DiscountPredicate right;

    public DiscountPredicateOr(DiscountPredicate left, DiscountPredicate right) {
        this.left = left;
        this.right = right;
    }


    @Override
    public boolean predicateStandsForProduct(PurchasableProduct ProductAmount) {
        return left.predicateStandsForProduct(ProductAmount) || right.predicateStandsForProduct(ProductAmount);
    }

    @Override
    public String toString() {
        return "DiscountPredicateOr{" +
                "left=" + left +
                ", right=" + right +
                '}';
    }
}
