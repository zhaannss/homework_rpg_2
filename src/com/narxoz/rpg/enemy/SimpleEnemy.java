package com.narxoz.rpg.enemy;
import com.narxoz.rpg.combat.Ability;
import com.narxoz.rpg.loot.LootTable;
import java.util.List;
import java.util.ArrayList;
public class SimpleEnemy extends BaseEnemy {
    public SimpleEnemy(String name, int health, int damage, int defense, int speed,
                       List<Ability> abilities, LootTable lootTable) {
        super(name, health, damage, defense, speed, abilities, lootTable);
    }
    @Override
    protected Enemy createClone(String name, int health, int damage, int defense, int speed,
                                List<Ability> abilities, LootTable lootTable) {
        return new SimpleEnemy(name, health, damage, defense, speed, abilities, lootTable);
    }

}
