package com.company;

import java.util.Scanner;

public class Main {
      static void divisors(int n) {
          int i;
          for ( i = 1; i * i < n; i++) {
              if (n % i == 0) {
                  System.out.println(i);
              }
          }
                  for(; i>= 1; i--) {
                      if (n % i == 0) {
                          System.out.println(n / i);
                      }
                  }
              }

          public static void main(String[] args) {
	Scanner sc=new Scanner(System.in);
        System.out.println("Enter The Number");
	int s=sc.nextInt();
	Main.divisors(s);
    }
}
