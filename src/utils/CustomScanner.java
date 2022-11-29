package utils;

import java.util.Scanner;

public class CustomScanner {

    protected String scString(String msg) {
        Scanner sc = new Scanner(System.in);
        try {
            System.out.println(msg);
            return sc.next();
        } catch (Exception e) {
            System.out.println("Digite um valor valido !!");
            return this.scString(msg);
        }
    }

    protected Long scLong(String msg) {
        Scanner sc = new Scanner(System.in);
        try {
            System.out.println(msg);
            return sc.nextLong();
        } catch (Exception e) {
            System.out.println("Digite um numero valido!!");
            return this.scLong(msg);
        }

    }

    protected Short scShort(String msg) {
        Scanner sc = new Scanner(System.in);
        try {
            System.out.println(msg);
            return sc.nextShort();
        } catch (Exception e) {
            System.out.println("Digite um numero valido!!");
            return this.scShort(msg);
        }
    }

    protected Double scDouble(String msg) {
        Scanner sc = new Scanner(System.in);
        try {
            System.out.println(msg);
            return sc.nextDouble();
        } catch (Exception e) {
            System.out.println("Digite um numero valido!!");
            return this.scDouble(msg);
        }
    }

    protected int scInt(String nome) {
        System.out.println(nome);
        Scanner sc = new Scanner(System.in);
        try {
            return sc.nextInt();
        } catch (Exception e) {
            System.out.println("Digite um numero valido!!");
            return this.scInt(nome);
        }
    }

    protected Short scStringMsgFull(String msg) {
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
