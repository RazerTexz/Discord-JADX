package com.discord.widgets.settings.connections;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.LayoutRes;
import androidx.cardview.widget.CardView;
import androidx.core.app.NotificationCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.recyclerview.widget.RecyclerView;
import b.a.d.g0;
import b.a.d.i0;
import b.a.d.j;
import b.a.k.b;
import b.d.b.a.a;
import com.discord.R;
import com.discord.api.activity.ActivityType;
import com.discord.api.connectedaccounts.ConnectedAccount;
import com.discord.api.connectedaccounts.ConnectedAccountIntegration;
import com.discord.app.AppFragment;
import com.discord.databinding.WidgetSettingsConnectionsBinding;
import com.discord.databinding.WidgetSettingsItemConnectedAccountBinding;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreUserConnections;
import com.discord.stores.StoreUserPresence;
import com.discord.utilities.drawable.DrawableCompat;
import com.discord.utilities.mg_recycler.MGRecyclerAdapter;
import com.discord.utilities.mg_recycler.MGRecyclerAdapterSimple;
import com.discord.utilities.mg_recycler.MGRecyclerDataPayload;
import com.discord.utilities.mg_recycler.MGRecyclerViewHolder;
import com.discord.utilities.platform.Platform;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegateKt;
import com.discord.widgets.settings.connections.WidgetSettingsUserConnectionsViewModel;
import com.google.android.material.switchmaterial.SwitchMaterial;
import d0.g0.t;
import d0.z.d.a0;
import d0.z.d.m;
import d0.z.d.o;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;
import rx.functions.Action2;

/* compiled from: WidgetSettingsUserConnections.kt */
/* loaded from: classes2.dex */
public final class WidgetSettingsUserConnections extends AppFragment {
    public static final String CONNECTION_ID = "connection_id";
    public static final String PLATFORM_NAME = "platform_name";
    public static final String PLATFORM_TITLE = "platform_title";
    private Adapter adapter;

    /* renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;

    /* renamed from: viewModel$delegate, reason: from kotlin metadata */
    private final Lazy viewModel;
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {a.d0(WidgetSettingsUserConnections.class, "binding", "getBinding()Lcom/discord/databinding/WidgetSettingsConnectionsBinding;", 0)};

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* compiled from: WidgetSettingsUserConnections.kt */
    public static final class Adapter extends MGRecyclerAdapterSimple<UserConnectionItem> {
        private final FragmentManager fragmentManager;
        private final Function1<String, Unit> onJoinIntegration;

