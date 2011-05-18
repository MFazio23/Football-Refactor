import javax.swing.*;
import javax.swing.event.*;
import java.awt.event.*;
import java.awt.*;
import java.io.*;
import java.util.*;

public class FFDisplay implements ActionListener {

    private JFrame window;
    private JLabel name,kname,dname,qb,qbpts,wra,wrapts,wrb,wrbpts,wrc,wrcpts,rba,rbapts,rbb,rbbpts,te,tepts,k,kpts,def,defpts,faz,totalPoints,ptsLabel;
    private JTextField qbpy, qbpt, qbint, qbruy,qbrut,qbrey,qbret,qb2p,qbfl;
    private JTextField wrapy, wrapt, wraint, wraruy,wrarut,wrarey,wraret,wra2p,wrafl;
    private JTextField wrbpy, wrbpt, wrbint, wrbruy,wrbrut,wrbrey,wrbret,wrb2p,wrbfl;
    private JTextField wrcpy, wrcpt, wrcint, wrcruy,wrcrut,wrcrey,wrcret,wrc2p,wrcfl;
    private JTextField rbapy, rbapt, rbaint, rbaruy,rbarut,rbarey,rbaret,rba2p,rbafl;
    private JTextField rbbpy, rbbpt, rbbint, rbbruy,rbbrut,rbbrey,rbbret,rbb2p,rbbfl;
    private JTextField tepy, tept, teint, teruy,terut,terey,teret,te2p,tefl;
    private JTextField kpy, kpt, kint, kruy,krut,krey,kret,k2p,kfl;
    private JTextField defpy, defpt, defint, defruy,defrut,defrey,defret,def2p,deffl;
    private JTextArea passy,passt,passint,rushy,rusht,recy,rect,twopts,fumbl;
    private JTextArea u19,u29,u39,u49,o50,PAT;
    private JTextArea ptsAll,sack,intc,fumr,deftd,safe,bkick,rettd;
    private JButton compile;
    private Roster rost;
    private int totalPts = 0;

