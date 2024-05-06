import java.io.IOException;
import java.io.RandomAccessFile;

public class League {
    private final RandomAccessFile raf;
    public League(String fileName) throws IOException {
        this.raf = new RandomAccessFile(fileName,"rw");
    }
    public Team readTeam(long id) throws IOException {
        this.raf.seek((id-1) * Team.SIZE);
        byte[] rec = new byte[Team.SIZE];
        this.raf.read(rec);
        return  Team.fromBytes(rec);

    }
    public boolean exists(long id) throws IOException { ... }
    public void writeTeam(Team team) throws IOException { ... }
    public int numTeams() throws IOException { ... }
    public void close() throws IOException { ... }

}

//long id = Long.parseLong(st next token)