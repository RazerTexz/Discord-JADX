package com.discord.widgets.servers.community;

import androidx.fragment.app.Fragment;
import androidx.view.ViewModelProvider;
import b.d.b.a.outline;
import d0.z.d.Lambda;
import kotlin.jvm.functions.Function0;

/* compiled from: FragmentViewModelLazy.kt */
/* loaded from: classes2.dex */
public final class WidgetConfirmRemoveCommunityDialog$appActivityViewModels$$inlined$activityViewModels$2 extends Lambda implements Function0<ViewModelProvider.Factory> {
    public final /* synthetic */ Fragment $this_activityViewModels;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetConfirmRemoveCommunityDialog$appActivityViewModels$$inlined$activityViewModels$2(Fragment fragment) {
        super(0);
        this.$this_activityViewModels = fragment;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final ViewModelProvider.Factory invoke() {
        return outline.e0(this.$this_activityViewModels, "requireActivity()");
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ ViewModelProvider.Factory invoke() {
        return invoke();
    }
}
