package com.discord.widgets.servers;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.TableLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.discord.C5419R;
import com.discord.databinding.WidgetServerSettingsChannelsSortFabMenuBinding;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate3;
import com.discord.utilities.views.FloatingButtonMenuInitializer;
import com.discord.widgets.channels.WidgetCreateChannel;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;
import p007b.p100d.p104b.p105a.outline;
import p507d0.Tuples;
import p507d0.p580t.Maps6;
import p507d0.p592z.p594d.Intrinsics3;
import p658rx.functions.Action0;

/* compiled from: WidgetServerSettingsChannelsFabMenuFragment.kt */
/* loaded from: classes2.dex */
public final class WidgetServerSettingsChannelsFabMenuFragment extends Fragment {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {outline.m846d0(WidgetServerSettingsChannelsFabMenuFragment.class, "binding", "getBinding()Lcom/discord/databinding/WidgetServerSettingsChannelsSortFabMenuBinding;", 0)};

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String INTENT_EXTRA_GUILD_ID = "INTENT_EXTRA_GUILD_ID";
    private static final String TAG = "channels fab menu";

    /* renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;
    private Action0 dismissHandler;

    /* compiled from: WidgetServerSettingsChannelsFabMenuFragment.kt */
    public static final class Companion {
        private Companion() {
        }

        public final void show(long guildId, FragmentManager fragmentManager, Action0 dismissHandler) {
            Intrinsics3.checkNotNullParameter(fragmentManager, "fragmentManager");
            Intrinsics3.checkNotNullParameter(dismissHandler, "dismissHandler");
            WidgetServerSettingsChannelsFabMenuFragment widgetServerSettingsChannelsFabMenuFragment = new WidgetServerSettingsChannelsFabMenuFragment();
            Bundle bundle = new Bundle();
            bundle.putLong("INTENT_EXTRA_GUILD_ID", guildId);
            widgetServerSettingsChannelsFabMenuFragment.setArguments(bundle);
            WidgetServerSettingsChannelsFabMenuFragment.access$setDismissHandler$p(widgetServerSettingsChannelsFabMenuFragment, dismissHandler);
            fragmentManager.beginTransaction().setCustomAnimations(C5419R.anim.anim_fade_in, C5419R.anim.anim_fade_out).add(C5419R.id.widget_server_settings_channels_container, widgetServerSettingsChannelsFabMenuFragment, WidgetServerSettingsChannelsFabMenuFragment.TAG).addToBackStack(WidgetServerSettingsChannelsFabMenuFragment.TAG).commit();
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: WidgetServerSettingsChannelsFabMenuFragment.kt */
    /* renamed from: com.discord.widgets.servers.WidgetServerSettingsChannelsFabMenuFragment$createListener$1 */
    public static final class ViewOnClickListenerC92081 implements View.OnClickListener {
        public final /* synthetic */ View.OnClickListener $onClickListener;

        public ViewOnClickListenerC92081(View.OnClickListener onClickListener) {
            this.$onClickListener = onClickListener;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            View.OnClickListener onClickListener = this.$onClickListener;
            if (onClickListener != null) {
                onClickListener.onClick(view);
            }
            WidgetServerSettingsChannelsFabMenuFragment.access$dismiss(WidgetServerSettingsChannelsFabMenuFragment.this);
        }
    }

    /* compiled from: WidgetServerSettingsChannelsFabMenuFragment.kt */
    /* renamed from: com.discord.widgets.servers.WidgetServerSettingsChannelsFabMenuFragment$onResume$1 */
    public static final class ViewOnClickListenerC92091 implements View.OnClickListener {
        public ViewOnClickListenerC92091() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetServerSettingsChannelsFabMenuFragment.access$dismiss(WidgetServerSettingsChannelsFabMenuFragment.this);
        }
    }

    /* compiled from: WidgetServerSettingsChannelsFabMenuFragment.kt */
    /* renamed from: com.discord.widgets.servers.WidgetServerSettingsChannelsFabMenuFragment$onResume$2 */
    public static final class ViewOnClickListenerC92102 implements View.OnClickListener {
        public final /* synthetic */ long $guildId;

        public ViewOnClickListenerC92102(long j) {
            this.$guildId = j;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetCreateChannel.Companion companion = WidgetCreateChannel.INSTANCE;
            Context contextRequireContext = WidgetServerSettingsChannelsFabMenuFragment.this.requireContext();
            Intrinsics3.checkNotNullExpressionValue(contextRequireContext, "requireContext()");
            WidgetCreateChannel.Companion.show$default(companion, contextRequireContext, this.$guildId, 4, null, 8, null);
        }
    }

    /* compiled from: WidgetServerSettingsChannelsFabMenuFragment.kt */
    /* renamed from: com.discord.widgets.servers.WidgetServerSettingsChannelsFabMenuFragment$onResume$3 */
    public static final class ViewOnClickListenerC92113 implements View.OnClickListener {
        public final /* synthetic */ long $guildId;

        public ViewOnClickListenerC92113(long j) {
            this.$guildId = j;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetCreateChannel.Companion companion = WidgetCreateChannel.INSTANCE;
            Context contextRequireContext = WidgetServerSettingsChannelsFabMenuFragment.this.requireContext();
            Intrinsics3.checkNotNullExpressionValue(contextRequireContext, "requireContext()");
            WidgetCreateChannel.Companion.show$default(companion, contextRequireContext, this.$guildId, 2, null, 8, null);
        }
    }

