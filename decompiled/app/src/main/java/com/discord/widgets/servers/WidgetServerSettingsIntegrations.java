package com.discord.widgets.servers;

import a0.a.a.b;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.ViewGroup;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import b.a.d.AppScreen2;
import b.d.b.a.outline;
import com.discord.R;
import com.discord.app.AppFragment;
import com.discord.app.AppLogger2;
import com.discord.app.AppViewFlipper;
import com.discord.databinding.WidgetServerSettingsIntegrationsBinding;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.models.domain.ModelGuildIntegration;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreUser;
import com.discord.utilities.mg_recycler.MGRecyclerAdapter;
import com.discord.utilities.mg_recycler.MGRecyclerAdapterSimple;
import com.discord.utilities.mg_recycler.MGRecyclerDataPayload;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate3;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;
import rx.Observable;

/* compiled from: WidgetServerSettingsIntegrations.kt */
/* loaded from: classes2.dex */
public final class WidgetServerSettingsIntegrations extends AppFragment {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {outline.d0(WidgetServerSettingsIntegrations.class, "binding", "getBinding()Lcom/discord/databinding/WidgetServerSettingsIntegrationsBinding;", 0)};

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String INTENT_EXTRA_GUILD_ID = "INTENT_EXTRA_GUILD_ID";
    private static final int VIEW_INDEX_INTEGRATION_LIST = 0;
    private static final int VIEW_INDEX_NO_INTEGRATIONS = 1;
    private Adapter adapter;

    /* renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;
    private final AppLogger2 loggingConfig;

    /* compiled from: WidgetServerSettingsIntegrations.kt */
    public static final class Adapter extends MGRecyclerAdapterSimple<Model.IntegrationItem> {
        private Function1<? super Long, Unit> onIntegrationSelectedListener;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Adapter(RecyclerView recyclerView) {
            super(recyclerView, false, 2, null);
            Intrinsics3.checkNotNullParameter(recyclerView, "recycler");
        }

        public final void configure(List<Model.IntegrationItem> data, Function1<? super Long, Unit> onIntegrationSelectedListener) {
            Intrinsics3.checkNotNullParameter(data, "data");
            this.onIntegrationSelectedListener = onIntegrationSelectedListener;
            setData(data);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public /* bridge */ /* synthetic */ RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
            return onCreateViewHolder(viewGroup, i);
        }

