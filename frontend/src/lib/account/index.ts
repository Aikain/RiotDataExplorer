'use server';

import api from '@/lib/api';

import { Account, SimpleAccount } from './types';

export const findAccounts = (q?: string) => api.get<SimpleAccount[]>('account', q ? { q } : undefined);

export const getAccount = (gameName: string, tagLine: string) => api.get<Account>(`account/${gameName}/${tagLine}`);
