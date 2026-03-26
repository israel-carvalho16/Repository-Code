//Versão 0.02-Incompleto
package com.example.Demo.CodeWithoutSpring;
import java.util.Scanner;

public class Jogo {
    //Atributos do jogo:
    Scanner input = new Scanner(System.in);
    private final String JogadorO;
    private final String JogadorX;
    private Boolean Player = true;
    private boolean fim = true;
    protected String[][] Table = new String[3][3];

    //quando a classe for instanciada esse bloco aqui vai roda primeiro e preecher a tabela igual no jogo da velha
    {
        int posicao = 0;
        for (int L = 0; L < Table.length; L++) {
            for (int C = 0; C < Table.length; C++) {
                Table[L][C] = "" + posicao;
                posicao++;
            }
        }
    }
    //Aqui eu faço um metodo para os participantes preecherem o seus nomes
    public Jogo(String jogadorO, String jogadorX) {
        this.JogadorO = jogadorO;
        JogadorX = jogadorX;
    }
    //Aqui é onde irá roda o jogo

    //metodo para mostra a tabela de Strings onde cada posição terá seu número
    public void mostrarTable() {
        for (int L = 0; L < Table.length; L++) {
            for (int C = 0; C < Table.length; C++) {
                System.out.print(Table[L][C] + " ");
            }

            System.out.println();
        }
    }
    //esse metodo permite que os jogadores preencham os respectivos índices da tabela
    //ele irá percorre e  verificar se o valor digitado pelo jogador existe no índices da tabela
    public void preencherTable(int p) {
        for (byte i = 0; i < Table.length; i++) {
            for (byte j = 0; j < Table.length; j++) {
                if (Table[i][j].equals(String.valueOf(p))) {
                    if (Player == true) {
                        if (!Table[i][j].equals("X") || p < 8 || Table[i][j].equals("O")) {
                            Table[i][j] = "O";
                            Player = false;
                        }else{
                            Player = true;
                        }
                        break;
                    } else {
                        if (!Table[i][j].equals("O") || p < 8 || Table[i][j].equals("X")) {
                            Table[i][j] = "X";
                            Player = true;
                        }else {
                            Player = false;
                        }
                    }
                    break;
                }
            }
        }
    }
    //metodo para vericar qual jogador Ganhou
    public void win(){
        //Aqui verifica na horizontal
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

            //aqui verifica na vertical
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

        //Aqui verifica nas diagonais
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

        //Aqui verifica se deu velha ou seja empate
        byte cont = 0;
        for (int i = 0;i < 3;i++){
            for (int j = 0;j<3;j++){
                if (Table[i][j].equals("O") || Table[i][j].equals("X")){
                    cont++;
                }
            }
        }
        if (cont == 8 && fim){
            mostrarTable();
            System.out.println("velha");
            fim = false;
        }
    }

    public void jogo() {
        //Apresentação dos jogadores
        System.out.println("Jogador O: " + JogadorO + ", Jogador X: " + JogadorX);
        System.out.println("Jogo da Velha: ");
        do {
            int MarcarPosicao;
            mostrarTable();

            //esse IF serve quando o metodo win retorna False indica que o jogador-O já Ganhou senão o jogador-X irá poder jogar
            if (fim || Player) {
                System.out.print("Jogador-O {" + JogadorO + "} escolhe a posição dos respectivos numeros: ");
                MarcarPosicao = input.nextByte();
                preencherTable(MarcarPosicao);
                win();
            }else{
                System.out.print("Jogador-X {" + JogadorX + "} escolhe a posição dos respectivos numeros: ");
                MarcarPosicao = input.nextByte();
                preencherTable(MarcarPosicao);
                win();
            }

        } while (fim);

        input.close();
    }
}