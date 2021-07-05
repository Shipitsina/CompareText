public class Main {
    public static void main(String [] args){
        String [] array1 = { "Execute A"
                ,"Execute B"
                ,"Loop"
                ,"Execute C"
                ,"End Loop"
                ,"Execute A"
                ,"Execute B"
        };
        String [] array2 = { "Execute A"
                ,"If"
                ,"Execute D"
                ,"Begin"
                ,"Execute C"
                ,"End"
                ,"End If"
                ,"Execute B"
        };
        String [] array3 = {  "Execute A"
                ,"If"
                ,"Begin"
                ,"Begin"
                ,"Loop"
                ,"Execute C"
                ,"End Loop"
                ,"End"
                ,"End"
                ,"End If"
                ,"Execute B"
        };
        String [] array4 = {  "Execute A"
                ,"Execute B"
                ,"Loop"
                ,"Execute A"
                ,"Execute B"
                ,"Loop"
                ,"Execute C"
                ,"Execute D"

        };
        String [] array5 = {"Execute A"
                ,"Execute B"
                ,"Loop"
                ,"Execute A"
                ,"Execute B"
                ,"If"
                ,"Execute C"
                ,"Execute D"
                ,"End Loop"
                ,"End If"	 };


        System.out.println(compareArray(array1));
        System.out.println(compareArray(array2));
        System.out.println(compareArray(array3));
        System.out.println(compareArray(array4));
        System.out.println(compareArray(array5));
    }
    public static boolean compareArray(String [] array) {
        String[][] blocks = {{"Loop", "End Loop"},
                {"If", "End If"},
                {"Begin", "End"}};
        String [] begins = new String[array.length];
        String [] ends = new String[array.length];
        boolean b = false;
        int countBegins = 0;
        int countEnds = 0;

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < blocks.length; j++) {
                if (array[i].equals(blocks[j][0])) {
                    begins[countBegins] = array[i];
                    countBegins++;
                    break;
                }
                if (array[i].equals(blocks[j][1])) {
                    ends[countEnds] = blocks[j][0];
                    countEnds++;
                    break;
                }
            }
        }
        if (countBegins != countEnds) return false;
        else {
            for (int i = 0; i < countBegins; i++) {
                if (begins[i].equals(ends[countBegins-i-1]))
                    return true;
                }
            }
            return false;
        }
}
