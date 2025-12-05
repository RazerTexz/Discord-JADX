package com.discord.widgets.voice.fullscreen.stage;

import android.view.View;
import androidx.annotation.LayoutRes;
import com.discord.utilities.mg_recycler.MGRecyclerViewHolder;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: StageCallViewHolder.kt */
/* loaded from: classes.dex */
public abstract class StageCallViewHolder extends MGRecyclerViewHolder<StageCallAdapter, StageCallItem> {

    /* compiled from: StageCallViewHolder.kt */
    /* renamed from: com.discord.widgets.voice.fullscreen.stage.StageCallViewHolder$1 */
    public static final class ViewOnClickListenerC105581 implements View.OnClickListener {
        public final /* synthetic */ StageCallAdapter $adapter;

        public ViewOnClickListenerC105581(StageCallAdapter stageCallAdapter) {
            this.$adapter = stageCallAdapter;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            if (StageCallViewHolder.this.getAdapterPosition() != -1) {
                StageCallAdapter stageCallAdapter = this.$adapter;
                stageCallAdapter.onItemClick$app_productionGoogleRelease(stageCallAdapter.getItem(StageCallViewHolder.this.getAdapterPosition()));
            }
        }
    }

    public /* synthetic */ StageCallViewHolder(int i, StageCallAdapter stageCallAdapter, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, stageCallAdapter);
    }

    private StageCallViewHolder(@LayoutRes int i, StageCallAdapter stageCallAdapter) {
        super(i, stageCallAdapter);
        this.itemView.setOnClickListener(new ViewOnClickListenerC105581(stageCallAdapter));
    }
}
