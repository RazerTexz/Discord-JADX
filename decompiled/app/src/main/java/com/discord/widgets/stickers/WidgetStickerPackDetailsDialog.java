package com.discord.widgets.stickers;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.discord.C5419R;
import com.discord.app.AppDialog;
import com.discord.databinding.StickerPackDetailsDialogBinding;
import com.discord.models.sticker.dto.ModelStickerPack;
import com.discord.stores.StoreStickers;
import com.discord.stores.StoreStream;
import com.discord.utilities.p501rx.ObservableExtensionsKt;
import com.discord.utilities.stickers.StickerUtils;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate3;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;
import p007b.p008a.p027k.FormatUtils;
import p007b.p100d.p104b.p105a.outline;
import p507d0.p592z.p594d.Intrinsics3;
import p507d0.p592z.p594d.Lambda;

/* JADX INFO: compiled from: WidgetStickerPackDetailsDialog.kt */
/* JADX INFO: loaded from: classes.dex */
public final class WidgetStickerPackDetailsDialog extends AppDialog {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {outline.m846d0(WidgetStickerPackDetailsDialog.class, "binding", "getBinding()Lcom/discord/databinding/StickerPackDetailsDialogBinding;", 0)};

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String EXTRA_Y_POSITION = "EXTRA_Y_POSITION";

    /* JADX INFO: renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;
    private Long stickerPackId;

    /* JADX INFO: compiled from: WidgetStickerPackDetailsDialog.kt */
    public static final class Companion {
        private Companion() {
        }

        public static /* synthetic */ void show$default(Companion companion, FragmentManager fragmentManager, long j, Integer num, int i, Object obj) {
            if ((i & 4) != 0) {
                num = null;
            }
            companion.show(fragmentManager, j, num);
        }

