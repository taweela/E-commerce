package Tests;

import ExternalConnections.Delivery.UPS;
import ExternalConnections.Payment.MasterCard;
import ExternalConnections.Payment.Visa;
import History.PurchaseHistory;
import Store.Product;
import Tests.Bridge.Proxy;
import Tests.Bridge.Real;
import org.junit.jupiter.api.*;

import javax.naming.NoPermissionException;
import java.lang.reflect.Method;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

public class AcceptanceTests {

    /**
     * Version 1 tests status: 104 passed, 31 failed (due to requirement that not yet implemented).
     */

    /*TODO: (Tagged with fail() in the tests)
     * 1) Parallel Use.
     * 2) Logging.
     * 3) External Services.
     */

    Proxy proxy = new Proxy(new Real());

    @BeforeEach
    void setUp() throws NoPermissionException {
        proxy.openingMarket();

//        admin: user AdminID_1, password BigBoss
//        user1: store owner of store1 (store original owner)
//        user2: store manager of store1
//        user3: subscriber
//        guest: GuestID_1

        proxy.register("user1", "11111");
        proxy.login("user1", "11111");
        String store1_id = proxy.openStore("user1", "store1");
        proxy.register("user2", "22222");

        proxy.addNewStoreManager(store1_id, "user1", "user2");
        proxy.register("user3", "33333");
        proxy.getInToTheSystem(); // for guest

        proxy.addProductToStore(store1_id, "user1", "p0", 5.0f, 0, "Other");
        proxy.addProductToStore(store1_id, "user1", "p1", 10.0f, 5, "Other");
        proxy.addProductToStore(store1_id, "user1", "p2", 15.0f, 10, "Other");
        proxy.addProductToStore(store1_id, "user1", "p3", 20.0f, 15, "Other");
    }

    @AfterEach
    void tearDown() {
//        proxy.setUsers(new ArrayList<>());
//        proxy.setStores(new ArrayList<>());
    }

    @Test
    void pass_sanity_test_success_case() {
        assertTrue(true);
    }

    /**
     *  Need to implement thread-base system
     *  (requirement 1.b in V1)
     **/
    @Test
    void parallel_use_success_case_test() {
        System.out.println("Need to implement thread-base system");
        fail();
    }
    @Test
    void parallel_use_fail_case_test() {
        System.out.println("Need to implement thread-base system");
        fail();
    }

    /**
     *  Need to create log file - contains error logs
     *  (requirement 1.c in V1)
     **/
    @Test
    void check_log_success_case_test() {
        System.out.println("Need to create log file - contains error logs");
        fail();
    }
    @Test
    void check_log_fail_case_test() {
        System.out.println("Need to create log file - contains error logs");
        fail();
    }

    /**
     *  System requirement - I.1
     *  Important Note: This test is a must! otherwise all the tests can't have a proper set-up!
     **/
    @Test
    void opening_market_system_success_case_test() throws NoPermissionException {
//        -Check that all the external services' connection are valid
//        -Check that there is a system founder
//        -Check that all users and stores uploaded successfully

//        tearDown(); // Because set-up method is the openMarket
        assertEquals("system opened successfully", proxy.openingMarket());
    }
    @Test
    void opening_market_system_fail_case_test1() throws NoPermissionException {
        //TODO: Create a fail case for this test
//        -Check that all the external services' connection are valid
//        -Check that there is a system manager
//          -> there is no system founder.

//        tearDown(); // Because set-up method is the openMarket
//        proxy.uploadUsersAndStores_FailTest1();
        assertEquals("fail - system doesn't have a founder", proxy.openingMarket());
    }
    @Test
    void opening_market_system_fail_case_test2() throws NoPermissionException {
        //TODO: Create a fail case for this test
//        -Check that all the external services' connection are valid
//        -Check that there is a system manager
//        -Check that all users and stores uploaded successfully
//          -> users/stores didn't upload successfully.

//        tearDown(); // Because set-up method is the openMarket
//        proxy.uploadUsersAndStores_FailTest2();
        assertEquals("fail - system didn't upload all the users or stores", proxy.openingMarket());
    }
    @Test
    void opening_market_system_fail_case_test3() {
        //TODO: Create a fail case for this test

//        -Check that all the external services connection are valid
//              -> No payment system is exists in the system.
        fail();
    }
    @Test
    void opening_market_system_fail_case_test4() {
        //TODO: Create a fail case for this test

//        -Check that all the external services connection are valid
//              -> No delivery system is exists in the system.
        fail();
    }
    @Test
    void opening_market_system_fail_case_test5() {
        //TODO: Create a fail case for this test

//        -Check that all the external services connection are valid
//              -> No security system is exists in the system.
        fail();
    }

    /**
     *  System requirement - I.2
     **/
    // testing change/edit external service connection
    @Test
    void change_external_service_success_case_test() {
//        TODO
//        -Check that all actions in the system work well
//        -Check that the new service is valid
//        -Check that the change done successfully

//        assertEquals("change services done successfully",
//                proxy.changeExternalService(1, "aaa",
//                        2, "bbb"));
        fail();
    }
    @Test
    void change_external_service_fail_case_test1() {
//        TODO
//        -Check that all actions in the system work well
//        -Check that the new service is valid
//          -> invalid service code

//        assertEquals("fail - invalid service code or name",
//                proxy.changeExternalService(1, "aaa",
//                        -2, "bbb"));
        fail();
    }
    @Test
    void change_external_service_fail_case_test2() {
//        TODO
//        -Check that all actions in the system work well
//        -Check that the new service is valid
//          -> invalid service name

//        assertEquals("fail - invalid service code or name",
//                proxy.changeExternalService(1, "aaa",
//                        2, "bbb222"));
        fail();
    }
    @Test
    void change_external_service_fail_case_test3() {
//        TODO
//        -Check that all actions in the system work well
//        -Check that the switch done successfully
//          -> the change itself failed / cause issues in system

        fail();
    }

