import React, { forwardRef, useState } from "react";
import { Dropdown, Form } from "react-bootstrap";
import style from "../assets/scss/FilterDropdown.module.scss";

const CustomMenu = forwardRef(({ children, style, className}, ref) => {
  const [filterValue, setFilterValue] = useState("");

  const handleFilterChange = (e) => {
    setFilterValue(e.target.value.toLowerCase());
  };

  const filteredChildren = React.Children.toArray(children).filter(
    (child) =>
      !filterValue || child.props.children.toLowerCase().includes(filterValue)
  );

  return (
    <div  ref={ref} style={style} className={`${className} px-2 bg-white py-1`}>
      <Form.Control
        autoFocus
        className="w-100"
        placeholder="Type to filter..."
        onChange={handleFilterChange}
        value={filterValue}
      />
      <ul className="list-unstyled mt-1 mb-0">{filteredChildren}</ul>
    </div>
  );
});

const FilterDropdown  = ({
  placeHolder,
  items,
  selectedItems,
  setSelectedItem,
}) => {
  const [isOpen, setIsOpen] = useState(false);

  const handleClickToggle = () => {
    setIsOpen(!isOpen);
  };

  return (
    <Dropdown onClick={handleClickToggle} show={isOpen} className="w-100" autoClose="outside">
      <Dropdown.Toggle  className="bg-transparent w-100 text-start overflow-hidden d-flex justify-content-between align-items-center">
        <span className={`${style.dropdown__toogle__span}`}> {selectedItems?.value || placeHolder}</span>
      </Dropdown.Toggle>

      {isOpen && (
        <Dropdown.Menu as={CustomMenu} className={`w-100 overflow-y-scroll ${style.dropdown__menu}`}>
          {items?.map((item) => (
            <Dropdown.Item
              key={item?.value}
              onClick={() => setSelectedItem(item)}
              className={`${
                item?.value === selectedItems?.value ? "active" : ""
              } ${style.dropdown__item} py-1 ps-2 fs-6`}
            >
              {item.value}
            </Dropdown.Item>
          ))}
        </Dropdown.Menu>
      )}
    </Dropdown>
  );
};

export default FilterDropdown;
