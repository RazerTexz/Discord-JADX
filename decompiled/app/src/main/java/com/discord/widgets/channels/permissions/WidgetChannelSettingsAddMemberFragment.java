package com.discord.widgets.channels.permissions;

import android.content.Context;
import androidx.core.os.BundleKt;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentViewModelLazyKt;
import b.a.d.i0;
import b.d.b.a.a;
import com.discord.R;
import com.discord.api.permission.PermissionOverwrite;
import com.discord.app.AppFragment;
import com.discord.databinding.WidgetChannelSettingsAddMemberBinding;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegateKt;
import com.discord.widgets.channels.permissions.WidgetChannelSettingsAddMemberFragmentViewModel;
import d0.g;
import d0.o;
import d0.z.d.a0;
import d0.z.d.m;
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
import rx.Observable;
import rx.subjects.BehaviorSubject;

/* compiled from: WidgetChannelSettingsAddMemberFragment.kt */
/* loaded from: classes2.dex */
public final class WidgetChannelSettingsAddMemberFragment extends AppFragment {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {a.d0(WidgetChannelSettingsAddMemberFragment.class, "binding", "getBinding()Lcom/discord/databinding/WidgetChannelSettingsAddMemberBinding;", 0)};

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String EXTRA_SHOW_ROLES_WITH_GUILD_PERMISSION = "EXTRA_SHOW_ROLES_WITH_GUILD_PERMISSION";

    /* renamed from: adapter$delegate, reason: from kotlin metadata */
    private final Lazy adapter;

    /* renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;

    /* renamed from: channelId$delegate, reason: from kotlin metadata */
    private final Lazy channelId;
    private final BehaviorSubject<String> querySubject;
    private final BehaviorSubject<Map<Long, PermissionOverwrite.Type>> selectedSubject;

    /* renamed from: showRolesWithGuildPermission$delegate, reason: from kotlin metadata */
    private final Lazy showRolesWithGuildPermission;

    /* renamed from: viewModel$delegate, reason: from kotlin metadata */
    private final Lazy viewModel;

    /* compiled from: WidgetChannelSettingsAddMemberFragment.kt */
    public static final class Companion {
        private Companion() {
        }

