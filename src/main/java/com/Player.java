package main.java.com;

import java.util.List;
import java.util.Scanner;

public enum Player {
    Player1("Player1", 1000, 300, 300,10,10,10),
    Player2("Player2", 1000, 300, 300,20,20,20),
    Player3("Player3", 1000, 300, 300,100,100,100);

    public final String name;

    private final int hitPoints;
    private final int attack;
    private final int spAttack;
    private final int defence;
    private final int spDefence;
    private final int speed;

    private int nowHitPoints;
    private int nowAttack;
    private int nowSpAttack;
    private int nowDefence;
    private int nowSpDefence;
    private int nowSpeed;

    private int recovery = 100;


    Player(String name, int hitPoints, int attack, int spAttack, int defence, int spDefence, int speed){
        this.name = name;
        this.hitPoints = hitPoints;
        this.attack = attack;
        this.spAttack = spAttack;
        this.defence = defence;
        this.spDefence = spDefence;
        this.speed = speed;

        this.nowHitPoints = hitPoints;
        this.nowAttack = attack;
        this.nowSpAttack = spAttack;
        this.nowDefence = defence;
        this.nowSpDefence = spDefence;
        this.nowSpeed = speed;
    }

    public String toString() {
        return this.name + "  " + "HP:" + this.nowHitPoints + "/" + this.hitPoints;
    }
//        return this.name + "\n" +
//               "HP:        " + this.nowHitPoints + "/" + this.hitPoints + "\n" +
//               "Attack:    " + this.nowAttack + "/" + this.attack + "\n" +
//               "SpAttack:  " + this.nowSpAttack + "/" + this.spAttack + "\n" +
//               "Defence:   " + this.nowDefence + "/" + this.defence + "\n" +
//               "SpDefence: " + this.nowSpDefence + "/" + this.spDefence + "\n" +
//               "Speed:     " + this.nowSpeed + "/" + this.speed + "\n";
//    }

    public void getDamage(int attack, int spAttack, int recoveryHP){
        this.nowHitPoints -= attack;
        this.nowHitPoints -= spAttack;
        this.nowHitPoints += recoveryHP;

        this.nowHitPoints = Math.min(this.nowHitPoints, this.hitPoints);
        this.nowHitPoints = Math.max(this.nowHitPoints, 0);
    }

    public boolean checkDie(){
        if (this.nowHitPoints <= 0){
            return true;
        } else {
            return false;
        }
    }

    public Action getAction(int actorTeam, int actorId, List<Player> playerArray,  List<Boss> bossArray){
        int[] targetArrayPlayer = new int[3];
        int[] targetArrayBoss = new int[3];
        int attack = 0;
        int spAttack = 0;
        int recoveryHP = 0;

        Scanner sc = new Scanner(System.in);

        System.out.println(this.name);
        System.out.println("Attack: 0, SpAttack: 1, HP Recovery: 2");
        int chooseAction = sc.nextInt();

        if (chooseAction==0){
//            System.out.println("Attack");
//            System.out.println("BossA: 0, BossB: 1, BossC: 2");
            targetArrayPlayer = new int[] {};
            targetArrayBoss = new int[] {0, 1};
            attack = this.attack;
            spAttack = 0;
            recoveryHP = 0;
        } else if (chooseAction==1) {
//            System.out.println("SpAttack");
//            System.out.println("BossA: 0, BossB: 1, BossC: 2");
            targetArrayPlayer = new int[] {};
            targetArrayBoss = new int[] {2};
            attack = 0;
            spAttack = this.spAttack;
            recoveryHP = 0;
        }  else if (chooseAction==2) {
//            System.out.println("HP Recovery");
//            System.out.println("Player1: 0, Player2: 1, Player3: 2");
            targetArrayPlayer = new int[] {0, 1, 2};
            targetArrayBoss = new int[] {};
            attack = 0;
            spAttack = 0;
            recoveryHP = this.recovery;
        }

        Action action = new Action(actorTeam, actorId, targetArrayPlayer, targetArrayBoss, attack, spAttack, recoveryHP);

        return action;
    }
}
