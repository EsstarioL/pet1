import java.util.Scanner;

public class ipCheck {
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
//        finalResult(firstArr,secondArr);
        circle(firstArr,secondArr);

    }

    public static void finalResult(String[] firstIp, String[] secondIp) {
        int[] a1 = new int[4];
        int[] a2 = new int[4];
        String message = "";
        for (int i = 0; i < 4; i++) {
            a1[i] = Integer.parseInt(firstIp[i]);
            a2[i] = Integer.parseInt(secondIp[i]);
        }
        if ((a1[0] == a2[0]) && (a1[1] == a2[1]) && (a1[2] == a2[2]) && (a1[3] == a2[3])) System.out.println("В введённом диапазоне нет других ip адресов");
        else if ((a1[0] == a2[0]) && (a1[1] == a2[1]) && (a1[2] == a2[2]) && (a1[3] != a2[3])) {
            for (int i = a1[3]+1; i < a2[3]; i++) {
                System.out.println(a1[0]+"."+a1[1]+"."+a1[2]+"."+i);
            }
        }

//        for (int i = a1[0]; i <= a2[0]; i++) {
//            if (i < a2[0]) message+=i+".";
//            else {message+=a1[0]+".";
//                i+=2;}
//            for (int j = a1[1]; j <= a2[1]; j++) {
//                if (j < a2[1] ) message+=j+".";
//                else {message+=a1[1]+"."; j+=2;}
//                for (int k = a1[2]; k <= a2[2]; k++) {
//                    if (k < a2[2] ) message+=k+".";
//                    else {message+=a1[2]+"."; k+=2;};
//                    for (int l = a1[3]; l <= a2[3]; l++) {
//                        if (l < a2[3] ) System.out.println(message+l);
//                        else {message+=a1[3]; l+=2;}
//
//                    }
//
//                }
//            }
//
//
//                }

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
    public static void circle (String[] firstIp, String[] secondIp){
        int[] a1 = new int[4];
        int[] a2 = new int[4];
        int max = 255;
        int min = 0;
        String message = "";
        for (int i = 0; i < 4; i++) {
            a1[i] = Integer.parseInt(firstIp[i]);
            a2[i] = Integer.parseInt(secondIp[i]);
        }
        for (int i = a1[0]; i <= a2[0]; i++) {
            for (int j = a1[1]; j <= a2[1]; j++) {
                for (int k = a1[2]; k <= a2[2]; k++) {
                    if (k == a1[2]) {
                        min = a1[3]+1;
                    }
                    if (k == a2[2]) {
                        max = a2[3]-1;
                    }
                    for (int l = min; l <= max; l++) {



                        System.out.println(i+"."+j+"."+k+"."+l);
                    }
                    min=0;
                }
            }
        }
    }



}