        public final WidgetChannelSettingsAddMemberFragment create(long channelId, boolean showRolesWithGuildPermission) {
            WidgetChannelSettingsAddMemberFragment widgetChannelSettingsAddMemberFragment = new WidgetChannelSettingsAddMemberFragment();
            widgetChannelSettingsAddMemberFragment.setArguments(BundleKt.bundleOf(o.to("com.discord.intent.extra.EXTRA_CHANNEL_ID", Long.valueOf(channelId)), o.to(WidgetChannelSettingsAddMemberFragment.access$getEXTRA_SHOW_ROLES_WITH_GUILD_PERMISSION$cp(), Boolean.valueOf(showRolesWithGuildPermission))));
            return widgetChannelSettingsAddMemberFragment;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: WidgetChannelSettingsAddMemberFragment.kt */
    /* renamed from: com.discord.widgets.channels.permissions.WidgetChannelSettingsAddMemberFragment$onViewBoundOrOnResume$1, reason: invalid class name */
    public static final class AnonymousClass1 extends d0.z.d.o implements Function1<String, Unit> {
        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(String str) {
            invoke2(str);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(String str) {
            WidgetChannelSettingsAddMemberFragmentViewModel widgetChannelSettingsAddMemberFragmentViewModelAccess$getViewModel$p = WidgetChannelSettingsAddMemberFragment.access$getViewModel$p(WidgetChannelSettingsAddMemberFragment.this);
            m.checkNotNullExpressionValue(str, "it");
            widgetChannelSettingsAddMemberFragmentViewModelAccess$getViewModel$p.updateQuery(str);
        }
    }

    /* compiled from: WidgetChannelSettingsAddMemberFragment.kt */
    /* renamed from: com.discord.widgets.channels.permissions.WidgetChannelSettingsAddMemberFragment$onViewBoundOrOnResume$2, reason: invalid class name */
    public static final class AnonymousClass2 extends d0.z.d.o implements Function1<String, Unit> {
        public AnonymousClass2() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(String str) {
            invoke2(str);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(String str) {
            m.checkNotNullParameter(str, "it");
            WidgetChannelSettingsAddMemberFragment.access$getQuerySubject$p(WidgetChannelSettingsAddMemberFragment.this).onNext(str);
        }
    }

    /* compiled from: WidgetChannelSettingsAddMemberFragment.kt */
    /* renamed from: com.discord.widgets.channels.permissions.WidgetChannelSettingsAddMemberFragment$onViewBoundOrOnResume$3, reason: invalid class name */
    public static final class AnonymousClass3 extends d0.z.d.o implements Function2<Long, PermissionOverwrite.Type, Unit> {
        public AnonymousClass3() {
            super(2);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(Long l, PermissionOverwrite.Type type) {
            invoke(l.longValue(), type);
            return Unit.a;
        }

        public final void invoke(long j, PermissionOverwrite.Type type) {
            m.checkNotNullParameter(type, "type");
            WidgetChannelSettingsAddMemberFragment.access$getViewModel$p(WidgetChannelSettingsAddMemberFragment.this).toggleItem(j, type);
        }
    }

    /* compiled from: WidgetChannelSettingsAddMemberFragment.kt */
    /* renamed from: com.discord.widgets.channels.permissions.WidgetChannelSettingsAddMemberFragment$onViewBoundOrOnResume$4, reason: invalid class name */
    public static final class AnonymousClass4 extends d0.z.d.o implements Function1<WidgetChannelSettingsAddMemberFragmentViewModel.ViewState, Unit> {
        public AnonymousClass4() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(WidgetChannelSettingsAddMemberFragmentViewModel.ViewState viewState) {
            invoke2(viewState);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(WidgetChannelSettingsAddMemberFragmentViewModel.ViewState viewState) {
            m.checkNotNullParameter(viewState, "viewState");
            WidgetChannelSettingsAddMemberFragment.access$configureUI(WidgetChannelSettingsAddMemberFragment.this, viewState);
            WidgetChannelSettingsAddMemberFragment.access$getSelectedSubject$p(WidgetChannelSettingsAddMemberFragment.this).onNext(viewState.getSelected());
        }
    }

    public WidgetChannelSettingsAddMemberFragment() {
        super(R.layout.widget_channel_settings_add_member);
        this.binding = FragmentViewBindingDelegateKt.viewBinding$default(this, WidgetChannelSettingsAddMemberFragment$binding$2.INSTANCE, null, 2, null);
        this.adapter = g.lazy(new WidgetChannelSettingsAddMemberFragment$adapter$2(this));
        this.channelId = g.lazy(new WidgetChannelSettingsAddMemberFragment$channelId$2(this));
        this.showRolesWithGuildPermission = g.lazy(new WidgetChannelSettingsAddMemberFragment$showRolesWithGuildPermission$2(this));
        WidgetChannelSettingsAddMemberFragment$viewModel$2 widgetChannelSettingsAddMemberFragment$viewModel$2 = new WidgetChannelSettingsAddMemberFragment$viewModel$2(this);
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(this, a0.getOrCreateKotlinClass(WidgetChannelSettingsAddMemberFragmentViewModel.class), new WidgetChannelSettingsAddMemberFragment$appViewModels$$inlined$viewModels$1(widgetChannelSettingsAddMemberFragment$viewModel$2), new i0(new WidgetChannelSettingsAddMemberFragment$viewModel$3(this)));
        this.querySubject = BehaviorSubject.l0("");
        this.selectedSubject = BehaviorSubject.l0(Collections.emptyMap());
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
        Observable<String> observableR = this.querySubject.p(200L, TimeUnit.MILLISECONDS).r();
        m.checkNotNullExpressionValue(observableR, "querySubject\n        .de…  .distinctUntilChanged()");
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(observableR, this, null, 2, null), WidgetChannelSettingsAddMemberFragment.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass1(), 62, (Object) null);
        getBinding().c.setText(getViewModel().getQuery());
        getBinding().c.a(this, new AnonymousClass2());
        getAdapter().setOnClickListener(new AnonymousClass3());
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.bindToComponentLifecycle$default(getViewModel().observeViewState(), this, null, 2, null), WidgetChannelSettingsAddMemberFragment.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass4(), 62, (Object) null);
    }
}
