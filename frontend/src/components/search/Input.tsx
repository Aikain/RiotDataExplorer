'use client';

import Link from 'next/link';
import { useMemo, useState, useTransition } from 'react';

import Autocomplete from '@mui/material/Autocomplete';
import Box from '@mui/material/Box';
import CircularProgress from '@mui/material/CircularProgress';
import TextField from '@mui/material/TextField';
import Typography from '@mui/material/Typography';
import { debounce } from '@mui/material/utils';

import { findAccounts } from '@/lib/account';
import { SimpleAccount } from '@/lib/account/types';
import { ProblemDetails } from '@/lib/api/types';

const Input = () => {
    const [accounts, setAccounts] = useState<SimpleAccount[]>([]);
    const [error, setError] = useState<ProblemDetails | null>(null);
    const [isPending, startTransition] = useTransition();

    const fetchPlayers = useMemo(
        () =>
            debounce(
                (q: string) =>
                    startTransition(async () =>
                        findAccounts(q).then(({ data, error }) => {
                            if (data) {
                                setAccounts(data);
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
            getOptionLabel={(option) => `${option.gameName}#${option.tagLine}`}
            options={accounts}
            renderInput={(params) => (
                <TextField
                    {...params}
                    label='GameName#TAG'
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
                        href={`/account/${encodeURIComponent(option.gameName)}-${option.tagLine}`}
                        sx={{ width: '100%', py: 0.75, px: 1.75, textDecoration: 'none', color: 'inherit' }}>
                        {option.gameName}#{option.tagLine}
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
