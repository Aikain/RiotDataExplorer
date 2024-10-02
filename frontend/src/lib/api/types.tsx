export interface ProblemDetails {
    type: string;
    status: number;
    title: string;
    detail: string;
    instance: string;
    properties?: string;
}

export type ApiResponse<T> = { data: T; error: undefined } | { data: undefined; error: ProblemDetails };

// General types

export interface Image {
    x: number;
    y: number;
    w: number;
    h: number;
    url: string;
    spriteUrl: string;
}

export interface SimpleChampion {
    name: string;
    image: Image;
}

export interface SummonerSpell {
    name: string;
    image: Image;
}
