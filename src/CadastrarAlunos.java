import java.util.Scanner;

public class CadastrarAlunos {
    // UPS
    //melhorar a parte de cadastro de alunos.
    private static int a0 = 0;
    private static String[][] ALUNOS;
    private static int TOTAL_DE_ALUNOS = 0;
    private static boolean LIBERADO = false;
    private static final String MENU = """
            -------------------------------
            C A D A S T R O  D E  A L U N O
            -------------------------------
            [1] = Cadastra alunos
            [2] = Listar alunos
            [3] = excruir alunos
            [4] = modificar alunos
            [5] = Adicionar nota
            [6] = ATA
            [7] = sair
            """;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int cont;
        //codigo
        do {
            System.out.println(MENU);
            cont = sc.nextInt();
            sc.nextLine();
            if (cont <= 0 || cont > 7) {
                System.out.println("Numero invalido!");
            }
            switch (cont){
                case 1: //final
                    Cadastra_alunos(sc);
                    break;
                case 2: //incomplete
                    listar_alunos();
                    break;
                case 3: //final
                    excluir(sc);
                    break;
                case 4: //final
                    enditar(sc);
                    break;
                case 5: //final
                    media(sc);
                    break;
                case 6: //final
                    ata(sc);
                    break;
            }


        }while (cont != 7);
        if (!LIBERADO) {
            System.out.println("Salvando...Nada???");
        } else {
            System.out.println("Salvando alterações...");
            System.out.println("Saindo");
        }
    }

    private static void Cadastra_alunos(Scanner sc) {
        boolean a1 = true;
        int qtd;
        if (a0 == 0) {
            a1 = false;
            a0 = 1;
        }
        if (!a1) {
            System.out.println("Quantos alunos tem na sala de aula");
            System.out.println("Atenção só pode responder uma vez!");
            do {
                qtd = sc.nextInt();
                if (qtd <= 1) {
                    System.out.println("Numero invalido!");
                }
            }while (qtd <= 1);
            System.out.println("Quantidades de alunos salvo!");
            LIBERADO = true;
            ALUNOS = new String[qtd][5];

        } else {
            if (TOTAL_DE_ALUNOS >= ALUNOS.length) {
                System.out.println("Limite de alunos atingido!");
                return;
            }
            System.out.println("Digite o nome do aluno:");
            ALUNOS[TOTAL_DE_ALUNOS][0] = sc.nextLine();
            System.out.println("Digite o endereço do aluno " + ALUNOS[TOTAL_DE_ALUNOS][0] + " : ");
            ALUNOS[TOTAL_DE_ALUNOS][1] = sc.nextLine();
            System.out.println("Digite o curso do aluno " + ALUNOS[TOTAL_DE_ALUNOS][0] + " : ");
            ALUNOS[TOTAL_DE_ALUNOS][2] = sc.nextLine();
            System.out.println("Aluno cadastrado!");
            TOTAL_DE_ALUNOS++;
        }
    }

    private static void listar_alunos () {
        int i = 0;
        if (!LIBERADO) {
            System.out.println("A Sala está vazia :(");
        } else {
            for(String[] ignored : ALUNOS) {
                System.out.println("--------------------------------------");
                if (ALUNOS[i][0] == null) {
                    System.out.println("Aluno não cadastrado!");
                } else {
                    System.out.println("Aluno " + (i + 1) + " : " + ALUNOS[i][0]);
                    System.out.println("Endereço " + (i + 1) + " : " + ALUNOS[i][1]);
                    System.out.println("Curso " + (i + 1) + " : " + ALUNOS[i][2]);
                    if (ALUNOS[i][3] == null) {
                        System.out.println("Nenhuma nota lançada!");
                    } else {
                        System.out.println("Media: " + ALUNOS[i][3]);
                    }
                    if (ALUNOS[i][4] == null) {
                        System.out.println("Nenhuma ATA");
                    } else {
                        System.out.println("ATA: " + ALUNOS[i][4]);
                    }
                    i++;
                }
            }
        }
    }

    private static void excluir (Scanner sc) {
        int excluir;
        if (!LIBERADO) {
            System.out.println("Nenhum aluno para excluir!");
        } else {
            System.out.println("Qual aluno deseja excluir?");
            do {
                excluir = sc.nextInt();
                if (excluir <= 0) {
                    System.out.println("Numero invalido!");
                }
            } while (excluir <= 0);
            excluir -= 1;
            if (excluir >= ALUNOS.length) {
                System.out.println("Esse aluno não existe!!");
            } else {
                ALUNOS[excluir][0] = "Excluido";
                ALUNOS[excluir][1] = "Excluido";
                ALUNOS[excluir][2] = "Excluido";
                if (ALUNOS[excluir][3] == null) {
                    System.out.print("");
                } else {
                    ALUNOS[excluir][3] = "Excluido";
                }
                if (ALUNOS[excluir][4] == null) {
                    System.out.print("");
                } else {
                    ALUNOS[excluir][4] = "Excluido";
                }

                System.out.println("Aluno excluido!");
            }
        }
    }

    private static void enditar (Scanner sc) {
        int editar;
        if (!LIBERADO) {
            System.out.println("Nenhum aluno para editar!");
        } else {
            System.out.println("Qual aluno deseja editar?");
            do {
                editar = sc.nextInt();
                if (editar <= 0) {
                    System.out.println("Numero invalido!");
                }
            } while (editar <= 0);
            editar -= 1;
            if (editar >= ALUNOS.length) {
                System.out.println("Esse aluno não existe!!");
            } else {
                sc.nextLine();
                System.out.println("Digite o nome do aluno:");
                ALUNOS[editar][0] = sc.nextLine();
                System.out.println("Digite o endereço do aluno " + ALUNOS[editar][0] + " : ");
                ALUNOS[editar][1] = sc.nextLine();
                System.out.println("Digite o curso do aluno " + ALUNOS[editar][0] + " : ");
                ALUNOS[editar][2] = sc.nextLine();
                System.out.println("Aluno cadastrado!");
                TOTAL_DE_ALUNOS++;
            }
        }
    }

    private static void media(Scanner sc) {
        if(!LIBERADO){
            System.out.println("Vai dar a media para um fantasma?");
        } else {
            float media;
            int nota;
            do {
                System.out.println("Qual aluno vai colocar nota?");
                nota = sc.nextInt();
            } while (nota <= 0);
            sc.nextLine();
            nota -= 1;
            if (nota >= ALUNOS.length) {
                System.out.println("Esse aluno não existe!");
            } else {
                System.out.println("Digite a media do aluno: min(0) max(10)");
                do {
                    media = sc.nextInt();
                    sc.nextLine();
                    if (media < 0 || media > 10) {
                        System.out.println("Numero invalido!");
                    }
                } while (media < 0 || media > 10);
                if (media >= 7) {
                    ALUNOS[nota][3] = "Aluno Aprovado";
                } else if (media >= 5){
                    ALUNOS[nota][3] = "Aluno em recuperação";
                } else {
                    ALUNOS[nota][3] = "Aluno reprovado";
                }
                System.out.println("Nota Adicionada!");
            }
        }


    }

    private static void ata(Scanner sc) {
        if (!LIBERADO) {
            System.out.println("Vai dar atá pra quem? pra mim? quero não :)");
        } else {
            String ata;
            int aluno_ata;
            System.out.println("Qual o aluno que vai receber a ata");
            aluno_ata = sc.nextInt();
            sc.nextLine();
            aluno_ata -= 1;
            if (aluno_ata >= ALUNOS.length) {
                System.out.println("Esse aluno não existe!");
            } else {
                System.out.println("Qual o motivo da ata?");
                ata = sc.nextLine();
                ALUNOS[aluno_ata][4] = ata;
            }
        }

    }

}