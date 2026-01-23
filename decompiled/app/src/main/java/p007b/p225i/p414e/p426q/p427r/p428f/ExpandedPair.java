package p007b.p225i.p414e.p426q.p427r.p428f;

import p007b.p225i.p414e.p426q.p427r.DataCharacter;
import p007b.p225i.p414e.p426q.p427r.FinderPattern;

/* JADX INFO: renamed from: b.i.e.q.r.f.a, reason: use source file name */
/* JADX INFO: compiled from: ExpandedPair.java */
/* JADX INFO: loaded from: classes3.dex */
public final class ExpandedPair {

    /* JADX INFO: renamed from: a */
    public final DataCharacter f13421a;

    /* JADX INFO: renamed from: b */
    public final DataCharacter f13422b;

    /* JADX INFO: renamed from: c */
    public final FinderPattern f13423c;

    public ExpandedPair(DataCharacter dataCharacter, DataCharacter dataCharacter2, FinderPattern finderPattern, boolean z2) {
        this.f13421a = dataCharacter;
        this.f13422b = dataCharacter2;
        this.f13423c = finderPattern;
    }

    /* JADX INFO: renamed from: a */
    public static boolean m7018a(Object obj, Object obj2) {
        return obj == null ? obj2 == null : obj.equals(obj2);
    }

    /* JADX INFO: renamed from: b */
    public static int m7019b(Object obj) {
        if (obj == null) {
            return 0;
        }
        return obj.hashCode();
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof ExpandedPair)) {
            return false;
        }
        ExpandedPair expandedPair = (ExpandedPair) obj;
        return m7018a(this.f13421a, expandedPair.f13421a) && m7018a(this.f13422b, expandedPair.f13422b) && m7018a(this.f13423c, expandedPair.f13423c);
    }

    public int hashCode() {
        return (m7019b(this.f13421a) ^ m7019b(this.f13422b)) ^ m7019b(this.f13423c);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("[ ");
        sb.append(this.f13421a);
        sb.append(" , ");
        sb.append(this.f13422b);
        sb.append(" : ");
        FinderPattern finderPattern = this.f13423c;
        sb.append(finderPattern == null ? "null" : Integer.valueOf(finderPattern.f13407a));
        sb.append(" ]");
        return sb.toString();
    }
}
