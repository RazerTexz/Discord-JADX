package com.discord.models.experiments.dto;

import com.discord.models.domain.Model;
import com.discord.models.experiments.dto.GuildExperimentOverridesDto;
import java.io.IOException;
import kotlin.jvm.internal.Ref$ObjectRef;
import p507d0.p592z.p594d.Intrinsics3;

/* compiled from: GuildExperimentDto.kt */
/* loaded from: classes.dex */
public final class GuildExperimentDto$Parser$parse$5 implements Runnable {
    public final /* synthetic */ Model.JsonReader $jsonReader;
    public final /* synthetic */ Ref$ObjectRef $overrides;

    /* compiled from: GuildExperimentDto.kt */
    /* renamed from: com.discord.models.experiments.dto.GuildExperimentDto$Parser$parse$5$1 */
    public static final class C55481<T> implements Model.JsonReader.ItemFactory<GuildExperimentOverridesDto> {
        public C55481() {
        }

        @Override // com.discord.models.domain.Model.JsonReader.ItemFactory
        public /* bridge */ /* synthetic */ GuildExperimentOverridesDto get() {
            return get();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.discord.models.domain.Model.JsonReader.ItemFactory
        public final GuildExperimentOverridesDto get() {
            return GuildExperimentOverridesDto.Parser.INSTANCE.parse(GuildExperimentDto$Parser$parse$5.this.$jsonReader);
        }
    }

    public GuildExperimentDto$Parser$parse$5(Ref$ObjectRef ref$ObjectRef, Model.JsonReader jsonReader) {
        this.$overrides = ref$ObjectRef;
        this.$jsonReader = jsonReader;
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [T, java.lang.Object, java.util.List] */
    @Override // java.lang.Runnable
    public final void run() throws IOException {
        Ref$ObjectRef ref$ObjectRef = this.$overrides;
        ?? NextList = this.$jsonReader.nextList(new C55481());
        Intrinsics3.checkNotNullExpressionValue(NextList, "jsonReader.nextList { Gu…arser.parse(jsonReader) }");
        ref$ObjectRef.element = NextList;
    }
}
