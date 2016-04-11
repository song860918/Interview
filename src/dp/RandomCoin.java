package dp;

public enum RandomCoin implements Coin {

    COIN1(3),
    COIN2(5);

    private int denomination;

    public int getDenomination() {
        return denomination;
    }

    RandomCoin(int denomination) {
        this.denomination = denomination;
    }


}
