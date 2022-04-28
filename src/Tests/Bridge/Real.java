package Tests.Bridge;

import Controllers.BigController;
import ExternalConnections.Payment.Payment;
import Store.Product;

import javax.naming.NoPermissionException;
import java.util.HashMap;

public class Real implements BridgeInterface{

    private BigController bigController;

    public Real() {

        try {
            this.bigController = new BigController();
        }catch (Exception e){

        }
    }
    public Real(BigController msApp) {
        this.bigController = msApp;
   }

//    public MarketSystem getMsApp() {
//        return msApp;
//    }
//
//    public void setMsApp(MarketSystem msApp) {
//        this.msApp = msApp;
//    }

    /** requirement 1.b in V1 */
    public String parallelUse() { //Need to implement thread-base system
        throw new UnsupportedOperationException("Not Implemented Yet");
    }

    /** requirement 1.c in V1 */
    public String systemLogging() { //Need to create log file (containing error logs)
        throw new UnsupportedOperationException("Not Implemented Yet");
    }

    /** System requirement - I.1 */
    public String openingMarket(){
        throw new UnsupportedOperationException("Not Implemented Yet");
    }

    /** System requirement - I.2 */
    /*public String changeExternalService(int currServiceCode, String currServiceName,
                                        int newServiceCode, String newServiceName){
        throw new UnsupportedOperationException("Not Implemented Yet");
    }*/

    //todo talk about Extrenal connections how to make it bettter.
    /** System requirement - I.2 */
    public String removePayment(String paymentRemove,Payment payment){
        return "";

    }
    public String AddPayment(Payment payment){
        return "";

    }

    /** System requirement - I.2 */
    public String addExternalService(int serviceCode, String serviceName){
        throw new UnsupportedOperationException("Not Implemented Yet");
    }

    /** System requirement - I.3 */
    public String payment(){
        throw new UnsupportedOperationException("Not Implemented Yet");
    }

    /** System requirement - I.4 */
    public String delivery(){
        throw new UnsupportedOperationException("Not Implemented Yet");
    }

    /** System requirement - I.5 */
    public String realtimeNotificationProductBought(){
        throw new UnsupportedOperationException("Not Implemented Yet");
    }

    /** System requirement - I.5 */
    public String realtimeNotificationStoreClosed(){
        throw new UnsupportedOperationException("Not Implemented Yet");
    }

    /** System requirement - I.5 */
    public String realtimeNotificationStoreReopened(){
        throw new UnsupportedOperationException("Not Implemented Yet");
    }

    /** System requirement - I.5 */
    public String realtimeNotificationUserPermissionUpdate(){
        throw new UnsupportedOperationException("Not Implemented Yet");
    }

    /** System requirement - I.6 */
    public String offlineNotificationProductBought(){
        throw new UnsupportedOperationException("Not Implemented Yet");
    }

    /** System requirement - I.6 */
    public String offlineNotificationStoreClosed(){
        throw new UnsupportedOperationException("Not Implemented Yet");
    }

    /** System requirement - I.6 */
    public String offlineNotificationStoreReopened(){
        throw new UnsupportedOperationException("Not Implemented Yet");
    }

    /** System requirement - I.6 */
    public String offlineNotificationUserPermissionUpdate(){
        throw new UnsupportedOperationException("Not Implemented Yet");
    }

    /** User requirement - II.1.1 */
    public String getInToTheSystem(){
        throw new UnsupportedOperationException("Not Implemented Yet");
    }

    /** User requirement - II.1.2 */
    public String getOutFromTheSystem(){
        throw new UnsupportedOperationException("Not Implemented Yet");
    }

    /** User requirement - II.1.3 */
    public String register(String username, String password){
        throw new UnsupportedOperationException("Not Implemented Yet");
    }

    /** User requirement - II.1.4 */
    public String login(String username, String password){
        throw new UnsupportedOperationException("Not Implemented Yet");
    }

    /** User requirement - II.2.1 */
    public String receiveSystemInfo(){
        throw new UnsupportedOperationException("Not Implemented Yet");
    }

    /** User requirement - II.2.2 */
    public String searchProduct(String productName){
        throw new UnsupportedOperationException("Not Implemented Yet");
    }

