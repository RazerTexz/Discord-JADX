package com.discord.widgets.stage.start;

import android.view.View;
import com.discord.widgets.stage.start.ModeratorStartStageAdapter;

/* compiled from: ModeratorStartStageAdapter.kt */
/* renamed from: com.discord.widgets.stage.start.ModeratorStartStageAdapter$CreateStageEventViewHolder$onConfigure$1, reason: use source file name */
/* loaded from: classes2.dex */
public final class ModeratorStartStageAdapter2 implements View.OnClickListener {
    public final /* synthetic */ ModeratorStartStageItem $data;
    public final /* synthetic */ ModeratorStartStageAdapter.CreateStageEventViewHolder this$0;

    public ModeratorStartStageAdapter2(ModeratorStartStageAdapter.CreateStageEventViewHolder createStageEventViewHolder, ModeratorStartStageItem moderatorStartStageItem) {
        this.this$0 = createStageEventViewHolder;
        this.$data = moderatorStartStageItem;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        this.this$0.this$0.getOnItemClicked().invoke(this.$data);
    }
}
