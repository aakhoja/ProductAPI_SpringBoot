import * as React from 'react';
import Box from '@mui/material/Box';
import TextField from '@mui/material/TextField';
import { Container , Paper} from '@mui/material';

export default function Product() {
    const titleBackground = {padding:'50px 20px', width:600,margin:'20px auto'}
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
      <TextField id="outlined-basic" label="ProductName" variant="outlined" />
      <TextField id="filled-basic" label="ProductQuantity" variant="filled" />
      <TextField id="standard-basic" label="ProductSKU" variant="standard" />
    </Box>
    </Paper>
    </Container>
  );
}
