package com.example.demo.Store.StorePurchase.Policies;



import com.example.demo.ExternalConnections.Old.ExternalConnectionHolder;
import com.example.demo.ShoppingCart.UserInfo;
import com.example.demo.Store.Product;

import java.util.HashMap;

public class AndGatePolicy extends Policy {
    Policy left;
    Policy right;

    public AndGatePolicy(Policy left, Policy right) {
        super();
        this.left = left;
        this.right = right;
    }

    @Override
    public boolean checkIfPolicyStands(HashMap<Product, Integer> ProductAmount, ExternalConnectionHolder externalConnectionHolder, UserInfo userInfo) {
        return left.checkIfPolicyStands(ProductAmount,externalConnectionHolder,userInfo) && right.checkIfPolicyStands(ProductAmount,externalConnectionHolder,userInfo);
    }

    @Override
    public String toString() {
        return "AndGatePolicy{" +
                "left=" + left +
                ", right=" + right +
                '}';
    }
}
