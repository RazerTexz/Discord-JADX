package com.discord.widgets.settings.developer;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.discord.C5419R;
import com.discord.databinding.IconListItemTextViewBinding;
import com.discord.widgets.settings.developer.WidgetSettingsDeveloper;
import java.util.Objects;
import kotlin.jvm.functions.Function2;
import p507d0.p592z.p594d.Intrinsics3;
import p507d0.p592z.p594d.Lambda;

/* compiled from: WidgetSettingsDeveloper.kt */
/* renamed from: com.discord.widgets.settings.developer.WidgetSettingsDeveloper$setupNoticesSection$noticesAdapter$1, reason: use source file name */
/* loaded from: classes2.dex */
public final class WidgetSettingsDeveloper4 extends Lambda implements Function2<LayoutInflater, ViewGroup, WidgetSettingsDeveloper.NoticeViewHolder> {
    public static final WidgetSettingsDeveloper4 INSTANCE = new WidgetSettingsDeveloper4();

    public WidgetSettingsDeveloper4() {
        super(2);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ WidgetSettingsDeveloper.NoticeViewHolder invoke(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        return invoke2(layoutInflater, viewGroup);
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final WidgetSettingsDeveloper.NoticeViewHolder invoke2(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        Intrinsics3.checkNotNullParameter(layoutInflater, "layoutInflater");
        Intrinsics3.checkNotNullParameter(viewGroup, "parent");
        View viewInflate = layoutInflater.inflate(C5419R.layout.icon_list_item_text_view, viewGroup, false);
        Objects.requireNonNull(viewInflate, "rootView");
        IconListItemTextViewBinding iconListItemTextViewBinding = new IconListItemTextViewBinding((TextView) viewInflate);
        Intrinsics3.checkNotNullExpressionValue(iconListItemTextViewBinding, "IconListItemTextViewBind…tInflater, parent, false)");
        return new WidgetSettingsDeveloper.NoticeViewHolder(iconListItemTextViewBinding);
    }
}
