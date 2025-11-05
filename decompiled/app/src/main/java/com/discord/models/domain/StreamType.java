package com.discord.models.domain;

import androidx.core.app.NotificationCompat;
import b.d.b.a.a;
import d0.z.d.m;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: ModelApplicationStream.kt */
/* loaded from: classes.dex */
public enum StreamType {
    GUILD("guild"),
    CALL(NotificationCompat.CATEGORY_CALL);

    private final String serializedRepresentation;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final StreamType[] VALUES = values();

    /* compiled from: ModelApplicationStream.kt */
    public static final class Companion {
        private Companion() {
        }

        public final StreamType fromString(String string) {
            StreamType streamType;
            m.checkNotNullParameter(string, "string");
            StreamType[] streamTypeArrAccess$getVALUES$cp = StreamType.access$getVALUES$cp();
            int length = streamTypeArrAccess$getVALUES$cp.length;
            int i = 0;
            while (true) {
                if (i >= length) {
                    streamType = null;
                    break;
                }
                streamType = streamTypeArrAccess$getVALUES$cp[i];
                if (m.areEqual(streamType.getSerializedRepresentation(), string)) {
                    break;
                }
                i++;
            }
            if (streamType != null) {
                return streamType;
            }
            throw new IllegalArgumentException(a.w("unable to parse stream type: ", string));
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    StreamType(String str) {
        this.serializedRepresentation = str;
    }

    public static final /* synthetic */ StreamType[] access$getVALUES$cp() {
        return VALUES;
    }

    public final String getSerializedRepresentation() {
        return this.serializedRepresentation;
    }
}
