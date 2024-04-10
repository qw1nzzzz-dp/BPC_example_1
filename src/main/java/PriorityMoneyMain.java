
public class PriorityMoneyMain {

    public static void main(String[] args) {
        //enter
        Game game = new Game();

        case1(game);

        case2(game);

        case3(game);

        case4(game);

        case5(game);

        case6(game);

        case6_multirebay(game);

        case7(game);

        case8_r100(game);

        case8_r0(game);

        case9_r100(game);

        case10(game);

        case11(game);

        case12(game);

        case13(game);

        case14(game);

        case_primer_1(game);

        case_primer_2(game);

        case_rebuy_primer_1(game);

        case_rebuy_primer_2(game);

    }

    private static void case_rebuy_primer_2(Game game) {
        System.out.println("\ncase_rebuy_primer_2");
        Balance balance = new Balance();
        balance.real = 100;
        balance.bonus = 100;

        float buyIn = 100;
        float tableResult = 150;
        float[] rebuys = {100};
        float[] rebuysTR = {0};
        Balance[] refils = {new Balance(100, 0)};

        GameResult gr = game.game(balance, buyIn, tableResult, rebuys, refils, rebuysTR);

        assertEquals("Неверная сумма байин+ребай", 200, gr.lastSumBuyIn);
        assertEquals("Неверный table result", 150, gr.tableResult);
        assertEquals("Неверный Начислили юзеру - реальный", 150, gr.returnBalance.real);
        assertEquals("Неверный Начислили юзеру - бонусный", 0, gr.returnBalance.bonus);
        assertEquals("Неверный Баланс юзера новый - реальный", 200, gr.balance.real);
        assertEquals("Неверный Баланс юзера новый - бонусный", 50, gr.balance.bonus);

        System.out.println("\n========================================================\n");
    }

    private static void case_rebuy_primer_1(Game game) {
        System.out.println("\ncase_rebuy_primer_1");
        Balance balance = new Balance();
        balance.real = 1000;
        balance.bonus = 720;

        float buyIn = 500;
        float tableResult = 550;
        float[] rebuys = {100};
        float[] rebuysTR = {300};
        Balance[] refils = {};

        GameResult gr = game.game(balance, buyIn, tableResult, rebuys, refils, rebuysTR);

        assertEquals("Неверная сумма байин+ребай", 600, gr.lastSumBuyIn);
        assertEquals("Неверный table result", 550, gr.tableResult);
        assertEquals("Неверный Начислили юзеру - реальный", 390, gr.returnBalance.real);
        assertEquals("Неверный Начислили юзеру - бонусный", 160, gr.returnBalance.bonus);
        assertEquals("Неверный Баланс юзера новый - реальный", 950, gr.balance.real);
        assertEquals("Неверный Баланс юзера новый - бонусный", 720, gr.balance.bonus);

        System.out.println("\n========================================================\n");
    }

    private static void case_primer_2(Game game) {
        System.out.println("\ncase_rebuy_primer_1");
        Balance balance = new Balance();
        balance.real = 1000;
        balance.bonus = 720;

        float buyIn = 500;
        float tableResult = 550;
        float[] rebuys = {};
        float[] rebuysTR = {};
        Balance[] refils = {};

        GameResult gr = game.game(balance, buyIn, tableResult, rebuys, refils, rebuysTR);

        assertEquals("Неверная сумма байин+ребай", 500, gr.lastSumBuyIn);
        assertEquals("Неверный table result", 550, gr.tableResult);
        assertEquals("Неверный Начислили юзеру - реальный", 440, gr.returnBalance.real);
        assertEquals("Неверный Начислили юзеру - бонусный", 110, gr.returnBalance.bonus);
        assertEquals("Неверный Баланс юзера новый - реальный", 1050, gr.balance.real);
        assertEquals("Неверный Баланс юзера новый - бонусный", 720, gr.balance.bonus);

        System.out.println("\n========================================================\n");
    }

