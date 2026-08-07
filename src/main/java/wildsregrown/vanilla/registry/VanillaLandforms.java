package wildsregrown.vanilla.registry;

import com.sipke.Constant;
import com.sipke.NoiseGenerator;
import com.sipke.api.categorization.Climate;
import com.sipke.api.categorization.Placement;
import com.sipke.api.terrain.Landform;
import com.sipke.math.CellType;
import com.sipke.math.Distance;
import com.sipke.math.MapType;
import com.sipke.noise2d.Noise;
import com.sipke.noise2d.warp.GradientWarp;
import com.sipke.registeries.WorldRegistries;
import com.sipke.registeries.RegistryContainer;
import wildsregrown.vanilla.WRGVanilla;

import static wildsregrown.vanilla.WRGVanilla.modid;

public class VanillaLandforms {


    ///Mountains

    public static final RegistryContainer<Landform> mountain = WorldRegistries.LANDFORMS.register(
            new Landform.Builder(modid, "mountain", Placement.Elevation.mountain)
                    .addClimate(Climate.chaparral, Climate.steppe, Climate.coolShrubland, Climate.mixedForest)
                    .addStrata(VanillaMaterials.stone, 12, 34, 5)
                    .addStrata(VanillaMaterials.granite, 3, 8, 1)
                    .addStrata(VanillaMaterials.tuff, 5, 24, 2)
                    .addStrata(VanillaMaterials.deepslate, 5, 24, 1)
                    .setNoise((seed, edge)-> {
                        Noise erosion = NoiseGenerator.perlin(seed.next(), 512)
                                .pingpong(3, 2.25f, 0.5f, 0.5f, 2)
                                .multiply(0.025f);
                        Noise surface = NoiseGenerator.simplex(seed.next(), 256)
                                .fbm(3)
                                .multiply(0.05f);
                        Noise shape = Constant.of(edge);
                        return shape.multiply(0.83f)
                                .add(surface)
                                .subtract(erosion)
                                .add(shape.map(MapType.almostUnitIdentity, 0.82f, 1f).multiply(0.12f));
                    })
                    .setDepthNoise((seed)->
                            NoiseGenerator.perlin(seed.next(), 128).fbm(3)
                    )
                    .build());
    public static final RegistryContainer<Landform> igneous_mountain = WorldRegistries.LANDFORMS.register(
            new Landform.Builder(modid, "igneous_mountain", Placement.Elevation.mountain)
                    .addClimate(Climate.chaparral, Climate.coniferousForest, Climate.polarDesert, Climate.tundra, Climate.hotScrubland, Climate.coolShrubland, Climate.mixedForest, Climate.coniferousForest, Climate.steppe)
                    .scale(0.88f)
                    .addStrata(VanillaMaterials.stone, 12, 34, 5)
                    .addStrata(VanillaMaterials.granite, 3, 8, 2)
                    .addStrata(VanillaMaterials.andesite, 5, 24, 2)
                    .addStrata(VanillaMaterials.diorite, 5, 24, 1)
                    .addStrata(VanillaMaterials.deepslate, 5, 24, 1)
                    .addStrata(VanillaMaterials.tuff, 5, 24, 1)
                    .setNoise((seed, edge)-> {
                        Noise erosion = NoiseGenerator.perlin(seed.next(), 128)
                                .pingpong(3, 2.25f, 0.5f, 0.5f, 2)
                                .multiply(0.032f);
                        return NoiseGenerator.cubic(seed.next(), 950)
                                .fbm(5)
                                .subtract(erosion)
                                .boost(2)
                                ;
                    })
                    .setDepthNoise((seed)->
                            NoiseGenerator.perlin(seed.next(), 128).fbm(3)
                    )
                    .build());
    public static final RegistryContainer<Landform> warm_mountains = WorldRegistries.LANDFORMS.register(
            new Landform.Builder(modid, "warm_mountains", Placement.Elevation.mountain)
                    .addClimate(Climate.hotDesert, Climate.coolDesert, Climate.savanna, Climate.coolShrubland, Climate.hotScrubland)
                    .scale(0.785f)
                    .addStrata(VanillaMaterials.stone, 12, 34, 5)
                    .addStrata(VanillaMaterials.red_sandstone, 3, 8, 1)
                    .addStrata(VanillaMaterials.sandstone, 5, 24, 2)
                    .addStrata(VanillaMaterials.granite, 2, 5, 1)
                    .setNoise((seed, edge)-> {
                        Noise erosion = NoiseGenerator.perlin(seed.next(), 512)
                                .pingpong(3, 2.25f, 0.5f, 0.5f, 2)
                                .multiply(0.015f);
                        return NoiseGenerator.perlin(seed.next(), 1512)
                                .ridged(5, 1.55f, 0.6f, 0.35f)
                                .scalebias(0.8f, 0.2f)
                                .subtract(erosion)
                                .boost(2);
                    })
                    .setDepthNoise((seed)->
                            NoiseGenerator.perlin(seed.next(), 128).fbm(3)
                    )
                    .build());
    public static final RegistryContainer<Landform> cold_mountains = WorldRegistries.LANDFORMS.register(
            new Landform.Builder(modid, "cold_mountains", Placement.Elevation.mountain)
                    .addClimate(Climate.ice, Climate.tundra, Climate.polarDesert)
                    .addStrata(VanillaMaterials.stone, 12, 34, 7)
                    .addStrata(VanillaMaterials.black_stone, 2, 8, 1)
                    .addStrata(VanillaMaterials.calcite, 2, 8, 1)
                    .addStrata(VanillaMaterials.deepslate, 5, 13, 1)
                    .setNoise((seed, edge)-> {
                        Noise erosion = NoiseGenerator.perlin(seed.next(), 384)
                                .pingpong(3, 2.25f, 0.5f, 0.5f, 2)
                                .multiply(0.12f);
                        return NoiseGenerator.perlin(seed.next(), 1200).fbm(5)
                                .scalebias(0.3f, 0.7f)
                                .subtract(erosion);
                    })
                    .setDepthNoise((seed)->
                            NoiseGenerator.perlin(seed.next(), 128).fbm(3)
                    )
                    .build());
    public static final RegistryContainer<Landform> vesuvius = WorldRegistries.LANDFORMS.register(
            new Landform.Builder(modid, "vesuvius", Placement.Elevation.mountain)
            .addClimate(Climate.chaparral, Climate.steppe, Climate.coolShrubland, Climate.mixedForest)
            .addStrata(VanillaMaterials.basalt, 12, 34, 5)
            .addStrata(VanillaMaterials.granite, 3, 8, 1)
            .addStrata(VanillaMaterials.andesite, 5, 24, 2)
            .addStrata(VanillaMaterials.diorite, 5, 24, 1)
            .setNoise((seed, edge)-> {
                Noise surface = NoiseGenerator.perlin(seed.next(), 128).fbm(3)
                        .multiply(0.57f);
                Noise ridges = NoiseGenerator.simplex(seed.next(), 64).ridged(3)
                        .multiply(0.0125f);
                Noise shape = Constant.of(edge).parabola(0.618f).curve(0.57f);
                return shape
                        .overlay(surface)
                        .subtract(ridges)
                        .warp(seed.next(), 128, 64)
                        .warp(seed.next(), 32, 8)
                        .terrace(12, NoiseGenerator.cubic(seed.next(), 512).map(MapType.quintic, 0.785f, 1f), 0.382f, 0.785f, 0.0625f);
            })
            .setDepthNoise((seed)->
                    NoiseGenerator.cubic(seed.next(), 384).ridged(5)
            )
            .build());

