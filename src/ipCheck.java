import java.util.Scanner;

public class IpCheck {
    public static void main(String[] args) {
        String symbol = "\\.";
        Scanner sc = new Scanner(System.in);
        String firstIp;
        String secondIp;
        String[] firstArr = new String[0];
        String[] secondArr = new String[0];
        boolean result = false;

        while (result == false) {
            firstIp = sc.next();
            firstArr = firstIp.split(symbol);
            if (result = checkIp(firstArr)) break;
            System.out.println("Неверно введён IP adress");
            System.out.println("верный формат х.х.х.х где х от 0 - 255");

        }
        result = false;

        while (result == false) {
            secondIp = sc.next();
            secondArr = secondIp.split(symbol);
            if (result = checkIp(secondArr)) break;
            System.out.println("Неверно введён IP adress");
            System.out.println("верный формат х.х.х.х где х от 0 - 255");

        }
        System.out.println(circle(firstArr, secondArr));

    }


    public static boolean checkIp(String[] ip) {
        String regex = "\\d+";
        boolean result = false;
        if (ip.length != 4) return false;

        for (int i = 0; i < ip.length; i++) {
            result = ip[i].matches(regex);
            if (result == false) return result;
            else if (Integer.parseInt(ip[i]) > 255 || Integer.parseInt(ip[i]) < 0) return false;
        }
        return result;

    }

    public static String circle(String[] firstIp, String[] secondIp) {
        String result = "";
        int[] a1 = new int[4];
        int[] a2 = new int[4];
        for (int i = 0; i < 4; i++) {
            a1[i] = Integer.parseInt(firstIp[i]);
            a2[i] = Integer.parseInt(secondIp[i]);
        }


        int max = 255;
        int max2 = 255;
        int max3 = 255;
        int min = a1[1];
        int min2 = a1[2];
        int min3 = a1[3] + 1;
        int count = 0;

        for (int i = 0; i < 4; i++) {
            a1[i] = Integer.parseInt(firstIp[i]);
            a2[i] = Integer.parseInt(secondIp[i]);
        }


        if ((a1[0] > a2[0])) result = "укажите ip адреса в ином порядке";
        else if ((a1[0] == a2[0]) && (a1[1] > a2[1])) result = "укажите ip адреса в ином порядке";
        else if (((a1[0] == a2[0]) && (a1[1] == a2[1])) && (a1[2] > a2[2])) result = "укажите ip адреса в ином порядке";
        else if (((a1[0] == a2[0]) && (a1[1] == a2[1])) && (a1[2] == a2[2]) && (a1[3]>a2[3])) result = "укажите ip адреса в ином порядке";
        else {

            for (int i = a1[0]; i <= a2[0]; i++) {

                if (i == a2[0]) count = 1;
                if (count == 1) max = a2[1];
                for (int j = min; j <= max; j++) {
                    if ((j == a2[1] && count == 1)) count = 2;
                    if (count == 2) max2 = a2[2];
                    for (int k = min2; k <= max2; k++) {
                        if ((k == a2[2] && count == 2)) count = 3;
                        if (count == 3) max3 = a2[3] - 1;
                        for (int l = min3; l <= max3; l++) {
                            System.out.println(i + "." + j + "." + k + "." + l);
                        }
                        min3 = 0;

                    }
                    min2 = 0;
                }
                min = 0;

            }
            result = "Операция выполнена успешно";


        }
        return result;
    }
}