    public FFDisplay(String filename){
        rost = new Roster(filename);
        window = new JFrame(filename);
        window.getContentPane().setLayout(null);
        window.setBounds(100,100,690,650);
        window.getContentPane().setBackground(Color.green);
        
        String[] qbName = rost.getQB();
        
        String[] wraName = rost.getWR1();
                
        String[] wrbName = rost.getWR2();
                
        String[] wrcName = rost.getWR3();
        
        String[] rbaName = rost.getRB1();
        
        String[] rbbName = rost.getRB2();
                
        String[] teName = rost.getTE();
                
        String[] kName = rost.getK();
                
        String[] defName = rost.getDEF();
        
//Headings and Labels        
        name = new JLabel("Player Name");
        name.setBounds(5,10,175,25);
        name.setHorizontalAlignment(JLabel.CENTER);
        window.getContentPane().add(name);
        
        kname = new JLabel("Kicker Name");
        kname.setBounds(5,330,175,25);
        kname.setHorizontalAlignment(JLabel.CENTER);
        window.getContentPane().add(kname);
        
        dname = new JLabel("Defensive Team");
        dname.setBounds(5,410,175,25);
        dname.setHorizontalAlignment(JLabel.CENTER);
        window.getContentPane().add(dname);

        passy = new JTextArea(2,2);
        passy.setBounds(190,10,35,35);
        passy.setText("Pass Yards");
        passy.setLineWrap(true);
        passy.setOpaque(false);
        passy.setEditable(false);
        window.getContentPane().add(passy);
        
        passt = new JTextArea(2,2);
        passt.setBounds(240,10,35,35);
        passt.setText("Pass TDs");
        passt.setLineWrap(true);
        passt.setOpaque(false);
        passt.setEditable(false);
        window.getContentPane().add(passt);
        
        passint = new JTextArea(2,2);
        passint.setBounds(290,10,35,35);
        passint.setText("Pass  INTs");
        passint.setLineWrap(true);
        passint.setOpaque(false);
        passint.setEditable(false);
        window.getContentPane().add(passint);
        
        rushy = new JTextArea(2,2);
        rushy.setBounds(340,10,35,35);
        rushy.setText("Rush Yards");
        rushy.setLineWrap(true);
        rushy.setOpaque(false);
        rushy.setEditable(false);
        window.getContentPane().add(rushy);
        
        rusht = new JTextArea(2,2);
        rusht.setBounds(390,10,35,35);
        rusht.setText("Rush TDs");
        rusht.setLineWrap(true);
        rusht.setOpaque(false);
        rusht.setEditable(false);
        window.getContentPane().add(rusht);
        
        recy = new JTextArea(2,2);
        recy.setBounds(440,10,35,35);
        recy.setText("RecevYards");
        recy.setLineWrap(true);
        recy.setOpaque(false);
        recy.setEditable(false);
        window.getContentPane().add(recy);
        
        rect = new JTextArea(2,2);
        rect.setBounds(490,10,35,35);
        rect.setText("RecevTDs");
        rect.setLineWrap(true);
        rect.setOpaque(false);
        rect.setEditable(false);
        window.getContentPane().add(rect);
        
        twopts = new JTextArea(2,2);
        twopts.setBounds(540,10,35,35);
        twopts.setText("2 Pts. Conv.");
        twopts.setLineWrap(true);
        twopts.setOpaque(false);
        twopts.setEditable(false);
        window.getContentPane().add(twopts);
        
        fumbl = new JTextArea(2,2);
        fumbl.setBounds(590,10,35,35);
        fumbl.setText("Fumb Lost");
        fumbl.setLineWrap(true);
        fumbl.setOpaque(false);
        fumbl.setEditable(false);
        window.getContentPane().add(fumbl);
//Kicker Stats        
        u19 = new JTextArea(2,2);
        u19.setBounds(190,330,35,35);
        u19.setText("0-19   Yards");
        u19.setLineWrap(true);
        u19.setOpaque(false);
        u19.setEditable(false);
        window.getContentPane().add(u19);
        
        u29 = new JTextArea(2,2);
        u29.setBounds(240,330,35,35);
        u29.setText("20-29 Yards");
        u29.setLineWrap(true);
        u29.setOpaque(false);
        u29.setEditable(false);
        window.getContentPane().add(u29);
        
        u39 = new JTextArea(2,2);
        u39.setBounds(290,330,35,35);
        u39.setText("30-39 Yards");
        u39.setLineWrap(true);
        u39.setOpaque(false);
        u39.setEditable(false);
        window.getContentPane().add(u39);
        
        u49 = new JTextArea(2,2);
        u49.setBounds(340,330,35,35);
        u49.setText("40-49 Yards");
        u49.setLineWrap(true);
        u49.setOpaque(false);
        u49.setEditable(false);
        window.getContentPane().add(u49);
        
        o50 = new JTextArea(2,2);
        o50.setBounds(390,330,35,35);
        o50.setText("50+    Yards");
        o50.setLineWrap(true);
        o50.setOpaque(false);
        o50.setEditable(false);
        window.getContentPane().add(o50);
        
        PAT = new JTextArea(2,2);
        PAT.setBounds(440,330,35,35);
        PAT.setText("PAT   Made");
        PAT.setLineWrap(true);
        PAT.setOpaque(false);
        PAT.setEditable(false);
        window.getContentPane().add(PAT);
//Defensive Stats
        ptsAll = new JTextArea(2,2);
        ptsAll.setBounds(190,410,35,35);
        ptsAll.setText("Points Allow");
        ptsAll.setLineWrap(true);
        ptsAll.setOpaque(false);
        ptsAll.setEditable(false);
        window.getContentPane().add(ptsAll);
        
        sack = new JTextArea(2,2);
        sack.setBounds(240,410,35,35);
        sack.setText("Sacks");
        sack.setLineWrap(true);
        sack.setOpaque(false);
        sack.setEditable(false);
        window.getContentPane().add(sack);
        
        intc = new JTextArea(2,2);
        intc.setBounds(290,410,35,35);
        intc.setText("Defen. INTs");
        intc.setLineWrap(true);
        intc.setOpaque(false);
        intc.setEditable(false);
        window.getContentPane().add(intc);
        
        fumr = new JTextArea(2,2);
        fumr.setBounds(340,410,35,35);
        fumr.setText("Fumb.Recov.");
        fumr.setLineWrap(true);
        fumr.setOpaque(false);
        fumr.setEditable(false);
        window.getContentPane().add(fumr);
        
        deftd = new JTextArea(2,2);
        deftd.setBounds(390,410,35,35);
        deftd.setText("Defen. TDs");
        deftd.setLineWrap(true);
        deftd.setOpaque(false);
        deftd.setEditable(false);
        window.getContentPane().add(deftd);
        
        safe = new JTextArea(2,2);
        safe.setBounds(440,410,35,35);
        safe.setText("Safety");
        safe.setLineWrap(true);
        safe.setOpaque(false);
        safe.setEditable(false);
        window.getContentPane().add(safe);
        
        bkick = new JTextArea(2,2);
        bkick.setBounds(490,410,35,35);
        bkick.setText("Block Kick");
        bkick.setLineWrap(true);
        bkick.setOpaque(false);
        bkick.setEditable(false);
        window.getContentPane().add(bkick);
        
        rettd = new JTextArea(2,2);
        rettd.setBounds(540,410,35,35);
        rettd.setText("Retrn. TDs");
        rettd.setLineWrap(true);
        rettd.setOpaque(false);
        rettd.setEditable(false);
        window.getContentPane().add(rettd);
        
//Total Points Label        
        ptsLabel = new JLabel("Total Points:");
        ptsLabel.setBounds(270,500,100,30);
        ptsLabel.setOpaque(true);
        ptsLabel.setBackground(Color.white);
        ptsLabel.setHorizontalAlignment(JLabel.CENTER);
        window.getContentPane().add(ptsLabel);
        
        totalPoints = new JLabel("0");
        totalPoints.setBounds(370,500,50,30);
        totalPoints.setOpaque(true);
        totalPoints.setBackground(Color.white);
        totalPoints.setHorizontalAlignment(JLabel.CENTER);
        window.getContentPane().add(totalPoints);
        
//Quarterback Display        
        qb = new JLabel("QB-"+qbName[0]+" "+qbName[1]+" ("+qbName[2]+")");
        qb.setBounds(5,50,175,25);
        qb.setOpaque(true);
        qb.setBackground(Color.white);
        qb.setHorizontalAlignment(JLabel.CENTER);
        window.getContentPane().add(qb);
        
        qbpy = new JTextField("0");
        qbpy.setBounds(190,50,35,25);
        qbpy.setHorizontalAlignment(JTextField.CENTER);
        window.getContentPane().add(qbpy);
        
        qbpt = new JTextField("0");
        qbpt.setBounds(240,50,35,25);
        qbpt.setHorizontalAlignment(JTextField.CENTER);
        window.getContentPane().add(qbpt);
        
        qbint = new JTextField("0");
        qbint.setBounds(290,50,35,25);
        qbint.setHorizontalAlignment(JTextField.CENTER);
        window.getContentPane().add(qbint);
        
        qbruy = new JTextField("0");
        qbruy.setBounds(340,50,35,25);
        qbruy.setHorizontalAlignment(JTextField.CENTER);
        window.getContentPane().add(qbruy);
        
        qbrut = new JTextField("0");
        qbrut.setBounds(390,50,35,25);
        qbrut.setHorizontalAlignment(JTextField.CENTER);
        window.getContentPane().add(qbrut);
        
        qbrey = new JTextField("0");
        qbrey.setBounds(440,50,35,25);
        qbrey.setHorizontalAlignment(JTextField.CENTER);
        window.getContentPane().add(qbrey);
        
        qbret = new JTextField("0");
        qbret.setBounds(490,50,35,25);
        qbret.setHorizontalAlignment(JTextField.CENTER);
        window.getContentPane().add(qbret);
        
        qb2p = new JTextField("0");
        qb2p.setBounds(540,50,35,25);
        qb2p.setHorizontalAlignment(JTextField.CENTER);
        window.getContentPane().add(qb2p);
        
        qbfl = new JTextField("0");
        qbfl.setBounds(590,50,35,25);
        qbfl.setHorizontalAlignment(JTextField.CENTER);
        window.getContentPane().add(qbfl);
        
        qbpts = new JLabel("0");
        qbpts.setBounds(640,50,35,25);
        qbpts.setOpaque(true);
        qbpts.setBackground(Color.white);
        qbpts.setHorizontalAlignment(JLabel.CENTER);
        window.getContentPane().add(qbpts);
//Wide Receiver A Display        
        wra = new JLabel("WR-"+wraName[0]+" "+wraName[1]+" ("+wraName[2]+")");
        wra.setBounds(5,90,175,25);
        wra.setOpaque(true);
        wra.setBackground(Color.white);
        wra.setHorizontalAlignment(JLabel.CENTER);
        window.getContentPane().add(wra);
        
        wrapy = new JTextField("0");
        wrapy.setBounds(190,90,35,25);
        wrapy.setHorizontalAlignment(JTextField.CENTER);
        window.getContentPane().add(wrapy);
        
        wrapt = new JTextField("0");
        wrapt.setBounds(240,90,35,25);
        wrapt.setHorizontalAlignment(JTextField.CENTER);
        window.getContentPane().add(wrapt);
        
        wraint = new JTextField("0");
        wraint.setBounds(290,90,35,25);
        wraint.setHorizontalAlignment(JTextField.CENTER);
        window.getContentPane().add(wraint);
        
        wraruy = new JTextField("0");
        wraruy.setBounds(340,90,35,25);
        wraruy.setHorizontalAlignment(JTextField.CENTER);
        window.getContentPane().add(wraruy);
        
        wrarut = new JTextField("0");
        wrarut.setBounds(390,90,35,25);
        wrarut.setHorizontalAlignment(JTextField.CENTER);
        window.getContentPane().add(wrarut);
        
        wrarey = new JTextField("0");
        wrarey.setBounds(440,90,35,25);
        wrarey.setHorizontalAlignment(JTextField.CENTER);
        window.getContentPane().add(wrarey);
        
        wraret = new JTextField("0");
        wraret.setBounds(490,90,35,25);
        wraret.setHorizontalAlignment(JTextField.CENTER);
        window.getContentPane().add(wraret);
        
        wra2p = new JTextField("0");
        wra2p.setBounds(540,90,35,25);
        wra2p.setHorizontalAlignment(JTextField.CENTER);
        window.getContentPane().add(wra2p);
        
        wrafl = new JTextField("0");
        wrafl.setBounds(590,90,35,25);
        wrafl.setHorizontalAlignment(JTextField.CENTER);
        window.getContentPane().add(wrafl);
        
        wrapts = new JLabel("0");
        wrapts.setBounds(640,90,35,25);
        wrapts.setOpaque(true);
        wrapts.setBackground(Color.white);
        wrapts.setHorizontalAlignment(JLabel.CENTER);
        window.getContentPane().add(wrapts);
//Wide Receiver B Display        
        wrb = new JLabel("WR-"+wrbName[0]+" "+wrbName[1]+" ("+wrbName[2]+")");
        wrb.setBounds(5,130,175,25);
        wrb.setOpaque(true);
        wrb.setBackground(Color.white);
        wrb.setHorizontalAlignment(JLabel.CENTER);
        window.getContentPane().add(wrb);
        
        wrbpy = new JTextField("0");
        wrbpy.setBounds(190,130,35,25);
        wrbpy.setHorizontalAlignment(JTextField.CENTER);
        window.getContentPane().add(wrbpy);
        
        wrbpt = new JTextField("0");
        wrbpt.setBounds(240,130,35,25);
        wrbpt.setHorizontalAlignment(JTextField.CENTER);
        window.getContentPane().add(wrbpt);
        
        wrbint = new JTextField("0");
        wrbint.setBounds(290,130,35,25);
        wrbint.setHorizontalAlignment(JTextField.CENTER);
        window.getContentPane().add(wrbint);
        
        wrbruy = new JTextField("0");
        wrbruy.setBounds(340,130,35,25);
        wrbruy.setHorizontalAlignment(JTextField.CENTER);
        window.getContentPane().add(wrbruy);
        
        wrbrut = new JTextField("0");
        wrbrut.setBounds(390,130,35,25);
        wrbrut.setHorizontalAlignment(JTextField.CENTER);
        window.getContentPane().add(wrbrut);
        
        wrbrey = new JTextField("0");
        wrbrey.setBounds(440,130,35,25);
        wrbrey.setHorizontalAlignment(JTextField.CENTER);
        window.getContentPane().add(wrbrey);
        
        wrbret = new JTextField("0");
        wrbret.setBounds(490,130,35,25);
        wrbret.setHorizontalAlignment(JTextField.CENTER);
        window.getContentPane().add(wrbret);
        
        wrb2p = new JTextField("0");
        wrb2p.setBounds(540,130,35,25);
        wrb2p.setHorizontalAlignment(JTextField.CENTER);
        window.getContentPane().add(wrb2p);
        
        wrbfl = new JTextField("0");
        wrbfl.setBounds(590,130,35,25);
        wrbfl.setHorizontalAlignment(JTextField.CENTER);
        window.getContentPane().add(wrbfl);
        
        wrbpts = new JLabel("0");
        wrbpts.setBounds(640,130,35,25);
        wrbpts.setOpaque(true);
        wrbpts.setBackground(Color.white);
        wrbpts.setHorizontalAlignment(JLabel.CENTER);
        window.getContentPane().add(wrbpts);
//Wide Receiver C Display        
        wrc = new JLabel("WR-"+wrcName[0]+" "+wrcName[1]+" ("+wrcName[2]+")");
        wrc.setBounds(5,170,175,25);
        wrc.setOpaque(true);
        wrc.setBackground(Color.white);
        wrc.setHorizontalAlignment(JLabel.CENTER);
        window.getContentPane().add(wrc);
        
        wrcpy = new JTextField("0");
        wrcpy.setBounds(190,170,35,25);
        wrcpy.setHorizontalAlignment(JTextField.CENTER);
        window.getContentPane().add(wrcpy);
        
        wrcpt = new JTextField("0");
        wrcpt.setBounds(240,170,35,25);
        wrcpt.setHorizontalAlignment(JTextField.CENTER);
        window.getContentPane().add(wrcpt);
        
        wrcint = new JTextField("0");
        wrcint.setBounds(290,170,35,25);
        wrcint.setHorizontalAlignment(JTextField.CENTER);
        window.getContentPane().add(wrcint);
        
        wrcruy = new JTextField("0");
        wrcruy.setBounds(340,170,35,25);
        wrcruy.setHorizontalAlignment(JTextField.CENTER);
        window.getContentPane().add(wrcruy);
        
        wrcrut = new JTextField("0");
        wrcrut.setBounds(390,170,35,25);
        wrcrut.setHorizontalAlignment(JTextField.CENTER);
        window.getContentPane().add(wrcrut);
        
        wrcrey = new JTextField("0");
        wrcrey.setBounds(440,170,35,25);
        wrcrey.setHorizontalAlignment(JTextField.CENTER);
        window.getContentPane().add(wrcrey);
        
        wrcret = new JTextField("0");
        wrcret.setBounds(490,170,35,25);
        wrcret.setHorizontalAlignment(JTextField.CENTER);
        window.getContentPane().add(wrcret);
        
        wrc2p = new JTextField("0");
        wrc2p.setBounds(540,170,35,25);
        wrc2p.setHorizontalAlignment(JTextField.CENTER);
        window.getContentPane().add(wrc2p);
        
        wrcfl = new JTextField("0");
        wrcfl.setBounds(590,170,35,25);
        wrcfl.setHorizontalAlignment(JTextField.CENTER);
        window.getContentPane().add(wrcfl);
        
        wrcpts = new JLabel("0");
        wrcpts.setBounds(640,170,35,25);
        wrcpts.setOpaque(true);
        wrcpts.setBackground(Color.white);
        wrcpts.setHorizontalAlignment(JLabel.CENTER);
        window.getContentPane().add(wrcpts);
//Running Back A Display        
        rba = new JLabel("RB-"+rbaName[0]+" "+rbaName[1]+" ("+rbaName[2]+")");
        rba.setBounds(5,210,175,25);
        rba.setOpaque(true);
        rba.setBackground(Color.white);
        rba.setHorizontalAlignment(JLabel.CENTER);
        window.getContentPane().add(rba);
        
        rbapy = new JTextField("0");
        rbapy.setBounds(190,210,35,25);
        rbapy.setHorizontalAlignment(JTextField.CENTER);
        window.getContentPane().add(rbapy);
        
        rbapt = new JTextField("0");
        rbapt.setBounds(240,210,35,25);
        rbapt.setHorizontalAlignment(JTextField.CENTER);
        window.getContentPane().add(rbapt);
        
        rbaint = new JTextField("0");
        rbaint.setBounds(290,210,35,25);
        rbaint.setHorizontalAlignment(JTextField.CENTER);
        window.getContentPane().add(rbaint);
        
        rbaruy = new JTextField("0");
        rbaruy.setBounds(340,210,35,25);
        rbaruy.setHorizontalAlignment(JTextField.CENTER);
        window.getContentPane().add(rbaruy);
        
        rbarut = new JTextField("0");
        rbarut.setBounds(390,210,35,25);
        rbarut.setHorizontalAlignment(JTextField.CENTER);
        window.getContentPane().add(rbarut);
        
        rbarey = new JTextField("0");
        rbarey.setBounds(440,210,35,25);
        rbarey.setHorizontalAlignment(JTextField.CENTER);
        window.getContentPane().add(rbarey);
        
        rbaret = new JTextField("0");
        rbaret.setBounds(490,210,35,25);
        rbaret.setHorizontalAlignment(JTextField.CENTER);
        window.getContentPane().add(rbaret);
        
        rba2p = new JTextField("0");
        rba2p.setBounds(540,210,35,25);
        rba2p.setHorizontalAlignment(JTextField.CENTER);
        window.getContentPane().add(rba2p);
        
        rbafl = new JTextField("0");
        rbafl.setBounds(590,210,35,25);
        rbafl.setHorizontalAlignment(JTextField.CENTER);
        window.getContentPane().add(rbafl);
        
        rbapts = new JLabel("0");
        rbapts.setBounds(640,210,35,25);
        rbapts.setOpaque(true);
        rbapts.setBackground(Color.white);
        rbapts.setHorizontalAlignment(JLabel.CENTER);
        window.getContentPane().add(rbapts);
//Running Back B Display        
        rbb = new JLabel("RB-"+rbbName[0]+" "+rbbName[1]+" ("+rbbName[2]+")");
        rbb.setBounds(5,250,175,25);
        rbb.setOpaque(true);
        rbb.setBackground(Color.white);
        rbb.setHorizontalAlignment(JLabel.CENTER);
        window.getContentPane().add(rbb);
        
        rbbpy = new JTextField("0");
        rbbpy.setBounds(190,250,35,25);
        rbbpy.setHorizontalAlignment(JTextField.CENTER);
        window.getContentPane().add(rbbpy);
        
        rbbpt = new JTextField("0");
        rbbpt.setBounds(240,250,35,25);
        rbbpt.setHorizontalAlignment(JTextField.CENTER);
        window.getContentPane().add(rbbpt);
        
        rbbint = new JTextField("0");
        rbbint.setBounds(290,250,35,25);
        rbbint.setHorizontalAlignment(JTextField.CENTER);
        window.getContentPane().add(rbbint);
        
        rbbruy = new JTextField("0");
        rbbruy.setBounds(340,250,35,25);
        rbbruy.setHorizontalAlignment(JTextField.CENTER);
        window.getContentPane().add(rbbruy);
        
        rbbrut = new JTextField("0");
        rbbrut.setBounds(390,250,35,25);
        rbbrut.setHorizontalAlignment(JTextField.CENTER);
        window.getContentPane().add(rbbrut);
        
        rbbrey = new JTextField("0");
        rbbrey.setBounds(440,250,35,25);
        rbbrey.setHorizontalAlignment(JTextField.CENTER);
        window.getContentPane().add(rbbrey);
        
        rbbret = new JTextField("0");
        rbbret.setBounds(490,250,35,25);
        rbbret.setHorizontalAlignment(JTextField.CENTER);
        window.getContentPane().add(rbbret);
        
        rbb2p = new JTextField("0");
        rbb2p.setBounds(540,250,35,25);
        rbb2p.setHorizontalAlignment(JTextField.CENTER);
        window.getContentPane().add(rbb2p);
        
        rbbfl = new JTextField("0");
        rbbfl.setBounds(590,250,35,25);
        rbbfl.setHorizontalAlignment(JTextField.CENTER);
        window.getContentPane().add(rbbfl);
        
        rbbpts = new JLabel("0");
        rbbpts.setBounds(640,250,35,25);
        rbbpts.setOpaque(true);
        rbbpts.setBackground(Color.white);
        rbbpts.setHorizontalAlignment(JLabel.CENTER);
        window.getContentPane().add(rbbpts);
//Tight End Display
        te = new JLabel("TE-"+teName[0]+" "+teName[1]+" ("+teName[2]+")");
        te.setBounds(5,290,175,25);
        te.setOpaque(true);
        te.setBackground(Color.white);
        te.setHorizontalAlignment(JLabel.CENTER);
        window.getContentPane().add(te);
        
        tepy = new JTextField("0");
        tepy.setBounds(190,290,35,25);
        tepy.setHorizontalAlignment(JTextField.CENTER);
        window.getContentPane().add(tepy);
        
        tept = new JTextField("0");
        tept.setBounds(240,290,35,25);
        tept.setHorizontalAlignment(JTextField.CENTER);
        window.getContentPane().add(tept);
        
        teint = new JTextField("0");
        teint.setBounds(290,290,35,25);
        teint.setHorizontalAlignment(JTextField.CENTER);
        window.getContentPane().add(teint);
        
        teruy = new JTextField("0");
        teruy.setBounds(340,290,35,25);
        teruy.setHorizontalAlignment(JTextField.CENTER);
        window.getContentPane().add(teruy);
        
        terut = new JTextField("0");
        terut.setBounds(390,290,35,25);
        terut.setHorizontalAlignment(JTextField.CENTER);
        window.getContentPane().add(terut);
        
        terey = new JTextField("0");
        terey.setBounds(440,290,35,25);
        terey.setHorizontalAlignment(JTextField.CENTER);
        window.getContentPane().add(terey);
        
        teret = new JTextField("0");
        teret.setBounds(490,290,35,25);
        teret.setHorizontalAlignment(JTextField.CENTER);
        window.getContentPane().add(teret);
        
        te2p = new JTextField("0");
        te2p.setBounds(540,290,35,25);
        te2p.setHorizontalAlignment(JTextField.CENTER);
        window.getContentPane().add(te2p);
        
        tefl = new JTextField("0");
        tefl.setBounds(590,290,35,25);
        tefl.setHorizontalAlignment(JTextField.CENTER);
        window.getContentPane().add(tefl);
        
        tepts = new JLabel("0");
        tepts.setBounds(640,290,35,25);
        tepts.setOpaque(true);
        tepts.setBackground(Color.white);
        tepts.setHorizontalAlignment(JLabel.CENTER);
        window.getContentPane().add(tepts);
//Kicker Display        
        k = new JLabel("K-"+kName[0]+" "+kName[1]+" ("+kName[2]+")");
        k.setBounds(5,370,175,25);
        k.setOpaque(true);
        k.setBackground(Color.white);
        k.setHorizontalAlignment(JLabel.CENTER);
        window.getContentPane().add(k);
        
        kpy = new JTextField("0");
        kpy.setBounds(190,370,35,25);
        kpy.setHorizontalAlignment(JTextField.CENTER);
        window.getContentPane().add(kpy);
        
        kpt = new JTextField("0");
        kpt.setBounds(240,370,35,25);
        kpt.setHorizontalAlignment(JTextField.CENTER);
        window.getContentPane().add(kpt);
        
        kint = new JTextField("0");
        kint.setBounds(290,370,35,25);
        kint.setHorizontalAlignment(JTextField.CENTER);
        window.getContentPane().add(kint);
        
        kruy = new JTextField("0");
        kruy.setBounds(340,370,35,25);
        kruy.setHorizontalAlignment(JTextField.CENTER);
        window.getContentPane().add(kruy);
        
        krut = new JTextField("0");
        krut.setBounds(390,370,35,25);
        krut.setHorizontalAlignment(JTextField.CENTER);
        window.getContentPane().add(krut);
        
        krey = new JTextField("0");
        krey.setBounds(440,370,35,25);
        krey.setHorizontalAlignment(JTextField.CENTER);
        window.getContentPane().add(krey);
                
        kpts = new JLabel("0");
        kpts.setBounds(640,370,35,25);
        kpts.setOpaque(true);
        kpts.setBackground(Color.white);
        kpts.setHorizontalAlignment(JLabel.CENTER);
        window.getContentPane().add(kpts);
//Defensive Display
        def = new JLabel("DEF-"+defName[0]+" "+defName[1]);
        def.setBounds(5,450,175,25);
        def.setOpaque(true);
        def.setBackground(Color.white);
        def.setHorizontalAlignment(JLabel.CENTER);
        window.getContentPane().add(def);
        
        defpy = new JTextField("0");
        defpy.setBounds(190,450,35,25);
        defpy.setHorizontalAlignment(JTextField.CENTER);
        window.getContentPane().add(defpy);
        
        defpt = new JTextField("0");
        defpt.setBounds(240,450,35,25);
        defpt.setHorizontalAlignment(JTextField.CENTER);
        window.getContentPane().add(defpt);
        
        defint = new JTextField("0");
        defint.setBounds(290,450,35,25);
        defint.setHorizontalAlignment(JTextField.CENTER);
        window.getContentPane().add(defint);
        
        defruy = new JTextField("0");
        defruy.setBounds(340,450,35,25);
        defruy.setHorizontalAlignment(JTextField.CENTER);
        window.getContentPane().add(defruy);
        
        defrut = new JTextField("0");
        defrut.setBounds(390,450,35,25);
        defrut.setHorizontalAlignment(JTextField.CENTER);
        window.getContentPane().add(defrut);
        
        defrey = new JTextField("0");
        defrey.setBounds(440,450,35,25);
        defrey.setHorizontalAlignment(JTextField.CENTER);
        window.getContentPane().add(defrey);
        
        defret = new JTextField("0");
        defret.setBounds(490,450,35,25);
        defret.setHorizontalAlignment(JTextField.CENTER);
        window.getContentPane().add(defret);
        
        def2p = new JTextField("0");
        def2p.setBounds(540,450,35,25);
        def2p.setHorizontalAlignment(JTextField.CENTER);
        window.getContentPane().add(def2p);
        
        defpts = new JLabel("0");
        defpts.setBounds(640,450,35,25);
        defpts.setOpaque(true);
        defpts.setBackground(Color.white);
        defpts.setHorizontalAlignment(JLabel.CENTER);
        window.getContentPane().add(defpts);        
        
        compile = new JButton("Compile Stats");
        compile.setBounds(270,590,150,30);
        compile.addActionListener(this);
        window.getContentPane().add(compile);
        
        faz = new JLabel("Michael Fazio - 2004");
        faz.setBounds(475,600,200,30);
        faz.setHorizontalAlignment(JLabel.CENTER);
        window.getContentPane().add(faz);
        
        window.show();
        window.repaint();
        
    }
    
