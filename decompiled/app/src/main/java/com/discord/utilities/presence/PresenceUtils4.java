package com.discord.utilities.presence;

import com.discord.api.activity.Activity;
import kotlin.jvm.functions.Function1;
import p507d0.p592z.p594d.Intrinsics3;
import p507d0.p592z.p594d.Lambda;

/* JADX INFO: renamed from: com.discord.utilities.presence.PresenceUtils$ACTIVITY_COMPARATOR$3, reason: use source file name */
/* JADX INFO: compiled from: PresenceUtils.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class PresenceUtils4 extends Lambda implements Function1<Activity, Comparable<?>> {
    public static final PresenceUtils4 INSTANCE = new PresenceUtils4();

    public PresenceUtils4() {
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Comparable<?> invoke(Activity activity) {
        return invoke2(activity);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Comparable<?> invoke2(Activity activity) {
        Intrinsics3.checkNotNullParameter(activity, "it");
        return Long.valueOf(activity.getCreatedAt());
    }
}
