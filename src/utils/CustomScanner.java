package utils;
import java.text.SimpleDateFormat;
import java.util.Scanner;
import java.util.Date;
import java.util.Scanner;
import java.text.DateFormat;
public class CustomScanner {

    public String scString(String msg) {
        Scanner sc = new Scanner(System.in);
        try {
            System.out.println(msg);
            return sc.next();
        } catch (Exception e) {
            System.out.println("Digite um valor valido !!");
            return this.scString(msg);
        }
    }

    public Long scLong(String msg) {
        Scanner sc = new Scanner(System.in);
        try {
            System.out.println(msg);
            return sc.nextLong();
        } catch (Exception e) {
            System.out.println("Digite um numero valido!!");
            return this.scLong(msg);
        }

    }

    public Short scShort(String msg) {
        Scanner sc = new Scanner(System.in);
        try {
            System.out.println(msg);
            return sc.nextShort();
        } catch (Exception e) {
            System.out.println("Digite um numero valido!!");
            return this.scShort(msg);
        }
    }

    public Double scDouble(String msg) {
        Scanner sc = new Scanner(System.in);
        try {
            System.out.println(msg);
            return sc.nextDouble();
        } catch (Exception e) {
            System.out.println("Digite um numero valido!!");
            return this.scDouble(msg);
        }
    }

    public int scInt(String nome) {
        System.out.println(nome);
        Scanner sc = new Scanner(System.in);
        try {
            return sc.nextInt();
        } catch (Exception e) {
            System.out.println("Digite um numero valido!!");
            return this.scInt(nome);
        }
    }

    public Date scData(String msg) {
        System.out.println(msg);
        Scanner sc = new Scanner(System.in);
        try {

            System.out.println("Data no formato dd/MM/yyyy");
            DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
            Date dt = df.parse(sc.next());

            return dt;

        } catch (Exception e) {
            System.out.println("Digite um numero valido!!");
            return this.scData(msg);
        }
    }
}
