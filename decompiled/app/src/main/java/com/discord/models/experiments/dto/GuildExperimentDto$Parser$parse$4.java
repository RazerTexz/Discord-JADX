package com.discord.models.experiments.dto;

import com.discord.models.domain.Model;
import com.discord.models.experiments.dto.GuildExperimentPopulationDto;
import kotlin.jvm.internal.Ref$ObjectRef;

/* JADX INFO: compiled from: GuildExperimentDto.kt */
/* JADX INFO: loaded from: classes.dex */
public final class GuildExperimentDto$Parser$parse$4 implements Runnable {
    public final /* synthetic */ Model.JsonReader $jsonReader;
    public final /* synthetic */ Ref$ObjectRef $populations;

    /* JADX INFO: renamed from: com.discord.models.experiments.dto.GuildExperimentDto$Parser$parse$4$1 */
    /* JADX INFO: compiled from: GuildExperimentDto.kt */
    public static final class C55471<T> implements Model.JsonReader.ItemFactory<GuildExperimentPopulationDto> {
        public C55471() {
        }

        @Override // com.discord.models.domain.Model.JsonReader.ItemFactory
        public /* bridge */ /* synthetic */ GuildExperimentPopulationDto get() {
            return get();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.discord.models.domain.Model.JsonReader.ItemFactory
        public final GuildExperimentPopulationDto get() {
            return GuildExperimentPopulationDto.Parser.INSTANCE.parse(GuildExperimentDto$Parser$parse$4.this.$jsonReader);
        }
    }

    public GuildExperimentDto$Parser$parse$4(Ref$ObjectRef ref$ObjectRef, Model.JsonReader jsonReader) {
        this.$populations = ref$ObjectRef;
        this.$jsonReader = jsonReader;
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [T, java.util.List] */
    @Override // java.lang.Runnable
    public final void run() {
        this.$populations.element = this.$jsonReader.nextList(new C55471());
    }
}
