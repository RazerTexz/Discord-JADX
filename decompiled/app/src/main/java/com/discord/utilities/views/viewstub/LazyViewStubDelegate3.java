package com.discord.utilities.views.viewstub;

import android.view.View;
import android.view.ViewStub;
import kotlin.jvm.functions.Function0;
import p507d0.p592z.p594d.Lambda;

/* compiled from: LazyViewStubDelegate.kt */
/* renamed from: com.discord.utilities.views.viewstub.LazyViewStubDelegate$viewField$1, reason: use source file name */
/* loaded from: classes2.dex */
public final class LazyViewStubDelegate3 extends Lambda implements Function0<View> {
    public final /* synthetic */ ViewStub $stub;
    public final /* synthetic */ LazyViewStubDelegate this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LazyViewStubDelegate3(LazyViewStubDelegate lazyViewStubDelegate, ViewStub viewStub) {
        super(0);
        this.this$0 = lazyViewStubDelegate;
        this.$stub = viewStub;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ View invoke() {
        return invoke();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final View invoke() {
        View viewInflate = this.$stub.inflate();
        viewInflate.setOnClickListener(LazyViewStubDelegate.access$getListener$p(this.this$0));
        return viewInflate;
    }
}
