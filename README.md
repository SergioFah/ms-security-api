# Microsoft Security Update Fetcher

### Assuntos Abordados:
- Serialização & desserialização (json <-> Java Object)
- WebClient (consumo de APIs externas)
- Front-end básico com Angular

### Objetivos

1 - Criar serviço, em Java, que consuma todos os "Microsoft Security Updates" disponíveis da API da microsoft e persistir todos os dados coletados no banco de dados PostgreSQL. ✅

2 - Criar uma Timer/Schedule que fique a cada 5 minutos atualizando os dados acima, adicionando novos updates em background.  ✅

3 - Criar uma interface visual, em angular, onde seja possível visualizar os dados adquiridos anteriormente, onde tenha a possibilidade de filtrar pelos campos de cada "Microsoft Security Updates".


- Swagger da API: https://api.msrc.microsoft.com/cvrf/v2.0/swagger/index#/
- Rota da API a ser consumida: https://api.msrc.microsoft.com/cvrf/v2.0/updates


###### Opcionais: fazer tratamento de excepções, documentar código, usar log onde achar recomendado, etc.


### Tecnologias Usadas
* Java + Spring
* Javascript + Angular
* Jsonschema2pojo (https://www.jsonschema2pojo.org/)
* LomboK
* JPA
* PostgreSQL