    // testing switch external service connection
    @Test
    void switch_external_service_success_case_test() {
//        TODO
//        -Check that all actions in the system work well
//        -Check that the new service is valid
//        -Check that the switch done successfully

//        assertEquals("switch services done successfully",
//                proxy.switchExternalService(1, "aaa",
//                        2, "bbb"));
        fail();
    }
    @Test
    void switch_external_service_fail_case_test1() {
//        TODO
//        -Check that all actions in the system work well
//        -Check that the new service is valid
//              -> invalid service code

//        assertEquals("fail - invalid service code or name",
//                proxy.switchExternalService(1, "aaa",
//                        -2, "bbb"));
        fail();
    }
    @Test
    void switch_external_service_fail_case_test2() {
//        TODO
//        -Check that all actions in the system work well
//        -Check that the new service is valid
//              -> invalid service name

//        assertEquals("fail - invalid service code or name",
//                proxy.switchExternalService(1, "aaa",
//                        2, "bbb222"));
        fail();
    }
    @Test
    void switch_external_service_fail_case_test3() {
//        TODO
//        -Check that all actions in the system work well
//        -Check that the switch done successfully
//              -> the switch itself failed / cause issues in system
        fail();
    }

    // testing add external service connection
    @Test
    void add_external_service_success_case_test() {
//        TODO
//        -Check that all actions in the system work well
//        -Check that the new service is valid
//        -Check that the switch done successfully

//        assertEquals("adding services done successfully",
//                proxy.addExternalService(1, "aaa"));
        fail();
    }
    @Test
    void add_external_service_fail_case_test1() {
//        TODO
//        -Check that all actions in the system work well
//        -Check that the new service is valid
//              -> invalid service code

//        assertEquals("fail - invalid service code or name",
//                proxy.addExternalService(-1, "aaa"));
        fail();
    }
    @Test
    void add_external_service_fail_case_test2() {
//        TODO
//        -Check that all actions in the system work well
//        -Check that the new service is valid
//              -> invalid service name

//        assertEquals("fail - invalid service code or name",
//                proxy.addExternalService(1, "aaa111"));
        fail();
    }
    @Test
    void add_external_service_fail_case_test3() {
//        TODO
//        -Check that all actions in the system work well
//        -Check that the switch done successfully
//              -> the add itself failed / cause issues in system
        fail();
    }

    // additional methods for I.2 requirement
    @Test
    void remove_payment_service_success_case() {
//        assertTrue(proxy.AddPayment(new MasterCard()));
        assertTrue(proxy.AddPayment(new Visa()));
    }
    @Test
    void add_payment_service_success_case() {
//        assertTrue(proxy.AddPayment(new MasterCard()));
        assertTrue(proxy.AddPayment(new Visa()));
    }
    @Test
    void remove_delivery_service_success_case() {
        //assertTrue(proxy.removeDelivery("UPS"));
        assertTrue(proxy.removeDelivery("FedEx"));
    }
    @Test
    void add_delivery_service_success_case() {
        //assertTrue(proxy.removeDelivery("UPS"));
        assertTrue(proxy.removeDelivery("FedEx"));
    }

    /**
     *  System requirement - I.3
     **/
    @Test
    void payment_success_case_test() {
//        -Check that the payment service connection is valid
//        -Check payment details
//        -Check payment service answer

        // "Payment done successfully" - returning 0 means paid successfully
        assertEquals(0, proxy.payment("Visa", 50));
    }
    @Test
    void payment_fail_case_test1() {
        //TODO: Create a fail case for this test

//        -Check that the payment service connection is valid
//        -Check payment details
//        -Check payment service answer
//              -> payment service connection lost

//        // "Failed to do payment" - returning -1
//        assertNotEquals(0, proxy.payment("Visa", 50));
        fail();
    }
    @Test
    void payment_fail_case_test2() {
//        -Check that the payment service connection is valid
//        -Check payment details
//        -Check payment service answer
//              -> payment service returns an invalid answer (= the payment can't be done)

        // "Failed to do payment" - returning -1
        assertNotEquals(0, proxy.payment("Visa", -50));
    }

    /**
     *  System requirement - I.4
     **/
    @Test
    void delivery_success_case_test() {
//        -Check that the delivery service connection is valid
//        -Check delivery details
//        -Check delivery service answer

        //"Delivery done successfully"
        assertEquals(0, proxy.delivery("FedEx", 2));
    }
    @Test
    void delivery_fail_case_test1() {
        //TODO: Create a fail case for this test

//        -Check that the delivery service connection is valid
//        -Check delivery details
//        -Check delivery service answer
//              -> delivery service connection lost

//        //"Failed to do the delivery"
//        assertEquals(0, proxy.delivery("FedEx", 2));
        fail(); //assertNotEquals(proxy.delivery(), "Delivery done successfully");
    }
    @Test
    void delivery_fail_case_test2() {
//        -Check that the delivery service connection is valid
//        -Check delivery details
//        -Check delivery service answer
//              -> payment service returns an invalid answer (= the delivery can't be done)

        assertNotEquals(0, proxy.delivery("FedEx", -2));
    }

    /**
     *  System requirement - I.5
     **/
    // A user bought a product from a store
    @Test
    void realtime_notification_product_bought_success_case_test() {
//        TODO
//        - Product purchase was activated - a user logged in and bought a product
//        - Check that the store manager is logged in (will be true in this case)
//        - Check the message that just sent (will simulate the realtime message sent)

        fail();
    }
    @Test
    void realtime_notification_product_bought_fail_case_test() {
//        TODO
//        - Product purchase was activated - a user logged in and bought a product
//        - Check that the store manager is logged in (will be true in this case)
//        - Check the message that just sent (will simulate the realtime message sent)
//              -> MESSAGE DIDN'T ARRIVE

        fail();
    }

    // A store was closed, then re-opened
    @Test
    void realtime_notification_store_closed_and_opened_success_case_test() {
//        TODO
//        - Store owner closed his store (after logged in as store owner)
//        - Check that another store manager (of the same store) is logged in (will be true in this case)
//        - The store owner close the store
//        - Check the message that just sent (will simulate the realtime message sent)
//        - The store owner open the store
//        - Check that the store manager is logged in (will be true in this case)
//        - Check the message that just sent (will simulate the realtime message sent)

        fail();
    }
    @Test
    void realtime_notification_store_closed_and_opened_fail_case_test1() {
//        TODO
//        - Store owner closed his store (after logged in as store owner)
//        - Check that another store manager (of the same store) is logged in (will be true in this case)
//        - The store owner close the store
//        - Check the message that just sent (will simulate the realtime message sent)
//              -> MESSAGE DIDN'T ARRIVE

        fail();
    }
    @Test
    void realtime_notification_store_closed_and_opened_fail_case_test2() {
//        TODO
//        - Store owner closed his store (after logged in as store owner)
//        - Check that another store manager (of the same store) is logged in (will be true in this case)
//        - The store owner close the store
//        - Check the message that just sent (will simulate the realtime message sent)
//        - The store owner open the store
//        - Check that the store manager is logged in (will be true in this case)
//        - Check the message that just sent (will simulate the realtime message sent)
//              -> MESSAGE DIDN'T ARRIVE

        fail();
    }

