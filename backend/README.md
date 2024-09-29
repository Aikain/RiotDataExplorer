## Ympäristömuuttujat

| Ympäristömuuttuja    | Selite                                  | Esimerkki                                        |
|----------------------|-----------------------------------------|--------------------------------------------------|
| DATABASE_URL         | Tietokannan jdbc-osoite                 | jdbc:mariadb://localhost:3306/riot-data-explorer |
| DATABASE_USERNAME    | Tietokannan käyttäjänimi                | root                                             |
| DATABASE_PASSWORD    | Tietokannan salasana                    |                                                  |
| RIOT_API_KEY         | API avain Riot:n rajapintaan            |                                                  |
| RIOT_NEAREST_CLUSTER | Lähin clusteri (AMERICAS, ASIA. EUROPE) | EUROPE                                           |

### Vapaavalintaiset

| Ympäristömuuttuja     | Selite                     | Esimerkki |
|-----------------------|----------------------------|-----------|
| SHOW_SQL              | Tulostetaanko SQL-kyselyt? | true      |
| LOGGING_LEVEL_IN_AIKA | Logging level projektille  | TRACE     |
