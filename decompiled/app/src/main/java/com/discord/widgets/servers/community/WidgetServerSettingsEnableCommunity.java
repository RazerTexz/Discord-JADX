package com.discord.widgets.servers.community;

import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentViewModelLazyKt;
import com.discord.C5419R;
import com.discord.app.AppFragment;
import com.discord.app.AppLogger2;
import com.discord.databinding.WidgetServerSettingsEnableCommunityBinding;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate3;
import kotlin.Lazy;
import kotlin.reflect.KProperty;
import p007b.p008a.p018d.AppViewModelDelegates2;
import p007b.p100d.p104b.p105a.outline;
import p507d0.p592z.p594d.Reflection2;

/* compiled from: WidgetServerSettingsEnableCommunity.kt */
/* loaded from: classes2.dex */
public final class WidgetServerSettingsEnableCommunity extends AppFragment {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {outline.m846d0(WidgetServerSettingsEnableCommunity.class, "binding", "getBinding()Lcom/discord/databinding/WidgetServerSettingsEnableCommunityBinding;", 0)};

    /* renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;
    private final AppLogger2 loggingConfig;

    /* renamed from: viewModel$delegate, reason: from kotlin metadata */
    private final Lazy viewModel;

    /* compiled from: WidgetServerSettingsEnableCommunity.kt */
    /* renamed from: com.discord.widgets.servers.community.WidgetServerSettingsEnableCommunity$onViewBoundOrOnResume$1 */
    public static final class ViewOnClickListenerC93941 implements View.OnClickListener {
        public ViewOnClickListenerC93941() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetServerSettingsEnableCommunity.access$getViewModel$p(WidgetServerSettingsEnableCommunity.this).updateCurrentPage(1);
        }
    }

    public WidgetServerSettingsEnableCommunity() {
        super(C5419R.layout.widget_server_settings_enable_community);
        this.binding = FragmentViewBindingDelegate3.viewBinding$default(this, WidgetServerSettingsEnableCommunity2.INSTANCE, null, 2, null);
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection2.getOrCreateKotlinClass(WidgetServerSettingsEnableCommunityViewModel.class), new C9392x6fecf2bb(this), new AppViewModelDelegates2(WidgetServerSettingsEnableCommunity4.INSTANCE));
        this.loggingConfig = new AppLogger2(false, null, WidgetServerSettingsEnableCommunity3.INSTANCE, 3);
    }

    public static final /* synthetic */ WidgetServerSettingsEnableCommunityViewModel access$getViewModel$p(WidgetServerSettingsEnableCommunity widgetServerSettingsEnableCommunity) {
        return widgetServerSettingsEnableCommunity.getViewModel();
    }

    private final WidgetServerSettingsEnableCommunityBinding getBinding() {
        return (WidgetServerSettingsEnableCommunityBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    private final WidgetServerSettingsEnableCommunityViewModel getViewModel() {
        return (WidgetServerSettingsEnableCommunityViewModel) this.viewModel.getValue();
    }

    @Override // com.discord.app.AppFragment, com.discord.app.AppLogger.InterfaceC5455a
    public AppLogger2 getLoggingConfig() {
        return this.loggingConfig;
    }

    @Override // com.discord.app.AppFragment
    public void onViewBoundOrOnResume() {
        super.onViewBoundOrOnResume();
        getBinding().f17659b.setOnClickListener(new ViewOnClickListenerC93941());
    }
}
