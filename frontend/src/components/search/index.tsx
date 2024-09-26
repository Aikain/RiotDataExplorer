import Box from '@mui/material/Box';
import Grid from '@mui/material/Grid2';

import Input from './Input';

const Search = () => (
    <Box>
        <Grid container justifyContent='center' sx={{ mt: '20vh' }}>
            <Input />
        </Grid>
    </Box>
);

export default Search;
