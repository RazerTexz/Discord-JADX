package com.discord.media_picker;

import com.discord.models.domain.ModelAuditLogEntry;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: RequestType.kt */
/* loaded from: classes.dex */
public enum RequestType {
    CAMERA,
    GALLERY,
    DOCUMENTS,
    CROP,
    CHOOSER;


    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* compiled from: RequestType.kt */
    /* renamed from: com.discord.media_picker.RequestType$a, reason: from kotlin metadata */
    public static final class Companion {
        public Companion(DefaultConstructorMarker defaultConstructorMarker) {
        }
    }

    public final int getCode$media_picker_release() {
        int iOrdinal = ordinal();
        if (iOrdinal == 0) {
            return 777;
        }
        if (iOrdinal == 1) {
            return 778;
        }
        if (iOrdinal == 2) {
            return 779;
        }
        if (iOrdinal == 3) {
            return 800;
        }
        if (iOrdinal == 4) {
            return 801;
        }
        throw new NoWhenBranchMatchedException();
    }
}
