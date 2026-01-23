package com.discord.models.domain;

import androidx.core.app.NotificationCompat;
import kotlin.jvm.internal.DefaultConstructorMarker;
import p007b.p100d.p104b.p105a.outline;
import p507d0.p592z.p594d.Intrinsics3;

/* JADX INFO: renamed from: com.discord.models.domain.StreamType, reason: use source file name */
/* JADX INFO: compiled from: ModelApplicationStream.kt */
/* JADX INFO: loaded from: classes.dex */
public enum ModelApplicationStream9 {
    GUILD("guild"),
    CALL(NotificationCompat.CATEGORY_CALL);

    private final String serializedRepresentation;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final ModelApplicationStream9[] VALUES = values();

    /* JADX INFO: renamed from: com.discord.models.domain.StreamType$Companion, reason: from kotlin metadata */
    /* JADX INFO: compiled from: ModelApplicationStream.kt */
    public static final class Companion {
        private Companion() {
        }

        public final ModelApplicationStream9 fromString(String string) {
            ModelApplicationStream9 modelApplicationStream9;
            Intrinsics3.checkNotNullParameter(string, "string");
            ModelApplicationStream9[] modelApplicationStream9ArrAccess$getVALUES$cp = ModelApplicationStream9.access$getVALUES$cp();
            int length = modelApplicationStream9ArrAccess$getVALUES$cp.length;
            int i = 0;
            while (true) {
                if (i >= length) {
                    modelApplicationStream9 = null;
                    break;
                }
                modelApplicationStream9 = modelApplicationStream9ArrAccess$getVALUES$cp[i];
                if (Intrinsics3.areEqual(modelApplicationStream9.getSerializedRepresentation(), string)) {
                    break;
                }
                i++;
            }
            if (modelApplicationStream9 != null) {
                return modelApplicationStream9;
            }
            throw new IllegalArgumentException(outline.m883w("unable to parse stream type: ", string));
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    ModelApplicationStream9(String str) {
        this.serializedRepresentation = str;
    }

    public static final /* synthetic */ ModelApplicationStream9[] access$getVALUES$cp() {
        return VALUES;
    }

    public final String getSerializedRepresentation() {
        return this.serializedRepresentation;
    }
}
