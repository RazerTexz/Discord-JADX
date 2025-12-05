package com.google.android.flexbox;

import android.content.Context;
import android.graphics.PointF;
import android.graphics.Rect;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.core.view.ViewCompat;
import androidx.recyclerview.widget.LinearSmoothScroller;
import androidx.recyclerview.widget.OrientationHelper;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;
import p007b.p100d.p104b.p105a.outline;
import p007b.p225i.p226a.p287e.FlexContainer;
import p007b.p225i.p226a.p287e.FlexLine;
import p007b.p225i.p226a.p287e.FlexboxHelper;

/* loaded from: classes3.dex */
public class FlexboxLayoutManager extends RecyclerView.LayoutManager implements FlexContainer, RecyclerView.SmoothScroller.ScrollVectorProvider {

    /* renamed from: j */
    public static final Rect f20318j = new Rect();

    /* renamed from: E */
    public final Context f20323E;

    /* renamed from: F */
    public View f20324F;

    /* renamed from: k */
    public int f20327k;

    /* renamed from: l */
    public int f20328l;

    /* renamed from: m */
    public int f20329m;

    /* renamed from: o */
    public boolean f20331o;

    /* renamed from: p */
    public boolean f20332p;

    /* renamed from: s */
    public RecyclerView.Recycler f20335s;

    /* renamed from: t */
    public RecyclerView.State f20336t;

    /* renamed from: u */
    public C10784c f20337u;

    /* renamed from: w */
    public OrientationHelper f20339w;

    /* renamed from: x */
    public OrientationHelper f20340x;

    /* renamed from: y */
    public SavedState f20341y;

    /* renamed from: n */
    public int f20330n = -1;

    /* renamed from: q */
    public List<FlexLine> f20333q = new ArrayList();

    /* renamed from: r */
    public final FlexboxHelper f20334r = new FlexboxHelper(this);

    /* renamed from: v */
    public C10783b f20338v = new C10783b(null);

    /* renamed from: z */
    public int f20342z = -1;

    /* renamed from: A */
    public int f20319A = Integer.MIN_VALUE;

    /* renamed from: B */
    public int f20320B = Integer.MIN_VALUE;

    /* renamed from: C */
    public int f20321C = Integer.MIN_VALUE;

    /* renamed from: D */
    public SparseArray<View> f20322D = new SparseArray<>();

    /* renamed from: G */
    public int f20325G = -1;

    /* renamed from: H */
    public FlexboxHelper.b f20326H = new FlexboxHelper.b();

    public static class SavedState implements Parcelable {
        public static final Parcelable.Creator<SavedState> CREATOR = new C10781a();

        /* renamed from: j */
        public int f20352j;

        /* renamed from: k */
        public int f20353k;

        /* renamed from: com.google.android.flexbox.FlexboxLayoutManager$SavedState$a */
        public static class C10781a implements Parcelable.Creator<SavedState> {
            @Override // android.os.Parcelable.Creator
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel, (C10782a) null);
            }

