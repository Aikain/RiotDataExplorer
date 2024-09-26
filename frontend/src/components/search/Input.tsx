'use client';

import { useMemo, useState, useTransition } from 'react';

import Autocomplete from '@mui/material/Autocomplete';
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
                            console.log('test');
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
                    label='Summoner'
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
            sx={{ width: 400 }}
        />
    );
};

export default Input;
