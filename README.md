<h3 align="center"><b>λ§€κ±°μ§</b></h3>

<h4 align="center">π 2022.02.18 ~</h4>
<br>
<br>

---

## π νλ‘ νΈμλ
||
|:----:|
|<img src="https://avatars.githubusercontent.com/u/66668478?v=4" alt="avatar" height="150px" width="150px" /> |
[sunny-yo](https://github.com/MagazineProject/FE_sunju_MagazineProject/tree/api/LYW)|
<br>

<h3 align="center"><b>π· νμ μκ΅¬μ¬ν­ π·</b></h3>

```
1. λ‘κ·ΈμΈ νμ΄μ§
    - λ‘κ·ΈμΈ λ²νΌμ λλ₯Έ κ²½μ° λλ€μκ³Ό λΉλ°λ²νΈκ° λ°μ΄ν°λ² μ΄μ€μ λ±λ‘λλμ§ νμΈν λ€, νλλΌλ λ§μ§ μλ μ λ³΄κ° μλ€λ©΄ "λλ€μ λλ ν¨μ€μλλ₯Ό νμΈν΄μ£ΌμΈμ"λΌλ λ©μΈμ§λ₯Ό νλ‘ νΈμλμμ λ³΄μ¬μ£ΌκΈ°
        1. νμ κ°μ νμ΄μ§
            - λλ€μμ `μ΅μ 3μ μ΄μ, μνλ²³ λμλ¬Έμ(a~z, A~Z), μ«μ(0~9)`λ‘ κ΅¬μ±νκΈ°
            - λΉλ°λ²νΈλ `μ΅μ 4μ μ΄μμ΄λ©°, λλ€μκ³Ό κ°μ κ°μ΄ ν¬ν¨λ κ²½μ° νμκ°μμ μ€ν¨`λ‘ λ§λ€κΈ°
            - λΉλ°λ²νΈ νμΈμ λΉλ°λ²νΈμ μ ννκ² μΌμΉνκΈ°
2. λ‘κ·ΈμΈ κ²μ¬
    - λ‘κ·ΈμΈ νμ§ μμ μ¬μ©μλ, κ²μκΈ λͺ©λ‘ μ‘°νλ κ°λ₯νλλ‘ νκΈ°
    - λ‘κ·ΈμΈνμ§ μμ μ¬μ©μκ° μ’μμ λ²νΌμ λλ μ κ²½μ°, "λ‘κ·ΈμΈμ΄ νμν©λλ€." λΌλ λ©μΈμ§λ₯Ό νλ‘ νΈμλμμ λμμ€ μ μλλ‘ μμΈμ²λ¦¬ νκΈ°
    - λ‘κ·ΈμΈ ν μ¬μ©μκ° λ‘κ·ΈμΈ νμ΄μ§ λλ νμκ°μ νμ΄μ§μ μ μν κ²½μ° "μ΄λ―Έ λ‘κ·ΈμΈμ΄ λμ΄μμ΅λλ€."λΌλ λ©μΈμ§λ‘ μμΈμ²λ¦¬νκΈ°
```

<br>
<h3 align="center"><b>π  Tech Stack π </b></h3>
<p align="center">

<img src="https://img.shields.io/badge/java11-539bf5?style=for-the-badge&logo=java1.8&logoColor=white">
<img src="https://img.shields.io/badge/gradle-1f4954?style=for-the-badge&logo=gradle&logoColor=white">

</br>
    
<img src="https://img.shields.io/badge/jpa-green?style=for-the-badge&logo=jpa&logoColor=white">
<img src="https://img.shields.io/badge/spring%20data%20jpa-green?style=for-the-badge&logo=springdatajpa&logoColor=white">
<img src="https://img.shields.io/badge/springsecurity-green?style=for-the-badge&logo=springsecurity&logoColor=white">
<img src="https://img.shields.io/badge/querydsl-blue?style=for-the-badge&logo=querydsl&logoColor=white">
<img src="https://img.shields.io/badge/mysql-skyblue?style=for-the-badge&logo=mysql&logoColor=white">
    
</br>
    
<img src="https://img.shields.io/badge/Junit5-green?style=for-the-badge&logo=Junit5&logoColor=white">
<img src="https://img.shields.io/badge/swagger3.0-green?style=for-the-badge&logo=swagger&logoColor=white">

</br>

<img src="https://img.shields.io/badge/awsrds-orange?style=for-the-badge&logo=awsrds&logoColor=white">
<img src="https://img.shields.io/badge/awsEc2-orange?style=for-the-badge&logo=awsrds&logoColor=white">
<img src="https://img.shields.io/badge/awsS3-orange?style=for-the-badge&logo=awsrds&logoColor=white">
<img src="https://img.shields.io/badge/ubuntu-orange?style=for-the-badge&logo=ubuntu&logoColor=white">

</br>

<img src="https://img.shields.io/badge/GitHub Actions-blue?style=for-the-badge&logo=GitHub Actions&logoColor=white">
<img src="https://img.shields.io/badge/docker-blue?style=for-the-badge&logo=docker&logoColor=white">

</br>

<br><br>

---




<br><br>

<h3 align="center"><b>π· API Table π·</b></h3>

| function    | method | urI                  | Request                                                                                                        | Success-Response|Fail-Response|
|-------------|--------|----------------------|----------------------------------------------------------------------------------------------------------------|------------------------------------|----------------------|
| λ‘κ·ΈμΈ         | POST   | /api/login           | {"account_email": "string","password": "string"}                                                               | {"success": true,"msg": "λ‘κ·ΈμΈ μ±κ³΅","data": {"account_id": 23,"account_email": "string@naver.com","account_name": "string","token": "Bearer eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJzdHJpbmdAbmF2ZXIuY29tIiwiaWF0IjoxNjQ2NzI2NTQxLCJleHAiOjE2NDY3NDQ1NDF9.ohO7E5V_EmsC_xiWcQWB268o2YqIVluikUfEqOQ98vg","like_board": []} } |{"success": false,"msg": "μ‘΄μ¬ νμ§ μλ μ¬μ©μ μλλ€."}|
| νμκ°μ        | POST   | /api/register        | {"account_email": "string@naver.com","account_name": "string","password": "123456","password_check": "123456"} | {"success": true,"msg": "νμ κ°μ μλ£"} |{"success": false,"msg": "μ΄λ―Έ μ‘΄μ¬νλ μ¬μ©μ μλλ€."}|
| ν ν°μΌλ‘ μ¬μ©μ μ‘°ν | GET    | /api/token           | Headerμ μλ token μ¬μ©                                                                                            |{"success": true,"msg": "μ¬μ©μ μ λ³΄","data": {"account_id": 23,"account_email": "string@naver.com","account_name": "string","token": null,"like_board": []} }|{"timestamp": "2022-03-08T08:08:14.115+00:00","status": 401,"error": "Unauthorized","message": "λ‘κ·ΈμΈ ν΄μ£ΌμΈμ.","path": "/api/token"}
| κ²μκΈ μ μ²΄ μ‘°ν   | GET    | /api/board           |                                                                                         |{"success": true,"msg": "μ μ²΄ κ²μκΈ μ‘°ν μ±κ³΅","data": [{"board_id": 51,"img_url": "https://firebasestorage.googleapis.com/v0/b/myinsta-60d69.appspot.com/o/images%2Fundefined_1646148469611?alt=media&token=e1361922-3a25-48b8-acd9-87a41c527d14","account_id": 4,"account_name": "like","content": "dgfhdgfhfd","time": "2022-03-02T00:27:55.901579","board_status": "left","like": 2,"like_account": [{"account_id": 1 }, {"account_id": 22 }]}|
| κ²μκΈ λ±λ‘      | POST   | /api/board           | Headerμ μλ token μ¬μ©                                                                                            |{"success": true,"msg": "κ²μκΈ λ±λ‘ μ±κ³΅","board_id": 53 }|{"timestamp": "2022-03-08T08:08:14.115+00:00","status": 401,"error": "Unauthorized","message": "λ‘κ·ΈμΈ ν΄μ£ΌμΈμ.","path": "/api/token"}
| κ²μκΈ μμ       | PUT    | /api/board/{boardId} | Headerμ μλ token μ¬μ©                                                                                            |{"success": true,"msg": "κ²μκΈ μμ  μ±κ³΅"}|{"success": false,"msg": "κ²μκΈμ΄ μ‘΄μ¬νμ§ μμ΅λλ€."} OR {"success": false,"msg": "κ²μκΈ μμ±μκ° μλλλ€."}
| κ²μκΈ μ­μ       | DELETE | /api/board/{boardId} | Headerμ μλ token μ¬μ©                                                                                            |{"success": true,"msg": "κ²μκΈ μ­μ  μ±κ³΅"}|{"success": false,"msg": "κ²μκΈμ΄ μ‘΄μ¬νμ§ μμ΅λλ€."} OR {"success": false,"msg": "κ²μκΈ μμ±μκ° μλλλ€."}
| κ²μκΈ νμ΄μ§     | GET    | /api/boardPaging           |                                                                                         |{  "success": true,  "msg": "κ²μκΈ νμ΄μ§",  "data": {    "content": [      {        "board_id": 51,        "image_url": "https://firebasestorage.googleapis.com/v0/b/myinsta-60d69.appspot.com/o/images%2Fundefined_1646148469611?alt=media&token=e1361922-3a25-48b8-acd9-87a41c527d14",        "account_id": 4,        "account_name": "like",        "content": "dgfhdgfhfd",        "time": "2022-03-02T00:27:55.901579",        "board_status": "left",        "like_cnt": 2      }     ]   }"pageable": {      "sort": {        "sorted": false,        "unsorted": true,        "empty": true      },      "offset": 0,      "pageNumber": 0,      "pageSize": 5,      "paged": true,      "unpaged": false    },    "totalPages": 3,    "last": false,    "totalElements": 12,    "size": 5,    "number": 0,    "sort": {      "sorted": false,      "unsorted": true,      "empty": true    },    "numberOfElements": 5,    "first": true,    "empty": false  }}|
| κ²μκΈ μ’μμ λ±λ‘  | POST   | /api/board/{boardId}/like           | Headerμ μλ token μ¬μ©                                                                                            |{"success": true,"msg": "μ’μμ λ±λ‘ μ±κ³΅"}|{"success": false,"msg": "κ²μκΈμ΄ μ‘΄μ¬νμ§ μμ΅λλ€."}
| κ²μκΈ μ’μμ μ­μ   | DELETE | /api/board/{boardId}/like           | Headerμ μλ token μ¬μ©                                                                                            |{"success": true,"msg": "μ’μμ μ­μ  μ±κ³΅"}|{"success": false,"msg": "μ’μμ μ­μ  μ€ν¨"}


---
<br><br>

<h3 align="center"><b>π· Swagger RestApi Docs π·</b></h3>
<div style="text-align: center;">
<img src="https://user-images.githubusercontent.com/48196352/157191961-794d2d13-6f9e-40f1-85b3-15dfdb23880a.png">
</div>
<br><br>

<h3 align="center"><b>π· ERD π·</b></h3>
<div style="text-align: center;">
<img src="https://user-images.githubusercontent.com/48196352/157191334-bec3cfbf-d0aa-4083-89f3-a4e1bf1f2cc2.png">
</div>
<br><br>

<h3 align="center"><b>β Trouble Shooting β</b></h3>
<br>

<details>
    <summary>
        <b>N+1λ¬Έμ  λΆλͺ¨ μν°ν°μμ μ μ²΄λ₯Ό μ‘°νν λ λΆλͺ¨μμ  μν°ν° μ‘°ν (1) + μμμν°ν° (n) μ‘°ν νλ€κ³ ν΄μ n+1 λ§νΌ μ‘°ν </b>
    </summary>
    <br>ν΄κ²° : fetch joinμ μ¬μ©νμ¬ ν΄κ²° <br>
- μλ°©ν₯ λ§€νμ΄ μλ λ¨λ°©ν₯ λ§€νμΌλ‘ κ°λ° μ N+1 λ¬Έμ λ₯Ό λ§λμ§ μλλ€. <br>
- ymlμ μΈν Hibernate default_batch_fetch_size : ν΄λΉ μ΅μμ μ§μ λ μλ§νΌ inμ μ λΆλͺ¨ Keyλ₯Ό μ¬μ©ν¨μΌλ‘μ κ°μ₯ μ’μ λ°©λ²(?) inμ μ ν€κ°μ λ£μΌλ©΄μ λ°μ΄ν° λ»₯νκΈ°x <br>
</details>
