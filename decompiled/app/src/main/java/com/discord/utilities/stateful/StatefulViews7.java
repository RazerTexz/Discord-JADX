package com.discord.utilities.stateful;

import d0.z.d.Lambda;
import kotlin.jvm.functions.Function0;

/* compiled from: StatefulViews.kt */
/* renamed from: com.discord.utilities.stateful.StatefulViews$setupUnsavedChangesConfirmation$$inlined$let$lambda$1, reason: use source file name */
/* loaded from: classes2.dex */
public final class StatefulViews7 extends Lambda implements Function0<Boolean> {
    public final /* synthetic */ StatefulViews this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StatefulViews7(StatefulViews statefulViews) {
        super(0);
        this.this$0 = statefulViews;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Boolean invoke() {
        return Boolean.valueOf(invoke2());
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final boolean invoke2() {
        return StatefulViews.access$hasAnythingChanged(this.this$0);
    }
}
