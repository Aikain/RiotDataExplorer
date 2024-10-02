'use client';

import Image from 'next/image';
import { useEffect, useMemo, useState } from 'react';
import { TransitionGroup } from 'react-transition-group';

import Box from '@mui/material/Box';
import Collapse from '@mui/material/Collapse';
import Grid from '@mui/material/Grid2';
import IconButton from '@mui/material/IconButton';
import Paper from '@mui/material/Paper';
import Tooltip from '@mui/material/Tooltip';
import Typography from '@mui/material/Typography';

import BlockIcon from '@mui/icons-material/Block';
import CloseIcon from '@mui/icons-material/Close';

import AccountName from '@/components/account-name';
import SpriteImage from '@/components/sprite-image';
import { getCurrentGame } from '@/lib/account';
import { BannedChampion, CurrentGame as CurrentGameType } from '@/lib/account/types';

interface Props {
    gameName: string;
    tagLine: string;
}

const CurrentGame = ({ gameName, tagLine }: Props) => {
    const [show, setShow] = useState(true);
    const [currentGame, setCurrentGame] = useState<CurrentGameType | null>(null);

    const teams: Partial<Record<string, CurrentGameType['participants']>> = useMemo(
        () => (currentGame ? Object.groupBy(currentGame.participants, ({ teamId }) => teamId) : []),
        [currentGame],
    );
    const teamBans: Partial<Record<string, BannedChampion[]>> = useMemo(
        () =>
            currentGame && 'bannedChampions' in currentGame
                ? Object.groupBy(currentGame.bannedChampions, ({ teamId }) => teamId)
                : {},
        [currentGame],
    );

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
                            <Typography>{currentGame.queue.description}</Typography>
                            <Typography variant='caption'>
                                {new Date(currentGame.gameStartTime).toLocaleString()}
                            </Typography>
                            <Grid container direction='row' spacing={2} columnSpacing={4}>
                                {Object.entries(teams).map(([teamId, participants], teamIndex) => (
                                    <Grid key={teamId} container direction='column' size={6} spacing={0} gap={2}>
                                        <Grid container direction='column' columnSpacing={0.5}>
                                            {participants?.map(({ account, champion, ...rest }) => (
                                                <Grid
                                                    key={`${account.gameName}#${account.tagLine}`}
                                                    container
                                                    direction={teamIndex % 2 ? 'row-reverse' : 'row'}
                                                    alignItems='center'
                                                    flexWrap='nowrap'
                                                    py={0.5}>
                                                    {account.summoner && (
                                                        <SpriteImage
                                                            {...account.summoner.profileIcon.image}
                                                            width={36}
                                                            height={36}
                                                        />
                                                    )}
                                                    <Grid sx={teamIndex % 2 ? { ml: 'auto' } : { mr: 'auto' }}>
                                                        <AccountName {...account} />
                                                    </Grid>
                                                    {'perks' in rest && (
                                                        <Grid container direction='column'>
                                                            <Image
                                                                src={rest.perks.perkStyle.iconUrl}
                                                                alt={rest.perks.perkStyle.name}
                                                                width={24}
                                                                height={24}
                                                            />
                                                            <Image
                                                                src={rest.perks.perkSubStyle.iconUrl}
                                                                alt={rest.perks.perkSubStyle.name}
                                                                width={24}
                                                                height={24}
                                                            />
                                                        </Grid>
                                                    )}
                                                    <SpriteImage {...champion.image} tooltip={champion.name} />
                                                    {'summonerSpell1' in rest && (
                                                        <Grid container direction='column'>
                                                            <SpriteImage
                                                                {...rest.summonerSpell1.image}
                                                                width={24}
                                                                height={24}
                                                                tooltip={rest.summonerSpell1.name}
                                                            />
                                                            <SpriteImage
                                                                {...rest.summonerSpell2.image}
                                                                width={24}
                                                                height={24}
                                                                tooltip={rest.summonerSpell2.name}
                                                            />
                                                        </Grid>
                                                    )}
                                                </Grid>
                                            ))}
                                        </Grid>
                                        <Grid container direction={teamIndex % 2 ? 'row-reverse' : 'row'} gap={0.5}>
                                            {teamBans[teamId]?.map(({ champion, pickTurn }) => (
                                                <Tooltip key={pickTurn} title={champion.name}>
                                                    <Grid sx={{ position: 'relative', overflow: 'hidden' }}>
                                                        <SpriteImage
                                                            {...champion.image}
                                                            width={36}
                                                            height={36}
                                                            tooltip={champion.name}
                                                        />
                                                        <Box>
                                                            <BlockIcon
                                                                color='error'
                                                                sx={{
                                                                    position: 'absolute',
                                                                    top: -6,
                                                                    left: -6,
                                                                    fontSize: 48,
                                                                    opacity: 0.6,
                                                                }}
                                                            />
                                                        </Box>
                                                    </Grid>
                                                </Tooltip>
                                            ))}
                                        </Grid>
                                    </Grid>
                                ))}
                            </Grid>
                        </Grid>
                    </Collapse>
                ) : null}
            </TransitionGroup>
        </>
    );
};

export default CurrentGame;
