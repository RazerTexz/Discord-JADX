package com.discord.models.experiments.dto;

import androidx.exifinterface.media.ExifInterface;
import b.d.b.a.outline;
import b.i.d.TypeAdapterFactory2;
import com.discord.models.domain.Model;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import d0.z.d.Intrinsics3;
import java.io.IOException;
import kotlin.jvm.internal.Ref$ObjectRef;

/* compiled from: UserExperimentDto.kt */
/* loaded from: classes.dex */
public final /* data */ class UserExperimentDto {
    private final int bucket;
    private final long nameHash;
    private final int population;
    private final int revision;

    /* compiled from: UserExperimentDto.kt */
    public static final class Parser {
        public static final Parser INSTANCE = new Parser();

        private Parser() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static final UserExperimentDto parse(Model.JsonReader reader) throws IOException {
            Ref$ObjectRef ref$ObjectRefC0 = outline.c0(reader, "reader");
            ref$ObjectRefC0.element = null;
            Ref$ObjectRef ref$ObjectRef = new Ref$ObjectRef();
            ref$ObjectRef.element = null;
            Ref$ObjectRef ref$ObjectRef2 = new Ref$ObjectRef();
            ref$ObjectRef2.element = null;
            Ref$ObjectRef ref$ObjectRef3 = new Ref$ObjectRef();
            ref$ObjectRef3.element = null;
            reader.nextListIndexed(new UserExperimentDto2(ref$ObjectRefC0, reader), new UserExperimentDto3(ref$ObjectRef, reader), new UserExperimentDto4(ref$ObjectRef2, reader), new UserExperimentDto5(ref$ObjectRef3, reader));
            Long l = (Long) ref$ObjectRefC0.element;
            Intrinsics3.checkNotNull(l);
            long jLongValue = l.longValue();
            Integer num = (Integer) ref$ObjectRef.element;
            Intrinsics3.checkNotNull(num);
            int iIntValue = num.intValue();
            Integer num2 = (Integer) ref$ObjectRef2.element;
            Intrinsics3.checkNotNull(num2);
            int iIntValue2 = num2.intValue();
            Integer num3 = (Integer) ref$ObjectRef3.element;
            Intrinsics3.checkNotNull(num3);
            return new UserExperimentDto(jLongValue, iIntValue, iIntValue2, num3.intValue());
        }
    }

    /* compiled from: UserExperimentDto.kt */
    public static final class TypeAdapterFactory implements TypeAdapterFactory2 {
        public static final TypeAdapterFactory INSTANCE = new TypeAdapterFactory();

        /* compiled from: UserExperimentDto.kt */
        public static final class TypeAdapter extends com.google.gson.TypeAdapter<UserExperimentDto> {
            @Override // com.google.gson.TypeAdapter
            public /* bridge */ /* synthetic */ UserExperimentDto read(JsonReader jsonReader) {
                return read(jsonReader);
            }

            @Override // com.google.gson.TypeAdapter
            public /* bridge */ /* synthetic */ void write(JsonWriter jsonWriter, UserExperimentDto userExperimentDto) {
                write2(jsonWriter, userExperimentDto);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.google.gson.TypeAdapter
            public UserExperimentDto read(JsonReader in) {
                return Parser.parse(new Model.JsonReader(in));
            }

            /* renamed from: write, reason: avoid collision after fix types in other method */
            public void write2(JsonWriter out, UserExperimentDto value) {
                throw new UnsupportedOperationException();
            }
        }

        private TypeAdapterFactory() {
        }

        @Override // b.i.d.TypeAdapterFactory2
        public <T> com.google.gson.TypeAdapter<T> create(Gson gson, TypeToken<T> type) {
            if (gson == null || type == null || !UserExperimentDto.class.isAssignableFrom(type.getRawType())) {
                return null;
            }
            return new TypeAdapter();
        }
    }

    public UserExperimentDto(long j, int i, int i2, int i3) {
        this.nameHash = j;
        this.revision = i;
        this.bucket = i2;
        this.population = i3;
    }

    public static /* synthetic */ UserExperimentDto copy$default(UserExperimentDto userExperimentDto, long j, int i, int i2, int i3, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            j = userExperimentDto.nameHash;
        }
        long j2 = j;
        if ((i4 & 2) != 0) {
            i = userExperimentDto.revision;
        }
        int i5 = i;
        if ((i4 & 4) != 0) {
            i2 = userExperimentDto.bucket;
        }
        int i6 = i2;
        if ((i4 & 8) != 0) {
            i3 = userExperimentDto.population;
        }
        return userExperimentDto.copy(j2, i5, i6, i3);
    }

    /* renamed from: component1, reason: from getter */
    public final long getNameHash() {
        return this.nameHash;
    }

    /* renamed from: component2, reason: from getter */
    public final int getRevision() {
        return this.revision;
    }

    /* renamed from: component3, reason: from getter */
    public final int getBucket() {
        return this.bucket;
    }

    /* renamed from: component4, reason: from getter */
    public final int getPopulation() {
        return this.population;
    }

    public final UserExperimentDto copy(long nameHash, int revision, int bucket, int population) {
        return new UserExperimentDto(nameHash, revision, bucket, population);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof UserExperimentDto)) {
            return false;
        }
        UserExperimentDto userExperimentDto = (UserExperimentDto) other;
        return this.nameHash == userExperimentDto.nameHash && this.revision == userExperimentDto.revision && this.bucket == userExperimentDto.bucket && this.population == userExperimentDto.population;
    }

    public final int getBucket() {
        return this.bucket;
    }

    public final long getNameHash() {
        return this.nameHash;
    }

    public final int getPopulation() {
        return this.population;
    }

    public final int getRevision() {
        return this.revision;
    }

    public int hashCode() {
        long j = this.nameHash;
        return (((((((int) (j ^ (j >>> 32))) * 31) + this.revision) * 31) + this.bucket) * 31) + this.population;
    }

    public String toString() {
        StringBuilder sbU = outline.U("UserExperimentDto(nameHash=");
        sbU.append(this.nameHash);
        sbU.append(", revision=");
        sbU.append(this.revision);
        sbU.append(", bucket=");
        sbU.append(this.bucket);
        sbU.append(", population=");
        return outline.B(sbU, this.population, ")");
    }
}
