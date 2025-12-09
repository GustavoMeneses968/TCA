import java.util.Random;
import java.util.Scanner;

public class Jogo {
    final static Scanner LER = new Scanner(System.in);
    static int[] inimigoBase = new int[3];
    static int[] inimigoBase2 = new int[3];
    static int[] inimigoBuff = new int[3];
    static int[] inimigoBuff2 = new int[3];
    static int[] inimigoBoss = new int[3];
    static int[] statusJogador = new int[3];
    static int[] posiJogador = new int[2]; // posi 0 linha posi 1 coluna
    static int[] posiBoss = { 14, 14 };
    static int[] limitesBoss = new int[8];
    static int[] posiInimigoBase = new int[2];
    static int[] limitesInimigoBase = new int[8];
    static int[] posiInimigoBase2 = new int[2];
    static int[] limitesInimigoBase2 = new int[8];
    static int[] posiInimigoBuff = new int[2];
    static int[] limitesInimigoBuff = new int[8];
    static int[] posiInimigoBuff2 = new int[2];
    static int[] limitesInimigoBuff2 = new int[8];
    static int[] rotaInimigoBase = { 4, 0, 4, 5 };
    static int[] rotaInimigoBase2 = { 11, 0, 11, 5 };
    static int[] rotaInimigoBuff = { 14, 1, 8, 1 };
    static int[] rotaInimigoBuff2 = { 14, 9, 7, 9 };
    static int quantRodadaUltimateM = -100; // variavel para guardar a rodada em que o mago ativou o ultimate
    static int danoCausadoI;
    static int danoCausadoJ;
    static char classe;
    static char elementoJogador = ' ';
    static boolean enfrentandoInimigoBase = false;
    static boolean enfrentandoInimigoBase2 = false;
    static boolean enfrentandoInimigoBuff = false;
    static boolean enfrentandoInimigoBuff2 = false;
    static boolean enfrentandoBoss = false;
    static boolean derrotouInimigoBase = false;
    static boolean derrotouInimigoBase2 = false;
    static boolean derrotouInimigoBuff = false;
    static boolean derrotouInimigoBuff2 = false;
    static boolean derrotouBoss = false;
    static boolean jaEscolhiOElemento = false;
    static boolean jaEscolhiBuff1 = false;
    static boolean jaEscolhiBuff2 = false;
    static boolean foiUtilizadoItenDano = false;
    static boolean jaInformeielemento = false;
    static boolean batalhando = false;
    static char elementoInimigoBase;
    static char elementoInimigoBase2;
    static char elementoInimigoBuff;
    static char elementoInimigoBuff2;
    static char elementoBoss;
    static char iten1 = 'N';
    static char iten2 = 'N';
    static char buffEscolhido = ' ';
    static char buffEscolhido2 = ' ';
    static char ehInimigoBase = 'i';
    static char ehInimigoBuff = 'I';
    static char ehBoss = 'B';
   
    // metodos para definição de status do jogador e dos inimigos
    public static void StatusArqueiro(int[] status) { // posição 0 vida, posição 1 def,posição 2 atk
        status[0] = 110;
        status[1] = 15;
        status[2] = 30;
    }

    public static void StatusMago(int[] status) { // posição 0 vida, posição 1 def,posição 2 atk
        status[0] = 85;
        status[1] = 10;
        status[2] = 45;
    }

    public static void StatusGueirro(int[] status) { // posição 0 vida, posição 1 def,posição 2 atk
        status[0] = 125;
        status[1] = 20;
        status[2] = 35;
    }

    public static void StatusInimigoBase(int[] status) { // posição 0 vida, posição 1 def,posição 2 atk
        status[0] = 70;
        status[1] = 15;
        status[2] = 25;
    }

    public static void StatusInimigoBuff(int[] status) { // posição 0 vida, posição 1 def,posição 2 atk
        status[0] = 70;
        status[1] = 15;
        status[2] = 38;
    }

    public static void StatusBoss(int[] status) {// posição 0 vida, posição 1 def,posição 2 atk
        status[0] = 180;
        status[1] = 25;
        status[2] = 48;
    }

    // metodos que serão utilizados para os buffs dos itens e quando passar o efeito
    // o debuff
    public static int buff(int buff, int statusAtual) {
        return statusAtual += buff;
    }

    public static int debuff(int debuff, int statusAtual) {
        return statusAtual -= debuff;
    }

    public static void ImprimirInimigoBase() {
        gotoXY(5, 100);
        System.out.println("⠀⠀⠀⠀⠀⠀⣀⣤⡤⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀" );
        gotoXY(6, 100);
        System.out.println(        "⠀⠀⠀⠀⢀⣾⣿⠋⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀");
        gotoXY(7, 100);
        System.out.println(        "⠀⠀⠀⣠⣾⣿⡟⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀" );
        gotoXY(8, 100);
        System.out.println(        "⠀⠀⢸⠛⠉⢹⠃⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⡠⠄⠠⣀⠀⠀⠀⠀⠀⠀⠀⠀" );
        gotoXY(9, 100);
        System.out.println(        "⠀⠀⡘⠀⠀⠀⡀⠀⠀⠀⠀⠀⠀⠀⠀⣠⠖⠉⠀⠀⠀⣾⣿⣦⡀⠀⠀⠀⠀⠀" );
        gotoXY(10, 100);
        System.out.println(       "⠀⠀⡇⠀⠀⠀⢡⠄⠀⠀⣀⣀⣀⣠⠊⠀⠀⠀⠀⡠⠞⠛⠛⠛⠛⠀⠀⠀⠀⠀" );
        gotoXY(11, 100);
        System.out.println(        "⠀⠀⢃⠀⠀⠀⠀⠗⠚⠉⠉⠀⠈⠁⠀⠀⠀⢀⡔⠁⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀" );
        gotoXY(12, 100);
        System.out.println(        "⠀⠀⠸⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣴⣶⣄⠲⡎⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀" );
        gotoXY(13, 100);
        System.out.println(        "⠀⠀⠀⠃⠀⠀⢠⣤⡀⠀⠀⠀⠀⣿⣿⣿⠀⠘⡄⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀" );
        gotoXY(14, 100);
        System.out.println(        "⠀⠀⠀⡆⠀⠀⣿⣿⡇⠀⠀⠀⠀⠈⠛⠉⣴⣆⢹⡄⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀" );
        gotoXY(15, 100);
        System.out.println(        "⠀⠀⠀⣇⢰⡧⣉⡉⠀⠀⢀⡀⠀⣀⣀⣠⣿⡷⢠⡇⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀" );
        gotoXY(16, 100);
        System.out.println(        "⠀⠀⠀⢻⠘⠃⠈⠻⢦⠞⠋⠙⠺⠋⠉⠉⠉⢡⠟⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀" );
        gotoXY(17, 100);
        System.out.println(        "⠀⠀⠀⠀⠳⢄⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢠⠋⠀⠀⠀⠀⠀⠀⠀⠀⠀⣀⣀⠀" );
        gotoXY(18, 100);
        System.out.println(        "⠀⠀⠀⠀⠀⠀⠈⠁⢲⡄⠀⠀⠀⠀⠀⠀⠘⡆⠀⠀⠀⣀⣤⣴⣶⣿⣿⣿⣿⡇" );
        gotoXY(19, 100);
        System.out.println(        "⠀⠀⠀⠀⠀⠀⠀⡰⠋⠀⠀⠀⠀⠀⠀⠀⠀⢿⠀⠀⣿⣿⣿⣿⣿⣿⣿⣿⣿⠃" );
        gotoXY(20, 100);
        System.out.println(        "⠀⠀⠀⠀⠀⢀⡞⠁⠀⠀⣾⠀⠀⣶⠀⠀⠀⢸⣦⣴⣿⣿⣿⠛⠉⠉⠉⠉⠁⠀" );
        gotoXY(21, 100);
        System.out.println(        "⠀⠀⢀⣀⡰⠏⠀⠀⠀⠀⠉⠀⠈⠋⠀⠀⠀⠘⣿⣿⣿⠛⠋⠀⠀⠀⠀⠀⠀⠀" );
        gotoXY(22, 100);
        System.out.println(       "⠰⣮⣉⣀⣀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠻⣿⡋⠀⠀⠀⠀⠀⠀⠀⠀⠀ "); 
        gotoXY(23, 100);
        System.out.println(        "⠀⠈⠉⠻⠥⠤⢤⣶⢄⠀⢀⣠⣄⠀⠀⢠⣶⣤⣄⠈⠑⡄⠀⠀⠀⠀⠀⠀⠀⠀" );
        gotoXY(24, 100);
        System.out.println(        "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠉⠁⠈⠋⠁⠠⠁⠀⠈⠁⠀⠀⠀⠀⠀⠀");
    }

