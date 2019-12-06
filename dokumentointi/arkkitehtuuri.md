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

Käyttöliittymä on toteutettu luokassa snakegame.ui.GameUi

## Päätoiminallisuudet

Sekvenssikaavio, pisteiden haku

![image](https://www.websequencediagrams.com/cgi-bin/cdraw?lz=CgoKVXNlci0-K0dhbWVVaTpjbGljayBzY29yZXMKAA4GLT4rRmlsZVMADwVEYW86Z2V0SGlnaAAMBVN0cmluZygpCgAWDS0-LQBJB2hpZ2gASQUAIwYASgkAaAdzdGFnZS5zZXQoAG0GU2NlbmUpAHEILT5Vc2VyOgo&s=napkin)
