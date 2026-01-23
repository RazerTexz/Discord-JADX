package com.discord.widgets.servers.auditlog;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;
import com.discord.C5419R;
import com.discord.app.AppFragment;
import com.discord.databinding.WidgetAuditLogFilterBinding;
import com.discord.stores.StoreGuilds;
import com.discord.stores.StoreStream;
import com.discord.utilities.auditlogs.AuditLogUtils;
import com.discord.utilities.error.Error;
import com.discord.utilities.mg_recycler.MGRecyclerAdapter;
import com.discord.utilities.mg_recycler.MGRecyclerDataPayload;
import com.discord.utilities.p501rx.ObservableExtensionsKt;
import com.discord.utilities.view.extensions.ViewExtensions;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate3;
import com.google.android.material.textfield.TextInputLayout;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;
import p007b.p008a.p018d.AppScreen2;
import p007b.p100d.p104b.p105a.outline;
import p507d0.p592z.p594d.FunctionReferenceImpl;
import p507d0.p592z.p594d.Intrinsics3;
import p507d0.p592z.p594d.Lambda;
import p637j0.p642l.p647e.ScalarSynchronousObservable;
import p658rx.Observable;
import p658rx.subjects.BehaviorSubject;

/* JADX INFO: compiled from: WidgetServerSettingsAuditLogFilter.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetServerSettingsAuditLogFilter extends AppFragment {
    private static final String ARG_FILTER_TYPE = "ARG_FILTER_TYPE";
    private static final String ARG_GUILD_ID = "ARG_GUILD_ID";
    private WidgetServerSettingsAuditLogFilterAdapter adapter;

    /* JADX INFO: renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;
    private final BehaviorSubject<String> filterPublisher;
    private Integer filterType;
    private Long guildId;
    private final Function0<Unit> onFilterSelectedCallback;
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {outline.m846d0(WidgetServerSettingsAuditLogFilter.class, "binding", "getBinding()Lcom/discord/databinding/WidgetAuditLogFilterBinding;", 0)};

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* JADX INFO: compiled from: WidgetServerSettingsAuditLogFilter.kt */
    public static final class Companion {
        private Companion() {
        }

        public final void show(Context context, long guildId, int filterType) {
            Intrinsics3.checkNotNullParameter(context, "context");
            Intent intentPutExtra = new Intent().putExtra(WidgetServerSettingsAuditLogFilter.ARG_GUILD_ID, guildId).putExtra(WidgetServerSettingsAuditLogFilter.ARG_FILTER_TYPE, filterType);
            Intrinsics3.checkNotNullExpressionValue(intentPutExtra, "Intent()\n          .putE…_FILTER_TYPE, filterType)");
            AppScreen2.m156d(context, WidgetServerSettingsAuditLogFilter.class, intentPutExtra);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: compiled from: WidgetServerSettingsAuditLogFilter.kt */
    public static final class Model {

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private final List<MGRecyclerDataPayload> listItems;

        /* JADX INFO: compiled from: WidgetServerSettingsAuditLogFilter.kt */
        public static final class Companion {
            private Companion() {
            }

            private final Observable<Set<Long>> getPermissionUserIds(long guildId) {
                StoreGuilds guilds = StoreStream.INSTANCE.getGuilds();
                Observable<Set<Long>> observableM11112r = Observable.m11075i(guilds.observeGuild(guildId), guilds.observeRoles(guildId), guilds.observeComputed(guildId), WidgetServerSettingsAuditLogFilter6.INSTANCE).m11112r();
                Intrinsics3.checkNotNullExpressionValue(observableM11112r, "Observable\n            .…  .distinctUntilChanged()");
                return observableM11112r;
            }

            @SuppressLint({"DefaultLocale"})
            public final Observable<Model> get(Context context, long guildId, int filterType, Observable<String> filterPublisher) {
                Intrinsics3.checkNotNullParameter(context, "context");
                Intrinsics3.checkNotNullParameter(filterPublisher, "filterPublisher");
                StoreStream.Companion companion = StoreStream.INSTANCE;
                Observable<Model> observableM11112r = Observable.m11072g(companion.getAuditLog().observeAuditLogState(guildId), getPermissionUserIds(guildId).m11099Y(WidgetServerSettingsAuditLogFilter2.INSTANCE), companion.getGuilds().observeComputed(guildId), new ScalarSynchronousObservable(AuditLogUtils.INSTANCE.getALL_ACTION_TYPES()), ObservableExtensionsKt.leadingEdgeThrottle(filterPublisher, 100L, TimeUnit.MILLISECONDS).m11112r(), new WidgetServerSettingsAuditLogFilter3(filterType, context)).m11112r();
                Intrinsics3.checkNotNullExpressionValue(observableM11112r, "Observable\n             …  .distinctUntilChanged()");
                return observableM11112r;
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        public Model(List<? extends MGRecyclerDataPayload> list) {
            Intrinsics3.checkNotNullParameter(list, "listItems");
            this.listItems = list;
        }

        public final List<MGRecyclerDataPayload> getListItems() {
            return this.listItems;
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.servers.auditlog.WidgetServerSettingsAuditLogFilter$onViewBoundOrOnResume$1 */
    /* JADX INFO: compiled from: WidgetServerSettingsAuditLogFilter.kt */
    public static final class C93381 extends Lambda implements Function1<Error, Unit> {
        public C93381() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Error error) {
            invoke2(error);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Error error) {
            Intrinsics3.checkNotNullParameter(error, "it");
            FragmentActivity activity = WidgetServerSettingsAuditLogFilter.this.getActivity();
            if (activity != null) {
                activity.finish();
            }
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.servers.auditlog.WidgetServerSettingsAuditLogFilter$onViewBoundOrOnResume$2 */
    /* JADX INFO: compiled from: WidgetServerSettingsAuditLogFilter.kt */
    public static final /* synthetic */ class C93392 extends FunctionReferenceImpl implements Function1<Model, Unit> {
        public C93392(WidgetServerSettingsAuditLogFilter widgetServerSettingsAuditLogFilter) {
            super(1, widgetServerSettingsAuditLogFilter, WidgetServerSettingsAuditLogFilter.class, "configureUI", "configureUI(Lcom/discord/widgets/servers/auditlog/WidgetServerSettingsAuditLogFilter$Model;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Model model) {
            invoke2(model);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Model model) {
            Intrinsics3.checkNotNullParameter(model, "p1");
            WidgetServerSettingsAuditLogFilter.access$configureUI((WidgetServerSettingsAuditLogFilter) this.receiver, model);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.servers.auditlog.WidgetServerSettingsAuditLogFilter$onViewCreated$2 */
    /* JADX INFO: compiled from: WidgetServerSettingsAuditLogFilter.kt */
    public static final class C93412 extends Lambda implements Function1<Editable, Unit> {
        public C93412() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Editable editable) {
            invoke2(editable);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Editable editable) {
            Intrinsics3.checkNotNullParameter(editable, "it");
            WidgetServerSettingsAuditLogFilter.access$getFilterPublisher$p(WidgetServerSettingsAuditLogFilter.this).onNext(editable.toString());
        }
    }

    public WidgetServerSettingsAuditLogFilter() {
        super(C5419R.layout.widget_audit_log_filter);
        this.binding = FragmentViewBindingDelegate3.viewBinding$default(this, WidgetServerSettingsAuditLogFilter7.INSTANCE, null, 2, null);
        this.filterPublisher = BehaviorSubject.m11130l0("");
        this.onFilterSelectedCallback = new WidgetServerSettingsAuditLogFilter8(this);
    }

    public static final /* synthetic */ void access$configureUI(WidgetServerSettingsAuditLogFilter widgetServerSettingsAuditLogFilter, Model model) {
        widgetServerSettingsAuditLogFilter.configureUI(model);
    }

    public static final /* synthetic */ BehaviorSubject access$getFilterPublisher$p(WidgetServerSettingsAuditLogFilter widgetServerSettingsAuditLogFilter) {
        return widgetServerSettingsAuditLogFilter.filterPublisher;
    }

    private final void configureUI(Model model) {
        if (this.filterType == null) {
            FragmentActivity activity = getActivity();
            if (activity != null) {
                activity.finish();
                return;
            }
            return;
        }
        WidgetServerSettingsAuditLogFilterAdapter widgetServerSettingsAuditLogFilterAdapter = this.adapter;
        if (widgetServerSettingsAuditLogFilterAdapter != null) {
            widgetServerSettingsAuditLogFilterAdapter.configure(model.getListItems(), this.onFilterSelectedCallback);
        }
    }

    private final WidgetAuditLogFilterBinding getBinding() {
        return (WidgetAuditLogFilterBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    @Override // com.discord.app.AppFragment, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        AppFragment.hideKeyboard$default(this, null, 1, null);
    }

    @Override // com.discord.app.AppFragment
    public void onViewBoundOrOnResume() {
        super.onViewBoundOrOnResume();
        this.filterType = Integer.valueOf(getMostRecentIntent().getIntExtra(ARG_FILTER_TYPE, -1));
        this.guildId = Long.valueOf(getMostRecentIntent().getLongExtra(ARG_GUILD_ID, 0L));
        Model.Companion companion = Model.INSTANCE;
        Context contextRequireContext = requireContext();
        Long l = this.guildId;
        long jLongValue = l != null ? l.longValue() : 0L;
        Integer num = this.filterType;
        if (num != null) {
            int iIntValue = num.intValue();
            BehaviorSubject<String> behaviorSubject = this.filterPublisher;
            Intrinsics3.checkNotNullExpressionValue(behaviorSubject, "filterPublisher");
            ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.computationLatest(companion.get(contextRequireContext, jLongValue, iIntValue, behaviorSubject)), this, null, 2, null), WidgetServerSettingsAuditLogFilter.class, (Context) null, (Function1) null, new C93381(), (Function0) null, (Function0) null, new C93392(this), 54, (Object) null);
        }
    }

    @Override // com.discord.app.AppFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics3.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        AppFragment.setActionBarDisplayHomeAsUpEnabled$default(this, false, 1, null);
        MGRecyclerAdapter.Companion companion = MGRecyclerAdapter.INSTANCE;
        RecyclerView recyclerView = getBinding().f15667c;
        Intrinsics3.checkNotNullExpressionValue(recyclerView, "binding.auditLogFilterRecycler");
        WidgetServerSettingsAuditLogFilterAdapter widgetServerSettingsAuditLogFilterAdapter = (WidgetServerSettingsAuditLogFilterAdapter) companion.configure(new WidgetServerSettingsAuditLogFilterAdapter(recyclerView));
        widgetServerSettingsAuditLogFilterAdapter.setOnAuditLogAvatarClicked(new WidgetServerSettingsAuditLogFilter9(this));
        this.adapter = widgetServerSettingsAuditLogFilterAdapter;
        setActionBarTitle(C5419R.string.guild_settings_label_audit_log);
        Integer num = this.filterType;
        setActionBarSubtitle((num != null && num.intValue() == 0) ? C5419R.string.guild_settings_filter_user : C5419R.string.guild_settings_filter_action);
        TextInputLayout textInputLayout = getBinding().f15666b;
        Intrinsics3.checkNotNullExpressionValue(textInputLayout, "binding.auditLogFilterInput");
        Integer num2 = this.filterType;
        ViewExtensions.setSingleLineHint(textInputLayout, (num2 != null && num2.intValue() == 0) ? C5419R.string.search_members : C5419R.string.search_actions);
        TextInputLayout textInputLayout2 = getBinding().f15666b;
        Intrinsics3.checkNotNullExpressionValue(textInputLayout2, "binding.auditLogFilterInput");
        ViewExtensions.addBindedTextWatcher(textInputLayout2, this, new C93412());
    }
}
