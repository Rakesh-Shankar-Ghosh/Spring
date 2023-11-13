import React from "react";
import { useState } from "react";
import axios from "axios";
import { useNavigate } from "react-router-dom";

const PostData = () => {
  const [name, setName] = useState("");
  const [price, setPrice] = useState(0);
  const [quantity, setQuantity] = useState(0);
  const navigate = useNavigate();

  const handlePostdata = async (e) => {
    e.preventDefault();
    const formdata = {
      name,
      price,
      quantity,
    };

    try {
      const res = await axios.post(
        `${process.env.REACT_APP_API}/create/product/`,
        formdata
      );
      if (res.data.success) {
        navigate("/getdata");
      }
      console.log(res.data.message);
    } catch (err) {
      console.log(err);
    }
  };

  return (
    <>
      <div className="text-center">
        <form onSubmit={handlePostdata}>
          <div className="input-box">
            Name:{" "}
            <input
              type="text"
              placeholder="Enter your name"
              required
              value={name}
              onChange={(e) => setName(e.target.value)}
            />
          </div>
          <div className="input-box">
            Price:{" "}
            <input
              type="number"
              placeholder="Enter your email"
              required
              value={price}
              onChange={(e) => setPrice(e.target.value)}
            />
          </div>
          <div className="input-box">
            Quantity:{" "}
            <input
              type="number"
              placeholder="Create password"
              required
              value={quantity}
              onChange={(e) => setQuantity(e.target.value)}
            />
          </div>
          <div className="input-box button">
            <input type="Submit" defaultValue="POST DATA" />
          </div>
        </form>
      </div>
    </>
  );
};

export default PostData;