    ///Highlands

    public static final RegistryContainer<Landform> highlands = WorldRegistries.LANDFORMS.register(
            new Landform.Builder(modid, "highlands", Placement.Elevation.highland)
                    .scale(0.5f)
                    .addClimate(Climate.coniferousForest, Climate.mixedForest, Climate.steppe, Climate.chaparral, Climate.deciduousForest)
                    .addStrata(VanillaMaterials.stone, 12, 34, 5)
                    .addStrata(VanillaMaterials.granite, 3, 8, 1)
                    .addStrata(VanillaMaterials.tuff, 5, 24, 2)
                    .addStrata(VanillaMaterials.deepslate, 5, 24, 1)
                    .setNoise((seed, edge)-> {
                        Noise erosion = NoiseGenerator.perlin(seed.next(), 320)
                                .ridged(3, 2.8f, 0.5f, 0.5f)
                                .warp(new GradientWarp(seed.next(), 256), 128)
                                .multiply(0.08f);
                        return NoiseGenerator.perlin(seed.next(), 1024)
                                .steps(8,
                                        NoiseGenerator.simplexFast(seed.next(), 500).map(0f, 0.4f))
                                .warp(new GradientWarp(seed.next(), 1200), 512)
                                .fbm(3, 2.2f, 0.6f, 0.5f)
                                .warp(new GradientWarp(seed.next(), 512), 128)
                                .subtract(erosion)
                                .map(MapType.almostUnitIdentity, 0.1f, 0.9f);
                    })
                    .setDepthNoise((seed)->
                            NoiseGenerator.perlin(seed.next(), 384).fbm(3)
                    )
                    .build());
    public static final RegistryContainer<Landform> hills = WorldRegistries.LANDFORMS.register(
            new Landform.Builder(modid, "hills", Placement.Elevation.highland)
                    .scale(0.5f)
                    .setAllLandClimate()
                    .addStrata(VanillaMaterials.stone, 12, 34, 5)
                    .addStrata(VanillaMaterials.granite, 3, 8, 1)
                    .addStrata(VanillaMaterials.tuff, 5, 24, 2)
                    .addStrata(VanillaMaterials.deepslate, 5, 24, 1)
                    .setNoise((seed, edge)-> {
                        return NoiseGenerator.simplex(seed.next(), 1024)
                                .fbm(6, 1.8f, 0.5f, 0.5f)
                                .warp(seed.next(), 384, 384)
                                .map(MapType.hermite, 0.25f, 0.85f)
                                .multiply(edge);
                    })
                    .setDepthNoise((seed)->
                            NoiseGenerator.perlin(seed.next(), 384).fbm(3)
                    )
                    .build());
    public static final RegistryContainer<Landform> mesa = WorldRegistries.LANDFORMS.register(
            new Landform.Builder(modid, "mesa", Placement.Elevation.highland)
                    .scale(0.5f)
                    .addClimate(Climate.coolShrubland, Climate.hotScrubland, Climate.savanna, Climate.chaparral)
                    .addStrata(VanillaMaterials.sandstone, 12, 34, 5)
                    .addStrata(VanillaMaterials.red_sandstone, 5, 8, 2)
                    .addStrata(VanillaMaterials.stone, 5, 34, 2)
                    .addStrata(VanillaMaterials.granite, 3, 8, 1)
                    .addStrata(VanillaMaterials.tuff, 5, 24, 1)
                    .addStrata(VanillaMaterials.deepslate, 5, 24, 1)
                    .setNoise((seed, edge)-> {
                        Noise mask = NoiseGenerator.simplex(seed.next(), 512)
                                .map(MapType.hermite, 0.25f, 0.5f);
                        Noise underlayer = NoiseGenerator.simplex(seed.next(), 320)
                                .fbm(3, 3.8f, 0.5f, 0.5f)
                                .warp(seed.next(), 250, 250)
                                .add(NoiseGenerator.simplex(seed.next(), 64).multiply(0.175f))
                                .multiply(0.2f);
                        Noise upperlayer = NoiseGenerator.simplex(seed.next(), 380)
                                .warp(seed.next(), 180, 120)
                                .ridged(3, 2.5f, 0.5f, 0.5f)
                                .fbm(2)
                                .boost(2);
                        return mask.blend(underlayer, upperlayer, 0.25f, 1f, MapType.almostUnitIdentity)
                                .multiply(NoiseGenerator.constant(edge).map(MapType.hermite));
                    })
                    .setDepthNoise((seed)->
                            NoiseGenerator.perlin(seed.next(), 384).fbm(3)
                    )
                    .build());
    public static final RegistryContainer<Landform> plateau = WorldRegistries.LANDFORMS.register(
            new Landform.Builder(modid, "plateau", Placement.Elevation.highland)
                    .addClimate(Climate.chaparral, Climate.chaparral, Climate.coolDesert, Climate.hotDesert, Climate.hotScrubland, Climate.coolShrubland)
                    .addStrata(VanillaMaterials.sandstone, 12, 34, 5)
                    .addStrata(VanillaMaterials.red_sandstone, 5, 8, 2)
                    .addStrata(VanillaMaterials.stone, 5, 34, 2)
                    .addStrata(VanillaMaterials.granite, 3, 8, 1)
                    .addStrata(VanillaMaterials.tuff, 5, 24, 1)
                    .addStrata(VanillaMaterials.deepslate, 5, 24, 1)
                    .setNoise((seed, edge)-> {
                        Noise surface = NoiseGenerator.perlin(seed.next(), 180)
                                .fbm(3, 2.25f, 0.5f, 0.5f);
                        Noise valleys = NoiseGenerator.simplex(seed.next(), 1024)
                                .ridged(5).invert()
                                .map(MapType.hermite, 0.43f, 0.57f);
                        return valleys.lerp(surface, 0.16f);
                    })
                    .setDepthNoise((seed)->
                            NoiseGenerator.perlin(seed.next(), 512).fbm(3)
                    )
                    .build());
    public static final RegistryContainer<Landform> desert_dunes = WorldRegistries.LANDFORMS.register(
            new Landform.Builder(modid, "desert_dunes", Placement.Elevation.highland)
                    .scale(0.32f)
                    .addClimate(Climate.chaparral, Climate.hotDesert, Climate.coolDesert)
                    .addStrata(VanillaMaterials.sandstone, 12, 34, 5)
                    .addStrata(VanillaMaterials.red_sandstone, 5, 8, 2)
                    .addStrata(VanillaMaterials.stone, 5, 34, 2)
                    .addStrata(VanillaMaterials.tuff, 5, 13, 1)
                    .setNoise((seed, edge)-> {
                        return NoiseGenerator.cubic(seed.next(), 768)
                                .pingpong(5, 1.85f, 0.5f, 0.43f, 1f)
                                .boost(3);
                    })
                    .setDepthNoise((seed)->
                            NoiseGenerator.simplex(seed.next(), 512).fbm(3)
                    )
                    .build());

