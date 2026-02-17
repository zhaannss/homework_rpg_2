package src.com.narxoz.rpg.enemy;
import  src.com.narxoz.rpg.combat.Ability;
import  src.com.narxoz.rpg.loot.LootTable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
public abstract class BaseEnemy implements Enemy {
    protected final String name;
    protected final int health;
    protected final int damage;
    protected final int defense;
    protected final int speed;
    protected final List<Ability> abilities;
    protected final LootTable lootTable;
    protected BaseEnemy(String name,
                            int health,
                            int damage,
                            int defense,
                            int speed,
                            List<Ability> abilities,
                            LootTable lootTable) {

        this.name = name;
        this.health = health;
        this.damage = damage;
        this.defense = defense;
        this.speed = speed;

        this.abilities = Collections.unmodifiableList(new ArrayList<>(abilities));
        this.lootTable = lootTable;
    }

    public String getName() { return name; }
    public int getHealth() { return health; }
    public int getDamage() { return damage; }
    public int getDefense() { return defense; }
    public int getSpeed() { return speed; }
    public List<Ability> getAbilities() { return abilities; }
    public LootTable getLootTable() { return lootTable; }

    @Override
    public void displayInfo() {
        System.out.println("=== ENEMY ===");
        System.out.println("Name: " + name);
        System.out.println("HP: " + health);
        System.out.println("DMG: " + damage);
        System.out.println("DEF: " + defense);
        System.out.println("SPD: " + speed);

        System.out.println("\nAbilities:");
        for (Ability ability : abilities) {
            System.out.println("- " + ability.getName() +
                    " (" + ability.getDamage() + ")");
        }

        System.out.println("\nLoot:");
        System.out.println("Gold: " + lootTable.getGoldDrop());
        System.out.println("XP: " + lootTable.getExperienceDrop());
        System.out.println("Items: " + lootTable.getItems());
    }
    @Override
    public Enemy clone() {
        List<Ability> clonedAbilities = new ArrayList<>();
        for (Ability ability : abilities) {
            clonedAbilities.add(ability.clone());
        }

        LootTable clonedLoot = lootTable.clone();

        return createClone(
                name,
                health,
                damage,
                defense,
                speed,
                clonedAbilities,
                clonedLoot
        );
    }
    protected abstract Enemy createClone(
            String name,
            int health,
            int damage,
            int defense,
            int speed,
            List<Ability> abilities,
            LootTable lootTable
    );
}