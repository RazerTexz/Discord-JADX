package com.discord.widgets.servers.settings.members;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.TextView;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.app.NotificationCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.RecyclerView;
import b.a.d.AppScreen2;
import b.a.d.AppToast;
import b.a.i.ServerSettingsMembersRoleSpinnerItemBinding;
import b.a.i.ServerSettingsMembersRoleSpinnerItemOpenBinding;
import b.d.b.a.outline;
import com.discord.R;
import com.discord.api.role.GuildRole;
import com.discord.app.AppActivity;
import com.discord.app.AppFragment;
import com.discord.app.AppLogger2;
import com.discord.app.AppViewFlipper;
import com.discord.databinding.WidgetServerSettingsMembersBinding;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.stores.StoreGatewayConnection;
import com.discord.stores.StoreStream;
import com.discord.utilities.guilds.RoleUtils;
import com.discord.utilities.mg_recycler.MGRecyclerAdapter;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.view.text.TextWatcher;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate3;
import com.discord.widgets.servers.WidgetServerSettingsChannels;
import com.discord.widgets.servers.WidgetServerSettingsEditMember;
import com.discord.widgets.user.WidgetPruneUsers;
import com.google.android.material.textfield.TextInputLayout;
import d0.LazyJVM;
import d0.g0.StringNumberConversions;
import d0.t.CollectionsJVM;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.TimeUnit;
import kotlin.Lazy;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;
import rx.Observable;
import rx.functions.Action1;
import rx.functions.Action2;
import rx.subjects.BehaviorSubject;
import rx.subjects.Subject;

/* compiled from: WidgetServerSettingsMembers.kt */
/* loaded from: classes2.dex */
public final class WidgetServerSettingsMembers extends AppFragment {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {outline.d0(WidgetServerSettingsMembers.class, "binding", "getBinding()Lcom/discord/databinding/WidgetServerSettingsMembersBinding;", 0)};

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String INTENT_EXTRA_GUILD_ID = "GUILD_ID";
    private static final int VIEW_INDEX_MEMBER_LIST = 0;
    private static final int VIEW_INDEX_NO_RESULTS = 1;
    private WidgetServerSettingsMembersAdapter adapter;

    /* renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;

    /* renamed from: guildId$delegate, reason: from kotlin metadata */
    private final Lazy guildId;
    private Map<Long, GuildRole> guildRoles;
    private final AppLogger2 loggingConfig;
    private final Subject<String, String> nameFilterPublisher;
    private final Subject<Long, Long> roleFilterPublisher;

    /* compiled from: WidgetServerSettingsMembers.kt */
    public static final class Companion {
        private Companion() {
        }