    public void getPoints(){
        totalPts = 0;
        getQBPoints();        
        getWRaPoints();
        getWRbPoints();
        getWRcPoints();
        getRBaPoints();
        getRBbPoints();
        getTEPoints();
        getKPoints();
        getDEFPoints();
        totalPoints.setText(Integer.toString(totalPts));
        window.repaint();
    }
    
    public void getQBPoints(){
        int passY = Integer.parseInt(qbpy.getText());
        if (passY<0){
            passY = 0;}
        int passT = Integer.parseInt(qbpt.getText());
        int passInt = Integer.parseInt(qbint.getText());
        int rushY = Integer.parseInt(qbruy.getText());
        if (rushY<0){
            rushY=0;}
        int rushT = Integer.parseInt(qbrut.getText());
        int recY = Integer.parseInt(qbrey.getText());
        if (recY<0){
            recY=0;}
        int recT = Integer.parseInt(qbret.getText());
        int twoPts = Integer.parseInt(qb2p.getText());
        int fumL = Integer.parseInt(qbfl.getText());
        int points = ((int)passY/25)+(passT*4)-(passInt*2)+((int)rushY/10)+(rushT*6)+(recY/10)+(recT*6)+(twoPts*2)-(fumL*2);
        qbpts.setText(Integer.toString(points));
        totalPts = totalPts + points;
    }
    