    ///Low lands

    public static final RegistryContainer<Landform> flat_lands = WorldRegistries.LANDFORMS.register(
            new Landform.Builder(modid, "flat_lands", Placement.Elevation.lowland)
                    .scale(0)
                    .setAllLandClimate()
                    .addStrata(VanillaMaterials.stone, 12, 34, 5)
                    .addStrata(VanillaMaterials.tuff, 5, 24, 2)
                    .addStrata(VanillaMaterials.deepslate, 5, 24, 1)
                    .setDepthNoise((seed)->
                            NoiseGenerator.simplex(seed.next(), 512).fbm(3)
                    )
                    .build());
    public static final RegistryContainer<Landform> plains = WorldRegistries.LANDFORMS.register(
            new Landform.Builder(modid, "plains", Placement.Elevation.lowland)
                    .setAllLandClimate()
                    .scale(0.12f)
                    .addStrata(VanillaMaterials.stone, 12, 34, 5)
                    .addStrata(VanillaMaterials.granite, 3, 8, 1)
                    .addStrata(VanillaMaterials.tuff, 5, 24, 2)
                    .addStrata(VanillaMaterials.deepslate, 5, 24, 1)
                    .setNoise((seed, edge)-> {
                        Noise selector = NoiseGenerator.simplex(seed.next(), 150);
                        Noise high = NoiseGenerator.cubic(seed.next(), 80);
                        Noise low = NoiseGenerator.simplex(seed.next(), 32).multiply(0.4f);
                        return selector.blend(high,low).warp(seed.next(), 128, 64);
                    })
                    .setDepthNoise((seed)->
                            NoiseGenerator.perlin(seed.next(), 512).fbm(3)
                    )
                    .build());
    public static final RegistryContainer<Landform> tundra = WorldRegistries.LANDFORMS.register(
            new Landform.Builder(modid, "tundra", Placement.Elevation.lowland)
                    .addClimate(Climate.tundra, Climate.ice, Climate.polarDesert)
                    .addStrata(VanillaMaterials.stone, 12, 34, 5)
                    .addStrata(VanillaMaterials.granite, 3, 8, 1)
                    .addStrata(VanillaMaterials.tuff, 5, 24, 2)
                    .addStrata(VanillaMaterials.deepslate, 5, 24, 1)
                    .setNoise((seed, edge)-> {
                        return NoiseGenerator.simplex(seed.next(), 384)
                                .fbm(3, 3.5f, 0.5f, 0.5f)
                                .warp(seed.next(), 256, 220)
                                .warp(seed.next(), 180, 140)
                                .warp(seed.next(), 80, 60);
                    })
                    .setDepthNoise((seed)->
                            NoiseGenerator.perlin(seed.next(), 384).fbm(3)
                    )
                    .build());
    public static final RegistryContainer<Landform> smooth_desert = WorldRegistries.LANDFORMS.register(
            new Landform.Builder(modid, "smooth_desert", Placement.Elevation.lowland)
                    .scale(0.25f)
                    .addClimate(Climate.hotDesert, Climate.coolDesert)
                    .addStrata(VanillaMaterials.stone, 8, 12, 2)
                    .addStrata(VanillaMaterials.sandstone, 5, 24, 5)
                    .addStrata(VanillaMaterials.red_sandstone, 5, 24, 1)
                    .setNoise((seed, edge)-> {
                        return NoiseGenerator.cubic(seed.next(), 480)
                                .pingpong(3, 1.95f, 0.5f, 0.43f, 1f)
                                .boost(5);
                    })
                    .setDepthNoise((seed)->
                            NoiseGenerator.perlin(seed.next(), 512).fbm(3)
                    )
                    .build());