        public final void create(Context context, long guildId) {
            Intrinsics3.checkNotNullParameter(context, "context");
            Intent intentPutExtra = new Intent().putExtra(WidgetServerSettingsMembers.INTENT_EXTRA_GUILD_ID, guildId);
            Intrinsics3.checkNotNullExpressionValue(intentPutExtra, "Intent()\n          .putE…_EXTRA_GUILD_ID, guildId)");
            AppScreen2.d(context, WidgetServerSettingsMembers.class, intentPutExtra);
            StoreStream.INSTANCE.getAnalytics().onGuildSettingsPaneViewed("MEMBERS", guildId);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: WidgetServerSettingsMembers.kt */
    public static final class RolesSpinnerAdapter extends ArrayAdapter<GuildRole> {
        private final ArrayList<GuildRole> roles;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public RolesSpinnerAdapter(Context context, ArrayList<GuildRole> arrayList) {
            super(context, R.layout.server_settings_members_role_spinner_item, arrayList);
            Intrinsics3.checkNotNullParameter(context, "context");
            Intrinsics3.checkNotNullParameter(arrayList, "roles");
            this.roles = arrayList;
        }

        private final void configureLabel(TextView label, int position) {
            GuildRole item = getItem(position);
            Context context = getContext();
            Intrinsics3.checkNotNullExpressionValue(context, "context");
            label.setTextColor(RoleUtils.getRoleColor$default(item, context, null, 2, null));
            label.setText(item.getName());
        }

        @Override // android.widget.ArrayAdapter, android.widget.Adapter
        public int getCount() {
            return this.roles.size();
        }

        @Override // android.widget.ArrayAdapter, android.widget.BaseAdapter, android.widget.SpinnerAdapter
        public View getDropDownView(int position, View convertView, ViewGroup parent) {
            ServerSettingsMembersRoleSpinnerItemOpenBinding serverSettingsMembersRoleSpinnerItemOpenBinding;
            Intrinsics3.checkNotNullParameter(parent, "parent");
            if (convertView == null) {
                View viewInflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.server_settings_members_role_spinner_item_open, (ViewGroup) null, false);
                Objects.requireNonNull(viewInflate, "rootView");
                TextView textView = (TextView) viewInflate;
                serverSettingsMembersRoleSpinnerItemOpenBinding = new ServerSettingsMembersRoleSpinnerItemOpenBinding(textView, textView);
            } else {
                TextView textView2 = (TextView) convertView;
                serverSettingsMembersRoleSpinnerItemOpenBinding = new ServerSettingsMembersRoleSpinnerItemOpenBinding(textView2, textView2);
            }
            Intrinsics3.checkNotNullExpressionValue(serverSettingsMembersRoleSpinnerItemOpenBinding, "if (convertView == null)…bind(convertView)\n      }");
            TextView textView3 = serverSettingsMembersRoleSpinnerItemOpenBinding.f151b;
            Intrinsics3.checkNotNullExpressionValue(textView3, "binding.roleSpinnerItemTextview");
            configureLabel(textView3, position);
            TextView textView4 = serverSettingsMembersRoleSpinnerItemOpenBinding.a;
            Intrinsics3.checkNotNullExpressionValue(textView4, "binding.root");
            return textView4;
        }

        @Override // android.widget.ArrayAdapter, android.widget.Adapter
        public /* bridge */ /* synthetic */ Object getItem(int i) {
            return getItem(i);
        }

        @Override // android.widget.ArrayAdapter, android.widget.Adapter
        public long getItemId(int position) {
            return position;
        }

        @Override // android.widget.ArrayAdapter, android.widget.Adapter
        public View getView(int position, View convertView, ViewGroup parent) {
            ServerSettingsMembersRoleSpinnerItemBinding serverSettingsMembersRoleSpinnerItemBinding;
            Intrinsics3.checkNotNullParameter(parent, "parent");
            if (convertView == null) {
                View viewInflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.server_settings_members_role_spinner_item, (ViewGroup) null, false);
                Objects.requireNonNull(viewInflate, "rootView");
                TextView textView = (TextView) viewInflate;
                serverSettingsMembersRoleSpinnerItemBinding = new ServerSettingsMembersRoleSpinnerItemBinding(textView, textView);
            } else {
                TextView textView2 = (TextView) convertView;
                serverSettingsMembersRoleSpinnerItemBinding = new ServerSettingsMembersRoleSpinnerItemBinding(textView2, textView2);
            }
            Intrinsics3.checkNotNullExpressionValue(serverSettingsMembersRoleSpinnerItemBinding, "if (convertView == null)…bind(convertView)\n      }");
            TextView textView3 = serverSettingsMembersRoleSpinnerItemBinding.f145b;
            Intrinsics3.checkNotNullExpressionValue(textView3, "binding.roleSpinnerItemTextview");
            configureLabel(textView3, position);
            TextView textView4 = serverSettingsMembersRoleSpinnerItemBinding.a;
            Intrinsics3.checkNotNullExpressionValue(textView4, "binding.root");
            return textView4;
        }

        @Override // android.widget.ArrayAdapter, android.widget.Adapter
        public GuildRole getItem(int position) {
            GuildRole guildRole = this.roles.get(position);
            Intrinsics3.checkNotNullExpressionValue(guildRole, "roles[position]");
            return guildRole;
        }
    }

    /* compiled from: WidgetServerSettingsMembers.kt */
    /* renamed from: com.discord.widgets.servers.settings.members.WidgetServerSettingsMembers$configureUI$1, reason: invalid class name */
    public static final class AnonymousClass1<T1, T2> implements Action2<MenuItem, Context> {
        public final /* synthetic */ WidgetServerSettingsMembersModel $model;

        public AnonymousClass1(WidgetServerSettingsMembersModel widgetServerSettingsMembersModel) {
            this.$model = widgetServerSettingsMembersModel;
        }

        @Override // rx.functions.Action2
        public /* bridge */ /* synthetic */ void call(MenuItem menuItem, Context context) {
            call2(menuItem, context);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final void call2(MenuItem menuItem, Context context) {
            Intrinsics3.checkNotNullExpressionValue(menuItem, "menuItem");
            if (menuItem.getItemId() != R.id.menu_server_settings_members_prune) {
                return;
            }
            WidgetPruneUsers.Companion companion = WidgetPruneUsers.INSTANCE;
            long id2 = this.$model.getGuild().getId();
            FragmentManager parentFragmentManager = WidgetServerSettingsMembers.this.getParentFragmentManager();
            Intrinsics3.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
            companion.create(id2, parentFragmentManager);
        }
    }

