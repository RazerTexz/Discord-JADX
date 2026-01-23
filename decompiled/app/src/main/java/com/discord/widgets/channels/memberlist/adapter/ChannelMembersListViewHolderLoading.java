package com.discord.widgets.channels.memberlist.adapter;

import androidx.constraintlayout.widget.Guideline;
import androidx.recyclerview.widget.RecyclerView;
import com.discord.databinding.WidgetChannelMembersListItemLoadingBinding;
import com.discord.models.domain.ModelAuditLogEntry;
import java.util.Map;
import p507d0.Tuples;
import p507d0.p580t.Maps6;
import p507d0.p592z.p594d.Intrinsics3;

/* JADX INFO: compiled from: ChannelMembersListViewHolderLoading.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ChannelMembersListViewHolderLoading extends RecyclerView.ViewHolder {
    private static final Map<Integer, Float> POSITION_PERCENT_MAP;
    private final WidgetChannelMembersListItemLoadingBinding binding;

    static {
        Float fValueOf = Float.valueOf(0.7f);
        Float fValueOf2 = Float.valueOf(0.3f);
        Float fValueOf3 = Float.valueOf(0.6f);
        Float fValueOf4 = Float.valueOf(0.4f);
        POSITION_PERCENT_MAP = Maps6.mapOf(Tuples.m10073to(0, fValueOf), Tuples.m10073to(1, fValueOf2), Tuples.m10073to(2, fValueOf3), Tuples.m10073to(3, fValueOf4), Tuples.m10073to(4, fValueOf3), Tuples.m10073to(5, Float.valueOf(0.8f)), Tuples.m10073to(6, fValueOf2), Tuples.m10073to(7, Float.valueOf(0.5f)), Tuples.m10073to(8, fValueOf), Tuples.m10073to(9, fValueOf4));
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ChannelMembersListViewHolderLoading(WidgetChannelMembersListItemLoadingBinding widgetChannelMembersListItemLoadingBinding) {
        super(widgetChannelMembersListItemLoadingBinding.f15859a);
        Intrinsics3.checkNotNullParameter(widgetChannelMembersListItemLoadingBinding, "binding");
        this.binding = widgetChannelMembersListItemLoadingBinding;
    }

    public final void bind(int position) {
        Guideline guideline = this.binding.f15860b;
        Float f = POSITION_PERCENT_MAP.get(Integer.valueOf(position % 10));
        guideline.setGuidelinePercent(f != null ? f.floatValue() : 0.0f);
    }
}
