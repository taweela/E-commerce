import Link from "next/link";
import { useCookies } from "react-cookie";
import { useState } from "react";
import createNotification from "./norification";

const Menu = () => {
  const [cookies, setCookie, removeCookie] = useCookies([
    "username",
    "password",
    "userId",
    "type",
  ]);

  const [registerInput, setRegisterInput] = useState({
    username: "",
    password: "",
  });

  const [loginInput, setLoginInput] = useState({
    username: "",
    password: "",
  });

  const onSumbitRegister = (e) => {
    e.preventDefault();
    let encryptedPassword = 0;
    const encrypted = async () =>
      await bcrypt.hashSync(registerInput.password, 8);
    encrypted().then((res) => (encryptedPassword = res));
    api
      .post(`/register/${registerInput.username}/${encryptedPassword}`)
      .then((res) => {
        if (res.status === 200) {
          createNotification("success", "Register successfully")();
        } else {
          createNotification(
            "error",
            "Username and password was not valid , please try again"
          )();
        }
      });
  };

  const onSumbitLogin = (e) => {
    e.preventDefault();
    let encryptedPassword = 0;
    const encrypted = async () =>
      await bcrypt.hashSync(loginInput.password, 8);
    encrypted().then((res) => (encryptedPassword = res));
    api
      .post(`/users/login/${loginInput.username}/${encryptedPassword}`)
      .then((res) => {
        if (res.status === 200) {
          createNotification("success", "Login successfully")();
        } else {
          createNotification(
            "error",
            "Username and password was not valid , please try again"
          )();
        }
      });
  };

  return (
    <>
      {cookies.type === "admin" ? ( //Admin Menu
        <div className="flex">
          <div className="navbar navbar-expand-lg navbar-dark bg-primary">
            <Link href="/dashboard">
              <a className="ms-5">
                <h2>Marketplace</h2>
              </a>
            </Link>
            <div className="container">
              <button
                className="navbar-toggler"
                type="button"
                data-bs-toggle="collapse"
                data-bs-target="#navmenu"
              >
                <span className="navbar-toggler-icon" />
              </button>
              <div className="collapse navbar-collapse justify-content-center align-content-center">
                <ul className="navbar-nav" id="navmenu">
                  <li className="shopping-cart-button nav-item">
                    <Link href="/shopping-cart">
                      <a className="nav-link ms-4">Shopping Cart</a>
                    </Link>
                  </li>
                  <li className="open-new-store-button nav-item">
                    <Link href="/open-new-store">
                      <a className="nav-link ms-4">Open New Store</a>
                    </Link>
                  </li>
                  {/* <li className="store-management-button nav-item">
                <Link href="/store-management">
                  <a className="nav-link ms-4">Store Management</a>
                </Link>
              </li> */}
                  <li className="store-management-button nav-item">
                    <Link href="/stores">
                      <a className="nav-link ms-4">Stores</a>
                    </Link>
                  </li>
                  <li className="admin-actions-button nav-item">
                    <Link href="/admin-actions">
                      <a className="nav-link ms-4">Admin Actions</a>
                    </Link>
                  </li>
                  <li className="my-bids-button nav-item">
                    <Link href="#">
                      <a
                        className="nav-link ms-4"
                        onClick={createNotification("info", "message")}
                      >
                        My Bids
                      </a>
                    </Link>
                  </li>
                  <li className="history-button nav-item">
                    <Link href="#">
                      <a
                        className="nav-link ms-4"
                        onClick={() => {
                          setCookie("type", "guest", {
                            path: "/",
                            sameSite: true,
                          });
                          return createNotification("info", "in guest menu")();
                        }}
                      >
                        History
                      </a>
                    </Link>
                  </li>
                  <li className="notify-admins-button nav-item">
                    <Link href="/notify-admins">
                      <a className="nav-link ms-4">Notify Admins</a>
                    </Link>
                  </li>
                  <li className="notifications-button nav-item">
                    <Link href="#">
                      <a
                        className="nav-link ms-4"
                        onClick={createNotification("info", "message")}
                      >
                        Notifications
                      </a>
                    </Link>
                  </li>
                  <li className="statistics-button nav-item">
                    <Link href="/statistics">
                      <a className="nav-link ms-4">Statistics</a>
                    </Link>
                  </li>
                  <li className="logout-button nav-item">
                    <Link href="/login">
                      <a className="nav-link ms-4">Logout</a>
                    </Link>
                  </li>
                </ul>
              </div>
            </div>
          </div>
        </div>
      ) : cookies.type === "guest" ? ( //Guest Menu
        <div>
          <div className="flex">
            <div className="navbar navbar-expand-lg navbar-dark bg-primary">
              <Link href="/dashboard">
                <a className="ms-5">
                  <h2>Marketplace</h2>
                </a>
              </Link>
              <div className="container">
                <button
                  className="navbar-toggler"
                  type="button"
                  data-bs-toggle="collapse"
                  data-bs-target="#navmenu"
                >
                  <span className="navbar-toggler-icon" />
                </button>
                <div className="collapse navbar-collapse justify-content-center align-content-center">
                  <ul className="navbar-nav" id="navmenu">
                    <li className="shopping-cart-button nav-item">
                      <Link href="/shopping-cart">
                        <a className="nav-link ms-4">Shopping Cart</a>
                      </Link>
                    </li>
                    <li className="store-management-button nav-item">
                      <Link href="/stores">
                        <a className="nav-link ms-4">Stores</a>
                      </Link>
                    </li>
                    <li className="my-bids-button nav-item">
                      <Link href="#">
                        <a
                          className="nav-link ms-4"
                          onClick={createNotification("info", "message")}
                        >
                          My Bids
                        </a>
                      </Link>
                    </li>
                    <li className="history-button nav-item">
                      <Link href="#">
                        <a
                          className="nav-link ms-4"
                          onClick={() => {
                            setCookie("type", "manager", {
                              path: "/",
                              sameSite: true,
                            });
                            return createNotification(
                              "info",
                              "in manager menu"
                            )();
                          }}
                        >
                          History
                        </a>
                      </Link>
                    </li>
                    <li>
                      <a
                        type="button"
                        className="nav-link ms-4"
                        data-bs-toggle="modal"
                        data-bs-target="#register"
                      >
                        Become a member
                      </a>
                    </li>
                    <li>
                      <a
                        type="button"
                        className="nav-link ms-4"
                        data-bs-toggle="modal"
                        data-bs-target="#login"
                      >
                        Login
                      </a>
                    </li>
                    <li className="logout-button nav-item">
                      <Link href="/login">
                        <a className="nav-link ms-4">Logout</a>
                      </Link>
                    </li>
                  </ul>
                </div>
              </div>
            </div>
          </div>

          <div
            className="modal fade"
            id="register"
            tabIndex="-1"
            role="dialog"
            aria-labelledby="registerTitle"
            aria-hidden="true"
          >
            <div className="modal-dialog modal-dialog-centered" role="document">
              <div className="modal-content">
                <div className="modal-header">
                  <h5 className="modal-title" id="registerTitle">
                    Register
                  </h5>
                </div>
                <div className="modal-body">
                  <div>
                    <input
                      placeholder="Enter username"
                      value={registerInput.username}
                      onChange={(e) =>
                        setRegisterInput((prevState) => ({
                          ...prevState,
                          username: e.target.value,
                        }))
                      }
                    />
                  </div>
                  <div className="mt-2">
                    <input
                      placeholder="Enter password"
                      value={registerInput.password}
                      onChange={(e) =>
                        setRegisterInput((prevState) => ({
                          ...prevState,
                          password: e.target.value,
                        }))
                      }
                    />
                  </div>
                </div>
                <div className="modal-footer">
                  <button
                    type="button"
                    className="btn btn-secondary"
                    data-bs-dismiss="modal"
                  >
                    Close
                  </button>
                  <button
                    type="button"
                    className="btn btn-primary"
                    onClick={onSumbitRegister}
                  >
                    Submit
                  </button>
                </div>
              </div>
            </div>
          </div>

          <div
            className="modal fade"
            id="login"
            tabIndex="-1"
            role="dialog"
            aria-labelledby="loginTitle"
            aria-hidden="true"
          >
            <div className="modal-dialog modal-dialog-centered" role="document">
              <div className="modal-content">
                <div className="modal-header">
                  <h5 className="modal-title" id="loginTitle">
                    Login
                  </h5>
                </div>
                <div className="modal-body">
                  <div>
                    <input
                      placeholder="Enter username"
                      value={loginInput.username}
                      onChange={(e) =>
                        setLoginInput((prevState) => ({
                          ...prevState,
                          username: e.target.value,
                        }))
                      }
                    />
                  </div>
                  <div className="mt-2">
                    <input
                      placeholder="Enter password"
                      value={loginInput.password}
                      onChange={(e) =>
                        setLoginInput((prevState) => ({
                          ...prevState,
                          password: e.target.value,
                        }))
                      }
                    />
                  </div>
                </div>
                <div className="modal-footer">
                  <button
                    type="button"
                    className="btn btn-secondary"
                    data-bs-dismiss="modal"
                  >
                    Close
                  </button>
                  <button
                    type="button"
                    className="btn btn-primary"
                    onClick={onSumbitLogin}
                  >
                    Login
                  </button>
                </div>
              </div>
            </div>
          </div>

        </div>
      ) : ( //Subscriber Menu
        <div className="flex">
          <div className="navbar navbar-expand-lg navbar-dark bg-primary">
            <Link href="/dashboard">
              <a className="ms-5">
                <h2>Marketplace</h2>
              </a>
            </Link>
            <div className="container">
              <button
                className="navbar-toggler"
                type="button"
                data-bs-toggle="collapse"
                data-bs-target="#navmenu"
              >
                <span className="navbar-toggler-icon" />
              </button>
              <div className="collapse navbar-collapse justify-content-center align-content-center">
                <ul className="navbar-nav" id="navmenu">
                  <li className="shopping-cart-button nav-item">
                    <Link href="/shopping-cart">
                      <a className="nav-link ms-4">Shopping Cart</a>
                    </Link>
                  </li>
                  <li className="open-new-store-button nav-item">
                    <Link href="/open-new-store">
                      <a className="nav-link ms-4">Open New Store</a>
                    </Link>
                  </li>
                  <li className="store-management-button nav-item">
                    <Link href="/stores">
                      <a className="nav-link ms-4">Stores</a>
                    </Link>
                  </li>
                  <li className="my-bids-button nav-item">
                    <Link href="#">
                      <a
                        className="nav-link ms-4"
                        onClick={createNotification("info", "message")}
                      >
                        My Bids
                      </a>
                    </Link>
                  </li>
                  <li className="history-button nav-item">
                    <Link href="#">
                      <a
                        className="nav-link ms-4"
                        onClick={() => {
                          setCookie("type", "admin", {
                            path: "/",
                            sameSite: true,
                          });
                          return createNotification("info", "in admin menu")();
                        }}
                      >
                        History
                      </a>
                    </Link>
                  </li>
                  <li className="notify-admins-button nav-item">
                    <Link href="/notify-admins">
                      <a className="nav-link ms-4">Notify Admins</a>
                    </Link>
                  </li>
                  <li className="notifications-button nav-item">
                    <Link href="#">
                      <a
                        className="nav-link ms-4"
                        onClick={createNotification("info", "message")}
                      >
                        Notifications
                      </a>
                    </Link>
                  </li>
                  <li className="logout-button nav-item">
                    <Link href="/login">
                      <a className="nav-link ms-4">Logout</a>
                    </Link>
                  </li>
                </ul>
              </div>
            </div>
          </div>
        </div>
      )}
    </>
  );
};

export default Menu;
