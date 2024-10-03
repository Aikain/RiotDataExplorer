'use client';

import { useEffect, useState } from 'react';
import { TransitionGroup } from 'react-transition-group';

import Collapse from '@mui/material/Collapse';
import Grid from '@mui/material/Grid2';
import IconButton from '@mui/material/IconButton';
import Paper from '@mui/material/Paper';

import CloseIcon from '@mui/icons-material/Close';

import { getCurrentGame } from '@/lib/account';
import { CurrentGame as CurrentGameType } from '@/lib/account/types';

import LolGame from './lol-game';
import TftGame from './tft-game';

interface Props {
    gameName: string;
    tagLine: string;
}

const CurrentGame = ({ gameName, tagLine }: Props) => {
    const [show, setShow] = useState(true);
    const [currentGame, setCurrentGame] = useState<CurrentGameType | null>(null);

    useEffect(() => {
        getCurrentGame(gameName, tagLine).then(({ data }) => data && setCurrentGame(data));
    }, [gameName, tagLine]);

    const toggleVisibility = () => setShow((oldValue) => !oldValue);

    return (
        <>
            <TransitionGroup>
                {show && currentGame ? (
                    <Collapse timeout={{ enter: 1500, exit: 500 }}>
                        <Grid
                            component={Paper}
                            elevation={6}
                            sx={{ position: 'relative', p: 2, width: 800, willChange: 'transform' }}>
                            <IconButton
                                aria-label='close'
                                onClick={toggleVisibility}
                                sx={(theme) => ({
                                    position: 'absolute',
                                    right: 8,
                                    top: 8,
                                    color: theme.palette.grey[500],
                                })}>
                                <CloseIcon />
                            </IconButton>
                            {currentGame['@type'] === 'LOL' ? (
                                <LolGame {...currentGame} />
                            ) : currentGame['@type'] === 'TFT' ? (
                                <TftGame {...currentGame} />
                            ) : (
                                <span>unknown</span>
                            )}
                        </Grid>
                    </Collapse>
                ) : null}
            </TransitionGroup>
        </>
    );
};

export default CurrentGame;