    public static void ImprimirInimigoBuff() {
        System.out.println("⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⣤⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀" );
        gotoXY(5, 100);
        System.out.println(        "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢠⣤⡀⠀⠀⠀⠀⣤⣤⠲⠃⠀⠀⠀⠀⣤⡟⢹⠇⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀" );
        gotoXY(6, 100);
        System.out.println(        "⠀⠀⠀⠸⣿⣿⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣴⠏⢻⡇⣠⢤⣿⣏⠁⣿⣀⣰⣤⣤⢟⣿⢟⣇⢸⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀" );
        gotoXY(7, 100);
        System.out.println(        "⠀⠀⠀⠀⠈⠙⣿⣿⣶⣾⠟⠛⠦⢰⣶⣄⣴⣷⣿⣿⣿⣻⠿⠁⡟⣆⡿⣯⢙⣿⣿⠿⠋⢸⡿⢸⠀⢀⣀⣴⣦⠀⠀⠀⠀⠀⠀⠀⠀⠀" );
        gotoXY(8, 100);
        System.out.println(        "⠀⠀⠀⠀⠀⠘⣻⣍⠻⣿⣿⣷⣶⢾⣿⣇⣴⡿⠙⠛⠃⠀⠀⠀⠛⠛⠀⣿⡾⠃⠈⠀⠀⢸⡷⡜⢷⣾⣯⣿⠁⠀⠀⠀⠀⠀⠀⠀⠀⠀" );
        gotoXY(9, 100);
        System.out.println(        "⠀⠀⠀⠀⠀⠀⠙⠛⠀⠀⠀⠻⠿⣴⠛⣷⡇⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠸⣧⡿⢻⡟⣻⠁⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀" );
        gotoXY(10, 100);
        System.out.println(        "⠀⠀⠀⠀⠀⠀⠀⢿⣿⠀⠀⠀⠀⠈⠿⠟⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢸⣼⣿⠗⣺⡷⢀⣴⣿⠆⠀⠀⠀⠀" );
        gotoXY(11, 100);
        System.out.println(        "⠀⠀⣠⣤⣀⣀⡀⠐⢯⣇⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣿⡾⡿⣾⠿⠟⠻⠿⢆⣤⣤⠀" );
        gotoXY(12, 100);
        System.out.println(        "⠀⠸⠿⠿⠭⠭⣷⣶⠾⣻⡀⠀⣰⣦⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣠⣤⠀⠀⠀⠀⠀⠀⠀⠀⠀⠉⠉⠉⠉⠀⠀⠀⠀⠺⣿⣿⣶" );
        gotoXY(13, 100);
        System.out.println(        "⣰⣆⣄⠀⠀⠀⠈⠙⠟⠋⠀⠀⡇⠛⡏⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⣴⠋⣿⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⣤⢴⣿⡟⠉" );
        gotoXY(14, 100);
        System.out.println(        "⠉⠘⠛⣠⣄⠀⠀⠀⠀⠀⠀⠀⢱⡆⠷⣖⣆⡀⠀⠀⠀⠀⠀⣠⣲⡿⠁⢀⣇⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣰⣿⠟⠁⠀⠀⠀" );
        gotoXY(15, 100);
        System.out.println(        "⠀⠀⠀⠙⢿⣷⣄⠀⠀⠀⠀⡠⢤⠙⣿⣯⣹⣿⠆⠀⠀⠀⣾⣏⣭⣤⣤⣿⠋⣠⢾⡆⠀⠀⠀⠀⠀⠀⠀⠀⠀⣠⢾⡟⠁⠀⠀⠀⠀⠀" );
        gotoXY(16, 100);
        System.out.println(        "⠀⠀⠀⠀⠀⠉⠙⢯⣷⡄⠀⠉⢧⣤⡿⠠⡄⠀⠀⠀⠀⠀⠀⢉⡿⠿⣿⡶⠋⣁⣼⠇⠀⠀⠀⠀⠀⠀⠀⢀⣴⣷⠟⠁⠀⠀⠀⠀⠀⠀" );
        gotoXY(17, 100);
        System.out.println(        "⠀⠀⠀⠀⠀⠀⠀⠀⢉⣁⠀⠀⠘⣿⡇⠀⣿⠉⠉⢹⡎⠁⠉⣿⠀⠀⢹⠃⣰⡿⠛⠀⠀⠀⠀⠀⠀⠀⣴⣿⡟⠁⠀⠀⠀⠀⠀⠀⠀⠀" );
        gotoXY(18, 100);
        System.out.println(        "⠀⠀⠀⠀⠀⠀⠀⠀⢸⣿⠀⠀⠀⠙⢿⡆⢛⣶⠀⢸⡇⠀⠀⣿⣀⣀⣾⣷⡿⠀⠀⠀⠀⠀⠀⠀⠀⣾⣿⣿⣷⣄⣀⠀⠀⠀⠀⠀⠀⠀" );
        gotoXY(19, 100);
        System.out.println(        "⠀⠀⠀⠀⠀⠀⠀⠀⢸⡿⣤⠀⠀⠀⠀⠉⠿⠻⣶⣾⠷⣖⣶⡏⠛⠛⠁⠈⠀⠀⠀⠀⠀⠀⠀⠀⠀⠻⣾⣻⣿⡿⣿⠷⢖⣒⡶⠀⠀⠀");
        gotoXY(20, 100);
        System.out.println(        "⠀⠀⠀⠀⠀⠀⠀⠀⢸⣷⣾⣦⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠈⢿⣹⡇⠙⠓⣛⣥⠀⠀⠀⠀");
        gotoXY(21, 100);
        System.out.println(        "⠀⠀⠀⠀⠀⠀⠀⢸⣿⡟⠉⠉⠀⠀⢀⣀⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢿⣿⣾⡯⠿⠋⠀⠀⠀⠀");
        gotoXY(22, 100);
        System.out.println(        "⠀⠀⠀⠀⠀⠀⠀⢸⣿⡇⠀⠀⠀⠀⠈⠻⣗⣶⣄⣀⣀⠀⠀⠀⠀⠀⠀⢀⣀⣀⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣸⣿⡏⠀⠀⠀⠀⠀⠀⠀");
        gotoXY(23, 100);
        System.out.println(        "⠀⠀⠀⠀⠀⠀⠀⠈⢻⣿⣤⠀⠀⠀⠀⠀⢰⣿⠗⢳⣙⣒⣚⣛⣛⣛⣚⣿⠖⠲⣿⣦⡀⠀⠀⠀⠀⢀⣤⣤⣿⡿⠃⠀⠀⠀⠀⠀⠀⠀");
        gotoXY(24, 100);
        System.out.println(        "⠀⠀⠀⠀⠀⠀⠀⠀⠸⣿⡿⣧⢀⣤⡾⠿⠆⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠈⠙⠻⢿⣦⣤⡀⠈⠓⠚⠋⣴⣿⣦⡀⠀⠀⠀⠀⠀");
        gotoXY(25, 100);
        System.out.println(        "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠈⠉⠉⠀⠉⠁⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠈⠻⣿⣦⣤⣴⣿⣷⡝⠛⠁⠀⠀⠀⠀⠀");
        gotoXY(26, 100);
        System.out.println(        "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠈⠻⠿⠉⠈⠉⠁⠀⠀⠀⠀⠀⠀⠀");
    }

