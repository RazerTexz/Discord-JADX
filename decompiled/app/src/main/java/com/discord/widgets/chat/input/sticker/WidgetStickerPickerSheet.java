package com.discord.widgets.chat.input.sticker;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import com.discord.R;
import com.discord.api.sticker.Sticker;
import com.discord.widgets.chat.input.expression.WidgetExpressionPickerSheet;
import d0.z.d.m;
import java.io.Serializable;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: WidgetStickerPickerSheet.kt */
/* loaded from: classes2.dex */
public final class WidgetStickerPickerSheet extends WidgetExpressionPickerSheet implements StickerPickerListener {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private View container;
    private WidgetStickerPicker stickerPickerFragment;
    private StickerPickerListener stickerPickerListenerDelegate;

    /* compiled from: WidgetStickerPickerSheet.kt */
    public static final class Companion {
        private Companion() {
        }

        public static /* synthetic */ WidgetStickerPickerSheet show$default(Companion companion, FragmentManager fragmentManager, StickerPickerListener stickerPickerListener, Long l, String str, Function0 function0, int i, Object obj) {
            return companion.show(fragmentManager, stickerPickerListener, (i & 4) != 0 ? null : l, (i & 8) != 0 ? null : str, (i & 16) != 0 ? null : function0);
        }

        public final WidgetStickerPickerSheet show(FragmentManager fragmentManager, StickerPickerListener stickerPickerListener, Long initialStickerPackId, String searchText, Function0<Unit> onCancel) {
            m.checkNotNullParameter(fragmentManager, "fragmentManager");
            System.gc();
            Bundle bundle = new Bundle();
            if (initialStickerPackId != null) {
                initialStickerPackId.longValue();
                bundle.putLong("com.discord.intent.EXTRA_STICKER_PACK_ID", initialStickerPackId.longValue());
            }
            bundle.putString("com.discord.intent.extra.EXTRA_TEXT", searchText);
            WidgetStickerPickerSheet widgetStickerPickerSheet = new WidgetStickerPickerSheet();
            widgetStickerPickerSheet.setStickerPickerListener(stickerPickerListener);
            widgetStickerPickerSheet.setOnCancel(onCancel);
            widgetStickerPickerSheet.setArguments(bundle);
            widgetStickerPickerSheet.show(fragmentManager, WidgetStickerPickerSheet.class.getSimpleName());
            return widgetStickerPickerSheet;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: WidgetStickerPickerSheet.kt */
    /* renamed from: com.discord.widgets.chat.input.sticker.WidgetStickerPickerSheet$onViewCreated$2, reason: invalid class name */
    public static final class AnonymousClass2 implements Runnable {
        public AnonymousClass2() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            ViewGroup.LayoutParams layoutParams = WidgetStickerPickerSheet.access$getContainer$p(WidgetStickerPickerSheet.this).getLayoutParams();
            if (layoutParams != null) {
                m.checkNotNullExpressionValue(WidgetStickerPickerSheet.this.getResources(), "resources");
                layoutParams.height = (int) (r1.getDisplayMetrics().heightPixels * 0.9d);
            }
        }
    }

    public static final /* synthetic */ View access$getContainer$p(WidgetStickerPickerSheet widgetStickerPickerSheet) {
        View view = widgetStickerPickerSheet.container;
        if (view == null) {
            m.throwUninitializedPropertyAccessException("container");
        }
        return view;
    }

    public static final /* synthetic */ void access$setContainer$p(WidgetStickerPickerSheet widgetStickerPickerSheet, View view) {
        widgetStickerPickerSheet.container = view;
    }

    @Override // com.discord.app.AppBottomSheet
    public int getContentViewResId() {
        return R.layout.widget_sticker_picker_sheet;
    }

    @Override // com.discord.widgets.chat.input.expression.WidgetExpressionPickerSheet, androidx.fragment.app.DialogFragment, android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface dialog) {
        m.checkNotNullParameter(dialog, "dialog");
        super.onCancel(dialog);
        WidgetStickerPicker widgetStickerPicker = this.stickerPickerFragment;
        if (widgetStickerPicker == null) {
            m.throwUninitializedPropertyAccessException("stickerPickerFragment");
        }
        widgetStickerPicker.clearSearchInput();
    }

