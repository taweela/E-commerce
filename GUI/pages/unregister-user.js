import Menu from "../components/menu";
import { useState } from "react";
import createNotification from "../components/norification";
import { useRouter } from "next/router";
import api from "../components/api";
import { useCookies } from "react-cookie";

const UnregisterUser = () => {
  const router = useRouter();
  const [username, setUsername] = useState("");
  const [cookies, setCookie, removeCookie] = useCookies([
    "username",
    "password",
    "userId",
    "type",
    "session",
  ]);
  const onUnregistered = async (e) => {
    e.preventDefault();
    if (username !== "") {
      return await api
        .post(
          `/users/delete/?isDeleting=${cookies.username}&whosBeingDeleted=${username}`,
          null,
          {
            headers: {
              Authorization: cookies.session,
            },
          }
        )
        .then((res) => {
          const { data } = res;
          if (data.success) {
            createNotification(
              "success",
              "Unregistered user successfully",
              () => router.push("/dashboard")
            )();
          } else {
            createNotification("error", data.reason)();
          }
        })
        .catch((err) => console.log(err));
    } else {
      createNotification(
        "error",
        "username was cannot be empty, please try again"
      )();
    }
  };

  return (
    <>
      <Menu />
      <div className="text-center my-5">
        <h3>Unregister user</h3>
      </div>

      <div className="container d-flex justify-content-center">
        <div className="list-group">
          <div className="text-center">
            <h5>Note: you can unregister a user which isn't owner/manager!</h5>
          </div>
          <div className="my-3">
            <input
              className="form-control"
              type="search"
              placeholder="Enter username"
              aria-label="Search"
              onChange={(e) => setUsername(e.target.value)}
            />
          </div>

          <div className="d-flex justify-content-center">
            <button className="btn btn-primary" onClick={onUnregistered}>
              Unregister user
            </button>
          </div>
        </div>
      </div>
    </>
  );
};

export default UnregisterUser;
