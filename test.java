public class test {
    public static void main(String[] args) {
        int i = 0;
        int j = 0;
        try {
            while (i < 10) {
                i++;
            }
            while (j < 10) {
                System.out.println("hey");
                j++;
            }
        }
        finally {
            System.out.println("finally");
        }
    }
}