    /* compiled from: WidgetServerSettingsMembers.kt */
    /* renamed from: com.discord.widgets.servers.settings.members.WidgetServerSettingsMembers$configureUI$2, reason: invalid class name */
    public static final class AnonymousClass2 extends Lambda implements Function2<Long, List<? extends Long>, Unit> {
        public final /* synthetic */ WidgetServerSettingsMembersModel $model;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(WidgetServerSettingsMembersModel widgetServerSettingsMembersModel) {
            super(2);
            this.$model = widgetServerSettingsMembersModel;
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(Long l, List<? extends Long> list) {
            invoke(l.longValue(), (List<Long>) list);
            return Unit.a;
        }

        public final void invoke(long j, List<Long> list) {
            Intrinsics3.checkNotNullParameter(list, "userRoles");
            boolean z2 = j == this.$model.getMeUser().getId();
            if (this.$model.getGuild().getOwnerId() == j && !z2) {
                AppToast.i(WidgetServerSettingsMembers.this, R.string.cannot_manage_is_owner, 0, 4);
                return;
            }
            GuildRole highestRole = RoleUtils.getHighestRole(this.$model.getRoles(), list);
            if (!RoleUtils.rankIsHigher(this.$model.getMyHighestRole(), highestRole) && !this.$model.getGuild().isOwner(this.$model.getMeUser().getId()) && !z2) {
                if (RoleUtils.rankEquals(this.$model.getMyHighestRole(), highestRole)) {
                    AppToast.i(WidgetServerSettingsMembers.this, R.string.cannot_manage_same_rank, 0, 4);
                    return;
                } else {
                    AppToast.i(WidgetServerSettingsMembers.this, R.string.cannot_manage_higher_rank, 0, 4);
                    return;
                }
            }
            WidgetServerSettingsEditMember.Companion companion = WidgetServerSettingsEditMember.INSTANCE;
            long id2 = this.$model.getGuild().getId();
            WidgetServerSettingsMembersBinding widgetServerSettingsMembersBindingAccess$getBinding$p = WidgetServerSettingsMembers.access$getBinding$p(WidgetServerSettingsMembers.this);
            Intrinsics3.checkNotNullExpressionValue(widgetServerSettingsMembersBindingAccess$getBinding$p, "binding");
            CoordinatorLayout coordinatorLayout = widgetServerSettingsMembersBindingAccess$getBinding$p.a;
            Intrinsics3.checkNotNullExpressionValue(coordinatorLayout, "binding.root");
            Context context = coordinatorLayout.getContext();
            Intrinsics3.checkNotNullExpressionValue(context, "binding.root.context");
            companion.launch(id2, j, context);
        }
    }

    /* compiled from: WidgetServerSettingsMembers.kt */
    /* renamed from: com.discord.widgets.servers.settings.members.WidgetServerSettingsMembers$onViewBoundOrOnResume$1, reason: invalid class name */
    public static final class AnonymousClass1<T> implements Action1<String> {
        public AnonymousClass1() {
        }

        @Override // rx.functions.Action1
        public /* bridge */ /* synthetic */ void call(String str) {
            call2(str);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final void call2(String str) {
            WidgetServerSettingsMembers.access$getNameFilterPublisher$p(WidgetServerSettingsMembers.this).onNext(str);
        }
    }

    /* compiled from: WidgetServerSettingsMembers.kt */
    /* renamed from: com.discord.widgets.servers.settings.members.WidgetServerSettingsMembers$onViewBoundOrOnResume$2, reason: invalid class name */
    public static final class AnonymousClass2 extends Lambda implements Function1<String, Unit> {
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
            Intrinsics3.checkNotNullExpressionValue(str, "filterString");
            Long longOrNull = StringNumberConversions.toLongOrNull(str);
            StoreGatewayConnection.requestGuildMembers$default(StoreStream.INSTANCE.getGatewaySocket(), WidgetServerSettingsMembers.access$getGuildId$p(WidgetServerSettingsMembers.this), str, longOrNull != null ? CollectionsJVM.listOf(Long.valueOf(longOrNull.longValue())) : null, null, 8, null);
        }
    }

