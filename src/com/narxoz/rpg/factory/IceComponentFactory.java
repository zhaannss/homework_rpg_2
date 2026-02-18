package src.com.narxoz.rpg.factory;
import src.com.narxoz.rpg.combat.*;
import src.com.narxoz.rpg.loot.*;
import java.util.Arrays;
import java.util.List;
public class IceComponentFactory implements EnemyComponentFactory {
    @Override
    public List<Ability> createAbilities() {
        return Arrays.asList(new FrostBreath(), new IceShield(), new Blizzard());
    }
    @Override
    public LootTable createLootTable() {
        return new IceLootTable();
    }
    @Override
    public String createAIBehavior() {
        return "DEFENSIVE";// Ледяная тема = защитное поведение
    }
}