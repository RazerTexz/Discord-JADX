package p007b.p225i.p226a.p287e;

import android.graphics.drawable.Drawable;
import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.solver.widgets.analyzer.BasicMeasure;
import androidx.core.view.MarginLayoutParamsCompat;
import androidx.core.widget.CompoundButtonCompat;
import com.google.android.flexbox.FlexItem;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import p007b.p100d.p104b.p105a.outline;

/* JADX INFO: renamed from: b.i.a.e.c, reason: use source file name */
/* JADX INFO: compiled from: FlexboxHelper.java */
/* JADX INFO: loaded from: classes3.dex */
public class FlexboxHelper {

    /* JADX INFO: renamed from: a */
    public final FlexContainer f9181a;

    /* JADX INFO: renamed from: b */
    public boolean[] f9182b;

    /* JADX INFO: renamed from: c */
    @Nullable
    public int[] f9183c;

    /* JADX INFO: renamed from: d */
    @Nullable
    public long[] f9184d;

    /* JADX INFO: renamed from: e */
    @Nullable
    public long[] f9185e;

    /* JADX INFO: renamed from: b.i.a.e.c$b */
    /* JADX INFO: compiled from: FlexboxHelper.java */
    public static class b {

        /* JADX INFO: renamed from: a */
        public List<FlexLine> f9186a;

        /* JADX INFO: renamed from: b */
        public int f9187b;

        /* JADX INFO: renamed from: a */
        public void m3964a() {
            this.f9186a = null;
            this.f9187b = 0;
        }
    }

    /* JADX INFO: renamed from: b.i.a.e.c$c */
    /* JADX INFO: compiled from: FlexboxHelper.java */
    public static class c implements Comparable<c> {

        /* JADX INFO: renamed from: j */
        public int f9188j;

        /* JADX INFO: renamed from: k */
        public int f9189k;

        public c() {
        }

        @Override // java.lang.Comparable
        public int compareTo(@NonNull c cVar) {
            c cVar2 = cVar;
            int i = this.f9189k;
            int i2 = cVar2.f9189k;
            return i != i2 ? i - i2 : this.f9188j - cVar2.f9188j;
        }

        @NonNull
        public String toString() {
            StringBuilder sbM833U = outline.m833U("Order{order=");
            sbM833U.append(this.f9189k);
            sbM833U.append(", index=");
            return outline.m813A(sbM833U, this.f9188j, '}');
        }

        public c(a aVar) {
        }
    }

    public FlexboxHelper(FlexContainer flexContainer) {
        this.f9181a = flexContainer;
    }

    /* JADX INFO: renamed from: A */
    public void m3936A(int i) {
        View viewMo3926c;
        if (i >= this.f9181a.getFlexItemCount()) {
            return;
        }
        int flexDirection = this.f9181a.getFlexDirection();
        if (this.f9181a.getAlignItems() != 4) {
            for (FlexLine flexLine : this.f9181a.getFlexLinesInternal()) {
                for (Integer num : flexLine.f9176n) {
                    View viewMo3926c2 = this.f9181a.mo3926c(num.intValue());
                    if (flexDirection == 0 || flexDirection == 1) {
                        m3963z(viewMo3926c2, flexLine.f9169g, num.intValue());
                    } else {
                        if (flexDirection != 2 && flexDirection != 3) {
                            throw new IllegalArgumentException(outline.m871q("Invalid flex direction: ", flexDirection));
                        }
                        m3962y(viewMo3926c2, flexLine.f9169g, num.intValue());
                    }
                }
            }
            return;
        }
        int[] iArr = this.f9183c;
        List<FlexLine> flexLinesInternal = this.f9181a.getFlexLinesInternal();
        int size = flexLinesInternal.size();
        for (int i2 = iArr != null ? iArr[i] : 0; i2 < size; i2++) {
            FlexLine flexLine2 = flexLinesInternal.get(i2);
            int i3 = flexLine2.f9170h;
            for (int i4 = 0; i4 < i3; i4++) {
                int i5 = flexLine2.f9177o + i4;
                if (i4 < this.f9181a.getFlexItemCount() && (viewMo3926c = this.f9181a.mo3926c(i5)) != null && viewMo3926c.getVisibility() != 8) {
                    FlexItem flexItem = (FlexItem) viewMo3926c.getLayoutParams();
                    if (flexItem.mo8968u() == -1 || flexItem.mo8968u() == 4) {
                        if (flexDirection == 0 || flexDirection == 1) {
                            m3963z(viewMo3926c, flexLine2.f9169g, i5);
                        } else {
                            if (flexDirection != 2 && flexDirection != 3) {
                                throw new IllegalArgumentException(outline.m871q("Invalid flex direction: ", flexDirection));
                            }
                            m3962y(viewMo3926c, flexLine2.f9169g, i5);
                        }
                    }
                }
            }
        }
    }

    /* JADX INFO: renamed from: B */
    public final void m3937B(int i, int i2, int i3, View view) {
        long[] jArr = this.f9184d;
        if (jArr != null) {
            jArr[i] = (((long) i2) & 4294967295L) | (((long) i3) << 32);
        }
        long[] jArr2 = this.f9185e;
        if (jArr2 != null) {
            jArr2[i] = (((long) view.getMeasuredWidth()) & 4294967295L) | (((long) view.getMeasuredHeight()) << 32);
        }
    }

    /* JADX INFO: renamed from: a */
    public final void m3938a(List<FlexLine> list, FlexLine flexLine, int i, int i2) {
        flexLine.f9175m = i2;
        this.f9181a.mo3925b(flexLine);
        flexLine.f9178p = i;
        list.add(flexLine);
    }

