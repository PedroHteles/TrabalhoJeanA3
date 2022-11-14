import java.util.Scanner;

public class CustomScanner {

    private Scanner sc = new Scanner(System.in);

    public String scString(String msg,String nome) {
        System.out.println("digite "+msg+" "+nome+ ": ");
        return sc.next();
    }

    public Long scLong(String msg,String nome) {
        System.out.println("digite "+msg+" "+nome+ ": ");
        return sc.nextLong();
    }
    public Short scShort(String msg,String nome) {
        System.out.println("digite "+msg+" "+nome+ ": ");
        return sc.nextShort();
    }
    public Double scDouble(String msg,String nome) {
        System.out.println("digite "+msg+" "+nome+ ": ");
        return sc.nextDouble();
    }

    public int scInt(String msg,String nome) {
        System.out.println("digite "+msg+" "+nome+ ": ");
        return sc.nextInt();
    }

    public Short scStringMsgFull(String msg) {
        System.out.println(msg);
        return sc.nextShort();
    }
}
