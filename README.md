<div align="center">

# Agrotis API Test

Esse repositório se trata do teste técnico de backend para empresa [Agrotis](https://www.agrotis.com/).
O teste foi desenvolvido em Java com SpringBoot e MongoDB.

<img src="./images_agrotis_api/logo.png" width="150px">

</div>


## Descrição
O teste consiste em construir uma API para ser utilizada na construção de uma tela.
Link do protótipo (https://www.figma.com/proto/PXi5PcZWks8Z7veqA8WU30/Teste-Front-end).

## Instruções para consumir a API:

- Clone o repositório em sua máquina e instale as dependencias com o comando `mvn install`.
- Utilize o comando `mvn spring-boot:run` para iniciar aplicação.
- Aplicação utilizará a porta `8080` do localhost.
- É necessário o serviço do MongoDB funcionando em sua máquina.
- API possui as seguintes rotas:
    - POST e GET: `/property`
    - GET, PUT e DELETE: `/property/{propertyId}`
    
    - POST e GET: `/laboratory`
    - GET, PUT e DELETE: `/laboratory/{laboratoryId}`

    - POST e GET: `/register`
    - GET, PUT e DELETE: `/register/{registerId}` 

## Rotas:

### `/property`
#### Método POST:
- API permite que seja criado uma nova Property através do método POST no endpoint `/property` passando no body um json no formato:
```json
    {
        "name": "string, e não pode ser repetido com alguma propriedade já cadastrada.",
        "cnpj": "string, e não pode ser repetido com alguma propriedade já cadastrada, só pode ser numero e ter o length de 14."
    }
```
- Exemplo de retorno quando é criado com sucesso:
<img src="./images_agrotis_api/Property/property_success.jpg" width="400px">

Exemplo de retorno quando tem problema com o name e cnpj:
- Problema com conflito no nome:
<img src="./images_agrotis_api/Property/property_name_conflict.jpg" width="400px">

- Problema com conflito no cnpj:
<img src="./images_agrotis_api/Property/property_cnpj_length.jpg" width="400px">

- Problema com cnpj inválido:
<img src="./images_agrotis_api/Property/property_cnpj_conflict.jpg" width="400px">

#### Método GET:
- API permite que seja possivel listar todas as propriedades cadastradas através dp método GET no endpoint `/property`, e listar uma propriedade especifica com o endpoint `/property/{propertyId}`, passando um propertyId de uma propriedade já cadastrada.
- Exemplo retorno listando todas as propriedades cadastradas:
<img src="./images_agrotis_api/Property/property_get_all.jpg" width="400px">

- Exemplo retorno listando uma propriedade especifica:
<img src="./images_agrotis_api/Property/get_by_id.jpg" width="400px">

- Exemplo de retorno quando não se encontra uma propriedade especifica:
<img src="./images_agrotis_api/Property/not_found.jpg" width="400px">

#### Método DELETE:
- A API permite deletar uma propriedade especifica com o endpoint `/property/{propertyId}`, passando um propertyId de uma propriedade já cadastrada.
- Exemplo retorno listando todas as propriedades cadastradas:
<img src="./images_agrotis_api/Property/property_delete.jpg" width="400px">

#### Método PUT:
- A API permite editar uma propriedade especifica com o endpoint `/property/{propertyId}`, passando um propertyId de uma propriedade já cadastrada. E passando um body no mesmo padrão do método POST.
- Exemplo retorno listando todas as propriedades cadastradas:
<img src="./images_agrotis_api/Property/property_edit.jpg" width="400px">


### `/laboratory`
#### Método POST:
- API permite que seja criado um novo laboratório através do método POST no endpoint `/laboratory` passando no body um json no formato:
```json
    {
        "name": "string, e não pode ser repetido com alguma propriedade já cadastrada.",
    }
```
- Exemplo de retorno quando é criado com sucesso:
<img src="./images_agrotis_api/Laboratory/lab_post_ok.jpg" width="400px">

Exemplo de retorno quando tem problema com o name:
- Problema com conflito no nome:
<img src="./images_agrotis_api/Laboratory/lab_duplicated.jpg" width="400px">


#### Método GET:
- API permite que seja possivel listar todos os laboratorios cadastradas através dp método GET no endpoint `/laboratory`, e listar um laboratorio especifico com o endpoint `/laboratory/{labId}`, passando um labId de uma laboratorio já cadastrado.
- Exemplo retorno listando todos os laboratorios cadastrados:
<img src="./images_agrotis_api/Laboratory/lab_get_all.jpg" width="400px">

- Exemplo retorno listando um laboratorio especifico:
<img src="./images_agrotis_api/Laboratory/lab_get_by_id.jpg" width="400px">

- Exemplo de retorno quando não se encontra um laboratorio especifico:
<img src="./images_agrotis_api/Laboratory/lab_not_found.jpg" width="400px">

#### Método DELETE:
- A API permite deletar um laboratorio especifico com o endpoint `/laboratory/{labId}`, passando um labId de um laboratorio ja cadastrado.
- Exemplo retorno listando todas as propriedades cadastradas:
<img src="./images_agrotis_api/Laboratory/lab_edited.jpg" width="400px">

#### Método PUT:
- A API permite editar um laboratorio especifico com o endpoint `/laboraotry/{labId}`, passando um labId de um laboratorio ja cadastrado. E passando um body no mesmo padrão do método POST.
- Exemplo retorno listando todas as propriedades cadastradas:
<img src="./images_agrotis_api/Laboratory/lab_deleted.jpg" width="400px">


### `/register`
#### Método POST:
- API permite que seja criado um novo registro através do método POST no endpoint `/register` passando no body um json no formato:
```json
    {
        "name": "String",
        "initialDate": "String no formato YYYY-MM-DD",
        "finalDate": "String no formato YYYY-MM-DD",
        "propertyInfo": {
            "id": "Property id valido"
        },
        "laboratory": {
            "id": "Laboratory id valido"
        },
        "note": "String"
    }
```
- Exemplo de retorno quando é criado com sucesso:
<img src="./images_agrotis_api/Register/register_success.jpg" width="400px">

Exemplo de retorno quando tem problema com o propertyInfo ou laboratory:
- Problema com conflito no propertyInfo:
<img src="./images_agrotis_api/Register/register_property_not_found.jpg" width="400px">
- Problema com conflito no laboratory:
<img src="./images_agrotis_api/Register/register_lab_not_found.jpg" width="400px">


#### Método GET:
- API permite que seja possivel listar todos os registros cadastradas através dp método GET no endpoint `/register`, e listar um registro especifico com o endpoint `/register/{registerId}`, passando um registerId de uma registro já cadastrado.
- Exemplo retorno listando todos os registros cadastrados:
<img src="./images_agrotis_api/Register/register_get_ok.jpg" width="400px">

- Exemplo retorno listando um registro especifico:
<img src="./images_agrotis_api/Register/register_get_by_id.jpg" width="400px">

- Exemplo de retorno quando não se encontra um registro especifico:
<img src="./images_agrotis_api/Register/register_not_found.jpg" width="400px">

#### Método DELETE:
- A API permite deletar um registro especifico com o endpoint `/register/{registerId}`, passando um registerId de um registro ja cadastrado.
- Exemplo retorno listando todas as propriedades cadastradas:
<img src="./images_agrotis_api/Register/register_delete.jpg" width="400px">

#### Método PUT:
- A API permite editar um registro especifico com o endpoint `/laboraotry/{registerId}`, passando um registerId de um registro ja cadastrado. E passando um body no mesmo padrão do método POST.
- Exemplo retorno listando todas as propriedades cadastradas:
<img src="./images_agrotis_api/Register/register_edit.jpg" width="400px">


### Próximos passos:
- Mais testes unitários;
- Melhor tratamento com as exceptions.
