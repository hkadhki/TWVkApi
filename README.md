# Mirror Vk Api
бот цитирует присланный ему текст. Пример взаимодействия с подобным ботом см. на картинке:
![пример](https://sun9-22.userapi.com/impg/gAlXWGkwoEkm_aATNW4kmaVPSisYtQlbDoOlfA/RCrwLaGu7W0.jpg?size=603x368&quality=96&sign=1211273157fbb5666d061fe10eebb6b2&type=album)

## Настройка программы
Для запуска программы небходимо изменить параметры в application.properties

Парматеры базы данных:

```
spring.datasource.url=jdbc:postgresql://localhost:5432/postgres
spring.datasource.username=postgres
spring.datasource.password=Qazwsxedc123
spring.jpa.hibernate.ddl-auto=update
```

Параметры vk api:

```
# vk api
message.v = 5.199
message.secretKey = None
message.returnString = 3144d431
message.accessToken = dasfasfasfasfafas
```
---
### message.v - Версия vk api
---

![version](https://sun9-37.userapi.com/impg/1XxxSH4M6S469wiBK1HSBUdbPNTYvTnGhHze9g/hY6OM4qOoI8.jpg?size=611x301&quality=96&sign=8af511a85f8813c13d584a23b571de46&type=album)

---
### message.secretKey - Секретный ключ для отправки запроса (None если не исполюзуется)

---

![secretKey](https://sun9-76.userapi.com/impg/h7b6PPLwzv8CUJluKA24E5YrEBe0nRBZZynJpw/P4uDPMNp164.jpg?size=608x669&quality=96&sign=3569737edb677698478ad500176d9ec1&type=album)

--- 
### message.returnString - Cтрока которую необходимо вернуть Callback для подтверждения адреса
---
![returnString](https://sun9-61.userapi.com/impg/3S7h5Y6C5t9OVP-ZRGD9qWBgBECpoIz4Shpl9A/KsPMJ2v9PPs.jpg?size=591x372&quality=96&sign=9834e011c25df74c6c9b5d760f617ae7&type=album)

---
### message.accessToken - ключ доступа для группы
---
![accessToken](https://sun9-59.userapi.com/impg/jr0Zi_xEkfEGDoHx6a7ar1bcXcvOZ4R66BSTBw/1JZSo6fvpK0.jpg?size=627x225&quality=96&sign=a44667e2ddf4f1893d7145518e15b0cc&type=album)


---
### Для работы Callback api необходимо вписать адрес и зангузить ssl сертификат в формате .p12
---
![adres](https://sun9-66.userapi.com/impg/Z_ypz1t8a0k-fRSZ-z1Jqydaj2H2aocJOG9GRg/o01xYtnM9r8.jpg?size=618x717&quality=96&sign=eb2d9da0e3d8580ad53e5f88925a5b50&type=album)

## Порты
- По-умолчанию программа запускается на порте 8080 
- В приложении используется база данных PostgreSQL. Запускается на порте 5432.