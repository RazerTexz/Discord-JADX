package p007b.p225i.p226a.p242c;

import android.net.Uri;
import androidx.annotation.IntRange;
import androidx.annotation.Nullable;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.UUID;
import p007b.p085c.p086a.p087a0.AnimatableValueParser;
import p007b.p225i.p226a.p242c.Bundleable;
import p007b.p225i.p226a.p242c.p259f3.Util2;
import p007b.p225i.p226a.p288f.p299e.p308o.C3404f;
import p007b.p225i.p355b.p357b.AbstractIndexedListIterator;
import p007b.p225i.p355b.p357b.ImmutableCollection;
import p007b.p225i.p355b.p357b.ImmutableList2;
import p007b.p225i.p355b.p357b.ImmutableMap2;
import p007b.p225i.p355b.p357b.RegularImmutableList;
import p007b.p225i.p355b.p357b.RegularImmutableMap;

/* compiled from: MediaItem.java */
/* renamed from: b.i.a.c.o1, reason: use source file name */
/* loaded from: classes3.dex */
public final class MediaItem2 implements Bundleable {

    /* renamed from: j */
    public static final Bundleable.a<MediaItem2> f7261j;

    /* renamed from: k */
    public final String f7262k;

    /* renamed from: l */
    @Nullable
    public final h f7263l;

    /* renamed from: m */
    public final g f7264m;

    /* renamed from: n */
    public final MediaMetadata f7265n;

    /* renamed from: o */
    public final d f7266o;

    /* compiled from: MediaItem.java */
    /* renamed from: b.i.a.c.o1$b */
    public static final class b {
    }

    /* compiled from: MediaItem.java */
    /* renamed from: b.i.a.c.o1$c */
    public static final class c {

        /* renamed from: a */
        @Nullable
        public String f7267a;

        /* renamed from: b */
        @Nullable
        public Uri f7268b;

        /* renamed from: c */
        @Nullable
        public String f7269c;

        /* renamed from: g */
        @Nullable
        public String f7273g;

        /* renamed from: i */
        @Nullable
        public Object f7275i;

        /* renamed from: j */
        @Nullable
        public MediaMetadata f7276j;

        /* renamed from: d */
        public d.a f7270d = new d.a();

        /* renamed from: e */
        public f.a f7271e = new f.a(null);

        /* renamed from: f */
        public List<?> f7272f = Collections.emptyList();

        /* renamed from: h */
        public ImmutableList2<k> f7274h = RegularImmutableList.f12012l;

        /* renamed from: k */
        public g.a f7277k = new g.a();

        /* renamed from: a */
        public MediaItem2 m3320a() {
            i iVar;
            f.a aVar = this.f7271e;
            AnimatableValueParser.m426D(aVar.f7299b == null || aVar.f7298a != null);
            Uri uri = this.f7268b;
            if (uri != null) {
                String str = this.f7269c;
                f.a aVar2 = this.f7271e;
                iVar = new i(uri, str, aVar2.f7298a != null ? new f(aVar2, null) : null, null, this.f7272f, this.f7273g, this.f7274h, this.f7275i, null);
            } else {
                iVar = null;
            }
            String str2 = this.f7267a;
            if (str2 == null) {
                str2 = "";
            }
            String str3 = str2;
            e eVarM3322a = this.f7270d.m3322a();
            g.a aVar3 = this.f7277k;
            Objects.requireNonNull(aVar3);
            g gVar = new g(aVar3, null);
            MediaMetadata mediaMetadata = this.f7276j;
            if (mediaMetadata == null) {
                mediaMetadata = MediaMetadata.f7368j;
            }
            return new MediaItem2(str3, eVarM3322a, iVar, gVar, mediaMetadata, null);
        }
    }

    /* compiled from: MediaItem.java */
    /* renamed from: b.i.a.c.o1$d */
    public static class d implements Bundleable {

        /* renamed from: j */
        public static final Bundleable.a<e> f7278j;

        /* renamed from: k */
        @IntRange(from = 0)
        public final long f7279k;

