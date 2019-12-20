# Arkkitehtuurikuvaus
## Rakenne

Sovelluksen pakkausrakenne on seuraavanlainen:

![image](https://user-images.githubusercontent.com/57106545/70331701-a731eb80-1848-11ea-927e-b33ec39ba9d0.png)

Pakkaus snakegame.ui sisältää graafisen käyttöliittymän, snakegame.domain sovelluslogiikan ja pakkauksessa snakegame.dao on toteuttu sovelluksen tarvittavan tiedon tallentaminen.

## Käyttöliittymä
Käyttöliittymässä on kolme näkymää

* Aloitusnäkymä
* Pelinäkymä
* Pistenäkymä

Käyttöliittymä on toteutettu luokassa snakegame.ui.GameUi.
## Sovelluslogiikka
Sovellukslogiikan luokat ovat Point, Board, Food ja Scores. Luokka Point vastaa pelialueen pisteistä, Board pelialustan muodostamisesta, Food satunnaisen ruoka-pisteen luomisesta sekä Scores pelin pisteistä. Peli luodaan näiden luokkien avulla käyttöliittymässä.

Luokkien suhdetta toisiinsa ja käyttöliittymään kuvaava kaavio:
![image](https://user-images.githubusercontent.com/57106545/71199611-f7746900-229e-11ea-8b0c-e6ecddaaedba.png)

## Tiedon tallentaminen
Tiedon tallentaminen tapahtuu pakkauksen snakegame.dao luokassa FileDao, jossa pisteet lisätään tiedostoon ja luetaan tiedostosta.
Luokassa FileDao pisteet myös järjestetään suurusjärjestykseen ja lisätään listalle joka pistenäkymässä palautetaan käyttäjän tarkasteltavaksi.
Sovellukseen on sijoitettu konfiguraatiotiedosto config.properties, jossa pistetiedoston nimi on määritelty. 
Pisteet talletetaan tiedostoon allekkain kukin piste omalle rivilleen:

```
21
19
6
```


## Päätoiminnallisuudet

Sekvenssikaavio, pisteiden haku

![image](https://www.websequencediagrams.com/cgi-bin/cdraw?lz=CgoKVXNlci0-K0dhbWVVaTpjbGljayBzY29yZXMKAA4GLT4rRmlsZVMADwVEYW86Z2V0SGlnaAAMBVN0cmluZygpCgAWDS0-LQBJB2hpZ2gASQUAIwYASgkAaAdzdGFnZS5zZXQoAG0GU2NlbmUpAHEILT5Vc2VyOgo&s=napkin)