    // A user's permissions was removed
    @Test
    void realtime_notification_user_permission_update_success_case_test() {
//        TODO
//        - Store owner update one of the store manager permissions (after logged in as store owner)
//        - Check that the store manager is logged in (will be true in this case)
//        - Check the message that just sent (will simulate the realtime message sent)

        fail();
    }
    @Test
    void realtime_notification_user_permission_update_fail_case_test() {
//        TODO
//        - Store owner update one of the store manager permissions (after logged in as store owner)
//        - Check that the store manager is logged in (will be true in this case)
//        - Check the message that just sent (will simulate the realtime message sent)
//              -> MESSAGE DIDN'T ARRIVE

        fail();
    }

    /**
     *  System requirement - I.6
     **/
    // A user bought a product from a store
    @Test
    void offline_notification_product_bought_success_case_test() {
//        TODO
//        - Product purchase was activated - a user logged in and bought a product
//        - Check that the store manager is logged in (will be true in this case)
//        - Check the message that just sent (will simulate the offline message sent)

        fail();
    }
    @Test
    void offline_notification_product_bought_fail_case_test() {
//        TODO
//        - Product purchase was activated - a user logged in and bought a product
//        - Check that the store manager is logged in (will be true in this case)
//        - Check the message that just sent (will simulate the offline message sent)
//              -> MESSAGE DIDN'T ARRIVE

        fail();
    }

    // A store was closed, then re-opened
    @Test
    void offline_notification_store_closed_and_opened_success_case_test() {
//        TODO
//        - Store owner closed his store (after logged in as store owner)
//        - Check that another store manager (of the same store) is logged in (will be true in this case)
//        - The store owner close the store
//        - Check the message that just sent (will simulate the offline message sent)
//        - The store owner open the store
//        - Check that the store manager is logged in (will be true in this case)
//        - Check the message that just sent (will simulate the offline message sent)

        fail();
    }
    @Test
    void offline_notification_store_closed_and_opened_fail_case_test1() {
//        TODO
//        - Store owner closed his store (after logged in as store owner)
//        - Check that another store manager (of the same store) is logged in (will be true in this case)
//        - The store owner close the store
//        - Check the message that just sent (will simulate the offline message sent)
//              -> MESSAGE DIDN'T ARRIVE

        fail();
    }
    @Test
    void offline_notification_store_closed_and_opened_fail_case_test2() {
//        TODO
//        - Store owner closed his store (after logged in as store owner)
//        - Check that another store manager (of the same store) is logged in (will be true in this case)
//        - The store owner close the store
//        - Check the message that just sent (will simulate the offline message sent)
//        - The store owner open the store
//        - Check that the store manager is logged in (will be true in this case)
//        - Check the message that just sent (will simulate the offline message sent)
//              -> MESSAGE DIDN'T ARRIVE

        fail();
    }

    // A user's permissions was removed
    @Test
    void offline_notification_user_permission_update_success_case_test() {
//        TODO
//        - Store owner update one of the store manager permissions (after logged in as store owner)
//        - Check that the store manager is logged in (will be true in this case)
//        - Check the message that just sent (will simulate the offline message sent)

        fail();
    }
    @Test
    void offline_notification_user_permission_update_fail_case_test() {
//        TODO
//        - Store owner update one of the store manager permissions (after logged in as store owner)
//        - Check that the store manager is logged in (will be true in this case)
//        - Check the message that just sent (will simulate the offline message sent)
//              -> MESSAGE DIDN'T ARRIVE

        fail();
    }

    /**
     *  User requirement - II.1.1
     **/
    @Test
    void get_in_to_the_system_success_case_test() {
//        - Check that the user was "visitor" before get in to the system.
//        - Perform getting in to the visitor (include shopping cart).
//        - Check that the "visitor" became "buyer" after getting in to the system.

        assertEquals("user got-in successfully", proxy.getInToTheSystem());
    }
    @Test
    void get_in_to_the_system_fail_case_test1() {
//        - Check that the user was "visitor" before get in to the system
//              -> this user is not a "visitor".

        assertEquals("fail - the user that got in is not a visitor", proxy.getInToTheSystem());
    }
    @Test
    void get_in_to_the_system_fail_case_test2() {
//        - Check that the user was "visitor" before get in to the system.
//        - Perform getting in to the visitor (include shopping cart)
//              -> this user did not get a shopping cart.

        assertEquals("fail - user failed to get-in", proxy.getInToTheSystem());
    }

    /**
     *  User requirement - II.1.2
     **/
    @Test
    void get_out_of_the_system_success_case_test() {
//        - Check that the user was a "buyer" before get out of the system.
//        - Perform getting out of the system (include emptying the shopping cart and not "buyer" anymore).
//        - Send success message...

        assertEquals("user got out successfully", proxy.getOutFromTheSystem("user1"));
    }
    @Test
    void get_out_of_the_system_fail_case_test1() {
//        - Check that the user was a "buyer" before get out of the system.
//              -> this user was already out.
//        - Send proper fail message...

        assertEquals("fail - the user already got out of the system (as buyer)",
                proxy.getOutFromTheSystem("user1"));
    }
    @Test
    void get_out_of_the_system_fail_case_test2() {
//        - Check that the user was a "buyer" before get out of the system.
//        - Perform getting out of the system (include emptying the shopping cart and not "buyer" anymore).
//              -> the shopping cart did not get empty.
//        - Send proper fail message...

        assertEquals("fail - empty user's shopping cart failed", proxy.getOutFromTheSystem("user1"));
    }
    @Test
    void get_out_of_the_system_fail_case_test3() {
//        - Check that the user was a "buyer" before get out of the system.
//        - Perform getting out of the system (include emptying the shopping cart and not "buyer" anymore).
//              -> the user stayed as "buyer".
//        - Send proper fail message...

        assertEquals("fail - user's permission didn't change to visitor",
                proxy.getOutFromTheSystem("user1"));
    }

