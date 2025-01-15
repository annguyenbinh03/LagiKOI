import React, { forwardRef, useState } from "react";
import { Dropdown, Form } from "react-bootstrap";
import style from "../assets/scss/FilterDropdown.module.scss";

const CustomMenu = forwardRef(({ children, style, className }, ref) => {
  const [filterValue, setFilterValue] = useState("");

  const handleFilterChange = (e) => {
    setFilterValue(e.target.value.toLowerCase());
  };

  const filteredChildren = React.Children.toArray(children).filter(
    (child) =>
      !filterValue || child.props.children.toLowerCase().includes(filterValue)
  );

  return (
    <div ref={ref} style={style} className={`${className} px-2 bg-white py-1`}>
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

const OrderDropdown = ({
  items,
  setSortBy,
  setOrder
}) => {
  const [isOpen, setIsOpen] = useState(false);
  const [selectedItem, setSelectedItem] = useState(items[0]);

  const handleClickToggle = () => {
    setIsOpen(!isOpen);
  };

  const handleOnClick = (item) =>{
    setSelectedItem(item)
    setOrder(item.order);
    setSortBy(item.sortBy);
  }

  return (
    <Dropdown
      onClick={handleClickToggle}
      show={isOpen}
      className="w-100"
      autoClose="outside"
    >
      <Dropdown.Toggle className="bg-white w-100 text-start text-secondary overflow-hidden d-flex justify-content-between align-items-center border-secondary-subtle">
        <span className={`${style.dropdown__toogle__span}`}>
          {" "}
          {selectedItem?.name}
        </span>
      </Dropdown.Toggle>

      {isOpen && (
        <Dropdown.Menu
          as={CustomMenu}
          className={`w-100 ${style.dropdown__menu}`}
        >
          {items?.map((item) => (
            <Dropdown.Item
              key={item?.name}
              onClick={() => handleOnClick(item) }
              className={`${
                item === selectedItem ? "active" : ""
              } ${style.dropdown__item} py-1 ps-2 fs-6`}
            >
              {item.name}
            </Dropdown.Item>
          ))}
        </Dropdown.Menu>
      )}
    </Dropdown>
  );
};

export default OrderDropdown;
