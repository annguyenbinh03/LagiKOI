const Loading = () => {
  return (
    <>
      <div className="d-flex justify-content-center py-5">
        <div>
          <div className="text-center py-2 text-danger">
            <div style={{fontSize:"150px"}} className="spinner-border ms-auto" aria-hidden="true"></div>
          </div>
          <div>
            <strong style={{fontSize:"30px"}} role="status">Loading...</strong>
          </div>
        </div>
      </div>
    </>
  );
};

export default Loading;
