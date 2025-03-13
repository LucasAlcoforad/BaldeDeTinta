public class Cel {
    public int row;
    public int col;
    public String iden;

    public Cel(int row, int col) {
        this.row = row;
        this.col = col;
        this.iden = String.format("%d-%d", row, col);
    }

    public Cel(String iden) {
        this.iden = iden;
        String[] parts = iden.split("-");

        this.row = Integer.parseInt(parts[0]);
        this.col = Integer.parseInt(parts[1]);
    }

}
