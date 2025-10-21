package com.discord.widgets.stage.sheet;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import androidx.core.os.Bundle2;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.Fragment2;
import androidx.fragment.app.FragmentManager;
import b.d.b.a.outline;
import com.discord.R;
import com.discord.app.AppBottomSheet;
import com.discord.databinding.WidgetEndStageBottomSheetBinding;
import com.discord.utilities.rest.RestAPI;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate3;
import com.discord.views.ScreenTitleView;
import com.google.android.material.button.MaterialButton;
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

/* compiled from: WidgetEndStageBottomSheet.kt */
/* loaded from: classes2.dex */
public final class WidgetEndStageBottomSheet extends AppBottomSheet {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {outline.d0(WidgetEndStageBottomSheet.class, "binding", "getBinding()Lcom/discord/databinding/WidgetEndStageBottomSheetBinding;", 0)};

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String EXTRA_REQUEST_KEY = "INTENT_EXTRA_REQUEST_KEY";

    /* renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;

    /* renamed from: channelId$delegate, reason: from kotlin metadata */
    private final Lazy channelId;

    /* renamed from: requestKey$delegate, reason: from kotlin metadata */
    private final Lazy requestKey;

    /* compiled from: WidgetEndStageBottomSheet.kt */
    public static final class Companion {
        private Companion() {
        }

        public final void registerForResult(Fragment fragment, String requestKey, Function0<Unit> onActionTaken) {
            Intrinsics3.checkNotNullParameter(fragment, "fragment");
            Intrinsics3.checkNotNullParameter(requestKey, "requestKey");
            Intrinsics3.checkNotNullParameter(onActionTaken, "onActionTaken");
            Fragment2.setFragmentResultListener(fragment, requestKey, new WidgetEndStageBottomSheet2(requestKey, onActionTaken));
        }

        public final void show(FragmentManager fragmentManager, String requestKey, long channelId) {
            Intrinsics3.checkNotNullParameter(fragmentManager, "fragmentManager");
            Intrinsics3.checkNotNullParameter(requestKey, "requestKey");
            WidgetEndStageBottomSheet widgetEndStageBottomSheet = new WidgetEndStageBottomSheet();
            widgetEndStageBottomSheet.setArguments(Bundle2.bundleOf(Tuples.to("com.discord.intent.extra.EXTRA_CHANNEL_ID", Long.valueOf(channelId)), Tuples.to(WidgetEndStageBottomSheet.EXTRA_REQUEST_KEY, requestKey)));
            widgetEndStageBottomSheet.show(fragmentManager, WidgetEndStageBottomSheet.class.getSimpleName());
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: WidgetEndStageBottomSheet.kt */
    /* renamed from: com.discord.widgets.stage.sheet.WidgetEndStageBottomSheet$onConfirmEnd$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function1<Unit, Unit> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Unit unit) {
            invoke2(unit);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Unit unit) {
            Intrinsics3.checkNotNullParameter(unit, "it");
        }
    }

    /* compiled from: WidgetEndStageBottomSheet.kt */
    /* renamed from: com.discord.widgets.stage.sheet.WidgetEndStageBottomSheet$onViewCreated$1, reason: invalid class name */
    public static final class AnonymousClass1 implements View.OnClickListener {
        public AnonymousClass1() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetEndStageBottomSheet.this.dismiss();
            WidgetEndStageBottomSheet.access$callOnActionTaken(WidgetEndStageBottomSheet.this);
        }
    }

    /* compiled from: WidgetEndStageBottomSheet.kt */
    /* renamed from: com.discord.widgets.stage.sheet.WidgetEndStageBottomSheet$onViewCreated$2, reason: invalid class name */
    public static final class AnonymousClass2 implements View.OnClickListener {
        public AnonymousClass2() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetEndStageBottomSheet.this.dismiss();
            WidgetEndStageBottomSheet.access$onConfirmEnd(WidgetEndStageBottomSheet.this);
            WidgetEndStageBottomSheet.access$callOnActionTaken(WidgetEndStageBottomSheet.this);
        }
    }

    public WidgetEndStageBottomSheet() {
        super(false, 1, null);
        this.binding = FragmentViewBindingDelegate3.viewBinding$default(this, WidgetEndStageBottomSheet3.INSTANCE, null, 2, null);
        this.channelId = LazyJVM.lazy(new WidgetEndStageBottomSheet4(this));
        this.requestKey = LazyJVM.lazy(new WidgetEndStageBottomSheet5(this));
    }

    public static final /* synthetic */ void access$callOnActionTaken(WidgetEndStageBottomSheet widgetEndStageBottomSheet) {
        widgetEndStageBottomSheet.callOnActionTaken();
    }

    public static final /* synthetic */ void access$onConfirmEnd(WidgetEndStageBottomSheet widgetEndStageBottomSheet) {
        widgetEndStageBottomSheet.onConfirmEnd();
    }

    private final void callOnActionTaken() {
        String requestKey = getRequestKey();
        Intrinsics3.checkNotNullExpressionValue(requestKey, "requestKey");
        Fragment2.setFragmentResult(this, requestKey, new Bundle());
    }

    private final WidgetEndStageBottomSheetBinding getBinding() {
        return (WidgetEndStageBottomSheetBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    private final long getChannelId() {
        return ((Number) this.channelId.getValue()).longValue();
    }

    private final String getRequestKey() {
        return (String) this.requestKey.getValue();
    }

    private final void onConfirmEnd() {
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.restSubscribeOn$default(RestAPI.INSTANCE.getApi().endStageInstance(getChannelId()), false, 1, null), WidgetEndStageBottomSheet.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, AnonymousClass1.INSTANCE, 62, (Object) null);
    }

    @Override // com.discord.app.AppBottomSheet
    public int getContentViewResId() {
        return R.layout.widget_end_stage_bottom_sheet;
    }

    @Override // com.discord.app.AppBottomSheet, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics3.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        ScreenTitleView screenTitleView = getBinding().d;
        String string = requireContext().getString(R.string.explicit_end_stage_title);
        Intrinsics3.checkNotNullExpressionValue(string, "requireContext().getStri…explicit_end_stage_title)");
        screenTitleView.setTitle(string);
        getBinding().d.setSubtitle(requireContext().getString(R.string.explicit_end_stage_subtitle));
        MaterialButton materialButton = getBinding().f2382b;
        Intrinsics3.checkNotNullExpressionValue(materialButton, "binding.cancel");
        materialButton.setText(requireContext().getString(R.string.explicit_end_stage_cancel));
        MaterialButton materialButton2 = getBinding().c;
        Intrinsics3.checkNotNullExpressionValue(materialButton2, "binding.confirm");
        materialButton2.setText(requireContext().getString(R.string.explicit_end_stage_confirm_mobile));
        getBinding().f2382b.setOnClickListener(new AnonymousClass1());
        getBinding().c.setOnClickListener(new AnonymousClass2());
    }
}
