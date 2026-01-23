package com.discord.widgets.channels.permissions;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.core.os.Bundle2;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentContainerView;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import com.discord.C5419R;
import com.discord.api.channel.Channel;
import com.discord.api.channel.ChannelUtils;
import com.discord.api.permission.PermissionOverwrite;
import com.discord.app.AppBottomSheet;
import com.discord.databinding.WidgetChannelSettingsAddMemberSheetBinding;
import com.discord.stores.StoreStream;
import com.discord.utilities.channel.permissions.ChannelPermissionsAddMemberUtils;
import com.discord.utilities.p501rx.ObservableExtensionsKt;
import com.discord.utilities.view.extensions.ViewExtensions;
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
import p007b.p100d.p104b.p105a.outline;
import p507d0.LazyJVM;
import p507d0.Tuples;
import p507d0.p592z.p594d.Intrinsics3;
import p507d0.p592z.p594d.Lambda;
import p658rx.subjects.BehaviorSubject;

/* JADX INFO: compiled from: WidgetChannelSettingsAddMemberSheet.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChannelSettingsAddMemberSheet extends AppBottomSheet {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {outline.m846d0(WidgetChannelSettingsAddMemberSheet.class, "binding", "getBinding()Lcom/discord/databinding/WidgetChannelSettingsAddMemberSheetBinding;", 0)};

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* JADX INFO: renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;

    /* JADX INFO: renamed from: channelId$delegate, reason: from kotlin metadata */
    private final Lazy channelId;
    private WidgetChannelSettingsAddMemberFragment fragment;

    /* JADX INFO: compiled from: WidgetChannelSettingsAddMemberSheet.kt */
    public static final class Companion {
        private Companion() {
        }

        public final void show(FragmentManager fragmentManager, long channelId) {
            Intrinsics3.checkNotNullParameter(fragmentManager, "fragmentManager");
            WidgetChannelSettingsAddMemberSheet widgetChannelSettingsAddMemberSheet = new WidgetChannelSettingsAddMemberSheet();
            widgetChannelSettingsAddMemberSheet.setArguments(Bundle2.bundleOf(Tuples.m10073to("com.discord.intent.extra.EXTRA_CHANNEL_ID", Long.valueOf(channelId))));
            widgetChannelSettingsAddMemberSheet.show(fragmentManager, WidgetChannelSettingsAddMemberSheet.class.getName());
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.channels.permissions.WidgetChannelSettingsAddMemberSheet$addPermissionOverwrites$1 */
    /* JADX INFO: compiled from: WidgetChannelSettingsAddMemberSheet.kt */
    public static final class C75311 extends Lambda implements Function1<List<? extends Void>, Unit> {
        public C75311() {
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
            WidgetChannelSettingsAddMemberSheet.this.dismiss();
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.channels.permissions.WidgetChannelSettingsAddMemberSheet$configureUI$1 */
    /* JADX INFO: compiled from: WidgetChannelSettingsAddMemberSheet.kt */
    public static final class ViewOnClickListenerC75321 implements View.OnClickListener {
        public ViewOnClickListenerC75321() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetChannelSettingsAddMemberSheet.access$addPermissionOverwrites(WidgetChannelSettingsAddMemberSheet.this);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.channels.permissions.WidgetChannelSettingsAddMemberSheet$onResume$1 */
    /* JADX INFO: compiled from: WidgetChannelSettingsAddMemberSheet.kt */
    public static final class C75331 extends Lambda implements Function1<Channel, Unit> {
        public C75331() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Channel channel) {
            invoke2(channel);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Channel channel) {
            if (channel == null) {
                WidgetChannelSettingsAddMemberSheet.this.dismiss();
            } else {
                WidgetChannelSettingsAddMemberSheet.access$configureUI(WidgetChannelSettingsAddMemberSheet.this, channel);
            }
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.channels.permissions.WidgetChannelSettingsAddMemberSheet$onResume$2 */
    /* JADX INFO: compiled from: WidgetChannelSettingsAddMemberSheet.kt */
    public static final class C75342 extends Lambda implements Function1<Map<Long, ? extends PermissionOverwrite.Type>, Unit> {
        public C75342() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Map<Long, ? extends PermissionOverwrite.Type> map) {
            invoke2(map);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Map<Long, ? extends PermissionOverwrite.Type> map) {
            TextView textView = WidgetChannelSettingsAddMemberSheet.access$getBinding$p(WidgetChannelSettingsAddMemberSheet.this).f15905b;
            Intrinsics3.checkNotNullExpressionValue(textView, "binding.addButton");
            Intrinsics3.checkNotNullExpressionValue(map, "selected");
            ViewExtensions.setEnabledAndAlpha$default(textView, !map.isEmpty(), 0.0f, 2, null);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.channels.permissions.WidgetChannelSettingsAddMemberSheet$onViewCreated$1 */
    /* JADX INFO: compiled from: WidgetChannelSettingsAddMemberSheet.kt */
    public static final class RunnableC75351 implements Runnable {
        public final /* synthetic */ View $view;

        public RunnableC75351(View view) {
            this.$view = view;
        }

        @Override // java.lang.Runnable
        public final void run() {
            ViewGroup.LayoutParams layoutParams = this.$view.getLayoutParams();
            if (layoutParams != null) {
                Resources resources = WidgetChannelSettingsAddMemberSheet.this.getResources();
                Intrinsics3.checkNotNullExpressionValue(resources, "resources");
                layoutParams.height = (int) (((double) resources.getDisplayMetrics().heightPixels) * 0.9d);
            }
        }
    }

    public WidgetChannelSettingsAddMemberSheet() {
        super(false, 1, null);
        this.binding = FragmentViewBindingDelegate3.viewBinding$default(this, WidgetChannelSettingsAddMemberSheet2.INSTANCE, null, 2, null);
        this.channelId = LazyJVM.lazy(new WidgetChannelSettingsAddMemberSheet3(this));
    }

    public static final /* synthetic */ void access$addPermissionOverwrites(WidgetChannelSettingsAddMemberSheet widgetChannelSettingsAddMemberSheet) {
        widgetChannelSettingsAddMemberSheet.addPermissionOverwrites();
    }

    public static final /* synthetic */ void access$configureUI(WidgetChannelSettingsAddMemberSheet widgetChannelSettingsAddMemberSheet, Channel channel) {
        widgetChannelSettingsAddMemberSheet.configureUI(channel);
    }

    public static final /* synthetic */ Bundle access$getArgumentsOrDefault$p(WidgetChannelSettingsAddMemberSheet widgetChannelSettingsAddMemberSheet) {
        return widgetChannelSettingsAddMemberSheet.getArgumentsOrDefault();
    }

    public static final /* synthetic */ WidgetChannelSettingsAddMemberSheetBinding access$getBinding$p(WidgetChannelSettingsAddMemberSheet widgetChannelSettingsAddMemberSheet) {
        return widgetChannelSettingsAddMemberSheet.getBinding();
    }

    private final void addPermissionOverwrites() {
        ChannelPermissionsAddMemberUtils channelPermissionsAddMemberUtils = ChannelPermissionsAddMemberUtils.INSTANCE;
        long channelId = getChannelId();
        WidgetChannelSettingsAddMemberFragment widgetChannelSettingsAddMemberFragment = this.fragment;
        if (widgetChannelSettingsAddMemberFragment == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("fragment");
        }
        BehaviorSubject<Map<Long, PermissionOverwrite.Type>> selectedItemsSubject = widgetChannelSettingsAddMemberFragment.getSelectedItemsSubject();
        Intrinsics3.checkNotNullExpressionValue(selectedItemsSubject, "fragment.getSelectedItemsSubject()");
        Map<Long, PermissionOverwrite.Type> mapM11132n0 = selectedItemsSubject.m11132n0();
        Intrinsics3.checkNotNullExpressionValue(mapM11132n0, "fragment.getSelectedItemsSubject().value");
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(channelPermissionsAddMemberUtils.addPermissionOverwrites(channelId, mapM11132n0, 20971536L), this, null, 2, null), WidgetChannelSettingsAddMemberSheet.class, getContext(), (Function1) null, (Function1) null, (Function0) null, (Function0) null, new C75311(), 60, (Object) null);
    }

    @SuppressLint({"SetTextI18n"})
    private final void configureUI(Channel channel) {
        TextView textView = getBinding().f15907d;
        Intrinsics3.checkNotNullExpressionValue(textView, "binding.subtitle");
        Context contextRequireContext = requireContext();
        Intrinsics3.checkNotNullExpressionValue(contextRequireContext, "requireContext()");
        textView.setText(ChannelUtils.m7681e(channel, contextRequireContext, false, 2));
        getBinding().f15905b.setOnClickListener(new ViewOnClickListenerC75321());
    }

    private final WidgetChannelSettingsAddMemberSheetBinding getBinding() {
        return (WidgetChannelSettingsAddMemberSheetBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    private final long getChannelId() {
        return ((Number) this.channelId.getValue()).longValue();
    }

    @Override // com.discord.app.AppBottomSheet
    public int getContentViewResId() {
        return C5419R.layout.widget_channel_settings_add_member_sheet;
    }

    @Override // com.discord.app.AppBottomSheet, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(StoreStream.INSTANCE.getChannels().observeChannel(getChannelId()), this, null, 2, null), WidgetChannelSettingsAddMemberSheet.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new C75331(), 62, (Object) null);
        WidgetChannelSettingsAddMemberFragment widgetChannelSettingsAddMemberFragment = this.fragment;
        if (widgetChannelSettingsAddMemberFragment == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("fragment");
        }
        BehaviorSubject<Map<Long, PermissionOverwrite.Type>> selectedItemsSubject = widgetChannelSettingsAddMemberFragment.getSelectedItemsSubject();
        Intrinsics3.checkNotNullExpressionValue(selectedItemsSubject, "fragment.getSelectedItemsSubject()");
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(selectedItemsSubject, this, null, 2, null), WidgetChannelSettingsAddMemberSheet.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new C75342(), 62, (Object) null);
    }

    @Override // com.discord.app.AppBottomSheet, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics3.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        this.fragment = WidgetChannelSettingsAddMemberFragment.INSTANCE.create(getChannelId(), false);
        FragmentTransaction fragmentTransactionBeginTransaction = getChildFragmentManager().beginTransaction();
        FragmentContainerView fragmentContainerView = getBinding().f15906c;
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
        fragmentTransactionBeginTransaction.replace(id2, widgetChannelSettingsAddMemberFragment, widgetChannelSettingsAddMemberFragment2.getClass().getSimpleName()).runOnCommit(new RunnableC75351(view)).commit();
    }
}
