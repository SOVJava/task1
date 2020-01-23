import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class Main {

    private static double min (ArrayList<Integer> arr){
        double res = Double.MAX_VALUE;
        for (int i = 0; i < arr.size(); i++) {
            if ((double)arr.get(i)<res)
                res = (double)arr.get(i);
        }
        return res;
    }

    private static double max (ArrayList<Integer> arr){
        double res = Double.MIN_VALUE;
        for (int i = 0; i < arr.size(); i++) {
            if ((double)arr.get(i)>res)
                res = (double)arr.get(i);
        }
        return res;
    }

    private static double srednee (ArrayList<Integer> arr){
        double res = 0;
        int count = 0;
        for (int i = 0; i < arr.size(); i++) {
            res += (double)arr.get(i);
            count++;
        }
        return res/count;
    }

    private static double mediana (ArrayList<Integer> arr){
        return  (max(arr) + min(arr))/2;
    }

    private static double procentil(ArrayList<Integer> arr) {
        ArrayList<Integer> res = new ArrayList<>(arr);
        int count = 0;
        for (int i = 0; i < arr.size(); i++) {
            if (arr.get(i) != min(arr))
                count++;
        }
        res.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return Integer.compare(o1,o2);
            }
        });

        return ((double)90/(double)100)*(double) count+1;
    }

    public static void main(String[] args) {

        File file = new File("test1.txt");
        Scanner sc = null;
        try {
            sc = new Scanner(file);
        } catch (FileNotFoundException e) {
            System.out.println("Файла нет");
        }
        ArrayList<Integer> res = new ArrayList<>();
        while (sc.hasNextLine()){
            res.add(Integer.parseInt(sc.nextLine()));
        }
        sc.close();

        double minValue = min(res);
        double maxValue = max(res);
        double srednee = srednee(res);
        double median = mediana(res);
        double proc = procentil(res);

        System.out.printf("%.2f\n",proc);
        System.out.printf("%.2f\n",median);
        System.out.printf("%.2f\n",maxValue);
        System.out.printf("%.2f\n",minValue);
        System.out.printf("%.2f\n",srednee);

    }
}