        public final void show(FragmentManager fragmentManager, long stickerPackId, Integer y2) {
            Intrinsics3.checkNotNullParameter(fragmentManager, "fragmentManager");
            Bundle bundle = new Bundle();
            bundle.putLong("com.discord.intent.EXTRA_STICKER_PACK_ID", stickerPackId);
            if (y2 != null) {
                y2.intValue();
                bundle.putInt(WidgetStickerPackDetailsDialog.EXTRA_Y_POSITION, y2.intValue());
            }
            WidgetStickerPackDetailsDialog widgetStickerPackDetailsDialog = new WidgetStickerPackDetailsDialog();
            widgetStickerPackDetailsDialog.setArguments(bundle);
            widgetStickerPackDetailsDialog.show(fragmentManager, WidgetStickerPackDetailsDialog.class.getSimpleName());
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.stickers.WidgetStickerPackDetailsDialog$onViewBound$1 */
    /* JADX INFO: compiled from: WidgetStickerPackDetailsDialog.kt */
    public static final class ViewOnClickListenerC101341 implements View.OnClickListener {
        public ViewOnClickListenerC101341() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetStickerPackDetailsDialog.this.dismiss();
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.stickers.WidgetStickerPackDetailsDialog$onViewBoundOrOnResume$1 */
    /* JADX INFO: compiled from: WidgetStickerPackDetailsDialog.kt */
    public static final class C101351 extends Lambda implements Function1<StoreStickers.StickerPackState, Unit> {
        public C101351() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(StoreStickers.StickerPackState stickerPackState) {
            invoke2(stickerPackState);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(StoreStickers.StickerPackState stickerPackState) {
            Intrinsics3.checkNotNullParameter(stickerPackState, "it");
            WidgetStickerPackDetailsDialog.access$configureUI(WidgetStickerPackDetailsDialog.this, stickerPackState);
        }
    }

    public WidgetStickerPackDetailsDialog() {
        super(C5419R.layout.sticker_pack_details_dialog);
        this.binding = FragmentViewBindingDelegate3.viewBinding$default(this, WidgetStickerPackDetailsDialog2.INSTANCE, null, 2, null);
        setStyle(1, 2131951655);
    }

    public static final /* synthetic */ void access$configureUI(WidgetStickerPackDetailsDialog widgetStickerPackDetailsDialog, StoreStickers.StickerPackState stickerPackState) {
        widgetStickerPackDetailsDialog.configureUI(stickerPackState);
    }

    @SuppressLint({"SetTextI18n"})
    private final void configureUI(StoreStickers.StickerPackState stickerPackState) {
        if (stickerPackState instanceof StoreStickers.StickerPackState.Loaded) {
            ModelStickerPack stickerPack = ((StoreStickers.StickerPackState.Loaded) stickerPackState).getStickerPack();
            TextView textView = getBinding().f15273e;
            Intrinsics3.checkNotNullExpressionValue(textView, "binding.stickerPackDetailsPack");
            textView.setText(FormatUtils.m219k(this, C5419R.string.sticker_picker_pack_details, new Object[]{stickerPack.getName()}, null, 4));
            TextView textView2 = getBinding().f15270b;
            Intrinsics3.checkNotNullExpressionValue(textView2, "binding.stickerPackDetailsAnimated");
            textView2.setVisibility(stickerPack.isAnimatedPack() ? 0 : 8);
            TextView textView3 = getBinding().f15270b;
            Intrinsics3.checkNotNullExpressionValue(textView3, "binding.stickerPackDetailsAnimated");
            textView3.setText("・ " + getString(C5419R.string.sticker_picker_pack_details_animated));
            TextView textView4 = getBinding().f15274f;
            Intrinsics3.checkNotNullExpressionValue(textView4, "binding.stickerPackDetailsPremium");
            textView4.setVisibility(stickerPack.isPremiumPack() ? 0 : 8);
            TextView textView5 = getBinding().f15274f;
            Intrinsics3.checkNotNullExpressionValue(textView5, "binding.stickerPackDetailsPremium");
            textView5.setText("・ " + getString(C5419R.string.sticker_picker_pack_details_premium));
            TextView textView6 = getBinding().f15272d;
            Intrinsics3.checkNotNullExpressionValue(textView6, "binding.stickerPackDetailsLimited");
            textView6.setVisibility(stickerPack.isLimitedPack() ? 0 : 8);
            TextView textView7 = getBinding().f15272d;
            Intrinsics3.checkNotNullExpressionValue(textView7, "binding.stickerPackDetailsLimited");
            StringBuilder sb = new StringBuilder();
            sb.append("・ ");
            StickerUtils stickerUtils = StickerUtils.INSTANCE;
            Context contextRequireContext = requireContext();
            Intrinsics3.checkNotNullExpressionValue(contextRequireContext, "requireContext()");
            sb.append(FormatUtils.m219k(this, C5419R.string.sticker_picker_pack_details_limited_time_left, new Object[]{stickerUtils.getLimitedTimeLeftString(contextRequireContext, stickerPack.getStoreListing())}, null, 4));
            textView7.setText(sb.toString());
        }
    }

    private final StickerPackDetailsDialogBinding getBinding() {
        return (StickerPackDetailsDialogBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    @Override // com.discord.app.AppDialog, androidx.fragment.app.DialogFragment
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        WindowManager.LayoutParams attributes;
        Dialog dialogOnCreateDialog = super.onCreateDialog(savedInstanceState);
        Window window = dialogOnCreateDialog.getWindow();
        if (window != null) {
            window.setGravity(81);
        }
        Bundle arguments = getArguments();
        Integer numValueOf = arguments != null ? Integer.valueOf(arguments.getInt(EXTRA_Y_POSITION, 0)) : null;
        Window window2 = dialogOnCreateDialog.getWindow();
        if (window2 != null && (attributes = window2.getAttributes()) != null) {
            if (numValueOf != null && numValueOf.intValue() == 0) {
                Context context = dialogOnCreateDialog.getContext();
                Intrinsics3.checkNotNullExpressionValue(context, "context");
                numValueOf = Integer.valueOf((int) (context.getResources().getDimension(C5419R.dimen.default_keyboard_height) / 2));
            }
            attributes.y = numValueOf.intValue();
        }
        return dialogOnCreateDialog;
    }

    @Override // com.discord.app.AppDialog
    public void onViewBound(View view) {
        Intrinsics3.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        getBinding().f15271c.setOnClickListener(new ViewOnClickListenerC101341());
    }

    @Override // com.discord.app.AppDialog
    public void onViewBoundOrOnResume() {
        super.onViewBoundOrOnResume();
        Bundle arguments = getArguments();
        Long lValueOf = arguments != null ? Long.valueOf(arguments.getLong("com.discord.intent.EXTRA_STICKER_PACK_ID")) : null;
        this.stickerPackId = lValueOf;
        if (lValueOf != null) {
            ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(StoreStream.INSTANCE.getStickers().observeStickerPack(lValueOf.longValue()), this, null, 2, null), WidgetStickerPackDetailsDialog.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new C101351(), 62, (Object) null);
        }
    }
}
