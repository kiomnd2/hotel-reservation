# 호텔 예약 시스템
> 간단한 호텔 예약시스템을 구축함. 주요하게 생각해야 할 점은 호텔 방에 따라 예약 정원이 있으며, 정원이 가득찰 경우 
> 예약을 하지 못함. 동시성 에슈에 대해 생각해야함

## 정리
https://www.notion.so/62625776299c4a38a9de50c372237244

## SPEC
* java 17
* spring-boot 3.2.5
* jpa
* redis
* eureka-server
* api-gateway

## 구조도
![사진1.png](img%2F%EC%82%AC%EC%A7%841.png)
* MSA 로 구성되었으며 요금서비스와 결제서비스, 관리자 서비스는 제외됨

## ERD
![사진2.png](img%2F%EC%82%AC%EC%A7%842.png)


## 동시성 고민
* 2가지 방법
  * 낙관적 락 : 버저닝 사용, 제일 간단
  * 비관적 락 : 데이터 수정동안 접근을 제한함
    * Redisson 을 사용해서 비관적 락 사용