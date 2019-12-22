# Snake Game

Sovellus on matopeli, jossa pelaajan on tarkoitus kasvattaa matoa syömällä omenoita,jolloin pelaajan pisteet kasvavat. Matoa liikutetaan nuolinäppäimillä.
## Dokumentaatio
* [työaikakirjanpito](https://github.com/sofmakin/ot-harjoitustyo/blob/master/dokumentointi/tyoaikakirjanpito.md)
* [arkkitehtuuri](https://github.com/sofmakin/ot-harjoitustyo/blob/master/dokumentointi/arkkitehtuuri.md)
* [vaatimusmäärittely](https://github.com/sofmakin/ot-harjoitustyo/blob/master/dokumentointi/alustavaMaarittelydokumentti.md)
* [käyttöohje](https://github.com/sofmakin/ot-harjoitustyo/blob/master/dokumentointi/kayttoohje.md)
* [testausdokumentti](https://github.com/sofmakin/ot-harjoitustyo/blob/master/dokumentointi/testaus.md)
## Releaset
[final release](https://github.com/sofmakin/ot-harjoitustyo/releases/tag/final)
## Komentoivitoiminnot
### Testaus
Testit saadaan suoritettua komennolla
``` 
mvn test
```
ja testiraportti
```
mvn test jacoco:report
```
### Checkstyle

Checkstylen määrittämät tarkastukset suoritetaan komennolla
```
mvn jxr:jxr checkstyle:checkstyle
```
### Suoritettavan jarin generointi
Komento
```
mvn package
```
generoi hakemistoon target suoritettavan jar-tiedoston.
### JavaDocin generointi
JavaDoc saadaan generoitua komennolla 
```
mvn javadoc:javadoc
```
