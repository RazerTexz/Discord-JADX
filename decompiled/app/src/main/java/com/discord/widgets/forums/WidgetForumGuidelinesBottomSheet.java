package com.discord.widgets.forums;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import androidx.core.os.Bundle2;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.Fragment2;
import androidx.fragment.app.FragmentManager;
import b.d.b.a.outline;
import com.discord.R;
import com.discord.api.channel.Channel;
import com.discord.app.AppBottomSheet;
import com.discord.databinding.WidgetForumGuidelinesBottomSheetBinding;
import com.discord.stores.StoreStream;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate3;
import d0.LazyJVM;
import d0.Tuples;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import kotlin.Lazy;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;
import rx.Observable;

/* compiled from: WidgetForumGuidelinesBottomSheet.kt */
/* loaded from: classes2.dex */
public final class WidgetForumGuidelinesBottomSheet extends AppBottomSheet {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {outline.d0(WidgetForumGuidelinesBottomSheet.class, "binding", "getBinding()Lcom/discord/databinding/WidgetForumGuidelinesBottomSheetBinding;", 0)};

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String EXTRA_REQUEST_KEY = "INTENT_EXTRA_REQUEST_KEY";

    /* renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;

    /* renamed from: channelId$delegate, reason: from kotlin metadata */
    private final Lazy channelId;

    /* renamed from: guildId$delegate, reason: from kotlin metadata */
    private final Lazy guildId;

    /* renamed from: requestKey$delegate, reason: from kotlin metadata */
    private final Lazy requestKey;

    /* compiled from: WidgetForumGuidelinesBottomSheet.kt */
    public static final class Companion {
        private Companion() {
        }

        public final void registerForResult(Fragment fragment, String requestKey, Function2<? super Long, ? super Long, Unit> onActionTaken) {
            Intrinsics3.checkNotNullParameter(fragment, "fragment");
            Intrinsics3.checkNotNullParameter(requestKey, "requestKey");
            Intrinsics3.checkNotNullParameter(onActionTaken, "onActionTaken");
            Fragment2.setFragmentResultListener(fragment, requestKey, new WidgetForumGuidelinesBottomSheet2(requestKey, onActionTaken));
        }

        public final void show(FragmentManager fragmentManager, long guildId, long parentChannelId, String requestKey) {
            Intrinsics3.checkNotNullParameter(fragmentManager, "fragmentManager");
            Intrinsics3.checkNotNullParameter(requestKey, "requestKey");
            ForumGuidelinesManager.INSTANCE.markGuidelinesSeen(parentChannelId);
            WidgetForumGuidelinesBottomSheet widgetForumGuidelinesBottomSheet = new WidgetForumGuidelinesBottomSheet();
            widgetForumGuidelinesBottomSheet.setArguments(Bundle2.bundleOf(Tuples.to("com.discord.intent.extra.EXTRA_GUILD_ID", Long.valueOf(guildId)), Tuples.to("com.discord.intent.extra.EXTRA_CHANNEL_ID", Long.valueOf(parentChannelId)), Tuples.to(WidgetForumGuidelinesBottomSheet.EXTRA_REQUEST_KEY, requestKey)));
            widgetForumGuidelinesBottomSheet.show(fragmentManager, WidgetForumGuidelinesBottomSheet.class.getSimpleName());
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: WidgetForumGuidelinesBottomSheet.kt */
    /* renamed from: com.discord.widgets.forums.WidgetForumGuidelinesBottomSheet$configureUI$1, reason: invalid class name */
    public static final class AnonymousClass1 implements View.OnClickListener {
        public final /* synthetic */ Bundle $bundle;

        public AnonymousClass1(Bundle bundle) {
            this.$bundle = bundle;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetForumGuidelinesBottomSheet.this.dismiss();
            WidgetForumGuidelinesBottomSheet widgetForumGuidelinesBottomSheet = WidgetForumGuidelinesBottomSheet.this;
            String strAccess$getRequestKey$p = WidgetForumGuidelinesBottomSheet.access$getRequestKey$p(widgetForumGuidelinesBottomSheet);
            Intrinsics3.checkNotNullExpressionValue(strAccess$getRequestKey$p, "requestKey");
            Fragment2.setFragmentResult(widgetForumGuidelinesBottomSheet, strAccess$getRequestKey$p, this.$bundle);
        }
    }

    /* compiled from: WidgetForumGuidelinesBottomSheet.kt */
    /* renamed from: com.discord.widgets.forums.WidgetForumGuidelinesBottomSheet$onResume$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function1<Channel, Unit> {
        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Channel channel) {
            invoke2(channel);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Channel channel) {
            Intrinsics3.checkNotNullParameter(channel, "channel");
            WidgetForumGuidelinesBottomSheet.access$configureUI(WidgetForumGuidelinesBottomSheet.this, channel);
        }
    }

    public WidgetForumGuidelinesBottomSheet() {
        super(false, 1, null);
        this.binding = FragmentViewBindingDelegate3.viewBinding$default(this, WidgetForumGuidelinesBottomSheet3.INSTANCE, null, 2, null);
        this.guildId = LazyJVM.lazy(new WidgetForumGuidelinesBottomSheet5(this));
        this.channelId = LazyJVM.lazy(new WidgetForumGuidelinesBottomSheet4(this));
        this.requestKey = LazyJVM.lazy(new WidgetForumGuidelinesBottomSheet6(this));
    }

    public static final /* synthetic */ void access$configureUI(WidgetForumGuidelinesBottomSheet widgetForumGuidelinesBottomSheet, Channel channel) {
        widgetForumGuidelinesBottomSheet.configureUI(channel);
    }

    public static final /* synthetic */ String access$getRequestKey$p(WidgetForumGuidelinesBottomSheet widgetForumGuidelinesBottomSheet) {
        return widgetForumGuidelinesBottomSheet.getRequestKey();
    }

    private final void configureUI(Channel channel) {
        TextView textView = getBinding().f2388b;
        Intrinsics3.checkNotNullExpressionValue(textView, "binding.channelTopic");
        textView.setText(channel.getTopic());
        Bundle bundle = new Bundle();
        bundle.putLong("com.discord.intent.extra.EXTRA_CHANNEL_ID", getChannelId());
        bundle.putLong("com.discord.intent.extra.EXTRA_GUILD_ID", getGuildId());
        getBinding().c.setOnClickListener(new AnonymousClass1(bundle));
    }

    private final WidgetForumGuidelinesBottomSheetBinding getBinding() {
        return (WidgetForumGuidelinesBottomSheetBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    private final long getChannelId() {
        return ((Number) this.channelId.getValue()).longValue();
    }

    private final long getGuildId() {
        return ((Number) this.guildId.getValue()).longValue();
    }

    private final String getRequestKey() {
        return (String) this.requestKey.getValue();
    }

    @Override // com.discord.app.AppBottomSheet
    public int getContentViewResId() {
        return R.layout.widget_forum_guidelines_bottom_sheet;
    }

    @Override // com.discord.app.AppBottomSheet, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        Observable<R> observableG = StoreStream.INSTANCE.getChannels().observeChannel(getChannelId()).y(ObservableExtensionsKt.AnonymousClass1.INSTANCE).G(ObservableExtensionsKt.AnonymousClass2.INSTANCE);
        Intrinsics3.checkNotNullExpressionValue(observableG, "filter { it != null }.map { it!! }");
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(observableG, this, null, 2, null), WidgetForumGuidelinesBottomSheet.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass1(), 62, (Object) null);
    }
}
