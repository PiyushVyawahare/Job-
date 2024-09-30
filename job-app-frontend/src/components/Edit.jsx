import React, { useEffect, useState } from "react";
import { Typography, TextField, Button, Paper, Box } from "@mui/material";
import { useLocation, useNavigate } from "react-router-dom";
import axiosInstance from "../configs/axiosConfig";

const initial = {
  postId: "",
  postProfile: "",
  requiredExperience: 0,
  techStack: [],
  postDescription: "",
};

const Edit = () => {
  const location = useLocation();
  const navigate = useNavigate();
  const [form, setForm] = useState(initial);
  const [currId] = useState(location.state.id);

  useEffect(() => {
    const fetchInitialPosts = async (id) => {
      const response = await axiosInstance.get(`http://localhost:8080/jobPost/${id}`);
      console.log(response.data);
      setForm(response.data);
    };
    fetchInitialPosts(currId);
  }, [currId]);

  const handleSubmit = (e) => {
    e.preventDefault();
    axiosInstance
      .put("http://localhost:8080/jobPost", form)
      .then((resp) => {
        console.log(resp.data);
      })
      .catch((error) => {
        console.log(error);
      });
    navigate("/");
  };

  const handleChange = (e) => {
    const { value, checked } = e.target;
    if (checked) {
      setForm({ ...form, techStack: [...form.techStack, value] });
    } else {
      setForm({ ...form, techStack: form.techStack.filter((tech) => tech !== value) });
    }
  };

  const skillSet = [
    {
      name: "Javascript",
    },
    {
      name: "Java",
    },
    {
      name: "Python",
    },
    {
      name: "Django",
    },
    {
      name: "Rust",
    },
  ];

  return (
    <Paper sx={{ padding: "1%" }} elevation={0}>
      <Typography sx={{ margin: "3% auto" }} align='center' variant='h5'>
        Edit New Post
      </Typography>
      <form autoComplete='off' noValidate onSubmit={handleSubmit}>
        <Box
          sx={{
            display: "flex",
            justifyContent: "center",
            flexDirection: "column",
          }}
        >
          <TextField
            min='0'
            type='number'
            sx={{ width: "50%", margin: "2% auto" }}
            onChange={(e) => setForm({ ...form, postId: e.target.value })}
            label='Enter your Post ID'
            variant='outlined'
            value={form.postId}
          />
          <TextField
            type='string'
            sx={{ width: "50%", margin: "2% auto" }}
            required
            onChange={(e) => setForm({ ...form, postProfile: e.target.value })}
            label='Job-Profile'
            variant='outlined'
            value={form.postProfile}
          />
          <TextField
            min='0'
            type='number'
            sx={{ width: "50%", margin: "2% auto" }}
            required
            onChange={(e) => setForm({ ...form, requiredExperience: e.target.value })}
            label='Years of Experience'
            variant='outlined'
            value={form.requiredExperience}
          />
          <TextField
            type='string'
            sx={{ width: "50%", margin: "2% auto" }}
            required
            multiline
            rows={4}
            onChange={(e) => setForm({ ...form, postDescription: e.target.value })}
            label='Job-desc'
            variant='outlined'
            value={form.postDescription}
          />
          <Box sx={{ margin: "1% auto" }}>
            <h3>Please mention required skills</h3>
            <ul>
              {skillSet.map(({ name }, index) => {
                return (
                  <li key={index}>
                    <div>
                      <div>
                        <input
                          type='checkbox'
                          id={`custom-checkbox-${index}`}
                          name={name}
                          value={name}
                          onChange={handleChange}
                          checked={form.techStack.includes(name)}
                        />
                        <label htmlFor={`custom-checkbox-${index}`}>{name}</label>
                      </div>
                    </div>
                  </li>
                );
              })}
            </ul>
          </Box>
          <Button sx={{ width: "50%", margin: "2% auto" }} variant='contained' type='submit'>
            Submit
          </Button>
        </Box>
      </form>
    </Paper>
  );
};

export default Edit;
