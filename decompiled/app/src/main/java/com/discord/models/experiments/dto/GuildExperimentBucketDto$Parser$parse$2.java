package com.discord.models.experiments.dto;

import com.discord.models.domain.Model;
import com.discord.models.experiments.dto.GuildExperimentBucketDto;
import java.io.IOException;
import kotlin.jvm.internal.Ref$ObjectRef;
import kotlin.ranges.Ranges2;
import p507d0.p592z.p594d.Intrinsics3;

/* JADX INFO: compiled from: GuildExperimentDto.kt */
/* JADX INFO: loaded from: classes.dex */
public final class GuildExperimentBucketDto$Parser$parse$2 implements Runnable {
    public final /* synthetic */ Ref$ObjectRef $positions;
    public final /* synthetic */ Model.JsonReader $reader;

    /* JADX INFO: renamed from: com.discord.models.experiments.dto.GuildExperimentBucketDto$Parser$parse$2$1 */
    /* JADX INFO: compiled from: GuildExperimentDto.kt */
    public static final class C55461<T> implements Model.JsonReader.ItemFactory<Ranges2> {
        public C55461() {
        }

        @Override // com.discord.models.domain.Model.JsonReader.ItemFactory
        public /* bridge */ /* synthetic */ Ranges2 get() {
            return get2();
        }

        @Override // com.discord.models.domain.Model.JsonReader.ItemFactory
        /* JADX INFO: renamed from: get, reason: avoid collision after fix types in other method */
        public final Ranges2 get2() {
            return GuildExperimentBucketDto.Parser.access$parsePosition(GuildExperimentBucketDto.Parser.INSTANCE, GuildExperimentBucketDto$Parser$parse$2.this.$reader);
        }
    }

    public GuildExperimentBucketDto$Parser$parse$2(Ref$ObjectRef ref$ObjectRef, Model.JsonReader jsonReader) {
        this.$positions = ref$ObjectRef;
        this.$reader = jsonReader;
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [T, java.lang.Object, java.util.List] */
    @Override // java.lang.Runnable
    public final void run() throws IOException {
        Ref$ObjectRef ref$ObjectRef = this.$positions;
        ?? NextList = this.$reader.nextList(new C55461());
        Intrinsics3.checkNotNullExpressionValue(NextList, "reader.nextList { parsePosition(reader) }");
        ref$ObjectRef.element = NextList;
    }
}
