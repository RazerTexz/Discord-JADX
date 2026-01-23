package com.discord.utilities.views;

import android.graphics.Canvas;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.solver.widgets.analyzer.BasicMeasure;
import androidx.recyclerview.widget.RecyclerView;
import com.discord.C5419R;
import com.discord.models.domain.ModelAuditLogEntry;
import p507d0.p592z.p594d.Intrinsics3;

/* JADX INFO: compiled from: StickyHeaderItemDecoration.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StickyHeaderItemDecoration extends RecyclerView.ItemDecoration {
    private Float actionDownRawX;
    private Float actionDownRawY;
    private final StickyHeaderAdapter adapter;
    private float stickyHeaderBottom;

    /* JADX INFO: compiled from: StickyHeaderItemDecoration.kt */
    public static final class LayoutManager {
        public static final LayoutManager INSTANCE = new LayoutManager();

        private LayoutManager() {
        }

        public static final void layoutHeaderView(ViewGroup parent, View view) {
            Intrinsics3.checkNotNullParameter(parent, "parent");
            Intrinsics3.checkNotNullParameter(view, "view");
            int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(parent.getWidth(), BasicMeasure.EXACTLY);
            int iMakeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(parent.getHeight(), 0);
            view.measure(ViewGroup.getChildMeasureSpec(iMakeMeasureSpec, parent.getPaddingRight() + parent.getPaddingLeft(), view.getLayoutParams().width), ViewGroup.getChildMeasureSpec(iMakeMeasureSpec2, parent.getPaddingBottom() + parent.getPaddingTop(), view.getLayoutParams().height));
            view.layout(0, 0, view.getMeasuredWidth(), view.getMeasuredHeight());
        }
    }

    /* JADX INFO: compiled from: StickyHeaderItemDecoration.kt */
    public interface StickyHeaderAdapter {
        View getAndBindHeaderView(int position);

        Integer getHeaderPositionForItem(int itemPosition);

        boolean isHeader(int position);
    }

    /* JADX INFO: renamed from: com.discord.utilities.views.StickyHeaderItemDecoration$blockClicks$1 */
    /* JADX INFO: compiled from: StickyHeaderItemDecoration.kt */
    public static final class C70271 extends RecyclerView.SimpleOnItemTouchListener {
        public C70271() {
        }

        /* JADX WARN: Removed duplicated region for block: B:17:0x005f  */
        @Override // androidx.recyclerview.widget.RecyclerView.SimpleOnItemTouchListener, androidx.recyclerview.widget.RecyclerView.OnItemTouchListener
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public boolean onInterceptTouchEvent(RecyclerView recyclerView, MotionEvent event) {
            boolean z2;
            Intrinsics3.checkNotNullParameter(recyclerView, "recyclerView");
            Intrinsics3.checkNotNullParameter(event, "event");
            int action = event.getAction();
            if (action == 0) {
                StickyHeaderItemDecoration.access$setActionDownRawX$p(StickyHeaderItemDecoration.this, Float.valueOf(event.getRawX()));
                StickyHeaderItemDecoration.access$setActionDownRawY$p(StickyHeaderItemDecoration.this, Float.valueOf(event.getRawY()));
            } else if (action == 1) {
                Float fAccess$getActionDownRawX$p = StickyHeaderItemDecoration.access$getActionDownRawX$p(StickyHeaderItemDecoration.this);
                Float fAccess$getActionDownRawY$p = StickyHeaderItemDecoration.access$getActionDownRawY$p(StickyHeaderItemDecoration.this);
                if (fAccess$getActionDownRawX$p == null || fAccess$getActionDownRawY$p == null) {
                    z2 = false;
                    StickyHeaderItemDecoration.access$resetActionDownCoordinates(StickyHeaderItemDecoration.this);
                    if (!z2 && event.getY() <= StickyHeaderItemDecoration.access$getStickyHeaderBottom$p(StickyHeaderItemDecoration.this)) {
                        return true;
                    }
                } else {
                    float fAbs = Math.abs(event.getRawX() - fAccess$getActionDownRawX$p.floatValue());
                    float fAbs2 = Math.abs(event.getRawY() - fAccess$getActionDownRawY$p.floatValue());
                    float dimensionPixelSize = recyclerView.getResources().getDimensionPixelSize(C5419R.dimen.default_scroll_slop);
                    if (fAbs < dimensionPixelSize && fAbs2 < dimensionPixelSize) {
                        z2 = true;
                    }
                    StickyHeaderItemDecoration.access$resetActionDownCoordinates(StickyHeaderItemDecoration.this);
                    if (!z2) {
                    }
                }
            } else if (action == 3) {
                StickyHeaderItemDecoration.access$resetActionDownCoordinates(StickyHeaderItemDecoration.this);
            }
            return false;
        }
    }

    public StickyHeaderItemDecoration(StickyHeaderAdapter stickyHeaderAdapter) {
        Intrinsics3.checkNotNullParameter(stickyHeaderAdapter, "adapter");
        this.adapter = stickyHeaderAdapter;
    }

    public static final /* synthetic */ Float access$getActionDownRawX$p(StickyHeaderItemDecoration stickyHeaderItemDecoration) {
        return stickyHeaderItemDecoration.actionDownRawX;
    }

    public static final /* synthetic */ Float access$getActionDownRawY$p(StickyHeaderItemDecoration stickyHeaderItemDecoration) {
        return stickyHeaderItemDecoration.actionDownRawY;
    }

    public static final /* synthetic */ float access$getStickyHeaderBottom$p(StickyHeaderItemDecoration stickyHeaderItemDecoration) {
        return stickyHeaderItemDecoration.stickyHeaderBottom;
    }

    public static final /* synthetic */ void access$resetActionDownCoordinates(StickyHeaderItemDecoration stickyHeaderItemDecoration) {
        stickyHeaderItemDecoration.resetActionDownCoordinates();
    }

    public static final /* synthetic */ void access$setActionDownRawX$p(StickyHeaderItemDecoration stickyHeaderItemDecoration, Float f) {
        stickyHeaderItemDecoration.actionDownRawX = f;
    }

    public static final /* synthetic */ void access$setActionDownRawY$p(StickyHeaderItemDecoration stickyHeaderItemDecoration, Float f) {
        stickyHeaderItemDecoration.actionDownRawY = f;
    }

    public static final /* synthetic */ void access$setStickyHeaderBottom$p(StickyHeaderItemDecoration stickyHeaderItemDecoration, float f) {
        stickyHeaderItemDecoration.stickyHeaderBottom = f;
    }

    private final void drawHeader(Canvas c, View header, float offsetY) {
        c.save();
        if (offsetY != 0.0f) {
            c.translate(0.0f, offsetY);
        }
        this.stickyHeaderBottom = header.getBottom() - offsetY;
        header.draw(c);
        c.restore();
    }

    public static /* synthetic */ void drawHeader$default(StickyHeaderItemDecoration stickyHeaderItemDecoration, Canvas canvas, View view, float f, int i, Object obj) {
        if ((i & 4) != 0) {
            f = 0.0f;
        }
        stickyHeaderItemDecoration.drawHeader(canvas, view, f);
    }

    private final View getAndBindHeaderViewForItem(int itemPosition) {
        Integer headerPositionForItem = this.adapter.getHeaderPositionForItem(itemPosition);
        if (headerPositionForItem == null) {
            return null;
        }
        return this.adapter.getAndBindHeaderView(headerPositionForItem.intValue());
    }

    private final View getOverlappingView(RecyclerView parent, int contactPoint) {
        int childCount = parent.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = parent.getChildAt(i);
            Intrinsics3.checkNotNullExpressionValue(childAt, "child");
            int top = childAt.getTop();
            int bottom = childAt.getBottom();
            if (top <= contactPoint && bottom > contactPoint) {
                return childAt;
            }
        }
        return null;
    }

    private final void resetActionDownCoordinates() {
        this.actionDownRawX = null;
        this.actionDownRawY = null;
    }

    public final void blockClicks(RecyclerView parent) {
        Intrinsics3.checkNotNullParameter(parent, "parent");
        parent.addOnItemTouchListener(new C70271());
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public void onDrawOver(Canvas canvas, RecyclerView parent, RecyclerView.State state) {
        int childAdapterPosition;
        int childAdapterPosition2;
        Intrinsics3.checkNotNullParameter(canvas, "canvas");
        Intrinsics3.checkNotNullParameter(parent, "parent");
        Intrinsics3.checkNotNullParameter(state, "state");
        super.onDrawOver(canvas, parent, state);
        View childAt = parent.getChildAt(0);
        if (childAt == null || (childAdapterPosition = parent.getChildAdapterPosition(childAt)) == -1) {
            return;
        }
        View andBindHeaderViewForItem = getAndBindHeaderViewForItem(childAdapterPosition);
        float top = 0.0f;
        if (andBindHeaderViewForItem == null) {
            this.stickyHeaderBottom = 0.0f;
            return;
        }
        int top2 = parent.getTop() + andBindHeaderViewForItem.getBottom();
        int top3 = parent.getTop();
        int bottom = parent.getBottom();
        if (top3 > top2 || bottom <= top2) {
            return;
        }
        View overlappingView = getOverlappingView(parent, andBindHeaderViewForItem.getBottom());
        if (overlappingView != null && (childAdapterPosition2 = parent.getChildAdapterPosition(overlappingView)) != -1 && this.adapter.isHeader(childAdapterPosition2)) {
            top = overlappingView.getTop() - andBindHeaderViewForItem.getHeight();
        }
        drawHeader(canvas, andBindHeaderViewForItem, top);
    }
}
