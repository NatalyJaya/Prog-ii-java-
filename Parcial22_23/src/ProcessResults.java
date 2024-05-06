import acm.program.CommandLineProgram;
import acm.program.ConsoleProgram;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class ProcessResults extends ConsoleProgram {
    private static final String TEAMS = "teams.dat";
    private static final String RESULTS = "results.csv";
    private League league;
    private BufferedReader results;
    public void run() {
        try {
            openFiles();
            processResults();
            closeFiles();
        } catch (IOException ex) {
            println("Error");
        }
    }

    private void openFiles(String resultsName) throws IOException {
        league = new League(TEAMS);
        results = new BufferedReader(new FileReader(RESULTS));
    }
    private void closeFiles() throws IOException {
        league.close(); results.close();
    }
    private void processResults() throws IOException {
// Trata las líneas del fichero de resultados, actualizando los
// equipos del fichero de equipos en función de los resultados.
// Debéis descomponerlo en métodos auxiliares.

        String line = readLine("dimelo: ");
        StringTokenizer tk = new StringTokenizer(line," ");
        long idTeam1 = Long.parseLong(String.valueOf(tk.hasMoreTokens()));
        long idTeam2 = Long.parseLong(String.valueOf(tk.hasMoreTokens()));
        int goalsTeam1 = Integer.parseInt(String.valueOf(tk.hasMoreTokens()));
        int goalsTeam2 = Integer.parseInt(String.valueOf(tk.hasMoreTokens()));

        processResults(idTeam1,idTeam2,goalsTeam1,goalsTeam2);

    }

    private void processResults( long idTeam1, long idTeam2, int goalsTeam1, int goalsTeam2) {
        if(valid(idTeam1,idTeam2,goalsTeam1,goalsTeam2)) {
            update(idTeam1,goalsTeam1,goalsTeam2);
            update(idTeam2,goalsTeam2, goalsTeam1);
        }
    }
    private void update(long idTeam, int scored, int conceded) {
        Team team = league.readTeam(idTeam);
        team.addGameResult(scored,conceded);
        this.league.writeTeam(team);
    }

    private boolean valid (long idTeam1, long idTeam2, int goalsTeam1, int goalsTeam2) {
        return (goalsTeam1 >= 0 && goalsTeam2 >= 0 && exists(idTeam1) && exists(idTeam2));

    }
}
