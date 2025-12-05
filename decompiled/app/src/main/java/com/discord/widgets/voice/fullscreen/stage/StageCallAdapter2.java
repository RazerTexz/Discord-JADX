package com.discord.widgets.voice.fullscreen.stage;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.discord.utilities.dimen.DimenUtils;
import java.util.Objects;
import p507d0.p592z.p594d.Intrinsics3;

/* compiled from: StageCallAdapter.kt */
/* renamed from: com.discord.widgets.voice.fullscreen.stage.StageCallAdapter$itemDecoration$1, reason: use source file name */
/* loaded from: classes.dex */
public final class StageCallAdapter2 extends RecyclerView.ItemDecoration {
    public final /* synthetic */ StageCallAdapter this$0;

    public StageCallAdapter2(StageCallAdapter stageCallAdapter) {
        this.this$0 = stageCallAdapter;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        Intrinsics3.checkNotNullParameter(outRect, "outRect");
        Intrinsics3.checkNotNullParameter(view, "view");
        Intrinsics3.checkNotNullParameter(parent, "parent");
        Intrinsics3.checkNotNullParameter(state, "state");
        int childAdapterPosition = parent.getChildAdapterPosition(view);
        if (childAdapterPosition != -1 && ((StageCallItem) StageCallAdapter.access$getInternalData$p(this.this$0).get(childAdapterPosition)).getType() == 1) {
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            Objects.requireNonNull(layoutParams, "null cannot be cast to non-null type androidx.recyclerview.widget.GridLayoutManager.LayoutParams");
            int spanIndex = ((GridLayoutManager.LayoutParams) layoutParams).getSpanIndex();
            if (StageCallAdapter.access$getNumSpeakers$p(this.this$0) == 2 && spanIndex == 0) {
                outRect.right = DimenUtils.dpToPixels(4);
                return;
            }
            if (spanIndex == 6) {
                outRect.left = DimenUtils.dpToPixels(4);
                return;
            }
            if (StageCallAdapter.access$getNumSpeakers$p(this.this$0) > 2 && spanIndex == 0) {
                outRect.right = DimenUtils.dpToPixels(5.33f);
            } else if (spanIndex == 8) {
                outRect.left = DimenUtils.dpToPixels(5.33f);
            } else if (spanIndex == 4) {
                outRect.set(DimenUtils.dpToPixels(2.67f), 0, DimenUtils.dpToPixels(2.67f), 0);
            }
        }
    }
}