    /* compiled from: WidgetServerSettingsMembers.kt */
    /* renamed from: com.discord.widgets.servers.settings.members.WidgetServerSettingsMembers$onViewBoundOrOnResume$3, reason: invalid class name */
    public static final class AnonymousClass3 extends Lambda implements Function1<WidgetServerSettingsMembersModel, Unit> {
        public AnonymousClass3() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(WidgetServerSettingsMembersModel widgetServerSettingsMembersModel) throws Exception {
            invoke2(widgetServerSettingsMembersModel);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(WidgetServerSettingsMembersModel widgetServerSettingsMembersModel) throws Exception {
            WidgetServerSettingsMembers.access$configureUI(WidgetServerSettingsMembers.this, widgetServerSettingsMembersModel);
        }
    }

    /* compiled from: WidgetServerSettingsMembers.kt */
    /* renamed from: com.discord.widgets.servers.settings.members.WidgetServerSettingsMembers$setupRolesSpinner$1, reason: invalid class name */
    public static final class AnonymousClass1 implements AdapterView.OnItemSelectedListener {
        public final /* synthetic */ RolesSpinnerAdapter $rolesSpinnerAdapter;

        public AnonymousClass1(RolesSpinnerAdapter rolesSpinnerAdapter) {
            this.$rolesSpinnerAdapter = rolesSpinnerAdapter;
        }

        @Override // android.widget.AdapterView.OnItemSelectedListener
        public void onItemSelected(AdapterView<?> parent, View view, int position, long id2) {
            Intrinsics3.checkNotNullParameter(view, "view");
            WidgetServerSettingsMembers.access$getRoleFilterPublisher$p(WidgetServerSettingsMembers.this).onNext(Long.valueOf(this.$rolesSpinnerAdapter.getItem(position).getId()));
        }

        @Override // android.widget.AdapterView.OnItemSelectedListener
        public void onNothingSelected(AdapterView<?> parent) {
        }
    }

    public WidgetServerSettingsMembers() {
        super(R.layout.widget_server_settings_members);
        this.binding = FragmentViewBindingDelegate3.viewBinding$default(this, WidgetServerSettingsMembers2.INSTANCE, null, 2, null);
        BehaviorSubject behaviorSubjectL0 = BehaviorSubject.l0("");
        Intrinsics3.checkNotNullExpressionValue(behaviorSubjectL0, "BehaviorSubject.create(\"\")");
        this.nameFilterPublisher = behaviorSubjectL0;
        BehaviorSubject behaviorSubjectL02 = BehaviorSubject.l0(-1L);
        Intrinsics3.checkNotNullExpressionValue(behaviorSubjectL02, "BehaviorSubject.create(-1L)");
        this.roleFilterPublisher = behaviorSubjectL02;
        this.guildId = LazyJVM.lazy(new WidgetServerSettingsMembers3(this));
        this.loggingConfig = new AppLogger2(false, null, WidgetServerSettingsMembers4.INSTANCE, 3);
    }

    public static final /* synthetic */ void access$configureUI(WidgetServerSettingsMembers widgetServerSettingsMembers, WidgetServerSettingsMembersModel widgetServerSettingsMembersModel) throws Exception {
        widgetServerSettingsMembers.configureUI(widgetServerSettingsMembersModel);
    }

    public static final /* synthetic */ WidgetServerSettingsMembersBinding access$getBinding$p(WidgetServerSettingsMembers widgetServerSettingsMembers) {
        return widgetServerSettingsMembers.getBinding();
    }

    public static final /* synthetic */ long access$getGuildId$p(WidgetServerSettingsMembers widgetServerSettingsMembers) {
        return widgetServerSettingsMembers.getGuildId();
    }

    public static final /* synthetic */ Subject access$getNameFilterPublisher$p(WidgetServerSettingsMembers widgetServerSettingsMembers) {
        return widgetServerSettingsMembers.nameFilterPublisher;
    }

    public static final /* synthetic */ Subject access$getRoleFilterPublisher$p(WidgetServerSettingsMembers widgetServerSettingsMembers) {
        return widgetServerSettingsMembers.roleFilterPublisher;
    }

    private final void configureUI(WidgetServerSettingsMembersModel model) throws Exception {
        if (model == null) {
            AppActivity appActivity = getAppActivity();
            if (appActivity != null) {
                appActivity.onBackPressed();
                return;
            }
            return;
        }
        AppFragment.setActionBarOptionsMenu$default(this, model.getCanKick() ? R.menu.menu_server_settings_members : R.menu.menu_empty, new AnonymousClass1(model), null, 4, null);
        setActionBarTitle(R.string.member_list);
        setActionBarSubtitle(model.getGuild().getName());
        AppViewFlipper appViewFlipper = getBinding().e;
        Intrinsics3.checkNotNullExpressionValue(appViewFlipper, "binding.serverSettingsMembersViewFlipper");
        appViewFlipper.setDisplayedChild((!model.getMemberItems().isEmpty() ? 1 : 0) ^ 1);
        if (!Intrinsics3.areEqual(this.guildRoles, model.getRoles())) {
            this.guildRoles = model.getRoles();
            setupRolesSpinner(model.getGuild().getId(), model.getRoles());
        }
        WidgetServerSettingsMembersAdapter widgetServerSettingsMembersAdapter = this.adapter;
        if (widgetServerSettingsMembersAdapter != null) {
            widgetServerSettingsMembersAdapter.configure(model, new AnonymousClass2(model));
        }
    }

