import Controllers.StoreController;
import StorePermission.User;

import javax.naming.NoPermissionException;
import java.util.ArrayList;
import java.util.List;

public class testing {
    public static void main(String[] args) {
        try {
            StoreController con = new StoreController();

            User guy = new User() {
                @Override
                public String getUserId() {
                    return "guy";
                }
            };
            List<String> managers = new ArrayList<>();
            managers.add(guy.getUserId());
            con.openNewStore("guys store", managers);

            con.addNewProduct("StoreID_0", guy.getUserId(), "firstProduct", 2f, 4, "Other");
        } catch (NoPermissionException e) {
            e.printStackTrace();
        }
    }
}

