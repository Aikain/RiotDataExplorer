import { Image, SimpleChampion, SummonerSpell } from '@/lib/api/types';

export interface SimpleAccount {
    gameName: string;
    tagLine: string;
}

export interface Account extends SimpleAccount {
    summoner?: Summoner;
}

export interface Summoner {
    profileIcon: ProfileIcon;
    level: number;
}

interface ProfileIcon {
    id: string;
    image: Image;
}

interface AbstractCurrentGame<Q, P> {
    gameId: number;
    platformId: string; // TODO: enum
    gameMode: GameMode;
    gameType: GameType;
    queue: Q;
    map: GameMap;
    gameStartTime: string;
    participants: P[];
}

interface GameMode {
    gameMode: string; // TODO: enum
    description: string;
}

interface GameType {
    gameType: string; // TODO: enum
    description: string;
}

interface GameMap {
    mapName: string;
    notes: string;
    minimapUrl: string;
}

interface Queue {
    map: GameMap['mapName'];
    description: string;
}

interface Participant {
    account: Account;
    bot: boolean;
    teamId: number;
    champion: SimpleChampion;
}

export interface BannedChampion {
    pickTurn: number;
    champion: SimpleChampion;
    teamId: number;
}

interface LolParticipant extends Participant {
    summonerSpell1: SummonerSpell;
    summonerSpell2: SummonerSpell;
    perks: {
        perks: {
            name: string;
            iconUrl: string;
        }[];
        perkStyle: {
            name: string;
            iconUrl: string;
        };
        perkSubStyle: {
            name: string;
            iconUrl: string;
        };
    };
}

type TftParticipant = Participant;

interface CurrentLolGame extends AbstractCurrentGame<Queue, LolParticipant> {
    bannedChampions: BannedChampion[];
}

type CurrentTftGame = AbstractCurrentGame<Queue, TftParticipant>;

export type CurrentGame = CurrentLolGame | CurrentTftGame;
