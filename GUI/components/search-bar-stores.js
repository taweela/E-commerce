import { useState } from "react";
const SearchBarStores = ({ setStoreSearch }) => {
  const [value, setValue] = useState("");
  const onChange = (e) => {
    setValue(e.target.value);
  };

  const onSearch = (e) => {
    e.preventDefault();
    setStoreSearch(value);
  };
  return (
    <div className="container">
      <nav className="navbar navbar-expand-lg bg-secondery align-items-center justify-content-center rounded-3">
        <form className="row form-inline d-flex w-50">
          <div className="main-search-bar">
            <input
              className="form-control mr-sm-2"
              type="search"
              placeholder="Search for anything"
              aria-label="Search"
              onChange={onChange}
            />
            <div>
              <button className="btn btn-primary mr-lg-3" onClick={onSearch}>
                Search
              </button>
            </div>
          </div>
        </form>
      </nav>
    </div>
  );
};

export default SearchBarStores;
