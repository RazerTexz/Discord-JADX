package com.discord.widgets.channels.threads.browser;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentViewModelLazyKt;
import b.a.d.AppViewModelDelegates2;
import b.d.b.a.outline;
import com.discord.R;
import com.discord.app.AppBottomSheet;
import com.discord.databinding.WidgetThreadBrowserFilterSheetBinding;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate3;
import com.discord.views.CheckedSetting;
import com.discord.widgets.channels.threads.browser.WidgetThreadBrowserArchivedViewModel;
import d0.LazyJVM;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import d0.z.d.Reflection2;
import kotlin.Lazy;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;
import rx.subscriptions.CompositeSubscription;

/* compiled from: WidgetThreadBrowserFilterSheet.kt */
/* loaded from: classes2.dex */
public final class WidgetThreadBrowserFilterSheet extends AppBottomSheet {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {outline.d0(WidgetThreadBrowserFilterSheet.class, "binding", "getBinding()Lcom/discord/databinding/WidgetThreadBrowserFilterSheetBinding;", 0)};

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;

    /* renamed from: channelId$delegate, reason: from kotlin metadata */
    private final Lazy channelId;

    /* renamed from: guildId$delegate, reason: from kotlin metadata */
    private final Lazy guildId;

    /* renamed from: viewModel$delegate, reason: from kotlin metadata */
    private final Lazy viewModel;

    /* compiled from: WidgetThreadBrowserFilterSheet.kt */
    public static final class Companion {
        private Companion() {
        }

        public final void show(FragmentManager fragmentManager, long guildId, long channelId) {
            Intrinsics3.checkNotNullParameter(fragmentManager, "fragmentManager");
            WidgetThreadBrowserFilterSheet widgetThreadBrowserFilterSheet = new WidgetThreadBrowserFilterSheet();
            Bundle bundleT = outline.T("com.discord.intent.extra.EXTRA_GUILD_ID", guildId);
            bundleT.putLong("com.discord.intent.extra.EXTRA_CHANNEL_ID", channelId);
            widgetThreadBrowserFilterSheet.setArguments(bundleT);
            widgetThreadBrowserFilterSheet.show(fragmentManager, WidgetThreadBrowserFilterSheet.class.getName());
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: WidgetThreadBrowserFilterSheet.kt */
    /* renamed from: com.discord.widgets.channels.threads.browser.WidgetThreadBrowserFilterSheet$bindSubscriptions$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function1<WidgetThreadBrowserArchivedViewModel.ViewState, Unit> {
        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(WidgetThreadBrowserArchivedViewModel.ViewState viewState) {
            invoke2(viewState);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(WidgetThreadBrowserArchivedViewModel.ViewState viewState) {
            Intrinsics3.checkNotNullParameter(viewState, "viewState");
            WidgetThreadBrowserFilterSheet.access$configureUI(WidgetThreadBrowserFilterSheet.this, viewState);
        }
    }

    /* compiled from: WidgetThreadBrowserFilterSheet.kt */
    /* renamed from: com.discord.widgets.channels.threads.browser.WidgetThreadBrowserFilterSheet$configureUI$1, reason: invalid class name */
    public static final class AnonymousClass1 implements View.OnClickListener {
        public AnonymousClass1() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetThreadBrowserFilterSheet.access$getBinding$p(WidgetThreadBrowserFilterSheet.this).f2671b.toggle();
            WidgetThreadBrowserArchivedViewModel widgetThreadBrowserArchivedViewModelAccess$getViewModel$p = WidgetThreadBrowserFilterSheet.access$getViewModel$p(WidgetThreadBrowserFilterSheet.this);
            CheckedSetting checkedSetting = WidgetThreadBrowserFilterSheet.access$getBinding$p(WidgetThreadBrowserFilterSheet.this).f2671b;
            Intrinsics3.checkNotNullExpressionValue(checkedSetting, "binding.threadBrowserModeratorView");
            widgetThreadBrowserArchivedViewModelAccess$getViewModel$p.onModeratorModeChanged(checkedSetting.isChecked());
        }
    }

    /* compiled from: WidgetThreadBrowserFilterSheet.kt */
    /* renamed from: com.discord.widgets.channels.threads.browser.WidgetThreadBrowserFilterSheet$onResume$1, reason: invalid class name */
    public static final class AnonymousClass1 implements View.OnClickListener {
        public AnonymousClass1() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetThreadBrowserFilterSheet.access$getViewModel$p(WidgetThreadBrowserFilterSheet.this).onVisibilityChanged(WidgetThreadBrowserArchivedViewModel.VisibilityMode.PublicThreads);
        }
    }

