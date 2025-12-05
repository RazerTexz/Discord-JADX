package p007b.p225i.p355b.p356a;

import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.Arrays;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* compiled from: MoreObjects.java */
/* renamed from: b.i.b.a.g, reason: use source file name */
/* loaded from: classes3.dex */
public final class MoreObjects2 {

    /* renamed from: a */
    public final String f11950a;

    /* renamed from: b */
    public final a f11951b;

    /* renamed from: c */
    public a f11952c;

    /* compiled from: MoreObjects.java */
    /* renamed from: b.i.b.a.g$a */
    public static final class a {

        /* renamed from: a */
        @NullableDecl
        public String f11953a;

        /* renamed from: b */
        @NullableDecl
        public Object f11954b;

        /* renamed from: c */
        @NullableDecl
        public a f11955c;

        public a(MoreObjects moreObjects) {
        }
    }

    public MoreObjects2(String str, MoreObjects moreObjects) {
        a aVar = new a(null);
        this.f11951b = aVar;
        this.f11952c = aVar;
        this.f11950a = str;
    }

    @CanIgnoreReturnValue
    /* renamed from: a */
    public MoreObjects2 m6214a(String str, int i) {
        String strValueOf = String.valueOf(i);
        a aVar = new a(null);
        this.f11952c.f11955c = aVar;
        this.f11952c = aVar;
        aVar.f11954b = strValueOf;
        aVar.f11953a = str;
        return this;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(32);
        sb.append(this.f11950a);
        sb.append('{');
        a aVar = this.f11951b.f11955c;
        String str = "";
        while (aVar != null) {
            Object obj = aVar.f11954b;
            sb.append(str);
            String str2 = aVar.f11953a;
            if (str2 != null) {
                sb.append(str2);
                sb.append('=');
            }
            if (obj == null || !obj.getClass().isArray()) {
                sb.append(obj);
            } else {
                String strDeepToString = Arrays.deepToString(new Object[]{obj});
                sb.append((CharSequence) strDeepToString, 1, strDeepToString.length() - 1);
            }
            aVar = aVar.f11955c;
            str = ", ";
        }
        sb.append('}');
        return sb.toString();
    }
}
