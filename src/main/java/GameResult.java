
public class GameResult {

    public final float tableResult;
    public final float lastSumBuyIn;
    public final Balance returnBalance;
    public final Balance balance;

    public GameResult(float tableResult, float lastSumBuyIn, Balance returnBalance, Balance balance) {
        this.tableResult = tableResult;
        this.lastSumBuyIn = lastSumBuyIn;
        this.returnBalance = returnBalance;
        this.balance = balance;
    }
}