    /* JADX WARN: Removed duplicated region for block: B:106:0x02b9  */
    /* JADX WARN: Removed duplicated region for block: B:109:0x02d1  */
    /* JADX WARN: Removed duplicated region for block: B:110:0x02d4  */
    /* JADX WARN: Removed duplicated region for block: B:113:0x02e4  */
    /* JADX WARN: Removed duplicated region for block: B:114:0x02e7  */
    /* JADX WARN: Removed duplicated region for block: B:117:0x02f1  */
    /* JADX WARN: Removed duplicated region for block: B:120:0x02fb  */
    /* JADX WARN: Removed duplicated region for block: B:121:0x0300  */
    /* JADX WARN: Removed duplicated region for block: B:124:0x032f  */
    /* JADX WARN: Removed duplicated region for block: B:125:0x0334  */
    /* JADX WARN: Removed duplicated region for block: B:128:0x035b  */
    /* JADX WARN: Removed duplicated region for block: B:134:0x0394  */
    /* JADX WARN: Removed duplicated region for block: B:137:0x039f  */
    /* JADX WARN: Removed duplicated region for block: B:146:0x03c5 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:91:0x0233  */
    /* JADX INFO: renamed from: b */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void m3939b(b bVar, int i, int i2, int i3, int i4, int i5, @Nullable List<FlexLine> list) {
        b bVar2;
        int i6;
        List<FlexLine> list2;
        int i7;
        int i8;
        int i9;
        int i10;
        int iMo3931h;
        int i11;
        int i12;
        int i13;
        boolean z2;
        int i14;
        int i15;
        int[] iArr;
        int i16;
        int i17;
        int i18;
        boolean z3;
        int minimumHeight;
        int i19;
        int i20 = i;
        boolean zMo3932i = this.f9181a.mo3932i();
        int mode = View.MeasureSpec.getMode(i);
        int size = View.MeasureSpec.getSize(i);
        List<FlexLine> arrayList = list == null ? new ArrayList<>() : list;
        bVar.f9186a = arrayList;
        boolean z4 = i5 == -1;
        int paddingStart = zMo3932i ? this.f9181a.getPaddingStart() : this.f9181a.getPaddingTop();
        int paddingEnd = zMo3932i ? this.f9181a.getPaddingEnd() : this.f9181a.getPaddingBottom();
        int paddingTop = zMo3932i ? this.f9181a.getPaddingTop() : this.f9181a.getPaddingStart();
        int paddingBottom = zMo3932i ? this.f9181a.getPaddingBottom() : this.f9181a.getPaddingEnd();
        FlexLine flexLine = new FlexLine();
        int i21 = i4;
        flexLine.f9177o = i21;
        int i22 = paddingStart + paddingEnd;
        flexLine.f9167e = i22;
        int flexItemCount = this.f9181a.getFlexItemCount();
        int i23 = Integer.MIN_VALUE;
        boolean z5 = z4;
        int i24 = 0;
        int i25 = 0;
        int i26 = 0;
        while (true) {
            if (i21 >= flexItemCount) {
                bVar2 = bVar;
                break;
            }
            int i27 = i24;
            View viewMo3926c = this.f9181a.mo3926c(i21);
            if (viewMo3926c == null) {
                if (m3957t(i21, flexItemCount, flexLine)) {
                    m3938a(arrayList, flexLine, i21, i26);
                }
                i6 = i25;
            } else {
                i6 = i25;
                if (viewMo3926c.getVisibility() == 8) {
                    flexLine.f9171i++;
                    flexLine.f9170h++;
                    if (m3957t(i21, flexItemCount, flexLine)) {
                        m3938a(arrayList, flexLine, i21, i26);
                    }
                } else {
                    if (viewMo3926c instanceof CompoundButton) {
                        CompoundButton compoundButton = (CompoundButton) viewMo3926c;
                        FlexItem flexItem = (FlexItem) compoundButton.getLayoutParams();
                        i7 = flexItemCount;
                        int iMo8955D = flexItem.mo8955D();
                        list2 = arrayList;
                        int iMo8964f0 = flexItem.mo8964f0();
                        Drawable buttonDrawable = CompoundButtonCompat.getButtonDrawable(compoundButton);
                        int minimumWidth = buttonDrawable == null ? 0 : buttonDrawable.getMinimumWidth();
                        if (buttonDrawable == null) {
                            i19 = -1;
                            minimumHeight = 0;
                        } else {
                            minimumHeight = buttonDrawable.getMinimumHeight();
                            i19 = -1;
                        }
                        if (iMo8955D == i19) {
                            iMo8955D = minimumWidth;
                        }
                        flexItem.mo8956H(iMo8955D);
                        if (iMo8964f0 == i19) {
                            iMo8964f0 = minimumHeight;
                        }
                        flexItem.mo8960O(iMo8964f0);
                    } else {
                        list2 = arrayList;
                        i7 = flexItemCount;
                    }
                    FlexItem flexItem2 = (FlexItem) viewMo3926c.getLayoutParams();
                    if (flexItem2.mo8968u() == 4) {
                        flexLine.f9176n.add(Integer.valueOf(i21));
                    }
                    int width = zMo3932i ? flexItem2.getWidth() : flexItem2.getHeight();
                    if (flexItem2.mo8962W() != -1.0f && mode == 1073741824) {
                        width = Math.round(flexItem2.mo8962W() * size);
                    }
                    if (zMo3932i) {
                        iMo3931h = this.f9181a.mo3927d(i20, m3954q(flexItem2, true) + m3956s(flexItem2, true) + i22, width);
                        i9 = size;
                        i8 = mode;
                        i10 = i2;
                        int iMo3931h2 = this.f9181a.mo3931h(i10, m3953p(flexItem2, true) + m3955r(flexItem2, true) + paddingTop + paddingBottom + i26, flexItem2.getHeight());
                        viewMo3926c.measure(iMo3931h, iMo3931h2);
                        m3937B(i21, iMo3931h, iMo3931h2, viewMo3926c);
                    } else {
                        i8 = mode;
                        i9 = size;
                        i10 = i2;
                        int iMo3927d = this.f9181a.mo3927d(i10, m3953p(flexItem2, false) + m3955r(flexItem2, false) + paddingTop + paddingBottom + i26, flexItem2.getWidth());
                        iMo3931h = this.f9181a.mo3931h(i20, m3954q(flexItem2, false) + m3956s(flexItem2, false) + i22, width);
                        viewMo3926c.measure(iMo3927d, iMo3931h);
                        m3937B(i21, iMo3927d, iMo3931h, viewMo3926c);
                    }
                    this.f9181a.mo3928e(i21, viewMo3926c);
                    m3940c(viewMo3926c, i21);
                    int iCombineMeasuredStates = View.combineMeasuredStates(i6, viewMo3926c.getMeasuredState());
                    int i28 = flexLine.f9167e;
                    int iM3954q = m3954q(flexItem2, zMo3932i) + m3956s(flexItem2, zMo3932i) + (zMo3932i ? viewMo3926c.getMeasuredWidth() : viewMo3926c.getMeasuredHeight());
                    int size2 = list2.size();
                    if (this.f9181a.getFlexWrap() != 0) {
                        if (flexItem2.mo8965j0()) {
                            i11 = iCombineMeasuredStates;
                            i12 = i27;
                            i13 = i9;
                        } else {
                            if (i8 != 0) {
                                int maxLine = this.f9181a.getMaxLine();
                                i11 = iCombineMeasuredStates;
                                if (maxLine == -1 || maxLine > size2 + 1) {
                                    i12 = i27;
                                    int iMo3930g = this.f9181a.mo3930g(viewMo3926c, i21, i12);
                                    if (iMo3930g > 0) {
                                        iM3954q += iMo3930g;
                                    }
                                    i13 = i9;
                                    if (i13 < i28 + iM3954q) {
                                    }
                                    if (z2) {
                                        if (flexLine.m3934a() > 0) {
                                            arrayList = list2;
                                            m3938a(arrayList, flexLine, i21 > 0 ? i21 - 1 : 0, i26);
                                            i26 += flexLine.f9169g;
                                        } else {
                                            arrayList = list2;
                                        }
                                        if (zMo3932i) {
                                            if (flexItem2.getHeight() == -1) {
                                                FlexContainer flexContainer = this.f9181a;
                                                viewMo3926c.measure(iMo3931h, flexContainer.mo3931h(i10, flexItem2.mo8957I() + flexItem2.mo8959N() + this.f9181a.getPaddingBottom() + flexContainer.getPaddingTop() + i26, flexItem2.getHeight()));
                                                m3940c(viewMo3926c, i21);
                                            }
                                        } else if (flexItem2.getWidth() == -1) {
                                            FlexContainer flexContainer2 = this.f9181a;
                                            viewMo3926c.measure(flexContainer2.mo3927d(i10, flexItem2.mo8963d0() + flexItem2.mo8958J() + this.f9181a.getPaddingRight() + flexContainer2.getPaddingLeft() + i26, flexItem2.getWidth()), iMo3931h);
                                            m3940c(viewMo3926c, i21);
                                        }
                                        flexLine = new FlexLine();
                                        flexLine.f9170h = 1;
                                        flexLine.f9167e = i22;
                                        flexLine.f9177o = i21;
                                        i14 = 0;
                                        i15 = Integer.MIN_VALUE;
                                    } else {
                                        arrayList = list2;
                                        flexLine.f9170h++;
                                        i14 = i12 + 1;
                                        i15 = i23;
                                    }
                                    flexLine.f9179q |= flexItem2.mo8961S() != 0.0f;
                                    flexLine.f9180r |= flexItem2.mo8969x() != 0.0f;
                                    iArr = this.f9183c;
                                    if (iArr != null) {
                                        iArr[i21] = arrayList.size();
                                    }
                                    flexLine.f9167e = m3954q(flexItem2, zMo3932i) + m3956s(flexItem2, zMo3932i) + (zMo3932i ? viewMo3926c.getMeasuredWidth() : viewMo3926c.getMeasuredHeight()) + flexLine.f9167e;
                                    flexLine.f9172j = flexItem2.mo8961S() + flexLine.f9172j;
                                    flexLine.f9173k = flexItem2.mo8969x() + flexLine.f9173k;
                                    this.f9181a.mo3924a(viewMo3926c, i21, i14, flexLine);
                                    i16 = i13;
                                    int iMax = Math.max(i15, this.f9181a.mo3933j(viewMo3926c) + m3953p(flexItem2, zMo3932i) + m3955r(flexItem2, zMo3932i) + (zMo3932i ? viewMo3926c.getMeasuredHeight() : viewMo3926c.getMeasuredWidth()));
                                    flexLine.f9169g = Math.max(flexLine.f9169g, iMax);
                                    if (zMo3932i) {
                                        if (this.f9181a.getFlexWrap() != 2) {
                                            flexLine.f9174l = Math.max(flexLine.f9174l, flexItem2.mo8959N() + viewMo3926c.getBaseline());
                                        } else {
                                            flexLine.f9174l = Math.max(flexLine.f9174l, flexItem2.mo8957I() + (viewMo3926c.getMeasuredHeight() - viewMo3926c.getBaseline()));
                                        }
                                    }
                                    i17 = i7;
                                    if (m3957t(i21, i17, flexLine)) {
                                        m3938a(arrayList, flexLine, i21, i26);
                                        i26 += flexLine.f9169g;
                                    }
                                    if (i5 != -1 || arrayList.size() <= 0 || arrayList.get(arrayList.size() - 1).f9178p < i5 || i21 < i5 || z5) {
                                        i18 = i3;
                                        z3 = z5;
                                    } else {
                                        i26 = -flexLine.f9169g;
                                        z3 = true;
                                        i18 = i3;
                                    }
                                    if (i26 <= i18 && z3) {
                                        bVar2 = bVar;
                                        i25 = i11;
                                        break;
                                    }
                                    i23 = iMax;
                                    i27 = i14;
                                    i25 = i11;
                                    i21++;
                                    i20 = i;
                                    flexItemCount = i17;
                                    z5 = z3;
                                    i24 = i27;
                                    size = i16;
                                    mode = i8;
                                }
                                z2 = false;
                                if (z2) {
                                }
                                flexLine.f9179q |= flexItem2.mo8961S() != 0.0f;
                                flexLine.f9180r |= flexItem2.mo8969x() != 0.0f;
                                iArr = this.f9183c;
                                if (iArr != null) {
                                }
                                flexLine.f9167e = m3954q(flexItem2, zMo3932i) + m3956s(flexItem2, zMo3932i) + (zMo3932i ? viewMo3926c.getMeasuredWidth() : viewMo3926c.getMeasuredHeight()) + flexLine.f9167e;
                                flexLine.f9172j = flexItem2.mo8961S() + flexLine.f9172j;
                                flexLine.f9173k = flexItem2.mo8969x() + flexLine.f9173k;
                                this.f9181a.mo3924a(viewMo3926c, i21, i14, flexLine);
                                i16 = i13;
                                int iMax2 = Math.max(i15, this.f9181a.mo3933j(viewMo3926c) + m3953p(flexItem2, zMo3932i) + m3955r(flexItem2, zMo3932i) + (zMo3932i ? viewMo3926c.getMeasuredHeight() : viewMo3926c.getMeasuredWidth()));
                                flexLine.f9169g = Math.max(flexLine.f9169g, iMax2);
                                if (zMo3932i) {
                                }
                                i17 = i7;
                                if (m3957t(i21, i17, flexLine)) {
                                }
                                if (i5 != -1) {
                                }
                                i18 = i3;
                                z3 = z5;
                                if (i26 <= i18) {
                                }
                                i23 = iMax2;
                                i27 = i14;
                                i25 = i11;
                                i21++;
                                i20 = i;
                                flexItemCount = i17;
                                z5 = z3;
                                i24 = i27;
                                size = i16;
                                mode = i8;
                            }
                            i12 = i27;
                            i13 = i9;
                            z2 = false;
                            if (z2) {
                            }
                            flexLine.f9179q |= flexItem2.mo8961S() != 0.0f;
                            flexLine.f9180r |= flexItem2.mo8969x() != 0.0f;
                            iArr = this.f9183c;
                            if (iArr != null) {
                            }
                            flexLine.f9167e = m3954q(flexItem2, zMo3932i) + m3956s(flexItem2, zMo3932i) + (zMo3932i ? viewMo3926c.getMeasuredWidth() : viewMo3926c.getMeasuredHeight()) + flexLine.f9167e;
                            flexLine.f9172j = flexItem2.mo8961S() + flexLine.f9172j;
                            flexLine.f9173k = flexItem2.mo8969x() + flexLine.f9173k;
                            this.f9181a.mo3924a(viewMo3926c, i21, i14, flexLine);
                            i16 = i13;
                            int iMax22 = Math.max(i15, this.f9181a.mo3933j(viewMo3926c) + m3953p(flexItem2, zMo3932i) + m3955r(flexItem2, zMo3932i) + (zMo3932i ? viewMo3926c.getMeasuredHeight() : viewMo3926c.getMeasuredWidth()));
                            flexLine.f9169g = Math.max(flexLine.f9169g, iMax22);
                            if (zMo3932i) {
                            }
                            i17 = i7;
                            if (m3957t(i21, i17, flexLine)) {
                            }
                            if (i5 != -1) {
                            }
                            i18 = i3;
                            z3 = z5;
                            if (i26 <= i18) {
                            }
                            i23 = iMax22;
                            i27 = i14;
                            i25 = i11;
                            i21++;
                            i20 = i;
                            flexItemCount = i17;
                            z5 = z3;
                            i24 = i27;
                            size = i16;
                            mode = i8;
                        }
                        z2 = true;
                        if (z2) {
                        }
                        flexLine.f9179q |= flexItem2.mo8961S() != 0.0f;
                        flexLine.f9180r |= flexItem2.mo8969x() != 0.0f;
                        iArr = this.f9183c;
                        if (iArr != null) {
                        }
                        flexLine.f9167e = m3954q(flexItem2, zMo3932i) + m3956s(flexItem2, zMo3932i) + (zMo3932i ? viewMo3926c.getMeasuredWidth() : viewMo3926c.getMeasuredHeight()) + flexLine.f9167e;
                        flexLine.f9172j = flexItem2.mo8961S() + flexLine.f9172j;
                        flexLine.f9173k = flexItem2.mo8969x() + flexLine.f9173k;
                        this.f9181a.mo3924a(viewMo3926c, i21, i14, flexLine);
                        i16 = i13;
                        int iMax222 = Math.max(i15, this.f9181a.mo3933j(viewMo3926c) + m3953p(flexItem2, zMo3932i) + m3955r(flexItem2, zMo3932i) + (zMo3932i ? viewMo3926c.getMeasuredHeight() : viewMo3926c.getMeasuredWidth()));
                        flexLine.f9169g = Math.max(flexLine.f9169g, iMax222);
                        if (zMo3932i) {
                        }
                        i17 = i7;
                        if (m3957t(i21, i17, flexLine)) {
                        }
                        if (i5 != -1) {
                        }
                        i18 = i3;
                        z3 = z5;
                        if (i26 <= i18) {
                        }
                        i23 = iMax222;
                        i27 = i14;
                        i25 = i11;
                        i21++;
                        i20 = i;
                        flexItemCount = i17;
                        z5 = z3;
                        i24 = i27;
                        size = i16;
                        mode = i8;
                    }
                    i11 = iCombineMeasuredStates;
                    i12 = i27;
                    i13 = i9;
                    z2 = false;
                    if (z2) {
                    }
                    flexLine.f9179q |= flexItem2.mo8961S() != 0.0f;
                    flexLine.f9180r |= flexItem2.mo8969x() != 0.0f;
                    iArr = this.f9183c;
                    if (iArr != null) {
                    }
                    flexLine.f9167e = m3954q(flexItem2, zMo3932i) + m3956s(flexItem2, zMo3932i) + (zMo3932i ? viewMo3926c.getMeasuredWidth() : viewMo3926c.getMeasuredHeight()) + flexLine.f9167e;
                    flexLine.f9172j = flexItem2.mo8961S() + flexLine.f9172j;
                    flexLine.f9173k = flexItem2.mo8969x() + flexLine.f9173k;
                    this.f9181a.mo3924a(viewMo3926c, i21, i14, flexLine);
                    i16 = i13;
                    int iMax2222 = Math.max(i15, this.f9181a.mo3933j(viewMo3926c) + m3953p(flexItem2, zMo3932i) + m3955r(flexItem2, zMo3932i) + (zMo3932i ? viewMo3926c.getMeasuredHeight() : viewMo3926c.getMeasuredWidth()));
                    flexLine.f9169g = Math.max(flexLine.f9169g, iMax2222);
                    if (zMo3932i) {
                    }
                    i17 = i7;
                    if (m3957t(i21, i17, flexLine)) {
                    }
                    if (i5 != -1) {
                    }
                    i18 = i3;
                    z3 = z5;
                    if (i26 <= i18) {
                    }
                    i23 = iMax2222;
                    i27 = i14;
                    i25 = i11;
                    i21++;
                    i20 = i;
                    flexItemCount = i17;
                    z5 = z3;
                    i24 = i27;
                    size = i16;
                    mode = i8;
                }
            }
            z3 = z5;
            i8 = mode;
            i16 = size;
            i17 = flexItemCount;
            i25 = i6;
            i10 = i2;
            i21++;
            i20 = i;
            flexItemCount = i17;
            z5 = z3;
            i24 = i27;
            size = i16;
            mode = i8;
        }
        bVar2.f9187b = i25;
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x002d  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0032  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0040  */
    /* JADX WARN: Removed duplicated region for block: B:20:? A[RETURN, SYNTHETIC] */
    /* JADX INFO: renamed from: c */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void m3940c(View view, int i) {
        boolean z2;
        FlexItem flexItem = (FlexItem) view.getLayoutParams();
        int measuredWidth = view.getMeasuredWidth();
        int measuredHeight = view.getMeasuredHeight();
        boolean z3 = true;
        if (measuredWidth < flexItem.mo8955D()) {
            measuredWidth = flexItem.mo8955D();
        } else {
            if (measuredWidth <= flexItem.mo8967t0()) {
                z2 = false;
                if (measuredHeight >= flexItem.mo8964f0()) {
                    measuredHeight = flexItem.mo8964f0();
                } else if (measuredHeight > flexItem.mo8966m0()) {
                    measuredHeight = flexItem.mo8966m0();
                } else {
                    z3 = z2;
                }
                if (z3) {
                    return;
                }
                int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(measuredWidth, BasicMeasure.EXACTLY);
                int iMakeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(measuredHeight, BasicMeasure.EXACTLY);
                view.measure(iMakeMeasureSpec, iMakeMeasureSpec2);
                m3937B(i, iMakeMeasureSpec, iMakeMeasureSpec2, view);
                this.f9181a.mo3928e(i, view);
                return;
            }
            measuredWidth = flexItem.mo8967t0();
        }
        z2 = true;
        if (measuredHeight >= flexItem.mo8964f0()) {
        }
        if (z3) {
        }
    }

    /* JADX INFO: renamed from: d */
    public void m3941d(List<FlexLine> list, int i) {
        int i2 = this.f9183c[i];
        if (i2 == -1) {
            i2 = 0;
        }
        for (int size = list.size() - 1; size >= i2; size--) {
            list.remove(size);
        }
        int[] iArr = this.f9183c;
        int length = iArr.length - 1;
        if (i > length) {
            Arrays.fill(iArr, -1);
        } else {
            Arrays.fill(iArr, i, length, -1);
        }
        long[] jArr = this.f9184d;
        int length2 = jArr.length - 1;
        if (i > length2) {
            Arrays.fill(jArr, 0L);
        } else {
            Arrays.fill(jArr, i, length2, 0L);
        }
    }

    /* JADX INFO: renamed from: e */
    public final List<FlexLine> m3942e(List<FlexLine> list, int i, int i2) {
        int i3 = (i - i2) / 2;
        ArrayList arrayList = new ArrayList();
        FlexLine flexLine = new FlexLine();
        flexLine.f9169g = i3;
        int size = list.size();
        for (int i4 = 0; i4 < size; i4++) {
            if (i4 == 0) {
                arrayList.add(flexLine);
            }
            arrayList.add(list.get(i4));
            if (i4 == list.size() - 1) {
                arrayList.add(flexLine);
            }
        }
        return arrayList;
    }

    @NonNull
    /* JADX INFO: renamed from: f */
    public final List<c> m3943f(int i) {
        ArrayList arrayList = new ArrayList(i);
        for (int i2 = 0; i2 < i; i2++) {
            FlexItem flexItem = (FlexItem) this.f9181a.mo3929f(i2).getLayoutParams();
            c cVar = new c(null);
            cVar.f9189k = flexItem.getOrder();
            cVar.f9188j = i2;
            arrayList.add(cVar);
        }
        return arrayList;
    }

    /* JADX INFO: renamed from: g */
    public void m3944g(int i, int i2, int i3) {
        int mode;
        int size;
        int flexDirection = this.f9181a.getFlexDirection();
        if (flexDirection == 0 || flexDirection == 1) {
            int mode2 = View.MeasureSpec.getMode(i2);
            int size2 = View.MeasureSpec.getSize(i2);
            mode = mode2;
            size = size2;
        } else {
            if (flexDirection != 2 && flexDirection != 3) {
                throw new IllegalArgumentException(outline.m871q("Invalid flex direction: ", flexDirection));
            }
            mode = View.MeasureSpec.getMode(i);
            size = View.MeasureSpec.getSize(i);
        }
        List<FlexLine> flexLinesInternal = this.f9181a.getFlexLinesInternal();
        if (mode == 1073741824) {
            int sumOfCrossSize = this.f9181a.getSumOfCrossSize() + i3;
            int i4 = 0;
            if (flexLinesInternal.size() == 1) {
                flexLinesInternal.get(0).f9169g = size - i3;
                return;
            }
            if (flexLinesInternal.size() >= 2) {
                int alignContent = this.f9181a.getAlignContent();
                if (alignContent == 1) {
                    int i5 = size - sumOfCrossSize;
                    FlexLine flexLine = new FlexLine();
                    flexLine.f9169g = i5;
                    flexLinesInternal.add(0, flexLine);
                    return;
                }
                if (alignContent == 2) {
                    this.f9181a.setFlexLines(m3942e(flexLinesInternal, size, sumOfCrossSize));
                    return;
                }
                if (alignContent == 3) {
                    if (sumOfCrossSize >= size) {
                        return;
                    }
                    float size3 = (size - sumOfCrossSize) / (flexLinesInternal.size() - 1);
                    ArrayList arrayList = new ArrayList();
                    int size4 = flexLinesInternal.size();
                    float f = 0.0f;
                    while (i4 < size4) {
                        arrayList.add(flexLinesInternal.get(i4));
                        if (i4 != flexLinesInternal.size() - 1) {
                            FlexLine flexLine2 = new FlexLine();
                            if (i4 == flexLinesInternal.size() - 2) {
                                flexLine2.f9169g = Math.round(f + size3);
                                f = 0.0f;
                            } else {
                                flexLine2.f9169g = Math.round(size3);
                            }
                            int i6 = flexLine2.f9169g;
                            float f2 = (size3 - i6) + f;
                            if (f2 > 1.0f) {
                                flexLine2.f9169g = i6 + 1;
                                f2 -= 1.0f;
                            } else if (f2 < -1.0f) {
                                flexLine2.f9169g = i6 - 1;
                                f2 += 1.0f;
                            }
                            arrayList.add(flexLine2);
                            f = f2;
                        }
                        i4++;
                    }
                    this.f9181a.setFlexLines(arrayList);
                    return;
                }
                if (alignContent == 4) {
                    if (sumOfCrossSize >= size) {
                        this.f9181a.setFlexLines(m3942e(flexLinesInternal, size, sumOfCrossSize));
                        return;
                    }
                    int size5 = (size - sumOfCrossSize) / (flexLinesInternal.size() * 2);
                    ArrayList arrayList2 = new ArrayList();
                    FlexLine flexLine3 = new FlexLine();
                    flexLine3.f9169g = size5;
                    for (FlexLine flexLine4 : flexLinesInternal) {
                        arrayList2.add(flexLine3);
                        arrayList2.add(flexLine4);
                        arrayList2.add(flexLine3);
                    }
                    this.f9181a.setFlexLines(arrayList2);
                    return;
                }
                if (alignContent == 5 && sumOfCrossSize < size) {
                    float size6 = (size - sumOfCrossSize) / flexLinesInternal.size();
                    int size7 = flexLinesInternal.size();
                    float f3 = 0.0f;
                    while (i4 < size7) {
                        FlexLine flexLine5 = flexLinesInternal.get(i4);
                        float f4 = flexLine5.f9169g + size6;
                        if (i4 == flexLinesInternal.size() - 1) {
                            f4 += f3;
                            f3 = 0.0f;
                        }
                        int iRound = Math.round(f4);
                        float f5 = (f4 - iRound) + f3;
                        if (f5 > 1.0f) {
                            iRound++;
                            f5 -= 1.0f;
                        } else if (f5 < -1.0f) {
                            iRound--;
                            f5 += 1.0f;
                        }
                        f3 = f5;
                        flexLine5.f9169g = iRound;
                        i4++;
                    }
                }
            }
        }
    }

    /* JADX INFO: renamed from: h */
    public void m3945h(int i, int i2, int i3) {
        int size;
        int paddingLeft;
        int paddingRight;
        int flexItemCount = this.f9181a.getFlexItemCount();
        boolean[] zArr = this.f9182b;
        if (zArr == null) {
            if (flexItemCount < 10) {
                flexItemCount = 10;
            }
            this.f9182b = new boolean[flexItemCount];
        } else if (zArr.length < flexItemCount) {
            int length = zArr.length * 2;
            if (length >= flexItemCount) {
                flexItemCount = length;
            }
            this.f9182b = new boolean[flexItemCount];
        } else {
            Arrays.fill(zArr, false);
        }
        if (i3 >= this.f9181a.getFlexItemCount()) {
            return;
        }
        int flexDirection = this.f9181a.getFlexDirection();
        int flexDirection2 = this.f9181a.getFlexDirection();
        if (flexDirection2 == 0 || flexDirection2 == 1) {
            int mode = View.MeasureSpec.getMode(i);
            size = View.MeasureSpec.getSize(i);
            int largestMainSize = this.f9181a.getLargestMainSize();
            if (mode != 1073741824 && largestMainSize <= size) {
                size = largestMainSize;
            }
            paddingLeft = this.f9181a.getPaddingLeft();
            paddingRight = this.f9181a.getPaddingRight();
        } else {
            if (flexDirection2 != 2 && flexDirection2 != 3) {
                throw new IllegalArgumentException(outline.m871q("Invalid flex direction: ", flexDirection));
            }
            int mode2 = View.MeasureSpec.getMode(i2);
            size = View.MeasureSpec.getSize(i2);
            if (mode2 != 1073741824) {
                size = this.f9181a.getLargestMainSize();
            }
            paddingLeft = this.f9181a.getPaddingTop();
            paddingRight = this.f9181a.getPaddingBottom();
        }
        int i4 = paddingRight + paddingLeft;
        int[] iArr = this.f9183c;
        List<FlexLine> flexLinesInternal = this.f9181a.getFlexLinesInternal();
        int size2 = flexLinesInternal.size();
        for (int i5 = iArr != null ? iArr[i3] : 0; i5 < size2; i5++) {
            FlexLine flexLine = flexLinesInternal.get(i5);
            int i6 = flexLine.f9167e;
            if (i6 < size && flexLine.f9179q) {
                m3949l(i, i2, flexLine, size, i4, false);
            } else if (i6 > size && flexLine.f9180r) {
                m3960w(i, i2, flexLine, size, i4, false);
            }
        }
    }

    /* JADX INFO: renamed from: i */
    public void m3946i(int i) {
        int[] iArr = this.f9183c;
        if (iArr == null) {
            if (i < 10) {
                i = 10;
            }
            this.f9183c = new int[i];
        } else if (iArr.length < i) {
            int length = iArr.length * 2;
            if (length >= i) {
                i = length;
            }
            this.f9183c = Arrays.copyOf(iArr, i);
        }
    }

    /* JADX INFO: renamed from: j */
    public void m3947j(int i) {
        long[] jArr = this.f9184d;
        if (jArr == null) {
            if (i < 10) {
                i = 10;
            }
            this.f9184d = new long[i];
        } else if (jArr.length < i) {
            int length = jArr.length * 2;
            if (length >= i) {
                i = length;
            }
            this.f9184d = Arrays.copyOf(jArr, i);
        }
    }

    /* JADX INFO: renamed from: k */
    public void m3948k(int i) {
        long[] jArr = this.f9185e;
        if (jArr == null) {
            if (i < 10) {
                i = 10;
            }
            this.f9185e = new long[i];
        } else if (jArr.length < i) {
            int length = jArr.length * 2;
            if (length >= i) {
                i = length;
            }
            this.f9185e = Arrays.copyOf(jArr, i);
        }
    }

    /* JADX INFO: renamed from: l */
    public final void m3949l(int i, int i2, FlexLine flexLine, int i3, int i4, boolean z2) {
        int i5;
        int i6;
        int iMax;
        double d;
        int i7;
        double d2;
        float f = flexLine.f9172j;
        float f2 = 0.0f;
        if (f <= 0.0f || i3 < (i5 = flexLine.f9167e)) {
            return;
        }
        float f3 = (i3 - i5) / f;
        flexLine.f9167e = i4 + flexLine.f9168f;
        if (!z2) {
            flexLine.f9169g = Integer.MIN_VALUE;
        }
        int i8 = 0;
        boolean z3 = false;
        int i9 = 0;
        float f4 = 0.0f;
        while (i8 < flexLine.f9170h) {
            int i10 = flexLine.f9177o + i8;
            View viewMo3926c = this.f9181a.mo3926c(i10);
            if (viewMo3926c == null || viewMo3926c.getVisibility() == 8) {
                i6 = i5;
            } else {
                FlexItem flexItem = (FlexItem) viewMo3926c.getLayoutParams();
                int flexDirection = this.f9181a.getFlexDirection();
                if (flexDirection == 0 || flexDirection == 1) {
                    int i11 = i5;
                    int measuredWidth = viewMo3926c.getMeasuredWidth();
                    long[] jArr = this.f9185e;
                    if (jArr != null) {
                        measuredWidth = (int) jArr[i10];
                    }
                    int measuredHeight = viewMo3926c.getMeasuredHeight();
                    long[] jArr2 = this.f9185e;
                    i6 = i11;
                    if (jArr2 != null) {
                        measuredHeight = m3950m(jArr2[i10]);
                    }
                    if (!this.f9182b[i10] && flexItem.mo8961S() > 0.0f) {
                        float fMo8961S = (flexItem.mo8961S() * f3) + measuredWidth;
                        if (i8 == flexLine.f9170h - 1) {
                            fMo8961S += f4;
                            f4 = 0.0f;
                        }
                        int iRound = Math.round(fMo8961S);
                        if (iRound > flexItem.mo8967t0()) {
                            iRound = flexItem.mo8967t0();
                            this.f9182b[i10] = true;
                            flexLine.f9172j -= flexItem.mo8961S();
                            z3 = true;
                        } else {
                            float f5 = (fMo8961S - iRound) + f4;
                            double d3 = f5;
                            if (d3 > 1.0d) {
                                iRound++;
                                d = d3 - 1.0d;
                            } else {
                                if (d3 < -1.0d) {
                                    iRound--;
                                    d = d3 + 1.0d;
                                }
                                f4 = f5;
                            }
                            f5 = (float) d;
                            f4 = f5;
                        }
                        int iM3951n = m3951n(i2, flexItem, flexLine.f9175m);
                        int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(iRound, BasicMeasure.EXACTLY);
                        viewMo3926c.measure(iMakeMeasureSpec, iM3951n);
                        int measuredWidth2 = viewMo3926c.getMeasuredWidth();
                        int measuredHeight2 = viewMo3926c.getMeasuredHeight();
                        m3937B(i10, iMakeMeasureSpec, iM3951n, viewMo3926c);
                        this.f9181a.mo3928e(i10, viewMo3926c);
                        measuredWidth = measuredWidth2;
                        measuredHeight = measuredHeight2;
                    }
                    int iMax2 = Math.max(i9, this.f9181a.mo3933j(viewMo3926c) + flexItem.mo8957I() + flexItem.mo8959N() + measuredHeight);
                    flexLine.f9167e = flexItem.mo8963d0() + flexItem.mo8958J() + measuredWidth + flexLine.f9167e;
                    iMax = iMax2;
                } else {
                    int measuredHeight3 = viewMo3926c.getMeasuredHeight();
                    long[] jArr3 = this.f9185e;
                    if (jArr3 != null) {
                        measuredHeight3 = m3950m(jArr3[i10]);
                    }
                    int measuredWidth3 = viewMo3926c.getMeasuredWidth();
                    long[] jArr4 = this.f9185e;
                    if (jArr4 != null) {
                        measuredWidth3 = (int) jArr4[i10];
                    }
                    if (this.f9182b[i10] || flexItem.mo8961S() <= f2) {
                        i7 = i5;
                    } else {
                        float fMo8961S2 = (flexItem.mo8961S() * f3) + measuredHeight3;
                        if (i8 == flexLine.f9170h - 1) {
                            fMo8961S2 += f4;
                            f4 = 0.0f;
                        }
                        int iRound2 = Math.round(fMo8961S2);
                        if (iRound2 > flexItem.mo8966m0()) {
                            iRound2 = flexItem.mo8966m0();
                            this.f9182b[i10] = true;
                            flexLine.f9172j -= flexItem.mo8961S();
                            i7 = i5;
                            z3 = true;
                        } else {
                            float f6 = (fMo8961S2 - iRound2) + f4;
                            i7 = i5;
                            double d4 = f6;
                            if (d4 > 1.0d) {
                                iRound2++;
                                d2 = d4 - 1.0d;
                            } else if (d4 < -1.0d) {
                                iRound2--;
                                d2 = d4 + 1.0d;
                            } else {
                                f4 = f6;
                            }
                            f4 = (float) d2;
                        }
                        int iM3952o = m3952o(i, flexItem, flexLine.f9175m);
                        int iMakeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(iRound2, BasicMeasure.EXACTLY);
                        viewMo3926c.measure(iM3952o, iMakeMeasureSpec2);
                        measuredWidth3 = viewMo3926c.getMeasuredWidth();
                        int measuredHeight4 = viewMo3926c.getMeasuredHeight();
                        m3937B(i10, iM3952o, iMakeMeasureSpec2, viewMo3926c);
                        this.f9181a.mo3928e(i10, viewMo3926c);
                        measuredHeight3 = measuredHeight4;
                    }
                    iMax = Math.max(i9, this.f9181a.mo3933j(viewMo3926c) + flexItem.mo8963d0() + flexItem.mo8958J() + measuredWidth3);
                    flexLine.f9167e = flexItem.mo8957I() + flexItem.mo8959N() + measuredHeight3 + flexLine.f9167e;
                    i6 = i7;
                }
                flexLine.f9169g = Math.max(flexLine.f9169g, iMax);
                i9 = iMax;
            }
            i8++;
            i5 = i6;
            f2 = 0.0f;
        }
        int i12 = i5;
        if (!z3 || i12 == flexLine.f9167e) {
            return;
        }
        m3949l(i, i2, flexLine, i3, i4, true);
    }

    /* JADX INFO: renamed from: m */
    public int m3950m(long j) {
        return (int) (j >> 32);
    }

    /* JADX INFO: renamed from: n */
    public final int m3951n(int i, FlexItem flexItem, int i2) {
        FlexContainer flexContainer = this.f9181a;
        int iMo3931h = flexContainer.mo3931h(i, flexItem.mo8957I() + flexItem.mo8959N() + this.f9181a.getPaddingBottom() + flexContainer.getPaddingTop() + i2, flexItem.getHeight());
        int size = View.MeasureSpec.getSize(iMo3931h);
        return size > flexItem.mo8966m0() ? View.MeasureSpec.makeMeasureSpec(flexItem.mo8966m0(), View.MeasureSpec.getMode(iMo3931h)) : size < flexItem.mo8964f0() ? View.MeasureSpec.makeMeasureSpec(flexItem.mo8964f0(), View.MeasureSpec.getMode(iMo3931h)) : iMo3931h;
    }

    /* JADX INFO: renamed from: o */
    public final int m3952o(int i, FlexItem flexItem, int i2) {
        FlexContainer flexContainer = this.f9181a;
        int iMo3927d = flexContainer.mo3927d(i, flexItem.mo8963d0() + flexItem.mo8958J() + this.f9181a.getPaddingRight() + flexContainer.getPaddingLeft() + i2, flexItem.getWidth());
        int size = View.MeasureSpec.getSize(iMo3927d);
        return size > flexItem.mo8967t0() ? View.MeasureSpec.makeMeasureSpec(flexItem.mo8967t0(), View.MeasureSpec.getMode(iMo3927d)) : size < flexItem.mo8955D() ? View.MeasureSpec.makeMeasureSpec(flexItem.mo8955D(), View.MeasureSpec.getMode(iMo3927d)) : iMo3927d;
    }

    /* JADX INFO: renamed from: p */
    public final int m3953p(FlexItem flexItem, boolean z2) {
        return z2 ? flexItem.mo8957I() : flexItem.mo8963d0();
    }

    /* JADX INFO: renamed from: q */
    public final int m3954q(FlexItem flexItem, boolean z2) {
        return z2 ? flexItem.mo8963d0() : flexItem.mo8957I();
    }

    /* JADX INFO: renamed from: r */
    public final int m3955r(FlexItem flexItem, boolean z2) {
        return z2 ? flexItem.mo8959N() : flexItem.mo8958J();
    }

    /* JADX INFO: renamed from: s */
    public final int m3956s(FlexItem flexItem, boolean z2) {
        return z2 ? flexItem.mo8958J() : flexItem.mo8959N();
    }

    /* JADX INFO: renamed from: t */
    public final boolean m3957t(int i, int i2, FlexLine flexLine) {
        return i == i2 - 1 && flexLine.m3934a() != 0;
    }

    /* JADX INFO: renamed from: u */
    public void m3958u(View view, FlexLine flexLine, int i, int i2, int i3, int i4) {
        FlexItem flexItem = (FlexItem) view.getLayoutParams();
        int alignItems = this.f9181a.getAlignItems();
        if (flexItem.mo8968u() != -1) {
            alignItems = flexItem.mo8968u();
        }
        int i5 = flexLine.f9169g;
        if (alignItems != 0) {
            if (alignItems == 1) {
                if (this.f9181a.getFlexWrap() != 2) {
                    int i6 = i2 + i5;
                    view.layout(i, (i6 - view.getMeasuredHeight()) - flexItem.mo8957I(), i3, i6 - flexItem.mo8957I());
                    return;
                }
                view.layout(i, flexItem.mo8959N() + view.getMeasuredHeight() + (i2 - i5), i3, flexItem.mo8959N() + view.getMeasuredHeight() + (i4 - i5));
                return;
            }
            if (alignItems == 2) {
                int iMo8959N = ((flexItem.mo8959N() + (i5 - view.getMeasuredHeight())) - flexItem.mo8957I()) / 2;
                if (this.f9181a.getFlexWrap() != 2) {
                    int i7 = i2 + iMo8959N;
                    view.layout(i, i7, i3, view.getMeasuredHeight() + i7);
                    return;
                } else {
                    int i8 = i2 - iMo8959N;
                    view.layout(i, i8, i3, view.getMeasuredHeight() + i8);
                    return;
                }
            }
            if (alignItems == 3) {
                if (this.f9181a.getFlexWrap() != 2) {
                    int iMax = Math.max(flexLine.f9174l - view.getBaseline(), flexItem.mo8959N());
                    view.layout(i, i2 + iMax, i3, i4 + iMax);
                    return;
                } else {
                    int iMax2 = Math.max(view.getBaseline() + (flexLine.f9174l - view.getMeasuredHeight()), flexItem.mo8957I());
                    view.layout(i, i2 - iMax2, i3, i4 - iMax2);
                    return;
                }
            }
            if (alignItems != 4) {
                return;
            }
        }
        if (this.f9181a.getFlexWrap() != 2) {
            view.layout(i, flexItem.mo8959N() + i2, i3, flexItem.mo8959N() + i4);
        } else {
            view.layout(i, i2 - flexItem.mo8957I(), i3, i4 - flexItem.mo8957I());
        }
    }

    /* JADX INFO: renamed from: v */
    public void m3959v(View view, FlexLine flexLine, boolean z2, int i, int i2, int i3, int i4) {
        FlexItem flexItem = (FlexItem) view.getLayoutParams();
        int alignItems = this.f9181a.getAlignItems();
        if (flexItem.mo8968u() != -1) {
            alignItems = flexItem.mo8968u();
        }
        int i5 = flexLine.f9169g;
        if (alignItems != 0) {
            if (alignItems == 1) {
                if (!z2) {
                    view.layout(((i + i5) - view.getMeasuredWidth()) - flexItem.mo8963d0(), i2, ((i3 + i5) - view.getMeasuredWidth()) - flexItem.mo8963d0(), i4);
                    return;
                }
                view.layout(flexItem.mo8958J() + view.getMeasuredWidth() + (i - i5), i2, flexItem.mo8958J() + view.getMeasuredWidth() + (i3 - i5), i4);
                return;
            }
            if (alignItems == 2) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
                int marginStart = ((MarginLayoutParamsCompat.getMarginStart(marginLayoutParams) + (i5 - view.getMeasuredWidth())) - MarginLayoutParamsCompat.getMarginEnd(marginLayoutParams)) / 2;
                if (z2) {
                    view.layout(i - marginStart, i2, i3 - marginStart, i4);
                    return;
                } else {
                    view.layout(i + marginStart, i2, i3 + marginStart, i4);
                    return;
                }
            }
            if (alignItems != 3 && alignItems != 4) {
                return;
            }
        }
        if (z2) {
            view.layout(i - flexItem.mo8963d0(), i2, i3 - flexItem.mo8963d0(), i4);
        } else {
            view.layout(flexItem.mo8958J() + i, i2, flexItem.mo8958J() + i3, i4);
        }
    }

