import Image from 'next/image';

import Box from '@mui/material/Box';
import Typography from '@mui/material/Typography';

import SpriteImage from '@/components/sprite-image';
import { Summoner } from '@/lib/account/types';

interface Props extends Summoner {
    height?: number;
    hideLevel?: boolean;
    levelPosition?: 'left' | 'middle' | 'right';
    width?: number;
}

const SummonerIcon = ({ height, hideLevel = false, level, levelPosition = 'right', profileIcon, width }: Props) => (
    <Box sx={{ position: 'relative' }}>
        {(width ?? 0) > profileIcon.image.w || (height ?? 0) > profileIcon.image.h ? (
            <Image src={profileIcon.image.url} alt='Profile icon' width={width} height={height} />
        ) : (
            <SpriteImage {...profileIcon.image} width={width} height={height} />
        )}
        {!hideLevel && (
            <Box
                sx={{
                    position: 'absolute',
                    bottom: 0,
                    right: levelPosition === 'left' ? 'auto' : 0,
                    left: levelPosition === 'right' ? 'auto' : 0,
                    lineHeight: 1,
                    textAlign: 'center',
                }}>
                <Typography
                    fontSize={(width ?? 0) >= 128 ? 16 : (width ?? 0) >= 48 ? 14 : 12}
                    lineHeight={1}
                    variant='caption'
                    sx={{
                        background: '#000000',
                        px: 0.25,
                    }}>
                    {(width ?? 0) > 48 && 'Level '}
                    {level}
                </Typography>
            </Box>
        )}
    </Box>
);

export default SummonerIcon;
