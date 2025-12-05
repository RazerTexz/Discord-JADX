package com.discord.widgets.servers;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import androidx.core.app.NotificationCompat;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.RecyclerView;
import com.discord.C5419R;
import com.discord.api.role.GuildRole;
import com.discord.app.AppActivity;
import com.discord.app.AppFragment;
import com.discord.app.AppLogger2;
import com.discord.databinding.WidgetServerSettingsRolesBinding;
import com.discord.restapi.RestAPIParams;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreUser;
import com.discord.utilities.error.Error;
import com.discord.utilities.mg_recycler.DragAndDropAdapter;
import com.discord.utilities.mg_recycler.DragAndDropHelper;
import com.discord.utilities.mg_recycler.MGRecyclerAdapter;
import com.discord.utilities.p501rx.ObservableExtensionsKt;
import com.discord.utilities.rest.RestAPI;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate3;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Lazy;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;
import p001a0.p002a.p003a.C0002b;
import p007b.p008a.p018d.AppScreen2;
import p007b.p008a.p018d.AppToast;
import p007b.p100d.p104b.p105a.outline;
import p507d0.LazyJVM;
import p507d0.p580t.CollectionsJVM;
import p507d0.p592z.p594d.FunctionReferenceImpl;
import p507d0.p592z.p594d.Intrinsics3;
import p507d0.p592z.p594d.Lambda;
import p637j0.p641k.Func1;
import p658rx.Observable;

/* compiled from: WidgetServerSettingsRoles.kt */
/* loaded from: classes2.dex */
public final class WidgetServerSettingsRoles extends AppFragment {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {outline.m846d0(WidgetServerSettingsRoles.class, "binding", "getBinding()Lcom/discord/databinding/WidgetServerSettingsRolesBinding;", 0)};

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String INTENT_EXTRA_GUILD_ID = "INTENT_EXTRA_GUILD_ID";
    private WidgetServerSettingsRolesAdapter adapter;

    /* renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;

    /* renamed from: guildId$delegate, reason: from kotlin metadata */
    private final Lazy guildId;
    private ItemTouchHelper itemTouchHelper;
    private final AppLogger2 loggingConfig;

    /* compiled from: WidgetServerSettingsRoles.kt */
    public static final class Companion {
        private Companion() {
        }

