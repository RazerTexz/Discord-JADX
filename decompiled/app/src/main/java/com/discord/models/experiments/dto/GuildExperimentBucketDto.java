package com.discord.models.experiments.dto;

import b.d.b.a.a;
import com.discord.models.domain.Model;
import d0.t.n;
import d0.z.d.m;
import java.io.IOException;
import java.util.List;
import kotlin.jvm.internal.Ref$IntRef;
import kotlin.jvm.internal.Ref$ObjectRef;
import kotlin.ranges.IntRange;

/* compiled from: GuildExperimentDto.kt */
/* loaded from: classes.dex */
public final /* data */ class GuildExperimentBucketDto {
    private final int bucket;
    private final List<IntRange> positions;

    /* compiled from: GuildExperimentDto.kt */
    public static final class Parser {
        public static final Parser INSTANCE = new Parser();

        private Parser() {
        }

        public static final /* synthetic */ IntRange access$parsePosition(Parser parser, Model.JsonReader jsonReader) {
            return parser.parsePosition(jsonReader);
        }

        private final IntRange parsePosition(Model.JsonReader jsonReader) throws IOException {
            Ref$IntRef ref$IntRef = new Ref$IntRef();
            ref$IntRef.element = -1;
            Ref$IntRef ref$IntRef2 = new Ref$IntRef();
            ref$IntRef2.element = -1;
            jsonReader.nextObject(new GuildExperimentBucketDto$Parser$parsePosition$1(ref$IntRef, jsonReader, ref$IntRef2));
            return new IntRange(ref$IntRef.element, ref$IntRef2.element);
        }

        /* JADX WARN: Type inference failed for: r2v0, types: [T, java.util.List] */
        public final GuildExperimentBucketDto parse(Model.JsonReader reader) throws IOException {
            m.checkNotNullParameter(reader, "reader");
            Ref$IntRef ref$IntRef = new Ref$IntRef();
            ref$IntRef.element = -1;
            Ref$ObjectRef ref$ObjectRef = new Ref$ObjectRef();
            ref$ObjectRef.element = n.emptyList();
            reader.nextListIndexed(new GuildExperimentBucketDto$Parser$parse$1(ref$IntRef, reader), new GuildExperimentBucketDto$Parser$parse$2(ref$ObjectRef, reader));
            return new GuildExperimentBucketDto(ref$IntRef.element, (List) ref$ObjectRef.element);
        }
    }

    public GuildExperimentBucketDto(int i, List<IntRange> list) {
        m.checkNotNullParameter(list, "positions");
        this.bucket = i;
        this.positions = list;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ GuildExperimentBucketDto copy$default(GuildExperimentBucketDto guildExperimentBucketDto, int i, List list, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = guildExperimentBucketDto.bucket;
        }
        if ((i2 & 2) != 0) {
            list = guildExperimentBucketDto.positions;
        }
        return guildExperimentBucketDto.copy(i, list);
    }

    /* renamed from: component1, reason: from getter */
    public final int getBucket() {
        return this.bucket;
    }

    public final List<IntRange> component2() {
        return this.positions;
    }

    public final GuildExperimentBucketDto copy(int bucket, List<IntRange> positions) {
        m.checkNotNullParameter(positions, "positions");
        return new GuildExperimentBucketDto(bucket, positions);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof GuildExperimentBucketDto)) {
            return false;
        }
        GuildExperimentBucketDto guildExperimentBucketDto = (GuildExperimentBucketDto) other;
        return this.bucket == guildExperimentBucketDto.bucket && m.areEqual(this.positions, guildExperimentBucketDto.positions);
    }

    public final int getBucket() {
        return this.bucket;
    }

    public final List<IntRange> getPositions() {
        return this.positions;
    }

    public int hashCode() {
        int i = this.bucket * 31;
        List<IntRange> list = this.positions;
        return i + (list != null ? list.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = a.U("GuildExperimentBucketDto(bucket=");
        sbU.append(this.bucket);
        sbU.append(", positions=");
        return a.L(sbU, this.positions, ")");
    }
}
