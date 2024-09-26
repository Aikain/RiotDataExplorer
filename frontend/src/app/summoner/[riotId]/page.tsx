import Image from 'next/image';
import { notFound } from 'next/navigation';

import { parseRiotID } from '@/utils/parse';

import Grid from '@mui/material/Grid2';

import { getSummoner } from '@/lib/summoner';

interface Props {
    params: { riotId: string };
}

const Page = async ({ params: { riotId } }: Props) => {
    const { gameName, tagLine } = parseRiotID(decodeURIComponent(riotId));

    if (!tagLine) notFound();

    const { data: summoner, error } = await getSummoner(gameName, tagLine);

    if (error) notFound();

    return (
        <Grid container flexDirection='column' alignContent='center' alignItems='center' spacing={2} sx={{ p: 2 }}>
            <span>
                {gameName}#{tagLine}
            </span>
            <Image src={summoner.profileIcon} alt='Profile icon' width={128} height={128} />
            <span>Level: {summoner.summonerLevel}</span>
        </Grid>
    );
};

export default Page;
