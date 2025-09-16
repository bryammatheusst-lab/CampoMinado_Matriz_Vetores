import java.util.Random;
import java.util.Scanner;

public class CampoMinado {
    public static void main(String[] args) {

        int linha = 10;
        int coluna = 10;
        Random sortear = new Random();

        char[][] campo = new char[linha][coluna];

        for (int i= 0; i < linha; i++){

            for (int j= 0; j < coluna; j++){
                campo[i][j] = '*';
                System.out.print(" * ");
            }

            System.out.println(" ");
        }

        Scanner sc = new Scanner(System.in);

        System.out.println("Quantas bombas vamos adicionar?");
        int quantidade = sc.nextInt();

        int plantada = 0;

        while(plantada < quantidade){

            int linhaSorteio = sortear.nextInt(linha);
            int colunaSorteio = sortear.nextInt(coluna);

            char valorPosicao = campo[linhaSorteio][colunaSorteio];

            if(valorPosicao == '*'){

                campo[linhaSorteio][colunaSorteio] = 'O';
                plantada++;
            }
        }

        for (int i= 0; i < linha; i++){

            for (int j= 0; j < coluna; j++){
                System.out.print(" " + campo[i][j] + " ");
            }

            System.out.println(" ");
        }

        boolean continuar = true;

        //O jogador terá 100 tentativas - a quantidade de bombas que ele colocar no tabuleiro
        int tentativas = 100 - quantidade ;

        do {
            System.out.println("Informe uma Linha: ");
            int linhaEscolhida = sc.nextInt();

            System.out.println("Informe uma Coluna: ");
            int colunaEscolhida = sc.nextInt();

            char valorEscolhido = campo[linhaEscolhida - 1][colunaEscolhida - 1];

            if (valorEscolhido == 'O') {
                System.out.println("BOMBAAA!");
                continuar = false;
            } else {
                System.out.println("CAMPO VAZIO!");
                //a cada campo vazio, será subtraído uma tentativa, se todas as tentativas (Campos sem bomba) acabarem, ele irá ganhar o jogo
                tentativas--;
            }

        } while (continuar && tentativas > 0);


        if(continuar == false){
            System.out.println("Perdeu");
        }else {
            System.out.println("Ganhou");
        }
    }
}