    public void getWRaPoints(){
        int passY = Integer.parseInt(wrapy.getText());
        if (passY<0){
            passY = 0;}
        int passT = Integer.parseInt(wrapt.getText());
        int passInt = Integer.parseInt(wraint.getText());
        int rushY = Integer.parseInt(wraruy.getText());
        if (rushY<0){
            rushY=0;}
        int rushT = Integer.parseInt(wrarut.getText());
        int recY = Integer.parseInt(wrarey.getText());
        if (recY<0){
            recY=0;}
        int recT = Integer.parseInt(wraret.getText());
        int twoPts = Integer.parseInt(wra2p.getText());
        int fumL = Integer.parseInt(wrafl.getText());
        int points = ((int)passY/25)+(passT*4)-(passInt*2)+((int)rushY/10)+(rushT*6)+(recY/10)+(recT*6)+(twoPts*2)-(fumL*2);
        wrapts.setText(Integer.toString(points));
        totalPts = totalPts + points;
    }
    
    public void getWRbPoints(){
        int passY = Integer.parseInt(wrbpy.getText());
        if (passY<0){
            passY = 0;}
        int passT = Integer.parseInt(wrbpt.getText());
        int passInt = Integer.parseInt(wrbint.getText());
        int rushY = Integer.parseInt(wrbruy.getText());
        if (rushY<0){
            rushY=0;}
        int rushT = Integer.parseInt(wrbrut.getText());
        int recY = Integer.parseInt(wrbrey.getText());
        if (recY<0){
            recY=0;}
        int recT = Integer.parseInt(wrbret.getText());
        int twoPts = Integer.parseInt(wrb2p.getText());
        int fumL = Integer.parseInt(wrbfl.getText());
        int points = ((int)passY/25)+(passT*4)-(passInt*2)+((int)rushY/10)+(rushT*6)+(recY/10)+(recT*6)+(twoPts*2)-(fumL*2);
        wrbpts.setText(Integer.toString(points));
        totalPts = totalPts + points;
    }
    