        public final void create(Context context, long guildId) {
            Intrinsics3.checkNotNullParameter(context, "context");
            StoreStream.INSTANCE.getAnalytics().onGuildSettingsPaneViewed("ROLES", guildId);
            Intent intentPutExtra = new Intent().putExtra("INTENT_EXTRA_GUILD_ID", guildId);
            Intrinsics3.checkNotNullExpressionValue(intentPutExtra, "Intent()\n          .putE…_EXTRA_GUILD_ID, guildId)");
            AppScreen2.m156d(context, WidgetServerSettingsRoles.class, intentPutExtra);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: WidgetServerSettingsRoles.kt */
    public static final /* data */ class Model {

        /* renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private final boolean canManageRoles;
        private final boolean elevated;
        private final long guildId;
        private final String guildName;
        private final List<DragAndDropAdapter.Payload> roleItems;

        /* compiled from: WidgetServerSettingsRoles.kt */
        public static final class Companion {
            private Companion() {
            }

            public final Observable<Model> get(long guildId) {
                Observable<Model> observableM11112r = StoreUser.observeMe$default(StoreStream.INSTANCE.getUsers(), false, 1, null).m11099Y(new WidgetServerSettingsRoles2(guildId)).m11112r();
                Intrinsics3.checkNotNullExpressionValue(observableM11112r, "StoreStream\n            …  .distinctUntilChanged()");
                return observableM11112r;
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        public Model(long j, String str, boolean z2, boolean z3, List<? extends DragAndDropAdapter.Payload> list) {
            Intrinsics3.checkNotNullParameter(list, "roleItems");
            this.guildId = j;
            this.guildName = str;
            this.canManageRoles = z2;
            this.elevated = z3;
            this.roleItems = list;
        }

        public static /* synthetic */ Model copy$default(Model model, long j, String str, boolean z2, boolean z3, List list, int i, Object obj) {
            if ((i & 1) != 0) {
                j = model.guildId;
            }
            long j2 = j;
            if ((i & 2) != 0) {
                str = model.guildName;
            }
            String str2 = str;
            if ((i & 4) != 0) {
                z2 = model.canManageRoles;
            }
            boolean z4 = z2;
            if ((i & 8) != 0) {
                z3 = model.elevated;
            }
            boolean z5 = z3;
            if ((i & 16) != 0) {
                list = model.roleItems;
            }
            return model.copy(j2, str2, z4, z5, list);
        }

        /* renamed from: component1, reason: from getter */
        public final long getGuildId() {
            return this.guildId;
        }

        /* renamed from: component2, reason: from getter */
        public final String getGuildName() {
            return this.guildName;
        }

        /* renamed from: component3, reason: from getter */
        public final boolean getCanManageRoles() {
            return this.canManageRoles;
        }

        /* renamed from: component4, reason: from getter */
        public final boolean getElevated() {
            return this.elevated;
        }

        public final List<DragAndDropAdapter.Payload> component5() {
            return this.roleItems;
        }

        public final Model copy(long guildId, String guildName, boolean canManageRoles, boolean elevated, List<? extends DragAndDropAdapter.Payload> roleItems) {
            Intrinsics3.checkNotNullParameter(roleItems, "roleItems");
            return new Model(guildId, guildName, canManageRoles, elevated, roleItems);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Model)) {
                return false;
            }
            Model model = (Model) other;
            return this.guildId == model.guildId && Intrinsics3.areEqual(this.guildName, model.guildName) && this.canManageRoles == model.canManageRoles && this.elevated == model.elevated && Intrinsics3.areEqual(this.roleItems, model.roleItems);
        }

        public final boolean getCanManageRoles() {
            return this.canManageRoles;
        }

        public final boolean getElevated() {
            return this.elevated;
        }

        public final long getGuildId() {
            return this.guildId;
        }

        public final String getGuildName() {
            return this.guildName;
        }

        public final List<DragAndDropAdapter.Payload> getRoleItems() {
            return this.roleItems;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public int hashCode() {
            int iM3a = C0002b.m3a(this.guildId) * 31;
            String str = this.guildName;
            int iHashCode = (iM3a + (str != null ? str.hashCode() : 0)) * 31;
            boolean z2 = this.canManageRoles;
            int i = z2;
            if (z2 != 0) {
                i = 1;
            }
            int i2 = (iHashCode + i) * 31;
            boolean z3 = this.elevated;
            int i3 = (i2 + (z3 ? 1 : z3 ? 1 : 0)) * 31;
            List<DragAndDropAdapter.Payload> list = this.roleItems;
            return i3 + (list != null ? list.hashCode() : 0);
        }

        public String toString() {
            StringBuilder sbM833U = outline.m833U("Model(guildId=");
            sbM833U.append(this.guildId);
            sbM833U.append(", guildName=");
            sbM833U.append(this.guildName);
            sbM833U.append(", canManageRoles=");
            sbM833U.append(this.canManageRoles);
            sbM833U.append(", elevated=");
            sbM833U.append(this.elevated);
            sbM833U.append(", roleItems=");
            return outline.m824L(sbM833U, this.roleItems, ")");
        }
    }

    /* compiled from: WidgetServerSettingsRoles.kt */
    /* renamed from: com.discord.widgets.servers.WidgetServerSettingsRoles$configureUI$1 */
    public static final class C93001 extends Lambda implements Function1<GuildRole, Unit> {
        public final /* synthetic */ Model $data;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C93001(Model model) {
            super(1);
            this.$data = model;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(GuildRole guildRole) {
            invoke2(guildRole);
            return Unit.f27425a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(GuildRole guildRole) {
            Intrinsics3.checkNotNullParameter(guildRole, "<name for destructuring parameter 0>");
            WidgetServerSettingsEditRole.INSTANCE.launch(this.$data.getGuildId(), guildRole.getId(), WidgetServerSettingsRoles.this.requireContext());
        }
    }

    /* compiled from: WidgetServerSettingsRoles.kt */
    /* renamed from: com.discord.widgets.servers.WidgetServerSettingsRoles$configureUI$2 */
    public static final class C93012 extends Lambda implements Function1<Map<String, ? extends Integer>, Unit> {
        public final /* synthetic */ Model $data;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C93012(Model model) {
            super(1);
            this.$data = model;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Map<String, ? extends Integer> map) {
            invoke2((Map<String, Integer>) map);
            return Unit.f27425a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Map<String, Integer> map) {
            Intrinsics3.checkNotNullParameter(map, "newPositions");
            WidgetServerSettingsRoles.access$processRoleDrop(WidgetServerSettingsRoles.this, map, this.$data);
        }
    }

    /* compiled from: WidgetServerSettingsRoles.kt */
    /* renamed from: com.discord.widgets.servers.WidgetServerSettingsRoles$configureUI$3 */
    public static final class ViewOnClickListenerC93023 implements View.OnClickListener {
        public final /* synthetic */ Model $data;

        public ViewOnClickListenerC93023(Model model) {
            this.$data = model;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetServerSettingsRoles.access$createRole(WidgetServerSettingsRoles.this, this.$data.getGuildId(), this.$data);
        }
    }

    /* compiled from: WidgetServerSettingsRoles.kt */
    /* renamed from: com.discord.widgets.servers.WidgetServerSettingsRoles$createRole$1 */
    public static final class C93031<T, R> implements Func1<GuildRole, Observable<? extends GuildRole>> {
        public final /* synthetic */ long $guildId;

        /* compiled from: WidgetServerSettingsRoles.kt */
        /* renamed from: com.discord.widgets.servers.WidgetServerSettingsRoles$createRole$1$1, reason: invalid class name */
        public static final class AnonymousClass1<T, R> implements Func1<Map<Long, ? extends GuildRole>, GuildRole> {
            public final /* synthetic */ long $id;

            public AnonymousClass1(long j) {
                this.$id = j;
            }

            @Override // p637j0.p641k.Func1
            public /* bridge */ /* synthetic */ GuildRole call(Map<Long, ? extends GuildRole> map) {
                return call2((Map<Long, GuildRole>) map);
            }

            /* renamed from: call, reason: avoid collision after fix types in other method */
            public final GuildRole call2(Map<Long, GuildRole> map) {
                return map.get(Long.valueOf(this.$id));
            }
        }

        public C93031(long j) {
            this.$guildId = j;
        }

        @Override // p637j0.p641k.Func1
        public /* bridge */ /* synthetic */ Observable<? extends GuildRole> call(GuildRole guildRole) {
            return call2(guildRole);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final Observable<? extends GuildRole> call2(GuildRole guildRole) {
            long id2 = guildRole.getId();
            return StoreStream.INSTANCE.getGuilds().observeRoles(this.$guildId, CollectionsJVM.listOf(Long.valueOf(id2))).m11083G(new AnonymousClass1(id2));
        }
    }

    /* compiled from: WidgetServerSettingsRoles.kt */
    /* renamed from: com.discord.widgets.servers.WidgetServerSettingsRoles$createRole$2 */
    public static final class C93042 extends Lambda implements Function1<GuildRole, Unit> {
        public final /* synthetic */ Model $dataSnapshot;
        public final /* synthetic */ long $guildId;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C93042(long j, Model model) {
            super(1);
            this.$guildId = j;
            this.$dataSnapshot = model;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(GuildRole guildRole) throws Exception {
            invoke2(guildRole);
            return Unit.f27425a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(GuildRole guildRole) throws Exception {
            if (guildRole != null) {
                WidgetServerSettingsEditRole.INSTANCE.launch(this.$guildId, guildRole.getId(), WidgetServerSettingsRoles.this.requireContext());
            } else {
                WidgetServerSettingsRoles.access$configureUI(WidgetServerSettingsRoles.this, this.$dataSnapshot);
            }
        }
    }

    /* compiled from: WidgetServerSettingsRoles.kt */
    /* renamed from: com.discord.widgets.servers.WidgetServerSettingsRoles$onViewBoundOrOnResume$1 */
    public static final /* synthetic */ class C93051 extends FunctionReferenceImpl implements Function1<Model, Unit> {
        public C93051(WidgetServerSettingsRoles widgetServerSettingsRoles) {
            super(1, widgetServerSettingsRoles, WidgetServerSettingsRoles.class, "configureUI", "configureUI(Lcom/discord/widgets/servers/WidgetServerSettingsRoles$Model;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Model model) throws Exception {
            invoke2(model);
            return Unit.f27425a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Model model) throws Exception {
            WidgetServerSettingsRoles.access$configureUI((WidgetServerSettingsRoles) this.receiver, model);
        }
    }

    /* compiled from: WidgetServerSettingsRoles.kt */
    /* renamed from: com.discord.widgets.servers.WidgetServerSettingsRoles$processRoleDrop$1 */
    public static final class C93061 extends Lambda implements Function1<Void, Unit> {
        public C93061() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Void r1) {
            invoke2(r1);
            return Unit.f27425a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Void r4) {
            AppToast.m171i(WidgetServerSettingsRoles.this, C5419R.string.role_order_updated, 0, 4);
        }
    }

    /* compiled from: WidgetServerSettingsRoles.kt */
    /* renamed from: com.discord.widgets.servers.WidgetServerSettingsRoles$processRoleDrop$2 */
    public static final class C93072 extends Lambda implements Function1<Error, Unit> {
        public final /* synthetic */ Model $dataSnapshot;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C93072(Model model) {
            super(1);
            this.$dataSnapshot = model;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Error error) throws Exception {
            invoke2(error);
            return Unit.f27425a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Error error) throws Exception {
            Intrinsics3.checkNotNullParameter(error, "it");
            WidgetServerSettingsRoles.access$configureUI(WidgetServerSettingsRoles.this, this.$dataSnapshot);
        }
    }

    public WidgetServerSettingsRoles() {
        super(C5419R.layout.widget_server_settings_roles);
        this.binding = FragmentViewBindingDelegate3.viewBinding$default(this, WidgetServerSettingsRoles3.INSTANCE, null, 2, null);
        this.guildId = LazyJVM.lazy(new WidgetServerSettingsRoles4(this));
        this.loggingConfig = new AppLogger2(false, null, WidgetServerSettingsRoles5.INSTANCE, 3);
    }

    public static final /* synthetic */ void access$configureUI(WidgetServerSettingsRoles widgetServerSettingsRoles, Model model) throws Exception {
        widgetServerSettingsRoles.configureUI(model);
    }

    public static final /* synthetic */ void access$createRole(WidgetServerSettingsRoles widgetServerSettingsRoles, long j, Model model) {
        widgetServerSettingsRoles.createRole(j, model);
    }

    public static final /* synthetic */ void access$processRoleDrop(WidgetServerSettingsRoles widgetServerSettingsRoles, Map map, Model model) {
        widgetServerSettingsRoles.processRoleDrop(map, model);
    }

    private final void configureUI(Model data) throws Exception {
        if ((data != null ? data.getRoleItems() : null) == null || data.getRoleItems().isEmpty()) {
            AppActivity appActivity = getAppActivity();
            if (appActivity != null) {
                appActivity.onBackPressed();
                return;
            }
            return;
        }
        setActionBarTitle(C5419R.string.roles);
        setActionBarSubtitle(data.getGuildName());
        WidgetServerSettingsRolesAdapter widgetServerSettingsRolesAdapter = this.adapter;
        if (widgetServerSettingsRolesAdapter != null) {
            widgetServerSettingsRolesAdapter.configure(data.getRoleItems(), new C93001(data), new C93012(data));
        }
        if (data.getCanManageRoles() && data.getElevated()) {
            getBinding().f17750c.setOnClickListener(new ViewOnClickListenerC93023(data));
            getBinding().f17750c.show();
        } else {
            getBinding().f17750c.hide();
            getBinding().f17750c.setOnClickListener(null);
        }
    }

    private final void createRole(long guildId, Model dataSnapshot) {
        Observable observableM11099Y = ObservableExtensionsKt.restSubscribeOn$default(RestAPI.INSTANCE.getApi().createRole(guildId), false, 1, null).m11099Y(new C93031(guildId));
        Intrinsics3.checkNotNullExpressionValue(observableM11099Y, "RestAPI\n        .api\n   … rolesMap[id] }\n        }");
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.takeSingleUntilTimeout$default(observableM11099Y, 0L, false, 3, null), this, null, 2, null), WidgetServerSettingsRoles.class, getContext(), (Function1) null, (Function1) null, (Function0) null, (Function0) null, new C93042(guildId, dataSnapshot), 60, (Object) null);
    }

    private final WidgetServerSettingsRolesBinding getBinding() {
        return (WidgetServerSettingsRolesBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    private final long getGuildId() {
        return ((Number) this.guildId.getValue()).longValue();
    }

    private final void processRoleDrop(Map<String, Integer> newPositions, Model dataSnapshot) {
        Set<String> setKeySet = newPositions.keySet();
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = setKeySet.iterator();
        while (true) {
            RestAPIParams.Role roleCreateForPosition = null;
            if (!it.hasNext()) {
                ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.withDimmer$default(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.restSubscribeOn$default(RestAPI.INSTANCE.getApi().batchUpdateRole(dataSnapshot.getGuildId(), arrayList), false, 1, null), this, null, 2, null), getBinding().f17749b, 0L, 2, null), WidgetServerSettingsRoles.class, getContext(), (Function1) null, new C93072(dataSnapshot), (Function0) null, (Function0) null, new C93061(), 52, (Object) null);
                return;
            }
            String str = (String) it.next();
            Integer num = newPositions.get(str);
            if (num != null) {
                roleCreateForPosition = RestAPIParams.Role.INSTANCE.createForPosition(Long.parseLong(str), num.intValue());
            }
            if (roleCreateForPosition != null) {
                arrayList.add(roleCreateForPosition);
            }
        }
    }

    @Override // com.discord.app.AppFragment, com.discord.app.AppLogger.InterfaceC5455a
    public AppLogger2 getLoggingConfig() {
        return this.loggingConfig;
    }

    @Override // com.discord.app.AppFragment
    public void onViewBound(View view) {
        Intrinsics3.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        AppFragment.setActionBarDisplayHomeAsUpEnabled$default(this, false, 1, null);
        MGRecyclerAdapter.Companion companion = MGRecyclerAdapter.INSTANCE;
        RecyclerView recyclerView = getBinding().f17751d;
        Intrinsics3.checkNotNullExpressionValue(recyclerView, "binding.serverSettingsRolesRecycler");
        this.adapter = (WidgetServerSettingsRolesAdapter) companion.configure(new WidgetServerSettingsRolesAdapter(recyclerView));
        ItemTouchHelper itemTouchHelper = this.itemTouchHelper;
        if (itemTouchHelper != null && itemTouchHelper != null) {
            itemTouchHelper.attachToRecyclerView(null);
        }
        WidgetServerSettingsRolesAdapter widgetServerSettingsRolesAdapter = this.adapter;
        Intrinsics3.checkNotNull(widgetServerSettingsRolesAdapter);
        ItemTouchHelper itemTouchHelper2 = new ItemTouchHelper(new DragAndDropHelper(widgetServerSettingsRolesAdapter, 0, 2, null));
        this.itemTouchHelper = itemTouchHelper2;
        if (itemTouchHelper2 != null) {
            itemTouchHelper2.attachToRecyclerView(getBinding().f17751d);
        }
    }

    @Override // com.discord.app.AppFragment
    public void onViewBoundOrOnResume() {
        super.onViewBoundOrOnResume();
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.computationLatest(Model.INSTANCE.get(getGuildId())), this, null, 2, null), WidgetServerSettingsRoles.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new C93051(this), 62, (Object) null);
    }
}
