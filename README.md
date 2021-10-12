# API de Cadastro de Usuários no Sistema

<hr>
 <p>Ferramentas utilizadas</p>
        <ul>
  <li>Java</li>
  <li>Spring</li>
  <li>Postgresql</li>
  <li>JWT / Spring Security</li>
  <li>Criptografia BCrypt</li>
        </ul>
        <hr>

[POST] Criar novo usuario - https://api-restrevdev.herokuapp.com/api-rest/usuario/register
<details>
    <summary><b>JSON</b></summary>
{
 <br>
    &nbsp "login": "github", 
  <br>
    &nbsp "senha": "demonstracao",
  <br>
    &nbsp "nome":"insira seu nome aqui",
  <br>
    &nbsp "telefones": 
  <br>
 &nbsp &nbsp &nbsp [
  <br>
  &nbsp {
  <br>
   &nbsp "numero": "seu telefone aqui"
  <br>
  &nbsp }
  <br>
&nbsp &nbsp &nbsp ]
  <br>
}
  <br>
 
 </details>

 <hr>
 
[POST] Logar a conta - https://api-restrevdev.herokuapp.com/api-rest/login
<details>
    <summary><b>JSON</b></summary>
{
 <br>
    &nbsp "login": "github", 
  <br>
    &nbsp "senha": "demonstracao",
  <br>
}
 </details>
    <hr>
 <h4> OBS : PASSAR O TOKEN JWT GERADO NO LOGIN EM CADA REQUISIÇÃO </h4>
  <hr>

[GET] Listar todos usuarios -  https://api-restrevdev.herokuapp.com/api-rest/usuario/

<details>
   <br>
    <summary><b>JSON DE RETORNO</b></summary>
{
 <br>
    &nbsp "userLogin": "breno", 
  <br>
    &nbsp "userNome": "breno",
  <br>
    &nbsp "userTelefones": 
  <br>
 &nbsp &nbsp &nbsp [
  <br>
  &nbsp {
  <br>
   &nbsp "numero": "88582992"
  <br>
  &nbsp }
  <br>
&nbsp &nbsp &nbsp ]
  <br>
},
  <br>
....
 <br>
 </details>
 <hr>
 
[GET] Buscar um usuário pelo ID - https://api-restrevdev.herokuapp.com/api-rest/usuario/?id
<details>
    <br>
    <summary><b>JSON DE RETORNO</b></summary>
{
 <br>
    &nbsp "userLogin": "eliane", 
  <br>
    &nbsp "userNome": "eliane maria da silva",
  <br>
    &nbsp "userTelefones": []
  <br>
 }
 </details>
 <hr>
 
[PUT] Atualizar um usuário pelo ID - https://api-restrevdev.herokuapp.com/api-rest/usuario/?id
 <details>
    <br>
    <summary><b>JSON</b></summary>
{
<br>
    &nbsp "id": 2, 
  <br>
 <br>
    &nbsp "login": "githubatualizado", 
  <br>
    &nbsp "senha": "demonstracao2",
  <br>
    &nbsp "nome":"insira seu novo nome aqui",
  <br>
    &nbsp "telefones": 
  <br>
 &nbsp &nbsp &nbsp [
  <br>
  &nbsp {
  <br>
   &nbsp "numero": "seu novo telefone aqui"
  <br>
  &nbsp }
  <br>
&nbsp &nbsp &nbsp ]
  <br>
}
  <br>
 
 </details>
 <hr>
 <br>
[DELETE] Excluir um usuário pelo ID - https://api-restrevdev.herokuapp.com/api-rest/usuario/?id
 <No Return Statement>