    ///Coast

    public static final RegistryContainer<Landform> cliffs = WorldRegistries.LANDFORMS.register(
            new Landform.Builder(modid, "cliffs", Placement.Elevation.coast)
                    .setAllLandClimate()
                    .scale(0.28f)
                    .addStrata(VanillaMaterials.stone, 12, 34, 5)
                    .addStrata(VanillaMaterials.calcite, 3, 8, 1)
                    .addStrata(VanillaMaterials.tuff, 5, 24, 2)
                    .addStrata(VanillaMaterials.sandstone, 5, 24, 1)
                    .setNoise((seed, edge)-> {
                        Noise mask = NoiseGenerator.simplex(seed.next(), 1024)
                                .ridged(5, 1.55f, 0.5f, 0.5f);
                        return NoiseGenerator.perlin(seed.next(), 384)
                                .fbm(3, 1.85f, 0.5f,0.5f)
                                .warp(seed.next(), 256, 128)
                                .warp(seed.next(), 128, 64)
                                .multiply(mask.invert())
                                .range(-0.125f, 1f);
                    })
                    .setDepthNoise((seed)->
                            NoiseGenerator.perlin(seed.next(), 384).fbm(3)
                    )
                    .build());
    public static final RegistryContainer<Landform> beach = WorldRegistries.LANDFORMS.register(
            new Landform.Builder(modid, "beach", Placement.Elevation.coast)
                    .setAllLandClimate()
                    .scale(0.175f)
                    .addStrata(VanillaMaterials.stone, 12, 34, 5)
                    .addStrata(VanillaMaterials.granite, 3, 8, 1)
                    .addStrata(VanillaMaterials.tuff, 5, 24, 2)
                    .addStrata(VanillaMaterials.deepslate, 5, 24, 1)
                    .setNoise((seed, edge)-> {
                        return NoiseGenerator.cubic(seed.next(), 128)
                                .fbm(5, 1.45f, 0.45f, 0.38f)
                                .multiply(Constant.of(edge).map(MapType.almostUnitIdentity, 0.215f, 0.57f));
                    })
                    .setDepthNoise((seed)->
                            NoiseGenerator.perlin(seed.next(), 180).fbm(3)
                    )
                    .build());
    public static final RegistryContainer<Landform> dunes = WorldRegistries.LANDFORMS.register(
            new Landform.Builder(modid, "dunes", Placement.Elevation.coast)
                    .setAllLandClimate()
                    .scale(0.18f)
                    .addStrata(VanillaMaterials.stone, 12, 34, 5)
                    .addStrata(VanillaMaterials.sandstone, 3, 8, 1)
                    .addStrata(VanillaMaterials.tuff, 5, 24, 2)
                    .setNoise((seed, edge)-> {
                        return NoiseGenerator.voronoi(seed.next(), 256, Distance.hybrid, CellType.distance2Div, 0.75f, true)
                                .fbm(3)
                                .invert()
                                .warp(seed.next(), 220, 80)
                                .warp(seed.next(), 80, 44);
                    })
                    .setDepthNoise((seed)->
                            NoiseGenerator.perlin(seed.next(), 384).fbm(3)
                    )
                    .build());

