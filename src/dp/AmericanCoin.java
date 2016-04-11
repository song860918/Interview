package dp;

public enum AmericanCoin implements Coin {

    PENNY(1),
    NICKEL(5),
    DIME(10),
    QUARTER(25);

    private int denomination;

    public int getDenomination() {
        return denomination;
    }

    AmericanCoin(int denomination) {
        this.denomination = denomination;
    }

}