    private static void case_primer_1(Game game) {
        System.out.println("\ncase_rebuy_primer_1");
        Balance balance = new Balance();
        balance.real = 100;
        balance.bonus = 720;

        float buyIn = 500;
        float tableResult = 450;
        float[] rebuys = {};
        float[] rebuysTR = {};
        Balance[] refils = {};

        GameResult gr = game.game(balance, buyIn, tableResult, rebuys, refils, rebuysTR);

        assertEquals("Неверная сумма байин+ребай", 500, gr.lastSumBuyIn);
        assertEquals("Неверный table result", 450, gr.tableResult);
        assertEquals("Неверный Начислили юзеру - реальный", 50, gr.returnBalance.real);
        assertEquals("Неверный Начислили юзеру - бонусный", 400, gr.returnBalance.bonus);
        assertEquals("Неверный Баланс юзера новый - реальный", 50, gr.balance.real);
        assertEquals("Неверный Баланс юзера новый - бонусный", 720, gr.balance.bonus);

        System.out.println("\n========================================================\n");
    }

    private static void case14(Game game) {
        System.out.println("\nCASE-14");
        Balance balance = new Balance();
        balance.real = 100;
        balance.bonus = 100;

        float buyIn = 200;
        float tableResult = 100;
        float[] rebuys = {100};
        float[] rebuysTR = {50};
        Balance[] refils = {new Balance(0, 100)};

        GameResult gr = game.game(balance, buyIn, tableResult, rebuys, refils, rebuysTR);

        assertEquals("Неверная сумма байин+ребай", 300, gr.lastSumBuyIn);
        assertEquals("Неверный table result", 100, gr.tableResult);
        assertEquals("Неверный Начислили юзеру - реальный", 0, gr.returnBalance.real);
        assertEquals("Неверный Начислили юзеру - бонусный", 100, gr.returnBalance.bonus);
        assertEquals("Неверный Баланс юзера новый - реальный", 0, gr.balance.real);
        assertEquals("Неверный Баланс юзера новый - бонусный", 100, gr.balance.bonus);

        System.out.println("\n========================================================\n");
    }

    private static void case13(Game game) {
        System.out.println("\nCASE-13");
        Balance balance = new Balance();
        balance.real = 100;
        balance.bonus = 100;

        float buyIn = 200;
        float tableResult = 150;
        float[] rebuys = {150};
        float[] rebuysTR = {200};
        Balance[] refils = {new Balance(100, 50)};

        GameResult gr = game.game(balance, buyIn, tableResult, rebuys, refils, rebuysTR);

        assertEquals("Неверная сумма байин+ребай", 350, gr.lastSumBuyIn);
        assertEquals("Неверный table result", 150, gr.tableResult);
        assertEquals("Неверный Начислили юзеру - реальный", 0, gr.returnBalance.real);
        assertEquals("Неверный Начислили юзеру - бонусный", 150, gr.returnBalance.bonus);
        assertEquals("Неверный Баланс юзера новый - реальный", 0, gr.balance.real);
        assertEquals("Неверный Баланс юзера новый - бонусный", 150, gr.balance.bonus);

        System.out.println("\n========================================================\n");
    }

    private static void case12(Game game) {
        System.out.println("\nCASE-12");
        Balance balance = new Balance();
        balance.real = 100;
        balance.bonus = 100;

        float buyIn = 200;
        float tableResult = 100;
        float[] rebuys = {150};
        float[] rebuysTR = {0};
        Balance[] refils = {new Balance(100, 50)};


        GameResult gr = game.game(balance, buyIn, tableResult, rebuys, refils, rebuysTR);

        assertEquals("Неверная сумма байин+ребай", 350, gr.lastSumBuyIn);
        assertEquals("Неверный table result", 100, gr.tableResult);
        assertEquals("Неверный Начислили юзеру - реальный", 50, gr.returnBalance.real);
        assertEquals("Неверный Начислили юзеру - бонусный", 50, gr.returnBalance.bonus);
        assertEquals("Неверный Баланс юзера новый - реальный", 50, gr.balance.real);
        assertEquals("Неверный Баланс юзера новый - бонусный", 50, gr.balance.bonus);

        System.out.println("\n========================================================\n");
    }

    private static void case11(Game game) {
        System.out.println("\nCASE-11");
        Balance balance = new Balance();
        balance.real = 100;
        balance.bonus = 100;

        float buyIn = 200;
        float tableResult = 100;
        float[] rebuys = {100};
        float[] rebuysTR = {200};
        Balance[] refils = {new Balance(100, 0)};

        GameResult gr = game.game(balance, buyIn, tableResult, rebuys, refils, rebuysTR);

        assertEquals("Неверная сумма байин+ребай", 300, gr.lastSumBuyIn);
        assertEquals("Неверный table result", 100, gr.tableResult);
        assertEquals("Неверный Начислили юзеру - реальный", 0, gr.returnBalance.real);
        assertEquals("Неверный Начислили юзеру - бонусный", 100, gr.returnBalance.bonus);
        assertEquals("Неверный Баланс юзера новый - реальный", 0, gr.balance.real);
        assertEquals("Неверный Баланс юзера новый - бонусный", 100, gr.balance.bonus);

        System.out.println("\n========================================================\n");
    }

