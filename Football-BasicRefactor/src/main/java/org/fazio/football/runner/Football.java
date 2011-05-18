package org.fazio.football.runner;

import org.fazio.football.display.FFDisplay;
import org.fazio.football.types.Roster;

/**
 * Created by IntelliJ IDEA.
 * User: Michael
 * Date: 5/16/11
 * Time: 9:07 PM
 * To change this template use File | Settings | File Templates.
 */
public class Football {

    private Football(String filename) {
        Roster roster = new Roster(filename);
        FFDisplay display = new FFDisplay(roster);
    }

    public static void main(String[] args) {
        new Football(args[0]);
    }

}
