package week1;
public class getRemainder {
    public int numerator;
    public int denominator;
    private int remainder;

    public getRemainder(int a, int b) {
        numerator = a;
        denominator = b;
        if(denominator==0) throw new IllegalArgumentException("Cannot divide by 0.");
        remainder=a%b;
    }

    public void eqClasses(int modulus, int range) {
        int[] eqClasses = new int[modulus];
        StringBuilder builder = new StringBuilder();
        String w = "%d";
        for(int i=modulus-1;i>0;i--) {
            eqClasses[i] = 2 * i;
        }
        while (modulus>0) {
            modulus--;
            for (int k = 0; k < range; k++) {
                System.out.printf("\n[%d] : {" + w + "}", modulus, eqClasses[k]);
                w = builder.append(",%d").toString();
            }
        }
    }

    public int getRemainder() {
        return remainder;
    }
}