    ///Oceans

    public static final RegistryContainer<Landform> abyss = WorldRegistries.LANDFORMS.register(
            new Landform.Builder(modid, "abyss", Placement.Elevation.ocean)
                    .scale(0.02f)
                    .addClimate(Climate.coldOcean, Climate.temperateOcean, Climate.warmOcean)
                    .addStrata(VanillaMaterials.basalt, 12, 34, 5)
                    .addStrata(VanillaMaterials.granite, 3, 8, 1)
                    .setNoise((seed, edge)-> {
                        return NoiseGenerator.cubic(seed.next(), 1024)
                                .fbm(3)
                                .warp(seed.next(), 250, 250)
                                .map(MapType.inverseQuintic, 0.25f, 0.38f);
                    })
                    .setDepthNoise((seed)->
                            NoiseGenerator.perlin(seed.next(), 256).fbm(3)
                    )
                    .build());
    public static final RegistryContainer<Landform> basin = WorldRegistries.LANDFORMS.register(
            new Landform.Builder(modid, "basin", Placement.Elevation.mountain)
                    .scale(0f)
                    .addClimate(Climate.coldOcean, Climate.temperateOcean, Climate.warmOcean)
                    .addStrata(VanillaMaterials.basalt, 12, 34, 5)
                    .addStrata(VanillaMaterials.granite, 3, 8, 1)
                    .setDepthNoise((seed)->
                            NoiseGenerator.perlin(seed.next(), 384).fbm(3)
                    )
                    .build());

