## 💎 3주차 미션! (1월 28일 목요일 오후 6시까지 제출)

**💡 샘플미션. 채점 프로그램을 만들어보자!**

1. 미션 제목

   - 채점 프로그램을 만들어보자!

2. 지시문
   학생들의 답안을 채점하는 프로그램을 작성하시오. - 모든 문제는 객관식으로 1 ~ 5 사이의 정답을 가짐 - 10 문제에 대한 학생의 답을 매개변수 (arguments) 를 이용하여 입력 - 문제의 정답은 배열 (arrays) 를 이용하여 초기화 (아래 문제 정답 참조) - 답안의 유효성을 체크 (답안의 개수: 10, 답의 범위: 1 ~ 5), 맞지 않으면 오류를 출력
   ㄴ 답안의 개수가 틀린 경우, “문제는 10 문제입니다. 현재 {n} 개의 답안을 제출했습니다. 10 개의 답안을 제출하시오.”
   ㄴ 답의 범위가 틀린 경우, “답의 범위는 1 ~ 5 입니다. 범위 외의 답안이 있습니다.” - 문제당 10점으로 채점하고, 학점은 아래 “학점” 을 참고 - 정상 출력은 정답 수와 점수를 출력하고, 학점도 같이 출력

Table 1 - 학점

// 이미지

유효성 체크 1: 답안 수 == 10
유효성 체크 2: 1 <= 답 <= 5

문제 정답 예시: 1, 2, 3, 4, 5, 1, 2, 3, 4, 5

3. 핵심 개념 #배열 #분기문 #반복문 #매개변수 #표준출력 #atoi #stdlib #break

4. 부가 설명

- char to int (atoi: stdlib.h): https://ko.wikipedia.org/wiki/Stdlib.h
- 표준입출력: https://www.tutorialspoint.com/cprogramming/c_input_output.htm
- break: https://www.tutorialspoint.com/cprogramming/c_break_statement.htm
- malloc: http://www.cplusplus.com/reference/cstdlib/malloc/
- strlen: http://www.cplusplus.com/reference/cstring/strlen/

🔔 답안

```
#include <stdio.h>
#include <stdlib.h>
#include <string.h>

const int NUMBER_OF_ANSWERS = 10; // 문제 수
const int ANSWERS[NUMBER_OF_ANSWERS] = {1, 2, 3, 4, 5, 1, 2, 3, 4, 5}; // 문제 답안

const int NUMBER_OF_GRADES = 9; // 학점 수
const int SCORES[NUMBER_OF_GRADES] = {95, 90, 85, 80, 75, 70, 65, 60, 0}; // 학점 매기는 점수
const char *GRADES[NUMBER_OF_GRADES] = {"A+", "A", "B+", "B", "C+", "C", "D+", "D", "F"}; // 학점 등급

int* charArrayToIntArray(char *target[], const int length); // 사용자 답안 입력받는 배열
int getNumberOfCollectAnswers(const int answers[], const int target[], int length);
int calculateScore(int numberOfCollectAnswers);
void printAnswers(char *who, const int target[], int length);
char* calculateGrade(int totalScore, const int scores[], const char *grades[], int length);

int main(int argc, char *argv[]) { // args:메인함수에 전달되는 데이터의 갯수, 메인함수에 전달되는 실제적인 데이터로 char형 포인트 배열로 구성
	if (argc != (NUMBER_OF_ANSWERS + 1)) {
		printf("문제는 10 문제입니다. 현재 %d 개의 답안을 제출했습니다. 10개의 답안을 제출하시오.\n", argc - 1);
		printf("ex) ./mission02 4 4 3 5 2 5 1 2 4 3\n");
		return -1;
	}

	int *studentAnswers = charArrayToIntArray(argv, argc); // studentAnswers에다가 사용자가 입력한 값 넣기

	for (int i = 0; i < NUMBER_OF_ANSWERS; i++) {
		if (studentAnswers[i] >= 0 && studentAnswers[i] <= 5) {
			continue;
		} else {
			printf("답의 범위는 1 ~ 5 입니다. 범위 외의 답안이 있습니다.\n");
			return -1;
		}
	}

	printf("학점평가 시작\n");

	int numberOfCollectAnswers = getNumberOfCollectAnswers(ANSWERS, studentAnswers, NUMBER_OF_ANSWERS);

	int totalScore = calculateScore(numberOfCollectAnswers);

	char *grade = calculateGrade(totalScore, SCORES, GRADES, NUMBER_OF_GRADES);

	printAnswers("정답", ANSWERS, NUMBER_OF_ANSWERS);
	printAnswers("학생", studentAnswers, NUMBER_OF_ANSWERS);
	printf("정답 수: %d\n", numberOfCollectAnswers);
	printf("점수: %d\n", totalScore);
	printf("학점: %s\n", grade);

	return 0;
}

// 입력받는 함수
int* charArrayToIntArray(char *target[], const int length) {
  // 크기 바이트의 메모리 블록을 할당하여 블록 시작에 대한 포인터를 반환
	int *result = malloc(sizeof(int) * NUMBER_OF_ANSWERS); //int의 크기 * 문제 수

	for (int i = 0; i < NUMBER_OF_ANSWERS; i++) {
		result[i] = atoi(target[i + 1]); // atoi : a(char,ASCII) to i(int) = 문자타입에서 숫자타입으로 변경
	}

	return result;
}

// 답 구하는 함수
// 첫번째 : 답안번호, 두번째 : 사용자 답안, 세번째 : 문제 수
int getNumberOfCollectAnswers(const int answers[], const int target[], int length) {
	int numberOfCollectAnswers = 0; // 총 점수 0점부터 시작

	for (int i = 0; i < length; i++) {
		if (answers[i] == target[i]) {
			numberOfCollectAnswers++;
		}
	}

	return numberOfCollectAnswers;
}

// 총 점수(다 맞았을 경우의 점수)
int calculateScore(int numberOfCollectAnswers) {
	return numberOfCollectAnswers * 10;
}

// 출력 함수("정답 : 1, 2, 3, 4, 5, 1, 2, 3, 4, 5"와 같이 출력)
void printAnswers(char *who, const int target[], int length) {
	printf("%s : ", who);

	for (int i = 0; i < length; i++) {
		printf("%d\t", target[i]);
	}
}

// 학점을 구하는 함수(A+, A, B+, B 등)
// 첫번째 : 전체 점수, 두번째 : 95,90,85 등 학점 점수, 세번째 : 학점, 네번째 : 총 학점 개수
char* calculateGrade(int totalScore, const int scores[], const char *grades[], int length) {
	char *grade;

	for (int i = 0; i < length; i++) {
		if (totalScore >= scores[i]) {
			grade = malloc(sizeof(char) * strlen(grades[i])); // strlen : 문자열 길이
			strcpy(grade, grades[i]); // strcp : 문자열 복사
			break;
		}
	}

	return grade;
}

```
