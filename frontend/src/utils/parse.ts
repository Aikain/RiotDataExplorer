export const parseRiotID = (riotId: string): { gameName: string; tagLine: string | null } =>
    riotId.indexOf('-') !== -1
        ? {
              gameName: riotId.substring(0, riotId.lastIndexOf('-')),
              tagLine: riotId.substring(riotId.lastIndexOf('-') + 1),
          }
        : { gameName: riotId, tagLine: null };
