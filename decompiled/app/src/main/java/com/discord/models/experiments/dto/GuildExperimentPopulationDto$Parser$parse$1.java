package com.discord.models.experiments.dto;

import com.discord.models.domain.Model;
import com.discord.models.experiments.dto.GuildExperimentBucketDto;
import kotlin.jvm.internal.Ref$ObjectRef;

/* JADX INFO: compiled from: GuildExperimentDto.kt */
/* JADX INFO: loaded from: classes.dex */
public final class GuildExperimentPopulationDto$Parser$parse$1 implements Runnable {
    public final /* synthetic */ Ref$ObjectRef $buckets;
    public final /* synthetic */ Model.JsonReader $jsonReader;

    /* JADX INFO: renamed from: com.discord.models.experiments.dto.GuildExperimentPopulationDto$Parser$parse$1$1 */
    /* JADX INFO: compiled from: GuildExperimentDto.kt */
    public static final class C55601<T> implements Model.JsonReader.ItemFactory<GuildExperimentBucketDto> {
        public C55601() {
        }

        @Override // com.discord.models.domain.Model.JsonReader.ItemFactory
        public /* bridge */ /* synthetic */ GuildExperimentBucketDto get() {
            return get();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.discord.models.domain.Model.JsonReader.ItemFactory
        public final GuildExperimentBucketDto get() {
            return GuildExperimentBucketDto.Parser.INSTANCE.parse(GuildExperimentPopulationDto$Parser$parse$1.this.$jsonReader);
        }
    }

    public GuildExperimentPopulationDto$Parser$parse$1(Ref$ObjectRef ref$ObjectRef, Model.JsonReader jsonReader) {
        this.$buckets = ref$ObjectRef;
        this.$jsonReader = jsonReader;
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [T, java.util.List] */
    @Override // java.lang.Runnable
    public final void run() {
        this.$buckets.element = this.$jsonReader.nextList(new C55601());
    }
}