    /* JADX INFO: renamed from: w */
    public final void m3960w(int i, int i2, FlexLine flexLine, int i3, int i4, boolean z2) {
        int i5;
        int i6;
        int iMax;
        int iMo8955D;
        int i7 = flexLine.f9167e;
        float f = flexLine.f9173k;
        float f2 = 0.0f;
        if (f <= 0.0f || i3 > i7) {
            return;
        }
        float f3 = (i7 - i3) / f;
        flexLine.f9167e = i4 + flexLine.f9168f;
        if (!z2) {
            flexLine.f9169g = Integer.MIN_VALUE;
        }
        int i8 = 0;
        boolean z3 = false;
        int i9 = 0;
        float f4 = 0.0f;
        while (i8 < flexLine.f9170h) {
            int i10 = flexLine.f9177o + i8;
            View viewMo3926c = this.f9181a.mo3926c(i10);
            if (viewMo3926c == null || viewMo3926c.getVisibility() == 8) {
                i5 = i7;
                i6 = i8;
            } else {
                FlexItem flexItem = (FlexItem) viewMo3926c.getLayoutParams();
                int flexDirection = this.f9181a.getFlexDirection();
                if (flexDirection == 0 || flexDirection == 1) {
                    i5 = i7;
                    int i11 = i8;
                    int measuredWidth = viewMo3926c.getMeasuredWidth();
                    long[] jArr = this.f9185e;
                    if (jArr != null) {
                        measuredWidth = (int) jArr[i10];
                    }
                    int measuredHeight = viewMo3926c.getMeasuredHeight();
                    long[] jArr2 = this.f9185e;
                    if (jArr2 != null) {
                        measuredHeight = m3950m(jArr2[i10]);
                    }
                    if (this.f9182b[i10] || flexItem.mo8969x() <= 0.0f) {
                        i6 = i11;
                    } else {
                        float fMo8969x = measuredWidth - (flexItem.mo8969x() * f3);
                        i6 = i11;
                        if (i6 == flexLine.f9170h - 1) {
                            fMo8969x += f4;
                            f4 = 0.0f;
                        }
                        int iRound = Math.round(fMo8969x);
                        if (iRound < flexItem.mo8955D()) {
                            iMo8955D = flexItem.mo8955D();
                            this.f9182b[i10] = true;
                            flexLine.f9173k -= flexItem.mo8969x();
                            z3 = true;
                        } else {
                            float f5 = (fMo8969x - iRound) + f4;
                            double d = f5;
                            if (d > 1.0d) {
                                iRound++;
                                f5 -= 1.0f;
                            } else if (d < -1.0d) {
                                iRound--;
                                f5 += 1.0f;
                            }
                            f4 = f5;
                            iMo8955D = iRound;
                        }
                        int iM3951n = m3951n(i2, flexItem, flexLine.f9175m);
                        int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(iMo8955D, BasicMeasure.EXACTLY);
                        viewMo3926c.measure(iMakeMeasureSpec, iM3951n);
                        int measuredWidth2 = viewMo3926c.getMeasuredWidth();
                        int measuredHeight2 = viewMo3926c.getMeasuredHeight();
                        m3937B(i10, iMakeMeasureSpec, iM3951n, viewMo3926c);
                        this.f9181a.mo3928e(i10, viewMo3926c);
                        measuredWidth = measuredWidth2;
                        measuredHeight = measuredHeight2;
                    }
                    int iMax2 = Math.max(i9, this.f9181a.mo3933j(viewMo3926c) + flexItem.mo8957I() + flexItem.mo8959N() + measuredHeight);
                    flexLine.f9167e = flexItem.mo8963d0() + flexItem.mo8958J() + measuredWidth + flexLine.f9167e;
                    iMax = iMax2;
                } else {
                    int measuredHeight3 = viewMo3926c.getMeasuredHeight();
                    long[] jArr3 = this.f9185e;
                    if (jArr3 != null) {
                        measuredHeight3 = m3950m(jArr3[i10]);
                    }
                    int measuredWidth3 = viewMo3926c.getMeasuredWidth();
                    long[] jArr4 = this.f9185e;
                    if (jArr4 != null) {
                        measuredWidth3 = (int) jArr4[i10];
                    }
                    if (this.f9182b[i10] || flexItem.mo8969x() <= f2) {
                        i5 = i7;
                        i6 = i8;
                    } else {
                        float fMo8969x2 = measuredHeight3 - (flexItem.mo8969x() * f3);
                        if (i8 == flexLine.f9170h - 1) {
                            fMo8969x2 += f4;
                            f4 = 0.0f;
                        }
                        int iRound2 = Math.round(fMo8969x2);
                        if (iRound2 < flexItem.mo8964f0()) {
                            int iMo8964f0 = flexItem.mo8964f0();
                            this.f9182b[i10] = true;
                            flexLine.f9173k -= flexItem.mo8969x();
                            i6 = i8;
                            iRound2 = iMo8964f0;
                            z3 = true;
                            i5 = i7;
                        } else {
                            float f6 = (fMo8969x2 - iRound2) + f4;
                            i5 = i7;
                            i6 = i8;
                            double d2 = f6;
                            if (d2 > 1.0d) {
                                iRound2++;
                                f6 -= 1.0f;
                            } else if (d2 < -1.0d) {
                                iRound2--;
                                f6 += 1.0f;
                            }
                            f4 = f6;
                        }
                        int iM3952o = m3952o(i, flexItem, flexLine.f9175m);
                        int iMakeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(iRound2, BasicMeasure.EXACTLY);
                        viewMo3926c.measure(iM3952o, iMakeMeasureSpec2);
                        measuredWidth3 = viewMo3926c.getMeasuredWidth();
                        int measuredHeight4 = viewMo3926c.getMeasuredHeight();
                        m3937B(i10, iM3952o, iMakeMeasureSpec2, viewMo3926c);
                        this.f9181a.mo3928e(i10, viewMo3926c);
                        measuredHeight3 = measuredHeight4;
                    }
                    iMax = Math.max(i9, this.f9181a.mo3933j(viewMo3926c) + flexItem.mo8963d0() + flexItem.mo8958J() + measuredWidth3);
                    flexLine.f9167e = flexItem.mo8957I() + flexItem.mo8959N() + measuredHeight3 + flexLine.f9167e;
                }
                flexLine.f9169g = Math.max(flexLine.f9169g, iMax);
                i9 = iMax;
            }
            i8 = i6 + 1;
            i7 = i5;
            f2 = 0.0f;
        }
        int i12 = i7;
        if (!z3 || i12 == flexLine.f9167e) {
            return;
        }
        m3960w(i, i2, flexLine, i3, i4, true);
    }

