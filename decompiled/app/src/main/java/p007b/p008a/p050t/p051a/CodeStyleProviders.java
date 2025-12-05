package p007b.p008a.p050t.p051a;

import com.discord.simpleast.core.node.StyleNode;
import p007b.p100d.p104b.p105a.outline;
import p507d0.p592z.p594d.Intrinsics3;

/* compiled from: CodeStyleProviders.kt */
/* renamed from: b.a.t.a.f, reason: use source file name */
/* loaded from: classes.dex */
public final class CodeStyleProviders<R> {

    /* renamed from: a */
    public final StyleNode.InterfaceC5656a<R> f1906a;

    /* renamed from: b */
    public final StyleNode.InterfaceC5656a<R> f1907b;

    /* renamed from: c */
    public final StyleNode.InterfaceC5656a<R> f1908c;

    /* renamed from: d */
    public final StyleNode.InterfaceC5656a<R> f1909d;

    /* renamed from: e */
    public final StyleNode.InterfaceC5656a<R> f1910e;

    /* renamed from: f */
    public final StyleNode.InterfaceC5656a<R> f1911f;

    /* renamed from: g */
    public final StyleNode.InterfaceC5656a<R> f1912g;

    /* renamed from: h */
    public final StyleNode.InterfaceC5656a<R> f1913h;

    public CodeStyleProviders(StyleNode.InterfaceC5656a<R> interfaceC5656a, StyleNode.InterfaceC5656a<R> interfaceC5656a2, StyleNode.InterfaceC5656a<R> interfaceC5656a3, StyleNode.InterfaceC5656a<R> interfaceC5656a4, StyleNode.InterfaceC5656a<R> interfaceC5656a5, StyleNode.InterfaceC5656a<R> interfaceC5656a6, StyleNode.InterfaceC5656a<R> interfaceC5656a7, StyleNode.InterfaceC5656a<R> interfaceC5656a8) {
        Intrinsics3.checkNotNullParameter(interfaceC5656a, "defaultStyleProvider");
        Intrinsics3.checkNotNullParameter(interfaceC5656a2, "commentStyleProvider");
        Intrinsics3.checkNotNullParameter(interfaceC5656a3, "literalStyleProvider");
        Intrinsics3.checkNotNullParameter(interfaceC5656a4, "keywordStyleProvider");
        Intrinsics3.checkNotNullParameter(interfaceC5656a5, "identifierStyleProvider");
        Intrinsics3.checkNotNullParameter(interfaceC5656a6, "typesStyleProvider");
        Intrinsics3.checkNotNullParameter(interfaceC5656a7, "genericsStyleProvider");
        Intrinsics3.checkNotNullParameter(interfaceC5656a8, "paramsStyleProvider");
        this.f1906a = interfaceC5656a;
        this.f1907b = interfaceC5656a2;
        this.f1908c = interfaceC5656a3;
        this.f1909d = interfaceC5656a4;
        this.f1910e = interfaceC5656a5;
        this.f1911f = interfaceC5656a6;
        this.f1912g = interfaceC5656a7;
        this.f1913h = interfaceC5656a8;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CodeStyleProviders)) {
            return false;
        }
        CodeStyleProviders codeStyleProviders = (CodeStyleProviders) obj;
        return Intrinsics3.areEqual(this.f1906a, codeStyleProviders.f1906a) && Intrinsics3.areEqual(this.f1907b, codeStyleProviders.f1907b) && Intrinsics3.areEqual(this.f1908c, codeStyleProviders.f1908c) && Intrinsics3.areEqual(this.f1909d, codeStyleProviders.f1909d) && Intrinsics3.areEqual(this.f1910e, codeStyleProviders.f1910e) && Intrinsics3.areEqual(this.f1911f, codeStyleProviders.f1911f) && Intrinsics3.areEqual(this.f1912g, codeStyleProviders.f1912g) && Intrinsics3.areEqual(this.f1913h, codeStyleProviders.f1913h);
    }

    public int hashCode() {
        StyleNode.InterfaceC5656a<R> interfaceC5656a = this.f1906a;
        int iHashCode = (interfaceC5656a != null ? interfaceC5656a.hashCode() : 0) * 31;
        StyleNode.InterfaceC5656a<R> interfaceC5656a2 = this.f1907b;
        int iHashCode2 = (iHashCode + (interfaceC5656a2 != null ? interfaceC5656a2.hashCode() : 0)) * 31;
        StyleNode.InterfaceC5656a<R> interfaceC5656a3 = this.f1908c;
        int iHashCode3 = (iHashCode2 + (interfaceC5656a3 != null ? interfaceC5656a3.hashCode() : 0)) * 31;
        StyleNode.InterfaceC5656a<R> interfaceC5656a4 = this.f1909d;
        int iHashCode4 = (iHashCode3 + (interfaceC5656a4 != null ? interfaceC5656a4.hashCode() : 0)) * 31;
        StyleNode.InterfaceC5656a<R> interfaceC5656a5 = this.f1910e;
        int iHashCode5 = (iHashCode4 + (interfaceC5656a5 != null ? interfaceC5656a5.hashCode() : 0)) * 31;
        StyleNode.InterfaceC5656a<R> interfaceC5656a6 = this.f1911f;
        int iHashCode6 = (iHashCode5 + (interfaceC5656a6 != null ? interfaceC5656a6.hashCode() : 0)) * 31;
        StyleNode.InterfaceC5656a<R> interfaceC5656a7 = this.f1912g;
        int iHashCode7 = (iHashCode6 + (interfaceC5656a7 != null ? interfaceC5656a7.hashCode() : 0)) * 31;
        StyleNode.InterfaceC5656a<R> interfaceC5656a8 = this.f1913h;
        return iHashCode7 + (interfaceC5656a8 != null ? interfaceC5656a8.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbM833U = outline.m833U("CodeStyleProviders(defaultStyleProvider=");
        sbM833U.append(this.f1906a);
        sbM833U.append(", commentStyleProvider=");
        sbM833U.append(this.f1907b);
        sbM833U.append(", literalStyleProvider=");
        sbM833U.append(this.f1908c);
        sbM833U.append(", keywordStyleProvider=");
        sbM833U.append(this.f1909d);
        sbM833U.append(", identifierStyleProvider=");
        sbM833U.append(this.f1910e);
        sbM833U.append(", typesStyleProvider=");
        sbM833U.append(this.f1911f);
        sbM833U.append(", genericsStyleProvider=");
        sbM833U.append(this.f1912g);
        sbM833U.append(", paramsStyleProvider=");
        sbM833U.append(this.f1913h);
        sbM833U.append(")");
        return sbM833U.toString();
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public CodeStyleProviders() {
        CodeStyleProviders2 codeStyleProviders2 = CodeStyleProviders2.f1914a;
        this(codeStyleProviders2, codeStyleProviders2, codeStyleProviders2, codeStyleProviders2, codeStyleProviders2, codeStyleProviders2, codeStyleProviders2, codeStyleProviders2);
    }
}
