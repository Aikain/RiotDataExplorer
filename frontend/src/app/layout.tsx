import type { Metadata } from 'next';
import { Roboto } from 'next/font/google';
import { ReactNode } from 'react';

import { AppRouterCacheProvider } from '@mui/material-nextjs/v14-appRouter';

import Box from '@mui/material/Box';
import CssBaseline from '@mui/material/CssBaseline';
import Toolbar from '@mui/material/Toolbar';
import { ThemeProvider } from '@mui/material/styles';

import Footer from '@/components/footer';
import Header from '@/components/header';

import theme from '../theme';

export const metadata: Metadata = {
    title: 'Riot Data Explorer',
    description: 'Welcome to explore player data from different Riot Games games!',
};

const roboto = Roboto({
    weight: ['300', '400', '500', '700'],
    subsets: ['latin'],
    display: 'swap',
    variable: '--font-roboto',
});

const RootLayout = ({ children }: Readonly<{ children: ReactNode }>) => (
    <html lang='en' style={{ overflowX: 'hidden', marginRight: 'calc(-1 * (100vw - 100%)' }}>
        <body className={roboto.variable} style={{ minHeight: '100vh', display: 'flex', flexDirection: 'column' }}>
            <AppRouterCacheProvider>
                <ThemeProvider theme={theme}>
                    <CssBaseline />

                    <Header />
                    <Box component='main'>
                        <Toolbar />
                        {children}
                    </Box>
                    <Footer />
                </ThemeProvider>
            </AppRouterCacheProvider>
        </body>
    </html>
);

export default RootLayout;
