package com.example.test.fabric;

import com.example.test.TestMod;
import net.fabricmc.api.ModInitializer;

public class TestModFabric implements ModInitializer {
    @Override
    public void onInitialize() {
        TestMod.init();
    }
}
