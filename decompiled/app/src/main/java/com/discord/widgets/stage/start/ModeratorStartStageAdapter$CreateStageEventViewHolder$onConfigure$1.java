package com.discord.widgets.stage.start;

import android.view.View;
import com.discord.widgets.stage.start.ModeratorStartStageAdapter;

/* compiled from: ModeratorStartStageAdapter.kt */
/* loaded from: classes2.dex */
public final class ModeratorStartStageAdapter$CreateStageEventViewHolder$onConfigure$1 implements View.OnClickListener {
    public final /* synthetic */ ModeratorStartStageItem $data;
    public final /* synthetic */ ModeratorStartStageAdapter.CreateStageEventViewHolder this$0;

    public ModeratorStartStageAdapter$CreateStageEventViewHolder$onConfigure$1(ModeratorStartStageAdapter.CreateStageEventViewHolder createStageEventViewHolder, ModeratorStartStageItem moderatorStartStageItem) {
        this.this$0 = createStageEventViewHolder;
        this.$data = moderatorStartStageItem;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        this.this$0.this$0.getOnItemClicked().invoke(this.$data);
    }
}
