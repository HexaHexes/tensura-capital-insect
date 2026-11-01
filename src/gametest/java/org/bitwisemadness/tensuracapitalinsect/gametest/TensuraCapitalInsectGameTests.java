package org.bitwisemadness.tensuracapitalinsect.gametest;

import net.minecraft.core.registries.Registries;
import net.minecraft.gametest.framework.GameTest;
import net.minecraft.gametest.framework.GameTestHelper;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.neoforge.gametest.GameTestHolder;
import net.neoforged.neoforge.gametest.PrefixGameTestTemplate;
import org.bitwisemadness.tensuracapitalinsect.TensuraCapitalInsect;

/** Smoke test: the mod loads and the gametest harness runs. */
@GameTestHolder(TensuraCapitalInsect.MOD_ID)
@PrefixGameTestTemplate(false)
public final class TensuraCapitalInsectGameTests {

    private TensuraCapitalInsectGameTests() {
    }

    @GameTest(template = "empty")
    public static void mod_loads(GameTestHelper helper) {
        helper.succeed();
    }

    /** The Insect capital is a registered structure and its central tag resolves. */
    @GameTest(template = "empty")
    public static void capital_registered_and_tagged(GameTestHelper helper) {
        var registry = helper.getLevel().registryAccess().registryOrThrow(Registries.STRUCTURE);
        var key = net.minecraft.resources.ResourceKey.create(Registries.STRUCTURE,
                ResourceLocation.fromNamespaceAndPath(TensuraCapitalInsect.MOD_ID, "insect"));
        helper.assertTrue(registry.getHolder(key).isPresent(), "the Insect capital structure is not registered");
        var tag = net.minecraft.tags.TagKey.create(Registries.STRUCTURE,
                ResourceLocation.fromNamespaceAndPath("tensura_faction_spawn", "capital/insect"));
        var holders = registry.getTag(tag);
        helper.assertTrue(holders.isPresent() && holders.get().size() > 0, "the Insect capital tag does not resolve");
        helper.succeed();
    }
}