            @Override // android.os.Parcelable.Creator
            public SavedState[] newArray(int i) {
                return new SavedState[i];
            }
        }

        public SavedState() {
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public String toString() {
            StringBuilder sbM833U = outline.m833U("SavedState{mAnchorPosition=");
            sbM833U.append(this.f20352j);
            sbM833U.append(", mAnchorOffset=");
            return outline.m813A(sbM833U, this.f20353k, '}');
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeInt(this.f20352j);
            parcel.writeInt(this.f20353k);
        }

        public SavedState(Parcel parcel, C10782a c10782a) {
            this.f20352j = parcel.readInt();
            this.f20353k = parcel.readInt();
        }

        public SavedState(SavedState savedState, C10782a c10782a) {
            this.f20352j = savedState.f20352j;
            this.f20353k = savedState.f20353k;
        }
    }

    /* renamed from: com.google.android.flexbox.FlexboxLayoutManager$b */
    public class C10783b {

        /* renamed from: a */
        public int f20354a;

        /* renamed from: b */
        public int f20355b;

        /* renamed from: c */
        public int f20356c;

        /* renamed from: d */
        public int f20357d = 0;

        /* renamed from: e */
        public boolean f20358e;

        /* renamed from: f */
        public boolean f20359f;

        /* renamed from: g */
        public boolean f20360g;

        public C10783b(C10782a c10782a) {
        }

        /* renamed from: a */
        public static void m8998a(C10783b c10783b) {
            if (!FlexboxLayoutManager.this.mo3932i()) {
                FlexboxLayoutManager flexboxLayoutManager = FlexboxLayoutManager.this;
                if (flexboxLayoutManager.f20331o) {
                    c10783b.f20356c = c10783b.f20358e ? flexboxLayoutManager.f20339w.getEndAfterPadding() : flexboxLayoutManager.getWidth() - FlexboxLayoutManager.this.f20339w.getStartAfterPadding();
                    return;
                }
            }
            c10783b.f20356c = c10783b.f20358e ? FlexboxLayoutManager.this.f20339w.getEndAfterPadding() : FlexboxLayoutManager.this.f20339w.getStartAfterPadding();
        }

        /* renamed from: b */
        public static void m8999b(C10783b c10783b) {
            c10783b.f20354a = -1;
            c10783b.f20355b = -1;
            c10783b.f20356c = Integer.MIN_VALUE;
            c10783b.f20359f = false;
            c10783b.f20360g = false;
            if (FlexboxLayoutManager.this.mo3932i()) {
                FlexboxLayoutManager flexboxLayoutManager = FlexboxLayoutManager.this;
                int i = flexboxLayoutManager.f20328l;
                if (i == 0) {
                    c10783b.f20358e = flexboxLayoutManager.f20327k == 1;
                    return;
                } else {
                    c10783b.f20358e = i == 2;
                    return;
                }
            }
            FlexboxLayoutManager flexboxLayoutManager2 = FlexboxLayoutManager.this;
            int i2 = flexboxLayoutManager2.f20328l;
            if (i2 == 0) {
                c10783b.f20358e = flexboxLayoutManager2.f20327k == 3;
            } else {
                c10783b.f20358e = i2 == 2;
            }
        }

        public String toString() {
            StringBuilder sbM833U = outline.m833U("AnchorInfo{mPosition=");
            sbM833U.append(this.f20354a);
            sbM833U.append(", mFlexLinePosition=");
            sbM833U.append(this.f20355b);
            sbM833U.append(", mCoordinate=");
            sbM833U.append(this.f20356c);
            sbM833U.append(", mPerpendicularCoordinate=");
            sbM833U.append(this.f20357d);
            sbM833U.append(", mLayoutFromEnd=");
            sbM833U.append(this.f20358e);
            sbM833U.append(", mValid=");
            sbM833U.append(this.f20359f);
            sbM833U.append(", mAssignedFromSavedState=");
            sbM833U.append(this.f20360g);
            sbM833U.append('}');
            return sbM833U.toString();
        }
    }

    /* renamed from: com.google.android.flexbox.FlexboxLayoutManager$c */
    public static class C10784c {

        /* renamed from: a */
        public int f20362a;

        /* renamed from: b */
        public boolean f20363b;

        /* renamed from: c */
        public int f20364c;

        /* renamed from: d */
        public int f20365d;

        /* renamed from: e */
        public int f20366e;

        /* renamed from: f */
        public int f20367f;

        /* renamed from: g */
        public int f20368g;

        /* renamed from: h */
        public int f20369h = 1;

        /* renamed from: i */
        public int f20370i = 1;

        /* renamed from: j */
        public boolean f20371j;

        public C10784c(C10782a c10782a) {
        }

        public String toString() {
            StringBuilder sbM833U = outline.m833U("LayoutState{mAvailable=");
            sbM833U.append(this.f20362a);
            sbM833U.append(", mFlexLinePosition=");
            sbM833U.append(this.f20364c);
            sbM833U.append(", mPosition=");
            sbM833U.append(this.f20365d);
            sbM833U.append(", mOffset=");
            sbM833U.append(this.f20366e);
            sbM833U.append(", mScrollingOffset=");
            sbM833U.append(this.f20367f);
            sbM833U.append(", mLastScrollDelta=");
            sbM833U.append(this.f20368g);
            sbM833U.append(", mItemDirection=");
            sbM833U.append(this.f20369h);
            sbM833U.append(", mLayoutDirection=");
            return outline.m813A(sbM833U, this.f20370i, '}');
        }
    }

    public FlexboxLayoutManager(Context context, AttributeSet attributeSet, int i, int i2) {
        RecyclerView.LayoutManager.Properties properties = RecyclerView.LayoutManager.getProperties(context, attributeSet, i, i2);
        int i3 = properties.orientation;
        if (i3 != 0) {
            if (i3 == 1) {
                if (properties.reverseLayout) {
                    m8995x(3);
                } else {
                    m8995x(2);
                }
            }
        } else if (properties.reverseLayout) {
            m8995x(1);
        } else {
            m8995x(0);
        }
        int i4 = this.f20328l;
        if (i4 != 1) {
            if (i4 == 0) {
                removeAllViews();
                m8982k();
            }
            this.f20328l = 1;
            this.f20339w = null;
            this.f20340x = null;
            requestLayout();
        }
        if (this.f20329m != 4) {
            removeAllViews();
            m8982k();
            this.f20329m = 4;
            requestLayout();
        }
        setAutoMeasureEnabled(true);
        this.f20323E = context;
    }

    public static boolean isMeasurementUpToDate(int i, int i2, int i3) {
        int mode = View.MeasureSpec.getMode(i2);
        int size = View.MeasureSpec.getSize(i2);
        if (i3 > 0 && i != i3) {
            return false;
        }
        if (mode == Integer.MIN_VALUE) {
            return size >= i;
        }
        if (mode != 0) {
            return mode == 1073741824 && size == i;
        }
        return true;
    }

    private boolean shouldMeasureChild(View view, int i, int i2, RecyclerView.LayoutParams layoutParams) {
        return (!view.isLayoutRequested() && isMeasurementCacheEnabled() && isMeasurementUpToDate(view.getWidth(), i, ((ViewGroup.MarginLayoutParams) layoutParams).width) && isMeasurementUpToDate(view.getHeight(), i2, ((ViewGroup.MarginLayoutParams) layoutParams).height)) ? false : true;
    }

    /* renamed from: A */
    public final void m8981A(C10783b c10783b, boolean z2, boolean z3) {
        if (z3) {
            m8994w();
        } else {
            this.f20337u.f20363b = false;
        }
        if (mo3932i() || !this.f20331o) {
            this.f20337u.f20362a = c10783b.f20356c - this.f20339w.getStartAfterPadding();
        } else {
            this.f20337u.f20362a = (this.f20324F.getWidth() - c10783b.f20356c) - this.f20339w.getStartAfterPadding();
        }
        C10784c c10784c = this.f20337u;
        c10784c.f20365d = c10783b.f20354a;
        c10784c.f20369h = 1;
        c10784c.f20370i = -1;
        c10784c.f20366e = c10783b.f20356c;
        c10784c.f20367f = Integer.MIN_VALUE;
        int i = c10783b.f20355b;
        c10784c.f20364c = i;
        if (!z2 || i <= 0) {
            return;
        }
        int size = this.f20333q.size();
        int i2 = c10783b.f20355b;
        if (size > i2) {
            FlexLine flexLine = this.f20333q.get(i2);
            r4.f20364c--;
            this.f20337u.f20365d -= flexLine.f9170h;
        }
    }

    @Override // p007b.p225i.p226a.p287e.FlexContainer
    /* renamed from: a */
    public void mo3924a(View view, int i, int i2, FlexLine flexLine) {
        calculateItemDecorationsForChild(view, f20318j);
        if (mo3932i()) {
            int rightDecorationWidth = getRightDecorationWidth(view) + getLeftDecorationWidth(view);
            flexLine.f9167e += rightDecorationWidth;
            flexLine.f9168f += rightDecorationWidth;
            return;
        }
        int bottomDecorationHeight = getBottomDecorationHeight(view) + getTopDecorationHeight(view);
        flexLine.f9167e += bottomDecorationHeight;
        flexLine.f9168f += bottomDecorationHeight;
    }

    @Override // p007b.p225i.p226a.p287e.FlexContainer
    /* renamed from: b */
    public void mo3925b(FlexLine flexLine) {
    }

    @Override // p007b.p225i.p226a.p287e.FlexContainer
    /* renamed from: c */
    public View mo3926c(int i) {
        return mo3929f(i);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public boolean canScrollHorizontally() {
        if (this.f20328l == 0) {
            return mo3932i();
        }
        if (mo3932i()) {
            int width = getWidth();
            View view = this.f20324F;
            if (width <= (view != null ? view.getWidth() : 0)) {
                return false;
            }
        }
        return true;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public boolean canScrollVertically() {
        if (this.f20328l == 0) {
            return !mo3932i();
        }
        if (mo3932i()) {
            return true;
        }
        int height = getHeight();
        View view = this.f20324F;
        return height > (view != null ? view.getHeight() : 0);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public boolean checkLayoutParams(RecyclerView.LayoutParams layoutParams) {
        return layoutParams instanceof LayoutParams;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int computeHorizontalScrollExtent(RecyclerView.State state) {
        return computeScrollExtent(state);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int computeHorizontalScrollOffset(RecyclerView.State state) {
        return computeScrollOffset(state);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int computeHorizontalScrollRange(RecyclerView.State state) {
        return computeScrollRange(state);
    }

    public final int computeScrollExtent(RecyclerView.State state) {
        if (getChildCount() == 0) {
            return 0;
        }
        int itemCount = state.getItemCount();
        m8983l();
        View viewM8985n = m8985n(itemCount);
        View viewM8987p = m8987p(itemCount);
        if (state.getItemCount() == 0 || viewM8985n == null || viewM8987p == null) {
            return 0;
        }
        return Math.min(this.f20339w.getTotalSpace(), this.f20339w.getDecoratedEnd(viewM8987p) - this.f20339w.getDecoratedStart(viewM8985n));
    }

    public final int computeScrollOffset(RecyclerView.State state) {
        if (getChildCount() == 0) {
            return 0;
        }
        int itemCount = state.getItemCount();
        View viewM8985n = m8985n(itemCount);
        View viewM8987p = m8987p(itemCount);
        if (state.getItemCount() != 0 && viewM8985n != null && viewM8987p != null) {
            int position = getPosition(viewM8985n);
            int position2 = getPosition(viewM8987p);
            int iAbs = Math.abs(this.f20339w.getDecoratedEnd(viewM8987p) - this.f20339w.getDecoratedStart(viewM8985n));
            int i = this.f20334r.f9183c[position];
            if (i != 0 && i != -1) {
                return Math.round((i * (iAbs / ((r4[position2] - i) + 1))) + (this.f20339w.getStartAfterPadding() - this.f20339w.getDecoratedStart(viewM8985n)));
            }
        }
        return 0;
    }

    public final int computeScrollRange(RecyclerView.State state) {
        if (getChildCount() == 0) {
            return 0;
        }
        int itemCount = state.getItemCount();
        View viewM8985n = m8985n(itemCount);
        View viewM8987p = m8987p(itemCount);
        if (state.getItemCount() == 0 || viewM8985n == null || viewM8987p == null) {
            return 0;
        }
        return (int) ((Math.abs(this.f20339w.getDecoratedEnd(viewM8987p) - this.f20339w.getDecoratedStart(viewM8985n)) / ((findLastVisibleItemPosition() - (m8989r(0, getChildCount(), false) == null ? -1 : getPosition(r1))) + 1)) * state.getItemCount());
    }

    @Override // androidx.recyclerview.widget.RecyclerView.SmoothScroller.ScrollVectorProvider
    public PointF computeScrollVectorForPosition(int i) {
        if (getChildCount() == 0) {
            return null;
        }
        int i2 = i < getPosition(getChildAt(0)) ? -1 : 1;
        return mo3932i() ? new PointF(0.0f, i2) : new PointF(i2, 0.0f);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int computeVerticalScrollExtent(RecyclerView.State state) {
        return computeScrollExtent(state);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int computeVerticalScrollOffset(RecyclerView.State state) {
        return computeScrollOffset(state);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int computeVerticalScrollRange(RecyclerView.State state) {
        return computeScrollRange(state);
    }

    @Override // p007b.p225i.p226a.p287e.FlexContainer
    /* renamed from: d */
    public int mo3927d(int i, int i2, int i3) {
        return RecyclerView.LayoutManager.getChildMeasureSpec(getWidth(), getWidthMode(), i2, i3, canScrollHorizontally());
    }

    @Override // p007b.p225i.p226a.p287e.FlexContainer
    /* renamed from: e */
    public void mo3928e(int i, View view) {
        this.f20322D.put(i, view);
    }

    @Override // p007b.p225i.p226a.p287e.FlexContainer
    /* renamed from: f */
    public View mo3929f(int i) {
        View view = this.f20322D.get(i);
        return view != null ? view : this.f20335s.getViewForPosition(i);
    }

    public int findLastVisibleItemPosition() {
        View viewM8989r = m8989r(getChildCount() - 1, -1, false);
        if (viewM8989r == null) {
            return -1;
        }
        return getPosition(viewM8989r);
    }

    public final int fixLayoutEndGap(int i, RecyclerView.Recycler recycler, RecyclerView.State state, boolean z2) {
        int iM8991t;
        int endAfterPadding;
        if (!mo3932i() && this.f20331o) {
            int startAfterPadding = i - this.f20339w.getStartAfterPadding();
            if (startAfterPadding <= 0) {
                return 0;
            }
            iM8991t = m8991t(startAfterPadding, recycler, state);
        } else {
            int endAfterPadding2 = this.f20339w.getEndAfterPadding() - i;
            if (endAfterPadding2 <= 0) {
                return 0;
            }
            iM8991t = -m8991t(-endAfterPadding2, recycler, state);
        }
        int i2 = i + iM8991t;
        if (!z2 || (endAfterPadding = this.f20339w.getEndAfterPadding() - i2) <= 0) {
            return iM8991t;
        }
        this.f20339w.offsetChildren(endAfterPadding);
        return endAfterPadding + iM8991t;
    }

    public final int fixLayoutStartGap(int i, RecyclerView.Recycler recycler, RecyclerView.State state, boolean z2) {
        int iM8991t;
        int startAfterPadding;
        if (mo3932i() || !this.f20331o) {
            int startAfterPadding2 = i - this.f20339w.getStartAfterPadding();
            if (startAfterPadding2 <= 0) {
                return 0;
            }
            iM8991t = -m8991t(startAfterPadding2, recycler, state);
        } else {
            int endAfterPadding = this.f20339w.getEndAfterPadding() - i;
            if (endAfterPadding <= 0) {
                return 0;
            }
            iM8991t = m8991t(-endAfterPadding, recycler, state);
        }
        int i2 = i + iM8991t;
        if (!z2 || (startAfterPadding = i2 - this.f20339w.getStartAfterPadding()) <= 0) {
            return iM8991t;
        }
        this.f20339w.offsetChildren(-startAfterPadding);
        return iM8991t - startAfterPadding;
    }

    @Override // p007b.p225i.p226a.p287e.FlexContainer
    /* renamed from: g */
    public int mo3930g(View view, int i, int i2) {
        int topDecorationHeight;
        int bottomDecorationHeight;
        if (mo3932i()) {
            topDecorationHeight = getLeftDecorationWidth(view);
            bottomDecorationHeight = getRightDecorationWidth(view);
        } else {
            topDecorationHeight = getTopDecorationHeight(view);
            bottomDecorationHeight = getBottomDecorationHeight(view);
        }
        return bottomDecorationHeight + topDecorationHeight;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public RecyclerView.LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams(-2, -2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public RecyclerView.LayoutParams generateLayoutParams(Context context, AttributeSet attributeSet) {
        return new LayoutParams(context, attributeSet);
    }

    @Override // p007b.p225i.p226a.p287e.FlexContainer
    public int getAlignContent() {
        return 5;
    }

    @Override // p007b.p225i.p226a.p287e.FlexContainer
    public int getAlignItems() {
        return this.f20329m;
    }

    @Override // p007b.p225i.p226a.p287e.FlexContainer
    public int getFlexDirection() {
        return this.f20327k;
    }

    @Override // p007b.p225i.p226a.p287e.FlexContainer
    public int getFlexItemCount() {
        return this.f20336t.getItemCount();
    }

    @Override // p007b.p225i.p226a.p287e.FlexContainer
    public List<FlexLine> getFlexLinesInternal() {
        return this.f20333q;
    }

    @Override // p007b.p225i.p226a.p287e.FlexContainer
    public int getFlexWrap() {
        return this.f20328l;
    }

    @Override // p007b.p225i.p226a.p287e.FlexContainer
    public int getLargestMainSize() {
        if (this.f20333q.size() == 0) {
            return 0;
        }
        int iMax = Integer.MIN_VALUE;
        int size = this.f20333q.size();
        for (int i = 0; i < size; i++) {
            iMax = Math.max(iMax, this.f20333q.get(i).f9167e);
        }
        return iMax;
    }

    @Override // p007b.p225i.p226a.p287e.FlexContainer
    public int getMaxLine() {
        return this.f20330n;
    }

    @Override // p007b.p225i.p226a.p287e.FlexContainer
    public int getSumOfCrossSize() {
        int size = this.f20333q.size();
        int i = 0;
        for (int i2 = 0; i2 < size; i2++) {
            i += this.f20333q.get(i2).f9169g;
        }
        return i;
    }

    @Override // p007b.p225i.p226a.p287e.FlexContainer
    /* renamed from: h */
    public int mo3931h(int i, int i2, int i3) {
        return RecyclerView.LayoutManager.getChildMeasureSpec(getHeight(), getHeightMode(), i2, i3, canScrollVertically());
    }

    @Override // p007b.p225i.p226a.p287e.FlexContainer
    /* renamed from: i */
    public boolean mo3932i() {
        int i = this.f20327k;
        return i == 0 || i == 1;
    }

    @Override // p007b.p225i.p226a.p287e.FlexContainer
    /* renamed from: j */
    public int mo3933j(View view) {
        int leftDecorationWidth;
        int rightDecorationWidth;
        if (mo3932i()) {
            leftDecorationWidth = getTopDecorationHeight(view);
            rightDecorationWidth = getBottomDecorationHeight(view);
        } else {
            leftDecorationWidth = getLeftDecorationWidth(view);
            rightDecorationWidth = getRightDecorationWidth(view);
        }
        return rightDecorationWidth + leftDecorationWidth;
    }

    /* renamed from: k */
    public final void m8982k() {
        this.f20333q.clear();
        C10783b.m8999b(this.f20338v);
        this.f20338v.f20357d = 0;
    }

    /* renamed from: l */
    public final void m8983l() {
        if (this.f20339w != null) {
            return;
        }
        if (mo3932i()) {
            if (this.f20328l == 0) {
                this.f20339w = OrientationHelper.createHorizontalHelper(this);
                this.f20340x = OrientationHelper.createVerticalHelper(this);
                return;
            } else {
                this.f20339w = OrientationHelper.createVerticalHelper(this);
                this.f20340x = OrientationHelper.createHorizontalHelper(this);
                return;
            }
        }
        if (this.f20328l == 0) {
            this.f20339w = OrientationHelper.createVerticalHelper(this);
            this.f20340x = OrientationHelper.createHorizontalHelper(this);
        } else {
            this.f20339w = OrientationHelper.createHorizontalHelper(this);
            this.f20340x = OrientationHelper.createVerticalHelper(this);
        }
    }

    /* renamed from: m */
    public final int m8984m(RecyclerView.Recycler recycler, RecyclerView.State state, C10784c c10784c) {
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        int i10;
        int i11;
        int i12;
        int i13;
        int i14;
        int i15;
        int i16 = c10784c.f20367f;
        if (i16 != Integer.MIN_VALUE) {
            int i17 = c10784c.f20362a;
            if (i17 < 0) {
                c10784c.f20367f = i16 + i17;
            }
            m8993v(recycler, c10784c);
        }
        int i18 = c10784c.f20362a;
        boolean zMo3932i = mo3932i();
        int i19 = i18;
        int i20 = 0;
        while (true) {
            if (i19 <= 0 && !this.f20337u.f20363b) {
                break;
            }
            List<FlexLine> list = this.f20333q;
            int i21 = c10784c.f20365d;
            if (!(i21 >= 0 && i21 < state.getItemCount() && (i15 = c10784c.f20364c) >= 0 && i15 < list.size())) {
                break;
            }
            FlexLine flexLine = this.f20333q.get(c10784c.f20364c);
            c10784c.f20365d = flexLine.f9177o;
            if (mo3932i()) {
                int paddingLeft = getPaddingLeft();
                int paddingRight = getPaddingRight();
                int width = getWidth();
                int i22 = c10784c.f20366e;
                if (c10784c.f20370i == -1) {
                    i22 -= flexLine.f9169g;
                }
                int i23 = c10784c.f20365d;
                float f = width - paddingRight;
                float f2 = this.f20338v.f20357d;
                float rightDecorationWidth = paddingLeft - f2;
                float leftDecorationWidth = f - f2;
                float fMax = Math.max(0.0f, 0.0f);
                int i24 = flexLine.f9170h;
                int i25 = i23;
                int i26 = 0;
                while (i25 < i23 + i24) {
                    View viewMo3929f = mo3929f(i25);
                    if (viewMo3929f == null) {
                        i12 = i18;
                        i11 = i23;
                        i13 = i25;
                        i14 = i24;
                    } else {
                        i11 = i23;
                        int i27 = i24;
                        if (c10784c.f20370i == 1) {
                            calculateItemDecorationsForChild(viewMo3929f, f20318j);
                            addView(viewMo3929f);
                        } else {
                            calculateItemDecorationsForChild(viewMo3929f, f20318j);
                            addView(viewMo3929f, i26);
                            i26++;
                        }
                        int i28 = i26;
                        FlexboxHelper flexboxHelper = this.f20334r;
                        i12 = i18;
                        long j = flexboxHelper.f9184d[i25];
                        int i29 = (int) j;
                        int iM3950m = flexboxHelper.m3950m(j);
                        if (shouldMeasureChild(viewMo3929f, i29, iM3950m, (LayoutParams) viewMo3929f.getLayoutParams())) {
                            viewMo3929f.measure(i29, iM3950m);
                        }
                        float leftDecorationWidth2 = rightDecorationWidth + getLeftDecorationWidth(viewMo3929f) + ((ViewGroup.MarginLayoutParams) r4).leftMargin;
                        float rightDecorationWidth2 = leftDecorationWidth - (getRightDecorationWidth(viewMo3929f) + ((ViewGroup.MarginLayoutParams) r4).rightMargin);
                        int topDecorationHeight = getTopDecorationHeight(viewMo3929f) + i22;
                        if (this.f20331o) {
                            i13 = i25;
                            i14 = i27;
                            this.f20334r.m3958u(viewMo3929f, flexLine, Math.round(rightDecorationWidth2) - viewMo3929f.getMeasuredWidth(), topDecorationHeight, Math.round(rightDecorationWidth2), viewMo3929f.getMeasuredHeight() + topDecorationHeight);
                        } else {
                            i13 = i25;
                            i14 = i27;
                            this.f20334r.m3958u(viewMo3929f, flexLine, Math.round(leftDecorationWidth2), topDecorationHeight, viewMo3929f.getMeasuredWidth() + Math.round(leftDecorationWidth2), viewMo3929f.getMeasuredHeight() + topDecorationHeight);
                        }
                        leftDecorationWidth = rightDecorationWidth2 - ((getLeftDecorationWidth(viewMo3929f) + (viewMo3929f.getMeasuredWidth() + ((ViewGroup.MarginLayoutParams) r4).leftMargin)) + fMax);
                        rightDecorationWidth = getRightDecorationWidth(viewMo3929f) + viewMo3929f.getMeasuredWidth() + ((ViewGroup.MarginLayoutParams) r4).rightMargin + fMax + leftDecorationWidth2;
                        i26 = i28;
                    }
                    i25 = i13 + 1;
                    i23 = i11;
                    i18 = i12;
                    i24 = i14;
                }
                i = i18;
                c10784c.f20364c += this.f20337u.f20370i;
                i5 = flexLine.f9169g;
                i3 = i19;
                i4 = i20;
            } else {
                i = i18;
                int paddingTop = getPaddingTop();
                int paddingBottom = getPaddingBottom();
                int height = getHeight();
                int i30 = c10784c.f20366e;
                if (c10784c.f20370i == -1) {
                    int i31 = flexLine.f9169g;
                    int i32 = i30 - i31;
                    i2 = i30 + i31;
                    i30 = i32;
                } else {
                    i2 = i30;
                }
                int i33 = c10784c.f20365d;
                float f3 = height - paddingBottom;
                float f4 = this.f20338v.f20357d;
                float bottomDecorationHeight = paddingTop - f4;
                float topDecorationHeight2 = f3 - f4;
                float fMax2 = Math.max(0.0f, 0.0f);
                int i34 = flexLine.f9170h;
                int i35 = i33;
                int i36 = 0;
                while (i35 < i33 + i34) {
                    View viewMo3929f2 = mo3929f(i35);
                    if (viewMo3929f2 == null) {
                        i6 = i19;
                        i7 = i20;
                        i8 = i35;
                        i9 = i34;
                        i10 = i33;
                    } else {
                        int i37 = i34;
                        FlexboxHelper flexboxHelper2 = this.f20334r;
                        int i38 = i33;
                        i6 = i19;
                        i7 = i20;
                        long j2 = flexboxHelper2.f9184d[i35];
                        int i39 = (int) j2;
                        int iM3950m2 = flexboxHelper2.m3950m(j2);
                        if (shouldMeasureChild(viewMo3929f2, i39, iM3950m2, (LayoutParams) viewMo3929f2.getLayoutParams())) {
                            viewMo3929f2.measure(i39, iM3950m2);
                        }
                        float topDecorationHeight3 = bottomDecorationHeight + getTopDecorationHeight(viewMo3929f2) + ((ViewGroup.MarginLayoutParams) r8).topMargin;
                        float bottomDecorationHeight2 = topDecorationHeight2 - (getBottomDecorationHeight(viewMo3929f2) + ((ViewGroup.MarginLayoutParams) r8).rightMargin);
                        if (c10784c.f20370i == 1) {
                            calculateItemDecorationsForChild(viewMo3929f2, f20318j);
                            addView(viewMo3929f2);
                        } else {
                            calculateItemDecorationsForChild(viewMo3929f2, f20318j);
                            addView(viewMo3929f2, i36);
                            i36++;
                        }
                        int i40 = i36;
                        int leftDecorationWidth3 = getLeftDecorationWidth(viewMo3929f2) + i30;
                        int rightDecorationWidth3 = i2 - getRightDecorationWidth(viewMo3929f2);
                        boolean z2 = this.f20331o;
                        if (!z2) {
                            i8 = i35;
                            i9 = i37;
                            i10 = i38;
                            if (this.f20332p) {
                                this.f20334r.m3959v(viewMo3929f2, flexLine, z2, leftDecorationWidth3, Math.round(bottomDecorationHeight2) - viewMo3929f2.getMeasuredHeight(), viewMo3929f2.getMeasuredWidth() + leftDecorationWidth3, Math.round(bottomDecorationHeight2));
                            } else {
                                this.f20334r.m3959v(viewMo3929f2, flexLine, z2, leftDecorationWidth3, Math.round(topDecorationHeight3), viewMo3929f2.getMeasuredWidth() + leftDecorationWidth3, viewMo3929f2.getMeasuredHeight() + Math.round(topDecorationHeight3));
                            }
                        } else if (this.f20332p) {
                            i8 = i35;
                            i9 = i37;
                            i10 = i38;
                            this.f20334r.m3959v(viewMo3929f2, flexLine, z2, rightDecorationWidth3 - viewMo3929f2.getMeasuredWidth(), Math.round(bottomDecorationHeight2) - viewMo3929f2.getMeasuredHeight(), rightDecorationWidth3, Math.round(bottomDecorationHeight2));
                        } else {
                            i8 = i35;
                            i9 = i37;
                            i10 = i38;
                            this.f20334r.m3959v(viewMo3929f2, flexLine, z2, rightDecorationWidth3 - viewMo3929f2.getMeasuredWidth(), Math.round(topDecorationHeight3), rightDecorationWidth3, viewMo3929f2.getMeasuredHeight() + Math.round(topDecorationHeight3));
                        }
                        topDecorationHeight2 = bottomDecorationHeight2 - ((getTopDecorationHeight(viewMo3929f2) + (viewMo3929f2.getMeasuredHeight() + ((ViewGroup.MarginLayoutParams) r8).bottomMargin)) + fMax2);
                        bottomDecorationHeight = getBottomDecorationHeight(viewMo3929f2) + viewMo3929f2.getMeasuredHeight() + ((ViewGroup.MarginLayoutParams) r8).topMargin + fMax2 + topDecorationHeight3;
                        i36 = i40;
                    }
                    i35 = i8 + 1;
                    i19 = i6;
                    i20 = i7;
                    i34 = i9;
                    i33 = i10;
                }
                i3 = i19;
                i4 = i20;
                c10784c.f20364c += this.f20337u.f20370i;
                i5 = flexLine.f9169g;
            }
            i20 = i4 + i5;
            if (zMo3932i || !this.f20331o) {
                c10784c.f20366e = (flexLine.f9169g * c10784c.f20370i) + c10784c.f20366e;
            } else {
                c10784c.f20366e -= flexLine.f9169g * c10784c.f20370i;
            }
            i19 = i3 - flexLine.f9169g;
            i18 = i;
        }
        int i41 = i18;
        int i42 = i20;
        int i43 = c10784c.f20362a - i42;
        c10784c.f20362a = i43;
        int i44 = c10784c.f20367f;
        if (i44 != Integer.MIN_VALUE) {
            int i45 = i44 + i42;
            c10784c.f20367f = i45;
            if (i43 < 0) {
                c10784c.f20367f = i45 + i43;
            }
            m8993v(recycler, c10784c);
        }
        return i41 - c10784c.f20362a;
    }

    /* renamed from: n */
    public final View m8985n(int i) {
        View viewM8990s = m8990s(0, getChildCount(), i);
        if (viewM8990s == null) {
            return null;
        }
        int i2 = this.f20334r.f9183c[getPosition(viewM8990s)];
        if (i2 == -1) {
            return null;
        }
        return m8986o(viewM8990s, this.f20333q.get(i2));
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x003b  */
    /* renamed from: o */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final View m8986o(View view, FlexLine flexLine) {
        boolean zMo3932i = mo3932i();
        int i = flexLine.f9170h;
        for (int i2 = 1; i2 < i; i2++) {
            View childAt = getChildAt(i2);
            if (childAt != null && childAt.getVisibility() != 8) {
                if (!this.f20331o || zMo3932i) {
                    if (this.f20339w.getDecoratedStart(view) > this.f20339w.getDecoratedStart(childAt)) {
                        view = childAt;
                    }
                } else if (this.f20339w.getDecoratedEnd(view) < this.f20339w.getDecoratedEnd(childAt)) {
                }
            }
        }
        return view;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onAdapterChanged(RecyclerView.Adapter adapter, RecyclerView.Adapter adapter2) {
        removeAllViews();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onAttachedToWindow(RecyclerView recyclerView) {
        super.onAttachedToWindow(recyclerView);
        this.f20324F = (View) recyclerView.getParent();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onDetachedFromWindow(RecyclerView recyclerView, RecyclerView.Recycler recycler) {
        super.onDetachedFromWindow(recyclerView, recycler);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onItemsAdded(@NonNull RecyclerView recyclerView, int i, int i2) {
        super.onItemsAdded(recyclerView, i, i2);
        m8996y(i);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onItemsMoved(@NonNull RecyclerView recyclerView, int i, int i2, int i3) {
        super.onItemsMoved(recyclerView, i, i2, i3);
        m8996y(Math.min(i, i2));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onItemsRemoved(@NonNull RecyclerView recyclerView, int i, int i2) {
        super.onItemsRemoved(recyclerView, i, i2);
        m8996y(i);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onItemsUpdated(@NonNull RecyclerView recyclerView, int i, int i2, Object obj) {
        super.onItemsUpdated(recyclerView, i, i2, obj);
        m8996y(i);
    }

    /* JADX WARN: Removed duplicated region for block: B:116:0x01b6  */
    /* JADX WARN: Removed duplicated region for block: B:169:0x0290  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x0100  */
    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onLayoutChildren(RecyclerView.Recycler recycler, RecyclerView.State state) {
        boolean z2;
        boolean z3;
        int i;
        boolean z4;
        int i2;
        int i3;
        int i4;
        this.f20335s = recycler;
        this.f20336t = state;
        int itemCount = state.getItemCount();
        if (itemCount == 0 && state.isPreLayout()) {
            return;
        }
        int layoutDirection = getLayoutDirection();
        int i5 = this.f20327k;
        if (i5 == 0) {
            this.f20331o = layoutDirection == 1;
            this.f20332p = this.f20328l == 2;
        } else if (i5 == 1) {
            this.f20331o = layoutDirection != 1;
            this.f20332p = this.f20328l == 2;
        } else if (i5 == 2) {
            boolean z5 = layoutDirection == 1;
            this.f20331o = z5;
            if (this.f20328l == 2) {
                this.f20331o = !z5;
            }
            this.f20332p = false;
        } else if (i5 != 3) {
            this.f20331o = false;
            this.f20332p = false;
        } else {
            boolean z6 = layoutDirection == 1;
            this.f20331o = z6;
            if (this.f20328l == 2) {
                this.f20331o = !z6;
            }
            this.f20332p = true;
        }
        m8983l();
        if (this.f20337u == null) {
            this.f20337u = new C10784c(null);
        }
        this.f20334r.m3947j(itemCount);
        this.f20334r.m3948k(itemCount);
        this.f20334r.m3946i(itemCount);
        this.f20337u.f20371j = false;
        SavedState savedState = this.f20341y;
        if (savedState != null) {
            int i6 = savedState.f20352j;
            if (i6 >= 0 && i6 < itemCount) {
                this.f20342z = i6;
            }
        }
        C10783b c10783b = this.f20338v;
        if (!c10783b.f20359f || this.f20342z != -1 || savedState != null) {
            C10783b.m8999b(c10783b);
            C10783b c10783b2 = this.f20338v;
            SavedState savedState2 = this.f20341y;
            if (state.isPreLayout() || (i = this.f20342z) == -1) {
                z2 = false;
                if (!z2) {
                    if (getChildCount() != 0) {
                        View viewM8987p = c10783b2.f20358e ? m8987p(state.getItemCount()) : m8985n(state.getItemCount());
                        if (viewM8987p != null) {
                            FlexboxLayoutManager flexboxLayoutManager = FlexboxLayoutManager.this;
                            OrientationHelper orientationHelper = flexboxLayoutManager.f20328l == 0 ? flexboxLayoutManager.f20340x : flexboxLayoutManager.f20339w;
                            if (flexboxLayoutManager.mo3932i() || !FlexboxLayoutManager.this.f20331o) {
                                if (c10783b2.f20358e) {
                                    c10783b2.f20356c = orientationHelper.getTotalSpaceChange() + orientationHelper.getDecoratedEnd(viewM8987p);
                                } else {
                                    c10783b2.f20356c = orientationHelper.getDecoratedStart(viewM8987p);
                                }
                            } else if (c10783b2.f20358e) {
                                c10783b2.f20356c = orientationHelper.getTotalSpaceChange() + orientationHelper.getDecoratedStart(viewM8987p);
                            } else {
                                c10783b2.f20356c = orientationHelper.getDecoratedEnd(viewM8987p);
                            }
                            int position = FlexboxLayoutManager.this.getPosition(viewM8987p);
                            c10783b2.f20354a = position;
                            c10783b2.f20360g = false;
                            FlexboxLayoutManager flexboxLayoutManager2 = FlexboxLayoutManager.this;
                            int[] iArr = flexboxLayoutManager2.f20334r.f9183c;
                            if (position == -1) {
                                position = 0;
                            }
                            int i7 = iArr[position];
                            if (i7 == -1) {
                                i7 = 0;
                            }
                            c10783b2.f20355b = i7;
                            int size = flexboxLayoutManager2.f20333q.size();
                            int i8 = c10783b2.f20355b;
                            if (size > i8) {
                                c10783b2.f20354a = FlexboxLayoutManager.this.f20333q.get(i8).f9177o;
                            }
                            if (!state.isPreLayout() && supportsPredictiveItemAnimations()) {
                                if (this.f20339w.getDecoratedStart(viewM8987p) >= this.f20339w.getEndAfterPadding() || this.f20339w.getDecoratedEnd(viewM8987p) < this.f20339w.getStartAfterPadding()) {
                                    c10783b2.f20356c = c10783b2.f20358e ? this.f20339w.getEndAfterPadding() : this.f20339w.getStartAfterPadding();
                                }
                            }
                            z3 = true;
                        } else {
                            z3 = false;
                        }
                        if (!z3) {
                            C10783b.m8998a(c10783b2);
                            c10783b2.f20354a = 0;
                            c10783b2.f20355b = 0;
                        }
                    }
                }
                this.f20338v.f20359f = true;
            } else if (i < 0 || i >= state.getItemCount()) {
                this.f20342z = -1;
                this.f20319A = Integer.MIN_VALUE;
                z2 = false;
                if (!z2) {
                }
                this.f20338v.f20359f = true;
            } else {
                int i9 = this.f20342z;
                c10783b2.f20354a = i9;
                c10783b2.f20355b = this.f20334r.f9183c[i9];
                SavedState savedState3 = this.f20341y;
                if (savedState3 != null) {
                    int itemCount2 = state.getItemCount();
                    int i10 = savedState3.f20352j;
                    if (i10 >= 0 && i10 < itemCount2) {
                        c10783b2.f20356c = this.f20339w.getStartAfterPadding() + savedState2.f20353k;
                        c10783b2.f20360g = true;
                        c10783b2.f20355b = -1;
                    } else if (this.f20319A == Integer.MIN_VALUE) {
                        View viewFindViewByPosition = findViewByPosition(this.f20342z);
                        if (viewFindViewByPosition == null) {
                            if (getChildCount() > 0) {
                                c10783b2.f20358e = this.f20342z < getPosition(getChildAt(0));
                            }
                            C10783b.m8998a(c10783b2);
                        } else if (this.f20339w.getDecoratedMeasurement(viewFindViewByPosition) > this.f20339w.getTotalSpace()) {
                            C10783b.m8998a(c10783b2);
                        } else if (this.f20339w.getDecoratedStart(viewFindViewByPosition) - this.f20339w.getStartAfterPadding() < 0) {
                            c10783b2.f20356c = this.f20339w.getStartAfterPadding();
                            c10783b2.f20358e = false;
                        } else if (this.f20339w.getEndAfterPadding() - this.f20339w.getDecoratedEnd(viewFindViewByPosition) < 0) {
                            c10783b2.f20356c = this.f20339w.getEndAfterPadding();
                            c10783b2.f20358e = true;
                        } else {
                            c10783b2.f20356c = c10783b2.f20358e ? this.f20339w.getTotalSpaceChange() + this.f20339w.getDecoratedEnd(viewFindViewByPosition) : this.f20339w.getDecoratedStart(viewFindViewByPosition);
                        }
                    } else if (mo3932i() || !this.f20331o) {
                        c10783b2.f20356c = this.f20339w.getStartAfterPadding() + this.f20319A;
                    } else {
                        c10783b2.f20356c = this.f20319A - this.f20339w.getEndPadding();
                    }
                    z2 = true;
                    if (!z2) {
                    }
                    this.f20338v.f20359f = true;
                }
            }
        }
        detachAndScrapAttachedViews(recycler);
        C10783b c10783b3 = this.f20338v;
        if (c10783b3.f20358e) {
            m8981A(c10783b3, false, true);
        } else {
            m8997z(c10783b3, false, true);
        }
        int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(getWidth(), getWidthMode());
        int iMakeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(getHeight(), getHeightMode());
        int width = getWidth();
        int height = getHeight();
        if (mo3932i()) {
            int i11 = this.f20320B;
            z4 = (i11 == Integer.MIN_VALUE || i11 == width) ? false : true;
            C10784c c10784c = this.f20337u;
            i2 = c10784c.f20363b ? this.f20323E.getResources().getDisplayMetrics().heightPixels : c10784c.f20362a;
        } else {
            int i12 = this.f20321C;
            z4 = (i12 == Integer.MIN_VALUE || i12 == height) ? false : true;
            C10784c c10784c2 = this.f20337u;
            i2 = c10784c2.f20363b ? this.f20323E.getResources().getDisplayMetrics().widthPixels : c10784c2.f20362a;
        }
        int i13 = i2;
        this.f20320B = width;
        this.f20321C = height;
        int i14 = this.f20325G;
        if (i14 != -1 || (this.f20342z == -1 && !z4)) {
            int iMin = i14 != -1 ? Math.min(i14, this.f20338v.f20354a) : this.f20338v.f20354a;
            this.f20326H.m3964a();
            if (mo3932i()) {
                if (this.f20333q.size() > 0) {
                    this.f20334r.m3941d(this.f20333q, iMin);
                    this.f20334r.m3939b(this.f20326H, iMakeMeasureSpec, iMakeMeasureSpec2, i13, iMin, this.f20338v.f20354a, this.f20333q);
                } else {
                    this.f20334r.m3946i(itemCount);
                    this.f20334r.m3939b(this.f20326H, iMakeMeasureSpec, iMakeMeasureSpec2, i13, 0, -1, this.f20333q);
                }
            } else if (this.f20333q.size() > 0) {
                this.f20334r.m3941d(this.f20333q, iMin);
                this.f20334r.m3939b(this.f20326H, iMakeMeasureSpec2, iMakeMeasureSpec, i13, iMin, this.f20338v.f20354a, this.f20333q);
            } else {
                this.f20334r.m3946i(itemCount);
                this.f20334r.m3939b(this.f20326H, iMakeMeasureSpec2, iMakeMeasureSpec, i13, 0, -1, this.f20333q);
            }
            this.f20333q = this.f20326H.f9186a;
            this.f20334r.m3945h(iMakeMeasureSpec, iMakeMeasureSpec2, iMin);
            this.f20334r.m3936A(iMin);
        } else if (!this.f20338v.f20358e) {
            this.f20333q.clear();
            this.f20326H.m3964a();
            if (mo3932i()) {
                this.f20334r.m3939b(this.f20326H, iMakeMeasureSpec, iMakeMeasureSpec2, i13, 0, this.f20338v.f20354a, this.f20333q);
            } else {
                this.f20334r.m3939b(this.f20326H, iMakeMeasureSpec2, iMakeMeasureSpec, i13, 0, this.f20338v.f20354a, this.f20333q);
            }
            this.f20333q = this.f20326H.f9186a;
            this.f20334r.m3945h(iMakeMeasureSpec, iMakeMeasureSpec2, 0);
            this.f20334r.m3936A(0);
            C10783b c10783b4 = this.f20338v;
            int i15 = this.f20334r.f9183c[c10783b4.f20354a];
            c10783b4.f20355b = i15;
            this.f20337u.f20364c = i15;
        }
        if (this.f20338v.f20358e) {
            m8984m(recycler, state, this.f20337u);
            i4 = this.f20337u.f20366e;
            m8997z(this.f20338v, true, false);
            m8984m(recycler, state, this.f20337u);
            i3 = this.f20337u.f20366e;
        } else {
            m8984m(recycler, state, this.f20337u);
            i3 = this.f20337u.f20366e;
            m8981A(this.f20338v, true, false);
            m8984m(recycler, state, this.f20337u);
            i4 = this.f20337u.f20366e;
        }
        if (getChildCount() > 0) {
            if (this.f20338v.f20358e) {
                fixLayoutStartGap(fixLayoutEndGap(i3, recycler, state, true) + i4, recycler, state, false);
            } else {
                fixLayoutEndGap(fixLayoutStartGap(i4, recycler, state, true) + i3, recycler, state, false);
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onLayoutCompleted(RecyclerView.State state) {
        super.onLayoutCompleted(state);
        this.f20341y = null;
        this.f20342z = -1;
        this.f20319A = Integer.MIN_VALUE;
        this.f20325G = -1;
        C10783b.m8999b(this.f20338v);
        this.f20322D.clear();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof SavedState) {
            this.f20341y = (SavedState) parcelable;
            requestLayout();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public Parcelable onSaveInstanceState() {
        SavedState savedState = this.f20341y;
        if (savedState != null) {
            return new SavedState(savedState, (C10782a) null);
        }
        SavedState savedState2 = new SavedState();
        if (getChildCount() > 0) {
            View childAt = getChildAt(0);
            savedState2.f20352j = getPosition(childAt);
            savedState2.f20353k = this.f20339w.getDecoratedStart(childAt) - this.f20339w.getStartAfterPadding();
        } else {
            savedState2.f20352j = -1;
        }
        return savedState2;
    }

    /* renamed from: p */
    public final View m8987p(int i) {
        View viewM8990s = m8990s(getChildCount() - 1, -1, i);
        if (viewM8990s == null) {
            return null;
        }
        return m8988q(viewM8990s, this.f20333q.get(this.f20334r.f9183c[getPosition(viewM8990s)]));
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0047  */
    /* renamed from: q */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final View m8988q(View view, FlexLine flexLine) {
        boolean zMo3932i = mo3932i();
        int childCount = (getChildCount() - flexLine.f9170h) - 1;
        for (int childCount2 = getChildCount() - 2; childCount2 > childCount; childCount2--) {
            View childAt = getChildAt(childCount2);
            if (childAt != null && childAt.getVisibility() != 8) {
                if (!this.f20331o || zMo3932i) {
                    if (this.f20339w.getDecoratedEnd(view) < this.f20339w.getDecoratedEnd(childAt)) {
                        view = childAt;
                    }
                } else if (this.f20339w.getDecoratedStart(view) > this.f20339w.getDecoratedStart(childAt)) {
                }
            }
        }
        return view;
    }

    /* renamed from: r */
    public final View m8989r(int i, int i2, boolean z2) {
        int i3 = i;
        int i4 = i2 > i3 ? 1 : -1;
        while (i3 != i2) {
            View childAt = getChildAt(i3);
            int paddingLeft = getPaddingLeft();
            int paddingTop = getPaddingTop();
            int width = getWidth() - getPaddingRight();
            int height = getHeight() - getPaddingBottom();
            int decoratedLeft = getDecoratedLeft(childAt) - ((ViewGroup.MarginLayoutParams) ((RecyclerView.LayoutParams) childAt.getLayoutParams())).leftMargin;
            int decoratedTop = getDecoratedTop(childAt) - ((ViewGroup.MarginLayoutParams) ((RecyclerView.LayoutParams) childAt.getLayoutParams())).topMargin;
            int decoratedRight = getDecoratedRight(childAt) + ((ViewGroup.MarginLayoutParams) ((RecyclerView.LayoutParams) childAt.getLayoutParams())).rightMargin;
            int decoratedBottom = getDecoratedBottom(childAt) + ((ViewGroup.MarginLayoutParams) ((RecyclerView.LayoutParams) childAt.getLayoutParams())).bottomMargin;
            boolean z3 = false;
            boolean z4 = paddingLeft <= decoratedLeft && width >= decoratedRight;
            boolean z5 = decoratedLeft >= width || decoratedRight >= paddingLeft;
            boolean z6 = paddingTop <= decoratedTop && height >= decoratedBottom;
            boolean z7 = decoratedTop >= height || decoratedBottom >= paddingTop;
            if (!z2 ? !(!z5 || !z7) : !(!z4 || !z6)) {
                z3 = true;
            }
            if (z3) {
                return childAt;
            }
            i3 += i4;
        }
        return null;
    }

    /* renamed from: s */
    public final View m8990s(int i, int i2, int i3) {
        m8983l();
        View view = null;
        if (this.f20337u == null) {
            this.f20337u = new C10784c(null);
        }
        int startAfterPadding = this.f20339w.getStartAfterPadding();
        int endAfterPadding = this.f20339w.getEndAfterPadding();
        int i4 = i2 > i ? 1 : -1;
        View view2 = null;
        while (i != i2) {
            View childAt = getChildAt(i);
            int position = getPosition(childAt);
            if (position >= 0 && position < i3) {
                if (((RecyclerView.LayoutParams) childAt.getLayoutParams()).isItemRemoved()) {
                    if (view2 == null) {
                        view2 = childAt;
                    }
                } else {
                    if (this.f20339w.getDecoratedStart(childAt) >= startAfterPadding && this.f20339w.getDecoratedEnd(childAt) <= endAfterPadding) {
                        return childAt;
                    }
                    if (view == null) {
                        view = childAt;
                    }
                }
            }
            i += i4;
        }
        return view != null ? view : view2;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int scrollHorizontallyBy(int i, RecyclerView.Recycler recycler, RecyclerView.State state) {
        if (!mo3932i() || (this.f20328l == 0 && mo3932i())) {
            int iM8991t = m8991t(i, recycler, state);
            this.f20322D.clear();
            return iM8991t;
        }
        int iM8992u = m8992u(i);
        this.f20338v.f20357d += iM8992u;
        this.f20340x.offsetChildren(-iM8992u);
        return iM8992u;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void scrollToPosition(int i) {
        this.f20342z = i;
        this.f20319A = Integer.MIN_VALUE;
        SavedState savedState = this.f20341y;
        if (savedState != null) {
            savedState.f20352j = -1;
        }
        requestLayout();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int scrollVerticallyBy(int i, RecyclerView.Recycler recycler, RecyclerView.State state) {
        if (mo3932i() || (this.f20328l == 0 && !mo3932i())) {
            int iM8991t = m8991t(i, recycler, state);
            this.f20322D.clear();
            return iM8991t;
        }
        int iM8992u = m8992u(i);
        this.f20338v.f20357d += iM8992u;
        this.f20340x.offsetChildren(-iM8992u);
        return iM8992u;
    }

    @Override // p007b.p225i.p226a.p287e.FlexContainer
    public void setFlexLines(List<FlexLine> list) {
        this.f20333q = list;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void smoothScrollToPosition(RecyclerView recyclerView, RecyclerView.State state, int i) {
        LinearSmoothScroller linearSmoothScroller = new LinearSmoothScroller(recyclerView.getContext());
        linearSmoothScroller.setTargetPosition(i);
        startSmoothScroll(linearSmoothScroller);
    }

    /* JADX WARN: Removed duplicated region for block: B:75:0x01ee  */
    /* renamed from: t */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final int m8991t(int i, RecyclerView.Recycler recycler, RecyclerView.State state) {
        int i2;
        if (getChildCount() == 0 || i == 0) {
            return 0;
        }
        m8983l();
        this.f20337u.f20371j = true;
        boolean z2 = !mo3932i() && this.f20331o;
        int i3 = (!z2 ? i > 0 : i < 0) ? -1 : 1;
        int iAbs = Math.abs(i);
        this.f20337u.f20370i = i3;
        boolean zMo3932i = mo3932i();
        int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(getWidth(), getWidthMode());
        int iMakeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(getHeight(), getHeightMode());
        boolean z3 = !zMo3932i && this.f20331o;
        if (i3 == 1) {
            View childAt = getChildAt(getChildCount() - 1);
            this.f20337u.f20366e = this.f20339w.getDecoratedEnd(childAt);
            int position = getPosition(childAt);
            View viewM8988q = m8988q(childAt, this.f20333q.get(this.f20334r.f9183c[position]));
            C10784c c10784c = this.f20337u;
            c10784c.f20369h = 1;
            int i4 = position + 1;
            c10784c.f20365d = i4;
            int[] iArr = this.f20334r.f9183c;
            if (iArr.length <= i4) {
                c10784c.f20364c = -1;
            } else {
                c10784c.f20364c = iArr[i4];
            }
            if (z3) {
                c10784c.f20366e = this.f20339w.getDecoratedStart(viewM8988q);
                this.f20337u.f20367f = this.f20339w.getStartAfterPadding() + (-this.f20339w.getDecoratedStart(viewM8988q));
                C10784c c10784c2 = this.f20337u;
                int i5 = c10784c2.f20367f;
                if (i5 < 0) {
                    i5 = 0;
                }
                c10784c2.f20367f = i5;
            } else {
                c10784c.f20366e = this.f20339w.getDecoratedEnd(viewM8988q);
                this.f20337u.f20367f = this.f20339w.getDecoratedEnd(viewM8988q) - this.f20339w.getEndAfterPadding();
            }
            int i6 = this.f20337u.f20364c;
            if ((i6 == -1 || i6 > this.f20333q.size() - 1) && this.f20337u.f20365d <= getFlexItemCount()) {
                int i7 = iAbs - this.f20337u.f20367f;
                this.f20326H.m3964a();
                if (i7 > 0) {
                    if (zMo3932i) {
                        this.f20334r.m3939b(this.f20326H, iMakeMeasureSpec, iMakeMeasureSpec2, i7, this.f20337u.f20365d, -1, this.f20333q);
                    } else {
                        this.f20334r.m3939b(this.f20326H, iMakeMeasureSpec2, iMakeMeasureSpec, i7, this.f20337u.f20365d, -1, this.f20333q);
                    }
                    this.f20334r.m3945h(iMakeMeasureSpec, iMakeMeasureSpec2, this.f20337u.f20365d);
                    this.f20334r.m3936A(this.f20337u.f20365d);
                }
            }
        } else {
            View childAt2 = getChildAt(0);
            this.f20337u.f20366e = this.f20339w.getDecoratedStart(childAt2);
            int position2 = getPosition(childAt2);
            View viewM8986o = m8986o(childAt2, this.f20333q.get(this.f20334r.f9183c[position2]));
            C10784c c10784c3 = this.f20337u;
            c10784c3.f20369h = 1;
            int i8 = this.f20334r.f9183c[position2];
            if (i8 == -1) {
                i8 = 0;
            }
            if (i8 > 0) {
                this.f20337u.f20365d = position2 - this.f20333q.get(i8 - 1).f9170h;
            } else {
                c10784c3.f20365d = -1;
            }
            C10784c c10784c4 = this.f20337u;
            c10784c4.f20364c = i8 > 0 ? i8 - 1 : 0;
            if (z3) {
                c10784c4.f20366e = this.f20339w.getDecoratedEnd(viewM8986o);
                this.f20337u.f20367f = this.f20339w.getDecoratedEnd(viewM8986o) - this.f20339w.getEndAfterPadding();
                C10784c c10784c5 = this.f20337u;
                int i9 = c10784c5.f20367f;
                if (i9 < 0) {
                    i9 = 0;
                }
                c10784c5.f20367f = i9;
            } else {
                c10784c4.f20366e = this.f20339w.getDecoratedStart(viewM8986o);
                this.f20337u.f20367f = this.f20339w.getStartAfterPadding() + (-this.f20339w.getDecoratedStart(viewM8986o));
            }
        }
        C10784c c10784c6 = this.f20337u;
        int i10 = c10784c6.f20367f;
        c10784c6.f20362a = iAbs - i10;
        int iM8984m = m8984m(recycler, state, c10784c6) + i10;
        if (iM8984m < 0) {
            return 0;
        }
        if (z2) {
            i2 = iAbs > iM8984m ? (-i3) * iM8984m : i;
        } else if (iAbs > iM8984m) {
            i2 = i3 * iM8984m;
        }
        this.f20339w.offsetChildren(-i2);
        this.f20337u.f20368g = i2;
        return i2;
    }

    /* renamed from: u */
    public final int m8992u(int i) {
        int i2;
        if (getChildCount() == 0 || i == 0) {
            return 0;
        }
        m8983l();
        boolean zMo3932i = mo3932i();
        View view = this.f20324F;
        int width = zMo3932i ? view.getWidth() : view.getHeight();
        int width2 = zMo3932i ? getWidth() : getHeight();
        if (getLayoutDirection() == 1) {
            int iAbs = Math.abs(i);
            if (i < 0) {
                return -Math.min((width2 + this.f20338v.f20357d) - width, iAbs);
            }
            i2 = this.f20338v.f20357d;
            if (i2 + i <= 0) {
                return i;
            }
        } else {
            if (i > 0) {
                return Math.min((width2 - this.f20338v.f20357d) - width, i);
            }
            i2 = this.f20338v.f20357d;
            if (i2 + i >= 0) {
                return i;
            }
        }
        return -i2;
    }

    /* renamed from: v */
    public final void m8993v(RecyclerView.Recycler recycler, C10784c c10784c) {
        int childCount;
        if (c10784c.f20371j) {
            int i = -1;
            if (c10784c.f20370i != -1) {
                if (c10784c.f20367f >= 0 && (childCount = getChildCount()) != 0) {
                    int i2 = this.f20334r.f9183c[getPosition(getChildAt(0))];
                    if (i2 == -1) {
                        return;
                    }
                    FlexLine flexLine = this.f20333q.get(i2);
                    int i3 = 0;
                    while (true) {
                        if (i3 >= childCount) {
                            break;
                        }
                        View childAt = getChildAt(i3);
                        int i4 = c10784c.f20367f;
                        if (!(mo3932i() || !this.f20331o ? this.f20339w.getDecoratedEnd(childAt) <= i4 : this.f20339w.getEnd() - this.f20339w.getDecoratedStart(childAt) <= i4)) {
                            break;
                        }
                        if (flexLine.f9178p == getPosition(childAt)) {
                            if (i2 >= this.f20333q.size() - 1) {
                                i = i3;
                                break;
                            } else {
                                i2 += c10784c.f20370i;
                                flexLine = this.f20333q.get(i2);
                                i = i3;
                            }
                        }
                        i3++;
                    }
                    while (i >= 0) {
                        removeAndRecycleViewAt(i, recycler);
                        i--;
                    }
                    return;
                }
                return;
            }
            if (c10784c.f20367f < 0) {
                return;
            }
            this.f20339w.getEnd();
            int childCount2 = getChildCount();
            if (childCount2 == 0) {
                return;
            }
            int i5 = childCount2 - 1;
            int i6 = this.f20334r.f9183c[getPosition(getChildAt(i5))];
            if (i6 == -1) {
                return;
            }
            FlexLine flexLine2 = this.f20333q.get(i6);
            int i7 = i5;
            while (true) {
                if (i7 < 0) {
                    break;
                }
                View childAt2 = getChildAt(i7);
                int i8 = c10784c.f20367f;
                if (!(mo3932i() || !this.f20331o ? this.f20339w.getDecoratedStart(childAt2) >= this.f20339w.getEnd() - i8 : this.f20339w.getDecoratedEnd(childAt2) <= i8)) {
                    break;
                }
                if (flexLine2.f9177o == getPosition(childAt2)) {
                    if (i6 <= 0) {
                        childCount2 = i7;
                        break;
                    } else {
                        i6 += c10784c.f20370i;
                        flexLine2 = this.f20333q.get(i6);
                        childCount2 = i7;
                    }
                }
                i7--;
            }
            while (i5 >= childCount2) {
                removeAndRecycleViewAt(i5, recycler);
                i5--;
            }
        }
    }

    /* renamed from: w */
    public final void m8994w() {
        int heightMode = mo3932i() ? getHeightMode() : getWidthMode();
        this.f20337u.f20363b = heightMode == 0 || heightMode == Integer.MIN_VALUE;
    }

    /* renamed from: x */
    public void m8995x(int i) {
        if (this.f20327k != i) {
            removeAllViews();
            this.f20327k = i;
            this.f20339w = null;
            this.f20340x = null;
            m8982k();
            requestLayout();
        }
    }

    /* renamed from: y */
    public final void m8996y(int i) {
        if (i >= findLastVisibleItemPosition()) {
            return;
        }
        int childCount = getChildCount();
        this.f20334r.m3947j(childCount);
        this.f20334r.m3948k(childCount);
        this.f20334r.m3946i(childCount);
        if (i >= this.f20334r.f9183c.length) {
            return;
        }
        this.f20325G = i;
        View childAt = getChildAt(0);
        if (childAt == null) {
            return;
        }
        this.f20342z = getPosition(childAt);
        if (mo3932i() || !this.f20331o) {
            this.f20319A = this.f20339w.getDecoratedStart(childAt) - this.f20339w.getStartAfterPadding();
        } else {
            this.f20319A = this.f20339w.getEndPadding() + this.f20339w.getDecoratedEnd(childAt);
        }
    }

    /* renamed from: z */
    public final void m8997z(C10783b c10783b, boolean z2, boolean z3) {
        int i;
        if (z3) {
            m8994w();
        } else {
            this.f20337u.f20363b = false;
        }
        if (mo3932i() || !this.f20331o) {
            this.f20337u.f20362a = this.f20339w.getEndAfterPadding() - c10783b.f20356c;
        } else {
            this.f20337u.f20362a = c10783b.f20356c - getPaddingRight();
        }
        C10784c c10784c = this.f20337u;
        c10784c.f20365d = c10783b.f20354a;
        c10784c.f20369h = 1;
        c10784c.f20370i = 1;
        c10784c.f20366e = c10783b.f20356c;
        c10784c.f20367f = Integer.MIN_VALUE;
        c10784c.f20364c = c10783b.f20355b;
        if (!z2 || this.f20333q.size() <= 1 || (i = c10783b.f20355b) < 0 || i >= this.f20333q.size() - 1) {
            return;
        }
        FlexLine flexLine = this.f20333q.get(c10783b.f20355b);
        C10784c c10784c2 = this.f20337u;
        c10784c2.f20364c++;
        c10784c2.f20365d += flexLine.f9170h;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onItemsUpdated(@NonNull RecyclerView recyclerView, int i, int i2) {
        super.onItemsUpdated(recyclerView, i, i2);
        m8996y(i);
    }

    public static class LayoutParams extends RecyclerView.LayoutParams implements FlexItem {
        public static final Parcelable.Creator<LayoutParams> CREATOR = new C10780a();

        /* renamed from: j */
        public float f20343j;

        /* renamed from: k */
        public float f20344k;

        /* renamed from: l */
        public int f20345l;

        /* renamed from: m */
        public float f20346m;

        /* renamed from: n */
        public int f20347n;

        /* renamed from: o */
        public int f20348o;

        /* renamed from: p */
        public int f20349p;

        /* renamed from: q */
        public int f20350q;

        /* renamed from: r */
        public boolean f20351r;

        /* renamed from: com.google.android.flexbox.FlexboxLayoutManager$LayoutParams$a */
        public static class C10780a implements Parcelable.Creator<LayoutParams> {
            @Override // android.os.Parcelable.Creator
            public LayoutParams createFromParcel(Parcel parcel) {
                return new LayoutParams(parcel);
            }

            @Override // android.os.Parcelable.Creator
            public LayoutParams[] newArray(int i) {
                return new LayoutParams[i];
            }
        }

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.f20343j = 0.0f;
            this.f20344k = 1.0f;
            this.f20345l = -1;
            this.f20346m = -1.0f;
            this.f20349p = ViewCompat.MEASURED_SIZE_MASK;
            this.f20350q = ViewCompat.MEASURED_SIZE_MASK;
        }

        @Override // com.google.android.flexbox.FlexItem
        /* renamed from: D */
        public int mo8955D() {
            return this.f20347n;
        }

        @Override // com.google.android.flexbox.FlexItem
        /* renamed from: H */
        public void mo8956H(int i) {
            this.f20347n = i;
        }

        @Override // com.google.android.flexbox.FlexItem
        /* renamed from: I */
        public int mo8957I() {
            return ((ViewGroup.MarginLayoutParams) this).bottomMargin;
        }

        @Override // com.google.android.flexbox.FlexItem
        /* renamed from: J */
        public int mo8958J() {
            return ((ViewGroup.MarginLayoutParams) this).leftMargin;
        }

        @Override // com.google.android.flexbox.FlexItem
        /* renamed from: N */
        public int mo8959N() {
            return ((ViewGroup.MarginLayoutParams) this).topMargin;
        }

        @Override // com.google.android.flexbox.FlexItem
        /* renamed from: O */
        public void mo8960O(int i) {
            this.f20348o = i;
        }

        @Override // com.google.android.flexbox.FlexItem
        /* renamed from: S */
        public float mo8961S() {
            return this.f20343j;
        }

        @Override // com.google.android.flexbox.FlexItem
        /* renamed from: W */
        public float mo8962W() {
            return this.f20346m;
        }

        @Override // com.google.android.flexbox.FlexItem
        /* renamed from: d0 */
        public int mo8963d0() {
            return ((ViewGroup.MarginLayoutParams) this).rightMargin;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // com.google.android.flexbox.FlexItem
        /* renamed from: f0 */
        public int mo8964f0() {
            return this.f20348o;
        }

        @Override // com.google.android.flexbox.FlexItem
        public int getHeight() {
            return ((ViewGroup.MarginLayoutParams) this).height;
        }

        @Override // com.google.android.flexbox.FlexItem
        public int getOrder() {
            return 1;
        }

        @Override // com.google.android.flexbox.FlexItem
        public int getWidth() {
            return ((ViewGroup.MarginLayoutParams) this).width;
        }

        @Override // com.google.android.flexbox.FlexItem
        /* renamed from: j0 */
        public boolean mo8965j0() {
            return this.f20351r;
        }

        @Override // com.google.android.flexbox.FlexItem
        /* renamed from: m0 */
        public int mo8966m0() {
            return this.f20350q;
        }

        @Override // com.google.android.flexbox.FlexItem
        /* renamed from: t0 */
        public int mo8967t0() {
            return this.f20349p;
        }

        @Override // com.google.android.flexbox.FlexItem
        /* renamed from: u */
        public int mo8968u() {
            return this.f20345l;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeFloat(this.f20343j);
            parcel.writeFloat(this.f20344k);
            parcel.writeInt(this.f20345l);
            parcel.writeFloat(this.f20346m);
            parcel.writeInt(this.f20347n);
            parcel.writeInt(this.f20348o);
            parcel.writeInt(this.f20349p);
            parcel.writeInt(this.f20350q);
            parcel.writeByte(this.f20351r ? (byte) 1 : (byte) 0);
            parcel.writeInt(((ViewGroup.MarginLayoutParams) this).bottomMargin);
            parcel.writeInt(((ViewGroup.MarginLayoutParams) this).leftMargin);
            parcel.writeInt(((ViewGroup.MarginLayoutParams) this).rightMargin);
            parcel.writeInt(((ViewGroup.MarginLayoutParams) this).topMargin);
            parcel.writeInt(((ViewGroup.MarginLayoutParams) this).height);
            parcel.writeInt(((ViewGroup.MarginLayoutParams) this).width);
        }

        @Override // com.google.android.flexbox.FlexItem
        /* renamed from: x */
        public float mo8969x() {
            return this.f20344k;
        }

        public LayoutParams(int i, int i2) {
            super(i, i2);
            this.f20343j = 0.0f;
            this.f20344k = 1.0f;
            this.f20345l = -1;
            this.f20346m = -1.0f;
            this.f20349p = ViewCompat.MEASURED_SIZE_MASK;
            this.f20350q = ViewCompat.MEASURED_SIZE_MASK;
        }

        public LayoutParams(Parcel parcel) {
            super(-2, -2);
            this.f20343j = 0.0f;
            this.f20344k = 1.0f;
            this.f20345l = -1;
            this.f20346m = -1.0f;
            this.f20349p = ViewCompat.MEASURED_SIZE_MASK;
            this.f20350q = ViewCompat.MEASURED_SIZE_MASK;
            this.f20343j = parcel.readFloat();
            this.f20344k = parcel.readFloat();
            this.f20345l = parcel.readInt();
            this.f20346m = parcel.readFloat();
            this.f20347n = parcel.readInt();
            this.f20348o = parcel.readInt();
            this.f20349p = parcel.readInt();
            this.f20350q = parcel.readInt();
            this.f20351r = parcel.readByte() != 0;
            ((ViewGroup.MarginLayoutParams) this).bottomMargin = parcel.readInt();
            ((ViewGroup.MarginLayoutParams) this).leftMargin = parcel.readInt();
            ((ViewGroup.MarginLayoutParams) this).rightMargin = parcel.readInt();
            ((ViewGroup.MarginLayoutParams) this).topMargin = parcel.readInt();
            ((ViewGroup.MarginLayoutParams) this).height = parcel.readInt();
            ((ViewGroup.MarginLayoutParams) this).width = parcel.readInt();
        }
    }
}
