package com.discord.utilities.stateful;

import androidx.core.app.NotificationCompat;
import d0.z.d.Intrinsics3;
import rx.functions.Action1;

/* compiled from: StatefulViews.kt */
/* renamed from: com.discord.utilities.stateful.StatefulViews$setupTextWatcherWithSaveAction$$inlined$forEach$lambda$3, reason: use source file name */
/* loaded from: classes2.dex */
public final class StatefulViews6<T> implements Action1<Boolean> {
    public final /* synthetic */ StatefulViews5 $onAfterCheckedChanged$1;

    public StatefulViews6(StatefulViews5 statefulViews5) {
        this.$onAfterCheckedChanged$1 = statefulViews5;
    }

    @Override // rx.functions.Action1
    public /* bridge */ /* synthetic */ void call(Boolean bool) {
        call2(bool);
    }

    /* renamed from: call, reason: avoid collision after fix types in other method */
    public final void call2(Boolean bool) {
        StatefulViews5 statefulViews5 = this.$onAfterCheckedChanged$1;
        Intrinsics3.checkNotNullExpressionValue(bool, "it");
        statefulViews5.invoke(bool.booleanValue());
    }
}
