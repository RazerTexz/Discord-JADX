package com.discord.widgets.stage.sheet;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import androidx.core.os.Bundle2;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import b.a.d.AppToast;
import b.d.b.a.outline;
import com.discord.R;
import com.discord.api.channel.Channel;
import com.discord.app.AppBottomSheet;
import com.discord.databinding.WidgetStageModeratorJoinBottomSheetBinding;
import com.discord.stores.StoreStream;
import com.discord.utilities.rest.RestAPI;
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
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;

/* compiled from: WidgetStageModeratorJoinBottomSheet.kt */
/* loaded from: classes2.dex */
public final class WidgetStageModeratorJoinBottomSheet extends AppBottomSheet {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {outline.d0(WidgetStageModeratorJoinBottomSheet.class, "binding", "getBinding()Lcom/discord/databinding/WidgetStageModeratorJoinBottomSheetBinding;", 0)};

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;

    /* renamed from: channelId$delegate, reason: from kotlin metadata */
    private final Lazy channelId;

    /* compiled from: WidgetStageModeratorJoinBottomSheet.kt */
    public static final class Companion {
        private Companion() {
        }

        public final void show(FragmentManager fragmentManager, long channelId) {
            Intrinsics3.checkNotNullParameter(fragmentManager, "fragmentManager");
            WidgetStageModeratorJoinBottomSheet widgetStageModeratorJoinBottomSheet = new WidgetStageModeratorJoinBottomSheet();
            widgetStageModeratorJoinBottomSheet.setArguments(Bundle2.bundleOf(Tuples.to("com.discord.intent.extra.EXTRA_CHANNEL_ID", Long.valueOf(channelId))));
            widgetStageModeratorJoinBottomSheet.show(fragmentManager, WidgetStageModeratorJoinBottomSheet.class.getSimpleName());
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: WidgetStageModeratorJoinBottomSheet.kt */
    /* renamed from: com.discord.widgets.stage.sheet.WidgetStageModeratorJoinBottomSheet$onViewCreated$1, reason: invalid class name */
    public static final class AnonymousClass1 implements View.OnClickListener {

        /* compiled from: WidgetStageModeratorJoinBottomSheet.kt */
        /* renamed from: com.discord.widgets.stage.sheet.WidgetStageModeratorJoinBottomSheet$onViewCreated$1$1, reason: invalid class name and collision with other inner class name */
        public static final class C03441 extends Lambda implements Function0<Unit> {
            public C03441() {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                AppToast.g(WidgetStageModeratorJoinBottomSheet.this.getContext(), R.string.stage_channel_permission_microphone_denied, 0, null, 12);
            }
        }

        /* compiled from: WidgetStageModeratorJoinBottomSheet.kt */
        /* renamed from: com.discord.widgets.stage.sheet.WidgetStageModeratorJoinBottomSheet$onViewCreated$1$2, reason: invalid class name */
        public static final class AnonymousClass2 extends Lambda implements Function0<Unit> {
            public AnonymousClass2() {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                WidgetStageModeratorJoinBottomSheet.access$setSelfSpeaker(WidgetStageModeratorJoinBottomSheet.this);
            }
        }

        public AnonymousClass1() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetStageModeratorJoinBottomSheet.this.requestMicrophone(new C03441(), new AnonymousClass2());
        }
    }

    /* compiled from: WidgetStageModeratorJoinBottomSheet.kt */
    /* renamed from: com.discord.widgets.stage.sheet.WidgetStageModeratorJoinBottomSheet$onViewCreated$2, reason: invalid class name */
    public static final class AnonymousClass2 implements View.OnClickListener {
        public AnonymousClass2() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetStageModeratorJoinBottomSheet.this.dismiss();
        }
    }

    /* compiled from: WidgetStageModeratorJoinBottomSheet.kt */
    /* renamed from: com.discord.widgets.stage.sheet.WidgetStageModeratorJoinBottomSheet$setSelfSpeaker$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function1<Void, Unit> {
        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Void r1) {
            invoke2(r1);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Void r1) {
            WidgetStageModeratorJoinBottomSheet.this.dismiss();
        }
    }

    public WidgetStageModeratorJoinBottomSheet() {
        super(false, 1, null);
        this.binding = FragmentViewBindingDelegate3.viewBinding$default(this, WidgetStageModeratorJoinBottomSheet2.INSTANCE, null, 2, null);
        this.channelId = LazyJVM.lazy(new WidgetStageModeratorJoinBottomSheet3(this));
    }

    public static final /* synthetic */ Bundle access$getArgumentsOrDefault$p(WidgetStageModeratorJoinBottomSheet widgetStageModeratorJoinBottomSheet) {
        return widgetStageModeratorJoinBottomSheet.getArgumentsOrDefault();
    }

    public static final /* synthetic */ void access$setSelfSpeaker(WidgetStageModeratorJoinBottomSheet widgetStageModeratorJoinBottomSheet) {
        widgetStageModeratorJoinBottomSheet.setSelfSpeaker();
    }

    private final WidgetStageModeratorJoinBottomSheetBinding getBinding() {
        return (WidgetStageModeratorJoinBottomSheetBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    private final long getChannelId() {
        return ((Number) this.channelId.getValue()).longValue();
    }

    private final void setSelfSpeaker() {
        Channel channel = StoreStream.INSTANCE.getChannels().getChannel(getChannelId());
        if (channel != null) {
            ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.restSubscribeOn$default(RestAPI.INSTANCE.getApiSerializeNulls().setMeSuppressed(channel, false), false, 1, null), this, null, 2, null), WidgetStageModeratorJoinBottomSheet.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass1(), 62, (Object) null);
        }
    }

    @Override // com.discord.app.AppBottomSheet
    public int getContentViewResId() {
        return R.layout.widget_stage_moderator_join_bottom_sheet;
    }

    @Override // com.discord.app.AppBottomSheet, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics3.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        getBinding().c.setOnClickListener(new AnonymousClass1());
        getBinding().f2656b.setOnClickListener(new AnonymousClass2());
    }
}
