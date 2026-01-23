package com.discord.widgets.channels.permissions;

import java.util.Comparator;
import kotlin.jvm.functions.Function2;
import p507d0.p592z.p594d.Intrinsics3;

/* JADX INFO: renamed from: com.discord.widgets.channels.permissions.WidgetChannelSettingsPermissionsAdvanced$sam$java_util_Comparator$0, reason: use source file name */
/* JADX INFO: compiled from: WidgetChannelSettingsPermissionsAdvanced.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChannelSettingsPermissionsAdvanced4 implements Comparator {
    private final /* synthetic */ Function2 function;

    public WidgetChannelSettingsPermissionsAdvanced4(Function2 function2) {
        this.function = function2;
    }

    @Override // java.util.Comparator
    public final /* synthetic */ int compare(Object obj, Object obj2) {
        Object objInvoke = this.function.invoke(obj, obj2);
        Intrinsics3.checkNotNullExpressionValue(objInvoke, "invoke(...)");
        return ((Number) objInvoke).intValue();
    }
}
