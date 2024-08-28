package com.example.test.forge;

import com.example.test.TestMod;
import net.minecraftforge.fml.common.Mod;

@Mod("test_mod")
public class TestModForge {
    public TestModForge() {
        TestMod.init();
    }
}
