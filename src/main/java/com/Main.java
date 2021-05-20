package main.java.com;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Player> playerList  = new LinkedList<>(Arrays.asList(Player.values()));
        List<Boss> bossList  = new LinkedList<>(Arrays.asList(Boss.values()));

        for (Player player : playerList) {
            System.out.println(player);
        }
        System.out.println();
        for (Boss boss : bossList) {
            System.out.println(boss);
        }
        System.out.println("==============================================");


        List<Action> actionList = new LinkedList<>();
        while(true) {
            for (int actorID=0; actorID < playerList.size(); actorID++) {
                Action action = playerList.get(actorID).getAction(0, actorID, playerList, bossList);
                actionList.add(action);
                System.out.println();
            }
            for (Action action : actionList) {
                action.doAction(playerList, bossList);
            }
            System.out.println();
            actionList = new LinkedList<>();

            for (Player player : playerList) {
                System.out.println(player);
            }
            System.out.println();
            for (Boss boss : bossList) {
                System.out.println(boss);
            }


            int bossHP = 0;
            for (Boss boss : bossList) {
                bossHP += boss.nowHitPoints;
            }

            if (bossHP==0){
                break;
            }

        }
        System.out.println();

    }
}