    /**
     *  User requirement - II.1.3
     **/
    @Test
    void register_success_case_test() {
//        - Perform Register (entering username and password) & validate registration details (will return TRUE)
//        - Check that the user is still "visitor/buyer" (and not a logged-in user - until he performs login).
//        - Send success message...

        assertTrue(proxy.register("user8", "88888"));
    }
    @Test
    void register_fail_case_test1() {
//        - Perform Register (entering username and password) & validate registration details
//              -> username already exists in system.
//        - Send failure message...

        assertFalse(proxy.register("user1", "11111"));
    }
    @Test
    void register_fail_case_test2() {
//        - Perform Register (entering username and password) & validate registration details
//              -> username is not match the requirements for proper username in the system.
//        - Send failure message...

        assertFalse(proxy.register("u1", "11111"));
    }
    @Test
    void register_fail_case_test3() {
//        - Perform Register (entering username and password) & validate registration details
//              -> password is not match the requirements for proper password in the system.
//        - Send failure message...

        assertFalse(proxy.register("user0", "000"));
    }

    /**
     *  User requirement - II.1.4
     **/
    @Test
    void login_success_case_test() {
//        - Perform Login (entering username and password) & validate login details (will return TRUE)
//        - Check that the user is logged-in (shopping cart, permissions...).
//        - Send success message...

        assertTrue(proxy.login("user1", "11111"));
    }
    @Test
    void login_fail_case_test1() {
//        - Perform Login (entering username and password) & validate login details
//              -> username does not exists in system.
//        - Send failure message...

        assertFalse(proxy.login("user10", "11111"));
    }
    @Test
    void login_fail_case_test2() {
//        - Perform Login (entering username and password) & validate login details
//              -> password does not match the username's user in system.
//        - Send failure message...

        assertFalse(proxy.login("user1", "111111"));
    }

    /**
     *  User requirement - II.2.1
     **/
    @Test
    void receive_system_info_success_case_test() {
//        - Check all stores and products are presented to the costumer (will be successful).
        String str = "";
        assertEquals(str, proxy.receiveSystemInfo());
    }
    @Test
    void receive_system_info_fail_case_test() {
//        - Check all stores and products are presented to the costumer
//              -> will be empty/missing product/missing store.
//        - Send failure message...

        String str = "";
        assertNotEquals(str, proxy.receiveSystemInfo());
    }

    /**
     *  User requirement - II.2.2
     **/
    @Test
    void search_product_success_case_test() {
//        - User inserting the product he is looking for...
//        - System shows all the same products (from all stores).
//        - Check all the same products are presented to the costumer (will be successful).

        // "showing all the products that were searched by the user"
        List<Product> productList = new ArrayList<>();
        assertEquals(productList, proxy.searchProduct("user1", "p1"));
    }
    @Test
    void search_product_fail_case_test() {
//        - User inserting the product he is looking for...
//        - System shows all the same products (from all stores).
//        - Check all the same products are presented to the costumer
//              -> will be empty/missing product/missing store.

        //"there's no such product in the system (in any store)"
        List<Product> productList = new ArrayList<>(); // list will stay empty
        assertEquals(productList, proxy.searchProduct("user1", "p10"));
    }

    /**
     *  User requirement - II.2.3
     **/
    @Test
    void save_products_from_store_to_shopping_cart_success_case_test() {
//        - User selecting products from specific store.
//        - User perform save to these products.
//        - Check that the user is not a visitor.
//        - Check that all the saved products are in the user's shopping cart (will be successful).

        // "product saved to shopping cart successfully"
        assertTrue(proxy.saveProductFromStoreToShoppingCart("user1", "p1", "store1",
                                                        1, true));
    }
    @Test
    void save_products_from_store_to_shopping_cart_fail_case_test() {
//        - User selecting products from specific store.
//        - User perform save to these products.
//        - Check that the user is not a visitor.
//        - Check that all the saved products are in the user's shopping cart
//              -> the shopping cart will be empty/missing product.

        // "there's no such product in the store / there's no quantity left to this product"
        assertFalse(proxy.saveProductFromStoreToShoppingCart("user1", "notExistProd", "store1",
                                                        1, true));
    }

    /**
     *  User requirement - II.2.4
     **/
    @Test
    void show_shopping_cart_success_case_test() {
//        - Check all shopping cart info presented to the costumer (will be successful).

        assertEquals("showing user's shopping cart", proxy.showShoppingCart("user1"));
    }
    @Test
    void show_shopping_cart_fail_case_test() {
//        - Check all shopping cart info presented to the costumer (will be successful).
//              -> will be empty/missing product/missing store.
//        - Send failure message...

        assertEquals("fail - shopping cart can't be displayed", proxy.showShoppingCart("user1"));
    }
    @Test
    void increase_product_quantity_in_shopping_cart_success_case_test() {
//        - User selecting product from his shopping cart and increase its quantity.
//        - Check that the product's quantity has increased (will be successful).

        // "the product quantity increased successfully"
        assertTrue(proxy.increaseProductQuantityInShoppingCart("user1", "p1", "store1",
                                                                10, true));
    }
    @Test
    void increase_product_quantity_in_shopping_cart_fail_case_test() {
//        - User selecting product from his shopping cart and increase its quantity.
//        - Check that the product's quantity has increased
//              ->  the product's quantity did not increase

        // "fail - visitor user can't use shopping cart (need to be at least buyer)"
        assertFalse(proxy.increaseProductQuantityInShoppingCart("user00", "p1", "store1",
                        10, true));
    }
    @Test
    void decrease_product_quantity_in_shopping_cart_success_case_test() {
//        - User selecting product from his shopping cart and decrease its quantity.
//        - Check that the product's quantity has decreased (will be successful).

        // "the product quantity decreased successfully"
        assertTrue(proxy.decreaseProductQuantityInShoppingCart("user1", "p1", "store1",10));
    }
    @Test
    void decrease_product_quantity_in_shopping_cart_fail_case_test() {
//        - User selecting product from his shopping cart and decrease its quantity.
//        - Check that the product's quantity has decreased
//              ->  the product's quantity did not decreased

        // "fail - visitor user can't use shopping cart (need to be at least buyer)"
        assertFalse(proxy.decreaseProductQuantityInShoppingCart("user00", "p1", "store1",10));
    }
    @Test
    void remove_product_from_shopping_cart_success_case_test() {
        //- User selecting product from his shopping cart and remove it from cart.
        //- Check that the product isn't in the cart (will be successful).

        assertEquals("the product removed successfully",
                proxy.removeProductFromShoppingCart("p4"));
    }
    @Test
    void remove_product_from_shopping_cart_fail_case_test() {
        //- User selecting product from his shopping cart and remove it from cart.
        //- Check that the product isn't in the cart
        //    ->  the product is still in the cart

        assertEquals("fail - visitor user can't use shopping cart (need to be at least buyer)",
                proxy.removeProductFromShoppingCart("p4"));
    }

