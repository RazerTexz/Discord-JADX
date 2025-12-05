package p007b.p225i.p226a.p242c.p267x2.p274i0;

import com.discord.widgets.chat.input.MentionUtils;
import java.util.ArrayList;
import java.util.List;
import p007b.p225i.p355b.p356a.CharMatcher;
import p007b.p225i.p355b.p356a.Splitter2;
import p007b.p225i.p355b.p356a.Splitter3;

/* compiled from: SefReader.java */
/* renamed from: b.i.a.c.x2.i0.k, reason: use source file name */
/* loaded from: classes3.dex */
public final class SefReader {

    /* renamed from: a */
    public static final Splitter3 f8452a = new Splitter3(new Splitter2(new CharMatcher.b(MentionUtils.EMOJIS_AND_STICKERS_CHAR)));

    /* renamed from: b */
    public static final Splitter3 f8453b = new Splitter3(new Splitter2(new CharMatcher.b('*')));

    /* renamed from: c */
    public final List<a> f8454c = new ArrayList();

    /* renamed from: d */
    public int f8455d = 0;

    /* renamed from: e */
    public int f8456e;

    /* compiled from: SefReader.java */
    /* renamed from: b.i.a.c.x2.i0.k$a */
    public static final class a {

        /* renamed from: a */
        public final long f8457a;

        /* renamed from: b */
        public final int f8458b;

        public a(int i, long j, int i2) {
            this.f8457a = j;
            this.f8458b = i2;
        }
    }
}
