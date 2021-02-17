import java.util.Scanner;
import java.util.LinkedList;
import java.util.Queue;

public class Queue2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Queue<Integer> queue = new LinkedList<>();

        int cnt = sc.nextInt();
        for(int i=0 ; i<cnt ; i++){
            String command = sc.next();
            switch(command){
                case 'push':
                    int x = sc.nextInt();
                    queue.add(x);
                    break;
                case 'pop':
                    queue.remove();
                    break;
                case 'size':
                    System.out.println(queue.size());
                    break;
                case 'empty':
                    System.out.println(queue.isEmpty());
                    break;
                case 'front':
                    System.out.println(queue.getFi());
            }
        }
    }
}