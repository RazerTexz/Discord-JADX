package com.discord.widgets.guildscheduledevent;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import androidx.core.os.Bundle2;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.Fragment2;
import androidx.fragment.app.FragmentManager;
import com.discord.C5419R;
import com.discord.app.AppBottomSheet;
import com.discord.databinding.WidgetEndStageBottomSheetBinding;
import com.discord.utilities.p501rx.ObservableExtensionsKt;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate3;
import com.discord.views.ScreenTitleView;
import com.google.android.material.button.MaterialButton;
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

/* compiled from: WidgetEndGuildScheduledEventBottomSheet.kt */
/* loaded from: classes2.dex */
public final class WidgetEndGuildScheduledEventBottomSheet extends AppBottomSheet {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {outline.m846d0(WidgetEndGuildScheduledEventBottomSheet.class, "binding", "getBinding()Lcom/discord/databinding/WidgetEndStageBottomSheetBinding;", 0)};

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String EXTRA_REQUEST_KEY = "INTENT_EXTRA_REQUEST_KEY";

    /* renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;

    /* renamed from: guildId$delegate, reason: from kotlin metadata */
    private final Lazy guildId;

    /* renamed from: guildScheduledEventId$delegate, reason: from kotlin metadata */
    private final Lazy guildScheduledEventId;

    /* renamed from: requestKey$delegate, reason: from kotlin metadata */
    private final Lazy requestKey;

    /* compiled from: WidgetEndGuildScheduledEventBottomSheet.kt */
    public static final class Companion {
        private Companion() {
        }

        public final void registerForResult(Fragment fragment, String requestKey, Function0<Unit> onActionTaken) {
            Intrinsics3.checkNotNullParameter(fragment, "fragment");
            Intrinsics3.checkNotNullParameter(requestKey, "requestKey");
            Intrinsics3.checkNotNullParameter(onActionTaken, "onActionTaken");
            Fragment2.setFragmentResultListener(fragment, requestKey, new WidgetEndGuildScheduledEventBottomSheet2(requestKey, onActionTaken));
        }

        public final void show(FragmentManager fragmentManager, String requestKey, long guildId, long guildScheduledEventId) {
            Intrinsics3.checkNotNullParameter(fragmentManager, "fragmentManager");
            Intrinsics3.checkNotNullParameter(requestKey, "requestKey");
            WidgetEndGuildScheduledEventBottomSheet widgetEndGuildScheduledEventBottomSheet = new WidgetEndGuildScheduledEventBottomSheet();
            widgetEndGuildScheduledEventBottomSheet.setArguments(Bundle2.bundleOf(Tuples.m10073to("com.discord.intent.extra.EXTRA_GUILD_SCHEDULED_EVENT_ID", Long.valueOf(guildScheduledEventId)), Tuples.m10073to("com.discord.intent.extra.EXTRA_GUILD_ID", Long.valueOf(guildId)), Tuples.m10073to(WidgetEndGuildScheduledEventBottomSheet.EXTRA_REQUEST_KEY, requestKey)));
            widgetEndGuildScheduledEventBottomSheet.show(fragmentManager, WidgetEndGuildScheduledEventBottomSheet.class.getSimpleName());
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: WidgetEndGuildScheduledEventBottomSheet.kt */
    /* renamed from: com.discord.widgets.guildscheduledevent.WidgetEndGuildScheduledEventBottomSheet$onConfirmEnd$1 */
    public static final class C88411 extends Lambda implements Function1<Unit, Unit> {
        public static final C88411 INSTANCE = new C88411();

        public C88411() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Unit unit) {
            invoke2(unit);
            return Unit.f27425a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Unit unit) {
            Intrinsics3.checkNotNullParameter(unit, "it");
        }
    }

    /* compiled from: WidgetEndGuildScheduledEventBottomSheet.kt */
    /* renamed from: com.discord.widgets.guildscheduledevent.WidgetEndGuildScheduledEventBottomSheet$onViewCreated$1 */
    public static final class ViewOnClickListenerC88421 implements View.OnClickListener {
        public ViewOnClickListenerC88421() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetEndGuildScheduledEventBottomSheet.this.dismiss();
            WidgetEndGuildScheduledEventBottomSheet.access$callOnActionTaken(WidgetEndGuildScheduledEventBottomSheet.this);
        }
    }

