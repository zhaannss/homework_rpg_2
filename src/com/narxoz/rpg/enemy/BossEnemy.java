package src.com.narxoz.rpg.enemy;
import src.com.narxoz.rpg.combat.Ability;
import src.com.narxoz.rpg.loot.LootTable;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
public class BossEnemy extends BaseEnemy {
    private final Map<Integer, Integer> phases;
    public BossEnemy(String name, int health, int damage, int defense, int speed,
                     List<Ability> abilities, LootTable lootTable, Map<Integer, Integer> phases) {
        super(name, health, damage, defense, speed, abilities, lootTable);
        this.phases = new HashMap<>(phases);
    }
    public Map<Integer, Integer> getPhases() {
        return new HashMap<>(phases);
    }
    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Phases: " + phases);
    }
    @Override
    protected Enemy createClone(String name, int health, int damage, int defense, int speed,
                                List<Ability> abilities, LootTable lootTable) {
        return new BossEnemy(name, health, damage, defense, speed, abilities, lootTable, new HashMap<>(this.phases));
    }
}