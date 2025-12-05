package com.discord.widgets.channels.permissions;

import androidx.recyclerview.widget.RecyclerView;
import com.discord.utilities.mg_recycler.MGRecyclerAdapter;
import kotlin.jvm.functions.Function0;
import p507d0.p592z.p594d.Intrinsics3;
import p507d0.p592z.p594d.Lambda;

/* compiled from: WidgetChannelSettingsAddMemberFragment.kt */
/* renamed from: com.discord.widgets.channels.permissions.WidgetChannelSettingsAddMemberFragment$adapter$2, reason: use source file name */
/* loaded from: classes2.dex */
public final class WidgetChannelSettingsAddMemberFragment2 extends Lambda implements Function0<AddMemberAdapter> {
    public final /* synthetic */ WidgetChannelSettingsAddMemberFragment this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetChannelSettingsAddMemberFragment2(WidgetChannelSettingsAddMemberFragment widgetChannelSettingsAddMemberFragment) {
        super(0);
        this.this$0 = widgetChannelSettingsAddMemberFragment;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ AddMemberAdapter invoke() {
        return invoke();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final AddMemberAdapter invoke() {
        MGRecyclerAdapter.Companion companion = MGRecyclerAdapter.INSTANCE;
        RecyclerView recyclerView = WidgetChannelSettingsAddMemberFragment.access$getBinding$p(this.this$0).f15896b;
        Intrinsics3.checkNotNullExpressionValue(recyclerView, "binding.recycler");
        return (AddMemberAdapter) companion.configure(new AddMemberAdapter(recyclerView));
    }
}
