import java.util.*;
import static java.lang.Math.*;

public class SpeSkillTest {
    private static int countDigits(int number) {
        if (number == 0)
            return 0;
        return 1 + countDigits(number / 10);
    }

    private static boolean isNarcissistic(int number) {
        int power = countDigits(number);
        int n = number;
        int sum = 0;
        while (n > 0) {
            sum += pow(n % 10, power);
            n = n / 10;
        }
        return (number == sum);
    }

    private static int parityOutlier(int[] array) {
        int oddCount = 0;
        for (int n : array) {
            if (n % 2 != 0) {
                oddCount += 1;
            }
        }

        if (oddCount == 1) {
            for (int n : array) {
                if (n % 2 != 0) {
                    return n;
                }
            }
        } else {
            for (int n : array) {
                if (n % 2 == 0) {
                    return n;
                }
            }
        }

        return 0;
    }

    private static int haystack(String[] array,String search) {
        int find = 0;

        for (int index = 0;index<array.length;index++) {
            if(array[index].equalsIgnoreCase(search) == true) {
                find =  index;
                return find;
            }
        }

        return 0;
    }

    private static ArrayList blueOcean(int[] array,int[] arrayRemove) {
        ArrayList<Integer> result = new ArrayList<>();
        boolean find = false;
        for(int index = 0; index<array.length;index++) {
            for(int indexRemove = 0;indexRemove<arrayRemove.length;indexRemove++) {
                if(array[index] == arrayRemove[indexRemove]) {
                    find = true;
                }
            }

            if(find == false) {
                result.add(array[index]); 
            } else {
                find = false;
            }
        }

        return result;
    }

    public static void main(String args[]) {
        // NARCISSISTIC NUMBER
        System.out.println(isNarcissistic(153));
        System.out.println(isNarcissistic(111));

        // PARITY OUTLIER
        int[] test1PO = new int[]{2, 4, 0, 100, 4, 11, 2602, 36}; 
        int[] test2PO = new int[]{160, 3, 1719, 19, 11, 13, -21}; 
        int[] test3PO = new int[]{11, 13, 15, 19, 9, 13, -21}; 
        if (parityOutlier(test1PO) == 0) {
            System.out.println(false);
        } else {
            System.out.println(parityOutlier(test1PO));
        }

        if (parityOutlier(test2PO) == 0) {
            System.out.println(false);
        } else {
            System.out.println(parityOutlier(test2PO));
        } 

        if (parityOutlier(test3PO) == 0) {
            System.out.println(false);
        } else {
            System.out.println(parityOutlier(test3PO));
        }

        // NEEDLE IN THE HAYSTACK
        String[] test1H = new String[]{"red", "blue", "yellow", "black", "grey", "blue"};
        System.out.println(haystack(test1H, "blue"));
        
        // 

        int[] test1BO = new int[]{1,2,3,4,6,10};
        int[] remove1BO = new int[]{1};
        int[] test2BO = new int[]{1,5,5,5,5,3};
        int[] remove2BO = new int[]{5};
        System.out.println(blueOcean(test1BO, remove1BO));
        System.out.println(blueOcean(test2BO, remove2BO));
    }
}