    /* compiled from: WidgetEndGuildScheduledEventBottomSheet.kt */
    /* renamed from: com.discord.widgets.guildscheduledevent.WidgetEndGuildScheduledEventBottomSheet$onViewCreated$2 */
    public static final class ViewOnClickListenerC88432 implements View.OnClickListener {
        public ViewOnClickListenerC88432() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetEndGuildScheduledEventBottomSheet.this.dismiss();
            WidgetEndGuildScheduledEventBottomSheet.access$onConfirmEnd(WidgetEndGuildScheduledEventBottomSheet.this);
            WidgetEndGuildScheduledEventBottomSheet.access$callOnActionTaken(WidgetEndGuildScheduledEventBottomSheet.this);
        }
    }

    public WidgetEndGuildScheduledEventBottomSheet() {
        super(false, 1, null);
        this.binding = FragmentViewBindingDelegate3.viewBinding$default(this, WidgetEndGuildScheduledEventBottomSheet3.INSTANCE, null, 2, null);
        this.guildScheduledEventId = LazyJVM.lazy(new WidgetEndGuildScheduledEventBottomSheet5(this));
        this.guildId = LazyJVM.lazy(new WidgetEndGuildScheduledEventBottomSheet4(this));
        this.requestKey = LazyJVM.lazy(new WidgetEndGuildScheduledEventBottomSheet6(this));
    }

    public static final /* synthetic */ void access$callOnActionTaken(WidgetEndGuildScheduledEventBottomSheet widgetEndGuildScheduledEventBottomSheet) {
        widgetEndGuildScheduledEventBottomSheet.callOnActionTaken();
    }

    public static final /* synthetic */ void access$onConfirmEnd(WidgetEndGuildScheduledEventBottomSheet widgetEndGuildScheduledEventBottomSheet) {
        widgetEndGuildScheduledEventBottomSheet.onConfirmEnd();
    }

    private final void callOnActionTaken() {
        String requestKey = getRequestKey();
        Intrinsics3.checkNotNullExpressionValue(requestKey, "requestKey");
        Fragment2.setFragmentResult(this, requestKey, new Bundle());
    }

    private final WidgetEndStageBottomSheetBinding getBinding() {
        return (WidgetEndStageBottomSheetBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    private final long getGuildId() {
        return ((Number) this.guildId.getValue()).longValue();
    }

    private final long getGuildScheduledEventId() {
        return ((Number) this.guildScheduledEventId.getValue()).longValue();
    }

    private final String getRequestKey() {
        return (String) this.requestKey.getValue();
    }

    private final void onConfirmEnd() {
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.restSubscribeOn$default(GuildScheduledEventAPI.INSTANCE.endEvent(getGuildId(), getGuildScheduledEventId()), false, 1, null), WidgetEndGuildScheduledEventBottomSheet.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, C88411.INSTANCE, 62, (Object) null);
    }

    @Override // com.discord.app.AppBottomSheet
    public int getContentViewResId() {
        return C5419R.layout.widget_end_stage_bottom_sheet;
    }

    @Override // com.discord.app.AppBottomSheet, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics3.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        ScreenTitleView screenTitleView = getBinding().f16601d;
        String string = requireContext().getString(C5419R.string.guild_event_end_prompt_title);
        Intrinsics3.checkNotNullExpressionValue(string, "requireContext().getStri…d_event_end_prompt_title)");
        screenTitleView.setTitle(string);
        getBinding().f16601d.setSubtitle(null);
        MaterialButton materialButton = getBinding().f16599b;
        Intrinsics3.checkNotNullExpressionValue(materialButton, "binding.cancel");
        materialButton.setText(requireContext().getString(C5419R.string.guild_event_end_prompt_cancel));
        MaterialButton materialButton2 = getBinding().f16600c;
        Intrinsics3.checkNotNullExpressionValue(materialButton2, "binding.confirm");
        materialButton2.setText(requireContext().getString(C5419R.string.guild_event_end_prompt_confirm));
        getBinding().f16599b.setOnClickListener(new ViewOnClickListenerC88421());
        getBinding().f16600c.setOnClickListener(new ViewOnClickListenerC88432());
    }
}
