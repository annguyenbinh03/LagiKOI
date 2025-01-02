import { useState } from "react";
import { Bounce } from "react-toastify";
import { toast } from "react-toastify/unstyled";

import useCloudinaryUpload from "../hooks/useCloudinaryUpload";

const UploadImage = () => {
  const { loading, error, uploadedImageUrl, handleCloudinaryUpload } =
    useCloudinaryUpload();
  const [file, setFile] = useState(null);

  const handleFileChange = (event) => {
    const selectedFile = event.target.files[0];
    setFile(selectedFile);
  };

  const handleUploadClick = async () => {
    if (file) {
       await handleCloudinaryUpload(file);
       console.log(uploadedImageUrl);
    } else {
      toast.error("No file selected", {
        position: "top-right",
        autoClose: 5000,
        hideProgressBar: false,
        closeOnClick: true,
        pauseOnHover: true,
        draggable: true,
        progress: undefined,
        theme: "light",
        transition: Bounce,
      });
    }
  };

  return (
    <div className="file-upload">
      <div className="upload-container">
        {loading ? (
          <div>Loading...</div>
        ) : (
          <>
            <div className="upload-icon">
              <i
                style={{ fontSize: "100px" }}
                className="bi bi-cloud-arrow-up-fill"
              ></i>
            </div>
            <input
              type="file"
              className="file-input"
              onChange={handleFileChange}
            />
            <button onClick={handleUploadClick}>Upload</button>
          </>
        )}
        {error && <div className="error">{error}</div>}
        {uploadedImageUrl && (
          <div>
            Image uploaded successfully:{" "}
            <img
              src={uploadedImageUrl}
              alt="image"
            />
          </div>
        )}
      </div>
    </div>
  );
};

export default UploadImage;
