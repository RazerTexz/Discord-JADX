package com.discord.widgets.user;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import b.a.d.AppScreen2;
import b.a.i.WidgetUserProfileAdapterItemFriendMutualServerBinding;
import b.d.b.a.outline;
import com.discord.R;
import com.discord.app.AppFragment;
import com.discord.databinding.WidgetUserMutualFriendsBinding;
import com.discord.databinding.WidgetUserProfileAdapterItemFriendBinding;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.models.guild.Guild;
import com.discord.models.presence.Presence;
import com.discord.models.user.User;
import com.discord.utilities.icon.IconUtils;
import com.discord.utilities.images.MGImages;
import com.discord.utilities.mg_recycler.MGRecyclerAdapter;
import com.discord.utilities.mg_recycler.MGRecyclerAdapterSimple;
import com.discord.utilities.mg_recycler.MGRecyclerDataPayload;
import com.discord.utilities.mg_recycler.MGRecyclerViewHolder;
import com.discord.utilities.presence.PresenceUtils;
import com.discord.utilities.resources.StringResourceUtils;
import com.discord.utilities.rest.RestAPI;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.view.text.SimpleDraweeSpanTextView;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate3;
import com.discord.views.StatusView;
import com.discord.widgets.user.profile.WidgetUserProfileEmptyListItem;
import com.facebook.drawee.view.SimpleDraweeView;
import d0.LazyJVM;
import d0.t._Collections;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import java.util.List;
import kotlin.Lazy;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;
import rx.Observable;

/* compiled from: WidgetUserMutualFriends.kt */
/* loaded from: classes.dex */
public final class WidgetUserMutualFriends extends AppFragment {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {outline.d0(WidgetUserMutualFriends.class, "binding", "getBinding()Lcom/discord/databinding/WidgetUserMutualFriendsBinding;", 0)};

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private MutualFriendsAdapter adapter;

    /* renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;

    /* renamed from: userId$delegate, reason: from kotlin metadata */
    private final Lazy userId;

    /* compiled from: WidgetUserMutualFriends.kt */
    public static final class Companion {
        private Companion() {
        }

