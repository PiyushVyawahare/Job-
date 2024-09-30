import React, { useState } from "react";
import { Typography, TextField, Button, Paper, Box } from "@mui/material";
import { useNavigate } from "react-router-dom";
import axiosInstance from "../configs/axiosConfig";
const initial = { postId: "", postProfile: "", requiredExperience: 0, techStack: [], postDescription: "" };

const Create = () => {
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

  const navigate = useNavigate();
  const [form, setForm] = useState(initial);

  const handleSubmit = (e) => {
    e.preventDefault();
    axiosInstance
      .post("http://localhost:8080/jobPost", form)
      .then((resp) => {
        console.log(resp.data);
      })
      .catch((error) => {
        console.log(error);
      });
    navigate("/");
  };

  const { postId, postProfile, requiredExperience, postDescription } = form;

  const handleChange = (e) => {
    const { value, checked } = e.target;
    if (checked) {
      setForm({ ...form, techStack: [...form.techStack, value] });
    } else {
      setForm({ ...form, techStack: form.techStack.filter((tech) => tech !== value) });
    }
  };

  return (
    <Paper sx={{ padding: "1%" }} elevation={0}>
      <Typography sx={{ margin: "3% auto" }} align='center' variant='h5'>
        Create New Post
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
            value={postId}
          />
          <TextField
            type='string'
            sx={{ width: "50%", margin: "2% auto" }}
            required
            onChange={(e) => setForm({ ...form, postProfile: e.target.value })}
            label='Job-Profile'
            variant='outlined'
            value={postProfile}
          />
          <TextField
            min='0'
            type='number'
            sx={{ width: "50%", margin: "2% auto" }}
            required
            onChange={(e) => setForm({ ...form, requiredExperience: e.target.value })}
            label='Years of Experience'
            variant='outlined'
            value={requiredExperience}
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
            value={postDescription}
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

export default Create;
