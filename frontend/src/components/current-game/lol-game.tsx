import Image from 'next/image';
import { useMemo } from 'react';

import Box from '@mui/material/Box';
import Grid from '@mui/material/Grid2';
import Tooltip from '@mui/material/Tooltip';
import Typography from '@mui/material/Typography';

import BlockIcon from '@mui/icons-material/Block';

import AccountName from '@/components/account-name';
import SpriteImage from '@/components/sprite-image';
import SummonerIcon from '@/components/summoner-icon';
import { BannedChampion, CurrentLolGame } from '@/lib/account/types';

const LolGame = ({ bannedChampions, gameStartTime, participants, queue }: CurrentLolGame) => {
    const teams: Partial<Record<string, CurrentLolGame['participants']>> = useMemo(
        () => Object.groupBy(participants, ({ teamId }) => teamId),
        [participants],
    );
    const teamBans: Partial<Record<string, BannedChampion[]>> = useMemo(
        () => Object.groupBy(bannedChampions, ({ teamId }) => teamId),
        [bannedChampions],
    );

    return (
        <>
            <Typography>{queue.description}</Typography>
            <Typography variant='caption'>{new Date(gameStartTime).toLocaleString()}</Typography>
            <Grid container direction='row' spacing={2} columnSpacing={4}>
                {Object.entries(teams).map(([teamId, participants], teamIndex) => (
                    <Grid key={teamId} container direction='column' size={6} spacing={0} gap={2}>
                        <Grid container direction='column' columnSpacing={0.5}>
                            {participants?.map(({ account, champion, perks, summonerSpell1, summonerSpell2 }) => (
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
                                    <Grid container direction='column'>
                                        <Tooltip title={perks.perkStyle.name}>
                                            <Image
                                                src={perks.perkStyle.iconUrl}
                                                alt={perks.perkStyle.name}
                                                width={24}
                                                height={24}
                                            />
                                        </Tooltip>
                                        <Tooltip title={perks.perkSubStyle.name}>
                                            <Image
                                                src={perks.perkSubStyle.iconUrl}
                                                alt={perks.perkSubStyle.name}
                                                width={24}
                                                height={24}
                                            />
                                        </Tooltip>
                                    </Grid>
                                    <SpriteImage {...champion.image} tooltip={champion.name} />
                                    <Grid container direction='column'>
                                        <SpriteImage
                                            {...summonerSpell1.image}
                                            width={24}
                                            height={24}
                                            tooltip={summonerSpell1.name}
                                        />
                                        <SpriteImage
                                            {...summonerSpell2.image}
                                            width={24}
                                            height={24}
                                            tooltip={summonerSpell2.name}
                                        />
                                    </Grid>
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
        </>
    );
};

export default LolGame;
