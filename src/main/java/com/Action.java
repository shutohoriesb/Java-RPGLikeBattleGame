package main.java.com;

import java.util.List;

public class Action {
    public final int actorTeam; //0 means Player, 1 means Boss.
    public final int actorId;
    public final int[] targetArrayPlayer;
    public final int[] targetArrayBoss;

    public final int attack;
    public final int spAttack;
    public final int recoveryHP;
//    public final int actorTeam; //0 means Player, 1 means Boss.
//    public final int actorId;
//    public final int[] targetArrayPlayer;
//    public final int[] targetArrayBoss;
//
//    public int attack;
//    public final int spAttack;
//    public final int recoveryHP;

    Action(int actorTeam, int actorId, int[] targetArrayPlayer, int[] targetArrayBoss, int attack, int spAttack, int recoveryHP) {
        this.actorTeam = actorTeam;
        this.actorId = actorId;
        this.targetArrayBoss = targetArrayBoss;
        this.targetArrayPlayer = targetArrayPlayer;

        this.attack = attack;
        this.spAttack = spAttack;
        this.recoveryHP = recoveryHP;
    }


    public void doAction(List<Player> playerList, List<Boss> bossList){
        if (actorTeam==0) {
            System.out.println("Action of " + playerList.get(this.actorId).name);
        } else if (actorTeam==1){
            System.out.println("Action of " + bossList.get(this.actorId).name);
        }


        for (int i : this.targetArrayPlayer) {
            playerList.get(i).getDamage(this.attack, this.spAttack, this.recoveryHP);
        }

        for (int i : this.targetArrayBoss) {
            bossList.get(i).getDamage(this.attack, this.spAttack, this.recoveryHP);
        }
    }
}
