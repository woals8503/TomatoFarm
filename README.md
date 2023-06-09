<h1 align="center">JPA 개인 프로젝트</h1>



## :convenience_store: 프로젝트 소개
```
토마토를 직접 심어 해충으로부터 토마토를 안전하게 재배하는 게임입니다.
여태껏 기술적인 부분에 치우치다 보니 기본적인 자바의 객체지향에 대해서 손을 놓고있었습니다.
객체지향적으로 엔티티를 설계하여 자바의 특징인 캡슐화의 장점을 극대화 할 수 있는 설계를 하여 JPA와 함께 프로젝트를
만들어 보고 싶었습니다. 

```

## 📅 개발 기간
```
2023.05.05 ~ 2023.05.10
```


사용 기술
1. java
2. spring-data-jpa
3. querydsl
4. gradle
5. springboot

## 🔨 목표

### 목표
1. JPA에 대한 이해도 
2.  다양한 조건으로서 객체들의 연관관계 매핑
3.  변경이나 확장 시 유지보수 측면에서 쉽도록 설계.
4.  객체지향적으로 접근

<br><br>

## 🔨 프로젝트 기능
  
1. 밭 생성 및 조회
2. 밭에 토마토 심기 - 토마토 심기 버튼을 눌러 비어있는 밭을 클릭하여 토마토를 심을 수 있다.
3. 물 주기          - 물을 줄 수록 토마토 단계가 증가 - 씨앗(1단계) -> 방울 토마토(2단계) -> 토마토(3단계)
4. 해충 생성        - 토마토가 2단계 이상으로 증가하면 해충이 확률적으로 생성된다.
5. 농약 사용        - 농약을 사용하여 해충의 생성 확률을 낮출 수 있다.
6. 해충 박멸        - 현재 토마토에 붙어있는 해충을 없애 원래 토마토로 되돌릴 수 있다.
7. 토마토 수확      - 해충이 없는 3단계인 토마토를 재배하여 가지고 있는 토마토 수를 늘린다.
8. 해충 공격        - 해충은 시간적으로 토마토를 공격하여 토마토 life를 감소시킨다. life가 0일 경우 썩은 토마토로 변경되어 수확할 수 없다. ( 미완성 )
<br><br>


### 도메인 설계
<p align="center">
  <img src="./Readme_Assets/domain.PNG">
<p>
<br>
<br>
  

### 1. 밭 생성
<p align="center">
  <img src="./Readme_Assets/makefield.PNG">
<p>
<br>
<br>
  
### 2. 씨앗 심기
<p align="center">
  <img src="./Readme_Assets/plantSeed.PNG">
<p>
<br>
  
### 3. 물 주기
<p align="center">
  <img src="./Readme_Assets/water.PNG">
<p>
<br>
<br>  

### 4. 해충 생성 
<p align="center">
  <img src="./Readme_Assets/pest.PNG">
<p>
<br>
<br>  
  ### 5. 농약 사용 
<p align="center">
 <img src="./Readme_Assets/pestside.PNG">
<p>
<br>
<br>  
### 6. 토마토 수확
<p align="center">
 <img src="./Readme_Assets/plant.PNG">
<p>
<br>
<br>  
### 7. 해충 박멸
<p align="center">
  <img src="./Readme_Assets/해충박멸전.PNG">
  <img src="./Readme_Assets/해충박멸 사용.PNG">
   <img src="./Readme_Assets/removePest.PNG">
<p>
<br>
