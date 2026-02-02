package vanilla.wildsregrown.mixin;

import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.structure.StructureSet;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.source.BiomeSource;
import net.minecraft.world.gen.chunk.placement.StructurePlacementCalculator;
import net.minecraft.world.gen.structure.Structure;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import vanilla.wildsregrown.WRGVanilla;

import java.util.*;

@Mixin(StructurePlacementCalculator.class)
public class StructurePlacement {

    @Final
    @Shadow
    private List<RegistryEntry<StructureSet>> structureSets;

    @Final
    @Shadow
    private BiomeSource biomeSource;

    @Final
    @Shadow
    private Map<Structure, List<net.minecraft.world.gen.chunk.placement.StructurePlacement>> structuresToPlacements;


    @Inject(at = @At(value = "HEAD"), method = "Lnet/minecraft/world/gen/chunk/placement/StructurePlacementCalculator;hasValidBiome(Lnet/minecraft/structure/StructureSet;Lnet/minecraft/world/biome/source/BiomeSource;)Z", cancellable = true)
    private static void hasValidBiome(StructureSet structureSet, BiomeSource biomeSource, CallbackInfoReturnable<Boolean> cir) {
        cir.setReturnValue(true);
    }

    @Inject(method = "Lnet/minecraft/world/gen/chunk/placement/StructurePlacementCalculator;calculate()V", at = @At(value = "HEAD"), cancellable = true)
    private void calculate(CallbackInfo ci) {
        Set<RegistryEntry<Biome>> set = this.biomeSource.getBiomes();
        this.structureSets.forEach((structureSet) -> {
            StructureSet value = structureSet.value();
            for(StructureSet.WeightedEntry weightedEntry : value.structures()) {
                Structure structure = weightedEntry.structure().value();
                WRGVanilla.LOGGER.info("Mixin: " + weightedEntry.structure().getIdAsString());
                Objects.requireNonNull(set);
                (this.structuresToPlacements.computeIfAbsent(structure, (structurex) -> new ArrayList())).add(value.placement());
            }

        });
        ci.cancel();
    }
}