        public final void show(Context context, User user) {
            Intrinsics3.checkNotNullParameter(context, "context");
            Intrinsics3.checkNotNullParameter(user, "user");
            Intent intentPutExtra = new Intent().putExtra("com.discord.intent.extra.EXTRA_USER_ID", user.getId());
            Intrinsics3.checkNotNullExpressionValue(intentPutExtra, "Intent().putExtra(Intents.EXTRA_USER_ID, user.id)");
            AppScreen2.d(context, WidgetUserMutualFriends.class, intentPutExtra);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: WidgetUserMutualFriends.kt */
    public static final /* data */ class Model {

        /* renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private final List<Item> items;
        private final int numMutualFriends;
        private final User user;

        /* compiled from: WidgetUserMutualFriends.kt */
        public static final class Companion {
            private Companion() {
            }

            public final Observable<Model> get(long userId) {
                Observable observableY = ObservableExtensionsKt.restSubscribeOn$default(RestAPI.INSTANCE.getApi().getRelationships(userId), false, 1, null).Y(new WidgetUserMutualFriends2(userId));
                Intrinsics3.checkNotNullExpressionValue(observableY, "RestAPI\n            .api…          )\n            }");
                Observable<Model> observableR = ObservableExtensionsKt.computationLatest(observableY).r();
                Intrinsics3.checkNotNullExpressionValue(observableR, "RestAPI\n            .api…  .distinctUntilChanged()");
                return observableR;
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        /* compiled from: WidgetUserMutualFriends.kt */
        public static abstract class Item implements MGRecyclerDataPayload {
            public static final int TYPE_EMPTY = 0;
            public static final int TYPE_FRIEND = 1;

            /* compiled from: WidgetUserMutualFriends.kt */
            public static final class Empty extends Item {
                public static final Empty INSTANCE;
                private static final String key;
                private static final int type = 0;

                static {
                    Empty empty = new Empty();
                    INSTANCE = empty;
                    StringBuilder sbU = outline.U("empty");
                    sbU.append(empty.getType());
                    key = sbU.toString();
                }

                private Empty() {
                    super(null);
                }

                @Override // com.discord.utilities.mg_recycler.MGRecyclerDataPayload, com.discord.utilities.recycler.DiffKeyProvider
                public String getKey() {
                    return key;
                }

                @Override // com.discord.utilities.mg_recycler.MGRecyclerDataPayload
                public int getType() {
                    return type;
                }
            }

            /* compiled from: WidgetUserMutualFriends.kt */
            public static final /* data */ class MutualFriend extends Item {
                private final Boolean isApplicationStreaming;
                private final String key;
                private final List<Guild> mutualGuilds;
                private final Presence presence;
                private final int type;
                private final User user;

                public /* synthetic */ MutualFriend(User user, Presence presence, List list, Boolean bool, int i, DefaultConstructorMarker defaultConstructorMarker) {
                    this(user, presence, list, (i & 8) != 0 ? null : bool);
                }

                /* JADX WARN: Multi-variable type inference failed */
                public static /* synthetic */ MutualFriend copy$default(MutualFriend mutualFriend, User user, Presence presence, List list, Boolean bool, int i, Object obj) {
                    if ((i & 1) != 0) {
                        user = mutualFriend.user;
                    }
                    if ((i & 2) != 0) {
                        presence = mutualFriend.presence;
                    }
                    if ((i & 4) != 0) {
                        list = mutualFriend.mutualGuilds;
                    }
                    if ((i & 8) != 0) {
                        bool = mutualFriend.isApplicationStreaming;
                    }
                    return mutualFriend.copy(user, presence, list, bool);
                }

                /* renamed from: component1, reason: from getter */
                public final User getUser() {
                    return this.user;
                }

                /* renamed from: component2, reason: from getter */
                public final Presence getPresence() {
                    return this.presence;
                }

                public final List<Guild> component3() {
                    return this.mutualGuilds;
                }

                /* renamed from: component4, reason: from getter */
                public final Boolean getIsApplicationStreaming() {
                    return this.isApplicationStreaming;
                }

                public final MutualFriend copy(User user, Presence presence, List<Guild> mutualGuilds, Boolean isApplicationStreaming) {
                    Intrinsics3.checkNotNullParameter(user, "user");
                    Intrinsics3.checkNotNullParameter(mutualGuilds, "mutualGuilds");
                    return new MutualFriend(user, presence, mutualGuilds, isApplicationStreaming);
                }

                public boolean equals(Object other) {
                    if (this == other) {
                        return true;
                    }
                    if (!(other instanceof MutualFriend)) {
                        return false;
                    }
                    MutualFriend mutualFriend = (MutualFriend) other;
                    return Intrinsics3.areEqual(this.user, mutualFriend.user) && Intrinsics3.areEqual(this.presence, mutualFriend.presence) && Intrinsics3.areEqual(this.mutualGuilds, mutualFriend.mutualGuilds) && Intrinsics3.areEqual(this.isApplicationStreaming, mutualFriend.isApplicationStreaming);
                }

                @Override // com.discord.utilities.mg_recycler.MGRecyclerDataPayload, com.discord.utilities.recycler.DiffKeyProvider
                public String getKey() {
                    return this.key;
                }

                public final List<Guild> getMutualGuilds() {
                    return this.mutualGuilds;
                }

                public final Presence getPresence() {
                    return this.presence;
                }

                @Override // com.discord.utilities.mg_recycler.MGRecyclerDataPayload
                public int getType() {
                    return this.type;
                }

                public final User getUser() {
                    return this.user;
                }

                public int hashCode() {
                    User user = this.user;
                    int iHashCode = (user != null ? user.hashCode() : 0) * 31;
                    Presence presence = this.presence;
                    int iHashCode2 = (iHashCode + (presence != null ? presence.hashCode() : 0)) * 31;
                    List<Guild> list = this.mutualGuilds;
                    int iHashCode3 = (iHashCode2 + (list != null ? list.hashCode() : 0)) * 31;
                    Boolean bool = this.isApplicationStreaming;
                    return iHashCode3 + (bool != null ? bool.hashCode() : 0);
                }

                public final Boolean isApplicationStreaming() {
                    return this.isApplicationStreaming;
                }

                public String toString() {
                    StringBuilder sbU = outline.U("MutualFriend(user=");
                    sbU.append(this.user);
                    sbU.append(", presence=");
                    sbU.append(this.presence);
                    sbU.append(", mutualGuilds=");
                    sbU.append(this.mutualGuilds);
                    sbU.append(", isApplicationStreaming=");
                    return outline.D(sbU, this.isApplicationStreaming, ")");
                }

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                public MutualFriend(User user, Presence presence, List<Guild> list, Boolean bool) {
                    super(null);
                    Intrinsics3.checkNotNullParameter(user, "user");
                    Intrinsics3.checkNotNullParameter(list, "mutualGuilds");
                    this.user = user;
                    this.presence = presence;
                    this.mutualGuilds = list;
                    this.isApplicationStreaming = bool;
                    this.type = 1;
                    StringBuilder sb = new StringBuilder();
                    sb.append(getType());
                    sb.append(user.getId());
                    this.key = sb.toString();
                }
            }

            private Item() {
            }

            public /* synthetic */ Item(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        public Model(User user, List<? extends Item> list, int i) {
            Intrinsics3.checkNotNullParameter(list, "items");
            this.user = user;
            this.items = list;
            this.numMutualFriends = i;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ Model copy$default(Model model, User user, List list, int i, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                user = model.user;
            }
            if ((i2 & 2) != 0) {
                list = model.items;
            }
            if ((i2 & 4) != 0) {
                i = model.numMutualFriends;
            }
            return model.copy(user, list, i);
        }

        /* renamed from: component1, reason: from getter */
        public final User getUser() {
            return this.user;
        }

        public final List<Item> component2() {
            return this.items;
        }

        /* renamed from: component3, reason: from getter */
        public final int getNumMutualFriends() {
            return this.numMutualFriends;
        }

        public final Model copy(User user, List<? extends Item> items, int numMutualFriends) {
            Intrinsics3.checkNotNullParameter(items, "items");
            return new Model(user, items, numMutualFriends);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Model)) {
                return false;
            }
            Model model = (Model) other;
            return Intrinsics3.areEqual(this.user, model.user) && Intrinsics3.areEqual(this.items, model.items) && this.numMutualFriends == model.numMutualFriends;
        }

        public final List<Item> getItems() {
            return this.items;
        }

        public final int getNumMutualFriends() {
            return this.numMutualFriends;
        }

        public final User getUser() {
            return this.user;
        }

        public int hashCode() {
            User user = this.user;
            int iHashCode = (user != null ? user.hashCode() : 0) * 31;
            List<Item> list = this.items;
            return ((iHashCode + (list != null ? list.hashCode() : 0)) * 31) + this.numMutualFriends;
        }

        public String toString() {
            StringBuilder sbU = outline.U("Model(user=");
            sbU.append(this.user);
            sbU.append(", items=");
            sbU.append(this.items);
            sbU.append(", numMutualFriends=");
            return outline.B(sbU, this.numMutualFriends, ")");
        }
    }

    /* compiled from: WidgetUserMutualFriends.kt */
    public static final class MutualFriendsAdapter extends MGRecyclerAdapterSimple<Model.Item> {
        private final AppFragment fragment;

        /* compiled from: WidgetUserMutualFriends.kt */
        public static final class ViewHolder extends MGRecyclerViewHolder<MutualFriendsAdapter, Model.Item> {
            private final WidgetUserProfileAdapterItemFriendBinding binding;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public ViewHolder(MutualFriendsAdapter mutualFriendsAdapter) {
                super(R.layout.widget_user_profile_adapter_item_friend, mutualFriendsAdapter);
                Intrinsics3.checkNotNullParameter(mutualFriendsAdapter, "adapter");
                View view = this.itemView;
                int i = R.id.mutual_server_1;
                View viewFindViewById = view.findViewById(R.id.mutual_server_1);
                if (viewFindViewById != null) {
                    WidgetUserProfileAdapterItemFriendMutualServerBinding widgetUserProfileAdapterItemFriendMutualServerBindingA = WidgetUserProfileAdapterItemFriendMutualServerBinding.a(viewFindViewById);
                    i = R.id.mutual_server_2;
                    View viewFindViewById2 = view.findViewById(R.id.mutual_server_2);
                    if (viewFindViewById2 != null) {
                        WidgetUserProfileAdapterItemFriendMutualServerBinding widgetUserProfileAdapterItemFriendMutualServerBindingA2 = WidgetUserProfileAdapterItemFriendMutualServerBinding.a(viewFindViewById2);
                        i = R.id.mutual_server_3;
                        View viewFindViewById3 = view.findViewById(R.id.mutual_server_3);
                        if (viewFindViewById3 != null) {
                            WidgetUserProfileAdapterItemFriendMutualServerBinding widgetUserProfileAdapterItemFriendMutualServerBindingA3 = WidgetUserProfileAdapterItemFriendMutualServerBinding.a(viewFindViewById3);
                            i = R.id.mutual_server_4;
                            View viewFindViewById4 = view.findViewById(R.id.mutual_server_4);
                            if (viewFindViewById4 != null) {
                                WidgetUserProfileAdapterItemFriendMutualServerBinding widgetUserProfileAdapterItemFriendMutualServerBindingA4 = WidgetUserProfileAdapterItemFriendMutualServerBinding.a(viewFindViewById4);
                                i = R.id.user_profile_adapter_item_friend_avatar;
                                SimpleDraweeView simpleDraweeView = (SimpleDraweeView) view.findViewById(R.id.user_profile_adapter_item_friend_avatar);
                                if (simpleDraweeView != null) {
                                    i = R.id.user_profile_adapter_item_friend_mutual;
                                    LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.user_profile_adapter_item_friend_mutual);
                                    if (linearLayout != null) {
                                        i = R.id.user_profile_adapter_item_friend_status;
                                        StatusView statusView = (StatusView) view.findViewById(R.id.user_profile_adapter_item_friend_status);
                                        if (statusView != null) {
                                            i = R.id.user_profile_adapter_item_friend_user_game;
                                            SimpleDraweeSpanTextView simpleDraweeSpanTextView = (SimpleDraweeSpanTextView) view.findViewById(R.id.user_profile_adapter_item_friend_user_game);
                                            if (simpleDraweeSpanTextView != null) {
                                                i = R.id.user_profile_adapter_item_friend_user_name;
                                                TextView textView = (TextView) view.findViewById(R.id.user_profile_adapter_item_friend_user_name);
                                                if (textView != null) {
                                                    WidgetUserProfileAdapterItemFriendBinding widgetUserProfileAdapterItemFriendBinding = new WidgetUserProfileAdapterItemFriendBinding((RelativeLayout) view, widgetUserProfileAdapterItemFriendMutualServerBindingA, widgetUserProfileAdapterItemFriendMutualServerBindingA2, widgetUserProfileAdapterItemFriendMutualServerBindingA3, widgetUserProfileAdapterItemFriendMutualServerBindingA4, simpleDraweeView, linearLayout, statusView, simpleDraweeSpanTextView, textView);
                                                    Intrinsics3.checkNotNullExpressionValue(widgetUserProfileAdapterItemFriendBinding, "WidgetUserProfileAdapter…endBinding.bind(itemView)");
                                                    this.binding = widgetUserProfileAdapterItemFriendBinding;
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
                throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
            }

            public static final /* synthetic */ MutualFriendsAdapter access$getAdapter$p(ViewHolder viewHolder) {
                return (MutualFriendsAdapter) viewHolder.adapter;
            }

            @Override // com.discord.utilities.mg_recycler.MGRecyclerViewHolder
            public /* bridge */ /* synthetic */ void onConfigure(int i, Model.Item item) {
                onConfigure2(i, item);
            }

            /* renamed from: onConfigure, reason: avoid collision after fix types in other method */
            public void onConfigure2(int position, Model.Item data) {
                Intrinsics3.checkNotNullParameter(data, "data");
                super.onConfigure(position, (int) data);
                Model.Item.MutualFriend mutualFriend = (Model.Item.MutualFriend) data;
                this.itemView.setOnClickListener(new WidgetUserMutualFriends3(this, mutualFriend));
                TextView textView = this.binding.i;
                Intrinsics3.checkNotNullExpressionValue(textView, "binding.userProfileAdapterItemFriendUserName");
                textView.setText(mutualFriend.getUser().getUsername());
                this.binding.g.setPresence(mutualFriend.getPresence());
                SimpleDraweeSpanTextView simpleDraweeSpanTextView = this.binding.h;
                Presence presence = mutualFriend.getPresence();
                Boolean boolIsApplicationStreaming = mutualFriend.isApplicationStreaming();
                Intrinsics3.checkNotNull(boolIsApplicationStreaming);
                boolean zBooleanValue = boolIsApplicationStreaming.booleanValue();
                Intrinsics3.checkNotNullExpressionValue(simpleDraweeSpanTextView, "it");
                PresenceUtils.setPresenceText$default(presence, zBooleanValue, simpleDraweeSpanTextView, true, false, 16, null);
                SimpleDraweeView simpleDraweeView = this.binding.f;
                Intrinsics3.checkNotNullExpressionValue(simpleDraweeView, "binding.userProfileAdapterItemFriendAvatar");
                IconUtils.setIcon$default(simpleDraweeView, mutualFriend.getUser(), R.dimen.avatar_size_standard, null, null, null, 56, null);
                int i = 0;
                while (i <= 3) {
                    WidgetUserProfileAdapterItemFriendMutualServerBinding widgetUserProfileAdapterItemFriendMutualServerBinding = i != 1 ? i != 2 ? i != 3 ? i != 4 ? this.binding.e : this.binding.e : this.binding.d : this.binding.c : this.binding.f2690b;
                    Intrinsics3.checkNotNullExpressionValue(widgetUserProfileAdapterItemFriendMutualServerBinding, "when (i) {\n            1…mutualServer4\n          }");
                    RelativeLayout relativeLayout = widgetUserProfileAdapterItemFriendMutualServerBinding.a;
                    Intrinsics3.checkNotNullExpressionValue(relativeLayout, "item.root");
                    relativeLayout.setVisibility(8);
                    TextView textView2 = widgetUserProfileAdapterItemFriendMutualServerBinding.c;
                    Intrinsics3.checkNotNullExpressionValue(textView2, "item.userProfileAdapterItemFriendMutualText");
                    textView2.setVisibility(8);
                    SimpleDraweeView simpleDraweeView2 = widgetUserProfileAdapterItemFriendMutualServerBinding.f115b;
                    Intrinsics3.checkNotNullExpressionValue(simpleDraweeView2, "item.userProfileAdapterItemFriendMutualImage");
                    simpleDraweeView2.setVisibility(8);
                    Guild guild = (Guild) _Collections.getOrNull(mutualFriend.getMutualGuilds(), i);
                    if (guild != null) {
                        RelativeLayout relativeLayout2 = widgetUserProfileAdapterItemFriendMutualServerBinding.a;
                        Intrinsics3.checkNotNullExpressionValue(relativeLayout2, "item.root");
                        relativeLayout2.setVisibility(0);
                        if (guild.getIcon() != null) {
                            SimpleDraweeView simpleDraweeView3 = widgetUserProfileAdapterItemFriendMutualServerBinding.f115b;
                            Intrinsics3.checkNotNullExpressionValue(simpleDraweeView3, "item.userProfileAdapterItemFriendMutualImage");
                            simpleDraweeView3.setVisibility(0);
                            SimpleDraweeView simpleDraweeView4 = widgetUserProfileAdapterItemFriendMutualServerBinding.f115b;
                            Intrinsics3.checkNotNullExpressionValue(simpleDraweeView4, "imageView");
                            IconUtils.setIcon$default((ImageView) simpleDraweeView4, guild, 0, (MGImages.ChangeDetector) null, false, 28, (Object) null);
                        } else {
                            TextView textView3 = widgetUserProfileAdapterItemFriendMutualServerBinding.c;
                            Intrinsics3.checkNotNullExpressionValue(textView3, "item.userProfileAdapterItemFriendMutualText");
                            textView3.setVisibility(0);
                            TextView textView4 = widgetUserProfileAdapterItemFriendMutualServerBinding.c;
                            Intrinsics3.checkNotNullExpressionValue(textView4, "item.userProfileAdapterItemFriendMutualText");
                            textView4.setText(guild.getShortName());
                        }
                    }
                    i++;
                }
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public MutualFriendsAdapter(RecyclerView recyclerView, AppFragment appFragment) {
            super(recyclerView, false, 2, null);
            Intrinsics3.checkNotNullParameter(recyclerView, "recyclerView");
            Intrinsics3.checkNotNullParameter(appFragment, "fragment");
            this.fragment = appFragment;
        }

        public static final /* synthetic */ AppFragment access$getFragment$p(MutualFriendsAdapter mutualFriendsAdapter) {
            return mutualFriendsAdapter.fragment;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public /* bridge */ /* synthetic */ RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
            return onCreateViewHolder(viewGroup, i);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public MGRecyclerViewHolder<?, Model.Item> onCreateViewHolder(ViewGroup parent, int viewType) {
            Intrinsics3.checkNotNullParameter(parent, "parent");
            if (viewType == 0) {
                return new WidgetUserProfileEmptyListItem(R.layout.widget_user_profile_adapter_item_empty, this, R.attr.img_no_mutual_friends, R.string.no_mutual_friends);
            }
            if (viewType == 1) {
                return new ViewHolder(this);
            }
            throw invalidViewTypeException(viewType);
        }
    }

    /* compiled from: WidgetUserMutualFriends.kt */
    /* renamed from: com.discord.widgets.user.WidgetUserMutualFriends$onViewBoundOrOnResume$1, reason: invalid class name */
    public static final /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function1<Model, Unit> {
        public AnonymousClass1(WidgetUserMutualFriends widgetUserMutualFriends) {
            super(1, widgetUserMutualFriends, WidgetUserMutualFriends.class, "configureUI", "configureUI(Lcom/discord/widgets/user/WidgetUserMutualFriends$Model;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Model model) {
            invoke2(model);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Model model) {
            Intrinsics3.checkNotNullParameter(model, "p1");
            WidgetUserMutualFriends.access$configureUI((WidgetUserMutualFriends) this.receiver, model);
        }
    }

    public WidgetUserMutualFriends() {
        super(R.layout.widget_user_mutual_friends);
        this.binding = FragmentViewBindingDelegate3.viewBinding$default(this, WidgetUserMutualFriends4.INSTANCE, null, 2, null);
        this.userId = LazyJVM.lazy(new WidgetUserMutualFriends5(this));
    }

    public static final /* synthetic */ void access$configureUI(WidgetUserMutualFriends widgetUserMutualFriends, Model model) {
        widgetUserMutualFriends.configureUI(model);
    }

    private final void configureUI(Model data) {
        Resources resources = getResources();
        Intrinsics3.checkNotNullExpressionValue(resources, "resources");
        setActionBarTitle(StringResourceUtils.getQuantityString(resources, R.plurals.user_profile_mutual_friends_count, R.string.mutual_friends, data.getNumMutualFriends(), Integer.valueOf(data.getNumMutualFriends())));
        User user = data.getUser();
        setActionBarSubtitle(user != null ? user.getUsername() : null);
        MutualFriendsAdapter mutualFriendsAdapter = this.adapter;
        if (mutualFriendsAdapter != null) {
            mutualFriendsAdapter.setData(data.getItems());
        }
    }

    private final WidgetUserMutualFriendsBinding getBinding() {
        return (WidgetUserMutualFriendsBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    private final long getUserId() {
        return ((Number) this.userId.getValue()).longValue();
    }

    @Override // com.discord.app.AppFragment
    public void onViewBound(View view) {
        Intrinsics3.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        MGRecyclerAdapter.Companion companion = MGRecyclerAdapter.INSTANCE;
        RecyclerView recyclerView = getBinding().f2684b;
        Intrinsics3.checkNotNullExpressionValue(recyclerView, "binding.userMutualFriendsRecyclerView");
        this.adapter = (MutualFriendsAdapter) companion.configure(new MutualFriendsAdapter(recyclerView, this));
    }

    @Override // com.discord.app.AppFragment
    public void onViewBoundOrOnResume() {
        super.onViewBoundOrOnResume();
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(Model.INSTANCE.get(getUserId()), this, null, 2, null), WidgetUserMutualFriends.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass1(this), 62, (Object) null);
    }
}
