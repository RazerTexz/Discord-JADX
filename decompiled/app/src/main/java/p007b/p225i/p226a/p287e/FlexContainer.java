package p007b.p225i.p226a.p287e;

import android.view.View;
import java.util.List;

/* compiled from: FlexContainer.java */
/* renamed from: b.i.a.e.a, reason: use source file name */
/* loaded from: classes3.dex */
public interface FlexContainer {
    /* renamed from: a */
    void mo3924a(View view, int i, int i2, FlexLine flexLine);

    /* renamed from: b */
    void mo3925b(FlexLine flexLine);

    /* renamed from: c */
    View mo3926c(int i);

    /* renamed from: d */
    int mo3927d(int i, int i2, int i3);

    /* renamed from: e */
    void mo3928e(int i, View view);

    /* renamed from: f */
    View mo3929f(int i);

    /* renamed from: g */
    int mo3930g(View view, int i, int i2);

    int getAlignContent();

    int getAlignItems();

    int getFlexDirection();

    int getFlexItemCount();

    List<FlexLine> getFlexLinesInternal();

    int getFlexWrap();

    int getLargestMainSize();

    int getMaxLine();

    int getPaddingBottom();

    int getPaddingEnd();

    int getPaddingLeft();

    int getPaddingRight();

    int getPaddingStart();

    int getPaddingTop();

    int getSumOfCrossSize();

    /* renamed from: h */
    int mo3931h(int i, int i2, int i3);

    /* renamed from: i */
    boolean mo3932i();

    /* renamed from: j */
    int mo3933j(View view);

    void setFlexLines(List<FlexLine> list);
}
