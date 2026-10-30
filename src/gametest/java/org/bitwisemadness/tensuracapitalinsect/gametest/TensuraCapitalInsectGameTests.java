package org.bitwisemadness.tensuracapitalinsect.gametest;

import net.minecraft.gametest.framework.GameTest;
import net.minecraft.gametest.framework.GameTestHelper;
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
}