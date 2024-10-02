import Box from '@mui/material/Box';
import Typography from '@mui/material/Typography';

// TODO: replace "This software" with site name
const Footer = () => (
    <Box component='footer' sx={{ m: 0, mt: 'auto', px: 2, py: 1, textAlign: 'center' }}>
        <Typography variant='caption'>
            {"This software isn't endorsed by Riot Games and doesn't reflect the views or opinions of Riot Games or " +
                'anyone officially involved in producing or managing Riot Games properties. Riot Games, and all ' +
                'associated properties are trademarks or registered trademarks of Riot Games, Inc.'}
        </Typography>
    </Box>
);

export default Footer;
