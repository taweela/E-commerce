package com.example.demo.ExternalConnections.Old;


import com.example.demo.CustomExceptions.Exception.CantPurchaseException;
import com.example.demo.ExternalConnections.Old.Delivery.Delivery;
import com.example.demo.ExternalConnections.Old.Delivery.DeliveryNames;
import com.example.demo.ExternalConnections.Old.Payment.Payment;
import com.example.demo.ExternalConnections.Old.Payment.PaymentNames;
import com.example.demo.GlobalSystemServices.Log;

public class ExternalConnectionHolder {
    private DeliveryNames delivery;
    private PaymentNames payment;
    private static int TRYTOCONNECT = 20;
    private Log my_log;


    public ExternalConnectionHolder(DeliveryNames delivery, PaymentNames payment) {
        this.delivery = delivery;
        this.payment = payment;
        try {
            my_log = Log.getLogger();
        } catch (Exception e) {
        }
    }


    public int tryToPurchase(float total, float deliveryDetails)  {
        int answer = 0;
        boolean gotDelivery = false;
        boolean gotPayment = false;
        Delivery deliveryObject = null;
        Payment paymentObject = null;


        my_log.fine("trying to purchase with total:" + total + " and delivery weight is" + deliveryDetails);


        for (int i = 0; i < TRYTOCONNECT  && !gotDelivery; i++) {
            try {
                deliveryObject = ExternalConnections.getInstance().getCertainDelivery(delivery);
                gotDelivery = true;
            } catch (Exception e) {
                try {
                    Thread.sleep(100);
                }catch (Exception e2){}

            }

        }

        for (int i = 0; i < TRYTOCONNECT && !gotPayment; i++) {

            try {
                paymentObject = ExternalConnections.getInstance().getCertainPayment(payment);
                gotPayment = true;
            } catch (Exception e) {
                try {
                    Thread.sleep(100);
                }catch (Exception e2){}
            }

        }

        if (gotDelivery==false) {
            my_log.warning("could not purchase, because couldn't not obtain external connection of " + delivery);
            throw new CantPurchaseException("could not purchase, because couldn't not obtain external connection of" + delivery);
        }
        if( gotPayment == false){
            my_log.warning("could not purchase, because couldn't not obtain external connection of " + payment );
            throw new CantPurchaseException("could not purchase, because couldn't not obtain external connection of" + payment);
        }

        answer = deliveryObject.delivery(deliveryDetails);
        answer += paymentObject.payment(total);


        return answer;

    }

    public DeliveryNames getDeliveryName() {
        return delivery;
    }

    public void setDelivery(DeliveryNames delivery) {
        this.delivery = delivery;
    }

    public PaymentNames getPaymentName() {
        return payment;
    }

    public void setPayment(PaymentNames payment) {
        this.payment = payment;
    }

}
