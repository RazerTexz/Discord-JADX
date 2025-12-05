package androidx.view;

import androidx.annotation.MainThread;
import p507d0.p592z.p594d.Intrinsics3;

/* compiled from: ViewModelProvider.kt */
/* renamed from: androidx.lifecycle.ViewModelProviderKt, reason: use source file name */
/* loaded from: classes.dex */
public final class ViewModelProvider3 {
    @MainThread
    public static final /* synthetic */ <VM extends ViewModel> VM get(ViewModelProvider viewModelProvider) {
        Intrinsics3.checkNotNullParameter(viewModelProvider, "$this$get");
        Intrinsics3.reifiedOperationMarker(4, "VM");
        VM vm = (VM) viewModelProvider.get(ViewModel.class);
        Intrinsics3.checkNotNullExpressionValue(vm, "get(VM::class.java)");
        return vm;
    }
}