    /* JADX INFO: renamed from: x */
    public final int[] m3961x(int i, List<c> list, SparseIntArray sparseIntArray) {
        Collections.sort(list);
        sparseIntArray.clear();
        int[] iArr = new int[i];
        int i2 = 0;
        for (c cVar : list) {
            int i3 = cVar.f9188j;
            iArr[i2] = i3;
            sparseIntArray.append(i3, cVar.f9189k);
            i2++;
        }
        return iArr;
    }

    /* JADX INFO: renamed from: y */
    public final void m3962y(View view, int i, int i2) {
        FlexItem flexItem = (FlexItem) view.getLayoutParams();
        int iMin = Math.min(Math.max(((i - flexItem.mo8958J()) - flexItem.mo8963d0()) - this.f9181a.mo3933j(view), flexItem.mo8955D()), flexItem.mo8967t0());
        long[] jArr = this.f9185e;
        int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(jArr != null ? m3950m(jArr[i2]) : view.getMeasuredHeight(), BasicMeasure.EXACTLY);
        int iMakeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(iMin, BasicMeasure.EXACTLY);
        view.measure(iMakeMeasureSpec2, iMakeMeasureSpec);
        m3937B(i2, iMakeMeasureSpec2, iMakeMeasureSpec, view);
        this.f9181a.mo3928e(i2, view);
    }

    /* JADX INFO: renamed from: z */
    public final void m3963z(View view, int i, int i2) {
        FlexItem flexItem = (FlexItem) view.getLayoutParams();
        int iMin = Math.min(Math.max(((i - flexItem.mo8959N()) - flexItem.mo8957I()) - this.f9181a.mo3933j(view), flexItem.mo8964f0()), flexItem.mo8966m0());
        long[] jArr = this.f9185e;
        int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(jArr != null ? (int) jArr[i2] : view.getMeasuredWidth(), BasicMeasure.EXACTLY);
        int iMakeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(iMin, BasicMeasure.EXACTLY);
        view.measure(iMakeMeasureSpec, iMakeMeasureSpec2);
        m3937B(i2, iMakeMeasureSpec, iMakeMeasureSpec2, view);
        this.f9181a.mo3928e(i2, view);
    }
}
