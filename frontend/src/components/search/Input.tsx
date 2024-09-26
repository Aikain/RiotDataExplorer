'use client';

import Link from 'next/link';
import { useMemo, useState, useTransition } from 'react';

import { Typography } from '@mui/material';

import Autocomplete from '@mui/material/Autocomplete';
import Box from '@mui/material/Box';
import CircularProgress from '@mui/material/CircularProgress';
import TextField from '@mui/material/TextField';
import { debounce } from '@mui/material/utils';

import { ProblemDetails } from '@/lib/api/types';
import { getSummoners } from '@/lib/summoner';

const Input = () => {
    const [players, setPlayers] = useState<string[]>([]);
    const [error, setError] = useState<ProblemDetails | null>(null);
    const [isPending, startTransition] = useTransition();

    const fetchPlayers = useMemo(
        () =>
            debounce(
                (q: string) =>
                    startTransition(async () =>
                        getSummoners(q).then(({ data, error }) => {
                            if (data) {
                                setPlayers(data);
                                setError(null);
                            } else {
                                setError(error);
                                console.error(error);
                            }
                        }),
                    ),
                400,
            ),
        [],
    );

    const handleInputChange = (_: unknown, newValue: string) => fetchPlayers(newValue);

    return (
        <Autocomplete
            filterOptions={(x) => x}
            onInputChange={handleInputChange}
            options={players}
            renderInput={(params) => (
                <TextField
                    {...params}
                    label='Summoner#TAG'
                    slotProps={{
                        input: {
                            ...params.InputProps,
                            endAdornment: (
                                <>
                                    {isPending ? <CircularProgress color='inherit' size={20} /> : null}
                                    {params.InputProps.endAdornment}
                                </>
                            ),
                        },
                    }}
                    helperText={error?.title}
                    error={!!error}
                />
            )}
            renderOption={({ key, ...rest }, option) => (
                <Box component='li' key={key} {...rest}>
                    <Typography
                        component={Link}
                        href={`/summoner/${encodeURIComponent(
                            option.indexOf('#') !== -1
                                ? `${option.substring(0, option.lastIndexOf('#'))}-${option.substring(option.lastIndexOf('#') + 1)}`
                                : option,
                        )}`}
                        sx={{ width: '100%', py: 0.75, px: 1.75, textDecoration: 'none', color: 'inherit' }}>
                        {option}
                    </Typography>
                </Box>
            )}
            slotProps={{
                popper: {
                    sx: { [`& li.MuiAutocomplete-option`]: { p: 0 } },
                },
            }}
            sx={{ width: 400, [`& .MuiAutocomplete-option`]: { p: 0 } }}
        />
    );
};

export default Input;