    /**
     *  User requirement - II.2.5
     **/
    @Test
    void purchase_shopping_cart_success_case_test() {
//        System.out.println("""
//                - Perform purchase of the shopping cart.
//                - Check all external services returns required answers.
//                - Show success message to the user (later on - will need to update quantity in the system).
//                """);

        assertTrue(proxy.purchaseShoppingCart("user1", "Visa", "FedEx"));
    }
    @Test
    void purchase_shopping_cart_fail_case_test1() {
//        System.out.println("""
//                - Perform purchase of the shopping cart.
//                - Check all external services returns required answers -> will return error message.
//                - Show failure message to the user.
//                """);

        assertFalse(proxy.purchaseShoppingCart("user1", "Visa...", "FedEx"));
    }
    @Test
    void purchase_shopping_cart_fail_case_test2() {
//        System.out.println("""
//                - Perform purchase of the shopping cart.
//                - Check all external services returns required answers -> will return error message.
//                - Show failure message to the user.
//                """);

        assertFalse(proxy.purchaseShoppingCart("user1", "Visa", "FedEx..."));
    }

    /**
     *  User requirement - II.3.1
     **/
    @Test
    void logout_success_case_test() {
//        - Perform logout.
//        - Check that user was logged-in.
//        - The system saving the user's shopping cart.
//        - The user is now a visitor (when login again, he will get his cart).

        // "logout done successfully"
        assertTrue(proxy.logout("user1"));
    }
    @Test
    void logout_fail_case_test1() {
//        - Perform logout.
//        - Check that user was logged-in
//              -> the user is not logged in.
//        - Show fail massage...

        // "fail - this user isn't logged in"
        assertTrue(proxy.logout("user100"));
    }
    @Test
    void logout_fail_case_test2() {
//        TODO
//        - Perform logout.
//        - Check that user was logged-in (in this case the user was logged in).
//        - The system saving the user's shopping cart.
//              -> saving cart has failed.
//        - Show fail massage...

        fail();
    }

    /**
     *  User requirement - II.3.2
     **/
    @Test
    void open_store_success_case_test() {
//        - User inserting new store details.
//        - The system checks these details (will be valid) & check user is registered/logged in.
//        - Opening store will be activated & check that new permissions were given to the user (as store owner).
//        - Show success message...

        assertEquals("store was opened successfully", proxy.openStore("user2", "store2"));
    }
    @Test
    void open_store_fail_case_test1() {
//        - User inserting new store details.
//        - The system checks these details (will be valid) & check user is registered/logged in ->
//                  -> store name is already exists.
//        - Show fail message...

        assertEquals("fail - this store name is already taken", proxy.openStore("user1", "store1"));
    }
    @Test
    void open_store_fail_case_test2() {
//        - User inserting new store details.
//        - The system checks these details (will be valid) & check user is registered/logged in ->
//                  -> user is not registered/logged-in to his user.
//        - Show fail message...

        assertEquals("fail - registration & login are required in order to open a store",
                proxy.openStore("user3", "store2")); //Not logged in
    }
    @Test
    void open_store_fail_case_test3() {
//        - User inserting new store details.
//        - The system checks these details (will be valid) & check user is registered/logged in ->
//                  -> user is not registered/logged-in to his user.
//        - Show fail message...

        assertEquals("fail - registration & login are required in order to open a store",
                proxy.openStore("user10", "store2")); //Not registered
    }
    @Test
    void open_store_fail_case_test4() {
//        - User inserting new store details.
//        - The system checks these details (will be valid) & check user is registered/logged in ->
//                  -> store details are invalid (not matching the store details required in the system).
//        - Show fail message...

        assertEquals("fail - store name is not valid", proxy.openStore("user2", "st2"));
    }

    /**
     *  User requirement - II.4.1
     **/
    @Test
    void store_management_add_product_success_case_test() {
//        - Check that the user is logged in as store owner.
//        - User inserting new product details.
//        - Adding product to store activated.
//        - Check that the product is now in the store (will be true).

        // "product was added to the store successfully"
        assertTrue(proxy.addProductToStore("store1", "user1", "p1",
                    5.0f, 1, "Other"));
    }
    @Test
    void store_management_add_product_fail_case_test1() {
//        - Check that the user is logged in as store owner.
//                  -> user isn't logged in as store owner.
//        - Show fail message...

        // "fail - user has to be at least shop owner and to be logged in"
        assertFalse(proxy.addProductToStore("store1", "user4", "p1",
                5.0f, 1, "Other")); //user not logged in
    }
    @Test
    void store_management_add_product_fail_case_test2() {
//        - Check that the user is logged in as store owner.
//                  -> user isn't registered in as store owner.
//        - Show fail message...

        // "fail - user has to be at least shop owner and to be logged in"
        assertFalse(proxy.addProductToStore("store1", "user44", "p1",
                5.0f, 1, "Other")); //user not registered
    }
    @Test
    void store_management_add_product_fail_case_test3() {
//        - Check that the user is logged in as store owner.
//        - User inserting new product details.
//                  -> the details inserted isn't match details info in the system.
//        - Show fail message...

        // "fail - product name/price/quantity is not valid"
        assertFalse(proxy.addProductToStore("store1", "user44", "ppp...",
                5.0f, 1, "Other"));
    }
    @Test
    void store_management_add_product_fail_case_test4() {
//        - Check that the user is logged in as store owner.
//        - User inserting new product details.
//                  -> the details inserted isn't match details info in the system.
//        - Show fail message...

        // "fail - product name/price/quantity is not valid"
        assertFalse(proxy.addProductToStore("store1", "user1", "p1",
                        -5.0f, 1, "Other"));
    }
    @Test
    void store_management_add_product_fail_case_test5() {
//        - Check that the user is logged in as store owner.
//        - User inserting new product details.
//                  -> the details inserted isn't match details info in the system.
//        - Show fail message...

        // "fail - product name/price/quantity is not valid"
        assertFalse(proxy.addProductToStore("store1", "user1", "p1",
                5.0f, -1, "Other"));
    }

