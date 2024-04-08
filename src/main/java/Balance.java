public class Balance {
    public float real = 0;
    public float bonus = 0;

    public Balance() {

    }
    public Balance(float real, float bonus) {
        this.real = real;
        this.bonus = bonus;
    }

    @Override
    public String toString() {
        return "All="+(real+bonus)+"\nreal="+real+"\nbonus="+bonus;
    }
}
