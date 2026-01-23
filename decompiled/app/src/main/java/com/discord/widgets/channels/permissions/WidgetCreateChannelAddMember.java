package com.discord.widgets.channels.permissions;

import android.content.Context;
import android.content.Intent;
import android.view.MenuItem;
import android.view.View;
import androidx.core.app.NotificationCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentContainerView;
import androidx.fragment.app.FragmentTransaction;
import com.discord.C5419R;
import com.discord.api.channel.Channel;
import com.discord.api.permission.PermissionOverwrite;
import com.discord.app.AppFragment;
import com.discord.app.AppLogger2;
import com.discord.databinding.WidgetCreateChannelAddMemberBinding;
import com.discord.stores.StoreStream;
import com.discord.utilities.channel.permissions.ChannelPermissionsAddMemberUtils;
import com.discord.utilities.p501rx.ObservableExtensionsKt;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate3;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;
import p007b.p008a.p018d.AppScreen2;
import p007b.p100d.p104b.p105a.outline;
import p507d0.LazyJVM;
import p507d0.p592z.p594d.Intrinsics3;
import p507d0.p592z.p594d.Lambda;
import p658rx.functions.Action2;
import p658rx.subjects.BehaviorSubject;

/* JADX INFO: compiled from: WidgetCreateChannelAddMember.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetCreateChannelAddMember extends AppFragment {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {outline.m846d0(WidgetCreateChannelAddMember.class, "binding", "getBinding()Lcom/discord/databinding/WidgetCreateChannelAddMemberBinding;", 0)};

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* JADX INFO: renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;

    /* JADX INFO: renamed from: channelId$delegate, reason: from kotlin metadata */
    private final Lazy channelId;
    private WidgetChannelSettingsAddMemberFragment fragment;
    private final AppLogger2 loggingConfig;

    /* JADX INFO: compiled from: WidgetCreateChannelAddMember.kt */
    public static final class Companion {
        private Companion() {
        }

        public final void create(Context context, long channelId) {
            Intrinsics3.checkNotNullParameter(context, "context");
            Intent intent = new Intent();
            intent.putExtra("com.discord.intent.extra.EXTRA_CHANNEL_ID", channelId);
            AppScreen2.m156d(context, WidgetCreateChannelAddMember.class, intent);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.channels.permissions.WidgetCreateChannelAddMember$addPermissionOverwrites$1 */
    /* JADX INFO: compiled from: WidgetCreateChannelAddMember.kt */
    public static final class C75571 extends Lambda implements Function1<List<? extends Void>, Unit> {
        public C75571() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(List<? extends Void> list) {
            invoke2((List<Void>) list);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(List<Void> list) {
            Intrinsics3.checkNotNullParameter(list, "it");
            FragmentActivity activity = WidgetCreateChannelAddMember.this.getActivity();
            if (activity != null) {
                activity.finish();
            }
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.channels.permissions.WidgetCreateChannelAddMember$onViewBound$1 */
    /* JADX INFO: compiled from: WidgetCreateChannelAddMember.kt */
    public static final class C75581 extends Lambda implements Function1<Channel, Unit> {
        public C75581() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Channel channel) {
            invoke2(channel);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Channel channel) {
            WidgetCreateChannelAddMember.access$configureUI(WidgetCreateChannelAddMember.this, channel);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.channels.permissions.WidgetCreateChannelAddMember$onViewBound$2 */
    /* JADX INFO: compiled from: WidgetCreateChannelAddMember.kt */
    public static final class C75592 extends Lambda implements Function1<Map<Long, ? extends PermissionOverwrite.Type>, Unit> {

        /* JADX INFO: renamed from: com.discord.widgets.channels.permissions.WidgetCreateChannelAddMember$onViewBound$2$1, reason: invalid class name */
        /* JADX INFO: compiled from: WidgetCreateChannelAddMember.kt */
        public static final class AnonymousClass1<T1, T2> implements Action2<MenuItem, Context> {
            public final /* synthetic */ Map $selected;

            public AnonymousClass1(Map map) {
                this.$selected = map;
            }

            @Override // p658rx.functions.Action2
            public /* bridge */ /* synthetic */ void call(MenuItem menuItem, Context context) {
                call2(menuItem, context);
            }

            /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
            public final void call2(MenuItem menuItem, Context context) {
                Intrinsics3.checkNotNullExpressionValue(menuItem, "menuItem");
                if (menuItem.getItemId() != C5419R.id.menu_continue) {
                    return;
                }
                WidgetCreateChannelAddMember widgetCreateChannelAddMember = WidgetCreateChannelAddMember.this;
                Map map = this.$selected;
                Intrinsics3.checkNotNullExpressionValue(map, "selected");
                WidgetCreateChannelAddMember.access$addPermissionOverwrites(widgetCreateChannelAddMember, map);
            }
        }

        public C75592() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Map<Long, ? extends PermissionOverwrite.Type> map) {
            invoke2(map);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Map<Long, ? extends PermissionOverwrite.Type> map) {
            AppFragment.setActionBarOptionsMenu$default(WidgetCreateChannelAddMember.this, C5419R.menu.menu_add_member_continue, new AnonymousClass1(map), null, 4, null);
        }
    }

    public WidgetCreateChannelAddMember() {
        super(C5419R.layout.widget_create_channel_add_member);
        this.binding = FragmentViewBindingDelegate3.viewBinding$default(this, WidgetCreateChannelAddMember2.INSTANCE, null, 2, null);
        this.channelId = LazyJVM.lazy(new WidgetCreateChannelAddMember3(this));
        this.loggingConfig = new AppLogger2(false, null, WidgetCreateChannelAddMember4.INSTANCE, 3);
    }

    public static final /* synthetic */ void access$addPermissionOverwrites(WidgetCreateChannelAddMember widgetCreateChannelAddMember, Map map) {
        widgetCreateChannelAddMember.addPermissionOverwrites(map);
    }

    public static final /* synthetic */ void access$configureUI(WidgetCreateChannelAddMember widgetCreateChannelAddMember, Channel channel) {
        widgetCreateChannelAddMember.configureUI(channel);
    }

    private final void addPermissionOverwrites(Map<Long, ? extends PermissionOverwrite.Type> selected) {
        if (!selected.isEmpty()) {
            ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(ChannelPermissionsAddMemberUtils.INSTANCE.addPermissionOverwrites(getChannelId(), selected, 20971536L), this, null, 2, null), WidgetCreateChannelAddMember.class, getContext(), (Function1) null, (Function1) null, (Function0) null, (Function0) null, new C75571(), 60, (Object) null);
            return;
        }
        FragmentActivity activity = getActivity();
        if (activity != null) {
            activity.finish();
        }
    }

    private final void configureUI(Channel channel) {
        if (channel != null) {
            setActionBarSubtitle(channel.getName());
            return;
        }
        FragmentActivity activity = getActivity();
        if (activity != null) {
            activity.finish();
        }
    }

    private final WidgetCreateChannelAddMemberBinding getBinding() {
        return (WidgetCreateChannelAddMemberBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    private final long getChannelId() {
        return ((Number) this.channelId.getValue()).longValue();
    }

    @Override // com.discord.app.AppFragment, com.discord.app.AppLogger.InterfaceC5455a
    public AppLogger2 getLoggingConfig() {
        return this.loggingConfig;
    }

    @Override // com.discord.app.AppFragment
    public void onViewBound(View view) {
        Intrinsics3.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        this.fragment = WidgetChannelSettingsAddMemberFragment.INSTANCE.create(getChannelId(), true);
        FragmentTransaction fragmentTransactionBeginTransaction = getChildFragmentManager().beginTransaction();
        FragmentContainerView fragmentContainerView = getBinding().f16418b;
        Intrinsics3.checkNotNullExpressionValue(fragmentContainerView, "binding.content");
        int id2 = fragmentContainerView.getId();
        WidgetChannelSettingsAddMemberFragment widgetChannelSettingsAddMemberFragment = this.fragment;
        if (widgetChannelSettingsAddMemberFragment == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("fragment");
        }
        WidgetChannelSettingsAddMemberFragment widgetChannelSettingsAddMemberFragment2 = this.fragment;
        if (widgetChannelSettingsAddMemberFragment2 == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("fragment");
        }
        fragmentTransactionBeginTransaction.replace(id2, widgetChannelSettingsAddMemberFragment, widgetChannelSettingsAddMemberFragment2.getClass().getSimpleName()).commit();
        setActionBarDisplayHomeAsUpEnabled(true);
        setActionBarTitle(C5419R.string.channel_permissions_add_moderator_title);
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(StoreStream.INSTANCE.getChannels().observeChannel(getChannelId()), this, null, 2, null), WidgetCreateChannelAddMember.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new C75581(), 62, (Object) null);
        WidgetChannelSettingsAddMemberFragment widgetChannelSettingsAddMemberFragment3 = this.fragment;
        if (widgetChannelSettingsAddMemberFragment3 == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("fragment");
        }
        BehaviorSubject<Map<Long, PermissionOverwrite.Type>> selectedItemsSubject = widgetChannelSettingsAddMemberFragment3.getSelectedItemsSubject();
        Intrinsics3.checkNotNullExpressionValue(selectedItemsSubject, "fragment.getSelectedItemsSubject()");
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(selectedItemsSubject, this, null, 2, null), WidgetCreateChannelAddMember.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new C75592(), 62, (Object) null);
    }
}
