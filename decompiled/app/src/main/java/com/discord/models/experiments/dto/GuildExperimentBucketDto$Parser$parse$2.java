package com.discord.models.experiments.dto;

import com.discord.models.domain.Model;
import com.discord.models.experiments.dto.GuildExperimentBucketDto;
import d0.z.d.m;
import java.io.IOException;
import kotlin.jvm.internal.Ref$ObjectRef;
import kotlin.ranges.IntRange;

/* compiled from: GuildExperimentDto.kt */
/* loaded from: classes.dex */
public final class GuildExperimentBucketDto$Parser$parse$2 implements Runnable {
    public final /* synthetic */ Ref$ObjectRef $positions;
    public final /* synthetic */ Model.JsonReader $reader;

    /* compiled from: GuildExperimentDto.kt */
    /* renamed from: com.discord.models.experiments.dto.GuildExperimentBucketDto$Parser$parse$2$1, reason: invalid class name */
    public static final class AnonymousClass1<T> implements Model.JsonReader.ItemFactory<IntRange> {
        public AnonymousClass1() {
        }

        @Override // com.discord.models.domain.Model.JsonReader.ItemFactory
        public /* bridge */ /* synthetic */ IntRange get() {
            return get2();
        }

        @Override // com.discord.models.domain.Model.JsonReader.ItemFactory
        /* renamed from: get, reason: avoid collision after fix types in other method */
        public final IntRange get2() {
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
        ?? NextList = this.$reader.nextList(new AnonymousClass1());
        m.checkNotNullExpressionValue(NextList, "reader.nextList { parsePosition(reader) }");
        ref$ObjectRef.element = NextList;
    }
}
