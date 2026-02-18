package src.com.narxoz.rpg.factory;
import src.com.narxoz.rpg.combat.*;
import src.com.narxoz.rpg.loot.*;
import java.util.Arrays;
import java.util.List;
public class ShadowComponentFactory implements EnemyComponentFactory {
    @Override
    public List<Ability> createAbilities() {
        return Arrays.asList(new ShadowStrike(), new Vanish(), new DarkNova());
    }
    @Override
    public LootTable createLootTable() {
        return new ShadowLootTable();
    }
    @Override
    public String createAIBehavior() {
        return "TACTICAL"; // Теневая тема = тактическое поведение
    }
}