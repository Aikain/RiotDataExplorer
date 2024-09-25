import type { Metadata } from 'next';
import { Roboto } from 'next/font/google';
import { ReactNode } from 'react';

import { CssBaseline } from '@mui/material';
import { AppRouterCacheProvider } from '@mui/material-nextjs/v14-appRouter';

import { ThemeProvider } from '@mui/material/styles';

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
    <html lang='en'>
        <body className={roboto.variable}>
            <AppRouterCacheProvider>
                <ThemeProvider theme={theme}>
                    <CssBaseline />
                    {children}
                </ThemeProvider>
            </AppRouterCacheProvider>
        </body>
    </html>
);

export default RootLayout;