    private static void case10(Game game) {
        System.out.println("\nCASE-10");
        Balance balance = new Balance();
        balance.real = 100;
        balance.bonus = 100;

        float buyIn = 200;
        float tableResult = 100;
        float[] rebuys = {100};
        float[] rebuysTR = {0};
        Balance[] refils = {new Balance(100, 0)};

        GameResult gr = game.game(balance, buyIn, tableResult, rebuys, refils, rebuysTR);

        assertEquals("Неверная сумма байин+ребай", 300, gr.lastSumBuyIn);
        assertEquals("Неверный table result", 100, gr.tableResult);
        assertEquals("Неверный Начислили юзеру - реальный", 100, gr.returnBalance.real);
        assertEquals("Неверный Начислили юзеру - бонусный", 0, gr.returnBalance.bonus);
        assertEquals("Неверный Баланс юзера новый - реальный", 100, gr.balance.real);
        assertEquals("Неверный Баланс юзера новый - бонусный", 0, gr.balance.bonus);

        System.out.println("\n========================================================\n");
    }

    private static void case9_r100(Game game) {
        System.out.println("\nCASE-9");

        Balance balance = new Balance();
        balance.real = 100;
        balance.bonus = 100;

        float buyIn = 100;
        float tableResult = 150;
        float[] rebuys = {100};
        float[] rebuysTR = {100};
        Balance[] refils = {};

        GameResult gr = game.game(balance, buyIn, tableResult, rebuys, refils, rebuysTR);

        assertEquals("Неверная сумма байин+ребай", 200, gr.lastSumBuyIn);
        assertEquals("Неверный table result", 150, gr.tableResult);
        assertEquals("Неверный Начислили юзеру - реальный", 50, gr.returnBalance.real);
        assertEquals("Неверный Начислили юзеру - бонусный", 100, gr.returnBalance.bonus);
        assertEquals("Неверный Баланс юзера новый - реальный", 50, gr.balance.real);
        assertEquals("Неверный Баланс юзера новый - бонусный", 100, gr.balance.bonus);

        System.out.println("\n========================================================\n");
    }

    private static void case8_r0(Game game) {
        System.out.println("\nCASE-8 R0");

        Balance balance = new Balance();
        balance.real = 100;
        balance.bonus = 100;

        float buyIn = 100;
        float tableResult = 300;
        float[] rebuys = {100};
        float[] rebuysTR = {0};
        Balance[] refils = {};

        GameResult gr = game.game(balance, buyIn, tableResult, rebuys, refils, rebuysTR);

        assertEquals("Неверная сумма байин+ребай", 200, gr.lastSumBuyIn);
        assertEquals("Неверный table result", 300, gr.tableResult);
        assertEquals("Неверный Начислили юзеру - реальный", 250, gr.returnBalance.real);
        assertEquals("Неверный Начислили юзеру - бонусный", 50, gr.returnBalance.bonus);
        assertEquals("Неверный Баланс юзера новый - реальный", 250, gr.balance.real);
        assertEquals("Неверный Баланс юзера новый - бонусный", 50, gr.balance.bonus);

        System.out.println("\n========================================================\n");
    }

    private static void case8_r100(Game game) {
        System.out.println("\nCASE-8 R100");

        Balance balance = new Balance();
        balance.real = 100;
        balance.bonus = 100;

        float buyIn = 100;
        float tableResult = 300;
        float[] rebuys = {100};
        float[] rebuysTR = {100};
        Balance[] refils = {};

        GameResult gr = game.game(balance, buyIn, tableResult, rebuys, refils, rebuysTR);

        assertEquals("Неверная сумма байин+ребай", 200, gr.lastSumBuyIn);
        assertEquals("Неверный table result", 300, gr.tableResult);
        assertEquals("Неверный Начислили юзеру - реальный", 200, gr.returnBalance.real);
        assertEquals("Неверный Начислили юзеру - бонусный", 100, gr.returnBalance.bonus);
        assertEquals("Неверный Баланс юзера новый - реальный", 200, gr.balance.real);
        assertEquals("Неверный Баланс юзера новый - бонусный", 100, gr.balance.bonus);

        System.out.println("\n========================================================\n");
    }