    private final WidgetServerSettingsMembersBinding getBinding() {
        return (WidgetServerSettingsMembersBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    private final long getGuildId() {
        return ((Number) this.guildId.getValue()).longValue();
    }

    private final void setupRolesSpinner(long everyoneRoleId, Map<Long, GuildRole> guildRoles) {
        ArrayList arrayList = new ArrayList(guildRoles.size());
        for (GuildRole guildRole : guildRoles.values()) {
            if (guildRole.getId() != everyoneRoleId) {
                arrayList.add(guildRole);
            } else {
                arrayList.add(0, guildRole);
            }
        }
        RolesSpinnerAdapter rolesSpinnerAdapter = new RolesSpinnerAdapter(requireContext(), arrayList);
        Spinner spinner = getBinding().d;
        Intrinsics3.checkNotNullExpressionValue(spinner, "binding.serverSettingsMembersRolesSpinner");
        spinner.setAdapter((SpinnerAdapter) rolesSpinnerAdapter);
        Spinner spinner2 = getBinding().d;
        Intrinsics3.checkNotNullExpressionValue(spinner2, "binding.serverSettingsMembersRolesSpinner");
        spinner2.setOnItemSelectedListener(new AnonymousClass1(rolesSpinnerAdapter));
    }

    @Override // com.discord.app.AppFragment, com.discord.app.AppLogger.a
    public AppLogger2 getLoggingConfig() {
        return this.loggingConfig;
    }

    @Override // com.discord.app.AppFragment
    public void onViewBound(View view) {
        Intrinsics3.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        AppFragment.setActionBarDisplayHomeAsUpEnabled$default(this, false, 1, null);
        MGRecyclerAdapter.Companion companion = MGRecyclerAdapter.INSTANCE;
        RecyclerView recyclerView = getBinding().c;
        Intrinsics3.checkNotNullExpressionValue(recyclerView, "binding.serverSettingsMembersRecycler");
        this.adapter = (WidgetServerSettingsMembersAdapter) companion.configure(new WidgetServerSettingsMembersAdapter(recyclerView));
        if (getIsRecreated()) {
            return;
        }
        this.roleFilterPublisher.onNext(Long.valueOf(getGuildId()));
    }

    @Override // com.discord.app.AppFragment
    public void onViewBoundOrOnResume() {
        super.onViewBoundOrOnResume();
        TextWatcher.Companion companion = TextWatcher.INSTANCE;
        TextInputLayout textInputLayout = getBinding().f2579b;
        Intrinsics3.checkNotNullExpressionValue(textInputLayout, "binding.serverSettingsMembersNameSearch");
        EditText editText = textInputLayout.getEditText();
        Intrinsics3.checkNotNull(editText);
        Intrinsics3.checkNotNullExpressionValue(editText, "binding.serverSettingsMembersNameSearch.editText!!");
        companion.addBindedTextWatcher(this, editText, new AnonymousClass1());
        Subject<String, String> subject = this.nameFilterPublisher;
        TextInputLayout textInputLayout2 = getBinding().f2579b;
        Intrinsics3.checkNotNullExpressionValue(textInputLayout2, "binding.serverSettingsMembersNameSearch");
        EditText editText2 = textInputLayout2.getEditText();
        subject.onNext(String.valueOf(editText2 != null ? editText2.getText() : null));
        Observable<String> observableP = this.nameFilterPublisher.p(750L, TimeUnit.MILLISECONDS);
        Intrinsics3.checkNotNullExpressionValue(observableP, "nameFilterPublisher\n    …0, TimeUnit.MILLISECONDS)");
        ObservableExtensionsKt.appSubscribe$default(observableP, WidgetServerSettingsMembers.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass2(), 62, (Object) null);
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(WidgetServerSettingsMembersModel.INSTANCE.get(getGuildId(), this.nameFilterPublisher, this.roleFilterPublisher), this, null, 2, null), WidgetServerSettingsMembers.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass3(), 62, (Object) null);
    }
}
