import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class BJ2635 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int firstNum = Integer.parseInt(br.readLine());

        int max = 0;
        ArrayList<Integer> answer = new ArrayList<>();
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = firstNum; i > 0; i--) {
            int cnt = 2;
            int secondNum = i;
            int target = firstNum - secondNum;
            list.clear();
            list.add(firstNum);
            list.add(secondNum);

            while (target >= 0) {
                list.add(target);
                target = list.get(list.size() - 2) - list.get(list.size() - 1);
                cnt++;
            }

            if (max < cnt) {
                max = cnt;
                answer.clear();
                for (int n : list)
                    answer.add(n);
            }
        }

        System.out.println(max);
        for (int n : answer)
            System.out.print(n + " ");
        System.out.println();
    }

}