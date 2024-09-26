'use server';

import api from '@/lib/api';

import { Summoner } from './types';

export const getSummoners = (q?: string) => api.get<string[]>('summoner', q ? { q } : undefined);

export const getSummoner = (gameName: string, tagLine: string) => api.get<Summoner>(`summoner/${gameName}/${tagLine}`);