    public void getWRcPoints(){
        int passY = Integer.parseInt(wrcpy.getText());
        if (passY<0){
            passY = 0;}
        int passT = Integer.parseInt(wrcpt.getText());
        int passInt = Integer.parseInt(wrcint.getText());
        int rushY = Integer.parseInt(wrcruy.getText());
        if (rushY<0){
            rushY=0;}
        int rushT = Integer.parseInt(wrcrut.getText());
        int recY = Integer.parseInt(wrcrey.getText());
        if (recY<0){
            recY=0;}
        int recT = Integer.parseInt(wrcret.getText());
        int twoPts = Integer.parseInt(wrc2p.getText());
        int fumL = Integer.parseInt(wrcfl.getText());
        int points = ((int)passY/25)+(passT*4)-(passInt*2)+((int)rushY/10)+(rushT*6)+(recY/10)+(recT*6)+(twoPts*2)-(fumL*2);
        wrcpts.setText(Integer.toString(points));
        totalPts = totalPts + points;
    }
    
    public void getRBaPoints(){
        int passY = Integer.parseInt(rbapy.getText());
        if (passY<0){
            passY = 0;}
        int passT = Integer.parseInt(rbapt.getText());
        int passInt = Integer.parseInt(rbaint.getText());
        int rushY = Integer.parseInt(rbaruy.getText());
        if (rushY<0){
            rushY=0;}
        int rushT = Integer.parseInt(rbarut.getText());
        int recY = Integer.parseInt(rbarey.getText());
        if (recY<0){
            recY=0;}
        int recT = Integer.parseInt(rbaret.getText());
        int twoPts = Integer.parseInt(rba2p.getText());
        int fumL = Integer.parseInt(rbafl.getText());
        int points = ((int)passY/25)+(passT*4)-(passInt*2)+((int)rushY/10)+(rushT*6)+(recY/10)+(recT*6)+(twoPts*2)-(fumL*2);
        rbapts.setText(Integer.toString(points));
        totalPts = totalPts + points;
    }
    
