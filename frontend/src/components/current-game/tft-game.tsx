import { useMemo } from 'react';

import Grid from '@mui/material/Grid2';
import Typography from '@mui/material/Typography';

import AccountName from '@/components/account-name';
import SummonerIcon from '@/components/summoner-icon';
import { CurrentTftGame } from '@/lib/account/types';

const TftGame = ({ gameStartTime, participants, queue }: CurrentTftGame) => {
    const teams: Partial<Record<string, CurrentTftGame['participants']>> = useMemo(
        () => Object.groupBy(participants, ({ teamId }) => teamId),
        [participants],
    );

    return (
        <>
            <Typography>{queue.queueType}</Typography>
            <Typography variant='caption'>{new Date(gameStartTime).toLocaleString()}</Typography>
            <Grid container direction='row' spacing={2} columnSpacing={4}>
                {Object.entries(teams).map(([teamId, participants], teamIndex) => (
                    <Grid key={teamId} container direction='column' size={6} spacing={0} gap={2}>
                        <Grid container direction='column' columnSpacing={0.5}>
                            {participants?.map(({ account }) => (
                                <Grid
                                    key={`${account.gameName}#${account.tagLine}`}
                                    container
                                    direction={teamIndex % 2 ? 'row-reverse' : 'row'}
                                    alignItems='center'
                                    flexWrap='nowrap'
                                    py={0.5}>
                                    {account.summoner && (
                                        <SummonerIcon
                                            {...account.summoner}
                                            width={36}
                                            height={36}
                                            levelPosition={teamIndex % 2 ? 'right' : 'left'}
                                        />
                                    )}
                                    <Grid sx={teamIndex % 2 ? { ml: 'auto' } : { mr: 'auto' }}>
                                        <AccountName {...account} />
                                    </Grid>
                                </Grid>
                            ))}
                        </Grid>
                    </Grid>
                ))}
            </Grid>
        </>
    );
};

export default TftGame;
