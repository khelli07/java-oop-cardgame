package com.aetherwars.card;

import com.aetherwars.util.Type;
import java.util.ArrayList;

public class PotionSpellCard extends SpellCard {
    private int hp; // Health points (for PotionSpellCard)
    private int attack; // Attack points (for PotionSpellCard)

    // id	name	description	imagepath	attack	hp	mana	duration
    // PotionSpellCard(row[1], row[2], Type.PTN, row[3], row[4], row[6], row[5], row[7])
    public PotionSpellCard(PotionBuilder builder) {
        super(builder.name, builder.desc, Type.PTN, builder.imagepath, builder.mana, builder.duration);
        this.hp = builder.hp;
        this.attack = builder.atk;
    }

    public int getHP() {
        return this.hp;
    }
    public int getAttack() {
        return this.attack;
    }
    public void setHP(int hp) {
        this.hp = hp;
    }
    public void setAttack(int attack) {
        this.attack = attack;
    }

    public void show() {
        super.show();

        System.out.println("HP: " + this.getHP());
        System.out.println("Attack: " + this.getAttack());
    }

    public ArrayList<Object> giveEffect() {
        ArrayList<Object> effect = new ArrayList<Object>();
        effect.add(this.getHP());
        effect.add(this.getAttack());
        return effect;
    }

    public static class PotionBuilder {
        private String name;
        private String desc;
        private String imagepath;
        private int mana;
        private int atk;
        private int hp;
        private int duration;

        public PotionBuilder setCardName(String name) {
            this.name = name; return this;
        }

        public PotionBuilder setCardDescription(String desc) {
            this.desc = desc;return this;
        }

        public PotionBuilder setCardImagePath(String imagepath) {
            this.imagepath = imagepath;return this;
        }

        public PotionBuilder setCardMana(int mana) {
            this.mana = mana;return this;
        }

        public PotionBuilder setCardAtk(int atk) {
            this.atk = atk;return this;
        }

        public PotionBuilder setCardHp(int hp) {
            this.hp = hp;return this;
        }

        public PotionBuilder setCardDuration(int duration){
            this.duration = duration;return this;
        }

        public PotionSpellCard getResult() {
            return new PotionSpellCard(this);
        }
    }
}