export interface ProblemDetails {
    type: string;
    status: number;
    title: string;
    detail: string;
    instance: string;
    properties?: string;
}

export type ApiResponse<T> = { data: T; error: undefined } | { data: undefined; error: ProblemDetails };