    public void getRBbPoints(){
        int passY = Integer.parseInt(rbbpy.getText());
        if (passY<0){
            passY = 0;}
        int passT = Integer.parseInt(rbbpt.getText());
        int passInt = Integer.parseInt(rbbint.getText());
        int rushY = Integer.parseInt(rbbruy.getText());
        if (rushY<0){
            rushY=0;}
        int rushT = Integer.parseInt(rbbrut.getText());
        int recY = Integer.parseInt(rbbrey.getText());
        if (recY<0){
            recY=0;}
        int recT = Integer.parseInt(rbbret.getText());
        int twoPts = Integer.parseInt(rbb2p.getText());
        int fumL = Integer.parseInt(rbbfl.getText());
        int points = ((int)passY/25)+(passT*4)-(passInt*2)+((int)rushY/10)+(rushT*6)+(recY/10)+(recT*6)+(twoPts*2)-(fumL*2);
        rbbpts.setText(Integer.toString(points));
        totalPts = totalPts + points;
    }
    
    public void getTEPoints(){
        int passY = Integer.parseInt(tepy.getText());
        if (passY<0){
            passY = 0;}
        int passT = Integer.parseInt(tept.getText());
        int passInt = Integer.parseInt(teint.getText());
        int rushY = Integer.parseInt(teruy.getText());
        if (rushY<0){
            rushY=0;}
        int rushT = Integer.parseInt(terut.getText());
        int recY = Integer.parseInt(terey.getText());
        if (recY<0){
            recY=0;}
        int recT = Integer.parseInt(teret.getText());
        int twoPts = Integer.parseInt(te2p.getText());
        int fumL = Integer.parseInt(tefl.getText());
        int points = ((int)passY/25)+(passT*4)-(passInt*2)+((int)rushY/10)+(rushT*6)+(recY/10)+(recT*6)+(twoPts*2)-(fumL*2);
        tepts.setText(Integer.toString(points));
        totalPts = totalPts + points;
    }
    