    /** User requirement - II.2.3  => its the same as II.2.4 */


    /** User requirement - II.2.4 */
    public String showShoppingCart(String userId){
        return bigController.getCartInventory(userId);
    }
    /** User requirement - II.2.4 */
    //inc. by 1!
    public boolean increaseProductQuantityInShoppingCart(String user_id,String productID, String storeID, int amount,boolean auctionOrBid ){
        int ans = bigController.addProduct( user_id, productID,  storeID,  amount, auctionOrBid);
        if(ans == 0)
            return true;
        return false;

    }
    /** User requirement - II.2.4 */
    //dec. by 1!
    public boolean decreaseProductQuantityInShoppingCart(String userId,String productID, String storeID, int amount){
        int ans = bigController.removeProduct( userId, productID,  storeID,  amount);
        if(ans == 0)
            return true;
        return false;

        }
    /** User requirement - II.2.4 */
    public String removeProductFromShoppingCart(String productName){
        throw new UnsupportedOperationException("Not Implemented Yet");
    }

    /** User requirement - II.2.5 */
    public String purchaseShoppingCart(){
        throw new UnsupportedOperationException("Not Implemented Yet");
    }

    /** User requirement - II.3.1 */
    public String logout(){
        throw new UnsupportedOperationException("Not Implemented Yet");
    }

    /** User requirement - II.3.2 */
    public boolean openStore(String userID, String storeName, HashMap<Product, Integer> products){
        try {
            String storeId = bigController.openNewStore(storeName, userID);
            for (Product p : products.keySet()) {
                addProductToStore(storeId, userID , p.getName(), p.getPrice(), products.get(p), p.getCategory().toString());
            }
            return true;
        }
        catch (Exception e){
            return false;
        }

    }
    public boolean openStore(String userID, String storeName){
        try {
            bigController.openNewStore(storeName, userID);
            return true;
        }
        catch (Exception e){
            return false;
        }
    }

    /** User requirement - II.4.1 */
    public boolean addProductToStore(String storeId, String userId, String productName, float price, int supply, String category){
        try {
            bigController.addNewProduct(storeId,userId,productName,price,supply,category);
            return true;
        } catch (NoPermissionException e) {
            e.printStackTrace();
            return false;
        }
    }
    /** User requirement - II.4.1 */
    public boolean removeProductFromStore(String storeId,String userId,String productId){
        try {
            bigController.deleteProduct(storeId,userId, productId);
            return true;
        } catch (NoPermissionException e) {
            e.printStackTrace();
            return false;
        }
    }
    /** User requirement - II.4.1 */
    public String editProductInStore(String storeName, String productName, String newProductName,
                                     int newProductPrice, int newProductQuantity){
        throw new UnsupportedOperationException("Not Implemented Yet");
    }

    /** User requirement - II.4.2 */
    public String changeStorePolicy(String storeName, String newStorePolicy){
        throw new UnsupportedOperationException("Not Implemented Yet");
    }

    /** User requirement - II.4.4 */
    public String addNewStoreOwner(String storeName, String newStoreOwnerUserName){
        throw new UnsupportedOperationException("Not Implemented Yet");
    }

    /** User requirement - II.4.6 */
    public String addNewStoreManager(String storeName, String newStoreManagerUserName){
        throw new UnsupportedOperationException("Not Implemented Yet");
    }

    /** User requirement - II.4.7 */
    public String changeStoreManagerPermissions(String storeName, String storeManagerUserName, User.permission newPermission){
        throw new UnsupportedOperationException("Not Implemented Yet");
    }

    /** User requirement - II.4.9 */
    public String closeStoreByOwner(String storeName){
        throw new UnsupportedOperationException("Not Implemented Yet");
    }

    /** User requirement - II.4.11 */
    public String showStoreOfficials(String storeName){
        throw new UnsupportedOperationException("Not Implemented Yet");
    }

    /** User requirement - II.4.13 */
    public String showStorePurchaseHistory(String storeName){
        throw new UnsupportedOperationException("Not Implemented Yet");
    }

    /** User requirement - II.6.4 */
    public String showPurchaseHistoryForSystemFounder(String storeOrUser, String name) {
        throw new UnsupportedOperationException("Not Implemented Yet");
    }
}
