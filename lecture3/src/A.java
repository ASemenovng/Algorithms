public class A {
    int a = 0;

    public static void main(String[] args) {
        A a = new A();
        a.d();
        System.out.println(a.a);
    }

    public void d(){
        this.a ++;
    }
}
