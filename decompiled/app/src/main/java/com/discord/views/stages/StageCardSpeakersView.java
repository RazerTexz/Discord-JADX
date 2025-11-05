package com.discord.views.stages;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import b.a.i.v3;
import b.a.y.o0.c;
import com.discord.R;
import com.discord.utilities.dimen.DimenUtils;
import com.discord.utilities.mg_recycler.MGRecyclerAdapter;
import d0.z.d.m;

/* compiled from: StageCardSpeakersView.kt */
/* loaded from: classes2.dex */
public final class StageCardSpeakersView extends LinearLayout {
    public static final RecyclerView.ItemDecoration j = new a();

    /* renamed from: k, reason: from kotlin metadata */
    public final v3 binding;

    /* renamed from: l, reason: from kotlin metadata */
    public final c speakersAdapter;

    /* renamed from: m, reason: from kotlin metadata */
    public final GridLayoutManager speakersLayoutManager;

    /* compiled from: StageCardSpeakersView.kt */
    public static final class a extends RecyclerView.ItemDecoration {
        @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
        public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.State state) {
            m.checkNotNullParameter(rect, "outRect");
            m.checkNotNullParameter(view, "view");
            m.checkNotNullParameter(recyclerView, "parent");
            m.checkNotNullParameter(state, "state");
            super.getItemOffsets(rect, view, recyclerView, state);
            boolean z2 = recyclerView.getChildAdapterPosition(view) >= state.getItemCount() + (-2);
            rect.left = DimenUtils.dpToPixels(4);
            rect.right = DimenUtils.dpToPixels(4);
            rect.bottom = z2 ? 0 : DimenUtils.dpToPixels(8);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StageCardSpeakersView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m.checkNotNullParameter(context, "context");
        LayoutInflater.from(context).inflate(R.layout.view_stage_card_speakers, this);
        SpeakersRecyclerView speakersRecyclerView = (SpeakersRecyclerView) findViewById(R.id.discovery_speakers_recycler);
        if (speakersRecyclerView == null) {
            throw new NullPointerException("Missing required view with ID: ".concat(getResources().getResourceName(R.id.discovery_speakers_recycler)));
        }
        v3 v3Var = new v3(this, speakersRecyclerView);
        m.checkNotNullExpressionValue(v3Var, "ViewStageCardSpeakersBin…ater.from(context), this)");
        this.binding = v3Var;
        MGRecyclerAdapter.Companion companion = MGRecyclerAdapter.INSTANCE;
        m.checkNotNullExpressionValue(speakersRecyclerView, "binding.discoverySpeakersRecycler");
        c cVar = (c) companion.configure(new c(speakersRecyclerView));
        this.speakersAdapter = cVar;
        m.checkNotNullExpressionValue(speakersRecyclerView, "binding.discoverySpeakersRecycler");
        GridLayoutManager gridLayoutManager = new GridLayoutManager(speakersRecyclerView.getContext(), 2);
        gridLayoutManager.setSpanSizeLookup(cVar.a);
        this.speakersLayoutManager = gridLayoutManager;
        RecyclerView recycler = cVar.getRecycler();
        recycler.setLayoutManager(gridLayoutManager);
        recycler.addItemDecoration(j);
        recycler.setHasFixedSize(false);
    }
}
