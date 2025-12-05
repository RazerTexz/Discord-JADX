package com.discord.widgets.servers;

import android.content.Context;
import android.content.Intent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import androidx.core.app.NotificationCompat;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.RecyclerView;
import com.discord.C5419R;
import com.discord.api.channel.Channel;
import com.discord.api.channel.ChannelUtils;
import com.discord.app.AppActivity;
import com.discord.app.AppFragment;
import com.discord.app.AppLogger2;
import com.discord.databinding.WidgetServerSettingsChannelsBinding;
import com.discord.models.guild.Guild;
import com.discord.restapi.RestAPIParams;
import com.discord.stores.StoreChannels;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreUser;
import com.discord.utilities.error.Error;
import com.discord.utilities.mg_recycler.CategoricalDragAndDropAdapter;
import com.discord.utilities.mg_recycler.MGRecyclerAdapter;
import com.discord.utilities.p501rx.ObservableExtensionsKt;
import com.discord.utilities.permissions.PermissionUtils;
import com.discord.utilities.rest.RestAPI;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate3;
import com.discord.widgets.channels.settings.WidgetTextChannelSettings;
import com.discord.widgets.chat.AutocompleteUtils2;
import com.discord.widgets.servers.SettingsChannelListAdapter;
import com.discord.widgets.servers.WidgetServerSettingsChannelsFabMenuFragment;
import com.discord.widgets.servers.WidgetServerSettingsChannelsSortActions;
import com.discord.widgets.voice.settings.WidgetVoiceChannelSettings;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;
import p007b.p008a.p018d.AppScreen2;
import p007b.p008a.p018d.AppToast;
import p007b.p100d.p104b.p105a.outline;
import p507d0.p578f0._Sequences2;
import p507d0.p580t._Collections;
import p507d0.p592z.p594d.FunctionReferenceImpl;
import p507d0.p592z.p594d.Intrinsics3;
import p507d0.p592z.p594d.Lambda;
import p658rx.Observable;
import p658rx.functions.Action0;
import p658rx.functions.Action1;
import p658rx.functions.Action2;
import p658rx.subjects.BehaviorSubject;

/* compiled from: WidgetServerSettingsChannels.kt */
/* loaded from: classes2.dex */
public final class WidgetServerSettingsChannels extends AppFragment {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {outline.m846d0(WidgetServerSettingsChannels.class, "binding", "getBinding()Lcom/discord/databinding/WidgetServerSettingsChannelsBinding;", 0)};

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final String INTENT_EXTRA_GUILD_ID = "INTENT_EXTRA_GUILD_ID";
    private SettingsChannelListAdapter adapter;

    /* renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;
    private final BehaviorSubject<Integer> channelSortTypeSubject;
    private final AppLogger2 loggingConfig;

    /* compiled from: WidgetServerSettingsChannels.kt */
    public static final class Companion {
        private Companion() {
        }

