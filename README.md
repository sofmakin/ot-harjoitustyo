# Snake Game

Sovellus on matopeli, jossa pelaajan on tarkoitus kasvattaa matoa. Matoa liikutetaan nuolinäppäimillä.
## Dokumentaatio
* [työaikakirjanpito](https://github.com/sofmakin/ot-harjoitustyo/blob/master/dokumentointi/tyoaikakirjanpito.md)
* [arkkitehtuuri](https://github.com/sofmakin/ot-harjoitustyo/blob/master/dokumentointi/arkkitehtuuri.md)
* [vaatimusmäärittely](https://github.com/sofmakin/ot-harjoitustyo/blob/master/dokumentointi/alustavaMaarittelydokumentti.md)
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
