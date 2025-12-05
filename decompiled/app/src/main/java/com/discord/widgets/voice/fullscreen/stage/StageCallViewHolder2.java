package com.discord.widgets.voice.fullscreen.stage;

import android.annotation.SuppressLint;
import android.view.View;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.discord.C5419R;
import com.discord.databinding.WidgetStageChannelAudienceRoleBinding;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.utilities.locale.LocaleManager;
import com.discord.widgets.voice.fullscreen.stage.StageCallItem;
import java.text.NumberFormat;
import p007b.p008a.p027k.FormatUtils;
import p507d0.p592z.p594d.Intrinsics3;

/* compiled from: StageCallViewHolder.kt */
/* renamed from: com.discord.widgets.voice.fullscreen.stage.AudienceHeaderViewHolder, reason: use source file name */
/* loaded from: classes.dex */
public final class StageCallViewHolder2 extends StageCallViewHolder {
    private final WidgetStageChannelAudienceRoleBinding binding;
    private final NumberFormat numberFormatter;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StageCallViewHolder2(StageCallAdapter stageCallAdapter) {
        super(C5419R.layout.widget_stage_channel_audience_role, stageCallAdapter, null);
        Intrinsics3.checkNotNullParameter(stageCallAdapter, "adapter");
        View view = this.itemView;
        TextView textView = (TextView) view.findViewById(C5419R.id.stage_channel_audience_role_text);
        if (textView == null) {
            throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(C5419R.id.stage_channel_audience_role_text)));
        }
        WidgetStageChannelAudienceRoleBinding widgetStageChannelAudienceRoleBinding = new WidgetStageChannelAudienceRoleBinding((ConstraintLayout) view, textView);
        Intrinsics3.checkNotNullExpressionValue(widgetStageChannelAudienceRoleBinding, "WidgetStageChannelAudien…oleBinding.bind(itemView)");
        this.binding = widgetStageChannelAudienceRoleBinding;
        LocaleManager localeManager = new LocaleManager();
        View view2 = this.itemView;
        Intrinsics3.checkNotNullExpressionValue(view2, "itemView");
        this.numberFormatter = NumberFormat.getNumberInstance(localeManager.getPrimaryLocale(view2.getContext()));
    }

    @Override // com.discord.utilities.mg_recycler.MGRecyclerViewHolder
    public /* bridge */ /* synthetic */ void onConfigure(int i, StageCallItem stageCallItem) {
        onConfigure2(i, stageCallItem);
    }

    @SuppressLint({"SetTextI18n"})
    /* renamed from: onConfigure, reason: avoid collision after fix types in other method */
    public void onConfigure2(int position, StageCallItem data) {
        Intrinsics3.checkNotNullParameter(data, "data");
        super.onConfigure(position, data);
        String str = this.numberFormatter.format(Integer.valueOf(((StageCallItem.AudienceHeaderItem) data).getAudienceSize()));
        TextView textView = this.binding.f18138b;
        Intrinsics3.checkNotNullExpressionValue(textView, "binding.stageChannelAudienceRoleText");
        FormatUtils.m222n(textView, C5419R.string.audience_section_header, new Object[]{str}, null, 4);
    }
}
