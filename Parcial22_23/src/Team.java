import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
public class Team {
    private static final int POINTS_FOR_WIN = 3; // puntos por ganar
    private static final int POINTS_FOR_DRAW = 1; // puntos por empate
    private static final int NAME_LIMIT = 20;
    public static final int SIZE = 8 + 2* NAME_LIMIT + 4 + 16 + 16;
    private long id;
    private String name;
    private int points;
    private StatVar goalsScored; // goles que ha marcado
    private StatVar goalsConceded; // goles que han recibido
    public Team(long id, String name) {
        this.id = id;
        this.name = name;
        this.points = 0;
        this.goalsScored = new StatVar();
        this.goalsConceded = new StatVar();
    }
    public byte[] toBytes() {

       //no lo pide el examen
    }
    public static Team fromBytes(byte[] record) {

        int offset;

        long id = utils.PackUtils.unpackLong(record, offset);
        offset += 8;

        String name = utils.PackUtils.unpackLimitedString(NAME_LIMIT, record, offset);
        offset += 2 * NAME_LIMIT;

        int points = utils.PackUtils.unpackInt(record, offset);
        offset += 4;

        StatVar goalsScored = StatVar.unpack(record, offset);
        offset += StatVar.SIZE;

        StatVar goalsConceded = StatVar.unpack(record, offset);
        offset += StatVar.SIZE;

        return new Team(id, name, points, goalsScored, goalsConceded);

    }

    public void addGameResult(int scored, int conceded) {
        //potser cambia la estadistica  de gols A CONSIDERAR
        if(scored > conceded) { //si he ganadao
            this.points += POINTS_FOR_WIN;
        } else if(scored == conceded) { //si he empatado
          this.points += POINTS_FOR_DRAW;
        }

        this.goalsScored.addObservation(scored);
        this.goalsConceded.addObservation(conceded);

    }

    public long getId() { return this.id; }

}
