package org.fazio.football.types;

/**
 * Created by IntelliJ IDEA.
 * User: Michael
 * Date: 5/16/11
 * Time: 11:32 PM
 * To change this template use File | Settings | File Templates.
 */
public enum Position {
    QB(9),
    WR(9),
    RB(9),
    TE(9),
    K(6),
    DEF(8);

    private int categories;

    private Position(int categories) {
        this.categories = categories;
    }

    public int getCategoryCount() {
        return this.categories;
    }
}
