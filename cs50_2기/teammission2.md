## cs50 2기 2주차 미션

📗 문제 1번

```c
#include <stdio.h>

#define VAR 0.1 // 부가세
#define PRICE 10000 // 물품 가격

int main(void){
    int stock = 5; // 기존 재고량
    int leftStock = stock; // 남은 재고량
    int salePrice; // 매출액
    int order = 3; // 주문건수

    leftStock = stock - order;
    salePrice = order*PRICE*(1+VAR);

    printf("주문건수 : %d\n", order);
    printf("기존 재고량 : %d\n", stock);
    printf("남은 재고량 : %d\n", leftStock);
    printf("매출액(부가세포함) : %d\n", salePrice);

}
```

📘 문제 2번

```c
#include <stdio.h>

#define RATE 0.012 // 이율

int main(void){
    int goal; //목표금액
    int total; // 만기시 받게 되는 금액

    printf("목표금액을 입력하세요: ");
    scanf("%d", &goal);

    total = goal*(1+RATE);

    printf("만기시 받게 되는 금액 : %d\n",total);

}
```

📙 문제 3번

```c
#include <stdio.h>
#include <string.h> // strcmp 함수가 선언된 헤더 파일

int main(void)
{
    char input[10];
    char week[7][10] = {"월요일","화요일","수요일","목요일","금요일", "토요일", "일요일"};
    char food[7][20] = {"청국장","비빔밥","된장찌개","칼국수","냉면","소불고기","오삼불고기"};

    printf("요일을 입력하세요: ");
    scanf("%s", input);

    for(int i=0; i<7; i++){
    if(strcmp(input, week[i])==0){
    printf("%s : %s\n", input, food[i]);
    return 0;
    }
    }
    printf("요일을 입력하지 않았습니다.\n");
}
```

📌 코드URL : https://sandbox.cs50.io/3fc165c0-4f8c-4422-8863-ff21a6a792b7