    @Test
    void store_management_remove_product_success_case_test() {
//        - Check that the user is logged in as store owner.
//        - User inserting an existing product details.
//        - Removing product from store activated.
//        - Check that the product is now not in the store (will be true).

        // "product was removed from the store successfully"
        assertTrue(proxy.removeProductFromStore("store1", "user1", "p1"));
    }
    @Test
    void store_management_remove_product_fail_case_test1() {
//        - Check that the user is logged in as store owner.
//               -> user isn't logged in as store owner.
//        - Show fail message...

        // "fail - user has to be at least shop owner and to be logged in"
        assertFalse(proxy.removeProductFromStore("store1", "user4", "p1")); //not logged in
    }
    @Test
    void store_management_remove_product_fail_case_test2() {
//        - Check that the user is logged in as store owner.
//              -> user isn't registered in as store owner.
//        - Show fail message...

        // "fail - user has to be at least shop owner and to be logged in"
        assertFalse(proxy.removeProductFromStore("store1", "user44", "p1")); //not registered
    }
    @Test
    void store_management_remove_product_fail_case_test3() {
//        - Check that the user is logged in as store owner.
//        - User inserting existing product details.
//              -> there is no product in the store with these details.
//        - Show fail message...

        // "failed to remove product (check storeName or productName)"
        assertFalse(proxy.removeProductFromStore("store1", "user1", "ppp..."));
    }

    @Test
    void store_management_edit_product_success_case_test() {
//        - Check that the user is logged in as store owner.
//        - User inserting an existing product details & updated details to that product.
//        - Editing product in store activated.
//        - Check that the product is now updated (will be true).

        // "product was edited in the store successfully"
        assertTrue(proxy.editProductInStore("store1", "user1", "p1", 50,
                                        "prod1", 10.0f, "Other"));
    }
    @Test
    void store_management_edit_product_fail_case_test1() {
//        - Check that the user is logged in as store owner.
//              -> user isn't logged in as store owner.
//        - Show fail message...

        // "fail - user has to be at least shop owner and to be logged in"
        assertFalse(proxy.editProductInStore("store1", "user4", "p1", 50,
                "prod1", 10.0f, "Other")); // not logged in
    }
    @Test
    void store_management_edit_product_fail_case_test2() {
//        - Check that the user is logged in as store owner.
//               -> user isn't registered as store owner.
//        - Show fail message...

        // "fail - user has to be at least shop owner and to be logged in"
        assertFalse(proxy.editProductInStore("store1", "user14", "p1", 50,
                "prod1", 10.0f, "Other")); // not registered
    }
    @Test
    void store_management_edit_product_fail_case_test3() {
//        - Check that the user is logged in as store owner.
//        - User inserting an existing product details & updated details to that product.
//               -> there is no product in the store with these details.
//        - Show fail message...

        // "fail - new product name/price/quantity is not valid"
        assertFalse(proxy.editProductInStore("store1", "user14", "p1", 50,
                "ppp...", 10.0f, "Other"));
    }
    @Test
    void store_management_edit_product_fail_case_test4() {
//        - Check that the user is logged in as store owner.
//        - User inserting an existing product details & updated details to that product.
//               -> there is no product in the store with these details.
//        - Show fail message...

        // "fail - new product name/price/quantity is not valid"
        assertFalse(proxy.editProductInStore("store1", "user14", "p1", 50,
                "prod1", -10.0f, "Other"));
    }
    @Test
    void store_management_edit_product_fail_case_test5() {
//        - Check that the user is logged in as store owner.
//        - User inserting an existing product details & updated details to that product.
//                  -> there is no product in the store with these details.
//        - Show fail message...

        // "fail - new product name/price/quantity is not valid"
        assertFalse(proxy.editProductInStore("store1", "user14", "p1", -50,
                "prod1", 10.0f, "Other"));
    }
    @Test
    void store_management_edit_product_fail_case_test6() {
//        - Check that the user is logged in as store owner.
//        - User inserting an existing product details & updated details to that product.
//                  -> there is no product in the store with these details.
//        - Show fail message...

        // "fail - new product name/price/quantity is not valid"
        assertFalse(proxy.editProductInStore("store1...", "user14", "p1", 50,
                "prod1", 10.0f, "Other"));
    }

    /**
     *  User requirement - II.4.2
     **/
    @Test
    void change_store_policy_success_case_test() {
//        - Check that the user is logged in as store owner.
//        - User inserting the new policy details.
//        - Changing store policy is activated.
//        - Check that the store policy is now updated (will be true).

        assertEquals("changed policy successfully",
                proxy.changeStorePolicy("store1", "20% discount policy"));
    }
    @Test
    void change_store_policy_fail_case_test1() {
//        - Check that the user is logged in as store owner.
//                  -> User isn't logged in as a store owner.
//        - Show fail message...

        assertEquals("fail - user has to be at least shop owner and to be logged in",
                proxy.changeStorePolicy("store1", "20% discount policy"));
    }
    @Test
    void change_store_policy_fail_case_test2() {
//        - Check that the user is logged in as store owner.
//                  -> User isn't registered as a store owner.
//        - Show fail message...

        assertEquals("fail - user has to be at least shop owner and to be logged in",
                proxy.changeStorePolicy("store1", "20% discount policy"));
    }
    @Test
    void change_store_policy_fail_case_test3() {
//        - Check that the user is logged in as store owner.
//        - User inserting the new policy details.
//                  -> details doesn't match to a policy in the system
//        - Show fail message...

        assertEquals("fail - new policy is not valid",
                proxy.changeStorePolicy("store1", "policy"));
    }
    @Test
    void change_store_policy_fail_case_test4() {
//        - Check that the user is logged in as store owner.
//        - User inserting the new policy details.
//        - Changing store policy is activated.
//        - Check that the store policy is now updated (will be FALSE).

        assertEquals("fail - the user is not owner on that store (Check store name)",
                proxy.changeStorePolicy("store1", "irregular policy"));
    }