        /* renamed from: l */
        public final long f7280l;

        /* renamed from: m */
        public final boolean f7281m;

        /* renamed from: n */
        public final boolean f7282n;

        /* renamed from: o */
        public final boolean f7283o;

        /* compiled from: MediaItem.java */
        /* renamed from: b.i.a.c.o1$d$a */
        public static final class a {

            /* renamed from: a */
            public long f7284a;

            /* renamed from: b */
            public long f7285b = Long.MIN_VALUE;

            /* renamed from: c */
            public boolean f7286c;

            /* renamed from: d */
            public boolean f7287d;

            /* renamed from: e */
            public boolean f7288e;

            @Deprecated
            /* renamed from: a */
            public e m3322a() {
                return new e(this, null);
            }
        }

        static {
            new a().m3322a();
            f7278j = C2806i0.f7120a;
        }

        public d(a aVar, a aVar2) {
            this.f7279k = aVar.f7284a;
            this.f7280l = aVar.f7285b;
            this.f7281m = aVar.f7286c;
            this.f7282n = aVar.f7287d;
            this.f7283o = aVar.f7288e;
        }

        /* renamed from: a */
        public static String m3321a(int i) {
            return Integer.toString(i, 36);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof d)) {
                return false;
            }
            d dVar = (d) obj;
            return this.f7279k == dVar.f7279k && this.f7280l == dVar.f7280l && this.f7281m == dVar.f7281m && this.f7282n == dVar.f7282n && this.f7283o == dVar.f7283o;
        }

        public int hashCode() {
            long j = this.f7279k;
            int i = ((int) (j ^ (j >>> 32))) * 31;
            long j2 = this.f7280l;
            return ((((((i + ((int) (j2 ^ (j2 >>> 32)))) * 31) + (this.f7281m ? 1 : 0)) * 31) + (this.f7282n ? 1 : 0)) * 31) + (this.f7283o ? 1 : 0);
        }
    }

    /* compiled from: MediaItem.java */
    @Deprecated
    /* renamed from: b.i.a.c.o1$e */
    public static final class e extends d {

        /* renamed from: p */
        public static final e f7289p = new d.a().m3322a();

        public e(d.a aVar, a aVar2) {
            super(aVar, null);
        }
    }

    /* compiled from: MediaItem.java */
    /* renamed from: b.i.a.c.o1$f */
    public static final class f {

        /* renamed from: a */
        public final UUID f7290a;

        /* renamed from: b */
        @Nullable
        public final Uri f7291b;

        /* renamed from: c */
        public final ImmutableMap2<String, String> f7292c;

        /* renamed from: d */
        public final boolean f7293d;

        /* renamed from: e */
        public final boolean f7294e;

        /* renamed from: f */
        public final boolean f7295f;

        /* renamed from: g */
        public final ImmutableList2<Integer> f7296g;

        /* renamed from: h */
        @Nullable
        public final byte[] f7297h;

        /* compiled from: MediaItem.java */
        /* renamed from: b.i.a.c.o1$f$a */
        public static final class a {

            /* renamed from: a */
            @Nullable
            public UUID f7298a;

            /* renamed from: b */
            @Nullable
            public Uri f7299b;

            /* renamed from: c */
            public ImmutableMap2<String, String> f7300c = RegularImmutableMap.f12015m;

            /* renamed from: d */
            public boolean f7301d;

            /* renamed from: e */
            public boolean f7302e;

            /* renamed from: f */
            public boolean f7303f;

            /* renamed from: g */
            public ImmutableList2<Integer> f7304g;

            /* renamed from: h */
            @Nullable
            public byte[] f7305h;

            public a(a aVar) {
                AbstractIndexedListIterator<Object> abstractIndexedListIterator = ImmutableList2.f12045k;
                this.f7304g = RegularImmutableList.f12012l;
            }
        }

        public f(a aVar, a aVar2) {
            AnimatableValueParser.m426D((aVar.f7303f && aVar.f7299b == null) ? false : true);
            UUID uuid = aVar.f7298a;
            Objects.requireNonNull(uuid);
            this.f7290a = uuid;
            this.f7291b = aVar.f7299b;
            this.f7292c = aVar.f7300c;
            this.f7293d = aVar.f7301d;
            this.f7295f = aVar.f7303f;
            this.f7294e = aVar.f7302e;
            this.f7296g = aVar.f7304g;
            byte[] bArr = aVar.f7305h;
            this.f7297h = bArr != null ? Arrays.copyOf(bArr, bArr.length) : null;
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof f)) {
                return false;
            }
            f fVar = (f) obj;
            return this.f7290a.equals(fVar.f7290a) && Util2.m2993a(this.f7291b, fVar.f7291b) && Util2.m2993a(this.f7292c, fVar.f7292c) && this.f7293d == fVar.f7293d && this.f7295f == fVar.f7295f && this.f7294e == fVar.f7294e && this.f7296g.equals(fVar.f7296g) && Arrays.equals(this.f7297h, fVar.f7297h);
        }

        public int hashCode() {
            int iHashCode = this.f7290a.hashCode() * 31;
            Uri uri = this.f7291b;
            return Arrays.hashCode(this.f7297h) + ((this.f7296g.hashCode() + ((((((((this.f7292c.hashCode() + ((iHashCode + (uri != null ? uri.hashCode() : 0)) * 31)) * 31) + (this.f7293d ? 1 : 0)) * 31) + (this.f7295f ? 1 : 0)) * 31) + (this.f7294e ? 1 : 0)) * 31)) * 31);
        }
    }

    /* compiled from: MediaItem.java */
    /* renamed from: b.i.a.c.o1$h */
    public static class h {

        /* renamed from: a */
        public final Uri f7318a;

        /* renamed from: b */
        @Nullable
        public final String f7319b;

        /* renamed from: c */
        @Nullable
        public final f f7320c;

        /* renamed from: d */
        public final List<?> f7321d;

        /* renamed from: e */
        @Nullable
        public final String f7322e;

        /* renamed from: f */
        public final ImmutableList2<k> f7323f;

        /* renamed from: g */
        @Nullable
        public final Object f7324g;

        /* JADX WARN: Multi-variable type inference failed */
        public h(Uri uri, String str, f fVar, b bVar, List list, String str2, ImmutableList2 immutableList2, Object obj, a aVar) {
            this.f7318a = uri;
            this.f7319b = str;
            this.f7320c = fVar;
            this.f7321d = list;
            this.f7322e = str2;
            this.f7323f = immutableList2;
            AbstractIndexedListIterator<Object> abstractIndexedListIterator = ImmutableList2.f12045k;
            C3404f.m4189A(4, "initialCapacity");
            Object[] objArrCopyOf = new Object[4];
            int i = 0;
            int i2 = 0;
            while (i < immutableList2.size()) {
                j jVar = new j(new k.a((k) immutableList2.get(i), null), null);
                int i3 = i2 + 1;
                if (objArrCopyOf.length < i3) {
                    objArrCopyOf = Arrays.copyOf(objArrCopyOf, ImmutableCollection.b.m6260a(objArrCopyOf.length, i3));
                }
                objArrCopyOf[i2] = jVar;
                i++;
                i2 = i3;
            }
            ImmutableList2.m6262l(objArrCopyOf, i2);
            this.f7324g = obj;
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof h)) {
                return false;
            }
            h hVar = (h) obj;
            return this.f7318a.equals(hVar.f7318a) && Util2.m2993a(this.f7319b, hVar.f7319b) && Util2.m2993a(this.f7320c, hVar.f7320c) && Util2.m2993a(null, null) && this.f7321d.equals(hVar.f7321d) && Util2.m2993a(this.f7322e, hVar.f7322e) && this.f7323f.equals(hVar.f7323f) && Util2.m2993a(this.f7324g, hVar.f7324g);
        }

        public int hashCode() {
            int iHashCode = this.f7318a.hashCode() * 31;
            String str = this.f7319b;
            int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
            f fVar = this.f7320c;
            int iHashCode3 = (this.f7321d.hashCode() + ((((iHashCode2 + (fVar == null ? 0 : fVar.hashCode())) * 31) + 0) * 31)) * 31;
            String str2 = this.f7322e;
            int iHashCode4 = (this.f7323f.hashCode() + ((iHashCode3 + (str2 == null ? 0 : str2.hashCode())) * 31)) * 31;
            Object obj = this.f7324g;
            return iHashCode4 + (obj != null ? obj.hashCode() : 0);
        }
    }

    /* compiled from: MediaItem.java */
    @Deprecated
    /* renamed from: b.i.a.c.o1$i */
    public static final class i extends h {
        public i(Uri uri, String str, f fVar, b bVar, List list, String str2, ImmutableList2 immutableList2, Object obj, a aVar) {
            super(uri, str, fVar, null, list, str2, immutableList2, obj, null);
        }
    }

    /* compiled from: MediaItem.java */
    @Deprecated
    /* renamed from: b.i.a.c.o1$j */
    public static final class j extends k {
        public j(k.a aVar, a aVar2) {
            super(aVar, null);
        }
    }

    /* compiled from: MediaItem.java */
    /* renamed from: b.i.a.c.o1$k */
    public static class k {

        /* renamed from: a */
        public final Uri f7325a;

        /* renamed from: b */
        @Nullable
        public final String f7326b;

        /* renamed from: c */
        @Nullable
        public final String f7327c;

        /* renamed from: d */
        public final int f7328d;

        /* renamed from: e */
        public final int f7329e;

        /* renamed from: f */
        @Nullable
        public final String f7330f;

        /* compiled from: MediaItem.java */
        /* renamed from: b.i.a.c.o1$k$a */
        public static final class a {

            /* renamed from: a */
            public Uri f7331a;

            /* renamed from: b */
            @Nullable
            public String f7332b;

            /* renamed from: c */
            @Nullable
            public String f7333c;

            /* renamed from: d */
            public int f7334d;

            /* renamed from: e */
            public int f7335e;

            /* renamed from: f */
            @Nullable
            public String f7336f;

            public a(k kVar, a aVar) {
                this.f7331a = kVar.f7325a;
                this.f7332b = kVar.f7326b;
                this.f7333c = kVar.f7327c;
                this.f7334d = kVar.f7328d;
                this.f7335e = kVar.f7329e;
                this.f7336f = kVar.f7330f;
            }
        }

        public k(a aVar, a aVar2) {
            this.f7325a = aVar.f7331a;
            this.f7326b = aVar.f7332b;
            this.f7327c = aVar.f7333c;
            this.f7328d = aVar.f7334d;
            this.f7329e = aVar.f7335e;
            this.f7330f = aVar.f7336f;
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof k)) {
                return false;
            }
            k kVar = (k) obj;
            return this.f7325a.equals(kVar.f7325a) && Util2.m2993a(this.f7326b, kVar.f7326b) && Util2.m2993a(this.f7327c, kVar.f7327c) && this.f7328d == kVar.f7328d && this.f7329e == kVar.f7329e && Util2.m2993a(this.f7330f, kVar.f7330f);
        }

        public int hashCode() {
            int iHashCode = this.f7325a.hashCode() * 31;
            String str = this.f7326b;
            int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
            String str2 = this.f7327c;
            int iHashCode3 = (((((iHashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31) + this.f7328d) * 31) + this.f7329e) * 31;
            String str3 = this.f7330f;
            return iHashCode3 + (str3 != null ? str3.hashCode() : 0);
        }
    }

    static {
        new c().m3320a();
        f7261j = C2814k0.f7194a;
    }

    public MediaItem2(String str, e eVar, @Nullable i iVar, g gVar, MediaMetadata mediaMetadata) {
        this.f7262k = str;
        this.f7263l = null;
        this.f7264m = gVar;
        this.f7265n = mediaMetadata;
        this.f7266o = eVar;
    }

    /* renamed from: a */
    public static String m3319a(int i2) {
        return Integer.toString(i2, 36);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof MediaItem2)) {
            return false;
        }
        MediaItem2 mediaItem2 = (MediaItem2) obj;
        return Util2.m2993a(this.f7262k, mediaItem2.f7262k) && this.f7266o.equals(mediaItem2.f7266o) && Util2.m2993a(this.f7263l, mediaItem2.f7263l) && Util2.m2993a(this.f7264m, mediaItem2.f7264m) && Util2.m2993a(this.f7265n, mediaItem2.f7265n);
    }

    public int hashCode() {
        int iHashCode = this.f7262k.hashCode() * 31;
        h hVar = this.f7263l;
        return this.f7265n.hashCode() + ((this.f7266o.hashCode() + ((this.f7264m.hashCode() + ((iHashCode + (hVar != null ? hVar.hashCode() : 0)) * 31)) * 31)) * 31);
    }

    public MediaItem2(String str, e eVar, i iVar, g gVar, MediaMetadata mediaMetadata, a aVar) {
        this.f7262k = str;
        this.f7263l = iVar;
        this.f7264m = gVar;
        this.f7265n = mediaMetadata;
        this.f7266o = eVar;
    }

    /* compiled from: MediaItem.java */
    /* renamed from: b.i.a.c.o1$g */
    public static final class g implements Bundleable {

        /* renamed from: j */
        public static final g f7306j = new a().m3324a();

        /* renamed from: k */
        public static final Bundleable.a<g> f7307k = C2810j0.f7124a;

        /* renamed from: l */
        public final long f7308l;

        /* renamed from: m */
        public final long f7309m;

        /* renamed from: n */
        public final long f7310n;

        /* renamed from: o */
        public final float f7311o;

        /* renamed from: p */
        public final float f7312p;

        /* compiled from: MediaItem.java */
        /* renamed from: b.i.a.c.o1$g$a */
        public static final class a {

            /* renamed from: a */
            public long f7313a = -9223372036854775807L;

            /* renamed from: b */
            public long f7314b = -9223372036854775807L;

            /* renamed from: c */
            public long f7315c = -9223372036854775807L;

            /* renamed from: d */
            public float f7316d = -3.4028235E38f;

            /* renamed from: e */
            public float f7317e = -3.4028235E38f;

            /* renamed from: a */
            public g m3324a() {
                return new g(this, null);
            }
        }

        public g(a aVar, a aVar2) {
            long j = aVar.f7313a;
            long j2 = aVar.f7314b;
            long j3 = aVar.f7315c;
            float f = aVar.f7316d;
            float f2 = aVar.f7317e;
            this.f7308l = j;
            this.f7309m = j2;
            this.f7310n = j3;
            this.f7311o = f;
            this.f7312p = f2;
        }

        /* renamed from: a */
        public static String m3323a(int i) {
            return Integer.toString(i, 36);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof g)) {
                return false;
            }
            g gVar = (g) obj;
            return this.f7308l == gVar.f7308l && this.f7309m == gVar.f7309m && this.f7310n == gVar.f7310n && this.f7311o == gVar.f7311o && this.f7312p == gVar.f7312p;
        }

        public int hashCode() {
            long j = this.f7308l;
            long j2 = this.f7309m;
            int i = ((((int) (j ^ (j >>> 32))) * 31) + ((int) (j2 ^ (j2 >>> 32)))) * 31;
            long j3 = this.f7310n;
            int i2 = (i + ((int) (j3 ^ (j3 >>> 32)))) * 31;
            float f = this.f7311o;
            int iFloatToIntBits = (i2 + (f != 0.0f ? Float.floatToIntBits(f) : 0)) * 31;
            float f2 = this.f7312p;
            return iFloatToIntBits + (f2 != 0.0f ? Float.floatToIntBits(f2) : 0);
        }

        @Deprecated
        public g(long j, long j2, long j3, float f, float f2) {
            this.f7308l = j;
            this.f7309m = j2;
            this.f7310n = j3;
            this.f7311o = f;
            this.f7312p = f2;
        }
    }
}
