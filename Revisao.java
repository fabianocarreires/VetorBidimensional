
package revisao;

import java.util.Random;
import java.util.Scanner;

public class Revisao {

    static Random random = new Random();
    static int[][] matriz = new int[10][10];
    static int[][] matrizAux = new int[10][10];
    static Scanner entrada;

    public static void main(String[] args) {

        int opcao = 0;

        for (int l = 0; l < 10; l++) {
            for (int c = 0; c < 10; c++) {
                matriz[l][c] = random.nextInt(8) + 1;                
            }
        }
        do {
            for (int l = 0; l < 10; l++) {
                for (int c = 0; c < 10; c++) {
                    matrizAux[l][c] = 0;
                }
            }
            entrada = new Scanner(System.in);
            menu();
            opcao = entrada.nextInt();

            if (opcao == 1) {
                DP();
            }
            if (opcao == 2) {
                DS();
            }
            if (opcao == 3) {
                acDP();
            }
            if (opcao == 4) {
                abDP();
            }
            if (opcao == 5) {
                acDS();
            }
            if (opcao == 6) {
                abDS();
            }
            if (opcao == 7) {
                todos();
            }
        } while (opcao != 8);        
    }

    public static void menu() {
        System.out.println("=== Escolha uma das opções === ");
        System.out.println("1. Diagonal principal (DP)");
        System.out.println("2. Diagonal secundária (DS)");
        System.out.println("3. Elementos acima da DP");
        System.out.println("4. Elementos abaixo da DP");
        System.out.println("5. Elementos acima da DS");
        System.out.println("6. Elementos abaixo da DS");
        System.out.println("7. Todos os elementos da matriz");
        System.out.println("8. Sair do programa");
        System.out.println("Digite o número da opção escolhida: ");
    }

    public static void DP() {
        int DP = 0;
        for (int l = 0; l < 10; l++) {
            for (int c = 0; c < 10; c++) {
                if (l == c) {
                    DP = DP + matriz[l][c];
                    matrizAux[l][c] = matriz[l][c];
                }
                if (matrizAux[l][c] == 0) {
                    System.out.print("[ ]");
                } else {
                    System.out.print("[" + matriz[l][c] + "]");
                }
            }
            System.out.print("\n");
        }
        System.out.println("\nA soma dos elementos da diagonal principal é: " + DP + "\n");
    }

    public static void DS() {
        int DS = 0, n = 10;
        for (int l = 0; l < 10; l++) {
            for (int c = 0; c < 10; c++) {
                if (l + c == n - 1) {
                    DS = DS + matriz[l][c];
                    matrizAux[l][c] = matriz[l][c];
                }
                if (matrizAux[l][c] == 0) {
                    System.out.print("[ ]");
                } else {
                    System.out.print("[" + matriz[l][c] + "]");
                }
            }
            System.out.print("\n");
        }
        System.out.println("\nA soma dos elementos da diagonal secundária é: " + DS + "\n");
    }

    public static void acDP() {
        int acDP = 0;
        for (int l = 0; l < 10; l++) {
            for (int c = 0; c < 10; c++) {
                if (l < c) {
                    acDP = acDP + matriz[l][c];
                    matrizAux[l][c] = matriz[l][c];
                }
                if (matrizAux[l][c] == 0) {
                    System.out.print("[ ]");
                } else {
                    System.out.print("[" + matriz[l][c] + "]");
                }
            }
            System.out.print("\n");
        }
        System.out.println("\nA soma dos elementos acima da diagonal principal é: " + acDP + "\n");
    }

    public static void abDP() {
        int abDP = 0;
        for (int l = 0; l < 10; l++) {
            for (int c = 0; c < 10; c++) {
                if (l > c) {
                    abDP = abDP + matriz[l][c];
                    matrizAux[l][c] = matriz[l][c];
                }
                if (matrizAux[l][c] == 0) {
                    System.out.print("[ ]");
                } else {
                    System.out.print("[" + matriz[l][c] + "]");
                }
            }
            System.out.print("\n");
        }
        System.out.println("\nA soma dos elementos abaixo da diagonal principal é: " + abDP + "\n");
    }

    public static void acDS() {
        int acDS = 0, n = 10;
        for (int l = 0; l < 10; l++) {
            for (int c = 0; c < 10; c++) {
                if (l + c < n - 1) {
                    acDS = acDS + matriz[l][c];
                    matrizAux[l][c] = matriz[l][c];
                }
                if (matrizAux[l][c] == 0) {
                    System.out.print("[ ]");
                } else {
                    System.out.print("[" + matriz[l][c] + "]");
                }
            }
            System.out.print("\n");
        }
        System.out.println("\nA soma dos elementos acima da diagonal secundária é: " + acDS + "\n");
    }

    public static void abDS() {
        int abDS = 0, n = 10;
        for (int l = 0; l < 10; l++) {
            for (int c = 0; c < 10; c++) {
                if (l + c > n - 1) {
                    abDS = abDS + matriz[l][c];
                    matrizAux[l][c] = matriz[l][c];
                }
                if (matrizAux[l][c] == 0) {
                    System.out.print("[ ]");
                } else {
                    System.out.print("[" + matriz[l][c] + "]");
                }
            }
            System.out.print("\n");
        }
        System.out.println("\nA soma dos elementos abaixo da diagonal secundária é: " + abDS + "\n");
    }

    public static void todos() {
        int soma = 0;
        for (int l = 0; l < 10; l++) {
            for (int c = 0; c < 10; c++) {

                soma = soma + matriz[l][c];

                System.out.print("[" + matriz[l][c] + "]");
            }
            System.out.print("\n");
        }
        System.out.println("\nA soma de todos os elementos da matriz é: " + soma + "\n");
    }

}
