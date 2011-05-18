package org.fazio.football.types;

/**
 * Created by IntelliJ IDEA.
 * User: Michael
 * Date: 5/17/11
 * Time: 11:53 AM
 * To change this template use File | Settings | File Templates.
 */
public class Player {
    Position position;
    String name;
    String team;

    public Player(Position position, String name, String team) {
        this.position = position;
        this.name = name;
        this.team = team;
    }

    public String getPlayerID() {
        return this.name + ":" + this.position.name() + ":" + this.team;
    }

    public Position getPosition() {
        return this.position;
    }

    public String getName() {
        return this.name;
    }

    public String getTeam() {
        return this.team;
    }

    public String toString() {
        return this.name + " (" + this.position.name() + " - " + team + ")";
    }
}
