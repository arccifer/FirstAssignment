 

/**
 * Created by Yang on 1/23/20.
 */
public class StringArrayUtils {
    /**
     * @param array array of String objects
     * @return first element of specified array
     */ // TODO
    public static String getFirstElement(String[] array) {
        return array[0];
    }

    /**
     * @param array array of String objects
     * @return second element in specified array
     */
    public static String getSecondElement(String[] array) {
        return array.length>1?array[1]:null;
    }

    /**
     * @param array array of String objects
     * @return last element in specified array
     */ // TODO
    public static String getLastElement(String[] array) {
        return array[array.length-1];
    }

    /**
     * @param array array of String objects
     * @return second to last element in specified array
     */ // TODO
    public static String getSecondToLastElement(String[] array) {
        return array[array.length-2];
    }

    /**
     * @param array array of String objects
     * @param value value to check array for
     * @return true if the array contains the specified `value`
     */ // TODO
    public static boolean contains(String[] array, String value) {
        for (String str: array) {
            if(str.equals(value)){
                return true;
            }
        }
        return false;
    }

    /**
     * @param array of String objects
     * @return an array with identical contents in reverse order
     */ // TODO
    public static String[] reverse(String[] array) {
        String[] res = new String[array.length];
        for(int i=0; i<array.length; i++){
            res[array.length-1-i] = array[i];
        }
        return res;
    }

    /**
     * @param array array of String objects
     * @return true if the order of the array is the same backwards and forwards
     */ // TODO
    public static boolean isPalindromic(String[] array) {
        int i=0, j=array.length-1;
        while (i<j){
            if (array[i].equals(array[j])==false){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

    /**
     * @param array array of String objects
     * @return true if each letter in the alphabet has been used in the array
     */ // TODO
    public static boolean isPangramic(String[] array) {
        boolean[] temp = new boolean[26];
        int res=26;
        for(String str: array){
            for(int i=0;i<str.length();i++){
                int c = str.charAt(i);
                if(c>=97 && c<=122){
                    if (temp[c-97]==false){
                        temp[c-97]=true;
                        res--;
                    }
                }
                else if(c>=65 && c<=90){
                    if (temp[c-65]==false){
                        temp[c-65]=true;
                        res--;
                    }
                }
            }
        }
        return res<1;
    }

    /**
     * @param array array of String objects
     * @param value value to check array for
     * @return number of occurrences the specified `value` has occurred
     */ // TODO
    public static int getNumberOfOccurrences(String[] array, String value) {
        int res = 0;
        for (String str: array){
            if(str == value){
                res++;
            }
        }
        return res;
    }

    /**
     * @param array         array of String objects
     * @param valueToRemove value to remove from array
     * @return array with identical contents excluding values of `value`
     */ // TODO
    public static String[] removeValue(String[] array, String valueToRemove) {
        int num=0;
        for (String str: array){
            if(str != valueToRemove){
                num++;
            }
        }
        String[] res = new String[num];
        int i = 0;
        for (String str: array){
            if(str != valueToRemove){
                res[i] = str;
                i++;
            }
        }
        return res;
    }

    /**
     * @param array array of chars
     * @return array of Strings with consecutive duplicates removes
     */ // TODO
    public static String[] removeConsecutiveDuplicates(String[] array) {
        if (array.length==0){
            return new String[0];
        }
        int[] temp = new int[array.length-1];
        int x = 0;
        for (int i=1; i<array.length; i++){
            if (array[i] != array[i-1]){
                temp[x]=i;
                x++;
            }
        }
        String[] res = new String[x+1];
        res[0]=array[0];
        for (int i=0;i<temp.length;i++){
            if(temp[i]==0){
                break;
            }
            res[i+1]=array[temp[i]];
        }
        return res;
    }

    /**
     * @param array array of chars
     * @return array of Strings with each consecutive duplicate occurrence concatenated as a single string in an array of Strings
     */ // TODO
    public static String[] packConsecutiveDuplicates(String[] array) {
        if (array.length==0){
            return new String[0];
        }
        int[] temp = new int[array.length-1];
        int x = 0;
        for (int i=1; i<array.length; i++){
            if (array[i] != array[i-1]){
                temp[x]=i;
                x++;
            }
        }
        String[] res = new String[x+1];
        res[0]=array[0].repeat(temp[0]);
        for (int i=0; i<temp.length; i++){
            if(temp[i+1]==0){
                res[i+1]=array[temp[i]].repeat(array.length-temp[i]);
                break;
            }
            res[i+1]=array[temp[i]].repeat(temp[i+1]-temp[i]);
        }
        return res;
    }
}
