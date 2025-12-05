package com.discord.widgets.channels.memberlist;

import java.util.Comparator;
import kotlin.jvm.functions.Function2;
import p507d0.p592z.p594d.Intrinsics3;

/* compiled from: PrivateChannelMemberListItemGenerator.kt */
/* renamed from: com.discord.widgets.channels.memberlist.PrivateChannelMemberListItemGeneratorKt$sam$java_util_Comparator$0, reason: use source file name */
/* loaded from: classes2.dex */
public final class PrivateChannelMemberListItemGenerator3 implements Comparator {
    private final /* synthetic */ Function2 function;

    public PrivateChannelMemberListItemGenerator3(Function2 function2) {
        this.function = function2;
    }

    @Override // java.util.Comparator
    public final /* synthetic */ int compare(Object obj, Object obj2) {
        Object objInvoke = this.function.invoke(obj, obj2);
        Intrinsics3.checkNotNullExpressionValue(objInvoke, "invoke(...)");
        return ((Number) objInvoke).intValue();
    }
}