        public final void show(Context context, long guildId) {
            Intrinsics3.checkNotNullParameter(context, "context");
            StoreStream.INSTANCE.getAnalytics().onGuildSettingsPaneViewed(AutocompleteUtils2.CHANNELS, guildId);
            Intent intentPutExtra = new Intent().putExtra(WidgetServerSettingsChannels.INTENT_EXTRA_GUILD_ID, guildId);
            Intrinsics3.checkNotNullExpressionValue(intentPutExtra, "Intent()\n          .putE…_EXTRA_GUILD_ID, guildId)");
            AppScreen2.m156d(context, WidgetServerSettingsChannels.class, intentPutExtra);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: WidgetServerSettingsChannels.kt */
    public static final /* data */ class Model {

        /* renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private final Map<Long, Long> channelPermissions;
        private final Map<Long, Channel> channels;
        private final Guild guild;
        private final boolean isSorting;
        private final List<CategoricalDragAndDropAdapter.Payload> items;

        /* compiled from: WidgetServerSettingsChannels.kt */
        public static final class Companion {
            private Companion() {
            }

            public final Observable<Model> get(long guildId, Observable<Integer> channelTypeObservable) {
                Intrinsics3.checkNotNullParameter(channelTypeObservable, "channelTypeObservable");
                StoreStream.Companion companion = StoreStream.INSTANCE;
                Observable observableM11069e = Observable.m11069e(StoreUser.observeMe$default(companion.getUsers(), false, 1, null), companion.getPermissions().observePermissionsForGuild(guildId), companion.getGuilds().observeGuild(guildId), StoreChannels.observeChannelsForGuild$default(companion.getChannels(), guildId, null, 2, null), companion.getChannels().observeChannelCategories(guildId), companion.getPermissions().observeChannelPermissionsForGuild(guildId), channelTypeObservable, WidgetServerSettingsChannels2.INSTANCE);
                Intrinsics3.checkNotNullExpressionValue(observableM11069e, "Observable\n            .…ermissions)\n            }");
                Observable<Model> observableM11112r = ObservableExtensionsKt.computationLatest(observableM11069e).m11112r();
                Intrinsics3.checkNotNullExpressionValue(observableM11112r, "Observable\n            .…  .distinctUntilChanged()");
                return observableM11112r;
            }

            /* JADX WARN: Multi-variable type inference failed */
            public final LinkedHashMap<Long, Channel> getSortedGuildChannels(Map<Long, Channel> guildChannels, int channelType) {
                Intrinsics3.checkNotNullParameter(guildChannels, "guildChannels");
                LinkedHashMap<Long, Channel> linkedHashMap = new LinkedHashMap<>();
                for (Object obj : _Sequences2.sortedWith(_Sequences2.filter(_Collections.asSequence(guildChannels.values()), new WidgetServerSettingsChannels3(guildChannels, channelType)), ChannelUtils.m7684h(Channel.INSTANCE))) {
                    linkedHashMap.put(Long.valueOf(((Channel) obj).getId()), obj);
                }
                return linkedHashMap;
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        public Model(Guild guild, List<? extends CategoricalDragAndDropAdapter.Payload> list, boolean z2, Map<Long, Channel> map, Map<Long, Long> map2) {
            Intrinsics3.checkNotNullParameter(guild, "guild");
            Intrinsics3.checkNotNullParameter(list, "items");
            Intrinsics3.checkNotNullParameter(map, "channels");
            Intrinsics3.checkNotNullParameter(map2, "channelPermissions");
            this.guild = guild;
            this.items = list;
            this.isSorting = z2;
            this.channels = map;
            this.channelPermissions = map2;
        }

        public static /* synthetic */ Model copy$default(Model model, Guild guild, List list, boolean z2, Map map, Map map2, int i, Object obj) {
            if ((i & 1) != 0) {
                guild = model.guild;
            }
            if ((i & 2) != 0) {
                list = model.items;
            }
            List list2 = list;
            if ((i & 4) != 0) {
                z2 = model.isSorting;
            }
            boolean z3 = z2;
            if ((i & 8) != 0) {
                map = model.channels;
            }
            Map map3 = map;
            if ((i & 16) != 0) {
                map2 = model.channelPermissions;
            }
            return model.copy(guild, list2, z3, map3, map2);
        }

        /* renamed from: component1, reason: from getter */
        public final Guild getGuild() {
            return this.guild;
        }

        public final List<CategoricalDragAndDropAdapter.Payload> component2() {
            return this.items;
        }

        /* renamed from: component3, reason: from getter */
        public final boolean getIsSorting() {
            return this.isSorting;
        }

        public final Map<Long, Channel> component4() {
            return this.channels;
        }

        public final Map<Long, Long> component5() {
            return this.channelPermissions;
        }

        public final Model copy(Guild guild, List<? extends CategoricalDragAndDropAdapter.Payload> items, boolean isSorting, Map<Long, Channel> channels, Map<Long, Long> channelPermissions) {
            Intrinsics3.checkNotNullParameter(guild, "guild");
            Intrinsics3.checkNotNullParameter(items, "items");
            Intrinsics3.checkNotNullParameter(channels, "channels");
            Intrinsics3.checkNotNullParameter(channelPermissions, "channelPermissions");
            return new Model(guild, items, isSorting, channels, channelPermissions);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Model)) {
                return false;
            }
            Model model = (Model) other;
            return Intrinsics3.areEqual(this.guild, model.guild) && Intrinsics3.areEqual(this.items, model.items) && this.isSorting == model.isSorting && Intrinsics3.areEqual(this.channels, model.channels) && Intrinsics3.areEqual(this.channelPermissions, model.channelPermissions);
        }

        public final Map<Long, Long> getChannelPermissions() {
            return this.channelPermissions;
        }

        public final Map<Long, Channel> getChannels() {
            return this.channels;
        }

        public final Guild getGuild() {
            return this.guild;
        }

        public final List<CategoricalDragAndDropAdapter.Payload> getItems() {
            return this.items;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public int hashCode() {
            Guild guild = this.guild;
            int iHashCode = (guild != null ? guild.hashCode() : 0) * 31;
            List<CategoricalDragAndDropAdapter.Payload> list = this.items;
            int iHashCode2 = (iHashCode + (list != null ? list.hashCode() : 0)) * 31;
            boolean z2 = this.isSorting;
            int i = z2;
            if (z2 != 0) {
                i = 1;
            }
            int i2 = (iHashCode2 + i) * 31;
            Map<Long, Channel> map = this.channels;
            int iHashCode3 = (i2 + (map != null ? map.hashCode() : 0)) * 31;
            Map<Long, Long> map2 = this.channelPermissions;
            return iHashCode3 + (map2 != null ? map2.hashCode() : 0);
        }

        public final boolean isSorting() {
            return this.isSorting;
        }

        public String toString() {
            StringBuilder sbM833U = outline.m833U("Model(guild=");
            sbM833U.append(this.guild);
            sbM833U.append(", items=");
            sbM833U.append(this.items);
            sbM833U.append(", isSorting=");
            sbM833U.append(this.isSorting);
            sbM833U.append(", channels=");
            sbM833U.append(this.channels);
            sbM833U.append(", channelPermissions=");
            return outline.m825M(sbM833U, this.channelPermissions, ")");
        }
    }

    /* compiled from: WidgetServerSettingsChannels.kt */
    /* renamed from: com.discord.widgets.servers.WidgetServerSettingsChannels$configureFabVisibility$1 */
    public static final class ViewOnClickListenerC91981 implements View.OnClickListener {
        public final /* synthetic */ Model $model;
        public final /* synthetic */ Function0 $setFabVisibility;

        /* compiled from: WidgetServerSettingsChannels.kt */
        /* renamed from: com.discord.widgets.servers.WidgetServerSettingsChannels$configureFabVisibility$1$1, reason: invalid class name */
        public static final class AnonymousClass1 implements Action0 {
            public AnonymousClass1() {
            }

            @Override // p658rx.functions.Action0
            public final void call() {
                ViewOnClickListenerC91981.this.$setFabVisibility.invoke();
            }
        }

        public ViewOnClickListenerC91981(Model model, Function0 function0) {
            this.$model = model;
            this.$setFabVisibility = function0;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetServerSettingsChannelsFabMenuFragment.Companion companion = WidgetServerSettingsChannelsFabMenuFragment.INSTANCE;
            long id2 = this.$model.getGuild().getId();
            FragmentManager childFragmentManager = WidgetServerSettingsChannels.this.getChildFragmentManager();
            Intrinsics3.checkNotNullExpressionValue(childFragmentManager, "childFragmentManager");
            companion.show(id2, childFragmentManager, new AnonymousClass1());
            WidgetServerSettingsChannels.access$getBinding$p(WidgetServerSettingsChannels.this).f17567c.hide();
        }
    }

    /* compiled from: WidgetServerSettingsChannels.kt */
    /* renamed from: com.discord.widgets.servers.WidgetServerSettingsChannels$configureUI$1 */
    public static final class C92001<T1, T2> implements Action2<MenuItem, Context> {

        /* compiled from: WidgetServerSettingsChannels.kt */
        /* renamed from: com.discord.widgets.servers.WidgetServerSettingsChannels$configureUI$1$1, reason: invalid class name */
        public static final class AnonymousClass1 extends Lambda implements Function1<Integer, Unit> {
            public AnonymousClass1() {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Integer num) {
                invoke(num.intValue());
                return Unit.f27425a;
            }

            public final void invoke(int i) {
                WidgetServerSettingsChannels.access$getChannelSortTypeSubject$p(WidgetServerSettingsChannels.this).onNext(Integer.valueOf(i));
            }
        }

        public C92001() {
        }

        @Override // p658rx.functions.Action2
        public /* bridge */ /* synthetic */ void call(MenuItem menuItem, Context context) {
            call2(menuItem, context);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final void call2(MenuItem menuItem, Context context) {
            Intrinsics3.checkNotNullExpressionValue(menuItem, "menuItem");
            switch (menuItem.getItemId()) {
                case C5419R.id.menu_sort_channel /* 2131364413 */:
                    WidgetServerSettingsChannelsSortActions.Companion companion = WidgetServerSettingsChannelsSortActions.INSTANCE;
                    FragmentManager childFragmentManager = WidgetServerSettingsChannels.this.getChildFragmentManager();
                    Intrinsics3.checkNotNullExpressionValue(childFragmentManager, "childFragmentManager");
                    companion.show(childFragmentManager, new AnonymousClass1());
                    break;
                case C5419R.id.menu_sort_done /* 2131364414 */:
                    WidgetServerSettingsChannels.access$getChannelSortTypeSubject$p(WidgetServerSettingsChannels.this).onNext(-1);
                    break;
            }
        }
    }

    /* compiled from: WidgetServerSettingsChannels.kt */
    /* renamed from: com.discord.widgets.servers.WidgetServerSettingsChannels$configureUI$2 */
    public static final class C92012<T> implements Action1<Menu> {
        public final /* synthetic */ Model $model;

        public C92012(Model model) {
            this.$model = model;
        }

        @Override // p658rx.functions.Action1
        public /* bridge */ /* synthetic */ void call(Menu menu) {
            call2(menu);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final void call2(Menu menu) {
            MenuItem menuItemFindItem = menu.findItem(C5419R.id.menu_sort_channel);
            Intrinsics3.checkNotNullExpressionValue(menuItemFindItem, "menu.findItem(R.id.menu_sort_channel)");
            menuItemFindItem.setVisible(!this.$model.isSorting());
            MenuItem menuItemFindItem2 = menu.findItem(C5419R.id.menu_sort_done);
            Intrinsics3.checkNotNullExpressionValue(menuItemFindItem2, "menu.findItem(R.id.menu_sort_done)");
            menuItemFindItem2.setVisible(this.$model.isSorting());
        }
    }

    /* compiled from: WidgetServerSettingsChannels.kt */
    /* renamed from: com.discord.widgets.servers.WidgetServerSettingsChannels$configureUI$3 */
    public static final class C92023<T> implements Action1<Map<Long, ? extends SettingsChannelListAdapter.UpdatedPosition>> {
        public final /* synthetic */ Model $model;

        public C92023(Model model) {
            this.$model = model;
        }

        @Override // p658rx.functions.Action1
        public /* bridge */ /* synthetic */ void call(Map<Long, ? extends SettingsChannelListAdapter.UpdatedPosition> map) {
            call2((Map<Long, SettingsChannelListAdapter.UpdatedPosition>) map);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final void call2(Map<Long, SettingsChannelListAdapter.UpdatedPosition> map) {
            WidgetServerSettingsChannels widgetServerSettingsChannels = WidgetServerSettingsChannels.this;
            Model model = this.$model;
            Intrinsics3.checkNotNullExpressionValue(map, "newPositions");
            WidgetServerSettingsChannels.access$reorderChannels(widgetServerSettingsChannels, model, map);
        }
    }

    /* compiled from: WidgetServerSettingsChannels.kt */
    /* renamed from: com.discord.widgets.servers.WidgetServerSettingsChannels$onViewBoundOrOnResume$1 */
    public static final /* synthetic */ class C92031 extends FunctionReferenceImpl implements Function1<Model, Unit> {
        public C92031(WidgetServerSettingsChannels widgetServerSettingsChannels) {
            super(1, widgetServerSettingsChannels, WidgetServerSettingsChannels.class, "configureUI", "configureUI(Lcom/discord/widgets/servers/WidgetServerSettingsChannels$Model;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Model model) throws Exception {
            invoke2(model);
            return Unit.f27425a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Model model) throws Exception {
            WidgetServerSettingsChannels.access$configureUI((WidgetServerSettingsChannels) this.receiver, model);
        }
    }

    /* compiled from: WidgetServerSettingsChannels.kt */
    /* renamed from: com.discord.widgets.servers.WidgetServerSettingsChannels$reorderChannels$1 */
    public static final class C92041 extends Lambda implements Function1<Void, Unit> {
        public C92041() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Void r1) {
            invoke2(r1);
            return Unit.f27425a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Void r4) {
            AppToast.m171i(WidgetServerSettingsChannels.this, C5419R.string.channel_order_updated, 0, 4);
        }
    }

    /* compiled from: WidgetServerSettingsChannels.kt */
    /* renamed from: com.discord.widgets.servers.WidgetServerSettingsChannels$reorderChannels$2 */
    public static final class C92052 extends Lambda implements Function1<Error, Unit> {
        public final /* synthetic */ Model $data;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C92052(Model model) {
            super(1);
            this.$data = model;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Error error) throws Exception {
            invoke2(error);
            return Unit.f27425a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Error error) throws Exception {
            Intrinsics3.checkNotNullParameter(error, "it");
            WidgetServerSettingsChannels.access$configureUI(WidgetServerSettingsChannels.this, this.$data);
        }
    }

    /* compiled from: WidgetServerSettingsChannels.kt */
    /* renamed from: com.discord.widgets.servers.WidgetServerSettingsChannels$setOnClickListener$1 */
    public static final class C92061 extends Lambda implements Function1<Long, Unit> {
        public static final C92061 INSTANCE = new C92061();

        public C92061() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Long l) {
            invoke(l.longValue());
            return Unit.f27425a;
        }

        public final void invoke(long j) {
        }
    }

    /* compiled from: WidgetServerSettingsChannels.kt */
    /* renamed from: com.discord.widgets.servers.WidgetServerSettingsChannels$setOnClickListener$2 */
    public static final class C92072 extends Lambda implements Function1<Long, Unit> {
        public final /* synthetic */ Model $model;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C92072(Model model) {
            super(1);
            this.$model = model;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Long l) {
            invoke(l.longValue());
            return Unit.f27425a;
        }

        public final void invoke(long j) {
            if (PermissionUtils.can(16L, this.$model.getChannelPermissions().get(Long.valueOf(j)))) {
                Channel channel = this.$model.getChannels().get(Long.valueOf(j));
                if (channel == null || !ChannelUtils.m7699w(channel)) {
                    WidgetTextChannelSettings.INSTANCE.launch(j, WidgetServerSettingsChannels.this.requireContext());
                } else {
                    WidgetVoiceChannelSettings.INSTANCE.launch(j, WidgetServerSettingsChannels.this.requireContext());
                }
            }
        }
    }

    public WidgetServerSettingsChannels() {
        super(C5419R.layout.widget_server_settings_channels);
        this.binding = FragmentViewBindingDelegate3.viewBinding$default(this, WidgetServerSettingsChannels4.INSTANCE, null, 2, null);
        this.channelSortTypeSubject = BehaviorSubject.m11130l0(-1);
        this.loggingConfig = new AppLogger2(false, null, WidgetServerSettingsChannels6.INSTANCE, 3);
    }

    public static final /* synthetic */ void access$configureUI(WidgetServerSettingsChannels widgetServerSettingsChannels, Model model) throws Exception {
        widgetServerSettingsChannels.configureUI(model);
    }

    public static final /* synthetic */ WidgetServerSettingsChannelsBinding access$getBinding$p(WidgetServerSettingsChannels widgetServerSettingsChannels) {
        return widgetServerSettingsChannels.getBinding();
    }

    public static final /* synthetic */ BehaviorSubject access$getChannelSortTypeSubject$p(WidgetServerSettingsChannels widgetServerSettingsChannels) {
        return widgetServerSettingsChannels.channelSortTypeSubject;
    }

    public static final /* synthetic */ void access$reorderChannels(WidgetServerSettingsChannels widgetServerSettingsChannels, Model model, Map map) {
        widgetServerSettingsChannels.reorderChannels(model, map);
    }

    private final void configureFabVisibility(Model model) {
        WidgetServerSettingsChannels5 widgetServerSettingsChannels5 = new WidgetServerSettingsChannels5(this, model);
        widgetServerSettingsChannels5.invoke();
        getBinding().f17567c.setOnClickListener(new ViewOnClickListenerC91981(model, widgetServerSettingsChannels5));
    }

    private final void configureUI(Model model) throws Exception {
        if (model == null) {
            AppActivity appActivity = getAppActivity();
            if (appActivity != null) {
                appActivity.onBackPressed();
                return;
            }
            return;
        }
        setActionBarDisplayHomeAsUpEnabled(!model.isSorting());
        setActionBarTitle(!model.isSorting() ? C5419R.string.channels : C5419R.string.sorting);
        setActionBarSubtitle(model.getGuild().getName());
        setActionBarOptionsMenu(C5419R.menu.menu_channel_sort, new C92001(), new C92012(model));
        configureFabVisibility(model);
        SettingsChannelListAdapter settingsChannelListAdapter = this.adapter;
        if (settingsChannelListAdapter != null) {
            settingsChannelListAdapter.setData(model.getItems());
        }
        SettingsChannelListAdapter settingsChannelListAdapter2 = this.adapter;
        if (settingsChannelListAdapter2 != null) {
            settingsChannelListAdapter2.setPositionUpdateListener(new C92023(model));
        }
        SettingsChannelListAdapter settingsChannelListAdapter3 = this.adapter;
        if (settingsChannelListAdapter3 != null) {
            setOnClickListener(settingsChannelListAdapter3, model);
        }
    }

    private final WidgetServerSettingsChannelsBinding getBinding() {
        return (WidgetServerSettingsChannelsBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    private final void reorderChannels(Model data, Map<Long, SettingsChannelListAdapter.UpdatedPosition> newPositions) {
        ArrayList arrayList = new ArrayList(newPositions.size());
        for (Map.Entry<Long, SettingsChannelListAdapter.UpdatedPosition> entry : newPositions.entrySet()) {
            long jLongValue = entry.getKey().longValue();
            SettingsChannelListAdapter.UpdatedPosition value = entry.getValue();
            arrayList.add(new RestAPIParams.ChannelPosition(jLongValue, value.getPosition(), value.getParentId()));
        }
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.withDimmer$default(ObservableExtensionsKt.restSubscribeOn$default(RestAPI.INSTANCE.getApiSerializeNulls().reorderChannels(data.getGuild().getId(), arrayList), false, 1, null), getBinding().f17566b, 0L, 2, null), this, null, 2, null), WidgetServerSettingsChannels.class, getContext(), (Function1) null, new C92052(data), (Function0) null, (Function0) null, new C92041(), 52, (Object) null);
    }

    private final void setOnClickListener(SettingsChannelListAdapter settingsChannelListAdapter, Model model) {
        settingsChannelListAdapter.setOnClickListener(model.isSorting() ? C92061.INSTANCE : new C92072(model));
    }

    @Override // com.discord.app.AppFragment, com.discord.app.AppLogger.InterfaceC5455a
    public AppLogger2 getLoggingConfig() {
        return this.loggingConfig;
    }

    @Override // com.discord.app.AppFragment
    public void onViewBound(View view) {
        Intrinsics3.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        MGRecyclerAdapter.Companion companion = MGRecyclerAdapter.INSTANCE;
        RecyclerView recyclerView = getBinding().f17568d;
        Intrinsics3.checkNotNullExpressionValue(recyclerView, "binding.serverSettingsChannelsTextRecycler");
        this.adapter = (SettingsChannelListAdapter) companion.configure(new SettingsChannelListAdapter(recyclerView, true));
    }

    @Override // com.discord.app.AppFragment
    public void onViewBoundOrOnResume() {
        super.onViewBoundOrOnResume();
        long longExtra = getMostRecentIntent().getLongExtra(INTENT_EXTRA_GUILD_ID, -1L);
        Model.Companion companion = Model.INSTANCE;
        BehaviorSubject<Integer> behaviorSubject = this.channelSortTypeSubject;
        Intrinsics3.checkNotNullExpressionValue(behaviorSubject, "channelSortTypeSubject");
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(companion.get(longExtra, behaviorSubject), this, null, 2, null), WidgetServerSettingsChannels.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new C92031(this), 62, (Object) null);
    }
}
