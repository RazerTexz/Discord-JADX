package p007b.p225i.p226a.p287e;

import android.view.View;
import com.google.android.flexbox.FlexItem;
import java.util.ArrayList;
import java.util.List;

/* compiled from: FlexLine.java */
/* renamed from: b.i.a.e.b, reason: use source file name */
/* loaded from: classes3.dex */
public class FlexLine {

    /* renamed from: e */
    public int f9167e;

    /* renamed from: f */
    public int f9168f;

    /* renamed from: g */
    public int f9169g;

    /* renamed from: h */
    public int f9170h;

    /* renamed from: i */
    public int f9171i;

    /* renamed from: j */
    public float f9172j;

    /* renamed from: k */
    public float f9173k;

    /* renamed from: l */
    public int f9174l;

    /* renamed from: m */
    public int f9175m;

    /* renamed from: o */
    public int f9177o;

    /* renamed from: p */
    public int f9178p;

    /* renamed from: q */
    public boolean f9179q;

    /* renamed from: r */
    public boolean f9180r;

    /* renamed from: a */
    public int f9163a = Integer.MAX_VALUE;

    /* renamed from: b */
    public int f9164b = Integer.MAX_VALUE;

    /* renamed from: c */
    public int f9165c = Integer.MIN_VALUE;

    /* renamed from: d */
    public int f9166d = Integer.MIN_VALUE;

    /* renamed from: n */
    public List<Integer> f9176n = new ArrayList();

    /* renamed from: a */
    public int m3934a() {
        return this.f9170h - this.f9171i;
    }

    /* renamed from: b */
    public void m3935b(View view, int i, int i2, int i3, int i4) {
        FlexItem flexItem = (FlexItem) view.getLayoutParams();
        this.f9163a = Math.min(this.f9163a, (view.getLeft() - flexItem.mo8958J()) - i);
        this.f9164b = Math.min(this.f9164b, (view.getTop() - flexItem.mo8959N()) - i2);
        this.f9165c = Math.max(this.f9165c, flexItem.mo8963d0() + view.getRight() + i3);
        this.f9166d = Math.max(this.f9166d, flexItem.mo8957I() + view.getBottom() + i4);
    }
}
