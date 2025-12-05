package com.google.android.flexbox;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.Nullable;
import androidx.core.view.ViewCompat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import p007b.p100d.p104b.p105a.outline;
import p007b.p225i.p226a.p287e.FlexContainer;
import p007b.p225i.p226a.p287e.FlexLine;
import p007b.p225i.p226a.p287e.FlexboxHelper;

/* loaded from: classes3.dex */
public class FlexboxLayout extends ViewGroup implements FlexContainer {

    /* renamed from: j */
    public int f20291j;

    /* renamed from: k */
    public int f20292k;

    /* renamed from: l */
    public int f20293l;

    /* renamed from: m */
    public int f20294m;

    /* renamed from: n */
    public int f20295n;

    /* renamed from: o */
    public int f20296o;

    /* renamed from: p */
    @Nullable
    public Drawable f20297p;

    /* renamed from: q */
    @Nullable
    public Drawable f20298q;

    /* renamed from: r */
    public int f20299r;

    /* renamed from: s */
    public int f20300s;

    /* renamed from: t */
    public int f20301t;

    /* renamed from: u */
    public int f20302u;

    /* renamed from: v */
    public int[] f20303v;

    /* renamed from: w */
    public SparseIntArray f20304w;

    /* renamed from: x */
    public FlexboxHelper f20305x;

    /* renamed from: y */
    public List<FlexLine> f20306y;

    /* renamed from: z */
    public FlexboxHelper.b f20307z;