        /* compiled from: WidgetSettingsUserConnections.kt */
        public final class ViewHolder extends MGRecyclerViewHolder<Adapter, UserConnectionItem> {
            private final WidgetSettingsItemConnectedAccountBinding binding;
            public final /* synthetic */ Adapter this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public ViewHolder(@LayoutRes Adapter adapter, int i, Adapter adapter2) {
                super(i, adapter2);
                m.checkNotNullParameter(adapter2, "adapter");
                this.this$0 = adapter;
                View view = this.itemView;
                int i2 = R.id.connected_account_disconnect;
                ImageView imageView = (ImageView) view.findViewById(R.id.connected_account_disconnect);
                if (imageView != null) {
                    i2 = R.id.connected_account_divider;
                    View viewFindViewById = view.findViewById(R.id.connected_account_divider);
                    if (viewFindViewById != null) {
                        i2 = R.id.connected_account_img;
                        ImageView imageView2 = (ImageView) view.findViewById(R.id.connected_account_img);
                        if (imageView2 != null) {
                            i2 = R.id.connected_account_name;
                            TextView textView = (TextView) view.findViewById(R.id.connected_account_name);
                            if (textView != null) {
                                i2 = R.id.display_activity_switch;
                                SwitchMaterial switchMaterial = (SwitchMaterial) view.findViewById(R.id.display_activity_switch);
                                if (switchMaterial != null) {
                                    i2 = R.id.display_switch;
                                    SwitchMaterial switchMaterial2 = (SwitchMaterial) view.findViewById(R.id.display_switch);
                                    if (switchMaterial2 != null) {
                                        i2 = R.id.divider;
                                        View viewFindViewById2 = view.findViewById(R.id.divider);
                                        if (viewFindViewById2 != null) {
                                            i2 = R.id.extra_info;
                                            TextView textView2 = (TextView) view.findViewById(R.id.extra_info);
                                            if (textView2 != null) {
                                                i2 = R.id.integrations_root;
                                                LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.integrations_root);
                                                if (linearLayout != null) {
                                                    i2 = R.id.label;
                                                    TextView textView3 = (TextView) view.findViewById(R.id.label);
                                                    if (textView3 != null) {
                                                        i2 = R.id.sync_friends_switch;
                                                        SwitchMaterial switchMaterial3 = (SwitchMaterial) view.findViewById(R.id.sync_friends_switch);
                                                        if (switchMaterial3 != null) {
                                                            WidgetSettingsItemConnectedAccountBinding widgetSettingsItemConnectedAccountBinding = new WidgetSettingsItemConnectedAccountBinding((CardView) view, imageView, viewFindViewById, imageView2, textView, switchMaterial, switchMaterial2, viewFindViewById2, textView2, linearLayout, textView3, switchMaterial3);
                                                            m.checkNotNullExpressionValue(widgetSettingsItemConnectedAccountBinding, "WidgetSettingsItemConnec…untBinding.bind(itemView)");
                                                            this.binding = widgetSettingsItemConnectedAccountBinding;
                                                            return;
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
                throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i2)));
            }

            public static final /* synthetic */ void access$updateUserConnection(ViewHolder viewHolder, ConnectedAccount connectedAccount) {
                viewHolder.updateUserConnection(connectedAccount);
            }

            private final void updateUserConnection(ConnectedAccount connectedAccount) {
                StoreStream.Companion companion = StoreStream.INSTANCE;
                StoreUserConnections userConnections = companion.getUserConnections();
                SwitchMaterial switchMaterial = this.binding.i;
                m.checkNotNullExpressionValue(switchMaterial, "binding.syncFriendsSwitch");
                boolean zIsChecked = switchMaterial.isChecked();
                SwitchMaterial switchMaterial2 = this.binding.e;
                m.checkNotNullExpressionValue(switchMaterial2, "binding.displayActivitySwitch");
                boolean zIsChecked2 = switchMaterial2.isChecked();
                SwitchMaterial switchMaterial3 = this.binding.f;
                m.checkNotNullExpressionValue(switchMaterial3, "binding.displaySwitch");
                userConnections.updateUserConnection(connectedAccount, zIsChecked, zIsChecked2, switchMaterial3.isChecked());
                if (m.areEqual(connectedAccount.getType(), Platform.SPOTIFY.getPlatformId())) {
                    SwitchMaterial switchMaterial4 = this.binding.e;
                    m.checkNotNullExpressionValue(switchMaterial4, "binding.displayActivitySwitch");
                    if (switchMaterial4.isChecked()) {
                        return;
                    }
                    StoreUserPresence.updateActivity$default(companion.getPresences(), ActivityType.LISTENING, null, false, 4, null);
                }
            }

            @Override // com.discord.utilities.mg_recycler.MGRecyclerViewHolder
            public /* bridge */ /* synthetic */ void onConfigure(int i, UserConnectionItem userConnectionItem) {
                onConfigure2(i, userConnectionItem);
            }

            @SuppressLint({"DefaultLocale"})
            /* renamed from: onConfigure, reason: avoid collision after fix types in other method */
            public void onConfigure2(int position, UserConnectionItem data) {
                m.checkNotNullParameter(data, "data");
                super.onConfigure(position, data);
                ConnectedAccount connection = data.getConnectedAccount().getConnection();
                Platform platformFrom = Platform.INSTANCE.from(connection);
                String id2 = connection.getId();
                this.binding.a.setOnClickListener(new WidgetSettingsUserConnections$Adapter$ViewHolder$onConfigure$$inlined$apply$lambda$1(platformFrom, this, data));
                ImageView imageView = this.binding.c;
                View view = this.itemView;
                m.checkNotNullExpressionValue(view, "itemView");
                Integer themedPlatformImage = platformFrom.getThemedPlatformImage();
                imageView.setImageResource(DrawableCompat.getThemedDrawableRes$default(view, themedPlatformImage != null ? themedPlatformImage.intValue() : 0, 0, 2, (Object) null));
                ImageView imageView2 = this.binding.c;
                m.checkNotNullExpressionValue(imageView2, "binding.connectedAccountImg");
                imageView2.setContentDescription(platformFrom.name());
                TextView textView = this.binding.d;
                m.checkNotNullExpressionValue(textView, "binding.connectedAccountName");
                textView.setText(connection.getName());
                this.binding.f2626b.setOnClickListener(new WidgetSettingsUserConnections$Adapter$ViewHolder$onConfigure$$inlined$apply$lambda$2(connection, platformFrom, id2, this, data));
                this.binding.f.setOnCheckedChangeListener(null);
                SwitchMaterial switchMaterial = this.binding.f;
                m.checkNotNullExpressionValue(switchMaterial, "binding.displaySwitch");
                switchMaterial.setChecked(connection.getVisibility() == 1);
                this.binding.f.setOnCheckedChangeListener(new WidgetSettingsUserConnections$Adapter$ViewHolder$onConfigure$$inlined$apply$lambda$3(connection, this, data));
                this.binding.i.setOnCheckedChangeListener(null);
                SwitchMaterial switchMaterial2 = this.binding.i;
                m.checkNotNullExpressionValue(switchMaterial2, "binding.syncFriendsSwitch");
                switchMaterial2.setVisibility(platformFrom.getCanSyncFriends() ? 0 : 8);
                SwitchMaterial switchMaterial3 = this.binding.i;
                m.checkNotNullExpressionValue(switchMaterial3, "binding.syncFriendsSwitch");
                switchMaterial3.setChecked(connection.getFriendSync());
                this.binding.i.setOnCheckedChangeListener(new WidgetSettingsUserConnections$Adapter$ViewHolder$onConfigure$$inlined$apply$lambda$4(connection, this, data));
                this.binding.e.setOnCheckedChangeListener(null);
                SwitchMaterial switchMaterial4 = this.binding.e;
                m.checkNotNullExpressionValue(switchMaterial4, "binding.displayActivitySwitch");
                switchMaterial4.setVisibility(platformFrom.getCanShowActivity() ? 0 : 8);
                SwitchMaterial switchMaterial5 = this.binding.e;
                m.checkNotNullExpressionValue(switchMaterial5, "binding.displayActivitySwitch");
                b.n(switchMaterial5, R.string.display_activity, new Object[]{t.capitalize(platformFrom.getProperName())}, null, 4);
                SwitchMaterial switchMaterial6 = this.binding.e;
                m.checkNotNullExpressionValue(switchMaterial6, "binding.displayActivitySwitch");
                switchMaterial6.setChecked(connection.getShowActivity());
                this.binding.e.setOnCheckedChangeListener(new WidgetSettingsUserConnections$Adapter$ViewHolder$onConfigure$$inlined$apply$lambda$5(connection, this, data));
                if (m.areEqual(connection.getType(), Platform.SPOTIFY.getPlatformId())) {
                    TextView textView2 = this.binding.g;
                    m.checkNotNullExpressionValue(textView2, "binding.extraInfo");
                    textView2.setVisibility(0);
                    TextView textView3 = this.binding.g;
                    m.checkNotNullExpressionValue(textView3, "binding.extraInfo");
                    b.n(textView3, R.string.spotify_connection_info_android, new Object[0], null, 4);
                    this.binding.g.setOnClickListener(new WidgetSettingsUserConnections$Adapter$ViewHolder$onConfigure$$inlined$apply$lambda$6(this, data));
                } else {
                    TextView textView4 = this.binding.g;
                    m.checkNotNullExpressionValue(textView4, "binding.extraInfo");
                    textView4.setVisibility(8);
                }
                List<ConnectedAccountIntegration> listC = connection.c();
                if (listC == null || listC.isEmpty()) {
                    LinearLayout linearLayout = this.binding.h;
                    m.checkNotNullExpressionValue(linearLayout, "binding.integrationsRoot");
                    linearLayout.setVisibility(8);
                    return;
                }
                LinearLayout linearLayout2 = this.binding.h;
                m.checkNotNullExpressionValue(linearLayout2, "binding.integrationsRoot");
                linearLayout2.setVisibility(0);
                int iIndexOfChild = this.binding.h.indexOfChild(this.binding.h.findViewById(R.id.label));
                if (iIndexOfChild != -1) {
                    LinearLayout linearLayout3 = this.binding.h;
                    int i = iIndexOfChild + 1;
                    m.checkNotNullExpressionValue(linearLayout3, "binding.integrationsRoot");
                    linearLayout3.removeViewsInLayout(i, linearLayout3.getChildCount() - i);
                }
                List<ConnectedAccountIntegration> listC2 = connection.c();
                if (listC2 != null) {
                    for (ConnectedAccountIntegration connectedAccountIntegration : listC2) {
                        LinearLayout linearLayout4 = this.binding.h;
                        ConnectionsGuildIntegrationView connectionsGuildIntegrationView = new ConnectionsGuildIntegrationView(this.this$0.getContext(), null);
                        connectionsGuildIntegrationView.setIntegrationData(connectedAccountIntegration, data.getConnectedAccount().getIntegrationGuildJoinStatus().get(connectedAccountIntegration.getId()));
                        connectionsGuildIntegrationView.setJoinClickListener(new WidgetSettingsUserConnections$Adapter$ViewHolder$onConfigure$$inlined$apply$lambda$7(connectedAccountIntegration, this, data));
                        linearLayout4.addView(connectionsGuildIntegrationView);
                    }
                }
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public Adapter(RecyclerView recyclerView, FragmentManager fragmentManager, Function1<? super String, Unit> function1) {
            super(recyclerView, false, 2, null);
            m.checkNotNullParameter(recyclerView, "recyclerView");
            m.checkNotNullParameter(fragmentManager, "fragmentManager");
            m.checkNotNullParameter(function1, "onJoinIntegration");
            this.fragmentManager = fragmentManager;
            this.onJoinIntegration = function1;
        }

        public final FragmentManager getFragmentManager() {
            return this.fragmentManager;
        }

        public final Function1<String, Unit> getOnJoinIntegration() {
            return this.onJoinIntegration;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public /* bridge */ /* synthetic */ RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
            return onCreateViewHolder(viewGroup, i);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public MGRecyclerViewHolder<Adapter, UserConnectionItem> onCreateViewHolder(ViewGroup parent, int viewType) {
            m.checkNotNullParameter(parent, "parent");
            return new ViewHolder(this, R.layout.widget_settings_item_connected_account, this);
        }
    }

    /* compiled from: WidgetSettingsUserConnections.kt */
    public static final class Companion {
        private Companion() {
        }

        public final void launch(Context context) {
            m.checkNotNullParameter(context, "context");
            j.e(context, WidgetSettingsUserConnections.class, null, 4);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: WidgetSettingsUserConnections.kt */
    public static final class UserConnectionItem implements MGRecyclerDataPayload {
        private final WidgetSettingsUserConnectionsViewModel.ConnectionState connectedAccount;
        private final String key;
        private final int type;

        public UserConnectionItem(WidgetSettingsUserConnectionsViewModel.ConnectionState connectionState) {
            m.checkNotNullParameter(connectionState, "connectedAccount");
            this.connectedAccount = connectionState;
            this.key = connectionState.getConnection().getId();
        }

        public final WidgetSettingsUserConnectionsViewModel.ConnectionState getConnectedAccount() {
            return this.connectedAccount;
        }

        @Override // com.discord.utilities.mg_recycler.MGRecyclerDataPayload, com.discord.utilities.recycler.DiffKeyProvider
        public String getKey() {
            return this.key;
        }

        @Override // com.discord.utilities.mg_recycler.MGRecyclerDataPayload
        public int getType() {
            return this.type;
        }
    }

    /* compiled from: WidgetSettingsUserConnections.kt */
    /* renamed from: com.discord.widgets.settings.connections.WidgetSettingsUserConnections$onViewBound$2, reason: invalid class name */
    public static final class AnonymousClass2<T1, T2> implements Action2<MenuItem, Context> {
        public AnonymousClass2() {
        }

        @Override // rx.functions.Action2
        public /* bridge */ /* synthetic */ void call(MenuItem menuItem, Context context) {
            call2(menuItem, context);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final void call2(MenuItem menuItem, Context context) {
            m.checkNotNullExpressionValue(menuItem, "menuItem");
            if (menuItem.getItemId() == R.id.menu_add_connections && WidgetSettingsUserConnections.this.getContext() != null) {
                WidgetSettingsUserConnectionsAdd.INSTANCE.show(WidgetSettingsUserConnections.this);
            }
        }
    }

    /* compiled from: WidgetSettingsUserConnections.kt */
    /* renamed from: com.discord.widgets.settings.connections.WidgetSettingsUserConnections$onViewBoundOrOnResume$1, reason: invalid class name */
    public static final class AnonymousClass1 extends o implements Function1<WidgetSettingsUserConnectionsViewModel.ViewState, Unit> {
        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(WidgetSettingsUserConnectionsViewModel.ViewState viewState) {
            invoke2(viewState);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(WidgetSettingsUserConnectionsViewModel.ViewState viewState) {
            m.checkNotNullParameter(viewState, "viewState");
            WidgetSettingsUserConnections.access$handleViewState(WidgetSettingsUserConnections.this, viewState);
        }
    }

    public WidgetSettingsUserConnections() {
        super(R.layout.widget_settings_connections);
        this.binding = FragmentViewBindingDelegateKt.viewBinding$default(this, WidgetSettingsUserConnections$binding$2.INSTANCE, null, 2, null);
        WidgetSettingsUserConnections$viewModel$2 widgetSettingsUserConnections$viewModel$2 = WidgetSettingsUserConnections$viewModel$2.INSTANCE;
        g0 g0Var = new g0(this);
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(this, a0.getOrCreateKotlinClass(WidgetSettingsUserConnectionsViewModel.class), new WidgetSettingsUserConnections$appViewModels$$inlined$viewModels$1(g0Var), new i0(widgetSettingsUserConnections$viewModel$2));
    }

    public static final /* synthetic */ WidgetSettingsUserConnectionsViewModel access$getViewModel$p(WidgetSettingsUserConnections widgetSettingsUserConnections) {
        return widgetSettingsUserConnections.getViewModel();
    }

    public static final /* synthetic */ void access$handleViewState(WidgetSettingsUserConnections widgetSettingsUserConnections, WidgetSettingsUserConnectionsViewModel.ViewState viewState) {
        widgetSettingsUserConnections.handleViewState(viewState);
    }

    private final WidgetSettingsConnectionsBinding getBinding() {
        return (WidgetSettingsConnectionsBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    private final WidgetSettingsUserConnectionsViewModel getViewModel() {
        return (WidgetSettingsUserConnectionsViewModel) this.viewModel.getValue();
    }

    private final void handleViewState(WidgetSettingsUserConnectionsViewModel.ViewState viewState) {
        Adapter adapter = this.adapter;
        int itemCount = adapter != null ? adapter.getItemCount() : 0;
        if (viewState instanceof WidgetSettingsUserConnectionsViewModel.ViewState.Uninitialized) {
            TextView textView = getBinding().f2614b;
            m.checkNotNullExpressionValue(textView, "binding.connectionsEmpty");
            textView.setVisibility(8);
            RecyclerView recyclerView = getBinding().c;
            m.checkNotNullExpressionValue(recyclerView, "binding.connectionsRecycler");
            recyclerView.setVisibility(8);
            return;
        }
        if (viewState instanceof WidgetSettingsUserConnectionsViewModel.ViewState.Empty) {
            TextView textView2 = getBinding().f2614b;
            m.checkNotNullExpressionValue(textView2, "binding.connectionsEmpty");
            textView2.setVisibility(0);
            RecyclerView recyclerView2 = getBinding().c;
            m.checkNotNullExpressionValue(recyclerView2, "binding.connectionsRecycler");
            recyclerView2.setVisibility(8);
            return;
        }
        if (viewState instanceof WidgetSettingsUserConnectionsViewModel.ViewState.Loaded) {
            TextView textView3 = getBinding().f2614b;
            m.checkNotNullExpressionValue(textView3, "binding.connectionsEmpty");
            textView3.setVisibility(8);
            RecyclerView recyclerView3 = getBinding().c;
            m.checkNotNullExpressionValue(recyclerView3, "binding.connectionsRecycler");
            recyclerView3.setVisibility(0);
            List<WidgetSettingsUserConnectionsViewModel.ConnectionState> data = ((WidgetSettingsUserConnectionsViewModel.ViewState.Loaded) viewState).getData();
            ArrayList arrayList = new ArrayList(d0.t.o.collectionSizeOrDefault(data, 10));
            Iterator<T> it = data.iterator();
            while (it.hasNext()) {
                arrayList.add(new UserConnectionItem((WidgetSettingsUserConnectionsViewModel.ConnectionState) it.next()));
            }
            Adapter adapter2 = this.adapter;
            if (adapter2 != null) {
                adapter2.setData(arrayList);
            }
            if (itemCount == 0 || arrayList.size() <= itemCount) {
                return;
            }
            getBinding().c.smoothScrollToPosition(arrayList.size() - 1);
        }
    }

    public static final void launch(Context context) {
        INSTANCE.launch(context);
    }

    @Override // com.discord.app.AppFragment
    public void onViewBound(View view) {
        m.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        FragmentActivity activity = getActivity();
        if (activity != null) {
            MGRecyclerAdapter.Companion companion = MGRecyclerAdapter.INSTANCE;
            RecyclerView recyclerView = getBinding().c;
            m.checkNotNullExpressionValue(recyclerView, "binding.connectionsRecycler");
            m.checkNotNullExpressionValue(activity, "it");
            FragmentManager supportFragmentManager = activity.getSupportFragmentManager();
            m.checkNotNullExpressionValue(supportFragmentManager, "it.supportFragmentManager");
            this.adapter = (Adapter) companion.configure(new Adapter(recyclerView, supportFragmentManager, new WidgetSettingsUserConnections$onViewBound$$inlined$let$lambda$1(this)));
        }
        AppFragment.setActionBarDisplayHomeAsUpEnabled$default(this, false, 1, null);
        setActionBarSubtitle(R.string.user_settings);
        setActionBarTitle(R.string.connections);
        AppFragment.setActionBarOptionsMenu$default(this, R.menu.menu_connections, new AnonymousClass2(), null, 4, null);
    }

    @Override // com.discord.app.AppFragment
    public void onViewBoundOrOnResume() {
        super.onViewBoundOrOnResume();
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.bindToComponentLifecycle$default(getViewModel().observeViewState(), this, null, 2, null), WidgetSettingsUserConnections.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass1(), 62, (Object) null);
    }
}
