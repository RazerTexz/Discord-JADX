package com.discord.models.domain;

import com.discord.models.domain.Model;
import java.io.IOException;
import kotlin.jvm.internal.Ref$ObjectRef;
import p007b.p100d.p104b.p105a.outline;
import p507d0.p592z.p594d.Intrinsics3;

/* compiled from: ModelApplicationStream.kt */
/* renamed from: com.discord.models.domain.StreamServerUpdate, reason: use source file name */
/* loaded from: classes.dex */
public final /* data */ class ModelApplicationStream7 {
    private final String endpoint;
    private final String streamKey;
    private final String token;

    /* compiled from: ModelApplicationStream.kt */
    /* renamed from: com.discord.models.domain.StreamServerUpdate$Parser */
    public static final class Parser implements Model.Parser<ModelApplicationStream7> {
        public static final Parser INSTANCE = new Parser();

        private Parser() {
        }

        @Override // com.discord.models.domain.Model.Parser
        public /* bridge */ /* synthetic */ ModelApplicationStream7 parse(Model.JsonReader jsonReader) {
            return parse(jsonReader);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.discord.models.domain.Model.Parser
        public ModelApplicationStream7 parse(Model.JsonReader reader) throws IOException {
            Ref$ObjectRef ref$ObjectRefM844c0 = outline.m844c0(reader, "reader");
            ref$ObjectRefM844c0.element = null;
            Ref$ObjectRef ref$ObjectRef = new Ref$ObjectRef();
            ref$ObjectRef.element = null;
            Ref$ObjectRef ref$ObjectRef2 = new Ref$ObjectRef();
            ref$ObjectRef2.element = null;
            reader.nextObject(new ModelApplicationStream8(ref$ObjectRefM844c0, reader, ref$ObjectRef, ref$ObjectRef2));
            T t = ref$ObjectRefM844c0.element;
            if (t == 0) {
                Intrinsics3.throwUninitializedPropertyAccessException("streamKey");
            }
            return new ModelApplicationStream7((String) t, (String) ref$ObjectRef.element, (String) ref$ObjectRef2.element);
        }
    }

    public ModelApplicationStream7(String str, String str2, String str3) {
        Intrinsics3.checkNotNullParameter(str, "streamKey");
        this.streamKey = str;
        this.endpoint = str2;
        this.token = str3;
    }

    public static /* synthetic */ ModelApplicationStream7 copy$default(ModelApplicationStream7 modelApplicationStream7, String str, String str2, String str3, int i, Object obj) {
        if ((i & 1) != 0) {
            str = modelApplicationStream7.streamKey;
        }
        if ((i & 2) != 0) {
            str2 = modelApplicationStream7.endpoint;
        }
        if ((i & 4) != 0) {
            str3 = modelApplicationStream7.token;
        }
        return modelApplicationStream7.copy(str, str2, str3);
    }

    /* renamed from: component1, reason: from getter */
    public final String getStreamKey() {
        return this.streamKey;
    }

    /* renamed from: component2, reason: from getter */
    public final String getEndpoint() {
        return this.endpoint;
    }

    /* renamed from: component3, reason: from getter */
    public final String getToken() {
        return this.token;
    }

    public final ModelApplicationStream7 copy(String streamKey, String endpoint, String token) {
        Intrinsics3.checkNotNullParameter(streamKey, "streamKey");
        return new ModelApplicationStream7(streamKey, endpoint, token);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ModelApplicationStream7)) {
            return false;
        }
        ModelApplicationStream7 modelApplicationStream7 = (ModelApplicationStream7) other;
        return Intrinsics3.areEqual(this.streamKey, modelApplicationStream7.streamKey) && Intrinsics3.areEqual(this.endpoint, modelApplicationStream7.endpoint) && Intrinsics3.areEqual(this.token, modelApplicationStream7.token);
    }

    public final String getEndpoint() {
        return this.endpoint;
    }

    public final String getStreamKey() {
        return this.streamKey;
    }

    public final String getToken() {
        return this.token;
    }

    public int hashCode() {
        String str = this.streamKey;
        int iHashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.endpoint;
        int iHashCode2 = (iHashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.token;
        return iHashCode2 + (str3 != null ? str3.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbM833U = outline.m833U("StreamServerUpdate(streamKey=");
        sbM833U.append(this.streamKey);
        sbM833U.append(", endpoint=");
        sbM833U.append(this.endpoint);
        sbM833U.append(", token=");
        return outline.m822J(sbM833U, this.token, ")");
    }
}