    public FlexboxLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        this.f20296o = -1;
        this.f20305x = new FlexboxHelper(this);
        this.f20306y = new ArrayList();
        this.f20307z = new FlexboxHelper.b();
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C10785R.a.FlexboxLayout, 0, 0);
        this.f20291j = typedArrayObtainStyledAttributes.getInt(C10785R.a.FlexboxLayout_flexDirection, 0);
        this.f20292k = typedArrayObtainStyledAttributes.getInt(C10785R.a.FlexboxLayout_flexWrap, 0);
        this.f20293l = typedArrayObtainStyledAttributes.getInt(C10785R.a.FlexboxLayout_justifyContent, 0);
        this.f20294m = typedArrayObtainStyledAttributes.getInt(C10785R.a.FlexboxLayout_alignItems, 0);
        this.f20295n = typedArrayObtainStyledAttributes.getInt(C10785R.a.FlexboxLayout_alignContent, 0);
        this.f20296o = typedArrayObtainStyledAttributes.getInt(C10785R.a.FlexboxLayout_maxLine, -1);
        Drawable drawable = typedArrayObtainStyledAttributes.getDrawable(C10785R.a.FlexboxLayout_dividerDrawable);
        if (drawable != null) {
            setDividerDrawableHorizontal(drawable);
            setDividerDrawableVertical(drawable);
        }
        Drawable drawable2 = typedArrayObtainStyledAttributes.getDrawable(C10785R.a.FlexboxLayout_dividerDrawableHorizontal);
        if (drawable2 != null) {
            setDividerDrawableHorizontal(drawable2);
        }
        Drawable drawable3 = typedArrayObtainStyledAttributes.getDrawable(C10785R.a.FlexboxLayout_dividerDrawableVertical);
        if (drawable3 != null) {
            setDividerDrawableVertical(drawable3);
        }
        int i = typedArrayObtainStyledAttributes.getInt(C10785R.a.FlexboxLayout_showDivider, 0);
        if (i != 0) {
            this.f20300s = i;
            this.f20299r = i;
        }
        int i2 = typedArrayObtainStyledAttributes.getInt(C10785R.a.FlexboxLayout_showDividerVertical, 0);
        if (i2 != 0) {
            this.f20300s = i2;
        }
        int i3 = typedArrayObtainStyledAttributes.getInt(C10785R.a.FlexboxLayout_showDividerHorizontal, 0);
        if (i3 != 0) {
            this.f20299r = i3;
        }
        typedArrayObtainStyledAttributes.recycle();
    }

    @Override // p007b.p225i.p226a.p287e.FlexContainer
    /* renamed from: a */
    public void mo3924a(View view, int i, int i2, FlexLine flexLine) {
        if (m8975p(i, i2)) {
            if (mo3932i()) {
                int i3 = flexLine.f9167e;
                int i4 = this.f20302u;
                flexLine.f9167e = i3 + i4;
                flexLine.f9168f += i4;
                return;
            }
            int i5 = flexLine.f9167e;
            int i6 = this.f20301t;
            flexLine.f9167e = i5 + i6;
            flexLine.f9168f += i6;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.view.ViewGroup
    public void addView(View view, int i, ViewGroup.LayoutParams layoutParams) {
        if (this.f20304w == null) {
            this.f20304w = new SparseIntArray(getChildCount());
        }
        FlexboxHelper flexboxHelper = this.f20305x;
        SparseIntArray sparseIntArray = this.f20304w;
        int flexItemCount = flexboxHelper.f9181a.getFlexItemCount();
        List<FlexboxHelper.c> listM3943f = flexboxHelper.m3943f(flexItemCount);
        FlexboxHelper.c cVar = new FlexboxHelper.c(null);
        if (view == null || !(layoutParams instanceof FlexItem)) {
            cVar.f9189k = 1;
        } else {
            cVar.f9189k = ((FlexItem) layoutParams).getOrder();
        }
        if (i == -1 || i == flexItemCount || i >= flexboxHelper.f9181a.getFlexItemCount()) {
            cVar.f9188j = flexItemCount;
        } else {
            cVar.f9188j = i;
            for (int i2 = i; i2 < flexItemCount; i2++) {
                ((FlexboxHelper.c) ((ArrayList) listM3943f).get(i2)).f9188j++;
            }
        }
        ((ArrayList) listM3943f).add(cVar);
        this.f20303v = flexboxHelper.m3961x(flexItemCount + 1, listM3943f, sparseIntArray);
        super.addView(view, i, layoutParams);
    }

    @Override // p007b.p225i.p226a.p287e.FlexContainer
    /* renamed from: b */
    public void mo3925b(FlexLine flexLine) {
        if (mo3932i()) {
            if ((this.f20300s & 4) > 0) {
                int i = flexLine.f9167e;
                int i2 = this.f20302u;
                flexLine.f9167e = i + i2;
                flexLine.f9168f += i2;
                return;
            }
            return;
        }
        if ((this.f20299r & 4) > 0) {
            int i3 = flexLine.f9167e;
            int i4 = this.f20301t;
            flexLine.f9167e = i3 + i4;
            flexLine.f9168f += i4;
        }
    }

    @Override // p007b.p225i.p226a.p287e.FlexContainer
    /* renamed from: c */
    public View mo3926c(int i) {
        return m8974o(i);
    }

    @Override // android.view.ViewGroup
    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof LayoutParams;
    }

    @Override // p007b.p225i.p226a.p287e.FlexContainer
    /* renamed from: d */
    public int mo3927d(int i, int i2, int i3) {
        return ViewGroup.getChildMeasureSpec(i, i2, i3);
    }

    @Override // p007b.p225i.p226a.p287e.FlexContainer
    /* renamed from: e */
    public void mo3928e(int i, View view) {
    }

    @Override // p007b.p225i.p226a.p287e.FlexContainer
    /* renamed from: f */
    public View mo3929f(int i) {
        return getChildAt(i);
    }

    @Override // p007b.p225i.p226a.p287e.FlexContainer
    /* renamed from: g */
    public int mo3930g(View view, int i, int i2) {
        int i3;
        int i4;
        if (mo3932i()) {
            i3 = m8975p(i, i2) ? 0 + this.f20302u : 0;
            if ((this.f20300s & 4) <= 0) {
                return i3;
            }
            i4 = this.f20302u;
        } else {
            i3 = m8975p(i, i2) ? 0 + this.f20301t : 0;
            if ((this.f20299r & 4) <= 0) {
                return i3;
            }
            i4 = this.f20301t;
        }
        return i3 + i4;
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }

    @Override // p007b.p225i.p226a.p287e.FlexContainer
    public int getAlignContent() {
        return this.f20295n;
    }

    @Override // p007b.p225i.p226a.p287e.FlexContainer
    public int getAlignItems() {
        return this.f20294m;
    }

    @Nullable
    public Drawable getDividerDrawableHorizontal() {
        return this.f20297p;
    }

    @Nullable
    public Drawable getDividerDrawableVertical() {
        return this.f20298q;
    }

    @Override // p007b.p225i.p226a.p287e.FlexContainer
    public int getFlexDirection() {
        return this.f20291j;
    }

    @Override // p007b.p225i.p226a.p287e.FlexContainer
    public int getFlexItemCount() {
        return getChildCount();
    }

    public List<FlexLine> getFlexLines() {
        ArrayList arrayList = new ArrayList(this.f20306y.size());
        for (FlexLine flexLine : this.f20306y) {
            if (flexLine.m3934a() != 0) {
                arrayList.add(flexLine);
            }
        }
        return arrayList;
    }

    @Override // p007b.p225i.p226a.p287e.FlexContainer
    public List<FlexLine> getFlexLinesInternal() {
        return this.f20306y;
    }

    @Override // p007b.p225i.p226a.p287e.FlexContainer
    public int getFlexWrap() {
        return this.f20292k;
    }

    public int getJustifyContent() {
        return this.f20293l;
    }

    @Override // p007b.p225i.p226a.p287e.FlexContainer
    public int getLargestMainSize() {
        Iterator<FlexLine> it = this.f20306y.iterator();
        int iMax = Integer.MIN_VALUE;
        while (it.hasNext()) {
            iMax = Math.max(iMax, it.next().f9167e);
        }
        return iMax;
    }

    @Override // p007b.p225i.p226a.p287e.FlexContainer
    public int getMaxLine() {
        return this.f20296o;
    }

    public int getShowDividerHorizontal() {
        return this.f20299r;
    }

    public int getShowDividerVertical() {
        return this.f20300s;
    }

    @Override // p007b.p225i.p226a.p287e.FlexContainer
    public int getSumOfCrossSize() {
        int size = this.f20306y.size();
        int i = 0;
        for (int i2 = 0; i2 < size; i2++) {
            FlexLine flexLine = this.f20306y.get(i2);
            if (m8976q(i2)) {
                i += mo3932i() ? this.f20301t : this.f20302u;
            }
            if (m8977r(i2)) {
                i += mo3932i() ? this.f20301t : this.f20302u;
            }
            i += flexLine.f9169g;
        }
        return i;
    }

    @Override // p007b.p225i.p226a.p287e.FlexContainer
    /* renamed from: h */
    public int mo3931h(int i, int i2, int i3) {
        return ViewGroup.getChildMeasureSpec(i, i2, i3);
    }

    @Override // p007b.p225i.p226a.p287e.FlexContainer
    /* renamed from: i */
    public boolean mo3932i() {
        int i = this.f20291j;
        return i == 0 || i == 1;
    }

    @Override // p007b.p225i.p226a.p287e.FlexContainer
    /* renamed from: j */
    public int mo3933j(View view) {
        return 0;
    }

    /* renamed from: k */
    public final void m8970k(Canvas canvas, boolean z2, boolean z3) {
        int paddingLeft = getPaddingLeft();
        int iMax = Math.max(0, (getWidth() - getPaddingRight()) - paddingLeft);
        int size = this.f20306y.size();
        for (int i = 0; i < size; i++) {
            FlexLine flexLine = this.f20306y.get(i);
            for (int i2 = 0; i2 < flexLine.f9170h; i2++) {
                int i3 = flexLine.f9177o + i2;
                View viewM8974o = m8974o(i3);
                if (viewM8974o != null && viewM8974o.getVisibility() != 8) {
                    LayoutParams layoutParams = (LayoutParams) viewM8974o.getLayoutParams();
                    if (m8975p(i3, i2)) {
                        m8973n(canvas, z2 ? viewM8974o.getRight() + ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin : (viewM8974o.getLeft() - ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin) - this.f20302u, flexLine.f9164b, flexLine.f9169g);
                    }
                    if (i2 == flexLine.f9170h - 1 && (this.f20300s & 4) > 0) {
                        m8973n(canvas, z2 ? (viewM8974o.getLeft() - ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin) - this.f20302u : viewM8974o.getRight() + ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin, flexLine.f9164b, flexLine.f9169g);
                    }
                }
            }
            if (m8976q(i)) {
                m8972m(canvas, paddingLeft, z3 ? flexLine.f9166d : flexLine.f9164b - this.f20301t, iMax);
            }
            if (m8977r(i) && (this.f20299r & 4) > 0) {
                m8972m(canvas, paddingLeft, z3 ? flexLine.f9164b - this.f20301t : flexLine.f9166d, iMax);
            }
        }
    }

    /* renamed from: l */
    public final void m8971l(Canvas canvas, boolean z2, boolean z3) {
        int paddingTop = getPaddingTop();
        int iMax = Math.max(0, (getHeight() - getPaddingBottom()) - paddingTop);
        int size = this.f20306y.size();
        for (int i = 0; i < size; i++) {
            FlexLine flexLine = this.f20306y.get(i);
            for (int i2 = 0; i2 < flexLine.f9170h; i2++) {
                int i3 = flexLine.f9177o + i2;
                View viewM8974o = m8974o(i3);
                if (viewM8974o != null && viewM8974o.getVisibility() != 8) {
                    LayoutParams layoutParams = (LayoutParams) viewM8974o.getLayoutParams();
                    if (m8975p(i3, i2)) {
                        m8972m(canvas, flexLine.f9163a, z3 ? viewM8974o.getBottom() + ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin : (viewM8974o.getTop() - ((ViewGroup.MarginLayoutParams) layoutParams).topMargin) - this.f20301t, flexLine.f9169g);
                    }
                    if (i2 == flexLine.f9170h - 1 && (this.f20299r & 4) > 0) {
                        m8972m(canvas, flexLine.f9163a, z3 ? (viewM8974o.getTop() - ((ViewGroup.MarginLayoutParams) layoutParams).topMargin) - this.f20301t : viewM8974o.getBottom() + ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin, flexLine.f9169g);
                    }
                }
            }
            if (m8976q(i)) {
                m8973n(canvas, z2 ? flexLine.f9165c : flexLine.f9163a - this.f20302u, paddingTop, iMax);
            }
            if (m8977r(i) && (this.f20300s & 4) > 0) {
                m8973n(canvas, z2 ? flexLine.f9163a - this.f20302u : flexLine.f9165c, paddingTop, iMax);
            }
        }
    }

    /* renamed from: m */
    public final void m8972m(Canvas canvas, int i, int i2, int i3) {
        Drawable drawable = this.f20297p;
        if (drawable == null) {
            return;
        }
        drawable.setBounds(i, i2, i3 + i, this.f20301t + i2);
        this.f20297p.draw(canvas);
    }

    /* renamed from: n */
    public final void m8973n(Canvas canvas, int i, int i2, int i3) {
        Drawable drawable = this.f20298q;
        if (drawable == null) {
            return;
        }
        drawable.setBounds(i, i2, this.f20302u + i, i3 + i2);
        this.f20298q.draw(canvas);
    }

    /* renamed from: o */
    public View m8974o(int i) {
        if (i < 0) {
            return null;
        }
        int[] iArr = this.f20303v;
        if (i >= iArr.length) {
            return null;
        }
        return getChildAt(iArr[i]);
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        if (this.f20298q == null && this.f20297p == null) {
            return;
        }
        if (this.f20299r == 0 && this.f20300s == 0) {
            return;
        }
        int layoutDirection = ViewCompat.getLayoutDirection(this);
        int i = this.f20291j;
        if (i == 0) {
            m8970k(canvas, layoutDirection == 1, this.f20292k == 2);
            return;
        }
        if (i == 1) {
            m8970k(canvas, layoutDirection != 1, this.f20292k == 2);
            return;
        }
        if (i == 2) {
            boolean z2 = layoutDirection == 1;
            if (this.f20292k == 2) {
                z2 = !z2;
            }
            m8971l(canvas, z2, false);
            return;
        }
        if (i != 3) {
            return;
        }
        boolean z3 = layoutDirection == 1;
        if (this.f20292k == 2) {
            z3 = !z3;
        }
        m8971l(canvas, z3, true);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z2, int i, int i2, int i3, int i4) {
        boolean z3;
        int layoutDirection = ViewCompat.getLayoutDirection(this);
        int i5 = this.f20291j;
        if (i5 == 0) {
            m8978s(layoutDirection == 1, i, i2, i3, i4);
            return;
        }
        if (i5 == 1) {
            m8978s(layoutDirection != 1, i, i2, i3, i4);
            return;
        }
        if (i5 == 2) {
            z3 = layoutDirection == 1;
            if (this.f20292k == 2) {
                z3 = !z3;
            }
            m8979t(z3, false, i, i2, i3, i4);
            return;
        }
        if (i5 != 3) {
            StringBuilder sbM833U = outline.m833U("Invalid flex direction is set: ");
            sbM833U.append(this.f20291j);
            throw new IllegalStateException(sbM833U.toString());
        }
        z3 = layoutDirection == 1;
        if (this.f20292k == 2) {
            z3 = !z3;
        }
        m8979t(z3, true, i, i2, i3, i4);
    }

    @Override // android.view.View
    public void onMeasure(int i, int i2) {
        boolean z2;
        if (this.f20304w == null) {
            this.f20304w = new SparseIntArray(getChildCount());
        }
        FlexboxHelper flexboxHelper = this.f20305x;
        SparseIntArray sparseIntArray = this.f20304w;
        int flexItemCount = flexboxHelper.f9181a.getFlexItemCount();
        if (sparseIntArray.size() != flexItemCount) {
            z2 = true;
            break;
        }
        for (int i3 = 0; i3 < flexItemCount; i3++) {
            View viewMo3929f = flexboxHelper.f9181a.mo3929f(i3);
            if (viewMo3929f != null && ((FlexItem) viewMo3929f.getLayoutParams()).getOrder() != sparseIntArray.get(i3)) {
                z2 = true;
                break;
            }
        }
        z2 = false;
        if (z2) {
            FlexboxHelper flexboxHelper2 = this.f20305x;
            SparseIntArray sparseIntArray2 = this.f20304w;
            int flexItemCount2 = flexboxHelper2.f9181a.getFlexItemCount();
            this.f20303v = flexboxHelper2.m3961x(flexItemCount2, flexboxHelper2.m3943f(flexItemCount2), sparseIntArray2);
        }
        int i4 = this.f20291j;
        if (i4 != 0 && i4 != 1) {
            if (i4 != 2 && i4 != 3) {
                StringBuilder sbM833U = outline.m833U("Invalid value for the flex direction is set: ");
                sbM833U.append(this.f20291j);
                throw new IllegalStateException(sbM833U.toString());
            }
            this.f20306y.clear();
            this.f20307z.m3964a();
            this.f20305x.m3939b(this.f20307z, i2, i, Integer.MAX_VALUE, 0, -1, null);
            this.f20306y = this.f20307z.f9186a;
            this.f20305x.m3945h(i, i2, 0);
            this.f20305x.m3944g(i, i2, getPaddingRight() + getPaddingLeft());
            this.f20305x.m3936A(0);
            m8980u(this.f20291j, i, i2, this.f20307z.f9187b);
            return;
        }
        this.f20306y.clear();
        this.f20307z.m3964a();
        this.f20305x.m3939b(this.f20307z, i, i2, Integer.MAX_VALUE, 0, -1, null);
        this.f20306y = this.f20307z.f9186a;
        this.f20305x.m3945h(i, i2, 0);
        if (this.f20294m == 3) {
            for (FlexLine flexLine : this.f20306y) {
                int iMax = Integer.MIN_VALUE;
                for (int i5 = 0; i5 < flexLine.f9170h; i5++) {
                    View viewM8974o = m8974o(flexLine.f9177o + i5);
                    if (viewM8974o != null && viewM8974o.getVisibility() != 8) {
                        LayoutParams layoutParams = (LayoutParams) viewM8974o.getLayoutParams();
                        iMax = this.f20292k != 2 ? Math.max(iMax, viewM8974o.getMeasuredHeight() + Math.max(flexLine.f9174l - viewM8974o.getBaseline(), ((ViewGroup.MarginLayoutParams) layoutParams).topMargin) + ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin) : Math.max(iMax, viewM8974o.getMeasuredHeight() + ((ViewGroup.MarginLayoutParams) layoutParams).topMargin + Math.max(viewM8974o.getBaseline() + (flexLine.f9174l - viewM8974o.getMeasuredHeight()), ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin));
                    }
                }
                flexLine.f9169g = iMax;
            }
        }
        this.f20305x.m3944g(i, i2, getPaddingBottom() + getPaddingTop());
        this.f20305x.m3936A(0);
        m8980u(this.f20291j, i, i2, this.f20307z.f9187b);
    }

    /* renamed from: p */
    public final boolean m8975p(int i, int i2) {
        boolean z2;
        int i3 = 1;
        while (true) {
            if (i3 > i2) {
                z2 = true;
                break;
            }
            View viewM8974o = m8974o(i - i3);
            if (viewM8974o != null && viewM8974o.getVisibility() != 8) {
                z2 = false;
                break;
            }
            i3++;
        }
        return z2 ? mo3932i() ? (this.f20300s & 1) != 0 : (this.f20299r & 1) != 0 : mo3932i() ? (this.f20300s & 2) != 0 : (this.f20299r & 2) != 0;
    }

    /* renamed from: q */
    public final boolean m8976q(int i) {
        boolean z2;
        if (i < 0 || i >= this.f20306y.size()) {
            return false;
        }
        int i2 = 0;
        while (true) {
            if (i2 >= i) {
                z2 = true;
                break;
            }
            if (this.f20306y.get(i2).m3934a() > 0) {
                z2 = false;
                break;
            }
            i2++;
        }
        return z2 ? mo3932i() ? (this.f20299r & 1) != 0 : (this.f20300s & 1) != 0 : mo3932i() ? (this.f20299r & 2) != 0 : (this.f20300s & 2) != 0;
    }

    /* renamed from: r */
    public final boolean m8977r(int i) {
        if (i < 0 || i >= this.f20306y.size()) {
            return false;
        }
        for (int i2 = i + 1; i2 < this.f20306y.size(); i2++) {
            if (this.f20306y.get(i2).m3934a() > 0) {
                return false;
            }
        }
        return mo3932i() ? (this.f20299r & 4) != 0 : (this.f20300s & 4) != 0;
    }

    /* JADX WARN: Removed duplicated region for block: B:41:0x00d9  */
    /* renamed from: s */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void m8978s(boolean z2, int i, int i2, int i3, int i4) {
        float f;
        float f2;
        float f3;
        int i5;
        int i6;
        int i7;
        float f4;
        float f5;
        int i8;
        LayoutParams layoutParams;
        int paddingLeft = getPaddingLeft();
        int paddingRight = getPaddingRight();
        int i9 = i3 - i;
        int paddingBottom = (i4 - i2) - getPaddingBottom();
        int paddingTop = getPaddingTop();
        int size = this.f20306y.size();
        int i10 = 0;
        while (i10 < size) {
            FlexLine flexLine = this.f20306y.get(i10);
            if (m8976q(i10)) {
                int i11 = this.f20301t;
                paddingBottom -= i11;
                paddingTop += i11;
            }
            int i12 = this.f20293l;
            int i13 = 1;
            if (i12 == 0) {
                f = paddingLeft;
                f2 = i9 - paddingRight;
            } else if (i12 == 1) {
                int i14 = flexLine.f9167e;
                f2 = i14 - paddingLeft;
                f = (i9 - i14) + paddingRight;
            } else if (i12 != 2) {
                if (i12 == 3) {
                    f = paddingLeft;
                    f3 = (i9 - flexLine.f9167e) / (flexLine.m3934a() != 1 ? r10 - 1 : 1.0f);
                    f2 = i9 - paddingRight;
                } else if (i12 == 4) {
                    int iM3934a = flexLine.m3934a();
                    f3 = iM3934a != 0 ? (i9 - flexLine.f9167e) / iM3934a : 0.0f;
                    float f6 = f3 / 2.0f;
                    f = paddingLeft + f6;
                    f2 = (i9 - paddingRight) - f6;
                } else {
                    if (i12 != 5) {
                        StringBuilder sbM833U = outline.m833U("Invalid justifyContent is set: ");
                        sbM833U.append(this.f20293l);
                        throw new IllegalStateException(sbM833U.toString());
                    }
                    f3 = flexLine.m3934a() != 0 ? (i9 - flexLine.f9167e) / (r9 + 1) : 0.0f;
                    f = paddingLeft + f3;
                    f2 = (i9 - paddingRight) - f3;
                }
                float fMax = Math.max(f3, 0.0f);
                i5 = 0;
                while (i5 < flexLine.f9170h) {
                    int i15 = flexLine.f9177o + i5;
                    View viewM8974o = m8974o(i15);
                    if (viewM8974o == null || viewM8974o.getVisibility() == 8) {
                        i6 = paddingLeft;
                        i7 = i5;
                    } else {
                        LayoutParams layoutParams2 = (LayoutParams) viewM8974o.getLayoutParams();
                        float f7 = f + ((ViewGroup.MarginLayoutParams) layoutParams2).leftMargin;
                        float f8 = f2 - ((ViewGroup.MarginLayoutParams) layoutParams2).rightMargin;
                        if (m8975p(i15, i5)) {
                            int i16 = this.f20302u;
                            float f9 = i16;
                            f4 = f7 + f9;
                            i8 = i16;
                            f5 = f8 - f9;
                        } else {
                            f4 = f7;
                            f5 = f8;
                            i8 = 0;
                        }
                        int i17 = (i5 != flexLine.f9170h - i13 || (this.f20300s & 4) <= 0) ? 0 : this.f20302u;
                        if (this.f20292k != 2) {
                            i6 = paddingLeft;
                            layoutParams = layoutParams2;
                            i7 = i5;
                            if (z2) {
                                this.f20305x.m3958u(viewM8974o, flexLine, Math.round(f5) - viewM8974o.getMeasuredWidth(), paddingTop, Math.round(f5), viewM8974o.getMeasuredHeight() + paddingTop);
                            } else {
                                this.f20305x.m3958u(viewM8974o, flexLine, Math.round(f4), paddingTop, viewM8974o.getMeasuredWidth() + Math.round(f4), viewM8974o.getMeasuredHeight() + paddingTop);
                            }
                        } else if (z2) {
                            i6 = paddingLeft;
                            layoutParams = layoutParams2;
                            i7 = i5;
                            this.f20305x.m3958u(viewM8974o, flexLine, Math.round(f5) - viewM8974o.getMeasuredWidth(), paddingBottom - viewM8974o.getMeasuredHeight(), Math.round(f5), paddingBottom);
                        } else {
                            i6 = paddingLeft;
                            layoutParams = layoutParams2;
                            i7 = i5;
                            this.f20305x.m3958u(viewM8974o, flexLine, Math.round(f4), paddingBottom - viewM8974o.getMeasuredHeight(), viewM8974o.getMeasuredWidth() + Math.round(f4), paddingBottom);
                        }
                        float measuredWidth = viewM8974o.getMeasuredWidth() + fMax + ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin + f4;
                        float measuredWidth2 = f5 - ((viewM8974o.getMeasuredWidth() + fMax) + ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin);
                        if (z2) {
                            flexLine.m3935b(viewM8974o, i17, 0, i8, 0);
                        } else {
                            flexLine.m3935b(viewM8974o, i8, 0, i17, 0);
                        }
                        f = measuredWidth;
                        f2 = measuredWidth2;
                    }
                    i5 = i7 + 1;
                    i13 = 1;
                    paddingLeft = i6;
                }
                int i18 = paddingLeft;
                int i19 = flexLine.f9169g;
                paddingTop += i19;
                paddingBottom -= i19;
                i10++;
                paddingLeft = i18;
            } else {
                int i20 = flexLine.f9167e;
                f2 = (i9 - paddingRight) - ((i9 - i20) / 2.0f);
                f = ((i9 - i20) / 2.0f) + paddingLeft;
            }
            f3 = 0.0f;
            float fMax2 = Math.max(f3, 0.0f);
            i5 = 0;
            while (i5 < flexLine.f9170h) {
            }
            int i182 = paddingLeft;
            int i192 = flexLine.f9169g;
            paddingTop += i192;
            paddingBottom -= i192;
            i10++;
            paddingLeft = i182;
        }
    }

    public void setAlignContent(int i) {
        if (this.f20295n != i) {
            this.f20295n = i;
            requestLayout();
        }
    }

    public void setAlignItems(int i) {
        if (this.f20294m != i) {
            this.f20294m = i;
            requestLayout();
        }
    }

    public void setDividerDrawable(Drawable drawable) {
        setDividerDrawableHorizontal(drawable);
        setDividerDrawableVertical(drawable);
    }

    public void setDividerDrawableHorizontal(@Nullable Drawable drawable) {
        if (drawable == this.f20297p) {
            return;
        }
        this.f20297p = drawable;
        if (drawable != null) {
            this.f20301t = drawable.getIntrinsicHeight();
        } else {
            this.f20301t = 0;
        }
        if (this.f20297p == null && this.f20298q == null) {
            setWillNotDraw(true);
        } else {
            setWillNotDraw(false);
        }
        requestLayout();
    }

    public void setDividerDrawableVertical(@Nullable Drawable drawable) {
        if (drawable == this.f20298q) {
            return;
        }
        this.f20298q = drawable;
        if (drawable != null) {
            this.f20302u = drawable.getIntrinsicWidth();
        } else {
            this.f20302u = 0;
        }
        if (this.f20297p == null && this.f20298q == null) {
            setWillNotDraw(true);
        } else {
            setWillNotDraw(false);
        }
        requestLayout();
    }

    public void setFlexDirection(int i) {
        if (this.f20291j != i) {
            this.f20291j = i;
            requestLayout();
        }
    }

    @Override // p007b.p225i.p226a.p287e.FlexContainer
    public void setFlexLines(List<FlexLine> list) {
        this.f20306y = list;
    }

    public void setFlexWrap(int i) {
        if (this.f20292k != i) {
            this.f20292k = i;
            requestLayout();
        }
    }

    public void setJustifyContent(int i) {
        if (this.f20293l != i) {
            this.f20293l = i;
            requestLayout();
        }
    }

    public void setMaxLine(int i) {
        if (this.f20296o != i) {
            this.f20296o = i;
            requestLayout();
        }
    }

    public void setShowDivider(int i) {
        setShowDividerVertical(i);
        setShowDividerHorizontal(i);
    }

    public void setShowDividerHorizontal(int i) {
        if (i != this.f20299r) {
            this.f20299r = i;
            requestLayout();
        }
    }

    public void setShowDividerVertical(int i) {
        if (i != this.f20300s) {
            this.f20300s = i;
            requestLayout();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:42:0x00d7  */
    /* renamed from: t */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void m8979t(boolean z2, boolean z3, int i, int i2, int i3, int i4) {
        float f;
        int i5;
        float f2;
        float f3;
        float f4;
        int i6;
        int i7;
        float f5;
        float f6;
        int i8;
        LayoutParams layoutParams;
        int paddingTop = getPaddingTop();
        int paddingBottom = getPaddingBottom();
        int paddingRight = getPaddingRight();
        int paddingLeft = getPaddingLeft();
        int i9 = i4 - i2;
        int i10 = (i3 - i) - paddingRight;
        int size = this.f20306y.size();
        for (int i11 = 0; i11 < size; i11++) {
            FlexLine flexLine = this.f20306y.get(i11);
            if (m8976q(i11)) {
                int i12 = this.f20302u;
                paddingLeft += i12;
                i10 -= i12;
            }
            int i13 = this.f20293l;
            if (i13 == 0) {
                f = paddingTop;
                i5 = i9 - paddingBottom;
            } else if (i13 == 1) {
                int i14 = flexLine.f9167e;
                f = (i9 - i14) + paddingBottom;
                i5 = i14 - paddingTop;
            } else if (i13 != 2) {
                if (i13 == 3) {
                    f3 = paddingTop;
                    f4 = (i9 - flexLine.f9167e) / (flexLine.m3934a() != 1 ? r10 - 1 : 1.0f);
                    f2 = i9 - paddingBottom;
                } else if (i13 == 4) {
                    int iM3934a = flexLine.m3934a();
                    f4 = iM3934a != 0 ? (i9 - flexLine.f9167e) / iM3934a : 0.0f;
                    float f7 = f4 / 2.0f;
                    f3 = paddingTop + f7;
                    f2 = (i9 - paddingBottom) - f7;
                } else {
                    if (i13 != 5) {
                        StringBuilder sbM833U = outline.m833U("Invalid justifyContent is set: ");
                        sbM833U.append(this.f20293l);
                        throw new IllegalStateException(sbM833U.toString());
                    }
                    f4 = flexLine.m3934a() != 0 ? (i9 - flexLine.f9167e) / (r9 + 1) : 0.0f;
                    f3 = paddingTop + f4;
                    f2 = (i9 - paddingBottom) - f4;
                }
                float fMax = Math.max(f4, 0.0f);
                i6 = 0;
                while (i6 < flexLine.f9170h) {
                    int i15 = flexLine.f9177o + i6;
                    View viewM8974o = m8974o(i15);
                    if (viewM8974o == null || viewM8974o.getVisibility() == 8) {
                        i7 = i6;
                    } else {
                        LayoutParams layoutParams2 = (LayoutParams) viewM8974o.getLayoutParams();
                        float f8 = f3 + ((ViewGroup.MarginLayoutParams) layoutParams2).topMargin;
                        float f9 = f2 - ((ViewGroup.MarginLayoutParams) layoutParams2).bottomMargin;
                        if (m8975p(i15, i6)) {
                            int i16 = this.f20301t;
                            float f10 = i16;
                            f5 = f8 + f10;
                            i8 = i16;
                            f6 = f9 - f10;
                        } else {
                            f5 = f8;
                            f6 = f9;
                            i8 = 0;
                        }
                        int i17 = (i6 != flexLine.f9170h + (-1) || (this.f20299r & 4) <= 0) ? 0 : this.f20301t;
                        if (!z2) {
                            layoutParams = layoutParams2;
                            i7 = i6;
                            if (z3) {
                                this.f20305x.m3959v(viewM8974o, flexLine, false, paddingLeft, Math.round(f6) - viewM8974o.getMeasuredHeight(), viewM8974o.getMeasuredWidth() + paddingLeft, Math.round(f6));
                            } else {
                                this.f20305x.m3959v(viewM8974o, flexLine, false, paddingLeft, Math.round(f5), viewM8974o.getMeasuredWidth() + paddingLeft, viewM8974o.getMeasuredHeight() + Math.round(f5));
                            }
                        } else if (z3) {
                            layoutParams = layoutParams2;
                            i7 = i6;
                            this.f20305x.m3959v(viewM8974o, flexLine, true, i10 - viewM8974o.getMeasuredWidth(), Math.round(f6) - viewM8974o.getMeasuredHeight(), i10, Math.round(f6));
                        } else {
                            layoutParams = layoutParams2;
                            i7 = i6;
                            this.f20305x.m3959v(viewM8974o, flexLine, true, i10 - viewM8974o.getMeasuredWidth(), Math.round(f5), i10, viewM8974o.getMeasuredHeight() + Math.round(f5));
                        }
                        LayoutParams layoutParams3 = layoutParams;
                        float measuredHeight = viewM8974o.getMeasuredHeight() + fMax + ((ViewGroup.MarginLayoutParams) layoutParams3).bottomMargin + f5;
                        float measuredHeight2 = f6 - ((viewM8974o.getMeasuredHeight() + fMax) + ((ViewGroup.MarginLayoutParams) layoutParams3).topMargin);
                        if (z3) {
                            flexLine.m3935b(viewM8974o, 0, i17, 0, i8);
                        } else {
                            flexLine.m3935b(viewM8974o, 0, i8, 0, i17);
                        }
                        f3 = measuredHeight;
                        f2 = measuredHeight2;
                    }
                    i6 = i7 + 1;
                }
                int i18 = flexLine.f9169g;
                paddingLeft += i18;
                i10 -= i18;
            } else {
                int i19 = flexLine.f9167e;
                f2 = (i9 - paddingBottom) - ((i9 - i19) / 2.0f);
                f3 = ((i9 - i19) / 2.0f) + paddingTop;
                f4 = 0.0f;
                float fMax2 = Math.max(f4, 0.0f);
                i6 = 0;
                while (i6 < flexLine.f9170h) {
                }
                int i182 = flexLine.f9169g;
                paddingLeft += i182;
                i10 -= i182;
            }
            f2 = i5;
            f3 = f;
            f4 = 0.0f;
            float fMax22 = Math.max(f4, 0.0f);
            i6 = 0;
            while (i6 < flexLine.f9170h) {
            }
            int i1822 = flexLine.f9169g;
            paddingLeft += i1822;
            i10 -= i1822;
        }
    }

    /* renamed from: u */
    public final void m8980u(int i, int i2, int i3, int i4) {
        int paddingBottom;
        int largestMainSize;
        int iResolveSizeAndState;
        int iResolveSizeAndState2;
        int mode = View.MeasureSpec.getMode(i2);
        int size = View.MeasureSpec.getSize(i2);
        int mode2 = View.MeasureSpec.getMode(i3);
        int size2 = View.MeasureSpec.getSize(i3);
        if (i == 0 || i == 1) {
            paddingBottom = getPaddingBottom() + getPaddingTop() + getSumOfCrossSize();
            largestMainSize = getLargestMainSize();
        } else {
            if (i != 2 && i != 3) {
                throw new IllegalArgumentException(outline.m871q("Invalid flex direction: ", i));
            }
            paddingBottom = getLargestMainSize();
            largestMainSize = getPaddingRight() + getPaddingLeft() + getSumOfCrossSize();
        }
        if (mode == Integer.MIN_VALUE) {
            if (size < largestMainSize) {
                i4 = View.combineMeasuredStates(i4, 16777216);
            } else {
                size = largestMainSize;
            }
            iResolveSizeAndState = View.resolveSizeAndState(size, i2, i4);
        } else if (mode == 0) {
            iResolveSizeAndState = View.resolveSizeAndState(largestMainSize, i2, i4);
        } else {
            if (mode != 1073741824) {
                throw new IllegalStateException(outline.m871q("Unknown width mode is set: ", mode));
            }
            if (size < largestMainSize) {
                i4 = View.combineMeasuredStates(i4, 16777216);
            }
            iResolveSizeAndState = View.resolveSizeAndState(size, i2, i4);
        }
        if (mode2 == Integer.MIN_VALUE) {
            if (size2 < paddingBottom) {
                i4 = View.combineMeasuredStates(i4, 256);
            } else {
                size2 = paddingBottom;
            }
            iResolveSizeAndState2 = View.resolveSizeAndState(size2, i3, i4);
        } else if (mode2 == 0) {
            iResolveSizeAndState2 = View.resolveSizeAndState(paddingBottom, i3, i4);
        } else {
            if (mode2 != 1073741824) {
                throw new IllegalStateException(outline.m871q("Unknown height mode is set: ", mode2));
            }
            if (size2 < paddingBottom) {
                i4 = View.combineMeasuredStates(i4, 256);
            }
            iResolveSizeAndState2 = View.resolveSizeAndState(size2, i3, i4);
        }
        setMeasuredDimension(iResolveSizeAndState, iResolveSizeAndState2);
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof LayoutParams ? new LayoutParams((LayoutParams) layoutParams) : layoutParams instanceof ViewGroup.MarginLayoutParams ? new LayoutParams((ViewGroup.MarginLayoutParams) layoutParams) : new LayoutParams(layoutParams);
    }

    public static class LayoutParams extends ViewGroup.MarginLayoutParams implements FlexItem {
        public static final Parcelable.Creator<LayoutParams> CREATOR = new C10779a();

        /* renamed from: j */
        public int f20308j;

        /* renamed from: k */
        public float f20309k;

        /* renamed from: l */
        public float f20310l;

        /* renamed from: m */
        public int f20311m;

        /* renamed from: n */
        public float f20312n;

        /* renamed from: o */
        public int f20313o;

        /* renamed from: p */
        public int f20314p;

        /* renamed from: q */
        public int f20315q;

        /* renamed from: r */
        public int f20316r;

        /* renamed from: s */
        public boolean f20317s;

        /* renamed from: com.google.android.flexbox.FlexboxLayout$LayoutParams$a */
        public static class C10779a implements Parcelable.Creator<LayoutParams> {
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
            this.f20308j = 1;
            this.f20309k = 0.0f;
            this.f20310l = 1.0f;
            this.f20311m = -1;
            this.f20312n = -1.0f;
            this.f20313o = -1;
            this.f20314p = -1;
            this.f20315q = ViewCompat.MEASURED_SIZE_MASK;
            this.f20316r = ViewCompat.MEASURED_SIZE_MASK;
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C10785R.a.FlexboxLayout_Layout);
            this.f20308j = typedArrayObtainStyledAttributes.getInt(C10785R.a.FlexboxLayout_Layout_layout_order, 1);
            this.f20309k = typedArrayObtainStyledAttributes.getFloat(C10785R.a.FlexboxLayout_Layout_layout_flexGrow, 0.0f);
            this.f20310l = typedArrayObtainStyledAttributes.getFloat(C10785R.a.FlexboxLayout_Layout_layout_flexShrink, 1.0f);
            this.f20311m = typedArrayObtainStyledAttributes.getInt(C10785R.a.FlexboxLayout_Layout_layout_alignSelf, -1);
            this.f20312n = typedArrayObtainStyledAttributes.getFraction(C10785R.a.FlexboxLayout_Layout_layout_flexBasisPercent, 1, 1, -1.0f);
            this.f20313o = typedArrayObtainStyledAttributes.getDimensionPixelSize(C10785R.a.FlexboxLayout_Layout_layout_minWidth, -1);
            this.f20314p = typedArrayObtainStyledAttributes.getDimensionPixelSize(C10785R.a.FlexboxLayout_Layout_layout_minHeight, -1);
            this.f20315q = typedArrayObtainStyledAttributes.getDimensionPixelSize(C10785R.a.FlexboxLayout_Layout_layout_maxWidth, ViewCompat.MEASURED_SIZE_MASK);
            this.f20316r = typedArrayObtainStyledAttributes.getDimensionPixelSize(C10785R.a.FlexboxLayout_Layout_layout_maxHeight, ViewCompat.MEASURED_SIZE_MASK);
            this.f20317s = typedArrayObtainStyledAttributes.getBoolean(C10785R.a.FlexboxLayout_Layout_layout_wrapBefore, false);
            typedArrayObtainStyledAttributes.recycle();
        }

        @Override // com.google.android.flexbox.FlexItem
        /* renamed from: D */
        public int mo8955D() {
            return this.f20313o;
        }

        @Override // com.google.android.flexbox.FlexItem
        /* renamed from: H */
        public void mo8956H(int i) {
            this.f20313o = i;
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
            this.f20314p = i;
        }

        @Override // com.google.android.flexbox.FlexItem
        /* renamed from: S */
        public float mo8961S() {
            return this.f20309k;
        }

        @Override // com.google.android.flexbox.FlexItem
        /* renamed from: W */
        public float mo8962W() {
            return this.f20312n;
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
            return this.f20314p;
        }

        @Override // com.google.android.flexbox.FlexItem
        public int getHeight() {
            return ((ViewGroup.MarginLayoutParams) this).height;
        }

        @Override // com.google.android.flexbox.FlexItem
        public int getOrder() {
            return this.f20308j;
        }

        @Override // com.google.android.flexbox.FlexItem
        public int getWidth() {
            return ((ViewGroup.MarginLayoutParams) this).width;
        }

        @Override // com.google.android.flexbox.FlexItem
        /* renamed from: j0 */
        public boolean mo8965j0() {
            return this.f20317s;
        }

        @Override // com.google.android.flexbox.FlexItem
        /* renamed from: m0 */
        public int mo8966m0() {
            return this.f20316r;
        }

        @Override // com.google.android.flexbox.FlexItem
        /* renamed from: t0 */
        public int mo8967t0() {
            return this.f20315q;
        }

        @Override // com.google.android.flexbox.FlexItem
        /* renamed from: u */
        public int mo8968u() {
            return this.f20311m;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeInt(this.f20308j);
            parcel.writeFloat(this.f20309k);
            parcel.writeFloat(this.f20310l);
            parcel.writeInt(this.f20311m);
            parcel.writeFloat(this.f20312n);
            parcel.writeInt(this.f20313o);
            parcel.writeInt(this.f20314p);
            parcel.writeInt(this.f20315q);
            parcel.writeInt(this.f20316r);
            parcel.writeByte(this.f20317s ? (byte) 1 : (byte) 0);
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
            return this.f20310l;
        }

        public LayoutParams(LayoutParams layoutParams) {
            super((ViewGroup.MarginLayoutParams) layoutParams);
            this.f20308j = 1;
            this.f20309k = 0.0f;
            this.f20310l = 1.0f;
            this.f20311m = -1;
            this.f20312n = -1.0f;
            this.f20313o = -1;
            this.f20314p = -1;
            this.f20315q = ViewCompat.MEASURED_SIZE_MASK;
            this.f20316r = ViewCompat.MEASURED_SIZE_MASK;
            this.f20308j = layoutParams.f20308j;
            this.f20309k = layoutParams.f20309k;
            this.f20310l = layoutParams.f20310l;
            this.f20311m = layoutParams.f20311m;
            this.f20312n = layoutParams.f20312n;
            this.f20313o = layoutParams.f20313o;
            this.f20314p = layoutParams.f20314p;
            this.f20315q = layoutParams.f20315q;
            this.f20316r = layoutParams.f20316r;
            this.f20317s = layoutParams.f20317s;
        }

        public LayoutParams(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.f20308j = 1;
            this.f20309k = 0.0f;
            this.f20310l = 1.0f;
            this.f20311m = -1;
            this.f20312n = -1.0f;
            this.f20313o = -1;
            this.f20314p = -1;
            this.f20315q = ViewCompat.MEASURED_SIZE_MASK;
            this.f20316r = ViewCompat.MEASURED_SIZE_MASK;
        }

        public LayoutParams(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
            this.f20308j = 1;
            this.f20309k = 0.0f;
            this.f20310l = 1.0f;
            this.f20311m = -1;
            this.f20312n = -1.0f;
            this.f20313o = -1;
            this.f20314p = -1;
            this.f20315q = ViewCompat.MEASURED_SIZE_MASK;
            this.f20316r = ViewCompat.MEASURED_SIZE_MASK;
        }

        public LayoutParams(Parcel parcel) {
            super(0, 0);
            this.f20308j = 1;
            this.f20309k = 0.0f;
            this.f20310l = 1.0f;
            this.f20311m = -1;
            this.f20312n = -1.0f;
            this.f20313o = -1;
            this.f20314p = -1;
            this.f20315q = ViewCompat.MEASURED_SIZE_MASK;
            this.f20316r = ViewCompat.MEASURED_SIZE_MASK;
            this.f20308j = parcel.readInt();
            this.f20309k = parcel.readFloat();
            this.f20310l = parcel.readFloat();
            this.f20311m = parcel.readInt();
            this.f20312n = parcel.readFloat();
            this.f20313o = parcel.readInt();
            this.f20314p = parcel.readInt();
            this.f20315q = parcel.readInt();
            this.f20316r = parcel.readInt();
            this.f20317s = parcel.readByte() != 0;
            ((ViewGroup.MarginLayoutParams) this).bottomMargin = parcel.readInt();
            ((ViewGroup.MarginLayoutParams) this).leftMargin = parcel.readInt();
            ((ViewGroup.MarginLayoutParams) this).rightMargin = parcel.readInt();
            ((ViewGroup.MarginLayoutParams) this).topMargin = parcel.readInt();
            ((ViewGroup.MarginLayoutParams) this).height = parcel.readInt();
            ((ViewGroup.MarginLayoutParams) this).width = parcel.readInt();
        }
    }
}