        public final void onIntegrationSelected(long id2) {
            Function1<? super Long, Unit> function1 = this.onIntegrationSelectedListener;
            if (function1 != null) {
                function1.invoke(Long.valueOf(id2));
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public WidgetServerSettingsIntegrationsListItem onCreateViewHolder(ViewGroup parent, int viewType) {
            Intrinsics3.checkNotNullParameter(parent, "parent");
            if (viewType == 0) {
                return new WidgetServerSettingsIntegrationsListItem(this);
            }
            throw invalidViewTypeException(viewType);
        }
    }

    /* compiled from: WidgetServerSettingsIntegrations.kt */
    public static final class Companion {
        private Companion() {
        }

        public final void create(Context context, long guildId) {
            Intrinsics3.checkNotNullParameter(context, "context");
            StoreStream.INSTANCE.getAnalytics().onGuildSettingsPaneViewed("INTEGRATIONS", guildId);
            Intent intentPutExtra = new Intent().putExtra("INTENT_EXTRA_GUILD_ID", guildId);
            Intrinsics3.checkNotNullExpressionValue(intentPutExtra, "Intent()\n          .putE…_EXTRA_GUILD_ID, guildId)");
            AppScreen2.d(context, WidgetServerSettingsIntegrations.class, intentPutExtra);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: WidgetServerSettingsIntegrations.kt */
    public static final /* data */ class Model {

        /* renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private final long guildId;
        private final String guildName;
        private final List<IntegrationItem> integrations;

        /* compiled from: WidgetServerSettingsIntegrations.kt */
        public static final class Companion {
            private Companion() {
            }

            public final Observable<Model> get(long guildId) {
                StoreStream.Companion companion = StoreStream.INSTANCE;
                Observable observableG = Observable.g(companion.getGuildIntegrations().get(guildId), StoreUser.observeMe$default(companion.getUsers(), false, 1, null), companion.getPermissions().observePermissionsForGuild(guildId), companion.getGuilds().observeGuild(guildId), companion.getGuilds().observeRoles(guildId), WidgetServerSettingsIntegrations2.INSTANCE);
                Intrinsics3.checkNotNullExpressionValue(observableG, "Observable\n             …        }\n              }");
                Observable<Model> observableR = ObservableExtensionsKt.computationLatest(observableG).r();
                Intrinsics3.checkNotNullExpressionValue(observableR, "Observable\n             …  .distinctUntilChanged()");
                return observableR;
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        /* compiled from: WidgetServerSettingsIntegrations.kt */
        public static final /* data */ class IntegrationItem implements MGRecyclerDataPayload {
            public static final int TYPE_INTEGRATION = 0;
            private final long guildId;
            private final ModelGuildIntegration integration;
            private final String key;
            private final int type;

            public IntegrationItem(ModelGuildIntegration modelGuildIntegration, long j) {
                Intrinsics3.checkNotNullParameter(modelGuildIntegration, "integration");
                this.integration = modelGuildIntegration;
                this.guildId = j;
                this.key = String.valueOf(modelGuildIntegration.getId());
            }

            public static /* synthetic */ IntegrationItem copy$default(IntegrationItem integrationItem, ModelGuildIntegration modelGuildIntegration, long j, int i, Object obj) {
                if ((i & 1) != 0) {
                    modelGuildIntegration = integrationItem.integration;
                }
                if ((i & 2) != 0) {
                    j = integrationItem.guildId;
                }
                return integrationItem.copy(modelGuildIntegration, j);
            }

            /* renamed from: component1, reason: from getter */
            public final ModelGuildIntegration getIntegration() {
                return this.integration;
            }

            /* renamed from: component2, reason: from getter */
            public final long getGuildId() {
                return this.guildId;
            }

            public final IntegrationItem copy(ModelGuildIntegration integration, long guildId) {
                Intrinsics3.checkNotNullParameter(integration, "integration");
                return new IntegrationItem(integration, guildId);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof IntegrationItem)) {
                    return false;
                }
                IntegrationItem integrationItem = (IntegrationItem) other;
                return Intrinsics3.areEqual(this.integration, integrationItem.integration) && this.guildId == integrationItem.guildId;
            }

            public final long getGuildId() {
                return this.guildId;
            }

            public final ModelGuildIntegration getIntegration() {
                return this.integration;
            }

            @Override // com.discord.utilities.mg_recycler.MGRecyclerDataPayload, com.discord.utilities.recycler.DiffKeyProvider
            public String getKey() {
                return this.key;
            }

            @Override // com.discord.utilities.mg_recycler.MGRecyclerDataPayload
            public int getType() {
                return this.type;
            }

            public int hashCode() {
                ModelGuildIntegration modelGuildIntegration = this.integration;
                return b.a(this.guildId) + ((modelGuildIntegration != null ? modelGuildIntegration.hashCode() : 0) * 31);
            }

            public String toString() {
                StringBuilder sbU = outline.U("IntegrationItem(integration=");
                sbU.append(this.integration);
                sbU.append(", guildId=");
                return outline.C(sbU, this.guildId, ")");
            }
        }

        public Model(long j, String str, List<IntegrationItem> list) {
            Intrinsics3.checkNotNullParameter(str, "guildName");
            Intrinsics3.checkNotNullParameter(list, "integrations");
            this.guildId = j;
            this.guildName = str;
            this.integrations = list;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ Model copy$default(Model model, long j, String str, List list, int i, Object obj) {
            if ((i & 1) != 0) {
                j = model.guildId;
            }
            if ((i & 2) != 0) {
                str = model.guildName;
            }
            if ((i & 4) != 0) {
                list = model.integrations;
            }
            return model.copy(j, str, list);
        }

        /* renamed from: component1, reason: from getter */
        public final long getGuildId() {
            return this.guildId;
        }

        /* renamed from: component2, reason: from getter */
        public final String getGuildName() {
            return this.guildName;
        }

        public final List<IntegrationItem> component3() {
            return this.integrations;
        }

        public final Model copy(long guildId, String guildName, List<IntegrationItem> integrations) {
            Intrinsics3.checkNotNullParameter(guildName, "guildName");
            Intrinsics3.checkNotNullParameter(integrations, "integrations");
            return new Model(guildId, guildName, integrations);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Model)) {
                return false;
            }
            Model model = (Model) other;
            return this.guildId == model.guildId && Intrinsics3.areEqual(this.guildName, model.guildName) && Intrinsics3.areEqual(this.integrations, model.integrations);
        }

        public final long getGuildId() {
            return this.guildId;
        }

        public final String getGuildName() {
            return this.guildName;
        }

        public final List<IntegrationItem> getIntegrations() {
            return this.integrations;
        }

        public int hashCode() {
            int iA = b.a(this.guildId) * 31;
            String str = this.guildName;
            int iHashCode = (iA + (str != null ? str.hashCode() : 0)) * 31;
            List<IntegrationItem> list = this.integrations;
            return iHashCode + (list != null ? list.hashCode() : 0);
        }

        public String toString() {
            StringBuilder sbU = outline.U("Model(guildId=");
            sbU.append(this.guildId);
            sbU.append(", guildName=");
            sbU.append(this.guildName);
            sbU.append(", integrations=");
            return outline.L(sbU, this.integrations, ")");
        }
    }

    /* compiled from: WidgetServerSettingsIntegrations.kt */
    /* renamed from: com.discord.widgets.servers.WidgetServerSettingsIntegrations$configureUI$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function1<Long, Unit> {
        public final /* synthetic */ Model $model;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(Model model) {
            super(1);
            this.$model = model;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Long l) {
            invoke(l.longValue());
            return Unit.a;
        }

        public final void invoke(long j) {
            WidgetServerSettingsEditIntegration.INSTANCE.launch(this.$model.getGuildId(), j, WidgetServerSettingsIntegrations.this.requireContext());
        }
    }

    /* compiled from: WidgetServerSettingsIntegrations.kt */
    /* renamed from: com.discord.widgets.servers.WidgetServerSettingsIntegrations$onResume$1, reason: invalid class name */
    public static final /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function1<Model, Unit> {
        public AnonymousClass1(WidgetServerSettingsIntegrations widgetServerSettingsIntegrations) {
            super(1, widgetServerSettingsIntegrations, WidgetServerSettingsIntegrations.class, "configureUI", "configureUI(Lcom/discord/widgets/servers/WidgetServerSettingsIntegrations$Model;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Model model) {
            invoke2(model);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Model model) {
            WidgetServerSettingsIntegrations.access$configureUI((WidgetServerSettingsIntegrations) this.receiver, model);
        }
    }

    public WidgetServerSettingsIntegrations() {
        super(R.layout.widget_server_settings_integrations);
        this.binding = FragmentViewBindingDelegate3.viewBinding$default(this, WidgetServerSettingsIntegrations3.INSTANCE, null, 2, null);
        this.loggingConfig = new AppLogger2(false, null, WidgetServerSettingsIntegrations4.INSTANCE, 3);
    }

    public static final /* synthetic */ void access$configureUI(WidgetServerSettingsIntegrations widgetServerSettingsIntegrations, Model model) {
        widgetServerSettingsIntegrations.configureUI(model);
    }

    private final void configureUI(Model model) {
        if (model == null) {
            return;
        }
        setActionBarTitle(R.string.integrations);
        setActionBarSubtitle(model.getGuildName());
        AppViewFlipper appViewFlipper = getBinding().c;
        Intrinsics3.checkNotNullExpressionValue(appViewFlipper, "binding.integrationsViewFlipper");
        appViewFlipper.setDisplayedChild(model.getIntegrations().isEmpty() ? 1 : 0);
        Adapter adapter = this.adapter;
        if (adapter != null) {
            adapter.configure(model.getIntegrations(), new AnonymousClass1(model));
        }
    }

    public static final void create(Context context, long j) {
        INSTANCE.create(context, j);
    }

    private final WidgetServerSettingsIntegrationsBinding getBinding() {
        return (WidgetServerSettingsIntegrationsBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    @Override // com.discord.app.AppFragment, com.discord.app.AppLogger.a
    public AppLogger2 getLoggingConfig() {
        return this.loggingConfig;
    }

    @Override // com.discord.app.AppFragment, androidx.fragment.app.Fragment
    public void onPause() {
        StoreStream.INSTANCE.getGuildIntegrations().onIntegrationScreenClosed();
        super.onPause();
    }

    @Override // com.discord.app.AppFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        long longExtra = getMostRecentIntent().getLongExtra("INTENT_EXTRA_GUILD_ID", -1L);
        StoreStream.INSTANCE.getGuildIntegrations().onIntegrationScreenOpened(longExtra);
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(Model.INSTANCE.get(longExtra), this, null, 2, null), WidgetServerSettingsIntegrations.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass1(this), 62, (Object) null);
    }

    @Override // com.discord.app.AppFragment
    public void onViewBound(View view) {
        Intrinsics3.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        AppFragment.setActionBarDisplayHomeAsUpEnabled$default(this, false, 1, null);
        MGRecyclerAdapter.Companion companion = MGRecyclerAdapter.INSTANCE;
        RecyclerView recyclerView = getBinding().f2577b;
        Intrinsics3.checkNotNullExpressionValue(recyclerView, "binding.integrationsRecycler");
        this.adapter = (Adapter) companion.configure(new Adapter(recyclerView));
    }
}
