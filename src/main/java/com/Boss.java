package main.java.com;

public enum Boss {
    BossA("BossA", 1000, 10, 10,10,10,10),
    BossB("BossB", 1000, 10, 20,20,20,20),
    BossC("BossC", 1000, 10, 100,100,100,100);

    public final String name;

    private final int hitPoints;
    private final int attack;
    private final int spAttack;
    private final int defence;
    private final int spDefence;
    private final int speed;

//    private int nowHitPoints;
    public int nowHitPoints;
    private int nowAttack;
    private int nowSpAttack;
    private int nowDefence;
    private int nowSpDefence;
    private int nowSpeed;

    private int recovery = 100;

    Boss(String name, int hitPoints, int attack, int spAttack, int defence, int spDefence, int speed){
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
//    public String toString() {
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

}