    @Override // androidx.fragment.app.DialogFragment, android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialog) {
        m.checkNotNullParameter(dialog, "dialog");
        super.onDismiss(dialog);
        WidgetStickerPicker widgetStickerPicker = this.stickerPickerFragment;
        if (widgetStickerPicker == null) {
            m.throwUninitializedPropertyAccessException("stickerPickerFragment");
        }
        widgetStickerPicker.selectCategoryById(-1L);
    }

    @Override // com.discord.widgets.chat.input.sticker.StickerPickerListener
    public void onStickerPicked(Sticker sticker) {
        m.checkNotNullParameter(sticker, "sticker");
        StickerPickerListener stickerPickerListener = this.stickerPickerListenerDelegate;
        if (stickerPickerListener != null) {
            stickerPickerListener.onStickerPicked(sticker);
        }
        dismiss();
    }

    @Override // com.discord.widgets.chat.input.expression.WidgetExpressionPickerSheet, com.discord.app.AppBottomSheet, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        m.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        this.container = view;
        Bundle arguments = getArguments();
        Long lValueOf = arguments != null ? Long.valueOf(arguments.getLong("com.discord.intent.EXTRA_STICKER_PACK_ID")) : null;
        Bundle arguments2 = getArguments();
        Serializable serializable = arguments2 != null ? arguments2.getSerializable("com.discord.intent.EXTRA_STICKER_PICKER_SCREEN") : null;
        Bundle arguments3 = getArguments();
        String string = arguments3 != null ? arguments3.getString("com.discord.intent.extra.EXTRA_TEXT") : null;
        WidgetStickerPicker widgetStickerPicker = new WidgetStickerPicker();
        this.stickerPickerFragment = widgetStickerPicker;
        if (widgetStickerPicker == null) {
            m.throwUninitializedPropertyAccessException("stickerPickerFragment");
        }
        Bundle bundle = new Bundle();
        bundle.putSerializable("MODE", StickerPickerMode.BOTTOM_SHEET);
        bundle.putSerializable(WidgetStickerPicker.VIEW_TYPE, StickerPackStoreSheetViewType.STICKER_SEARCH_VIEW_ALL);
        bundle.putString("com.discord.intent.extra.EXTRA_TEXT", string);
        if (lValueOf != null) {
            bundle.putLong("com.discord.intent.EXTRA_STICKER_PACK_ID", lValueOf.longValue());
        }
        if (serializable != null) {
            bundle.putSerializable("com.discord.intent.EXTRA_STICKER_PICKER_SCREEN", serializable);
        }
        widgetStickerPicker.setArguments(bundle);
        WidgetStickerPicker widgetStickerPicker2 = this.stickerPickerFragment;
        if (widgetStickerPicker2 == null) {
            m.throwUninitializedPropertyAccessException("stickerPickerFragment");
        }
        widgetStickerPicker2.setListener(this);
        FragmentTransaction fragmentTransactionBeginTransaction = getChildFragmentManager().beginTransaction();
        WidgetStickerPicker widgetStickerPicker3 = this.stickerPickerFragment;
        if (widgetStickerPicker3 == null) {
            m.throwUninitializedPropertyAccessException("stickerPickerFragment");
        }
        WidgetStickerPicker widgetStickerPicker4 = this.stickerPickerFragment;
        if (widgetStickerPicker4 == null) {
            m.throwUninitializedPropertyAccessException("stickerPickerFragment");
        }
        fragmentTransactionBeginTransaction.replace(R.id.sticker_sheet_sticker_picker_content, widgetStickerPicker3, widgetStickerPicker4.getClass().getSimpleName()).runOnCommit(new AnonymousClass2()).commit();
    }

    public final void scrollToPack(Long packId) {
        WidgetStickerPicker widgetStickerPicker = this.stickerPickerFragment;
        if (widgetStickerPicker == null) {
            m.throwUninitializedPropertyAccessException("stickerPickerFragment");
        }
        widgetStickerPicker.scrollToPack(packId);
    }

    public final void setStickerPickerListener(StickerPickerListener stickerPickerListener) {
        this.stickerPickerListenerDelegate = stickerPickerListener;
    }
}
