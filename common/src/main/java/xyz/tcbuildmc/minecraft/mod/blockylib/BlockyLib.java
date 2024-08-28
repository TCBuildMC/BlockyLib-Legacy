package xyz.tcbuildmc.minecraft.mod.blockylib;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import xyz.tcbuildmc.minecraft.mod.blockylib.loader.LoaderAbstract;

public final class BlockyLib {
    public static final String MOD_ID = "blockylib";
    public static final String MOD_NAME = "BlockyLib";
    public static final String MOD_VERSION = LoaderAbstract.getModVersion(MOD_ID);
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_NAME);

    public static void init() {
    }

    @Environment(EnvType.CLIENT)
    public static void initClient() {
    }
}
