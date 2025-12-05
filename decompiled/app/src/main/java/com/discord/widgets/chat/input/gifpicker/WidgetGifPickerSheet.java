package com.discord.widgets.chat.input.gifpicker;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import com.discord.C5419R;
import com.discord.app.AppBottomSheet;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import p507d0.p592z.p594d.Intrinsics3;
import p507d0.p592z.p594d.Lambda;

/* compiled from: WidgetGifPickerSheet.kt */
/* loaded from: classes2.dex */
public final class WidgetGifPickerSheet extends AppBottomSheet {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private View container;
    private WidgetGifPickerSearch gifPickerFragment;
    private Function0<Unit> onCancel;
    private Function0<Unit> onGifSelected;

    /* compiled from: WidgetGifPickerSheet.kt */
    public static final class Companion {
        private Companion() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ void show$default(Companion companion, FragmentManager fragmentManager, Function0 function0, Function0 function02, int i, Object obj) {
            if ((i & 2) != 0) {
                function0 = null;
            }
            if ((i & 4) != 0) {
                function02 = null;
            }
            companion.show(fragmentManager, function0, function02);
        }

        public final void show(FragmentManager fragmentManager, Function0<Unit> onGifSelected, Function0<Unit> onCancel) {
            Intrinsics3.checkNotNullParameter(fragmentManager, "fragmentManager");
            WidgetGifPickerSheet widgetGifPickerSheet = new WidgetGifPickerSheet();
            widgetGifPickerSheet.show(fragmentManager, WidgetGifPickerSheet.class.getSimpleName());
            widgetGifPickerSheet.setOnGifSelected(onGifSelected);
            widgetGifPickerSheet.setOnCancel(onCancel);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: WidgetGifPickerSheet.kt */
    /* renamed from: com.discord.widgets.chat.input.gifpicker.WidgetGifPickerSheet$onViewCreated$1 */
    public static final class C78901 extends Lambda implements Function0<Unit> {
        public C78901() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.f27425a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            Function0 function0Access$getOnGifSelected$p = WidgetGifPickerSheet.access$getOnGifSelected$p(WidgetGifPickerSheet.this);
            if (function0Access$getOnGifSelected$p != null) {
            }
            WidgetGifPickerSheet.this.dismiss();
        }
    }

    /* compiled from: WidgetGifPickerSheet.kt */
    /* renamed from: com.discord.widgets.chat.input.gifpicker.WidgetGifPickerSheet$onViewCreated$2 */
    public static final class RunnableC78912 implements Runnable {
        public RunnableC78912() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            ViewGroup.LayoutParams layoutParams = WidgetGifPickerSheet.access$getContainer$p(WidgetGifPickerSheet.this).getLayoutParams();
            if (layoutParams != null) {
                Intrinsics3.checkNotNullExpressionValue(WidgetGifPickerSheet.this.getResources(), "resources");
                layoutParams.height = (int) (r1.getDisplayMetrics().heightPixels * 0.9d);
            }
        }
    }

    public WidgetGifPickerSheet() {
        super(false, 1, null);
    }

    public static final /* synthetic */ View access$getContainer$p(WidgetGifPickerSheet widgetGifPickerSheet) {
        View view = widgetGifPickerSheet.container;
        if (view == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("container");
        }
        return view;
    }

    public static final /* synthetic */ Function0 access$getOnGifSelected$p(WidgetGifPickerSheet widgetGifPickerSheet) {
        return widgetGifPickerSheet.onGifSelected;
    }

    public static final /* synthetic */ void access$setContainer$p(WidgetGifPickerSheet widgetGifPickerSheet, View view) {
        widgetGifPickerSheet.container = view;
    }

    public static final /* synthetic */ void access$setOnGifSelected$p(WidgetGifPickerSheet widgetGifPickerSheet, Function0 function0) {
        widgetGifPickerSheet.onGifSelected = function0;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void setOnCancel$default(WidgetGifPickerSheet widgetGifPickerSheet, Function0 function0, int i, Object obj) {
        if ((i & 1) != 0) {
            function0 = null;
        }
        widgetGifPickerSheet.setOnCancel(function0);
    }

    @Override // com.discord.app.AppBottomSheet
    public int getContentViewResId() {
        return C5419R.layout.widget_gif_picker_sheet;
    }

    @Override // androidx.fragment.app.DialogFragment, android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface dialog) {
        Intrinsics3.checkNotNullParameter(dialog, "dialog");
        super.onCancel(dialog);
        WidgetGifPickerSearch widgetGifPickerSearch = this.gifPickerFragment;
        if (widgetGifPickerSearch == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("gifPickerFragment");
        }
        widgetGifPickerSearch.clearSearchBar();
        Function0<Unit> function0 = this.onCancel;
        if (function0 != null) {
            function0.invoke();
        }
    }

    @Override // com.discord.app.AppBottomSheet, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics3.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        setBottomSheetCollapsedStateDisabled();
        this.container = view;
        WidgetGifPickerSearch widgetGifPickerSearch = new WidgetGifPickerSearch();
        this.gifPickerFragment = widgetGifPickerSearch;
        if (widgetGifPickerSearch == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("gifPickerFragment");
        }
        widgetGifPickerSearch.setOnGifSelected(new C78901());
        FragmentTransaction fragmentTransactionBeginTransaction = getChildFragmentManager().beginTransaction();
        WidgetGifPickerSearch widgetGifPickerSearch2 = this.gifPickerFragment;
        if (widgetGifPickerSearch2 == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("gifPickerFragment");
        }
        WidgetGifPickerSearch widgetGifPickerSearch3 = this.gifPickerFragment;
        if (widgetGifPickerSearch3 == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("gifPickerFragment");
        }
        fragmentTransactionBeginTransaction.replace(C5419R.id.gif_search_sheet_content, widgetGifPickerSearch2, widgetGifPickerSearch3.getClass().getSimpleName()).runOnCommit(new RunnableC78912()).commit();
    }

    public final void setOnCancel(Function0<Unit> onCancel) {
        this.onCancel = onCancel;
    }

    public final void setOnGifSelected(Function0<Unit> onGifSelected) {
        this.onGifSelected = onGifSelected;
    }
}
