package org.fazio.football.types;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by IntelliJ IDEA.
 * User: Michael
 * Date: 5/16/11
 * Time: 11:31 PM
 * To change this template use File | Settings | File Templates.
 */
public class Roster {

    private Map<String, Player> players = new HashMap<String, Player>();

    public Roster(String filename) {
        loadRosterFromFile(filename);
    }

    private void loadRosterFromFile(String filename) {
        try {
            Scanner scan = new Scanner(new File(filename));
            while(scan.hasNextLine()) {
                String line = scan.nextLine();
                Player player = this.getPlayerFromFile(line);
                this.players.put(player.getPlayerID(), player);
            }
        } catch(FileNotFoundException e) {
            System.out.println("Roster.loadRosterFromFile() - Requested file could not be found [" + filename + "]");
        }
    }

    private Player getPlayerFromFile(String playerLine) {
        Scanner scan = new Scanner(playerLine);
        scan.useDelimiter(":");

        String positionID = scan.next();
        String firstName = scan.next();
        String lastName = scan.next();
        String team = scan.next();

        Position position = Position.valueOf(positionID);

        return new Player(position, firstName + " " + lastName, team);

    }

    public Map<String, Player> getPlayers() {
        return this.players;
    }

}
