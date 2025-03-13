import java.util.Objects;

public class Cel {
    public int row;
    public int col;
    public String iden;

    public Cel(int row, int col) {
        this.row = row;
        this.col = col;
        this.iden = String.format("%d%d", row, col);
    }

    public boolean isEqual(Cel cel){
        return Objects.equals(this.iden, cel.iden);
    }
}
