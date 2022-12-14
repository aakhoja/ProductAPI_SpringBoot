import * as React from 'react';
import Box from '@mui/material/Box';
import TextField from '@mui/material/TextField';
import { Container , Paper} from '@mui/material';
import Button from '@mui/material/Button';
import { useEffect, useState } from "react";
import { Pets } from '@mui/icons-material';

export default function Product() {
    const titleBackground = {padding:'50px 20px', width:800,margin:'20px auto'}
    const[pName,setPName] = useState('');
    const[pSku, setSku] = useState('');
    const[pQuantity,setQuantity] = useState('');
    const[pPrice,setPrice] = useState('');

    const handleClick = (e) => {
        e.preventDefault()
        const product = {pName,pSku,pQuantity,pPrice}
        console.log(product)

        fetch("http://localhost:8080/api/v1/product",{
            method:"POST",
            headers:{"Content-Type":"application/json" },
            body:JSON.stringify(product)}
            
        ).then(() => {
            console.log("New product has been added")
        })
    } 

  return (

    <Container>
    <Paper elevation={3} style={titleBackground}>
            <h1 style={titleBackground}> Add a Product </h1>
        <Box
          component="form"
          sx={{
            
            '& > :not(style)': { m: 1, width: '25ch' },
          }}
          noValidate
          autoComplete="off"
        >
              <TextField id="outlined-basic" label="ProductName" variant="outlined"
              value={pName}
              onChange={(e) => setPName(e.target.value)} />
              <TextField id="filled-basic" label="ProductQuantity" variant="filled"
              value={pQuantity}
              onChange={(e) => setQuantity(e.target.value)} />
              <TextField id="standard-basic" label="ProductSKU" variant="standard"
              value={pSku}
              onChange={(e) => setSku(e.target.value)} />
              <TextField id="standard-basic" label="ProductPrice" variant="standard"
                            value={pPrice}
                            onChange={(e) => setPrice(e.target.value)} />
        </Box>
    <Button variant="outlined" onClick={handleClick}>Add Product </Button>
    </Paper>
    </Container>
  );
}
