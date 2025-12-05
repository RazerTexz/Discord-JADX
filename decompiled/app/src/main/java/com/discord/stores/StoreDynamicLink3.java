package com.discord.stores;

import androidx.annotation.RecentlyNonNull;
import kotlin.jvm.functions.Function1;
import p007b.p225i.p226a.p288f.p340n.InterfaceC4359d;
import p507d0.p592z.p594d.Intrinsics3;

/* compiled from: StoreDynamicLink.kt */
/* renamed from: com.discord.stores.StoreDynamicLink$sam$com_google_android_gms_tasks_OnFailureListener$0, reason: use source file name */
/* loaded from: classes2.dex */
public final class StoreDynamicLink3 implements InterfaceC4359d {
    private final /* synthetic */ Function1 function;

    public StoreDynamicLink3(Function1 function1) {
        this.function = function1;
    }

    @Override // p007b.p225i.p226a.p288f.p340n.InterfaceC4359d
    public final /* synthetic */ void onFailure(@RecentlyNonNull Exception exc) {
        Intrinsics3.checkNotNullExpressionValue(this.function.invoke(exc), "invoke(...)");
    }
}
