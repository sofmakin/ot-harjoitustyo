# Testausdokumentti
Sovellusta on testattu JUnitilla käyttäen automatisoituja yksikkö- ja integraatiotestejä.
## Yksikkö- ja integraatiotestaus
### Sovelluslogiikka
Jokaiselle snakegame.domain pakkauksen luokalle on tehty testiluokat; FoodTest, PointTest, BoardTest ja ScoresTest joihin on jokaiseen tehty
automatisoidut yksikkö- ja integraatiotestit JUnitilla.
### Tiedon tallentamiseen tarkoitettu dao-luokka
FileDao- luokan toimintaa testaa luokka FileDaoTest, jossa tiedostoon lukemisen ja tallentamisen testaamista varten on hyödynnetty
tilapäistä tiedostoa.
### Testauskattavuus
Sovelluksen testikattavuus on 89% käyttöliittymää lukuunottamatta. Rivikattavuus on 89% ja haarautumakattavuus on 100%. 
Testaamatta on jäänut mm. satunnaisen pisteen generointi sekä tilanne, jolloin tiedostoa ei ole olemassa tai luotu.

![image](https://user-images.githubusercontent.com/57106545/70852125-76842e80-1ea6-11ea-8ef3-22a38f5f0332.png)

## Järjestelmätestaus

Sovellusta on testattu Windows-ympäristössä käyttöohjeen opastamalla tavalla, ja tiedosto scores.txt on ladattu ja sijoitettu suoritushakemistoon.
