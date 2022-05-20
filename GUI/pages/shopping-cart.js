import { useEffect, useState } from "react";
import Menu from "../components/menu";
import CartItem from "../components/cart-item.js";
import { useCookies } from "react-cookie";

const shoppingCart = () => {
  const [cart, setCart] = useState([]);
  const [storeList, setStoreList] = useState([]);
  const [isLoading, setIsLoading] = useState(true);
  const [cookies, setCookie, removeCookie] = useCookies([
    "username",
    "password",
    "userId",
  ]);
  const [userPermission, setUserPermission] = useState("Admin"); //TODO: Need to change to Guest when logic is ready!
  //      + Edit using new method "setUserPermission"

  useEffect(() => {
    // const fetchCart = async () => {
    //   return await api.get("/cart/" + window.id).then((res) => {
    //     if (res.status === 200) {
    //       const { data } = res;
    //       setIsLoading(!isLoading);
    //       setCart(JSON.parse(data));
    //     }
    //   });
    // };
    // fetchCart();
    setCart([1, 2, 3, 4]);
    setStoreList([1, 2, 3, 4]);
    console.log(cookies.username);
  }, []);

  const onBuy = (e) => {
    e.preventDefault();
    ///send cart to back to purcash
  };
  return (
    <>
      <Menu />
      <div className="text-center my-5">
        <h3>Cart</h3>
      </div>
      <div className="container">
        <div className="row">
          <div className="col-sm">
            <ul className="list-group list-group-flush">
              {storeList.map((item) => {
                return (
                  <div
                    className="container card mb-5"
                    style={{ width: "45rem" }}
                  >
                    <div className="card-header mb-3 text-center">
                      Store name
                    </div>
                    <ul>
                      {cart.map((item2) => {
                        return <CartItem />;
                      })}
                    </ul>
                  </div>
                );
              })}
            </ul>
          </div>
          <div className="col-sm">
            <form className="row g-3 sticky-sm-top">
              <div className="text-center">Subtotal: Price from back</div>
              <div className="text-center">Discount: Price from back</div>
              <div className="text-center">Total: total to pay</div>
              <div className="col-12 d-flex justify-content-center mt-3">
                <button
                  type="button"
                  className="btn btn-primary w-25"
                  onClick={onBuy}
                >
                  Buy
                </button>
              </div>
            </form>
          </div>
        </div>
      </div>
    </>
  );
};

export default shoppingCart;