        public void getKPoints(){
        int passY = Integer.parseInt(kpy.getText());
        if (passY<0){
            passY = 0;}
        int passT = Integer.parseInt(kpt.getText());
        int passInt = Integer.parseInt(kint.getText());
        int rushY = Integer.parseInt(kruy.getText());
        if (rushY<0){
            rushY=0;}
        int rushT = Integer.parseInt(krut.getText());
        int recY = Integer.parseInt(krey.getText());
        if (recY<0){
            recY=0;}
        int points = ((int)passY*3)+(passT*3)+(passInt*3)+((int)rushY*4)+(rushT*5)+(recY);
        kpts.setText(Integer.toString(points));
        totalPts = totalPts + points;
    }

    public void getDEFPoints(){
        int ptsA = Integer.parseInt(defpy.getText());
        int ptsAgst = 0;
            if (ptsA==0){
               ptsAgst = 10;}
       else if (ptsA>0 && ptsA<7){
               ptsAgst = 7;}
       else if (ptsA>6 && ptsA<14){
               ptsAgst = 4;}
       else if (ptsA>13 && ptsA<21){
               ptsAgst = 1;}
       else if (ptsA>20 && ptsA<28){
               ptsAgst = 0;}
       else if (ptsA>27 && ptsA<35){
               ptsAgst = -1;}
       else if (ptsA>=35){
               ptsAgst = -4;}
        int passT = Integer.parseInt(defpt.getText());
        int passInt = Integer.parseInt(defint.getText());
        int rushY = Integer.parseInt(defruy.getText());
        if (rushY<0){
            rushY=0;}
        int rushT = Integer.parseInt(defrut.getText());
        int recY = Integer.parseInt(defrey.getText());
        if (recY<0){
            recY=0;}
        int recT = Integer.parseInt(defret.getText());
        int twoPts = Integer.parseInt(def2p.getText());
        int points = ptsAgst+(passT)+(passInt*2)+((int)rushY*2)+(rushT*6)+(recY*4)+(recT*4)+(twoPts*6);
        defpts.setText(Integer.toString(points));
        totalPts = totalPts + points;
    }

    
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==compile){
            getPoints();
        }
    }
        
}