const AccessoryCardHighlight = ({accessory}) => {
  switch (accessory.category) {
    case "Thức ăn":
      return (
        <>
          <div>
            <strong>Khối lượng:</strong>{" "}
            {accessory.bagSize ? accessory.bagSize : ""}
          </div>
          <div>
            <strong>Kích cỡ hạt:</strong>{" "}
            {accessory.pelletSize ? accessory.pelletSize : ""}
          </div>
          <div>
            <strong>Xuất xứ:</strong> {accessory.origin ? accessory.origin : ""}
          </div>
        </>
      );
    case "Máy bơm nước":
      return (
        <>
          <div>
            <strong>Công suất:</strong>{" "}
            {accessory.power ? accessory.power + "w" : ""}
          </div>
          <div>
            <strong>Cột áp:</strong>{" "}
            {accessory.headPressure ? accessory.headPressure + "m" : ""}
          </div>
          <div>
            <strong>Lưu lượng nước:</strong>{" "}
            {accessory.flowRate ? accessory.flowRate : ""}
          </div>
        </>
      );
    case "Máy sủi oxy":
      return (
        <>
          <div>
            <strong>Công suất:</strong>{" "}
            {accessory.power ? accessory.power + "w" : ""}
          </div>
          <div>
            <strong>Số lượng đầu vòi:</strong>{" "}
            {accessory.nozzleCount ? accessory.nozzleCount : ""}
          </div>
          <div>
            <strong>Lưu lượng khí:</strong>{" "}
            {accessory.airflow ? accessory.airflow : ""}
          </div>
        </>
      );
  }
};

export default AccessoryCardHighlight;