    /**
     *  User requirement - II.4.4
     **/
    @Test
    void adding_store_owner_success_case_test() {
//        - Check that the user (adding the new store owner) is logged in as store owner.
//        - User inserting the new store owner details.
//        - Check that the new owner is registered to the system and not already a store owner.
//        - Adding store owner to the store is activated.
//        - Check that the new owner has been added (will be true).

        // "the user is now store owner"
        assertTrue(proxy.addNewStoreOwner("store1", "user1", "user4",
                                        new ArrayList<>()/*permissions*/));
    }
    @Test
    void adding_store_owner_fail_case_test1() {
//        - Check that the user (adding the new store owner) is logged in as store owner.
//                  -> the user isn't logged in as a store owner.
//        - Show fail message...

        // "fail - user has to be at least shop owner and to be logged in"
        assertFalse(proxy.addNewStoreOwner("store1", "user3", "user4",
                new ArrayList<>()/*permissions*/)); // not logged in
    }
    @Test
    void adding_store_owner_fail_case_test2() {
//        - Check that the user (adding the new store owner) is logged in as store owner.
//                  -> the user isn't registered as a store owner.
//        - Show fail message...

        // "fail - user has to be at least shop owner and to be logged in"
        assertFalse(proxy.addNewStoreOwner("store1", "user11", "user4",
                new ArrayList<>()/*permissions*/)); // not registered
    }
    @Test
    void adding_store_owner_fail_case_test3() {
//        - Check that the user (adding the new store owner) is logged in as store owner.
//        - User inserting the new store owner details.
//        - Check that the new owner is registered to the system and not already a store owner
//                  -> the new owner inserted isn't a user in the system
//        - Show fail message...

        // "fail - store name or username is invalid"
        assertFalse(proxy.addNewStoreOwner("store1...", "user1...", "user4",
                        new ArrayList<>()/*permissions*/));
    }
    @Test
    void adding_store_owner_fail_case_test4() {
//        - Check that the user (adding the new store owner) is logged in as store owner.
//        - User inserting the new store owner details.
//        - Check that the new owner is registered to the system and not already a store owner
//                  -> the new owner inserted is already a store owner
//        - Show fail message...

        // "fail - this user is already managing/owning a store in the system"
        assertFalse(proxy.addNewStoreOwner("store2", "user1", "user4",
                new ArrayList<>()/*permissions*/));
    }

    /**
     *  User requirement - II.4.6
     **/
    @Test
    void adding_store_manager_success_case_test() {
//        - Check that the user (adding the new store manager) is logged in as store owner.
//        - User inserting the new store manager details.
//        - Check that the new owner is registered to the system and not already a store owner or store manager.
//        - Adding store manager to the store is activated.
//        - Check that the new manager has been added (will be true).

        // "the user is now store manager"
        assertTrue(proxy.addNewStoreManager("store1", "user1", "user5"));
    }
    @Test
    void adding_store_manager_fail_case_test1() {
//        - Check that the user (adding the new store owner) is logged in as store owner.
//                  -> the user isn't logged in as a store owner.
//        - Show fail message...

        // "fail - user has to be at least shop owner and to be logged in"
        assertFalse(proxy.addNewStoreManager("store1", "user2", "user5")); //not logged in
    }
    @Test
    void adding_store_manager_fail_case_test2() {
//        - Check that the user (adding the new store owner) is logged in as store owner.
//                  -> the user isn't registered as a store owner.
//        - Show fail message...

        // "fail - user has to be at least shop owner and to be logged in"
        assertFalse(proxy.addNewStoreManager("store1", "user22", "user5")); //not registered
    }
    @Test
    void adding_store_manager_fail_case_test3() {
//        - Check that the user (adding the new store manager) is logged in as store owner.
//        - User inserting the new store manager details.
//        - Check that the new owner is registered to the system and not already a store owner or store manager
//                  -> the new manager inserted isn't a user in the system
//        - Show fail message...

        // "fail - store name or username is invalid"
        assertFalse(proxy.addNewStoreManager("store1...", "user1...", "user5"));
    }
    @Test
    void adding_store_manager_fail_case_test4() {
//        - Check that the user (adding the new store manager) is logged in as store owner.
//        - User inserting the new store manager details.
//        - Check that the new manager is registered to the system and not already a store owner or store manager
//                  -> the new owner inserted is already a store owner or store manager
//        - Show fail message...

        assertFalse(proxy.addNewStoreManager("store1", "user1", "user2"));
    }

    /**
     *  User requirement - II.4.7
     **/
    @Test
    void change_store_manager_permissions_success_case_test() {
//        - Check that the user (changing the store manager permissions) is logged in as store owner.
//        - User changing the store manager permissions.
//        - Check that the manager's permissions has been updated (will be true).

        assertEquals("store manager permission has changed successfully",
                proxy.changeStoreManagerPermissions("store1", "user3", "ShopOwner"));
    }
    @Test
    void change_store_manager_permissions_fail_case_test1() {
//        - Check that the user (changing the store manager permissions) is logged in as store owner.
//                  -> the user isn't logged/registered in as a store owner.
//        - Show fail message...

        assertEquals("fail - user has to be at least shop owner and to be logged in",
                proxy.changeStoreManagerPermissions("store1", "user3", "ShopOwner"));
    }
    @Test
    void change_store_manager_permissions_fail_case_test2() {
//        - Check that the user (changing the store manager permissions) is logged in as store owner.
//            -> the user isn't registered as a store owner.
//        - Show fail message...

        assertEquals("fail - user has to be at least shop owner and to be logged in",
                proxy.changeStoreManagerPermissions("store1", "user3", "ShopOwner"));
    }
    @Test
    void change_store_manager_permissions_fail_case_test3() {
//        - Check that the user (changing the store manager permissions) is logged in as store owner.
//        - User changing the store manager permissions.
//        - Check that the manager's permissions has been updated (will be FALSE).

        assertEquals("fail - this user is not a manager in that store",
                proxy.changeStoreManagerPermissions("store1", "user5", "ShopOwner"));
    }

    /**
     *  User requirement - II.4.9
     **/
    @Test
    void close_store_success_case_test() {
//        - Check that the user is logged in as store owner.
//        - User closing the store.
//        - Check that the store is closed (will be true).

        // "the store has closed successfully"
        //TODO: Make sure the store is open first!
        assertTrue(proxy.freezeStoreByOwner("store1", "user1"));
    }
    @Test
    void close_store_fail_case_test1() {
//        - Check that the user is logged in as store owner.
//                  -> the user isn't a store owner.
//        - Show fail message...

        // "fail - user has to be at least shop owner and to be logged in"
        assertFalse(proxy.freezeStoreByOwner("store1", "user4")); //not logged in
    }
    @Test
    void close_store_fail_case_test2() {
//        - Check that the user is logged in as store owner.
//                  -> the user isn't logged in.
//        - Show fail message...

        // "fail - user has to be at least shop owner and to be logged in"
        assertFalse(proxy.freezeStoreByOwner("store1", "user44")); //not registered
    }
    @Test
    void close_store_fail_case_test3() {
//        - Check that the user is logged in as store owner.
//        - User closing the store.
//        - Check that the store is closed (store was already closed).

        //"the store was already closed"
        //TODO: Make sure the store is closed first!
        assertFalse(proxy.freezeStoreByOwner("store1", "user1"));
    }