    /* compiled from: WidgetServerSettingsChannelsFabMenuFragment.kt */
    /* renamed from: com.discord.widgets.servers.WidgetServerSettingsChannelsFabMenuFragment$onResume$4 */
    public static final class ViewOnClickListenerC92124 implements View.OnClickListener {
        public final /* synthetic */ long $guildId;

        public ViewOnClickListenerC92124(long j) {
            this.$guildId = j;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetCreateChannel.Companion companion = WidgetCreateChannel.INSTANCE;
            Context contextRequireContext = WidgetServerSettingsChannelsFabMenuFragment.this.requireContext();
            Intrinsics3.checkNotNullExpressionValue(contextRequireContext, "requireContext()");
            WidgetCreateChannel.Companion.show$default(companion, contextRequireContext, this.$guildId, 0, null, 8, null);
        }
    }

    /* compiled from: WidgetServerSettingsChannelsFabMenuFragment.kt */
    /* renamed from: com.discord.widgets.servers.WidgetServerSettingsChannelsFabMenuFragment$onResume$5 */
    public static final class ViewOnClickListenerC92135 implements View.OnClickListener {
        public static final ViewOnClickListenerC92135 INSTANCE = new ViewOnClickListenerC92135();

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
        }
    }

    /* compiled from: WidgetServerSettingsChannelsFabMenuFragment.kt */
    /* renamed from: com.discord.widgets.servers.WidgetServerSettingsChannelsFabMenuFragment$onResume$6 */
    public static final class ViewOnClickListenerC92146 implements View.OnClickListener {
        public ViewOnClickListenerC92146() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetServerSettingsChannelsFabMenuFragment.access$dismiss(WidgetServerSettingsChannelsFabMenuFragment.this);
        }
    }

    public WidgetServerSettingsChannelsFabMenuFragment() {
        super(C5419R.layout.widget_server_settings_channels_sort_fab_menu);
        this.binding = FragmentViewBindingDelegate3.viewBinding$default(this, WidgetServerSettingsChannelsFabMenuFragment2.INSTANCE, null, 2, null);
    }

    public static final /* synthetic */ void access$dismiss(WidgetServerSettingsChannelsFabMenuFragment widgetServerSettingsChannelsFabMenuFragment) {
        widgetServerSettingsChannelsFabMenuFragment.dismiss();
    }

    public static final /* synthetic */ Action0 access$getDismissHandler$p(WidgetServerSettingsChannelsFabMenuFragment widgetServerSettingsChannelsFabMenuFragment) {
        return widgetServerSettingsChannelsFabMenuFragment.dismissHandler;
    }

    public static final /* synthetic */ void access$setDismissHandler$p(WidgetServerSettingsChannelsFabMenuFragment widgetServerSettingsChannelsFabMenuFragment, Action0 action0) {
        widgetServerSettingsChannelsFabMenuFragment.dismissHandler = action0;
    }

    private final View.OnClickListener createListener(View.OnClickListener onClickListener) {
        return new ViewOnClickListenerC92081(onClickListener);
    }

    private final void dismiss() {
        getParentFragmentManager().beginTransaction().remove(this).commit();
        Action0 action0 = this.dismissHandler;
        if (action0 != null) {
            action0.call();
        }
    }

    private final WidgetServerSettingsChannelsSortFabMenuBinding getBinding() {
        return (WidgetServerSettingsChannelsSortFabMenuBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    public static final void show(long j, FragmentManager fragmentManager, Action0 action0) {
        INSTANCE.show(j, fragmentManager, action0);
    }

    @Override // androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        dismiss();
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        WidgetServerSettingsChannelsSortFabMenuBinding binding = getBinding();
        Intrinsics3.checkNotNullExpressionValue(binding, "binding");
        binding.f17573a.setOnClickListener(new ViewOnClickListenerC92091());
        Bundle arguments = getArguments();
        long j = arguments != null ? arguments.getLong("INTENT_EXTRA_GUILD_ID", 0L) : 0L;
        Context contextRequireContext = requireContext();
        Intrinsics3.checkNotNullExpressionValue(contextRequireContext, "requireContext()");
        FloatingButtonMenuInitializer floatingButtonMenuInitializer = new FloatingButtonMenuInitializer(contextRequireContext, Maps6.mapOf(Tuples.m10073to(Integer.valueOf(C5419R.id.fab_menu_add_category), createListener(new ViewOnClickListenerC92102(j))), Tuples.m10073to(Integer.valueOf(C5419R.id.fab_menu_add_voice), createListener(new ViewOnClickListenerC92113(j))), Tuples.m10073to(Integer.valueOf(C5419R.id.fab_menu_add_text), createListener(new ViewOnClickListenerC92124(j))), Tuples.m10073to(Integer.valueOf(C5419R.id.fab_menu_main), createListener(ViewOnClickListenerC92135.INSTANCE))));
        TableLayout tableLayout = getBinding().f17575c;
        Intrinsics3.checkNotNullExpressionValue(tableLayout, "binding.fabMenuTable");
        FloatingActionButton floatingActionButton = getBinding().f17574b;
        Intrinsics3.checkNotNullExpressionValue(floatingActionButton, "binding.fabMenuMainFab");
        floatingButtonMenuInitializer.initialize(tableLayout, floatingActionButton, new ViewOnClickListenerC92146());
    }
}
