package androidx.activity;

import kotlin.jvm.functions.Function1;

/* compiled from: OnBackPressedDispatcher.kt */
/* renamed from: androidx.activity.OnBackPressedDispatcherKt$addCallback$callback$1, reason: use source file name */
/* loaded from: classes.dex */
public final class OnBackPressedDispatcher3 extends OnBackPressedCallback {
    public final /* synthetic */ boolean $enabled;
    public final /* synthetic */ Function1 $onBackPressed;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public OnBackPressedDispatcher3(Function1 function1, boolean z2, boolean z3) {
        super(z3);
        this.$onBackPressed = function1;
        this.$enabled = z2;
    }

    @Override // androidx.activity.OnBackPressedCallback
    public void handleOnBackPressed() {
        this.$onBackPressed.invoke(this);
    }
}
