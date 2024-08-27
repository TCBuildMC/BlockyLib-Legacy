package xyz.tcbuildmc.minecraft.mod.blockylib.event.command;

import com.mojang.brigadier.CommandDispatcher;
import net.minecraft.commands.CommandBuildContext;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.Commands;
import xyz.tcbuildmc.minecraft.mod.blockylib.event.Event;

@FunctionalInterface
public interface CommandRegistrationEvent {
    Event<CommandRegistrationEvent> EVENT = Event.create();

    void register(CommandDispatcher<CommandSourceStack> dispatcher, CommandBuildContext registryAccess, Commands.CommandSelection environment);
}
