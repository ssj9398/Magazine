<h3 align="center"><b>개인 프로젝트 매거진 만들기</b></h3>

<h4 align="center">📆 2022.02.18 ~</h4>
<br>
<br>

---

## 📌 프론트엔드

|김선주|
|:----:|
|<img src="https://avatars.githubusercontent.com/u/66668478?v=4" alt="avatar" height="150px" width="150px" /> |
[sunny-yo](https://github.com/MagazineProject/FE_sunju_MagazineProject/tree/api/LYW)|
<br>

---

<br>
<h3 align="center"><b>🛠 Tech Stack 🛠</b></h3>
<p align="center">

<img src="https://img.shields.io/badge/java11-539bf5?style=for-the-badge&logo=java1.8&logoColor=white">
<img src="https://img.shields.io/badge/jpa-green?style=for-the-badge&logo=jpa&logoColor=white">
<img src="https://img.shields.io/badge/spring%20data%20jpa-green?style=for-the-badge&logo=springdatajpa&logoColor=white">
<img src="https://img.shields.io/badge/gradle-1f4954?style=for-the-badge&logo=gradle&logoColor=white">
<img src="https://img.shields.io/badge/Junit5-green?style=for-the-badge&logo=Junit5&logoColor=white">
<img src="https://img.shields.io/badge/swagger3.0-green?style=for-the-badge&logo=swagger&logoColor=white">
<img src="https://img.shields.io/badge/springsecurity-green?style=for-the-badge&logo=springsecurity&logoColor=white">
<img src="https://img.shields.io/badge/mysql-skyblue?style=for-the-badge&logo=mysql&logoColor=white">

</br>

<img src="https://img.shields.io/badge/awsrds-orange?style=for-the-badge&logo=awsrds&logoColor=white">
<img src="https://img.shields.io/badge/awsEc2-orange?style=for-the-badge&logo=awsrds&logoColor=white">
<img src="https://img.shields.io/badge/awsS3-orange?style=for-the-badge&logo=awsrds&logoColor=white">
<img src="https://img.shields.io/badge/ubuntu-orange?style=for-the-badge&logo=ubuntu&logoColor=white">
<img src="https://img.shields.io/badge/git Action-blue?style=for-the-badge&logo=gitAction&logoColor=white">
<img src="https://img.shields.io/badge/docker-blue?style=for-the-badge&logo=docker&logoColor=white">
<img src="https://img.shields.io/badge/querydsl-blue?style=for-the-badge&logo=querydsl&logoColor=white">

</br>

<br><br>

---





---


<br><br>

<h3 align="center"><b>🏷 API Table 🏷</b></h3>

| function    | method | urI                  | Request                                                                                                        | Success-Response|Fail-Response|
|-------------|--------|----------------------|----------------------------------------------------------------------------------------------------------------|------------------------------------|----------------------|
| 로그인         | POST   | /api/login           | {"account_email": "string","password": "string"}                                                               | {"success": true,"msg": "로그인 성공","data": {"account_id": 23,"account_email": "string@naver.com","account_name": "string","token": "Bearer eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJzdHJpbmdAbmF2ZXIuY29tIiwiaWF0IjoxNjQ2NzI2NTQxLCJleHAiOjE2NDY3NDQ1NDF9.ohO7E5V_EmsC_xiWcQWB268o2YqIVluikUfEqOQ98vg","like_board": []} } |{"success": false,"msg": "존재 하지 않는 사용자 입니다."}|
| 회원가입        | POST   | /api/register        | {"account_email": "string@naver.com","account_name": "string","password": "123456","password_check": "123456"} | {"success": true,"msg": "회원 가입 완료"} |{"success": false,"msg": "이미 존재하는 사용자 입니다."}|
| 토큰으로 사용자 조회 | GET    | /api/token           | Header에 있는 token 사용                                                                                            |{"success": true,"msg": "사용자 정보","data": {"account_id": 23,"account_email": "string@naver.com","account_name": "string","token": null,"like_board": []} }|{"timestamp": "2022-03-08T08:08:14.115+00:00","status": 401,"error": "Unauthorized","message": "로그인 해주세요.","path": "/api/token"}
| 게시글 전체 조회   | GET    | /api/board           |                                                                                         |{"success": true,"msg": "전체 게시글 조회 성공","data": [{"board_id": 51,"img_url": "https://firebasestorage.googleapis.com/v0/b/myinsta-60d69.appspot.com/o/images%2Fundefined_1646148469611?alt=media&token=e1361922-3a25-48b8-acd9-87a41c527d14","account_id": 4,"account_name": "like","content": "dgfhdgfhfd","time": "2022-03-02T00:27:55.901579","board_status": "left","like": 2,"like_account": [{"account_id": 1 }, {"account_id": 22 }]}|
| 게시글 등록      | POST   | /api/board           | Header에 있는 token 사용                                                                                            |{"success": true,"msg": "게시글 등록 성공","board_id": 53 }|{"timestamp": "2022-03-08T08:08:14.115+00:00","status": 401,"error": "Unauthorized","message": "로그인 해주세요.","path": "/api/token"}
| 게시글 수정      | PUT    | /api/board/{boardId} | Header에 있는 token 사용                                                                                            |{"success": true,"msg": "게시글 수정 성공"}|{"success": false,"msg": "게시글이 존재하지 않습니다."} OR {"success": false,"msg": "게시글 작성자가 아닙니다."}
| 게시글 삭제      | DELETE | /api/board/{boardId} | Header에 있는 token 사용                                                                                            |{"success": true,"msg": "게시글 삭제 성공"}|{"success": false,"msg": "게시글이 존재하지 않습니다."} OR {"success": false,"msg": "게시글 작성자가 아닙니다."}
| 게시글 페이징     | GET    | /api/boardPaging           |                                                                                         |{  "success": true,  "msg": "게시글 페이징",  "data": {    "content": [      {        "board_id": 51,        "image_url": "https://firebasestorage.googleapis.com/v0/b/myinsta-60d69.appspot.com/o/images%2Fundefined_1646148469611?alt=media&token=e1361922-3a25-48b8-acd9-87a41c527d14",        "account_id": 4,        "account_name": "like",        "content": "dgfhdgfhfd",        "time": "2022-03-02T00:27:55.901579",        "board_status": "left",        "like_cnt": 2      }     ]   }"pageable": {      "sort": {        "sorted": false,        "unsorted": true,        "empty": true      },      "offset": 0,      "pageNumber": 0,      "pageSize": 5,      "paged": true,      "unpaged": false    },    "totalPages": 3,    "last": false,    "totalElements": 12,    "size": 5,    "number": 0,    "sort": {      "sorted": false,      "unsorted": true,      "empty": true    },    "numberOfElements": 5,    "first": true,    "empty": false  }}|
| 게시글 좋아요 등록  | POST   | /api/board/{boardId}/like           | Header에 있는 token 사용                                                                                            |{"success": true,"msg": "좋아요 등록 성공"}|{"success": false,"msg": "게시글이 존재하지 않습니다."}
| 게시글 좋아요 삭제  | DELETE | /api/board/{boardId}/like           | Header에 있는 token 사용                                                                                            |{"success": true,"msg": "좋아요 삭제 성공"}|{"success": false,"msg": "좋아요 삭제 실패"}


---
<br><br>

<h3 align="center"><b>🏷 Swagger RestApi Docs 🏷</b></h3>
<div style="text-align: center;">
<img src="https://user-images.githubusercontent.com/48196352/157191961-794d2d13-6f9e-40f1-85b3-15dfdb23880a.png">
</div>
<br><br>

<h3 align="center"><b>🏷 ERD 🏷</b></h3>
<div style="text-align: center;">
<img src="https://user-images.githubusercontent.com/48196352/157191334-bec3cfbf-d0aa-4083-89f3-a4e1bf1f2cc2.png">
</div>
<br><br>

<h3 align="center"><b>✏ Trouble Shooting ✏</b></h3>
<br>

<details>
    <summary>
        <b>N+1문제 부모 엔티티에서 전체를 조회할때 부모자신 엔티티 조회 (1) + 자식엔티티 (n) 조회 한다고해서 n+1 만큼 조회 </b>
    </summary>
    <br>해결 : fetch join을 사용하여 해결 <br>
- 양방향 매핑이 아닌 단방향 매핑으로 개발 시 N+1 문제를 만나지 않는다. <br>
- yml에 세팅 Hibernate default_batch_fetch_size : 해당 옵션은 지정된 수만큼 in절에 부모 Key를 사용함으로서 가장 좋은 방법(?) in절에 키값을 넣으면서 데이터 뻥튀기x <br>
</details>