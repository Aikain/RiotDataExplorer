import Link from 'next/link';

import AppBar from '@mui/material/AppBar';
import Button from '@mui/material/Button';
import Container from '@mui/material/Container';
import Toolbar from '@mui/material/Toolbar';

const Header = () => (
    <AppBar component='nav'>
        <Container maxWidth='lg'>
            <Toolbar>
                <Button component={Link} href='/' variant='text'>
                    Home
                </Button>
                <Button component={Link} href='/lol/' variant='text' disabled>
                    LoL
                </Button>
                <Button component={Link} href='/tft/' variant='text' disabled>
                    TFT
                </Button>
                <Button component={Link} href='/valorant/' variant='text' disabled>
                    Valorant
                </Button>
            </Toolbar>
        </Container>
    </AppBar>
);

export default Header;
