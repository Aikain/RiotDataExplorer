'use server';

import api from '@/lib/api';

export const getSummoners = (q?: string) => api.get<string[]>('summoner', q ? { q } : undefined);
