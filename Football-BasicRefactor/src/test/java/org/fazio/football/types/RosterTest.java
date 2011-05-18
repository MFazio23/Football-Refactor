package org.fazio.football.types;

import junit.framework.TestCase;
import org.junit.*;
import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

import java.io.File;
import java.io.FileWriter;

import static junit.framework.Assert.*;

/**
 * Created by IntelliJ IDEA.
 * User: Michael
 * Date: 5/17/11
 * Time: 12:10 PM
 * To change this template use File | Settings | File Templates.
 */
public class RosterTest {

    private static String filename = "Football-BasicRefactor\\src\\test\\resources\\RosterTest-JUnit-Roster.txt";

    @BeforeClass
    public static void initialSetUp() throws Exception {
        File oldFile = new File(filename);
        if(oldFile.exists()) {
            boolean deleted = oldFile.delete();
            assertTrue(deleted);
        }

        File file = new File(filename);
        FileWriter writer = new FileWriter(file);
        writer.write("QB:Jake:Delhomme:CAR\n");
        writer.write("WR:Donald:Driver:GB\n");
        writer.write("WR:Rod:Smith:DEN\n");
        writer.write("WR:Herman:Moore:DET\n");
        writer.write("RB:Mike:Anderson:DEN\n");
        writer.write("RB:Jerome:Bettis:PIT\n");
        writer.write("TE:Jason:Witten:DAL\n");
        writer.write("K:Ryan:Longwell:GB\n");
        writer.write("DEF:Green Bay:Packers:GB\n");
        writer.flush();
        writer.close();
    }

    @Before
    public void setUp() throws Exception {
        System.out.println("This is the set up method (before each test).");

    }

    @After
    public void tearDown() throws Exception {
        System.out.println("This is the tear down method (after each test).");

    }

    @AfterClass
    public static void finalTearDown() throws Exception {
        File file = new File(filename);

        assertTrue(file.exists());

        boolean deleted = file.delete();

        assertTrue(deleted);
        assertTrue(!file.exists());
    }

    @Test
    public void testRoster() throws Exception {
        Roster roster = new Roster(filename);

        for(Player player : roster.getPlayers().values()) {
            System.out.println(player);
        }
    }

}
