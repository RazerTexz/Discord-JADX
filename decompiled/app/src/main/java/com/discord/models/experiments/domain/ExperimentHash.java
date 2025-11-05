package com.discord.models.experiments.domain;

import com.discord.api.permission.Permission;
import com.discord.models.domain.ModelAuditLogEntry;
import d0.z.d.Intrinsics3;
import j0.l.e.UtilityFunctions;

/* compiled from: ExperimentHash.kt */
/* loaded from: classes.dex */
public final class ExperimentHash {
    public static final ExperimentHash INSTANCE = new ExperimentHash();

    private ExperimentHash() {
    }

    public final long from(CharSequence name) {
        Intrinsics3.checkNotNullParameter(name, ModelAuditLogEntry.CHANGE_KEY_NAME);
        int iA = UtilityFunctions.a(name, 0, name.length(), 0);
        return iA < 0 ? iA + Permission.REQUEST_TO_SPEAK : iA;
    }
}
