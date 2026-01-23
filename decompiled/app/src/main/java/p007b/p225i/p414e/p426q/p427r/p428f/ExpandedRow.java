package p007b.p225i.p414e.p426q.p427r.p428f;

import java.util.ArrayList;
import java.util.List;
import p007b.p100d.p104b.p105a.outline;

/* JADX INFO: renamed from: b.i.e.q.r.f.b, reason: use source file name */
/* JADX INFO: compiled from: ExpandedRow.java */
/* JADX INFO: loaded from: classes3.dex */
public final class ExpandedRow {

    /* JADX INFO: renamed from: a */
    public final List<ExpandedPair> f13424a;

    /* JADX INFO: renamed from: b */
    public final int f13425b;

    /* JADX INFO: renamed from: c */
    public final boolean f13426c;

    public ExpandedRow(List<ExpandedPair> list, int i, boolean z2) {
        this.f13424a = new ArrayList(list);
        this.f13425b = i;
        this.f13426c = z2;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof ExpandedRow)) {
            return false;
        }
        ExpandedRow expandedRow = (ExpandedRow) obj;
        return this.f13424a.equals(expandedRow.f13424a) && this.f13426c == expandedRow.f13426c;
    }

    public int hashCode() {
        return this.f13424a.hashCode() ^ Boolean.valueOf(this.f13426c).hashCode();
    }

    public String toString() {
        return outline.m824L(new StringBuilder("{ "), this.f13424a, " }");
    }
}
