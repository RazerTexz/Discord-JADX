package com.discord.utilities.presence;

import com.discord.api.activity.Activity;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import kotlin.jvm.functions.Function1;

/* compiled from: PresenceUtils.kt */
/* renamed from: com.discord.utilities.presence.PresenceUtils$ACTIVITY_COMPARATOR$3, reason: use source file name */
/* loaded from: classes2.dex */
public final class PresenceUtils4 extends Lambda implements Function1<Activity, Comparable<?>> {
    public static final PresenceUtils4 INSTANCE = new PresenceUtils4();

    public PresenceUtils4() {
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Comparable<?> invoke(Activity activity) {
        return invoke2(activity);
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Comparable<?> invoke2(Activity activity) {
        Intrinsics3.checkNotNullParameter(activity, "it");
        return Long.valueOf(activity.getCreatedAt());
    }
}
