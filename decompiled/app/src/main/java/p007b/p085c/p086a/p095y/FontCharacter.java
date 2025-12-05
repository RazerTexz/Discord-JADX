package p007b.p085c.p086a.p095y;

import androidx.annotation.RestrictTo;
import java.util.List;
import p007b.p085c.p086a.p095y.p097l.ShapeGroup;
import p007b.p100d.p104b.p105a.outline;

/* compiled from: FontCharacter.java */
@RestrictTo({RestrictTo.Scope.LIBRARY})
/* renamed from: b.c.a.y.e, reason: use source file name */
/* loaded from: classes.dex */
public class FontCharacter {

    /* renamed from: a */
    public final List<ShapeGroup> f2707a;

    /* renamed from: b */
    public final char f2708b;

    /* renamed from: c */
    public final double f2709c;

    /* renamed from: d */
    public final String f2710d;

    /* renamed from: e */
    public final String f2711e;

    public FontCharacter(List<ShapeGroup> list, char c, double d, double d2, String str, String str2) {
        this.f2707a = list;
        this.f2708b = c;
        this.f2709c = d2;
        this.f2710d = str;
        this.f2711e = str2;
    }

    /* renamed from: a */
    public static int m765a(char c, String str, String str2) {
        return str2.hashCode() + outline.m863m(str, (c + 0) * 31, 31);
    }

    public int hashCode() {
        return m765a(this.f2708b, this.f2711e, this.f2710d);
    }
}