    /**
     *  User requirement - II.4.10
     **/
    @Test
    void unfreeze_store_success_case_test() {
//        - Check that the user is logged in as store owner.
//        - User re-open the store.
//        - Check that the store is open (will be true).

        // "the store has closed successfully"
        //TODO: Make sure the store is frozen first!
        assertTrue(proxy.unfreezeStoreByOwner("store1", "user1"));
    }
    @Test
    void unfreeze_store_fail_case_test1() {
//        - Check that the user is logged in as store owner.
//                  -> the user isn't a store owner.
//        - Show fail message...

        // "fail - user has to be at least shop owner and to be logged in"
        assertFalse(proxy.unfreezeStoreByOwner("store1", "user4")); //not logged in
    }
    @Test
    void unfreeze_store_fail_case_test2() {
//        - Check that the user is logged in as store owner.
//                  -> the user isn't logged in.
//        - Show fail message...

        // "fail - user has to be at least shop owner and to be logged in"
        assertFalse(proxy.unfreezeStoreByOwner("store1", "user44")); //not registered
    }
    @Test
    void unfreeze_store_fail_case_test3() {
//        - Check that the user is logged in as store owner.
//        - User re-open the store.
//        - Check that the store is open (store was already opened).

        //"the store was already closed"
        //TODO: Make sure the store is open first!
        assertFalse(proxy.unfreezeStoreByOwner("store1", "user1"));
    }

    /**
     *  User requirement - II.4.11
     **/
    @Test
    void show_store_officials_success_case_test() { //officials = store owners/store managers
//        - Check that the user is logged in as store owner.
//        - Activate presenting all store's official (will show all the officials correctly).

        // "showing all the officials..."
        assertTrue(proxy.showStoreOfficials("store1", "user1"));
    }
    @Test
    void show_store_officials_fail_case_test1() { //officials = store owners/store managers
        //- Check that the user is logged in as store owner.
        //          -> the user isn't a store owner.
        //- Show fail message...

        // "fail - user has to be at least shop owner and to be logged in"
        assertFalse(proxy.showStoreOfficials("store1", "user5")); //not store owner
    }
    @Test
    void show_store_officials_fail_case_test2() { //officials = store owners/store managers
        //- Check that the user is logged in as store owner.
        //          -> the user isn't logged in as store owner.
        //- Show fail message...

        // "fail - user has to be at least shop owner and to be logged in"
        assertFalse(proxy.showStoreOfficials("store1", "user3")); //not logged in
    }
    @Test
    void show_store_officials_fail_case_test3() { //officials = store owners/store managers
//        - Check that the user is logged in as store owner.
//        - Activate presenting all store's official
//                  -> will fail to show the officials / will miss at least one of them

        // "fail - the user is not owner on that store (Check store name)"
        assertFalse(proxy.showStoreOfficials("s1", "user1"));
    }

    /**
     *  User requirement - II.4.13
     **/
    @Test
    void show_store_purchase_history_success_case_test() {
//        - Check that the user is logged in as store owner.
//        - Activate presenting all store's purchase history (will show it all correctly).

        List<PurchaseHistory> list = new ArrayList<>();
        // "showing all the purchase history..."
        assertEquals(list, proxy.showStorePurchaseHistory("store1"));
    }
    @Test
    void show_store_purchase_history_fail_case_test1() {
//        - Check that the user is logged in as store owner.
//                  -> the user isn't a store owner.
//        - Show fail message...

        List<PurchaseHistory> list = new ArrayList<>();
        // "fail - user has to be at least shop owner and to be logged in"
        assertEquals(list, proxy.showStorePurchaseHistory("store1"));
    }
    @Test
    void show_store_purchase_history_fail_case_test2() {
//        - Check that the user is logged in as store owner.
//                  -> the user isn't a store owner.
//        - Show fail message...

        List<PurchaseHistory> list = new ArrayList<>();
        // "fail - user has to be at least shop owner and to be logged in"
        assertEquals(list, proxy.showStorePurchaseHistory("store1"));
    }
    @Test
    void show_store_purchase_history_fail_case_test3() {
        //- Check that the user is logged in as store owner.
        //- Activate presenting all store's purchase history (will show it all correctly)
        //          -> will not show all purchase history / will miss at least one of the purchases

        List<PurchaseHistory> list = new ArrayList<>();
        // "fail - the user is not owner on that store (Check store name)"
        assertEquals(list, proxy.showStorePurchaseHistory("store1..."));
    }

    /**
     *  User requirement - II.6.4
     **/
    @Test
    void show_purchase_history_to_system_founder_success_case_test1() {
//        - Check that the user is logged in as store owner.
//        - Activate presenting required purchase history (will show it all correctly).

        assertEquals("showing all the purchase history...",
                proxy.showPurchaseHistoryForSystemFounder("store", "store1"));
    }
    @Test
    void show_purchase_history_to_system_founder_success_case_test2() {
//        - Check that the user is logged in as store owner.
//        - Activate presenting required purchase history (will show it all correctly).

        assertEquals("Show user history purchase...",
                proxy.showPurchaseHistoryForSystemFounder("user", "user2"));
    }
    @Test
    void show_purchase_history_to_system_founder_fail_case_test1() {
//        - Check that the user is logged in as store owner.
//                  -> the user isn't a system founder owner.
//        - Show fail message...

        assertEquals("fail - user has to be system founder and to be logged in",
                proxy.showPurchaseHistoryForSystemFounder("store", "store1"));
    }
    @Test
    void show_purchase_history_to_system_founder_fail_case_test2() {
//        - Check that the user is logged in as store owner.
//                  -> the user isn't logged in.
//        - Show fail message...

        assertEquals("fail - user has to be system founder and to be logged in",
                proxy.showPurchaseHistoryForSystemFounder("store", "store1"));
    }
    @Test
    void show_purchase_history_to_system_founder_fail_case_test3() {
//        - Check that the user is logged in as store owner.
//        - Activate presenting all store's purchase history
//                  -> will not show all purchase history / will miss at least one of the purchases

        assertEquals("fail - user have to ask user/store only",
                proxy.showPurchaseHistoryForSystemFounder("st", "store1"));
    }

}


