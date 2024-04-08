
import java.util.ArrayList;
import java.util.List;

public class Game {

    public GameResult game(Balance balance, float buyIn, float tableResult, float[] rebuys, Balance[] refils, float[] rebuysTR) {
        return gameSitLeave(balance, buyIn, tableResult, rebuys, refils, rebuysTR);
    }


    public GameResult gameSitLeave(Balance balance, float buyIn, float tableResult, float[] rebuys, Balance[] refils, float[] rebuysTR) {
        System.out.println("Баланс юзера: " + balance);
        System.out.println("Байин за стол: " + buyIn);

        /*
        Концепция мнимый выход со стола:
        в случае когда юзер хочет сделать ребай:
        1. мы должны определить его текуший результат за столом
        2. сделать "мнимый выход со стола", т.е. посчитать сколько мы ему должны были начислить реальных и бонусных средств
        3. далее сделать посадку за стол, с "мнимым резалтом" и с ребаем, т.е. "как бы начислить ему на баланс" и списать потом,
        чтобы пропорция бонусных и реальных средств пересчиталась относительно текущего резалта за столом

        если коротко: просто делаем встал/сел, и пересчитываем пропорцию реальных и бонусных среди всех байина и ребаев

         */

        List<Balance> balanceCharged = new ArrayList<>(); // сюда будем класть списания с реального баланса, чтобы помнить в какой пропорции списались бонусные и реальные средства
        Balance newBal = new Balance(); // сюда будем класть новый баланс пользователя, отражающий реальный баланс после списания байина/ребая
        Balance returnBalance = new Balance(); //сюда будем класть баланс, который пользователю нужно начислить на его баланс в руме по выходу со стола. т.е. по сути как его тейбл резалт записывается на бонусный и реальный баланс
        float lastSumBuyIn = buyIn; //сюда будем класть сумму всех байинов и ребаев за столом, нужна просто для проверки что всё учли. на логику не влияет
        float lastBuyIn = buyIn; //сюда будем класть значение байина или ребая в определенный момент времени, но с поправкой на то, чтоб при ребае, мы делаем "мнимный выход со стола"


        boolean sitIn = false; //отображает состояние - получилось ли сесть за стол юзеру, т.е. хватило ли средств чтобы закупиться

        System.out.println("-----------Садимся за стол----------------");
        newBal = applyBuyIn(balance, buyIn); // расчитываем новый баланс, т.е. списываем по правилу 50/50 + краевые случаи: реальных больше/реальных меньше чем бонусных. в итоге получаем новый баланс юзера в руме
        balanceCharged.add(calculateTotalCharge(balance, newBal.real, newBal.bonus)); // расчитываем сколько в итоге бонусных и реальных средств списало с баланса юзера, и запоминаем эти значения, чтобы знаьт пропорцию
        sitIn = buyIn(balance, buyIn, newBal.real, newBal.bonus); //обновляем баланс в руме, согласо тому, сколько нужно было списать для байина реальныйх и бонусных средств

        makeDeposit(balance, refils); // делаем пополнение средств, бонусных и/или реальных

        int i = 0; // счетчик количества ребаев
        for (float rebuy : rebuys) { //запускаем логику обработки ребаев, т.е. перерасчет списание с баланса рума и перерасчет пропорции бонусных и реальных, которые списаны были для посадки/продолжения игры за столом
            System.out.println("-----------Делаем ребай----------------");
            float rebuyTR = rebuysTR[i];

            System.out.println("Рейбай: " + rebuy + " резалт на столе: " + rebuyTR);
            //делаем "мнимый выход со стола, беря в расчет текущий результат на столе, во время запроса ребая
            //по итогу получаем суммы реального и бонусного баланса, которые якобы надо было вернуть пользователю как "результат стола"
            //но мы только из "запоминаем", чтобы понимать пропорцию между бонусами и реальными
            chargeByBuyinRebuySUM(balance, rebuyTR, balanceCharged, lastBuyIn, returnBalance);

            balanceCharged.clear(); // обнуляем все пропорции списаний, т.к. якобы начислили ему на баланс у руме текущий результат стола

            //списываем посадку с тем же резалтом, с которым сделали "мнимый выход со стола".
            //В общем случае этим списание делать смысла нет,
            // просто надо запоминать сколько и в какой пропорции средства бы начислили юзеру. если бы он встал в этот момент
            System.out.println("-----------списываем посадку с тем же резалтом----------------");
            newBal = applyBuyIn(balance, rebuyTR); // расчитываем новый баланс, НО как будто он с релазтом вышел со стола и сел с байином равным резалту, т.е. списываем по правилу 50/50 + краевые случаи: реальных больше/реальных меньше чем бонусных. в итоге получаем новый баланс юзера в руме
            balanceCharged.add(calculateTotalCharge(balance, newBal.real, newBal.bonus)); // расчитываем сколько в итоге бонусных и реальных средств списало с баланса юзера, и запоминаем эти значения, чтобы знаьт пропорцию
            sitIn = buyIn(balance, rebuyTR, newBal.real, newBal.bonus);//обновляем баланс в руме, согласо тому, сколько нужно было списать для байина реальныйх и бонусных средств

            //списываем посадку с ребаем
            System.out.println("-----------списываем посадку с ребаем----------------");
            newBal = applyBuyIn(balance, rebuy); // расчитываем новый баланс, НО уже для очередного ребая, т.е. списываем по правилу 50/50 + краевые случаи: реальных больше/реальных меньше чем бонусных. в итоге получаем новый баланс юзера в руме
            balanceCharged.add(calculateTotalCharge(balance, newBal.real, newBal.bonus));// расчитываем сколько в итоге бонусных и реальных средств списало с баланса юзера, и запоминаем эти значения, чтобы знаьт пропорцию
            sitIn = buyIn(balance, rebuy, newBal.real, newBal.bonus);//обновляем баланс в руме, согласо тому, сколько нужно было списать для байина реальныйх и бонусных средств

            lastBuyIn = rebuyTR + rebuy; // запоминаем комбинацию резалт на столе, далее мы с эти резалтом сделали "мнимый выход со стола" и потом сделаи посадку на сумму резалта и ребая.
            // и вот это как бы "общий байин" юзера за столом, при этом в balanceCharged - у нас как раз хранится пропорция списания средств реальных и бонуснхы для "общейго байина"

            lastSumBuyIn +=  rebuy; //считаем сумму всех байин и ребаев, на логику не влияет, только для проверки

            i++;
            System.out.println("---------------------------");

        }


        if (sitIn) { //если получилось сесть за стол, то рассчитываем выход со стола
            chargeByBuyinRebuySUM(balance, tableResult, balanceCharged, lastBuyIn, returnBalance);
        } else {
            throw new IllegalStateException("Ошибка расчетов, игрок не смог сесть за стол");
        }

        return new GameResult(tableResult, lastSumBuyIn, returnBalance, balance);
    }