    /* compiled from: WidgetThreadBrowserFilterSheet.kt */
    /* renamed from: com.discord.widgets.channels.threads.browser.WidgetThreadBrowserFilterSheet$onResume$2, reason: invalid class name */
    public static final class AnonymousClass2 implements View.OnClickListener {
        public AnonymousClass2() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetThreadBrowserFilterSheet.access$getViewModel$p(WidgetThreadBrowserFilterSheet.this).onVisibilityChanged(WidgetThreadBrowserArchivedViewModel.VisibilityMode.PrivateThreads);
        }
    }

    public WidgetThreadBrowserFilterSheet() {
        super(false, 1, null);
        this.binding = FragmentViewBindingDelegate3.viewBinding$default(this, WidgetThreadBrowserFilterSheet2.INSTANCE, null, 2, null);
        this.guildId = LazyJVM.lazy(new WidgetThreadBrowserFilterSheet4(this));
        this.channelId = LazyJVM.lazy(new WidgetThreadBrowserFilterSheet3(this));
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection2.getOrCreateKotlinClass(WidgetThreadBrowserArchivedViewModel.class), new WidgetThreadBrowserFilterSheet$appActivityViewModels$$inlined$activityViewModels$1(this), new AppViewModelDelegates2(new WidgetThreadBrowserFilterSheet5(this)));
    }

    public static final /* synthetic */ void access$configureUI(WidgetThreadBrowserFilterSheet widgetThreadBrowserFilterSheet, WidgetThreadBrowserArchivedViewModel.ViewState viewState) {
        widgetThreadBrowserFilterSheet.configureUI(viewState);
    }

    public static final /* synthetic */ WidgetThreadBrowserFilterSheetBinding access$getBinding$p(WidgetThreadBrowserFilterSheet widgetThreadBrowserFilterSheet) {
        return widgetThreadBrowserFilterSheet.getBinding();
    }

    public static final /* synthetic */ long access$getChannelId$p(WidgetThreadBrowserFilterSheet widgetThreadBrowserFilterSheet) {
        return widgetThreadBrowserFilterSheet.getChannelId();
    }

    public static final /* synthetic */ long access$getGuildId$p(WidgetThreadBrowserFilterSheet widgetThreadBrowserFilterSheet) {
        return widgetThreadBrowserFilterSheet.getGuildId();
    }

    public static final /* synthetic */ WidgetThreadBrowserArchivedViewModel access$getViewModel$p(WidgetThreadBrowserFilterSheet widgetThreadBrowserFilterSheet) {
        return widgetThreadBrowserFilterSheet.getViewModel();
    }

    private final void configureUI(WidgetThreadBrowserArchivedViewModel.ViewState viewState) {
        WidgetThreadBrowserArchivedViewModel.ViewMode viewMode = viewState.getViewMode();
        CheckedSetting checkedSetting = getBinding().e;
        Intrinsics3.checkNotNullExpressionValue(checkedSetting, "binding.threadBrowserVisibilityPublic");
        WidgetThreadBrowserArchivedViewModel.VisibilityMode visibility = viewMode.getVisibility();
        WidgetThreadBrowserArchivedViewModel.VisibilityMode visibilityMode = WidgetThreadBrowserArchivedViewModel.VisibilityMode.PublicThreads;
        checkedSetting.setChecked(visibility == visibilityMode);
        CheckedSetting checkedSetting2 = getBinding().d;
        Intrinsics3.checkNotNullExpressionValue(checkedSetting2, "binding.threadBrowserVisibilityPrivate");
        checkedSetting2.setChecked(viewMode.getVisibility() == WidgetThreadBrowserArchivedViewModel.VisibilityMode.PrivateThreads);
        CardView cardView = getBinding().c;
        Intrinsics3.checkNotNullExpressionValue(cardView, "binding.threadBrowserModeratorViewCard");
        cardView.setVisibility(viewState.isModerator() ? 0 : 8);
        if (viewMode.getVisibility() == visibilityMode) {
            CheckedSetting.d(getBinding().f2671b, null, 1);
        } else {
            getBinding().f2671b.e(new AnonymousClass1());
        }
        getBinding().f2671b.g(viewMode.isModeratorMode(), false);
    }

    private final WidgetThreadBrowserFilterSheetBinding getBinding() {
        return (WidgetThreadBrowserFilterSheetBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    private final long getChannelId() {
        return ((Number) this.channelId.getValue()).longValue();
    }

    private final long getGuildId() {
        return ((Number) this.guildId.getValue()).longValue();
    }

    private final WidgetThreadBrowserArchivedViewModel getViewModel() {
        return (WidgetThreadBrowserArchivedViewModel) this.viewModel.getValue();
    }

    @Override // com.discord.app.AppBottomSheet
    public void bindSubscriptions(CompositeSubscription compositeSubscription) {
        Intrinsics3.checkNotNullParameter(compositeSubscription, "compositeSubscription");
        super.bindSubscriptions(compositeSubscription);
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(getViewModel().observeViewState(), this, null, 2, null), WidgetThreadBrowserFilterSheet.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass1(), 62, (Object) null);
    }

    @Override // com.discord.app.AppBottomSheet
    public int getContentViewResId() {
        return R.layout.widget_thread_browser_filter_sheet;
    }

    @Override // com.discord.app.AppBottomSheet, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        dismiss();
    }

    @Override // com.discord.app.AppBottomSheet, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        getBinding().e.e(new AnonymousClass1());
        getBinding().d.e(new AnonymousClass2());
    }
}
