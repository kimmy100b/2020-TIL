# DB 트랜잭션(Transaction)

**랜잭션이란?**

> 데이터베이스의 상태를 변화시키기 위해 수행하는 작업 단위

상태를 변화시킨다는 것 -> **SQL 질의어를 통해 DB에 접근하는 것**

```
- SELECT
- INSERT
- UPDATE
- DELETE
```

작업 단위 -> **여러 SQL명령문들**<br>
사람이 정하는 기준에 따라 정한다.

```
ex) 사용자 A가 사용자 B에게 만원을 송금한다.

* 이때 DB 작업
1. 사용자 A의 계좌에서 만원을 차감 : UPDATE문을 사용해 사용자 A의 잔고를 변경
2. 사용자 B의 계좌에서 만원을 추가 : UPDATE문을 사용해 사용자 B의 잔고를 변경

작업단위 : 출금 UPDATE문 + 입금 UPDATE문
-> 이를 통틀어 하나의 트랜잭션이라고 한다.
- 작업 단위 모두 성공적으로 완료되어야만 "하나의 작업(트랜잭션)"이 완료되는 것이다. `Commit`
- 작업 단위에 속하는 쿼리 중 하나라도 실패하면 모든 쿼리문을 취소하고 이전 상태로 돌려놓아야한다. `Rollback`
```

## 참고

<https://github.com/gyoogle/tech-interview-for-developer/blob/master/Computer%20Science/Database/Transaction.md>