    public static void ImprimirBoss() {
        System.out.println("⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣀⣀⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀");
        gotoXY(5, 100);
        System.out.println(            "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢹⣿⣷⠀⠀⠀⠀⣸⣶⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀");
        gotoXY(6, 100);
        System.out.println(            "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣼⣿⣿⡞⣿⣷⣮⣻⣿⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀");
        gotoXY(7, 100);
        System.out.println(            "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⣾⣿⣿⣿⣿⣾⣿⣿⣿⣿⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀");
        gotoXY(8, 100);
        System.out.println(            "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢸⣿⣿⣿⣿⡝⢿⣿⣿⣿⣿⡆⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀");
        gotoXY(9, 100);
        System.out.println(            "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣀⣤⡀⠀⠀⠀⠀⠀⠀⠻⣿⣿⣿⠸⣸⣻⣏⣿⣿⠃⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀");
        gotoXY(10, 100);
        System.out.println(            "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠐⣿⣿⡿⡀⠀⠀⠀⠀⠀⣾⡞⡝⣿⢿⣿⣿⣿⣿⠁⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀");
        gotoXY(11, 100);
        System.out.println(            "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠈⠩⣾⣿⣶⢦⣤⣀⠸⠻⢭⣥⡻⣧⠀⡙⠛⠋⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀");
        gotoXY(12, 100);
        System.out.println(            "⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⣤⣄⢠⣴⣾⣿⣿⣿⣏⣶⣾⡽⣿⣷⣟⣿⣿⣿⣻⣷⡄⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀");
        gotoXY(13, 100);
        System.out.println(            "⠀⠀⠀⣀⣀⣀⠀⠀⠀⠸⣿⡿⠘⠻⢿⣿⣿⠟⠛⠿⠿⠃⢍⣿⣿⢸⣿⣿⣿⡽⣿⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀");
        gotoXY(14, 100);
        System.out.println(            "⠀⣰⣟⠛⠛⢿⣿⣦⣄⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠈⠻⣿⣜⢿⣿⡿⡷⡿⣼⣶⣄⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀");
        gotoXY(15, 100);
        System.out.println(            "⢰⣿⠃⠀⠀⠀⠈⢿⣿⣧⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠙⢿⣷⣯⣾⣿⡀⠀⠙⠻⢿⣶⣄⠀⠀⠀⠀⠀⠀⠀");
        gotoXY(16, 100);
        System.out.println(            "⢸⣿⠀⠀⠀⠀⠀⠀⢻⣿⣷⡄⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢸⣿⣿⣿⣿⣧⡀⠀⠀⠀⠙⢿⣧⡀⠀⠀⠀⠀⠀");
        gotoXY(17, 100);
        System.out.println(            "⢸⣿⡀⠀⠀⠀⠀⠀⠀⢻⣿⣿⣦⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣠⣬⣽⣿⣿⢟⣛⣳⠀⠀⠀⠀⠀⠹⣿⣆⠀⠀⠀");
        gotoXY(18, 100);
        System.out.println(            "⠀⣿⣇⠀⠀⠀⠀⠀⠀⠈⣿⣿⣿⣷⡀⠀⠀⠀⠀⠀⠀⠀⣴⣿⣿⣿⣿⣷⢻⣾⣿⣿⣷⡽⣄⠀⠀⢀⣾⣿⣷⣄⠀⠀");
        gotoXY(19, 100);
        System.out.println(            "⠀⠘⣿⣆⠀⠀⠀⠀⠀⠀⠘⣿⣿⣿⣿⣷⣄⡀⠀⠀⢀⣾⣿⣿⣿⣿⣿⣿⡇⣿⣿⣿⣿⣿⢹⣦⠀⢸⣇⠀⠹⣏⢧⡀");
        gotoXY(20, 100);
        System.out.println(            "⠀⠀⠹⣿⣷⡀⠀⠀⠀⠀⠀⠘⣿⣿⣿⣿⣿⣿⣿⡆⣿⣿⣿⣿⣿⣿⣿⣿⣧⣿⣿⣿⣿⣿⢸⣿⡄⠈⠛⠀⣶⠟⠼⠇");
        gotoXY(21, 100);
        System.out.println(            "⠀⠀⠀⠹⣿⣿⣷⣤⡀⠀⠀⠀⠘⢿⣿⣿⣿⣿⣿⢸⣿⣿⣿⣿⣿⣿⣿⡿⣼⣿⣿⣿⣿⡿⣾⣿⠁⠀⠀⠀⠀⠀⠀⠀");
        gotoXY(22, 100);
        System.out.println(            "⠀⠀⠀⠀⠙⣿⣿⣿⣿⣶⣄⠀⠀⠈⠻⣿⣿⣿⣿⢸⣿⣿⣿⣿⣿⣿⡿⣱⣿⣿⣿⣿⢟⣼⣿⠏⠀⠀⠀⠀⠀⠀⠀⠀");
        gotoXY(23, 100);
        System.out.println(            "⠀⠀⠀⠀⠀⠈⢻⣿⣿⣿⣿⣧⡀⠀⠀⠈⠻⢿⣿⢸⣿⣿⣿⡿⢟⣫⣾⣿⣿⠿⣛⣵⣿⡿⠃⠀⠀⠀⠀⠀⠀⠀⠀⠀");
        gotoXY(24, 100);
        System.out.println(            "⠀⠀⠀⠀⠀⠀⠀⠙⠿⣿⣿⣿⡇⠀⠀⠀⠀⠀⢈⣾⣿⡟⠙⠚⠛⠛⠋⠉⠀⠘⣿⣿⠋⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀");
        gotoXY(25, 100);
        System.out.println(            "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠈⠙⠛⠁⠀⠀⠀⠀⢀⣾⣿⡟⠀⠀⠀⠀⠀⠀⠀⠀⢰⣿⡿⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀");
        gotoXY(26, 100);
        System.out.println(            "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢠⣾⣿⠏⠀⠀⠀⠀⠀⠀⠀⠀⢀⣾⣿⣷⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀");
        gotoXY(27, 100);
        System.out.println(            "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢠⣿⡿⡏⠀⠀⠀⠀⠀⠀⠀⠀⢠⣾⣯⢻⣿⣷⣄⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀");
        gotoXY(28, 100);
        System.out.println(            "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⣾⣿⣿⣧⡀⠀⠀⠀⠀⠀⠀⠀⠈⠛⠋⠘⠻⣿⣿⣷⣶⣒⣒⢢⡄⠀⠀⠀⠀");
        gotoXY(29, 100);
        System.out.println(            "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣰⣿⣿⣿⡿⣏⣃⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠙⠻⠿⠿⠟⠈⠁⠀⠀⠀⠀");
        gotoXY(30, 100);
        System.out.println(            "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣾⣿⡿⠿⠿⠿⣿⣿⠇⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀");
        gotoXY(31, 100);
        System.out.println(            "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠉⠉⠁⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀");
    }

    public static void ImprimirArqueiro() {
        System.out.println("                          \n" + //
                "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣼⠃⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" + //
                "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣠⡶⠀⣿⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" + //
                "⠀⠀⠀⠀⠀⠀⠀⢀⣴⣾⣶⡄⠀⠀⣠⡾⠋⠀⠀⣿⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" + //
                "⠀⠀⠀⠀⠀⠀⠀⣿⣿⣿⣿⠟⢀⣼⠏⠀⠀⠀⠀⢹⣇⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" + //
                "⠀⠀⠀⠀⠀⠀⠀⣿⣿⠟⢁⣴⠟⠁⠀⠀⠀⠀⠀⠀⢿⡄⠀⠀⠀⠀⠀⠀⠀⠀\n" + //
                "⠀⠀⠀⠀⠀⠀⠀⠈⠁⠰⠿⠋⠀⠀⠀⠀⠀⠀⠀⠀⢸⣧⠀⠀⠀⢀⠀⠀⠀⠀\n" + //
                "⠀⠀⣤⣦⣤⣤⣤⣴⣶⣶⠖⠀⠶⠶⠶⠶⠶⠶⠶⠆⢠⣤⡄⠰⠶⢾⣿⠷⠂⠀\n" + //
                "⠀⠈⠛⠛⠋⠉⢉⠙⠻⠿⠂⣰⣶⣶⣶⣶⣶⣶⣶⡆⠸⣿⡏⠀⠀⠈⠀⠀⠀⠀\n" + //
                "⠀⠀⠀⠀⠀⠀⣼⣿⣶⣄⠘⢿⣿⠀⠀⠀⠀⠀⠀⠀⢠⣤⠀⠀⠀⠀⠀⠀⠀⠀\n" + //
                "⠀⠀⠀⠀⠀⠀⣿⣿⣿⣿⣧⡈⠻⣆⠀⠀⠀⠀⠀⠀⣼⠇⠀⠀⠀⠀⠀⠀⠀⠀\n" + //
                "⠀⠀⠀⠀⠀⠀⣿⣿⣿⣿⣿⣿⡄⠙⢷⡄⠀⠀⠀⢰⡟⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" + //
                "⠀⠀⠀⠀⠀⠀⣿⣿⣿⣿⣿⣿⠀⠀⠈⠻⣦⠀⠀⣿⠁⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" + //
                "⠀⠀⠀⠀⠀⠀⣿⣿⣿⣿⣿⣿⡆⠀⠀⠀⠘⠷⠀⣿⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" + //
                "⠀⠀⠀⠀⠀⠀⠛⠛⠛⠛⠛⠛⠓⠀⠀⠀⠀⠀⠀⠛⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀");
    }

    public static void ImprimirMago() {
        System.out.println("⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣀⣀⣀⣀⣀⣤⣴⣶⣶⣶⣦⣤⣄⣀⠀⠀⠀⠀⠀⠀⠀⠀\n" + //
                "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣠⣴⣾⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣶⣄⡀⠀⠀⠀⠀\n" + //
                "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⣾⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣦⠀⠀⠀\n" + //
                "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣧⠀⠀\n" + //
                "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⣾⣿⣿⣿⣿⣿⣿⣿⢿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣧⠀\n" + //
                "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣼⣿⣿⣿⣿⣿⣿⣿⢋⣲⠙⢿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣇\n" + //
                "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢻⣿⣿⣿⣿⣿⣿⠏⡸⢄⠩⢌⢻⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿\n" + //
                "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢸⣿⣿⣿⣿⡟⣠⣷⣾⣶⣬⡆⢻⣿⡿⢠⠹⢿⣿⣿⣏⣻⣿⣿⣿⣿⣿⣿⣿\n" + //
                "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢸⣿⣿⡿⢟⡶⢋⢔⣦⣌⠝⣯⠰⡉⢆⠡⣺⡿⢛⠛⡻⢧⡻⣿⣿⣿⣿⡟⠟\n" + //
                "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢹⣿⣟⢻⣇⠊⢿⣿⡿⠨⢼⣧⣼⣤⣳⡏⢄⣿⣿⣦⢃⢻⡉⣿⣿⣿⠇⠀\n" + //
                "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠘⢯⣿⡘⣯⡰⢈⠭⡑⢂⡾⢩⠉⠭⣹⡇⠜⡻⠿⡋⠌⣼⠷⣿⣿⠋⠀⠀\n" + //
                "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠘⣿⣿⣿⣿⣿⣿⣷⣬⡛⠾⠶⡞⢫⠑⢦⣉⣒⢄⠻⣦⣑⣌⣰⡽⢋⣴⣿⠞⠀⠀⠀\n" + //
                "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢹⣿⣿⣿⣿⣿⣿⣿⣿⣿⣶⣧⣦⣍⣢⣩⣁⣎⣰⣠⣉⣭⣵⡾⠟⠉⠀⠀⠀⠀⠀\n" + //
                "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣯⣍⠉⠉⠁⠀⠀⠀⠀⠀⠀⣀⣀⠀\n" + //
                "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠸⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⢿⣿⣿⣿⣿⣿⣦⣤⣶⣶⣶⣿⣿⣿⣿⣿⠁\n" + //
                "⠀⠀⠀⠀⢀⣀⣤⣤⣴⣦⣤⣤⣄⣀⡀⠀⢀⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣋⡿⠟⠛⠛⠉⠉⠉⠀⠀⠀\n" + //
                "⠀⠀⣴⣾⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⠛⠉⠉⠁⠀⠀⠉⠉⠁⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" + //
                "⠀⣘⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡿⠛⠻⣿⣿⣿⡿⠟⠁⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" + //
                "⠻⢿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡿⠃⠀⠀⠀⠀⠀⠀⠘⠻⠋⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" + //
                "⠀⠀⠘⠿⠿⣿⣿⣿⣿⣿⡿⠿⠛⠁⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀");
    }

