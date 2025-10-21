package com.discord.widgets.settings;

import android.view.View;
import androidx.core.widget.NestedScrollView;
import com.discord.R;
import com.discord.databinding.WidgetSettingsLanguageSelectBinding;
import com.discord.utilities.view.recycler.MaxHeightRecyclerView;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import kotlin.jvm.functions.Function1;

/* compiled from: WidgetSettingsLanguageSelect.kt */
/* renamed from: com.discord.widgets.settings.WidgetSettingsLanguageSelect$binding$2, reason: use source file name */
/* loaded from: classes2.dex */
public final /* synthetic */ class WidgetSettingsLanguageSelect4 extends FunctionReferenceImpl implements Function1<View, WidgetSettingsLanguageSelectBinding> {
    public static final WidgetSettingsLanguageSelect4 INSTANCE = new WidgetSettingsLanguageSelect4();

    public WidgetSettingsLanguageSelect4() {
        super(1, WidgetSettingsLanguageSelectBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetSettingsLanguageSelectBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ WidgetSettingsLanguageSelectBinding invoke(View view) {
        return invoke2(view);
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final WidgetSettingsLanguageSelectBinding invoke2(View view) {
        Intrinsics3.checkNotNullParameter(view, "p1");
        MaxHeightRecyclerView maxHeightRecyclerView = (MaxHeightRecyclerView) view.findViewById(R.id.settings_language_select_list);
        if (maxHeightRecyclerView != null) {
            return new WidgetSettingsLanguageSelectBinding((NestedScrollView) view, maxHeightRecyclerView);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(R.id.settings_language_select_list)));
    }
}
