package com.discord.widgets.guildscheduledevent;

import android.os.Bundle;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;

/* compiled from: WidgetEndGuildScheduledEventBottomSheet.kt */
/* renamed from: com.discord.widgets.guildscheduledevent.WidgetEndGuildScheduledEventBottomSheet$Companion$registerForResult$1, reason: use source file name */
/* loaded from: classes2.dex */
public final class WidgetEndGuildScheduledEventBottomSheet2 extends Lambda implements Function2<String, Bundle, Unit> {
    public final /* synthetic */ Function0 $onActionTaken;
    public final /* synthetic */ String $requestKey;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetEndGuildScheduledEventBottomSheet2(String str, Function0 function0) {
        super(2);
        this.$requestKey = str;
        this.$onActionTaken = function0;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Unit invoke(String str, Bundle bundle) {
        invoke2(str, bundle);
        return Unit.a;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(String str, Bundle bundle) {
        Intrinsics3.checkNotNullParameter(str, "resultRequestKey");
        Intrinsics3.checkNotNullParameter(bundle, "<anonymous parameter 1>");
        if (Intrinsics3.areEqual(this.$requestKey, str)) {
            this.$onActionTaken.invoke();
        }
    }
}
