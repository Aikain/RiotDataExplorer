import { ApiResponse, ProblemDetails } from './types';

const handleResponse = async <T>(res: Response): Promise<ApiResponse<T>> => {
    const contentType = res.headers.get('Content-Type');
    if (!res.ok) {
        return Promise.reject(
            contentType?.startsWith('application/problem+json')
                ? await res.json()
                : {
                      type: 'https://riot-data-explorer.aika.in/exceptions/ResponseNotOk',
                      title: res.statusText,
                      status: res.status,
                      detail: await res.text(),
                      instance: res.url,
                  },
        );
    }
    return contentType?.startsWith('application/json')
        ? { data: await res.json(), error: undefined }
        : res.headers.get('Content-Length') === '0'
          ? { data: null, error: undefined }
          : Promise.reject({
                type: 'https://riot-data-explorer.aika.in/exceptions/InvalidResponse',
                title: `Invalid response: Content-Type: ${contentType}`,
                status: res.status,
                detail: await res.text(),
                instance: res.url,
            });
};

const handleErrorResponse = <T>(err: Error | ProblemDetails, path: string): ApiResponse<T> => ({
    data: undefined,
    error:
        'type' in err
            ? err
            : {
                  type: 'https://riot-data-explorer.aika.in/exceptions/RequestFailed',
                  title: 'Request to API failed',
                  status: 0,
                  detail: err.message,
                  instance: path,
                  properties: err.cause ? JSON.parse(JSON.stringify(err.cause)) : null,
              },
});

const generateApi = (urlRoot: string, defaultHeaders?: HeadersInit) => ({
    get: <T>(
        url: string,
        queryParameters?: string | string[][] | Record<string, string> | URLSearchParams,
        options?: RequestInit,
    ): Promise<ApiResponse<T>> =>
        fetch(`${urlRoot}/${url}${queryParameters ? '?' + new URLSearchParams(queryParameters) : ''}`, {
            headers: defaultHeaders,
            ...options,
        })
            .then(handleResponse<T>)
            .catch((err) => handleErrorResponse<T>(err, url)),
});

export default generateApi(process.env.API_URL ?? '/api', {
    'Content-Type': 'application/json',
    Accept: 'application/json',
});
