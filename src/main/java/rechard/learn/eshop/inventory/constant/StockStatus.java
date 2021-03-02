package rechard.learn.inventory.constant;

public enum StockStatus {
    Empty(0),NOT_EMPTY(1);

    int value;

    StockStatus(int value) {
        this.value = value;
    }

    public int value() {
        return value;
    }
}
