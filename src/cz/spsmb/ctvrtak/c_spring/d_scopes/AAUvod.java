package cz.spsmb.ctvrtak.c_spring.d_scopes;

/***
 * Bean scopes:
 *   singleton      - kontejner springu vrací singleton. Nezávisle na počtu volání metody getBean().
 *   prototype      - kontejner vrací vždy novou instanci po požadavku na bean.
 *   request        - kontejner vrací vždy novou instanci s každým HTTP requestem; využití ve stavu web server.
 *   session        - kontejner vrací vždy novou instanci s každou HTTP session; využití ve stavu web server.
 *   globalSession  - kontejner vrací singleton s kačdou globální HTTP session; využití ve stavu web server.
 */
public class AAUvod {
}
