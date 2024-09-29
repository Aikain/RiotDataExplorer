import Image from 'next/image';
import { notFound } from 'next/navigation';

import { parseRiotID } from '@/utils/parse';

import Grid from '@mui/material/Grid2';

import { getAccount } from '@/lib/account';

interface Props {
    params: { riotId: string };
}

const Page = async ({ params: { riotId } }: Props) => {
    const { gameName, tagLine } = parseRiotID(decodeURIComponent(riotId));

    if (!tagLine) notFound();

    const { data: account, error } = await getAccount(gameName, tagLine);

    if (error) notFound();

    return (
        <Grid container flexDirection='column' alignContent='center' alignItems='center' spacing={2} sx={{ p: 2 }}>
            <span>
                {gameName}#{tagLine}
            </span>
            {account.summoner && (
                <>
                    <Image src={account.summoner.profileIconUrl} alt='Profile icon' width={128} height={128} />
                    <span>Level: {account.summoner.level}</span>
                </>
            )}
        </Grid>
    );
};

export default Page;
