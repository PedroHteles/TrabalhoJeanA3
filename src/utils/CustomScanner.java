package utils;

import java.util.Scanner;

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

    public Short scStringMsgFull(String msg) {
        Scanner sc = new Scanner(System.in);
        try {
            System.out.println(msg);
            return sc.nextShort();
        } catch (Exception e) {
            System.out.println("Digite um valor valido!!");
            return this.scStringMsgFull(msg);
        }
    }
}
