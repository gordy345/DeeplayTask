package utils;

public class Cell {

    private final int row;
    private final int column;
    private final int weight;

    public Cell(int row, int column, int distance) {
        this.row = row;
        this.column = column;
        this.weight = distance;
    }

    public int getRow() {
        return row;
    }

    public int getColumn() {
        return column;
    }

    public int getWeight() {
        return weight;
    }
}
