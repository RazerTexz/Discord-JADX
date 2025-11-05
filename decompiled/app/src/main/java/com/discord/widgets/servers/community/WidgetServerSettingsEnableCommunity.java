package com.discord.widgets.servers.community;

import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentViewModelLazyKt;
import b.a.d.AppViewModelDelegates2;
import b.d.b.a.outline;
import com.discord.R;
import com.discord.app.AppFragment;
import com.discord.app.AppLogger2;
import com.discord.databinding.WidgetServerSettingsEnableCommunityBinding;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate3;
import d0.z.d.Reflection2;
import kotlin.Lazy;
import kotlin.reflect.KProperty;

/* compiled from: WidgetServerSettingsEnableCommunity.kt */
/* loaded from: classes2.dex */
public final class WidgetServerSettingsEnableCommunity extends AppFragment {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {outline.d0(WidgetServerSettingsEnableCommunity.class, "binding", "getBinding()Lcom/discord/databinding/WidgetServerSettingsEnableCommunityBinding;", 0)};

    /* renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;
    private final AppLogger2 loggingConfig;

    /* renamed from: viewModel$delegate, reason: from kotlin metadata */
    private final Lazy viewModel;

    /* compiled from: WidgetServerSettingsEnableCommunity.kt */
    /* renamed from: com.discord.widgets.servers.community.WidgetServerSettingsEnableCommunity$onViewBoundOrOnResume$1, reason: invalid class name */
    public static final class AnonymousClass1 implements View.OnClickListener {
        public AnonymousClass1() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetServerSettingsEnableCommunity.access$getViewModel$p(WidgetServerSettingsEnableCommunity.this).updateCurrentPage(1);
        }
    }

    public WidgetServerSettingsEnableCommunity() {
        super(R.layout.widget_server_settings_enable_community);
        this.binding = FragmentViewBindingDelegate3.viewBinding$default(this, WidgetServerSettingsEnableCommunity2.INSTANCE, null, 2, null);
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection2.getOrCreateKotlinClass(WidgetServerSettingsEnableCommunityViewModel.class), new WidgetServerSettingsEnableCommunity$appActivityViewModels$$inlined$activityViewModels$1(this), new AppViewModelDelegates2(WidgetServerSettingsEnableCommunity4.INSTANCE));
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

    @Override // com.discord.app.AppFragment, com.discord.app.AppLogger.a
    public AppLogger2 getLoggingConfig() {
        return this.loggingConfig;
    }

    @Override // com.discord.app.AppFragment
    public void onViewBoundOrOnResume() {
        super.onViewBoundOrOnResume();
        getBinding().f2568b.setOnClickListener(new AnonymousClass1());
    }
}
