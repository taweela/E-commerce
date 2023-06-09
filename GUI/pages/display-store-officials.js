import Menu from "../components/menu";
import { useState, useEffect } from "react";
import api from "../components/api";
import { useCookies } from "react-cookie";
import createNotification from "../components/norification";

const DisplayStoreOfficials = () => {
  const [owners, setOwners] = useState([]);
  const [managers, setManagers] = useState([]);
  const [isLoading, setIsLoading] = useState(true);

  const [cookies, setCookie, removeCookie] = useCookies([
    "username",
    "password",
    "userId",
    "type",
    "session",
  ]);

  useEffect(() => {
    const fetchApi = async () => {
      setIsLoading(!isLoading);
      let storeID = window.location.href.split("?").pop();
      if (storeID.charAt(storeID.length - 1) === "#") {
        storeID = storeID.slice(0, -1);
      }
      await api
        .get(
          `/store/allRoles/?storeId=${storeID}&userIdRequesting=${cookies.userId}`,
          {
            headers: {
              Authorization: cookies.session,
            },
          }
        )
        .then((res) => {
          const { data } = res;
          if (data.success) {
            let owners = data.value.owners.slice(1, -1).split(",");
            let managers = data.value.managers.slice(1, -1).split(",");
            setOwners(owners);
            setManagers(managers);
            createNotification(
              "success",
              "Displaying all user's purchases successfully"
            )();
          } else {
            createNotification("error", data.reason)();
          }
        })
        .catch((err) => console.log(err));
    };
    fetchApi();
  }, []);

  return (
    <>
      <Menu />
      <div className="text-center m-5">
        <h3>
          Display Store Officials in {window.location.href.split("?").pop()}
        </h3>
      </div>
      <div className="container d-flex justify-content-center">
        <div className="row">
          <div className="col-12 mb-4">
            <h4>
              <u>Store Owners:</u>
            </h4>
            {owners.map((owner) => {
              return (
                <li className=" list-group-item m-1">
                  <p>{owner}</p>
                </li>
              );
            })}
          </div>
          <div className="col-12">
            <h4>
              <u>Store Managers:</u>
            </h4>
            {managers.map((man) => {
              return (
                <li className=" list-group-item m-1">
                  <p>{man}</p>
                </li>
              );
            })}
          </div>
        </div>
      </div>
    </>
  );
};

export default DisplayStoreOfficials;
