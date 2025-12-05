package p007b.p225i.p226a.p242c.p256d3;

import android.text.Html;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

/* compiled from: SpannedToHtmlConverter.java */
/* renamed from: b.i.a.c.d3.m, reason: use source file name */
/* loaded from: classes3.dex */
public final class SpannedToHtmlConverter {

    /* renamed from: a */
    public static final Pattern f6357a = Pattern.compile("(&#13;)?&#10;");

    /* compiled from: SpannedToHtmlConverter.java */
    /* renamed from: b.i.a.c.d3.m$b */
    public static class b {

        /* renamed from: a */
        public final String f6358a;

        /* renamed from: b */
        public final Map<String, String> f6359b;

        public b(String str, Map map, a aVar) {
            this.f6358a = str;
            this.f6359b = map;
        }
    }

    /* compiled from: SpannedToHtmlConverter.java */
    /* renamed from: b.i.a.c.d3.m$c */
    public static final class c {

        /* renamed from: a */
        public final int f6360a;

        /* renamed from: b */
        public final int f6361b;

        /* renamed from: c */
        public final String f6362c;

        /* renamed from: d */
        public final String f6363d;

        public c(int i, int i2, String str, String str2, a aVar) {
            this.f6360a = i;
            this.f6361b = i2;
            this.f6362c = str;
            this.f6363d = str2;
        }
    }

    /* compiled from: SpannedToHtmlConverter.java */
    /* renamed from: b.i.a.c.d3.m$d */
    public static final class d {

        /* renamed from: a */
        public final List<c> f6364a = new ArrayList();

        /* renamed from: b */
        public final List<c> f6365b = new ArrayList();
    }

    /* renamed from: a */
    public static String m2759a(CharSequence charSequence) {
        return f6357a.matcher(Html.escapeHtml(charSequence)).replaceAll("<br>");
    }
}
