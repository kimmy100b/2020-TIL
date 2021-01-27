## 💎 3주차 미션! (1월 28일 목요일 오후 6시까지 제출)

### 📙 문제 1. 학점을 계산해보자!

**1. 미션 제목**
학점을 계산해보자!

**2. 지시문**

- 학생의 점수로 학점을 구하는 프로그램을 작성하시오.
- 키보드에서 입력받은 성적 (0 ~ 100 점) 의 유효성을 체크
- 학점은 배열을 이용하여 초기화 (아래 “학점 테이블” 참조)
- 학점은 “학점” 과 같이 계산하는데, 반드시 “학점 테이블”을 사용하여 계산하고 학점도 “학점 테이블”의 내용을 출력
- 성적을 입력하여 계속 학점을 구하며 특별한 문자인 “999” 를 입력하면 프로그램을 종료

Table 1 - 학점

// 이미지

Table 2 - 학점 테이블

// 이미지

유효성 체크: 0 <= 성적 <= 100 - “120” 입력 -> 성적을 올바르게 입력하세요! (0 ~ 100)<br>

Figure 1 출력 결과

// 이미지

**3. 핵심 개념** #배열 #표준입력 #표준출력 #분기문 #반복문 #break #무한반복문

**4. 부가 설명**

- 표준입출력: https://www.tutorialspoint.com/cprogramming/c_input_output.htm
- break: https://www.tutorialspoint.com/cprogramming/c_break_statement.htm

### 📙 문제 1. 문제 풀이

**1. 소스코드**

```c
#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <cs50.h>

const int NUMBER_OF_GRADES = 9; // 학점 수
const int SCORES[NUMBER_OF_GRADES] = {95, 90, 85, 80, 75, 70, 65, 60, 0}; // 학점 점수
const char *GRADES[NUMBER_OF_GRADES] = {"A+", "A", "B+", "B", "C+", "C", "D+", "D", "F"}; // 학점


void printScore(char *who, const int scores[], int length); // 점수를 출력하는 함수
void printGrade(char *who, const char *grades[], int length); // 학점을 출력하는 함수
int getScore(); // 사용자로부터 점수를 입력받는 함수
char* calculateGrade(int studentScore, const int scores[], const char*grades[], int length); // 입력받는 점수를 학점으로 계산하는 함수

int main(void){
  printf("학점 프로그램\n");
  printf("종료를 원하면 \"999\"를 입력\n");
  printf("[학점 테이블]\n");
  printScore("점수:", SCORES, NUMBER_OF_GRADES);
  printGrade("학점:", GRADES, NUMBER_OF_GRADES);

  int studentScore = 0; // 입력받은 점수

  do{
    studentScore = getScore();
    char *grade = calculateGrade(studentScore, SCORES, GRADES, NUMBER_OF_GRADES);
    printf("학점은 %s입니다\n",grade);
  }while(studentScore!=999);

  printf("학점 프로그램을 종료합니다.\n");

  return 0;
}

// 점수를 출력하는 함수
void printScore(char *who, const int scores[], int length){
    printf("%s", who);

    for (int i = 0; i < length; i++) {
        printf("%d\t", scores[i]);
    }

    printf("\n");
}

// 학점을 출력하는 함수
void printGrade(char*who, const char*grades[], int length){
    printf("%s", who);

    for (int i = 0; i < length; i++) {
        printf("%s\t", grades[i]);
    }

    printf("\n");
}

// 사용자로부터 점수를 입력받는 함수
int getScore(){
    int inputScore = get_int("성적을 입력하세요 (0 ~ 100) : ");
    while((inputScore<0||inputScore>100)&&inputScore!=999){
        printf("**%4d 성적을 올바르게 입력하세요. 범위는 0 ~ 100 입니다.\n",inputScore);
        inputScore = get_int("성적을 입력하세요 (0 ~ 100) : ");
    };

    return inputScore;
}

// 입력받는 점수를 학점으로 계산하는 함수
char* calculateGrade(int studentScore, const int scores[], const char*grades[], int length){
    char *grade = "A+";

    for (int i = 0; i < length; i++) {
        if (studentScore >= scores[i]) {
            grade = malloc(sizeof(char) * strlen(grades[i]));
            strcpy(grade, grades[i]);
            break;
        }
    }

    return grade;
}

```

**2. 참고**
샘플문제의 소스코드를 참고하여 코딩해보았습니다.

**3. 소스 URL**
URL : <https://sandbox.cs50.io/6390b1ea-5cca-434a-b9e1-477e5fbf8399>
<br>
(해당 링크로 들어가시면 samplemission.c파일은 샘플문제 소스코드를 나름대로 분석하여 주석을 달아놓았습니다. teammission3_1.c파일은 3주차 팀미션 1번 문제에 대한 소스코드입니다.)
