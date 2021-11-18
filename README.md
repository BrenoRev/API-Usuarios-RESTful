# API de Cadastro de Usuários no Sistema
<h3> Back-end sendo consumido por um front-end SPA em Angular </h3>
<h4>http://angular-usuarios.herokuapp.com/login</h4>
<h5>https://github.com/BrenoRev/UsuariosAngular</h5>
<hr>
 <p>Ferramentas utilizadas</p>
        <ul>
  <li>Java</li>
  <li>Spring</li>
  <li>Postgresql</li>
  <li>JWT / Spring Security</li>
  <li>Criptografia BCrypt</li>
  <li>Jasper Relatorios</li>
        </ul>
        <hr>

[POST] Criar novo usuario - https://api-restrevdev.herokuapp.com/api-rest/usuario/register
<details>
    <summary><b>JSON</b></summary>
 
![Registro](https://user-images.githubusercontent.com/84048306/142333670-3e7786ff-cecb-4890-8762-934b8567cce4.png)

  <br>
 
 </details>

 <hr>
 
[POST] Logar a conta - https://api-restrevdev.herokuapp.com/api-rest/login
<details>
    <summary><b>JSON</b></summary>
 
![image](https://user-images.githubusercontent.com/84048306/142333767-2069e295-c095-49fc-a2e0-a84617fd8e83.png)
 
 </details>
    <hr>
    
  [POST] Recuperar Login - https://api-restrevdev.herokuapp.com/api-rest/recuperar
 <details>
    <br>
    <summary><b>JSON</b></summary>
 
 ![image](https://user-images.githubusercontent.com/84048306/142336503-5e625a69-22f5-4e0c-8aa2-4818be5fc419.png)

 </details>
 <hr>
 <h4> OBS : PASSAR O TOKEN JWT GERADO NO LOGIN EM CADA REQUISIÇÃO </h4>
  <hr>

[GET] Listar todos usuarios -  https://api-restrevdev.herokuapp.com/api-rest/usuario/

<details>
   <br>
    <summary><b>JSON</b></summary>
 
![image](https://user-images.githubusercontent.com/84048306/142333914-c6901516-4cdc-4723-9824-e0e9c5e52a50.png)
 
 </details>
 <hr>
 
[GET] Buscar um usuário pelo ID - https://api-restrevdev.herokuapp.com/api-rest/usuario/?id
<details>
    <br>
    <summary><b>JSON</b></summary>
 
![image](https://user-images.githubusercontent.com/84048306/142333981-8c7f468c-3df8-4439-9205-0387b2bfebe7.png)
 
 </details>
 <hr>
 
[PUT] Atualizar um usuário pelo ID - https://api-restrevdev.herokuapp.com/api-rest/usuario/
 <details>
    <br>
    <summary><b>JSON</b></summary>

 ![image](https://user-images.githubusercontent.com/84048306/142334509-fa65a519-2088-456e-abbe-7e3f918ec431.png)

 
 </details>
 <hr>
 <br>
[DELETE] Excluir um usuário pelo ID - https://api-restrevdev.herokuapp.com/api-rest/usuario/?id
<br>
!No Return Statement
<hr>

[GET] Paginação de Usuarios - https://api-restrevdev.herokuapp.com/api-rest/usuario/page/?number
 <details>
    <br>
    <summary><b>JSON</b></summary>

 ![image](https://user-images.githubusercontent.com/84048306/142334749-8fa929f5-1d77-45c1-8670-e049aaa16181.png)
 
 </details>
 <hr>
 
 [PATCH] Atualização parcial de Usuarios - https://api-restrevdev.herokuapp.com/api-rest/usuario/patch
 <details>
    <br>
    <summary><b>JSON</b></summary>

 ![image](https://user-images.githubusercontent.com/84048306/142335326-334c5e14-1171-4695-b73a-2d9808c81f67.png)
 
 </details>
 <hr>
 
  [GET] Buscar usuario por nome - https://api-restrevdev.herokuapp.com/api-rest/usuario/name/?nome
  <br>
  [GET] Buscar usuario por nome com paginação - https://api-restrevdev.herokuapp.com/api-rest/usuario/name/?{nome}/page/?{page}
 <details>
    <br>
    <summary><b>JSON</b></summary>

 ![image](https://user-images.githubusercontent.com/84048306/142335660-9d3a093a-1fb9-4791-a1da-369f6ff05641.png)

 
 </details>
 <hr>
 
   [GET] Buscar relatorio por id de usuario - https://api-restrevdev.herokuapp.com/api-rest/usuario/relatorio/?{id}
 
 <details>
    <br>
    <summary><b>JSON</b></summary>
 <h4>UM PDF</h4>
 
![image](https://user-images.githubusercontent.com/84048306/142335803-663009a7-c14b-44d8-80c1-d1209b4d4118.png)
 
  ->
 
 ![image](https://user-images.githubusercontent.com/84048306/142335897-2bade8c9-cb1d-4deb-8d0f-1111fda9bf29.png)

 </details>
 <hr>
 
   [GET] Buscar todas as profissoes - https://api-restrevdev.herokuapp.com/api-rest/profissao/
 <details>
    <br>
    <summary><b>JSON</b></summary>
 
  ![image](https://user-images.githubusercontent.com/84048306/142336349-fa502f17-d908-48c2-932f-05542363edf8.png)

 </details>
 <hr>
 