    private static void case7(Game game) {
        System.out.println("\nCASE-7");

        Balance balance = new Balance();
        balance.real = 250;
        balance.bonus = 100;

        float buyIn = 100;
        float tableResult = 150;
        float[] rebuys = {50};
        float[] rebuysTR = {0};
        Balance[] refils = {};

        GameResult gr = game.game(balance, buyIn, tableResult, rebuys, refils, rebuysTR);

        assertEquals("Неверная сумма байин+ребай", 150, gr.lastSumBuyIn);
        assertEquals("Неверный table result", 150, gr.tableResult);
        assertEquals("Неверный Начислили юзеру - реальный", 150, gr.returnBalance.real);
        assertEquals("Неверный Начислили юзеру - бонусный", 0, gr.returnBalance.bonus);
        assertEquals("Неверный Баланс юзера новый - реальный", 250, gr.balance.real);
        assertEquals("Неверный Баланс юзера новый - бонусный", 100, gr.balance.bonus);

        System.out.println("\n========================================================\n");
    }

    private static void case6(Game game) {
        System.out.println("\nCASE-6");

        Balance balance = new Balance();
        balance.real = 100;
        balance.bonus = 100;

        float buyIn = 100;
        float tableResult = 200;
        float[] rebuys = {100};
        float[] rebuysTR = {100};
        Balance[] refils = {};

        GameResult gr = game.game(balance, buyIn, tableResult, rebuys, refils, rebuysTR);

        assertEquals("Неверная сумма байин+ребай", 200, gr.lastSumBuyIn);
        assertEquals("Неверный table result", 200, gr.tableResult);
        assertEquals("Неверный Начислили юзеру - реальный", 100, gr.returnBalance.real);
        assertEquals("Неверный Начислили юзеру - бонусный", 100, gr.returnBalance.bonus);
        assertEquals("Неверный Баланс юзера новый - реальный", 100, gr.balance.real);
        assertEquals("Неверный Баланс юзера новый - бонусный", 100, gr.balance.bonus);

        System.out.println("\n========================================================\n");
    }

    private static void case6_multirebay(Game game) {
        System.out.println("\nCASE-6");

        Balance balance = new Balance();
        balance.real = 100;
        balance.bonus = 100;

        float buyIn = 100;
        float tableResult = 125;
        float[] rebuys = {50, 50};
        float[] rebuysTR = {50, 100};
        Balance[] refils = {};

        GameResult gr = game.game(balance, buyIn, tableResult, rebuys, refils, rebuysTR);

        assertEquals("Неверная сумма байин+ребай", 200, gr.lastSumBuyIn);
        assertEquals("Неверный table result", 125, gr.tableResult);
        assertEquals("Неверный Начислили юзеру - реальный", 25, gr.returnBalance.real);
        assertEquals("Неверный Начислили юзеру - бонусный", 100, gr.returnBalance.bonus);
        assertEquals("Неверный Баланс юзера новый - реальный", 25, gr.balance.real);
        assertEquals("Неверный Баланс юзера новый - бонусный", 100, gr.balance.bonus);

        System.out.println("\n========================================================\n");
    }

    private static void case5(Game game) {
        System.out.println("\nCASE-5");


        Balance balance = new Balance();
        balance.real = 50;
        balance.bonus = 100;

        float buyIn = 150;
        float tableResult = 150;
        float[] rebuys = {};
        float[] rebuysTR = {};
        Balance[] refils = {};

        GameResult gr = game.game(balance, buyIn, tableResult, rebuys, refils, rebuysTR);

        assertEquals("Неверная сумма байин+ребай", 150, gr.lastSumBuyIn);
        assertEquals("Неверный table result", 150, gr.tableResult);
        assertEquals("Неверный Начислили юзеру - реальный", 50, gr.returnBalance.real);
        assertEquals("Неверный Начислили юзеру - бонусный", 100, gr.returnBalance.bonus);
        assertEquals("Неверный Баланс юзера новый - реальный", 50, gr.balance.real);
        assertEquals("Неверный Баланс юзера новый - бонусный", 100, gr.balance.bonus);

        System.out.println("\n========================================================\n");
    }