    public static void ImprimirGuerreiro() {
        System.out.println("⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣠⣶⣿⣿⣦⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" + //
                "⠀⠀⠀⠀⠀⠀⠀⠀⠤⢴⣾⣿⣿⣿⣯⠘⠳⢦⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" + //
                "⠀⠀⠀⠀⠀⠀⠀⠀⢠⣿⣿⡟⣾⣿⣿⣠⢠⣀⢻⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" + //
                "⠀⠀⠀⠀⠀⠀⠀⠒⢫⣿⣿⣿⣿⣿⣿⢸⡗⣾⣙⡷⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" + //
                "⠀⠀⠀⠀⠀⠀⢀⣴⣿⣿⣿⣿⣿⣿⣧⢮⡯⣷⣼⠃⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" + //
                "⠀⠀⠀⠀⠀⡐⣚⣛⡛⠛⠉⢹⣽⣿⣽⠮⠓⣫⣏⠀⠀⣀⣀⣀⡀⠀⠀⠀⠀⠀\n" + //
                "⠀⠀⢀⣴⠟⠋⠩⠉⢩⣷⣾⣿⣽⣷⣿⠤⢋⡥⠚⠳⣾⡏⠉⠉⠙⠻⢦⡀⠀⠀\n" + //
                "⠀⢀⡿⢁⠈⢀⡠⢔⣣⠟⠿⣿⣿⣿⣗⡪⠇⠀⣢⡾⠛⣮⡢⢄⡀⠐⡈⢻⡄⠀\n" + //
                "⢰⣾⠷⠥⠉⠑⡪⣽⠧⠀⠀⠨⡻⣟⣿⠀⣠⠞⡁⠀⠀⠚⣯⣇⡊⠉⠬⠾⣻⡆\n" + //
                "⢨⡿⠤⣆⣒⡬⠞⣿⡑⠀⠀⠀⠀⠈⢳⣞⠁⠀⠀⠀⠀⢁⣿⠳⢥⣒⣨⠤⢿⣅\n" + //
                "⢻⣿⣿⢋⠁⠀⢰⡇⠀⠀⠀⢠⢞⢿⣭⡍⢻⢦⡀⠀⠀⠀⢼⡇⠀⠈⠝⣿⣿⡟\n" + //
                "⠀⣹⡏⢀⣀⣀⣸⣇⣀⣀⣀⣘⣛⣾⢶⠿⠿⣷⣽⡟⠓⢲⠶⠧⢤⣀⡠⢸⣏⠀\n" + //
                "⢠⣿⡟⡿⡝⠀⠐⠀⠁⠈⠈⡽⠁⠀⢸⣓⣚⣿⣿⠧⣤⣄⡀⠀⠀⠈⣽⣧⣿⡀\n" + //
                "⠘⢷⣧⣿⢷⣤⣤⣴⡶⣶⣾⣷⢤⣤⢾⠭⢭⣿⣿⣿⣶⣭⣝⡛⠶⠶⣳⣼⣿⡇\n" + //
                "⠀⠀⠙⠛⠛⠚⠛⠛⣿⣿⣿⣿⣟⣷⡿⠓⠛⠻⠿⢿⠟⢿⠉⠛⠻⠯⠴⠶⠛⠁\n" + //
                "⠀⠀⠀⠀⠀⠀⠀⢠⣿⣽⡯⢿⣿⡟⠷⠶⢲⡖⠶⢼⣴⣾⣔⠀⠀⠀⠀⠀⠀⠀\n" + //
                "⠀⠀⠀⠀⠀⠀⢀⡾⠁⠈⠛⠷⣾⣧⠀⠀⢸⣶⢾⠛⠉⠔⢿⣂⠀⠀⠀⠀⠀⠀\n" + //
                "⠀⠀⠀⠀⠀⠀⣼⠍⠂⠀⢠⢣⣿⣷⠀⠄⢸⣿⡞⡄⠀⠀⡨⢷⠆⠀⠀⠀⠀⠀\n" + //
                "⠀⠀⠀⠀⠀⢸⡣⣄⡀⠀⣎⣿⣿⣿⠀⡀⢺⣿⣿⡸⡀⢀⡰⢝⡧⠀⠀⠀⠀⠀\n" + //
                "⠀⠀⠀⠀⠀⠀⠉⠓⠮⠽⣼⠛⠿⠿⠤⠤⠿⠿⠛⢷⠯⠵⠚⠋⠀⠀⠀⠀⠀⠀");
    }

    // metodo utilizado para no inicio do jog você escolher sua classe
    public static void AdiquirirClasse() {
        while (classe != 'A' && classe != 'M' && classe != 'G' && classe != 'a' && classe != 'm' && classe != 'g') {
            System.out.println("você digitou uma classe invalida, digite novamente");
            classe = LER.next().charAt(0);
        }

        conferirClasse();
    }

    // de acordo com sua escolha define os seus status
    public static void conferirClasse() {

        switch (classe) {
            case 'A':
            case 'a':
                StatusArqueiro(statusJogador);
                break;
            case 'G':
            case 'g':
                StatusGueirro(statusJogador);
                break;
            case 'M':
            case 'm':
                StatusMago(statusJogador);
                break;
        }
    }

    // abertura do jogo (utilizar asc art para deixar mais bonito)
    public static void Abertura() {
        System.out.printf("\t\t\tMenemon RPG\n\n Escolha sua classe abaixo:\n");
        System.out.printf(
                "A --> Arqueiro -- |Vida:média| - |Defesa:média| - |Ataque:baixo| - |Passiva: Ataque prévio| - |ultimate:chuva de flechas|\n\n");
        System.out.printf(
                "G --> Guerreiro -- |Vida:alta| - |Defesa:alta| - |Ataque:médio| - |Passiva:espinhos| - |Ultimate: modo berserker|\n\n");
        System.out.printf(
                "M --> Mago -- |Vida:baixa| - |Defesa:baixa| - |Ataque:Muito alto| - |Passiva:cura| - |Ultimate: barreira impenetrável|\n");
    }

    // detalhar os status e habilidades da classe escolhida
    public static void Detalhar() {

        switch (classe) {
            case 'A':
            case 'a':
                System.out.printf("Parabéns, você agora é um arqueiro!\n");
                System.out.printf("| Vida:110 | -> | Defesa:15 | -> | Ataque:25 |\n");
                System.out.printf("Passiva: ataque prévio, logo após começar a batalha você já pode atacar.\n");
                System.out.printf(
                        "Ultimate: chuva de flechas, executa 5 ataques seguidos em um turno.\n Cooldown: três turnos.\n\n");
                break;
            case 'G':
            case 'g':
                System.out.printf("Parabéns, você agora é um guerreiro!\n");
                System.out.printf("| Vida:125 | -> | Defesa:20 | -> | Ataque:35 |\n");
                System.out.printf(
                        "Passiva: espinhos, quando você recebe um dano, o inimigo recebe 15%% do dano causado.\n");
                System.out.printf(
                        "Ultimate: modo berserker, faz um ataque que causa o dobro do dano, porém você perde 1/3 da vida.\n Cooldown: três turnos.\n\n");
                break;
            case 'M':
            case 'm':
                System.out.printf("Parabéns, você agora é um mago!\n");
                System.out.printf("| Vida:85 | -> | Defesa:10 | -> | Ataque:45 |\n");
                System.out.printf("Passiva: cura 20%% da vida a cada 2 turnos.\n");
                System.out.printf(
                        "Ultimate: barreira impenetrável, triplica sua defesa durante 2 turnos.\n Cooldown: três turnos.\n\n");
                break;
        }
    }

