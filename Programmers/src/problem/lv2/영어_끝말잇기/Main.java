package problem.lv2.영어_끝말잇기;

import java.util.Arrays;
import java.util.Stack;

public class Main {

    // 몇번째 사람의 몇번째 차례에 끝나는지 체크
    static void numOrderSetting(int[] arr, int i, int n) {
        // arr[0] = ((i + 1) % n == 0) ? n : (i + 1) % n;
        arr[0] = (i % n) + 1;
        // arr[1] = ((i + 1) % n == 0) ? ((i + 1) / n) : ((i + 1) / n) + 1;
        arr[1] = (i / n) + 1;
    }

    // 이웃한 단어의 끝말이 이어지는지, 끝말이 이어지면 중복되는 단어가 아닌지 체크
    static boolean neighborWordCheck(String[] arr, int[] a, int i, int n) {
        System.out.println(arr[i - 1]);
        System.out.println(arr[i]);
        if(arr[i].charAt(0) != arr[i - 1].charAt(arr[i - 1].length() - 1)) {
            numOrderSetting(a, i, n);
            return true;
        }
        else {
            // System.out.println(arr[i] + ": ");
            for(int j = 0; j < i; j++) {
                // System.out.print(arr[j] + " ");
                if(arr[j].equals(arr[i])) {
                    numOrderSetting(a, i, n);
                    return true;
                }
            }
            System.out.println();
            System.out.println();
        }
        return false;
    }

    public static void main(String[] args) {
        //사람의 수 n과 사람들이 순서대로 말한 단어 words 가 매개변수로 주어질 때,
        //가장 먼저 탈락하는 사람의 번호와 그 사람이 자신의 몇 번째 차례에 탈락하는지 리턴

        // int n = 3;
        // String[] words = {"tank", "kick", "know", 
        //                 "wheel", "land", "dream", 
        //                 "mother", "robot", "tank"};

        // int n = 5;
        // String[] words = {"hello", "observe", "effect", "take", "either", 
        //                 "recognize", "encourage", "ensure", "establish", "hang", 
        //                 "gather", "refer", "reference", "estimate", "executive"};

        int n = 2;
        String[] words = {"hello", "one", "even", "never", "now", "world", "draw"};

        
        System.out.println("단어 확인: " + Arrays.toString(words));
        
        int[] answer = new int[2];    //[번호, 차례]
        System.out.println(Arrays.toString(answer));
        
        boolean flag = false;
        // Stack<String> stack = new Stack<>();
        for(int i = 1; i < words.length; i++) {
            // System.out.println(i + "번째 단어: " + words[i - 1]);
            // System.out.println((i + 1) + "번째 단어: " + words[i]);
            // System.out.println(i + "번째 단어의 마지막 글자 : " + words[i - 1].charAt(words[i - 1].length() - 1));
            // System.out.println((i + 1) + "번째 단어의 첫번째 글자 : " + words[i].charAt(0));
            // System.out.println("위의 둘은 같은가?: " + (words[i].charAt(0) == words[i - 1].charAt(words[i - 1].length() - 1)));

            // if(words[i].charAt(0) != words[i - 1].charAt(words[i - 1].length() - 1)) {
            //     // System.out.println((i + 1) + "번째 단어는 틀렸습니다. 끝말잇기를 종료합니다.");
            //     // answer[0] = ((i + 1) % n == 0) ? n : (i + 1) % n;
            //     // answer[1] = ((i + 1) % n == 0) ? ((i + 1) / n) : ((i + 1) / n) + 1;
            //     numOrderSetting(answer, i, n);
            //     break;
            //     // System.out.println(words[i]);
            // } 
            // else {
            //     // System.out.println(i + "번째 단어는 맞았습니다. 끝말잇기를 속행합니다.");
            //     // System.out.println(words[i]);
            //     for(int j = 0; j < i; j++) {
            //         if(words[j].equals(words[i])) {
            //             // answer[0] = ((i + 1) % n == 0) ? n : (i + 1) % n;
            //             // answer[1] = ((i + 1) % n == 0) ? ((i + 1) / n) : ((i + 1) / n) + 1;
            //             numOrderSetting(answer, i, n);
            //             break;
            //         }
            //     }
            // }
            // System.out.println();
            flag = neighborWordCheck(words, answer, i, n);
            if(flag) break;
        }

        // System.out.println("스택 확인: " + stack);
        if(answer[0] == 0 && answer[1] == 0) {
            System.out.println("끝말잇기가 정상종료됨");
        } else {
            System.out.println(answer[0] + "번째 사람의 " + answer[1] + "번째 차례에 끝남");
        }
    
    }
}