    private void chargeByBuyinRebuySUM(Balance balance, float tableResult, List<Balance> balanceCharged, float lastBuyIn, Balance returnBalance) {
        float gameDiff = tableResult - lastBuyIn; // считаем разницу между результатом за столом и общим байином за стол
        float balanceChargedReal = getSumReal(balanceCharged); //считаем сколько у юзера списали реальных средств для посадки за стол во время текущего байина
        float balanceChargedBonus = getSumBonus(balanceCharged);//считаем сколько у юзера списали бонусных средств для посадки за стол во время текущего байина
        returnBalance.real = balanceChargedReal + gameDiff; //считаем сколько надо начислить(списать) юзеру реальных средств, посколку реальные средства в приоритете, то сначала начисляем(списываем) реальные средства
        returnBalance.bonus = balanceChargedBonus; // считаем сколько надо начислить(списать) юзеру бонусных средств, по факту просто начисляем столько, сколько и списали, а далее будем списывать из бонусных, если реальных не хватит
        if (returnBalance.real < 0) { // есил реальных средств не хватило, чтобы покрыть "потери" за столом, то списываем бонусные
            returnBalance.bonus = balanceChargedBonus + returnBalance.real; // из бонусных, вычетаем ту часть, что не покрылась реальным средствами
            returnBalance.real = 0; // обнуляем реальный баланс, точнее говорим что никаких реальных средств не вернем, т.к. всё ушло на покрытие "потерь" за столом
        }
        balance.real = balance.real + returnBalance.real; // делаем возврат средств со стола на баланс юзера в руме (реальный)
        balance.bonus = balance.bonus + returnBalance.bonus;// делаем возврат средств со стола на баланс юзера в руме (бонусный)

        System.out.println("\nВышел со стола: " + tableResult);
        System.out.println("Байин(+ребаи) был: " + lastBuyIn);
        System.out.println("Начислили юзеру: " + returnBalance);
        System.out.println("Баланс юзера новый: " + balance);
    }

