package com.discord.models.domain;

import b.d.b.a.outline;
import com.discord.models.domain.Model;
import d0.z.d.Intrinsics3;
import java.io.IOException;
import kotlin.jvm.internal.Ref$ObjectRef;

/* compiled from: ModelApplicationStream.kt */
/* renamed from: com.discord.models.domain.StreamDelete, reason: use source file name */
/* loaded from: classes.dex */
public final /* data */ class ModelApplicationStream5 {
    private final Reason reason;
    private final String streamKey;
    private final boolean unavailable;

    /* compiled from: ModelApplicationStream.kt */
    /* renamed from: com.discord.models.domain.StreamDelete$Parser */
    public static final class Parser implements Model.Parser<ModelApplicationStream5> {
        public static final Parser INSTANCE = new Parser();

        private Parser() {
        }

        @Override // com.discord.models.domain.Model.Parser
        public /* bridge */ /* synthetic */ ModelApplicationStream5 parse(Model.JsonReader jsonReader) {
            return parse(jsonReader);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Removed duplicated region for block: B:21:0x005f  */
        @Override // com.discord.models.domain.Model.Parser
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public ModelApplicationStream5 parse(Model.JsonReader reader) throws IOException {
            Reason reason;
            Ref$ObjectRef ref$ObjectRefC0 = outline.c0(reader, "reader");
            ref$ObjectRefC0.element = null;
            Ref$ObjectRef ref$ObjectRef = new Ref$ObjectRef();
            ref$ObjectRef.element = null;
            Ref$ObjectRef ref$ObjectRef2 = new Ref$ObjectRef();
            ref$ObjectRef2.element = null;
            reader.nextObject(new ModelApplicationStream6(ref$ObjectRefC0, reader, ref$ObjectRef, ref$ObjectRef2));
            String str = (String) ref$ObjectRef.element;
            if (str != null) {
                int iHashCode = str.hashCode();
                if (iHashCode != -2033943558) {
                    if (iHashCode != 620910836) {
                        reason = (iHashCode == 1627077614 && str.equals("stream_full")) ? Reason.STREAM_FULL : Reason.UNKNOWN;
                    } else if (str.equals("unauthorized")) {
                        reason = Reason.UNAUTHORIZED;
                    }
                } else if (str.equals("user_requested")) {
                    reason = Reason.USER_REQUESTED;
                }
            }
            T t = ref$ObjectRefC0.element;
            if (t == 0) {
                Intrinsics3.throwUninitializedPropertyAccessException("streamKey");
            }
            String str2 = (String) t;
            Boolean bool = (Boolean) ref$ObjectRef2.element;
            return new ModelApplicationStream5(str2, reason, bool != null ? bool.booleanValue() : false);
        }
    }

    /* compiled from: ModelApplicationStream.kt */
    /* renamed from: com.discord.models.domain.StreamDelete$Reason */
    public enum Reason {
        USER_REQUESTED,
        STREAM_FULL,
        UNAUTHORIZED,
        UNKNOWN
    }

    public ModelApplicationStream5(String str, Reason reason, boolean z2) {
        Intrinsics3.checkNotNullParameter(str, "streamKey");
        Intrinsics3.checkNotNullParameter(reason, ModelAuditLogEntry.CHANGE_KEY_REASON);
        this.streamKey = str;
        this.reason = reason;
        this.unavailable = z2;
    }

    public static /* synthetic */ ModelApplicationStream5 copy$default(ModelApplicationStream5 modelApplicationStream5, String str, Reason reason, boolean z2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = modelApplicationStream5.streamKey;
        }
        if ((i & 2) != 0) {
            reason = modelApplicationStream5.reason;
        }
        if ((i & 4) != 0) {
            z2 = modelApplicationStream5.unavailable;
        }
        return modelApplicationStream5.copy(str, reason, z2);
    }

    /* renamed from: component1, reason: from getter */
    public final String getStreamKey() {
        return this.streamKey;
    }

    /* renamed from: component2, reason: from getter */
    public final Reason getReason() {
        return this.reason;
    }

    /* renamed from: component3, reason: from getter */
    public final boolean getUnavailable() {
        return this.unavailable;
    }

    public final ModelApplicationStream5 copy(String streamKey, Reason reason, boolean unavailable) {
        Intrinsics3.checkNotNullParameter(streamKey, "streamKey");
        Intrinsics3.checkNotNullParameter(reason, ModelAuditLogEntry.CHANGE_KEY_REASON);
        return new ModelApplicationStream5(streamKey, reason, unavailable);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ModelApplicationStream5)) {
            return false;
        }
        ModelApplicationStream5 modelApplicationStream5 = (ModelApplicationStream5) other;
        return Intrinsics3.areEqual(this.streamKey, modelApplicationStream5.streamKey) && Intrinsics3.areEqual(this.reason, modelApplicationStream5.reason) && this.unavailable == modelApplicationStream5.unavailable;
    }

    public final Reason getReason() {
        return this.reason;
    }

    public final String getStreamKey() {
        return this.streamKey;
    }

    public final boolean getUnavailable() {
        return this.unavailable;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        String str = this.streamKey;
        int iHashCode = (str != null ? str.hashCode() : 0) * 31;
        Reason reason = this.reason;
        int iHashCode2 = (iHashCode + (reason != null ? reason.hashCode() : 0)) * 31;
        boolean z2 = this.unavailable;
        int i = z2;
        if (z2 != 0) {
            i = 1;
        }
        return iHashCode2 + i;
    }

    public String toString() {
        StringBuilder sbU = outline.U("StreamDelete(streamKey=");
        sbU.append(this.streamKey);
        sbU.append(", reason=");
        sbU.append(this.reason);
        sbU.append(", unavailable=");
        return outline.O(sbU, this.unavailable, ")");
    }
}
