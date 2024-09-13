import java.util.Random;
import java.util.Scanner;

public class BlackJackJavaVersion {
    
    public static void main(String[] args) {

        Random random = new Random();
        Scanner scanner = new Scanner(System.in); //adição de objeto para leitura dos inputs de dados
        int tira = random.nextInt(1, 11);
        int opc = 0; //Atribução de valor mandatória. Em Java não é permitida a utilização de variáveis para validação de dados antes que ela própria tenha um valor atribuído.
        int P;
        int finalValue = 21; //Alteração de nome da variável mandatória. Em Java "final" é uma palavra reservada à constantes e por isso não pode ser usada para outro fim.
        String esc = null;
        System.out.println("  _     _            _    _            _    \\r\\n" + //
                        " | |   | |          | |  (_)          | |   \\r\\n" + //
                        " | |__ | | __ _  ___| | ___  __ _  ___| | __\\r\\n" + //
                        " | '_ \\\\| |/ _` |/ __| |/ / |/ _` |/ __| |/ /\\r\\n" + //
                        " | |_) | | (_| | (__|      | | (_| | (__| \\r\\n" + //
                        " |_.__/|_|\\\\__,_|\\\\___|_|\\\\_\\\\ |\\\\__,_|\\\\___|_|\\\\_\\\\\\r\\n" + //
                        "                        _/ |                \\r\\n" + //
                        "                       |__/                 ");
            do{
            System.out.println();
            System.out.println("Digite uma opção");
            System.out.println("1 - Novo jogo \n2- Regras");
            opc = scanner.nextInt();
            if (opc == 2) {
                System.out.println(" - Objetivo: O objetivo do Blackjack é vencer ao obter uma mão de cartas cujo valor seja o mais próximo possível de 21, sem ultrapassá-lo.");
                
                System.out.println(" - Valor das Cartas: \n" + //
                                    "Cartas numeradas (2-10): Valem o número indicado na carta.");

                System.out.println(" - Decisões: \\n" + //
                                    "Hit (Pedir): O jogador pede outra carta.\n" + //
                                    "Stand (Parar): O jogador decide não receber mais cartas.");
            }
        } while(opc != 1);

        if (opc == 1) {
            System.out.println("Iniciando novo jogo...");
        }

        do{
            System.out.println("Digite a quantidade de jogadores (4 a 7 Jogdores): ");
            P = scanner.nextInt();
            if (P >= 4 && P <= 7) {
                int[] Players = new int[P];
            }
            else{
                System.out.println("Quantidade inválida");
            }
        } while(P < 4 || P > 7);
        
        String[] Nomes = new String[P];
        int[] Somas = new int[P];
        boolean[] Ativo = new boolean[P];

        for(int i = 0; i < P; i++){
            System.out.println("Digite o nome do " + (i + 1) + "º jogador");
            Nomes[i] = scanner.next();
            scanner.nextLine(); //linha para evitar possiveis erros. Coisas do Java ¯\_(ツ)_/¯
            Ativo[i] = true;
        }

        for( int i = 0; i < P; i++){
            System.out.println("Jogador " + Nomes[i] + " tirou: ");
            int tira1 = random.nextInt(1, 11);
            System.out.println(tira1);
            int tira2 = random.nextInt(1, 11);
            System.out.println(tira2);
            Somas[i] = tira1 + tira2;
            System.out.println(Nomes[i] + ", somou " + Somas[i]);
        }
        boolean jogoEmAndamento = true;
        while (jogoEmAndamento) {

            jogoEmAndamento = false;

            for(int i = 0; i < P; i++){
               
                if (Ativo[i])
                {
                    System.out.println("Jogador " + Nomes[i] + " com a soma " + Somas[i] + ", o que deseja realizar?");
                    System.out.println("Digite T para tirar uma nova carta, ou digite P para parar.");
                    esc = scanner.next();
                    if (esc == "T" || esc == "t")
                    {
                        int tira1 = random.nextInt(1, 11);
                        System.out.println(tira1);
                        Somas[i] = Somas[i] + tira1;
                        System.out.println(Nomes[i] + ", somou " + Somas[i]);
                    }
                        else if (esc == "P" || esc == "p"){
                        System.out.println(Nomes[i] + " parou");
                        Ativo[i] = false;
                    }else{
                        System.out.println("Dígito inválido");
                    }
                    if (Somas[i] > 21) {
                        System.out.println(Nomes[i] + " explodiu");
                        Ativo[i] = false;
                    }
                    if (Ativo[i]) {
                        jogoEmAndamento = true;
                    }
                }
            }
        }
        int melhorPontuação = 0;
        String ganhador = "Nenhum";
        for (int i = 0; i < P; i++){
            if (Somas[i] <= finalValue && Somas[i] > melhorPontuação) {
                melhorPontuação = Somas[i];
                ganhador = Nomes[i];
            }
        }
        if(ganhador != "Nenhum"){
            System.out.println("O ganhador é " + ganhador + " com " + melhorPontuação + " pontos!");

        }else{
            System.out.println("Todos os jogadores explodiram. Não há ganhador");
        }
        scanner.nextLine();
        System.out.println("Obrigado por jogar");
    }
}
    