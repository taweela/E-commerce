package com.example.demo.User;


import com.example.demo.Controllers.model.realTimeNotification;
import com.example.demo.Controllers.notificationController;
import com.example.demo.NotificationsManagement.ComplaintNotification;
import com.example.demo.NotificationsManagement.StoreNotification;

import java.text.SimpleDateFormat;
import java.util.*;


public class Subscriber extends User {
    String pattern = "MM/dd/yyyy HH:mm:ss";

    private String password;
    private boolean logged_in = false;
    private List<String> Queries; //3.5
    private List<StoreNotification> storeNotifications;
    private List<ComplaintNotification> complaintNotifications;
    private HashMap<String,ComplaintNotification> AdminComplaints;
    private Object lock = new Object();

    public Subscriber(String user_name, String password){
        super(user_name);
        this.password = password;
        this.name = user_name;
        Queries= new ArrayList<>();
        lock = new Object();
        storeNotifications = new ArrayList<>();
        complaintNotifications = new ArrayList<>();
        AdminComplaints = new LinkedHashMap<>();
    }

    public String getName()
    {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public boolean isLogged_in() {
        return logged_in;
    }

    public void setLogged_in(boolean logged_in) {
            this.logged_in = logged_in;
            if(this.logged_in && getStoreNotifications().size()>0){
                for(int i =0; i<getStoreNotifications().size();i++){
                    notificationController.getInstance().sendNotification(new realTimeNotification(this.name,getStoreNotifications().get(i).getSentFrom().getStoreName(), getStoreNotifications().get(i).getSubject().toString(), getStoreNotifications().get(i).getTitle(), getStoreNotifications().get(i).getBody(), new SimpleDateFormat(pattern).format(Calendar.getInstance().getTime())));
                }
            }
        if(this.logged_in && getAdminComplaints().size()>0){
            for(String sender: getAdminComplaints().keySet()){
                notificationController.getInstance().sendNotification(new realTimeNotification(this.name,sender, getAdminComplaints().get(sender).getSubject().toString(),getAdminComplaints().get(sender).getTitle(), getAdminComplaints().get(sender).getBody(), new SimpleDateFormat(pattern).format(Calendar.getInstance().getTime())));
            }
        }

    }
    public void AddQuery(String s){this.getQueries().add(s);}

    public List<String> getQueries() {
        return Queries;
    }


    public List<StoreNotification> getStoreNotifications() {
        return storeNotifications;
    }

    public List<ComplaintNotification> getComplaintNotifications() {
        return complaintNotifications;
    }

    public void addComplaint(ComplaintNotification complaintNotification,String senderId) {
        if (isLogged_in())
            notificationController.getInstance().sendNotification(new realTimeNotification(this.name, senderId, complaintNotification.getSubject().toString(), complaintNotification.getTitle(), complaintNotification.getBody(), new SimpleDateFormat(pattern).format(Calendar.getInstance().getTime())));
        else {
            getAdminComplaints().put(senderId, complaintNotification);
            getComplaintNotifications().add(complaintNotification);
        }
    }

    public void addNotification(StoreNotification storeNotification){
        if(isLogged_in())
            notificationController.getInstance().sendNotification(new realTimeNotification(this.name,storeNotification.getSentFrom().getStoreName(), storeNotification.getSubject().toString(), storeNotification.getTitle(), storeNotification.getBody(), new SimpleDateFormat(pattern).format(Calendar.getInstance().getTime())));
         else
        getStoreNotifications().add(storeNotification);
    }

    public Object getLock (){
        return lock;
    }

    public HashMap<String, ComplaintNotification> getAdminComplaints() {
        return AdminComplaints;
    }
}
