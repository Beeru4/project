package com.beerus.entity;

/**
 * @Author Beerus
 * @Description 玩家
 * @Date 2019/4/23
 **/
public class Player {
    private Equip arment;//头盔
    private Equip loricae;//铠甲
    private Equip boot;//靴子
    private Equip ring;//指环

    public Player() {
    }



    public Equip getArment() {
        return arment;
    }

    public void setArment(Equip arment) {
        this.arment = arment;
    }

    public Equip getLoricae() {
        return loricae;
    }

    public void setLoricae(Equip loricae) {
        this.loricae = loricae;
    }

    public Equip getBoot() {
        return boot;
    }

    public void setBoot(Equip boot) {
        this.boot = boot;
    }

    public Equip getRing() {
        return ring;
    }

    public void setRing(Equip ring) {
        this.ring = ring;
    }
}