    private void makeDeposit(Balance balance, Balance[] refils) {
        try {
            balance.real += refils[0].real;
            balance.bonus += refils[0].bonus;
            System.out.println("-----------Делаем депозиты----------------");
            System.out.println("Баланс юзера новый: " + balance);
        } catch (Exception e) {

        }

    }

    private float getSumBonus(List<Balance> balanceCharged) {
        float sum = 0;
        for (Balance balance : balanceCharged) {
            sum += balance.bonus;
        }
        return sum;
    }

    private float getSumReal(List<Balance> balanceCharged) {
        float sum = 0;
        for (Balance balance : balanceCharged) {
            sum += balance.real;
        }
        return sum;
    }

    private Balance applyBuyIn(Balance balance, float buyIn) {
        Balance newBal = new Balance();

        float availableChargeRealFirst = balance.real - balance.bonus; // доступные для списания в первую очередь реальные средства. для пропорции 50/50

        // Ветка 1:
        // balance.real - balance.bonus > 0 списываем реальные, и остаток 50/50
        //balance.real - balance.bonus == 0 можно списывать 50/50 и не париться
        if (availableChargeRealFirst >= 0) {
            float needChargeInProportion = availableChargeRealFirst - buyIn; //списали байин с доступных для списания в первую очередь реальных средств
            if (needChargeInProportion >= 0) { //хватило реальный средств на байин, не достигая пропорции
                //всё норм садимся за стол, списываем реальные средтва
                newBal.real = balance.real - buyIn;
                newBal.bonus = balance.bonus;

            } else { // не хватило реальных, далее списываем бонусы и реальные в пропорции
                float needChargeFromBoth = needChargeInProportion / 2; // делим пополам, и списываем в остаток байина в пропроции 50/50
                newBal.real = balance.real - availableChargeRealFirst;//списываем первую часть байина с реальных
                newBal.real = newBal.real + needChargeFromBoth;//списываем остаток 50/50 с реальных
                newBal.bonus = balance.bonus + needChargeFromBoth;//списываем остаток 50/50 с бонусных
            }
        } else {
            //Ветка 2:
            //balance.real - balance.bonus < 0 списываем 50/50 и остаток с бонусов

            float needChargeBoth = buyIn / 2;
            newBal.real = balance.real - needChargeBoth;
            newBal.bonus = balance.bonus - needChargeBoth;
            if (newBal.real < 0) { // не хватило реальных
                newBal.bonus = newBal.bonus + newBal.real; //списываем с бонусных
                newBal.real = 0;
            }
        }

        return newBal;
    }

    private Balance calculateTotalCharge(Balance balance, float newReal, float newBonus) {
        Balance diff = new Balance();
        diff.real = balance.real - newReal;
        diff.bonus = balance.bonus - newBonus;
        return diff;
    }

    private boolean buyIn(Balance balance, float buyIn, float newReal, float newBonus) {
        boolean sitIn;
        if (newReal >= 0 && newBonus >= 0) {
            balance.real = newReal;
            balance.bonus = newBonus;
            System.out.println("\nСел за стол, байин: " + buyIn);
            System.out.println("Баланс юзера: " + balance);
            System.out.println("Баланс юзера за столом: " + buyIn);
            sitIn = true;
        } else {
            System.out.println("Недостаточно средств! newReal=" + newReal + " newBonus=" + newBonus); //нереальная ветка
            sitIn = false;
        }
        return sitIn;
    }

    private boolean reBuy(Balance balance, float rebuy, float lastSumBuyIn, float newReal, float newBonus) {
        boolean sitIn;
        if (newReal >= 0 && newBonus >= 0) {
            balance.real = newReal;
            balance.bonus = newBonus;
            System.out.println("\nСделал ребай: " + rebuy);
            System.out.println("Баланс юзера: " + balance);
            System.out.println("Баланс юзера за столом (общий): " + lastSumBuyIn);
            sitIn = true;
        } else {
            System.out.println("Недостаточно средств! newReal=" + newReal + " newBonus=" + newBonus); //нереальная ветка
            sitIn = false;
        }
        return sitIn;
    }

}
