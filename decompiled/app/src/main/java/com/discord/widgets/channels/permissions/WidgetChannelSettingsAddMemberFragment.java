package com.discord.widgets.channels.permissions;

import android.content.Context;
import androidx.core.os.Bundle2;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentViewModelLazyKt;
import com.discord.C5419R;
import com.discord.api.permission.PermissionOverwrite;
import com.discord.app.AppFragment;
import com.discord.databinding.WidgetChannelSettingsAddMemberBinding;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.utilities.p501rx.ObservableExtensionsKt;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate3;
import com.discord.widgets.channels.permissions.WidgetChannelSettingsAddMemberFragmentViewModel;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import kotlin.Lazy;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;
import p007b.p008a.p018d.AppViewModelDelegates5;
import p007b.p100d.p104b.p105a.outline;
import p507d0.LazyJVM;
import p507d0.Tuples;
import p507d0.p592z.p594d.Intrinsics3;
import p507d0.p592z.p594d.Lambda;
import p507d0.p592z.p594d.Reflection2;
import p658rx.Observable;
import p658rx.subjects.BehaviorSubject;

/* JADX INFO: compiled from: WidgetChannelSettingsAddMemberFragment.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChannelSettingsAddMemberFragment extends AppFragment {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {outline.m846d0(WidgetChannelSettingsAddMemberFragment.class, "binding", "getBinding()Lcom/discord/databinding/WidgetChannelSettingsAddMemberBinding;", 0)};

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String EXTRA_SHOW_ROLES_WITH_GUILD_PERMISSION = "EXTRA_SHOW_ROLES_WITH_GUILD_PERMISSION";

    /* JADX INFO: renamed from: adapter$delegate, reason: from kotlin metadata */
    private final Lazy adapter;

    /* JADX INFO: renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;

    /* JADX INFO: renamed from: channelId$delegate, reason: from kotlin metadata */
    private final Lazy channelId;
    private final BehaviorSubject<String> querySubject;
    private final BehaviorSubject<Map<Long, PermissionOverwrite.Type>> selectedSubject;

    /* JADX INFO: renamed from: showRolesWithGuildPermission$delegate, reason: from kotlin metadata */
    private final Lazy showRolesWithGuildPermission;

    /* JADX INFO: renamed from: viewModel$delegate, reason: from kotlin metadata */
    private final Lazy viewModel;

    /* JADX INFO: compiled from: WidgetChannelSettingsAddMemberFragment.kt */
    public static final class Companion {
        private Companion() {
        }

        public final WidgetChannelSettingsAddMemberFragment create(long channelId, boolean showRolesWithGuildPermission) {
            WidgetChannelSettingsAddMemberFragment widgetChannelSettingsAddMemberFragment = new WidgetChannelSettingsAddMemberFragment();
            widgetChannelSettingsAddMemberFragment.setArguments(Bundle2.bundleOf(Tuples.m10073to("com.discord.intent.extra.EXTRA_CHANNEL_ID", Long.valueOf(channelId)), Tuples.m10073to(WidgetChannelSettingsAddMemberFragment.access$getEXTRA_SHOW_ROLES_WITH_GUILD_PERMISSION$cp(), Boolean.valueOf(showRolesWithGuildPermission))));
            return widgetChannelSettingsAddMemberFragment;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.channels.permissions.WidgetChannelSettingsAddMemberFragment$onViewBoundOrOnResume$1 */
    /* JADX INFO: compiled from: WidgetChannelSettingsAddMemberFragment.kt */
    public static final class C75241 extends Lambda implements Function1<String, Unit> {
        public C75241() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(String str) {
            invoke2(str);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(String str) {
            WidgetChannelSettingsAddMemberFragmentViewModel widgetChannelSettingsAddMemberFragmentViewModelAccess$getViewModel$p = WidgetChannelSettingsAddMemberFragment.access$getViewModel$p(WidgetChannelSettingsAddMemberFragment.this);
            Intrinsics3.checkNotNullExpressionValue(str, "it");
            widgetChannelSettingsAddMemberFragmentViewModelAccess$getViewModel$p.updateQuery(str);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.channels.permissions.WidgetChannelSettingsAddMemberFragment$onViewBoundOrOnResume$2 */
    /* JADX INFO: compiled from: WidgetChannelSettingsAddMemberFragment.kt */
    public static final class C75252 extends Lambda implements Function1<String, Unit> {
        public C75252() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(String str) {
            invoke2(str);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(String str) {
            Intrinsics3.checkNotNullParameter(str, "it");
            WidgetChannelSettingsAddMemberFragment.access$getQuerySubject$p(WidgetChannelSettingsAddMemberFragment.this).onNext(str);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.channels.permissions.WidgetChannelSettingsAddMemberFragment$onViewBoundOrOnResume$3 */
    /* JADX INFO: compiled from: WidgetChannelSettingsAddMemberFragment.kt */
    public static final class C75263 extends Lambda implements Function2<Long, PermissionOverwrite.Type, Unit> {
        public C75263() {
            super(2);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(Long l, PermissionOverwrite.Type type) {
            invoke(l.longValue(), type);
            return Unit.f27425a;
        }

        public final void invoke(long j, PermissionOverwrite.Type type) {
            Intrinsics3.checkNotNullParameter(type, "type");
            WidgetChannelSettingsAddMemberFragment.access$getViewModel$p(WidgetChannelSettingsAddMemberFragment.this).toggleItem(j, type);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.channels.permissions.WidgetChannelSettingsAddMemberFragment$onViewBoundOrOnResume$4 */
    /* JADX INFO: compiled from: WidgetChannelSettingsAddMemberFragment.kt */
    public static final class C75274 extends Lambda implements Function1<WidgetChannelSettingsAddMemberFragmentViewModel.ViewState, Unit> {
        public C75274() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(WidgetChannelSettingsAddMemberFragmentViewModel.ViewState viewState) {
            invoke2(viewState);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(WidgetChannelSettingsAddMemberFragmentViewModel.ViewState viewState) {
            Intrinsics3.checkNotNullParameter(viewState, "viewState");
            WidgetChannelSettingsAddMemberFragment.access$configureUI(WidgetChannelSettingsAddMemberFragment.this, viewState);
            WidgetChannelSettingsAddMemberFragment.access$getSelectedSubject$p(WidgetChannelSettingsAddMemberFragment.this).onNext(viewState.getSelected());
        }
    }

    public WidgetChannelSettingsAddMemberFragment() {
        super(C5419R.layout.widget_channel_settings_add_member);
        this.binding = FragmentViewBindingDelegate3.viewBinding$default(this, WidgetChannelSettingsAddMemberFragment3.INSTANCE, null, 2, null);
        this.adapter = LazyJVM.lazy(new WidgetChannelSettingsAddMemberFragment2(this));
        this.channelId = LazyJVM.lazy(new WidgetChannelSettingsAddMemberFragment4(this));
        this.showRolesWithGuildPermission = LazyJVM.lazy(new WidgetChannelSettingsAddMemberFragment5(this));
        WidgetChannelSettingsAddMemberFragment6 widgetChannelSettingsAddMemberFragment6 = new WidgetChannelSettingsAddMemberFragment6(this);
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection2.getOrCreateKotlinClass(WidgetChannelSettingsAddMemberFragmentViewModel.class), new C7523xeed7a80a(widgetChannelSettingsAddMemberFragment6), new AppViewModelDelegates5(new WidgetChannelSettingsAddMemberFragment7(this)));
        this.querySubject = BehaviorSubject.m11130l0("");
        this.selectedSubject = BehaviorSubject.m11130l0(Collections.emptyMap());
    }

    public static final /* synthetic */ void access$configureUI(WidgetChannelSettingsAddMemberFragment widgetChannelSettingsAddMemberFragment, WidgetChannelSettingsAddMemberFragmentViewModel.ViewState viewState) {
        widgetChannelSettingsAddMemberFragment.configureUI(viewState);
    }

    public static final /* synthetic */ WidgetChannelSettingsAddMemberBinding access$getBinding$p(WidgetChannelSettingsAddMemberFragment widgetChannelSettingsAddMemberFragment) {
        return widgetChannelSettingsAddMemberFragment.getBinding();
    }

    public static final /* synthetic */ long access$getChannelId$p(WidgetChannelSettingsAddMemberFragment widgetChannelSettingsAddMemberFragment) {
        return widgetChannelSettingsAddMemberFragment.getChannelId();
    }

    public static final /* synthetic */ String access$getEXTRA_SHOW_ROLES_WITH_GUILD_PERMISSION$cp() {
        return EXTRA_SHOW_ROLES_WITH_GUILD_PERMISSION;
    }

    public static final /* synthetic */ BehaviorSubject access$getQuerySubject$p(WidgetChannelSettingsAddMemberFragment widgetChannelSettingsAddMemberFragment) {
        return widgetChannelSettingsAddMemberFragment.querySubject;
    }

    public static final /* synthetic */ BehaviorSubject access$getSelectedSubject$p(WidgetChannelSettingsAddMemberFragment widgetChannelSettingsAddMemberFragment) {
        return widgetChannelSettingsAddMemberFragment.selectedSubject;
    }

    public static final /* synthetic */ boolean access$getShowRolesWithGuildPermission$p(WidgetChannelSettingsAddMemberFragment widgetChannelSettingsAddMemberFragment) {
        return widgetChannelSettingsAddMemberFragment.getShowRolesWithGuildPermission();
    }

    public static final /* synthetic */ WidgetChannelSettingsAddMemberFragmentViewModel access$getViewModel$p(WidgetChannelSettingsAddMemberFragment widgetChannelSettingsAddMemberFragment) {
        return widgetChannelSettingsAddMemberFragment.getViewModel();
    }

    private final void configureUI(WidgetChannelSettingsAddMemberFragmentViewModel.ViewState viewState) {
        getAdapter().setData(viewState.getItems());
    }

    private final AddMemberAdapter getAdapter() {
        return (AddMemberAdapter) this.adapter.getValue();
    }

    private final WidgetChannelSettingsAddMemberBinding getBinding() {
        return (WidgetChannelSettingsAddMemberBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    private final long getChannelId() {
        return ((Number) this.channelId.getValue()).longValue();
    }

    private final boolean getShowRolesWithGuildPermission() {
        return ((Boolean) this.showRolesWithGuildPermission.getValue()).booleanValue();
    }

    private final WidgetChannelSettingsAddMemberFragmentViewModel getViewModel() {
        return (WidgetChannelSettingsAddMemberFragmentViewModel) this.viewModel.getValue();
    }

    public final BehaviorSubject<Map<Long, PermissionOverwrite.Type>> getSelectedItemsSubject() {
        return this.selectedSubject;
    }

    @Override // com.discord.app.AppFragment
    public void onViewBoundOrOnResume() {
        super.onViewBoundOrOnResume();
        Observable<String> observableM11112r = this.querySubject.m11110p(200L, TimeUnit.MILLISECONDS).m11112r();
        Intrinsics3.checkNotNullExpressionValue(observableM11112r, "querySubject\n        .de…  .distinctUntilChanged()");
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(observableM11112r, this, null, 2, null), WidgetChannelSettingsAddMemberFragment.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new C75241(), 62, (Object) null);
        getBinding().f15897c.setText(getViewModel().getQuery());
        getBinding().f15897c.m8553a(this, new C75252());
        getAdapter().setOnClickListener(new C75263());
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.bindToComponentLifecycle$default(getViewModel().observeViewState(), this, null, 2, null), WidgetChannelSettingsAddMemberFragment.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new C75274(), 62, (Object) null);
    }
}
