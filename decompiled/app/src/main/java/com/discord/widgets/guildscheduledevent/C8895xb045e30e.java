package com.discord.widgets.guildscheduledevent;

import androidx.view.ViewModelStore;
import androidx.view.ViewModelStoreOwner;
import kotlin.jvm.functions.Function0;
import p507d0.p592z.p594d.Intrinsics3;
import p507d0.p592z.p594d.Lambda;

/* JADX INFO: renamed from: com.discord.widgets.guildscheduledevent.WidgetGuildScheduledEventLocationSelect$appViewModels$$inlined$viewModels$1 */
/* JADX INFO: compiled from: FragmentViewModelLazy.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class C8895xb045e30e extends Lambda implements Function0<ViewModelStore> {
    public final /* synthetic */ Function0 $ownerProducer;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C8895xb045e30e(Function0 function0) {
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
