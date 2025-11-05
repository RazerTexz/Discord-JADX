package com.discord.models.domain;

import b.d.b.a.a;
import com.discord.models.domain.Model;
import d0.z.d.m;
import java.io.IOException;
import kotlin.jvm.internal.Ref$ObjectRef;

/* compiled from: ModelApplicationStream.kt */
/* loaded from: classes.dex */
public final /* data */ class StreamDelete {
    private final Reason reason;
    private final String streamKey;
    private final boolean unavailable;

    /* compiled from: ModelApplicationStream.kt */
    public static final class Parser implements Model.Parser<StreamDelete> {
        public static final Parser INSTANCE = new Parser();

        private Parser() {
        }

        @Override // com.discord.models.domain.Model.Parser
        public /* bridge */ /* synthetic */ StreamDelete parse(Model.JsonReader jsonReader) {
            return parse(jsonReader);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Removed duplicated region for block: B:21:0x005f  */
        @Override // com.discord.models.domain.Model.Parser
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public StreamDelete parse(Model.JsonReader reader) throws IOException {
            Reason reason;
            Ref$ObjectRef ref$ObjectRefC0 = a.c0(reader, "reader");
            ref$ObjectRefC0.element = null;
            Ref$ObjectRef ref$ObjectRef = new Ref$ObjectRef();
            ref$ObjectRef.element = null;
            Ref$ObjectRef ref$ObjectRef2 = new Ref$ObjectRef();
            ref$ObjectRef2.element = null;
            reader.nextObject(new StreamDelete$Parser$parse$1(ref$ObjectRefC0, reader, ref$ObjectRef, ref$ObjectRef2));
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
                m.throwUninitializedPropertyAccessException("streamKey");
            }
            String str2 = (String) t;
            Boolean bool = (Boolean) ref$ObjectRef2.element;
            return new StreamDelete(str2, reason, bool != null ? bool.booleanValue() : false);
        }
    }

    /* compiled from: ModelApplicationStream.kt */
    public enum Reason {
        USER_REQUESTED,
        STREAM_FULL,
        UNAUTHORIZED,
        UNKNOWN
    }

    public StreamDelete(String str, Reason reason, boolean z2) {
        m.checkNotNullParameter(str, "streamKey");
        m.checkNotNullParameter(reason, ModelAuditLogEntry.CHANGE_KEY_REASON);
        this.streamKey = str;
        this.reason = reason;
        this.unavailable = z2;
    }

    public static /* synthetic */ StreamDelete copy$default(StreamDelete streamDelete, String str, Reason reason, boolean z2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = streamDelete.streamKey;
        }
        if ((i & 2) != 0) {
            reason = streamDelete.reason;
        }
        if ((i & 4) != 0) {
            z2 = streamDelete.unavailable;
        }
        return streamDelete.copy(str, reason, z2);
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

    public final StreamDelete copy(String streamKey, Reason reason, boolean unavailable) {
        m.checkNotNullParameter(streamKey, "streamKey");
        m.checkNotNullParameter(reason, ModelAuditLogEntry.CHANGE_KEY_REASON);
        return new StreamDelete(streamKey, reason, unavailable);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof StreamDelete)) {
            return false;
        }
        StreamDelete streamDelete = (StreamDelete) other;
        return m.areEqual(this.streamKey, streamDelete.streamKey) && m.areEqual(this.reason, streamDelete.reason) && this.unavailable == streamDelete.unavailable;
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
        StringBuilder sbU = a.U("StreamDelete(streamKey=");
        sbU.append(this.streamKey);
        sbU.append(", reason=");
        sbU.append(this.reason);
        sbU.append(", unavailable=");
        return a.O(sbU, this.unavailable, ")");
    }
}
