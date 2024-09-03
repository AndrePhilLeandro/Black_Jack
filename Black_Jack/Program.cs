using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Black_Jack
{
    internal class Program
    {
        static void Main(string[] args)
        {
            Random random = new Random();
            int tira = random.Next(1, 11);
            int opc, P, final = 21;
            string esc;
            Console.WriteLine("  _     _            _    _            _    \r\n | |   | |          | |  (_)          | |   \r\n | |__ | | __ _  ___| | ___  __ _  ___| | __\r\n | '_ \\| |/ _` |/ __| |/ / |/ _` |/ __| |/ /\r\n | |_) | | (_| | (__|      | | (_| | (__| \r\n |_.__/|_|\\__,_|\\___|_|\\_\\ |\\__,_|\\___|_|\\_\\\r\n                        _/ |                \r\n                       |__/                 ");
            do
            {
                Console.WriteLine("Digite uma opção");
                Console.WriteLine("1 - Novo Jogo \n2 - Regras");
                opc = int.Parse(Console.ReadLine());
                if (opc == 2)
                {
                    Console.WriteLine(" - Objetivo: O objetivo do Blackjack é vencer ao obter uma mão de cartas cujo valor seja o mais próximo possível de 21, sem ultrapassá-lo.\n");
                    Console.WriteLine(" - Valor das Cartas: \nCartas numeradas (2-10): Valem o número indicado na carta.");
                    Console.WriteLine(" - Decisões: \nHit (Pedir): O jogador pede outra carta.\r\nStand (Parar): O jogador decide não receber mais cartas. \n");
                }
            } while (opc != 1);
            if (opc == 1)
            {
                Console.WriteLine("Iniciando novo jogo...");
            }
            do
            {
                Console.Write("Digite a Quantidade de jogadores (4 a 7 Jogadores): ");
                P = int.Parse(Console.ReadLine());
                if (P >= 4 && P <= 7)
                {
                    int[] Players = new int[P];
                }
                else
                {
                    Console.WriteLine("Quantidade Invalida");
                }
            } while (P < 4 || P > 7);
            string[] Nomes = new string[P];
            int[] Somas = new int[P];
            bool[] Ativo = new bool[P];
            for (int i = 0; i < P; i++)
            {
                Console.Write($"Digite o nome do {i + 1}° Jogador: ");
                Nomes[i] = Console.ReadLine();
                Ativo[i] = true;
            }
            for (int i = 0; i < P; i++)
            {
                Console.WriteLine($"Jogador {Nomes[i]} Tirou: ");
                int tira1 = random.Next(1, 11);
                Console.WriteLine(tira1);
                int tira2 = random.Next(1, 11);
                Console.WriteLine(tira2);
                Somas[i] = tira1 + tira2;
                Console.WriteLine($"{Nomes[i]}, somou {Somas[i]}");
                Console.ReadKey();
            }
            bool JogoEmAndamento = true;
            while (JogoEmAndamento)
            {
                JogoEmAndamento = false;

                for (int i = 0; i < P; i++)
                {
                    if (Ativo[i])
                    {
                        Console.WriteLine($"Jogador {Nomes[i]} Com a soma {Somas[i]}, O que deseja Realizar? ");
                        Console.WriteLine("Digite T para tirar uma nova carta, ou digite P para parar. ");
                        esc = Console.ReadLine();
                        if (esc == "T" || esc == "t")
                        {
                            int tira1 = random.Next(1, 11);
                            Console.WriteLine(tira1);
                            Somas[i] = Somas[i] + tira1;
                            Console.WriteLine($"{Nomes[i]}, somou {Somas[i]}");
                            Console.ReadKey();
                        }
                        else if (esc == "P" || esc == "p")
                        {
                            Console.WriteLine($"{Nomes[i]} parou");
                            Ativo[i] = false;
                        }
                        else
                        {
                            Console.WriteLine("Digito Invalido");
                        }
                        if (Somas[i] > 21)
                        {
                            Console.WriteLine($"{Nomes[i]} Explodiu ");
                            Ativo[i] = false;
                        }
                        if (Ativo[i])
                        {
                            JogoEmAndamento = true;
                        }
                    }
                }
            }
            int melhorPontuacao = 0;
            string ganhador = "Nenhum";
            for (int i = 0; i < P; i++)
            {
                if (Somas[i] <= final && Somas[i] > melhorPontuacao)
                {
                    melhorPontuacao = Somas[i];
                    ganhador = Nomes[i];
                }
            }
            if (ganhador != "Nenhum")
            {
                Console.WriteLine($"O ganhador é {ganhador} com {melhorPontuacao} pontos!");
            }
            else
            {
                Console.WriteLine("Todos os jogadores explodiram. Não há ganhador.");
            }
            Console.ReadKey();
            Console.WriteLine("Obrigado Por Jogar");
        }
    }
}
