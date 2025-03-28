public class whatsTheOutputQuestions {
    public static void main(String[] args) {
      //1.
        int a = 5;
        int b = 10;
        if((a = 3) == b){
            System.out.println("a value"+ a);
        }else {
            System.out.println("a + b"+ (a + b ));
        }
        // out put will be 3 + 10 because while if it assigns a to 3

        //2.
        int a1 = 0;
        System.out.println("value"+ (a1++ == ++a1));
        // a++ is post increment so before == it'll be  0  and after that it'll be 1 ,
        // pre increment ++a where a is already 1 it'll become 2  0 ==2 false
        System.out.println(a1++ + ++ a1);
        // it'll add 0 + 2 = 2

        //3.
        try {
            int b1 = 10 / 0;

        }catch (Exception e){
            System.out.println("exception");
        }finally {
            System.out.println("finally ");
        }
        // exception and finally gets printed

        //4.
        String str = null;
        System.out.println(str instanceof String);  // false

        //5.
        int c =10;
        System.out.println(a += (a = 5) * (a /5));
        //first (a = 5 gets evaluated) then a /5 the (a = 5) * a /5 the a+= 5 so itll be 15

        //6.
        String  string = "Java";
        String s2 = "Ja" +"va";
        System.out.println(string == s2); // true

        //7.
        int[] ints = new int[5];
        System.out.println(ints[0]);

        //8
        Integer num = 200;
        Integer num2 = 200;
        int num3 = 200;
        int num4 =  200;
        System.out.println(num == num2); // false becauseInteger caches till -128 to 127 means re uses
        System.out.println(num3 == num4); // true

    }
}
