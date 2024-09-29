export interface SimpleAccount {
    gameName: string;
    tagLine: string;
}

export interface Account extends SimpleAccount {
    summoner?: Summoner;
}

export interface Summoner {
    profileIconUrl: string;
    level: number;
}
