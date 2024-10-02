import Link from 'next/link';

import Box from '@mui/material/Box';
import Typography from '@mui/material/Typography';

import { Account } from '@/lib/account/types';

const AccountName = ({ gameName, tagLine }: Account) => (
    <Box
        component={Link}
        href={`/account/${encodeURIComponent(gameName)}-${tagLine}`}
        sx={{ textDecoration: 'none', color: 'inherit' }}>
        <Typography display='inline'>{gameName}</Typography>
        <Typography display='inline' color='grey'>
            #{tagLine}
        </Typography>
    </Box>
);

export default AccountName;