    private static void case4(Game game) {
        System.out.println("\nCASE-4");

        Balance balance = new Balance();
        balance.real = 100;
        balance.bonus = 100;

        float buyIn = 100;
        float tableResult = 110;
        float[] rebuys = {};
        float[] rebuysTR = {};
        Balance[] refils = {};

        GameResult gr = game.game(balance, buyIn, tableResult, rebuys, refils, rebuysTR);

        assertEquals("Неверная сумма байин+ребай", 100, gr.lastSumBuyIn);
        assertEquals("Неверный table result", 110, gr.tableResult);
        assertEquals("Неверный Начислили юзеру - реальный", 60, gr.returnBalance.real);
        assertEquals("Неверный Начислили юзеру - бонусный", 50, gr.returnBalance.bonus);
        assertEquals("Неверный Баланс юзера новый - реальный", 110, gr.balance.real);
        assertEquals("Неверный Баланс юзера новый - бонусный", 100, gr.balance.bonus);

        System.out.println("\n========================================================\n");
    }

    private static void case3(Game game) {
        System.out.println("\nCASE-3");


        Balance balance = new Balance();
        balance.real = 100;
        balance.bonus = 100;

        float buyIn = 100;
        float tableResult = 60;
        float[] rebuys = {};
        float[] rebuysTR = {};
        Balance[] refils = {};

        GameResult gr = game.game(balance, buyIn, tableResult, rebuys, refils, rebuysTR);

        assertEquals("Неверная сумма байин+ребай", 100, gr.lastSumBuyIn);
        assertEquals("Неверный table result", 60, gr.tableResult);
        assertEquals("Неверный Начислили юзеру - реальный", 10, gr.returnBalance.real);
        assertEquals("Неверный Начислили юзеру - бонусный", 50, gr.returnBalance.bonus);
        assertEquals("Неверный Баланс юзера новый - реальный", 60, gr.balance.real);
        assertEquals("Неверный Баланс юзера новый - бонусный", 100, gr.balance.bonus);

        System.out.println("\n========================================================\n");
    }

    private static void case2(Game game) {
        System.out.println("\nCASE-2");

        Balance balance = new Balance();
        balance.real = 150;
        balance.bonus = 100;

        float buyIn = 100;
        float tableResult = 100;
        float[] rebuys = {};
        float[] rebuysTR = {};
        Balance[] refils = {};

        GameResult gr = game.game(balance, buyIn, tableResult, rebuys, refils, rebuysTR);

        assertEquals("Неверная сумма байин+ребай", 100, gr.lastSumBuyIn);
        assertEquals("Неверный table result", 100, gr.tableResult);
        assertEquals("Неверный Начислили юзеру - реальный", 75, gr.returnBalance.real);
        assertEquals("Неверный Начислили юзеру - бонусный", 25, gr.returnBalance.bonus);
        assertEquals("Неверный Баланс юзера новый - реальный", 150, gr.balance.real);
        assertEquals("Неверный Баланс юзера новый - бонусный", 100, gr.balance.bonus);

        System.out.println("\n========================================================\n");
    }

    private static void case1(Game game) {
        System.out.println("\nCASE-1");

        Balance balance = new Balance();
        balance.real = 100;
        balance.bonus = 100;

        float buyIn = 100;
        float tableResult = 100;
        float[] rebuys = {};
        float[] rebuysTR = {};
        Balance[] refils = {};

        GameResult gr = game.game(balance, buyIn, tableResult, rebuys, refils, rebuysTR);

        assertEquals("Неверная сумма байин+ребай", 100, gr.lastSumBuyIn);
        assertEquals("Неверный table result", 100, gr.tableResult);
        assertEquals("Неверный Начислили юзеру - реальный", 50, gr.returnBalance.real);
        assertEquals("Неверный Начислили юзеру - бонусный", 50, gr.returnBalance.bonus);
        assertEquals("Неверный Баланс юзера новый - реальный", 100, gr.balance.real);
        assertEquals("Неверный Баланс юзера новый - бонусный", 100, gr.balance.bonus);

        System.out.println("\n========================================================\n");
    }

    private static void assertEquals(String msg, float expected, float actual) {
        if (expected != actual) {
            throw new AssertionError(msg + " expected: " + expected + " actucal: " + actual);
        }
    }


}