    ///Sea's

    public static final RegistryContainer<Landform> ridge = WorldRegistries.LANDFORMS.register(
            new Landform.Builder(modid, "ridge", Placement.Elevation.sea)
                    .scale(0.0215f)
                    .addClimate( Climate.coldSea, Climate.temperateSea, Climate.warmSea)
                    .addStrata(VanillaMaterials.stone, 12, 34, 5)
                    .addStrata(VanillaMaterials.granite, 3, 8, 1)
                    .addStrata(VanillaMaterials.basalt, 3, 8, 1)
                    .setNoise((seed, edge)-> {
                        return NoiseGenerator.cubic(seed.next(), 768)
                                .ridged(2, 1.8f, 0.5f, 0.5f)
                                .multiply(edge);
                    })
                    .setDepthNoise((seed)->
                            NoiseGenerator.perlin(seed.next(), 256).fbm(3)
                    )
                    .build());
    public static final RegistryContainer<Landform> rift = WorldRegistries.LANDFORMS.register(
            new Landform.Builder(modid, "rift", Placement.Elevation.sea)
                    .scale(0.0215f)
                    .addClimate( Climate.coldSea, Climate.temperateSea, Climate.warmSea)
                    .addStrata(VanillaMaterials.stone, 12, 34, 5)
                    .addStrata(VanillaMaterials.granite, 3, 8, 1)
                    .addStrata(VanillaMaterials.basalt, 3, 8, 1)
                    .addStrata(VanillaMaterials.tuff, 5, 24, 2)
                    .addStrata(VanillaMaterials.deepslate, 5, 24, 1)
                    .setNoise((seed, edge)-> {
                        return NoiseGenerator.cubic(seed.next(), 768)
                                .ridged(2, 1.8f, 0.5f, 0.5f)
                                .map(MapType.inverseQuintic, 0.5f, 0.85f)
                                .invert()
                                .multiply(edge);
                    })
                    .setDepthNoise((seed)->
                            NoiseGenerator.perlin(seed.next(), 512).fbm(3)
                    )
                    .build());

    public static void init(){
        WRGVanilla.LOGGER.info("loaded landforms");
    }

}
