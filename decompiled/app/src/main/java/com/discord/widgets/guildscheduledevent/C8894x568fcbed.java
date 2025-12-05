package com.discord.widgets.guildscheduledevent;

import androidx.fragment.app.Fragment;
import androidx.view.ViewModelProvider;
import kotlin.jvm.functions.Function0;
import p007b.p100d.p104b.p105a.outline;
import p507d0.p592z.p594d.Lambda;

/* compiled from: FragmentViewModelLazy.kt */
/* renamed from: com.discord.widgets.guildscheduledevent.WidgetGuildScheduledEventLocationSelect$appActivityViewModels$$inlined$activityViewModels$2 */
/* loaded from: classes2.dex */
public final class C8894x568fcbed extends Lambda implements Function0<ViewModelProvider.Factory> {
    public final /* synthetic */ Fragment $this_activityViewModels;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C8894x568fcbed(Fragment fragment) {
        super(0);
        this.$this_activityViewModels = fragment;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final ViewModelProvider.Factory invoke() {
        return outline.m848e0(this.$this_activityViewModels, "requireActivity()");
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ ViewModelProvider.Factory invoke() {
        return invoke();
    }
}