    public static void imprimirMatriz(char[][] matriz) {
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz.length; j++) {
                System.out.printf("\t%c ", matriz[i][j]);
            }
            System.out.printf("\n\n");
        }
    }

    public static void preencherMatriz(char[][] matriz) {
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz.length; j++) {
                matriz[i][j] = '*';
            }
        }
    }

    public static void limparTerminal(char classe) {
        System.out.print("\033[H\033[2J");
        System.out.flush();
        Detalhar();
    }

    // metodo para fazer a novimentação do personagem
    public static void movimentar(char[][] mapa) {
        // imprimirMatriz(mapa);
        System.out.printf("\t  -----------------\n");
        System.out.printf("Digite -->| W | A | S | D |<-- para se mover pelo mapa!\n");
        System.out.printf("\t  -----------------\n");
        int movimento = LER.next().charAt(0);
        int[] posiAnterior = new int[2];
        posiAnterior[0] = posiJogador[0];
        posiAnterior[1] = posiJogador[1];
        switch (movimento) {
            case 'd':
            case 'D':
                // DIREITA: só anda se a coluna atual for menor que a última coluna
                if (posiJogador[1] < mapa[0].length - 1) {
                    posiJogador[1]++;
                }
                break;

            case 'a':
            case 'A':
                // ESQUERDA: só anda se a coluna atual for maior que 0
                if (posiJogador[1] > 0) {
                    posiJogador[1]--;
                }
                break;

            case 'w':
            case 'W':
                // CIMA: só anda se a linha atual for maior que 0
                if (posiJogador[0] > 0) {
                    posiJogador[0]--;
                }
                break;

            case 's':
            case 'S':
                // BAIXO: só anda se a linha atual for menor que a última linha
                if (posiJogador[0] < mapa.length - 1) {
                    posiJogador[0]++;
                }
                break;
        }
        // Atualiza mapa do jogador
        // mapa[posiAnterior[0]][posiAnterior[1]] = '*';
        mapa[posiJogador[0]][posiJogador[1]] = 'J';

        // Move cada inimigo
        moverInimigo(posiInimigoBase, rotaInimigoBase, mapa, ehInimigoBase);
        moverInimigo(posiInimigoBase2, rotaInimigoBase2, mapa, ehInimigoBase);
        moverInimigo(posiInimigoBuff, rotaInimigoBuff, mapa, ehInimigoBuff);
        moverInimigo(posiInimigoBuff2, rotaInimigoBuff2, mapa, ehInimigoBuff);

       ;
        atualizarMapa(mapa);

        if (mapa[posiAnterior[0]][posiAnterior[1]] == 'J') {
            mapa[posiAnterior[0]][posiAnterior[1]] = '*';
        }

    }

    public static void atualizarMapa(char[][] mapa) {
        // Limpa mapa
        for (int i = 0; i < mapa.length; i++) {
            for (int j = 0; j < mapa[i].length; j++) {
                mapa[i][j] = '*';
            }
        }

        // Desenha jogador
        mapa[posiJogador[0]][posiJogador[1]] = 'J';

        // Desenha inimigos que não foram derrotados
        if (!derrotouInimigoBase) {
            mapa[posiInimigoBase[0]][posiInimigoBase[1]] = 'i';
        }
        if (!derrotouInimigoBase2) {
            mapa[posiInimigoBase2[0]][posiInimigoBase2[1]] = 'i';
        }
        if (!derrotouInimigoBuff) {
            mapa[posiInimigoBuff[0]][posiInimigoBuff[1]] = 'I';
        }
        if (!derrotouInimigoBuff2) {
            mapa[posiInimigoBuff2[0]][posiInimigoBuff2[1]] = 'I';
        }
        if (!derrotouBoss) {
            mapa[posiBoss[0]][posiBoss[1]] = 'B';
        }
    }

    public static void VerificarInimigoForaLimitea(int[] posiInimigo) {
        if (posiInimigo[0] < 0) {
            posiInimigo[0] = 0;
        }
        if (posiInimigo[0] > 14) {
            posiInimigo[0] = 14;
        }
        if (posiInimigo[1] < 0) {
            posiInimigo[1] = 0;
        }
        if (posiInimigo[1] > 14) {
            posiInimigo[1] = 14;
        }
    }

    public static void moverInimigo(int[] posiInimigo, int[] rota, char[][] mapa, char inimigo) {
        int linhaAnterior = posiInimigo[0];
        int colunaAnterior = posiInimigo[1];
        // Persegue jogador se estiver próximo (3 casas)
        if (posiJogador[0] - posiInimigo[0] <= 3 && posiJogador[0] - posiInimigo[0] >= -3 &&
                posiJogador[1] - posiInimigo[1] <= 3 && posiJogador[1] - posiInimigo[1] >= -3) {
            if (posiInimigo[0] < posiJogador[0]) {
                posiInimigo[0]++;
            } else if (posiInimigo[0] > posiJogador[0]) {
                posiInimigo[0]--;
            }
            if (posiInimigo[1] < posiJogador[1]) {
                posiInimigo[1]++;
            } else if (posiInimigo[1] > posiJogador[1]) {
                posiInimigo[1]--;
            }
        } else {
            // Patrulha simples A B
            if (posiInimigo[0] < rota[0]) {
                posiInimigo[0]++;
            } else if (posiInimigo[0] > rota[0]) {
                posiInimigo[0]--;
            }
            if (posiInimigo[1] < rota[1]) {
                posiInimigo[1]++;
            } else if (posiInimigo[1] > rota[1]) {
                posiInimigo[1]--;
            }

            // Inverte destino se chegou
            if (posiInimigo[0] == rota[0] && posiInimigo[1] == rota[1]) {
                int tempLinha = rota[0], tempCol = rota[1];
                rota[0] = rota[2];
                rota[1] = rota[3];
                rota[2] = tempLinha;
                rota[3] = tempCol;
            }
        }
        VerificarInimigoForaLimitea(posiInimigo);

        // Atualiza mapa
        mapa[linhaAnterior][colunaAnterior] = '*';
        if (!(posiInimigo[0] == posiJogador[0] && posiInimigo[1] == posiJogador[1]))
            mapa[posiInimigo[0]][posiInimigo[1]] = inimigo;
    }

    // metodo para a batalha(divir em outros metodos, para deixar mais organizado)
    public static void batalhar(int[] statusInimigo, boolean derrotouInimigo, char elementoInimigo, char qualInimigo) {
        if (derrotouInimigo) {
            return;
        }
        Random gerador = new Random();
        int quantRodada = 0;
        int defesaOriginalMago = 10;
        int ataqueOriginalGuerreiro = 35;
        int ataqueOriginalArqueiro = 30;
        int esquivou; // variavel que guarda se o jogador conseguio esquivar ou não
        char decicaoBatalha = 0;
        System.out.printf("Você iniciou uma batalha, deseja prosseguir?\n");
        quantRodada = 0;
        batalhando = true;
        switch (classe) {
            case 'g':
            case 'G':
                if(buffEscolhido == 'A' && buffEscolhido2 == 'A'){
                    statusJogador[2] = 45;
                }else if (buffEscolhido == 'A' || buffEscolhido2 == 'A') {
                    statusJogador[2] = 40;
                }else{
                    statusJogador[2] = 35;
                }
                
                break;
            case 'a':
            case 'A':
                 if(buffEscolhido == 'A' && buffEscolhido2 == 'A'){
                    statusJogador[2] = 40;
                }else if (buffEscolhido == 'A' || buffEscolhido2 == 'A') {
                    statusJogador[2] = 35;
                }else{
                    statusJogador[2] = 30;
                }
                break;
            case 'm':
            case 'M':
                 if(buffEscolhido == 'D' && buffEscolhido2 == 'D'){
                    statusJogador[1] = 20;
                }else if (buffEscolhido == 'D' || buffEscolhido2 == 'D') {
                    statusJogador[1] = 25;
                }else{
                    statusJogador[1] = 10;
                }
                break;
        }
       
        System.out.printf("vida Jogador: %d\nvida Inimigo: %d\n", statusJogador[0], statusInimigo[0]);
        if (elementoInimigo == 'A') {
            System.out.println("Esse inimigo é do tipo água.");
        }else if (elementoInimigo == 'F') {
            System.out.println("Esse inimigo é do tipo Fogo.");
        }else if (elementoInimigo == 'P') {
            System.out.println("Esse inimigo é do tipo Planta.");
        }
            
        while (true) {
            limparTerminal(classe);
            ImprimirInimigosDaBatalha(qualInimigo);
            if (iten1 == 'D' || iten2 == 'D' && foiUtilizadoItenDano == false) {
                gotoXY(35, 1);
                System.out.println("Seu poção foi ativada o inimigo tomou 15 de dano");
                statusInimigo[0] -= 15;
                foiUtilizadoItenDano = true;
            }else if (iten1 == 'E' || iten2 == 'E') {
                gotoXY(36, 1);
                System.out.println("Graças a sua poção o inimigo está envenenado e tomou 5 de dano");
                statusInimigo[0] -= 5;
            }
            danoCausadoJ = 0;
            esquivou = -1;
            quantRodada++;
            if (classe == 'm' || classe == 'M' && statusJogador[0] > 85) {
                statusJogador[0] = 85;
            }
            if (quantRodada % 3 == 0 && quantRodada != 0) {
                gotoXY(30, 1);
                System.out.println("| A --> Atacar |");
                gotoXY(31, 1);
                System.out.println("| E --> Esquivar |");
                gotoXY(32, 1);
                System.out.println("| U --> Ultimate |");
                gotoXY(33, 1);
                System.out.print("Vida Jogador " + statusJogador[0]);
                gotoXY(34, 1);
                System.out.println("Vida Inimigo " + statusInimigo[0]);
                decicaoBatalha = LER.next().charAt(0);
                while (decicaoBatalha != 'a' && decicaoBatalha != 'A' && decicaoBatalha != 'E' && decicaoBatalha != 'e'
                        && decicaoBatalha != 'U' && decicaoBatalha != 'u') {
                    System.out.printf("Ação invalida! Por favor digite novamente.\nA-atacar\nE-esquivar\nU-ultimate");
                    decicaoBatalha = LER.next().charAt(0);
                }
            } else {
                gotoXY(30, 1);
                System.out.println("| A --> Atacar |");
                gotoXY(31, 1);
                System.out.println("| E --> Esquivar |");
                 gotoXY(32, 1);
                System.out.print("Vida Jogador " + statusJogador[0]);
                gotoXY(33, 1);
                System.out.println("Vida Inimigo " + statusInimigo[0]);
                decicaoBatalha = LER.next().charAt(0);
                while (decicaoBatalha != 'a' && decicaoBatalha != 'A' && decicaoBatalha != 'E'
                        && decicaoBatalha != 'e') {
                    System.out.printf("Ação invalida! Por favor digite novamente.\nA-atacar\nE-esquivar");
                    decicaoBatalha = LER.next().charAt(0);
                }
            }
            if (decicaoBatalha == 'A' || decicaoBatalha == 'a') {
                ControlarAtaque(statusInimigo, elementoInimigo);
            }
            if (decicaoBatalha == 'e' || decicaoBatalha == 'E') {
                esquivou = ControlarEsquiva(statusInimigo);
            }

            if (decicaoBatalha == 'U' || decicaoBatalha == 'u') {
                quantRodadaUltimateM = quantRodada;
                ControlarUltimates(quantRodada, statusInimigo);
            }
            if (esquivou == -1) {
                danoCausadoI = statusInimigo[2] - statusJogador[1];
                if (danoCausadoI <= 0) {
                    danoCausadoI = 0;
                }
                statusJogador[0] -= danoCausadoI;
            }
          
            System.out.printf("Vida do jogador: %d\nVida do inimigo: %d\n", statusJogador[0], statusInimigo[0]);
            if (quantRodada == quantRodadaUltimateM + 2 && (classe == 'M' || classe == 'm')) {
                statusJogador[1] = defesaOriginalMago;
            }
            controlarAtaquesPassivos(danoCausadoI, quantRodada);
            if (classe == 'G' || classe == 'g') {
                statusJogador[2] = ataqueOriginalGuerreiro;
            }
            if (classe == 'A' || classe == 'a') {
                statusJogador[2] = ataqueOriginalArqueiro;
            }
            if (statusInimigo[0] <= 0) {
                System.out.println("Você ganhou");
                if (foiUtilizadoItenDano) {
                    foiUtilizadoItenDano = false;
                }
                break;
            }

            if (statusJogador[0] <= 0) {
                System.out.println(" ####     ######   #####    #####     ####    ######     ##\n" + //
                                        " ## ##    ##       ##  ##   ##  ##   ##  ##     ##      ####\n" + //
                                        " ##  ##   ##       ##  ##   ##  ##   ##  ##     ##     ##  ##\n" + //
                                        " ##  ##   ####     #####    #####    ##  ##     ##     ######\n" + //
                                        " ##  ##   ##       ####     ####     ##  ##     ##     ##  ##\n" + //
                                        " ## ##    ##       ## ##    ## ##    ##  ##     ##     ##  ##\n" + //
                                        " ####     ######   ##  ##   ##  ##    ####      ##     ##  ##");
                System.exit(0);
            }
        }
    }

    public static void ControlarUltimates(int quantRodada, int[] statusInimigo) {
        int danoCausadoJ;
        switch (classe) {
            case 'M':
            case 'm':
                statusJogador[1] = statusJogador[1] * 3;
                break;
            case 'g':
            case 'G':
                statusJogador[2] *= 2;
                danoCausadoJ = statusJogador[2] - statusInimigo[1];
                if (danoCausadoJ <= 0) {
                    danoCausadoJ = 0;
                }
                statusInimigo[0] -= danoCausadoJ;
                statusJogador[0] = statusJogador[0] - (statusJogador[0] / 3);
                break;
            case 'a':
            case 'A':
                statusJogador[2] *= 5;
                danoCausadoJ = statusJogador[2] - statusInimigo[1];
                if (danoCausadoJ <= 0) {
                    danoCausadoJ = 0;
                }
                statusInimigo[0] -= danoCausadoJ;
                break;

        }

    }

    public static void ControlarAtaque(int[] statusInimigo, char elementoInimigo) {
        int danoCausadoJ;
        danoCausadoJ = statusJogador[2] - statusInimigo[1];
        VerificarSuperefetividadeEFraqueza(elementoInimigo, elementoJogador);
        if (danoCausadoJ <= 0) {
            danoCausadoJ = 0;
        }
        statusInimigo[0] -= danoCausadoJ;
    }

    public static int ControlarEsquiva(int[] statusInimigo) {
        Random gerador = new Random();
        int esquivou;
        int danoCausadoI;

        esquivou = gerador.nextInt(10);
        if (esquivou < 4) {
            System.out.println("Você esquivou com sucesso!");
            return 1;
        }
            danoCausadoI = statusInimigo[2] - statusJogador[1];
            if (danoCausadoI < 0) {
                danoCausadoI = 0;
            }
            statusJogador[0] -= danoCausadoI;
            return 0;
        
    }

    public static int[] AdiquirirLimitesInimigo(int[] posiInimigo) {
        int[] limites = new int[8];
        limites[0] = posiInimigo[0] + 1;
        limites[1] = posiInimigo[1] + 1;
        limites[2] = posiInimigo[0] + 1;
        limites[3] = posiInimigo[1] - 1;
        limites[4] = posiInimigo[0] - 1;
        limites[5] = posiInimigo[1] + 1;
        limites[6] = posiInimigo[0] - 1;
        limites[7] = posiInimigo[1] - 1;
        return limites;
    }

    public static char ControlarCondiçõesBatalha(int[] limiteInimigo, int[] posiInimigo, boolean derrotou) {
        char batalha = ' ';
        if (derrotou) {
            return ' ';
        }
        if (limiteInimigo[0] == -1) {
            return ' ';
        }
        if ((posiJogador[1] == posiInimigo[1] - 1 && posiJogador[0] == posiInimigo[0]) ||
                (posiJogador[1] == posiInimigo[1] + 1 && posiJogador[0] == posiInimigo[0]) ||
                (posiJogador[1] == posiInimigo[1] && posiJogador[0] == posiInimigo[0] - 1) ||
                (posiJogador[1] == posiInimigo[1] && posiJogador[0] == posiInimigo[0] + 1) ||
                (posiJogador[1] == limiteInimigo[1] && posiJogador[0] == limiteInimigo[0]) ||
                (posiJogador[1] == limiteInimigo[3] && posiJogador[0] == limiteInimigo[2]) ||
                (posiJogador[1] == limiteInimigo[5] && posiJogador[0] == limiteInimigo[4]) ||
                (posiJogador[1] == limiteInimigo[7] && posiJogador[0] == limiteInimigo[6])) {
            System.out.println("Deseja batalhar contra esse inimigo? Para sim digite 1, para não digite 2");
            batalha = LER.next().charAt(0);
            while (batalha != '2' && batalha != '1') {
                batalha = LER.next().charAt(0);
                System.out.printf("Ação invalida! Por favor digite novamente.\nDeseja batalhar contra esse inimigo? Para sim digite 1, para não digite 2");

            }
        }
        return batalha;
    }

    public static void restaurarStatusInimigoBase() {
        inimigoBase[0] = 70;
        if (classe == 'A' || classe == 'a') {
            inimigoBase[0] -= 10;
        }

    }

    public static void restaurarStatusInimigoBuff() {
        inimigoBuff[0] = 70;
        if (classe == 'A' || classe == 'a') {
            inimigoBuff[0] -= 7;
        }
    }

    public static void restaurarStatusJogador() {
        switch (classe) {
            case 'a':
            case 'A':
                if(buffEscolhido == 'V' && buffEscolhido2 == 'V'){
                    statusJogador[0] = 120;
                }else if (buffEscolhido == 'V' || buffEscolhido2 == 'V') {
                    statusJogador[0] = 115;
                }else{
                    statusJogador[0] = 110;
                }
            case 'm':
            case 'M':
                if(buffEscolhido == 'V' && buffEscolhido2 == 'V'){
                    statusJogador[0] = 95;
                }else if (buffEscolhido == 'V' || buffEscolhido2 == 'V') {
                    statusJogador[0] = 90;
                }else{
                    statusJogador[0] = 85;
                }
                break;
            case 'g':
            case 'G':
                if(buffEscolhido == 'V' && buffEscolhido2 == 'V'){
                    statusJogador[0] = 135;
                }else if (buffEscolhido == 'V' || buffEscolhido2 == 'V') {
                    statusJogador[0] = 130;
                }else{
                    statusJogador[0] = 125;
               }
    }
}

    public static void ControlarEntrarBatalha(char[][] mapa) { // metodo que confere se o jogdor quer ou não batalhar
        char batalha = ' ';
        batalha = ControlarCondiçõesBatalha(limitesInimigoBase, posiInimigoBase, derrotouInimigoBase);
        if (batalha == '1') {
            enfrentandoInimigoBase = true;
            batalhar(inimigoBase, derrotouInimigoBase,elementoInimigoBase, ehInimigoBase);
            derrotouInimigoBase = true;
            enfrentandoInimigoBase = true;
            batalhando = false;
            restaurarStatusJogador();
        }
        batalha = ControlarCondiçõesBatalha(limitesInimigoBase2, posiInimigoBase2, derrotouInimigoBase2);
        if (batalha == '1') {
            derrotouInimigoBase2 = true;
            batalhar(inimigoBase2, derrotouInimigoBase2, elementoInimigoBase2, ehInimigoBase);
            derrotouInimigoBase2 = true;
            batalhando = false;
            enfrentandoInimigoBase2 = true;
            restaurarStatusJogador();
        }
        batalha = ControlarCondiçõesBatalha(limitesInimigoBuff, posiInimigoBuff, derrotouInimigoBuff);
        if (batalha == '1') {
            enfrentandoInimigoBuff = true;
            batalhar(inimigoBuff, derrotouInimigoBuff, elementoInimigoBuff, ehInimigoBuff);
            derrotouInimigoBuff = true;
            batalhando = false;
            enfrentandoInimigoBuff = true;
            restaurarStatusJogador();
        }
        batalha = ControlarCondiçõesBatalha(limitesInimigoBuff2, posiInimigoBuff2, derrotouInimigoBuff2);
        if (batalha == '1') {
            enfrentandoInimigoBuff2 = true;
            batalhar(inimigoBuff2, derrotouInimigoBuff2, elementoInimigoBuff2, ehInimigoBuff);
            derrotouInimigoBuff2 = true;
            enfrentandoInimigoBuff2 = true;
            batalhando = false;
            restaurarStatusJogador();
        }
        batalha = ControlarCondiçõesBatalha(limitesBoss, posiBoss, derrotouBoss);
        if (batalha == '1') {
            enfrentandoBoss = true;
            batalhar(inimigoBoss, derrotouBoss, elementoBoss, ehBoss);
            derrotouBoss = true;
            enfrentandoBoss = true;
        }
        if (derrotouInimigoBase == true) {
            for (int i = 0; i < inimigoBase.length; i++) {
                limitesInimigoBase[i] = -1;
            }
            mapa[posiInimigoBase[0]][posiInimigoBase[1]] = '*';

        }
        if (derrotouInimigoBase2 == true) {
            for (int i = 0; i < inimigoBase.length; i++) {
                limitesInimigoBase2[i] = -1;
            }
            mapa[posiInimigoBase2[0]][posiInimigoBase2[1]] = '*';

        }
        if (derrotouInimigoBuff == true) {
            for (int i = 0; i < inimigoBase.length; i++) {
                limitesInimigoBuff[i] = -1;
            }
            mapa[posiInimigoBuff[0]][posiInimigoBuff[1]] = '*';

        }
        if (derrotouInimigoBuff2 == true) {
            for (int i = 0; i < inimigoBase.length; i++) {
                limitesInimigoBuff2[i] = -1;
            }
            mapa[posiInimigoBuff2[0]][posiInimigoBuff2[1]] = '*';
        }
        if (derrotouBoss == true) {
            for (int i = 0; i < inimigoBase.length; i++) {
                limitesBoss[i] = -1;
            }
            mapa[posiBoss[0]][posiBoss[1]] = '*';
        }

    }

    public static void controlarAtaquesPassivos(int danoCausadoI, int quantTurnos) {
        int danoCausadoEspinhos;
        int vidaMago = 85;
        switch (classe) {
            case 'M':
            case 'm':
                if (quantTurnos % 2 == 0) {
                    statusJogador[0] += (vidaMago * 0.2);
                }
                break;

            case 'G':
            case 'g':
                if (enfrentandoInimigoBase == true) {
                    danoCausadoEspinhos = danoCausadoI / 10;
                    inimigoBase[0] -= danoCausadoEspinhos;
                } else if (enfrentandoInimigoBuff == true) {
                    danoCausadoEspinhos = danoCausadoI / 10;
                    inimigoBuff[0] -= danoCausadoEspinhos;
                } else if (enfrentandoBoss == true) {
                    danoCausadoEspinhos = danoCausadoI / 10;
                    inimigoBoss[0] -= danoCausadoEspinhos;
                }
                break;
            case 'A':
            case 'a':
                inimigoBase[0] -= 10;
                inimigoBuff[0] -= 7;
                inimigoBoss[0] -= 18;
                break;

        }
    }

    public static void ChecarColisaoEIniciarBatalha(boolean derrotouInimigo, int[] posiInimigo) {
        if (derrotouInimigo) {
            return;
        }
        if (posiInimigo[0] == posiJogador[0] && posiInimigo[1] == posiJogador[1]) {
            System.out.println("Você colidiu com o inimigo! Que a batalha comece!");
            if (posiInimigo == posiInimigoBase) {
                batalhar(inimigoBase, derrotouInimigoBase, elementoInimigoBase, ehInimigoBase);
                derrotouInimigoBase = true;
                batalhando = false;
                restaurarStatusJogador();
            } else if (posiInimigo == posiInimigoBase2) {
                batalhar(inimigoBase2, derrotouInimigoBase2, elementoInimigoBase2, ehInimigoBase);
                derrotouInimigoBase2 = true;
                batalhando = false;
                restaurarStatusJogador();
            } else if (posiInimigo == posiInimigoBuff) {
                batalhar(inimigoBuff, derrotouInimigoBuff, elementoInimigoBuff, ehInimigoBuff);
                derrotouInimigoBuff = true;
                batalhando = false;
                restaurarStatusJogador();
            } else if (posiInimigo == posiInimigoBuff2) {
                batalhar(inimigoBuff2, derrotouInimigoBuff2, elementoInimigoBuff2, ehInimigoBuff);
                derrotouInimigoBuff2 = true;
                batalhando = false;
                restaurarStatusJogador();
            }
        }
    }

    public static void ObterElemento() {
        if ((derrotouInimigoBase || derrotouInimigoBase2 || derrotouInimigoBuff || derrotouInimigoBuff2)
                && jaEscolhiOElemento == false) {
            System.out.printf("Você desbloqueou uma nova habilidade, você pode selecionar seu elemento\n");
            System.out.printf("Lembre-se que cada elemento tem sua fraqueza e sua superioridade a outro elemento\\n");
            System.out.printf("Fogo tem fraqueza contra água e superioridade contra planta\n");
            System.out.printf("Planta tem fraqueza contra fogo e superioridade contra água\n");
            System.out.printf("Água tem fraqueza contra planta e superioridade contra fogo\n    ");
            System.out.printf("Qual elemento você deseja?\nF-fogo\nA-água\nP-planta\n");
            elementoJogador = LER.next().charAt(0);
            while (elementoJogador != 'F' && elementoJogador != 'f' && elementoJogador != 'a'
                    && elementoJogador != 'A' && elementoJogador != 'p' && elementoJogador != 'P') {
                System.out.printf(
                        "elemento invalido digite novamente\n Qual elemento você deseja?\nF-fogo\nA-água\nP-planta\n");
                elementoJogador = LER.next().charAt(0);
            }
            jaEscolhiOElemento = true;

        }
    }

    

    public static void VerificarMorteBoss() {
        if (inimigoBoss[0] <= 0) {
            System.out.println("Parabéns você salvou a cidade dos montros!!!");
            System.out.println("⠀⠀⠀⠀⠀⠀⢀⣠⣴⠶⠶⣦⣤⣀⣤⣶⣶⣶⡶⠶⠶⠶⠶⠶⠶⠶⠶⠶⠶⠶⠶⠶⣶⣶⣶⣦⣄⣤⣴⠶⠶⢦⣤⡀⠀⠀⠀⠀⠀⠀\n" + //
                                "⠀⠀⠀⠀⠀⢠⡿⠉⢀⣠⣀⣀⠈⣽⠏⠉⠉⠙⠛⠛⠛⠛⠛⠛⠛⠛⠛⠛⠛⠛⠛⠛⠛⠉⠉⠉⣿⠁⣄⣦⣤⣀⠈⠻⣦⠀⠀⠀⠀⠀\n" + //
                                "⠀⠀⠀⠀⠀⣿⠀⢠⡟⠉⠉⠉⠛⣿⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢹⡟⠋⠉⠉⢻⡆⠀⢻⡄⠀⠀⠀⠀\n" + //
                                "⠀⠀⠀⠀⠀⣿⠀⢸⡇⠀⠀⠀⠀⣿⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢸⡇⠀⠀⠀⠈⣷⠀⢸⡇⠀⠀⠀⠀\n" + //
                                "⠀⠀⠀⠀⠠⣿⠀⠸⣇⠀⠀⠀⠀⣿⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢸⡇⠀⠀⠀⢰⡏⠀⣸⠇⠀⠀⠀⠀\n" + //
                                "⠀⠀⠀⠀⠀⢻⣆⠀⢻⣄⠀⠀⠀⢻⡆⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣿⠀⠀⠀⢀⡾⠁⢀⡿⠀⠀⠀⠀⠀\n" + //
                                "⠀⠀⠀⠀⠀⠀⢻⣆⠀⠹⣧⣄⠀⠈⢷⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣼⠃⠀⢀⣴⠟⠁⢠⡾⠁⠀⠀⠀⠀⠀\n" + //
                                "⠀⠀⠀⠀⠀⠀⠀⠙⢷⣄⠀⠙⠻⢦⣼⣷⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⣼⣯⣴⠾⠋⠁⣀⣴⠟⠁⠀⠀⠀⠀⠀⠀\n" + //
                                "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠉⠻⢦⣄⣀⠈⠉⠻⣆⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣠⡾⠋⠁⢀⣠⣤⠾⠋⠁⠀⠀⠀⠀⠀⠀⠀⠀\n" + //
                                "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠈⠙⠛⠲⠶⠼⢷⣤⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣠⣾⠿⠶⠶⠛⠋⠉⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" + //
                                "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠈⠻⣦⡀⠀⠀⠀⠀⠀⣠⡾⠋⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" + //
                                "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠈⢷⡄⠀⠀⢀⡾⠋⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" + //
                                "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣿.⠀⣾⠃⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" + //
                                "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⡿⠀⠀⢻⡆⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" + //
                                "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⣾⠃⠀⠀⠈⢿⡄⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" + //
                                "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⡾⠁⠀⠀⠀⠀⠀⢻⡄⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" + //
                                "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⣾⣁⣀⣀⣀⣀⣀⣀⣀⣿⣄⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" + //
                                "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢠⡟⠉⠉⠉⠉⠉⠉⠉⠉⠉⠉⠹⡇⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" + //
                                "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢸⡇⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⡇⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" + //
                                "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣼⠿⠶⠶⠶⠶⠶⠶⠶⠶⠶⠶⠾⢷⡄⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" + //
                                "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢿⣤⣤⣤⣤⣤⣤⣤⣤⣤⣤⣤⣤⣼⠇⠀⠀⠀                 \n" + //
                                "                     YOU WIN!                                \n" + //
                                "                                                              ");
            System.exit(0);
        }
    }
    public static void DistribuirElementos(){
        boolean jaDistribuioElemento = false;
        if (derrotouInimigoBase && jaDistribuioElemento == false) {
            elementoInimigoBase2 = 'F';
            elementoInimigoBuff = 'A';
            elementoInimigoBuff2 = 'P';
            jaDistribuioElemento = true;
        }else if (derrotouInimigoBase2 && jaDistribuioElemento == false) {
            elementoInimigoBase = 'F';
            elementoInimigoBuff = 'A';
            elementoInimigoBuff2 = 'P';
            jaDistribuioElemento = true;
        }else if (derrotouInimigoBuff && jaDistribuioElemento == false) {
            elementoInimigoBase = 'F';
            elementoInimigoBase2 = 'A';
            elementoInimigoBuff2 = 'P';
            jaDistribuioElemento = true;
        }else if (derrotouInimigoBuff2 && jaDistribuioElemento == false) {
            elementoInimigoBase = 'F';
            elementoInimigoBase2 = 'A';
            elementoInimigoBuff = 'P';
            jaDistribuioElemento = true;
        }
        elementoBoss = 'X';
    }
    public static void VerificarSuperefetividadeEFraqueza(char elementoInimigo, char elementoJogador){
        if (elementoJogador == 'P' && elementoInimigo == 'A') {
            danoCausadoJ *= 1.5;
        }else if (elementoJogador == 'P' && elementoInimigo == 'F') {
            danoCausadoI /= 1.5;
        }else if (elementoJogador == 'P' && elementoInimigo == 'P') {
            danoCausadoJ *= 1;
        }
        if (elementoJogador == 'F' && elementoInimigo == 'P') {
            danoCausadoJ *= 1.5;
        }else if (elementoJogador == 'F' && elementoInimigo == 'A') {
            danoCausadoI /= 1.5;
        }else if (elementoJogador == 'F' && elementoInimigo == 'F') {
            danoCausadoJ *= 1;
        }
        if (elementoJogador == 'A' && elementoInimigo == 'P') {
            danoCausadoJ /= 1.5;
        }else if (elementoJogador == 'A' && elementoInimigo == 'A') {
            danoCausadoI *= 1;
        }else if (elementoJogador == 'A' && elementoInimigo == 'F') {
            danoCausadoJ *= 1.5;
        }
        
    }
    public static void DistribuirBuffEItens(){
        Random gerarItens = new Random();
        int qualIten = 0;
        if (derrotouInimigoBuff && jaEscolhiBuff1 == false) {
            System.out.printf("você derrotou um inimigo mais forte, parabéns!! agora pode escolher um buff de status, aumentara 5 pontos no status escolhido\n");
            System.out.printf("V-Vida\nA-Ataque\nD-Defesa");
            buffEscolhido = LER.next().charAt(0);
            while (buffEscolhido != 'v' && buffEscolhido == 'V' && buffEscolhido == 'A' && buffEscolhido == 'b' && buffEscolhido == 'B' && buffEscolhido == 'A') {
                System.out.printf("você derrotou um inimigo mais forte, parabéns!! agora pode escolher um buff de status, aumentara 5 pontos no status escolhido\n");
                System.out.printf("V-Vida\nA-Ataque\nD-Defesa");
                buffEscolhido = LER.next().charAt(0);
            }
            qualIten = gerarItens.nextInt(9);
            if (qualIten > 4) {
                System.out.println("Você Ganhou uma poção de dano, ela causa 15 de dano ao oponente.");
                iten1 = 'D';
            }else{
                System.out.println("Você Ganhou uma poção de envenenamento, ela causa 5 de dano a cada turno ao oponente.");
                iten1 = 'E';
            }
            jaEscolhiBuff1 = true;
        }
        if (derrotouInimigoBuff2 && jaEscolhiBuff2 == false) {
            System.out.printf("você derrotou um inimigo mais forte, parabéns!! agora pode escolher um buff de status, aumentara 5 pontos no status escolhido\n");
            System.out.printf("V-Vida\nA-Ataque\nD-Defesa");
            buffEscolhido2 = LER.next().charAt(0);
            while (buffEscolhido2 != 'v' && buffEscolhido2 == 'V' && buffEscolhido2 == 'A' && buffEscolhido == 'b' && buffEscolhido == 'B' && buffEscolhido == 'A') {
                System.out.printf("você derrotou um inimigo mais forte, parabéns!! agora pode escolher um buff de status, aumentara 5 pontos no status escolhido\n");
                System.out.printf("V-Vida\nA-Ataque\nD-Defesa");
                buffEscolhido2 = LER.next().charAt(0);
            }
            qualIten = gerarItens.nextInt(9);
            if (qualIten > 4) {
                System.out.println("Você Ganhou uma poção de dano, ela causa 15 de dano ao oponente.");
                iten2 = 'D';
            }else{
                System.out.println("Você Ganhou uma poção de envenenamento, ela causa 5 de dano a cada turno ao oponente.");
                iten2 = 'E';
            }
            
            jaEscolhiBuff2 = true;
        }
        if (buffEscolhido == 'V' || buffEscolhido == 'v' || buffEscolhido2 == 'v' || buffEscolhido2 == 'V') {
            statusJogador[0] += 10;
        }
        if (buffEscolhido == 'd' || buffEscolhido == 'D' || buffEscolhido2 == 'd' || buffEscolhido2 == 'D') {
            statusJogador[1] += 10;
        }
        if (buffEscolhido == 'a' || buffEscolhido == 'A' || buffEscolhido2 == 'a' || buffEscolhido2 == 'A') {
            statusJogador[2] += 10;
        }
        
    }
    public static void gotoXY(int linha, int coluna) {
        char escCode = 0x1B;
        System.out.print(String.format("%c[%d;%df", escCode, linha, coluna));
    }
    public static void ImprimirInimigosDaBatalha(char qualInimigo){
        if (classe == 'M' || classe == 'm' && qualInimigo == 'i' && batalhando) {
            ImprimirMago();
            ImprimirInimigoBase();
        }else if (classe == 'M' || classe == 'm' && qualInimigo == 'I' && batalhando) {
            ImprimirMago();
            ImprimirInimigoBuff();
        }else if (classe == 'M' || classe == 'm' && qualInimigo == 'B'  && batalhando) {
            ImprimirMago();
            ImprimirBoss();
        }else if (classe == 'A' || classe == 'a' && qualInimigo == 'i') {
            ImprimirArqueiro();
            ImprimirInimigoBase();
        }else if (classe == 'A' || classe == 'a' && qualInimigo == 'I' && batalhando) {
            ImprimirArqueiro();
            ImprimirInimigoBuff();
        }else if (classe == 'A' || classe == 'a' && qualInimigo == 'B'  && batalhando) {
            ImprimirArqueiro();
            ImprimirBoss();
        }else if (classe == 'G' || classe == 'g' && qualInimigo == 'i'  && batalhando) {
            ImprimirGuerreiro();
            ImprimirInimigoBase();
        }else if (classe == 'G' || classe == 'g' && qualInimigo == 'I'  && batalhando) {
            ImprimirGuerreiro();
            ImprimirInimigoBuff();
        }else if (classe == 'G' || classe == 'g' && qualInimigo == 'B' && batalhando) {
            ImprimirGuerreiro();
            ImprimirBoss();
        }else if (batalhando == false) {
            limparTerminal(classe);
        }
            
        
    }
    public static void main(String[] args) {
        char[][] mapa = new char[15][15];
        char batalha = ' ';
        preencherMatriz(mapa);
        StatusInimigoBase(inimigoBase);
        StatusInimigoBase(inimigoBase2);
        StatusInimigoBuff(inimigoBuff);
        StatusInimigoBuff(inimigoBuff2);
        StatusBoss(inimigoBoss);
        posiJogador[0] = 0;
        posiJogador[1] = 0;
        Abertura();
        classe = LER.next().charAt(0);
        AdiquirirClasse();
        Detalhar();
        System.out.println("Digite I para dar inicio ao seu jogo, boa sorte nesta aventura!");
        char iniciar = LER.next().charAt(0);
        while (iniciar != 'I' && iniciar != 'i') {
            System.out.println("Ação invalida! Por favor digite novamente.");
            iniciar = LER.next().charAt(0);
        }
        if (iniciar == 'I' || iniciar == 'i') {
            limparTerminal(classe);
        }
        // colocar os jogadores e inimigos no mapa
        // mapa[0][0] = 'J';
        // mapa[14][14] = 'B';
        // mapa[4][2] = 'i';
        // mapa[11][1] = 'i';
        // mapa[1][13] = 'I';
        // mapa[10][9] = 'I';
        // mapa[0][7] = 'b';

        // adribuindo a posição dos inimigo a vetores
        posiInimigoBase[0] = 4;
        posiInimigoBase[1] = 2;
        posiInimigoBase2[0] = 11;
        posiInimigoBase2[1] = 1;
        posiInimigoBuff[0] = 1;
        posiInimigoBuff[1] = 13;
        posiInimigoBuff2[0] = 10;
        posiInimigoBuff2[1] = 9;
        // adribuindo os limites dos inimigos/Baús aos vetores
        limitesInimigoBase = AdiquirirLimitesInimigo(posiInimigoBase);
        limitesInimigoBase2 = AdiquirirLimitesInimigo(posiInimigoBase2);
        limitesInimigoBuff = AdiquirirLimitesInimigo(posiInimigoBuff);
        limitesInimigoBuff2 = AdiquirirLimitesInimigo(posiInimigoBuff2);
        limitesBoss = AdiquirirLimitesInimigo(posiBoss);
       


        // loop para fazer a movimentação de forma infinita até que o personagem entre
        // em uma batalha
        while (true) {
            movimentar(mapa);
            ChecarColisaoEIniciarBatalha(derrotouInimigoBase, posiInimigoBase);
            ChecarColisaoEIniciarBatalha(derrotouInimigoBase2, posiInimigoBase2);
            ChecarColisaoEIniciarBatalha(derrotouInimigoBuff, posiInimigoBuff);
            ChecarColisaoEIniciarBatalha(derrotouInimigoBuff2, posiInimigoBuff2);
            ChecarColisaoEIniciarBatalha(derrotouBoss, posiBoss);

            ControlarEntrarBatalha(mapa);

            limitesInimigoBase = AdiquirirLimitesInimigo(posiInimigoBase);
            limitesInimigoBase2 = AdiquirirLimitesInimigo(posiInimigoBase2);
            limitesInimigoBuff = AdiquirirLimitesInimigo(posiInimigoBuff);
            limitesInimigoBuff2 = AdiquirirLimitesInimigo(posiInimigoBuff2);
            limitesBoss = AdiquirirLimitesInimigo(posiBoss);

            mapa[posiJogador[0]][posiJogador[1]] = 'J';

            limparTerminal(classe); // limpar terminal e imprimir detalhes
            imprimirMatriz(mapa); // imprimir mapa atualizado
            ObterElemento();
            VerificarMorteBoss();
            DistribuirElementos();
            DistribuirBuffEItens();
        }
    }
}
