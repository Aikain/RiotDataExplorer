import Box from '@mui/material/Box';
import Tooltip from '@mui/material/Tooltip';

import { Image } from '@/lib/api/types';

interface Props extends Pick<Image, 'spriteUrl' | 'w' | 'h' | 'x' | 'y'> {
    width?: number;
    height?: number;
    tooltip?: string;
}

const SpriteImage = ({ spriteUrl, w, h, x, y, width, height, tooltip }: Props) => (
    <Tooltip title={tooltip}>
        <Box
            sx={{
                width: w,
                height: h,
                background: `url(${spriteUrl}) -${x}px -${y}px`,
                transform: `scale(${width ? width / w : 1}, ${height ? height / h : 1})`,
                mx: `${((width ?? w) - w) / 2}px`,
                my: `${((height ?? h) - h) / 2}px`,
            }}
        />
    </Tooltip>
);

export default SpriteImage;
