/* 
Queue 라이브러리를 사용하지 않고 구현
*/

import java.util.Scanner;

class Queue {
    private int[] queue;
    private int frontIndex = 0;
    private int backIndex = 0;

    Queue(int cnt) {
        queue = new int[cnt];
    }

    // 정수 x를 큐에 넣는 연산
    public void push(int x) {
        queue[backIndex] = x;
        backIndex++;
    }

    // 큐에서 가장 앞에 있는 정수를 빼고, 그 수를 출력한다.(정수가 없는 경우 -1을 출력)
    public int pop() {
        if (isEmpty()) {
            return -1;
        } else {
            return queue[frontIndex++];
        }
    }

    // 큐에 있는 정수 개수
    public int size() {
        return backIndex - frontIndex;
    }

    // 큐가 비어있으면 1, 아니면 0을 출력한다.
    public boolean isEmpty() {
        return ((size() == 0) ? true : false);
    }

    public int front() {
        return (isEmpty() ? -1 : queue[frontIndex]);
    }

    public int back() {
        return (isEmpty() ? -1 : queue[backIndex - 1]);
    }

}

public class Queue1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int cnt = sc.nextInt();
        Queue queue = new Queue(cnt);
        for (int i = 0; i < cnt; i++) {
            String command = sc.next();
            switch (command) {
                case "push" -> {
                    int num = sc.nextInt();
                    queue.push(num);
                }
                case "pop" -> System.out.println(queue.pop());
                case "size" -> System.out.println(queue.size());
                case "empty" -> System.out.println(queue.isEmpty());
                case "front" -> System.out.println(queue.front());
                case "back" -> System.out.println(queue.back());
                default -> System.out.println("명령어를 잘못입력하였습니다.");
            }
        }
    }
}