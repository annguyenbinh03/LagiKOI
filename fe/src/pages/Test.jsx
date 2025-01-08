import { useState } from "react";
import FilterDropdown  from "../components/FilterDropdown";
import UploadImage from "../components/UploadImage";


const hehee = [
  {
    value: "hehheeh"
  },
  {
    value: "abc"
  },
  {
    value: "hehe"
  },
  {
    value: "aaaa"
  },
  {
    value: "nnnn"
  },
  {
    value: "bbb"
  } ,
   {
    value: "uuuu"
  },
  {
    value: "agg"
  }
]

const Test = () => {
  const [selectedItem, setSelectedItem] = useState(null);

  const logSelectedItemButton = () =>{
    console.log(selectedItem);
  }
  return (
    <div className="my-5 py-5">
      {/* //<UploadImage /> */}
      <div className="container">
        <div className="row d-flex justify-content-center">
          <div className="col-md-3 px-3">
              <FilterDropdown selectedItems={selectedItem} setSelectedItem={setSelectedItem} placeHolder={"Select for fish"} items={hehee} />
          </div>
          <div className="col-md-3">
            <input className="w-100 py-1 ps-2" type="text" placeholder="Tìm theo giới tính"/>
          </div>
          <div className="col-md-3">
            <input className="w-100 py-1 ps-2" type="text" placeholder="Tìm theo chủng loại"/>
          </div>
          <div className="col-md-3">
            <input className="w-100 py-1 ps-2" type="text" placeholder="Tìm theo trang trại"/>
          </div>
          <div className="col-md-3">
            <button onClick={logSelectedItemButton} >Log selected Item</button>
          </div>
        </div>
        <div className="row">
          heheheheh
        </div>
      </div>
    </div>
  );
};

export default Test;
