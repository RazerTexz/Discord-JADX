package com.discord.models.experiments.dto;

import com.discord.models.domain.Model;
import java.io.IOException;
import java.util.List;
import kotlin.jvm.internal.Ref$IntRef;
import kotlin.jvm.internal.Ref$ObjectRef;
import kotlin.ranges.Ranges2;
import p007b.p100d.p104b.p105a.outline;
import p507d0.p580t.Collections2;
import p507d0.p592z.p594d.Intrinsics3;

/* compiled from: GuildExperimentDto.kt */
/* loaded from: classes.dex */
public final /* data */ class GuildExperimentBucketDto {
    private final int bucket;
    private final List<Ranges2> positions;

    /* compiled from: GuildExperimentDto.kt */
    public static final class Parser {
        public static final Parser INSTANCE = new Parser();

        private Parser() {
        }

        public static final /* synthetic */ Ranges2 access$parsePosition(Parser parser, Model.JsonReader jsonReader) {
            return parser.parsePosition(jsonReader);
        }

        private final Ranges2 parsePosition(Model.JsonReader jsonReader) throws IOException {
            Ref$IntRef ref$IntRef = new Ref$IntRef();
            ref$IntRef.element = -1;
            Ref$IntRef ref$IntRef2 = new Ref$IntRef();
            ref$IntRef2.element = -1;
            jsonReader.nextObject(new GuildExperimentBucketDto$Parser$parsePosition$1(ref$IntRef, jsonReader, ref$IntRef2));
            return new Ranges2(ref$IntRef.element, ref$IntRef2.element);
        }

        /* JADX WARN: Type inference failed for: r2v0, types: [T, java.util.List] */
        public final GuildExperimentBucketDto parse(Model.JsonReader reader) throws IOException {
            Intrinsics3.checkNotNullParameter(reader, "reader");
            Ref$IntRef ref$IntRef = new Ref$IntRef();
            ref$IntRef.element = -1;
            Ref$ObjectRef ref$ObjectRef = new Ref$ObjectRef();
            ref$ObjectRef.element = Collections2.emptyList();
            reader.nextListIndexed(new GuildExperimentBucketDto$Parser$parse$1(ref$IntRef, reader), new GuildExperimentBucketDto$Parser$parse$2(ref$ObjectRef, reader));
            return new GuildExperimentBucketDto(ref$IntRef.element, (List) ref$ObjectRef.element);
        }
    }

    public GuildExperimentBucketDto(int i, List<Ranges2> list) {
        Intrinsics3.checkNotNullParameter(list, "positions");
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

    public final List<Ranges2> component2() {
        return this.positions;
    }

    public final GuildExperimentBucketDto copy(int bucket, List<Ranges2> positions) {
        Intrinsics3.checkNotNullParameter(positions, "positions");
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
        return this.bucket == guildExperimentBucketDto.bucket && Intrinsics3.areEqual(this.positions, guildExperimentBucketDto.positions);
    }

    public final int getBucket() {
        return this.bucket;
    }

    public final List<Ranges2> getPositions() {
        return this.positions;
    }

    public int hashCode() {
        int i = this.bucket * 31;
        List<Ranges2> list = this.positions;
        return i + (list != null ? list.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbM833U = outline.m833U("GuildExperimentBucketDto(bucket=");
        sbM833U.append(this.bucket);
        sbM833U.append(", positions=");
        return outline.m824L(sbM833U, this.positions, ")");
    }
}
