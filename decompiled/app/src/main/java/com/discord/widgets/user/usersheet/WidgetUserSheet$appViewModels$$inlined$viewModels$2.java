package com.discord.widgets.user.usersheet;

import androidx.view.ViewModelStore;
import androidx.view.ViewModelStoreOwner;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import kotlin.jvm.functions.Function0;

/* compiled from: FragmentViewModelLazy.kt */
/* loaded from: classes.dex */
public final class WidgetUserSheet$appViewModels$$inlined$viewModels$2 extends Lambda implements Function0<ViewModelStore> {
    public final /* synthetic */ Function0 $ownerProducer;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetUserSheet$appViewModels$$inlined$viewModels$2(Function0 function0) {
        super(0);
        this.$ownerProducer = function0;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final ViewModelStore invoke() {
        ViewModelStore viewModelStore = ((ViewModelStoreOwner) this.$ownerProducer.invoke()).getViewModelStore();
        Intrinsics3.checkNotNullExpressionValue(viewModelStore, "ownerProducer().viewModelStore");
        return viewModelStore;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ ViewModelStore invoke() {
        return invoke();
    }
}
