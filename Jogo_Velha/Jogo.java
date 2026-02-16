package com.example.Demo.CodeWithoutSpring;
import java.util.Scanner;

public class Jogo {
    Scanner input = new Scanner(System.in);
    private final String JogadorO;
    private final String JogadorX;
    private boolean fim = true;
    protected String[][] Table = new String[3][3];
    {
        byte posicao = 0;
        for (int L = 0; L < Table.length; L++) {
            for (int C = 0; C < Table.length; C++) {
                Table[L][C] = "" + posicao;
                posicao++;
            }
        }
    }
    public Jogo(String jogadorO, String jogadorX) {
        this.JogadorO = jogadorO;
        JogadorX = jogadorX;
    }
    public void jogo() {
        System.out.println("Jogador O: " + JogadorO + ", Jogador X: " + JogadorX);
        System.out.println("Jogo da Velha: ");
        do {
            byte MarcarPosicao;
            mostrarTable();

            System.out.print("Jogador-O {" + JogadorO + "} Digita: ");
            MarcarPosicao = input.nextByte();
            preencherTable(MarcarPosicao, true);
            win();
            if (fim) {
                System.out.print("Jogador-X {" + JogadorX + "} Digita: ");
                MarcarPosicao = input.nextByte();
                preencherTable(MarcarPosicao, false);
                win();
            }

        } while (fim);

        input.close();
    }
    public void mostrarTable() {
        for (int L = 0; L < Table.length; L++) {
            for (int C = 0; C < Table.length; C++) {
                System.out.print(Table[L][C] + " ");
            }

            System.out.println();
        }
    }
    public void preencherTable(byte p, Boolean Player) {
        for (byte i = 0; i < Table.length; i++) {
            for (byte j = 0; j < Table.length; j++) {
                if (Table[i][j].equals(String.valueOf(p))) {
                    if (Player == true) {
                        if (!Table[i][j].equals("X")) {
                            Table[i][j] = "O";
                        }
                        break;
                    } else {
                        if (!Table[i][j].equals("O")) {
                            Table[i][j] = "X";
                        }
                    }
                    break;
                }
            }
        }
    }
    public void win(){
        for (int i = 0;i<3;i++){
            if (Table[i][0].equals("O") && Table[i][1].equals("O") && Table[i][2].equals("O")){
                mostrarTable();
                System.out.println('{' + JogadorO + '}' + "-Ganhou");
                fim = false;
            }else if (Table[i][0].equals("X") && Table[i][1].equals("X") && Table[i][2].equals("X")){
                mostrarTable();
                System.out.println('{' + JogadorX + '}' + "-Ganhou");
                fim = false;
            }

            if (Table[0][i].equals("O") && Table[1][i].equals("O") && Table[2][i].equals("O")){
                mostrarTable();
                System.out.println('{' + JogadorO + '}' + "Ganhou");
                fim = false;
            }else if (Table[0][i].equals("X") && Table[1][i].equals("X") && Table[2][i].equals("X")){
                mostrarTable();
                System.out.println('{' + JogadorX + '}' + "Ganhou");
                fim = false;
            }
        }
        if (Table[0][0].equals("O") && Table[1][1].equals("O") && Table[2][2].equals("O")){
            mostrarTable();
            System.out.println('{' + JogadorO + '}' + "Ganhou");
            fim = false;
        } else if (Table[0][0].equals("X") && Table[1][1].equals("X") && Table[2][2].equals("X")) {
            mostrarTable();
            System.out.println('{' + JogadorX + '}' + "Ganhou");
            fim = false;
        }
        if (Table[0][2].equals("O") && Table[1][1].equals("O") && Table[2][0].equals("O")) {
            mostrarTable();
            System.out.println('{' + JogadorO + '}' + "Ganhou");
            fim = false;
        } else if (Table[0][2].equals("X") && Table[1][1].equals("X") && Table[2][0].equals("X")) {
            mostrarTable();
            System.out.println('{' + JogadorX + '}' + "Ganhou");
            fim = false;
        }
        byte cont = 0;
        for (int i = 0;i < 3;i++){
            for (int j = 0;j<3;j++){
                if (Table[i][j].equals("O") || Table[i][j].equals("X")){
                    cont++;
                }
            }
        }
        if (cont == 9){
            System.out.println("velha");
            fim = false;
        }
    }
}