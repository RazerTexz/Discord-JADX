package p007b.p225i.p226a.p242c.p257e3.p258b0;

import android.database.SQLException;
import android.os.ConditionVariable;
import android.util.Log;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.database.DatabaseIOException;
import com.google.android.exoplayer2.upstream.cache.Cache;
import java.io.File;
import java.io.IOException;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import java.util.Random;
import p007b.p085c.p086a.p087a0.AnimatableValueParser;
import p007b.p100d.p104b.p105a.outline;
import p007b.p225i.p226a.p242c.p257e3.p258b0.CachedContent;
import p007b.p225i.p226a.p242c.p259f3.Log2;
import p007b.p225i.p226a.p242c.p264u2.DatabaseProvider;
import p007b.p225i.p355b.p357b.ImmutableSet2;

/* JADX INFO: renamed from: b.i.a.c.e3.b0.r, reason: use source file name */
/* JADX INFO: compiled from: SimpleCache.java */
/* JADX INFO: loaded from: classes3.dex */
public final class SimpleCache2 implements Cache {

    /* JADX INFO: renamed from: a */
    public static final HashSet<File> f6506a = new HashSet<>();

    /* JADX INFO: renamed from: b */
    public final File f6507b;

    /* JADX INFO: renamed from: c */
    public final CacheEvictor f6508c;

    /* JADX INFO: renamed from: d */
    public final CachedContentIndex f6509d;

    /* JADX INFO: renamed from: e */
    @Nullable
    public final CacheFileMetadataIndex f6510e;

    /* JADX INFO: renamed from: f */
    public final HashMap<String, ArrayList<Cache.InterfaceC10774a>> f6511f;

    /* JADX INFO: renamed from: g */
    public final Random f6512g;

    /* JADX INFO: renamed from: h */
    public final boolean f6513h;

    /* JADX INFO: renamed from: i */
    public long f6514i;

    /* JADX INFO: renamed from: j */
    public long f6515j;

    /* JADX INFO: renamed from: k */
    public Cache.CacheException f6516k;

    public SimpleCache2(File file, CacheEvictor cacheEvictor, DatabaseProvider databaseProvider) {
        boolean zAdd;
        CachedContentIndex cachedContentIndex = new CachedContentIndex(databaseProvider, file, null, false, false);
        CacheFileMetadataIndex cacheFileMetadataIndex = new CacheFileMetadataIndex(databaseProvider);
        synchronized (SimpleCache2.class) {
            zAdd = f6506a.add(file.getAbsoluteFile());
        }
        if (!zAdd) {
            String strValueOf = String.valueOf(file);
            throw new IllegalStateException(outline.m857j(strValueOf.length() + 46, "Another SimpleCache instance uses the folder: ", strValueOf));
        }
        this.f6507b = file;
        this.f6508c = cacheEvictor;
        this.f6509d = cachedContentIndex;
        this.f6510e = cacheFileMetadataIndex;
        this.f6511f = new HashMap<>();
        this.f6512g = new Random();
        this.f6513h = true;
        this.f6514i = -1L;
        ConditionVariable conditionVariable = new ConditionVariable();
        new SimpleCache(this, "ExoPlayer:SimpleCacheInit", conditionVariable).start();
        conditionVariable.block();
    }

    /* JADX INFO: renamed from: j */
    public static void m2823j(SimpleCache2 simpleCache2) {
        long j;
        if (!simpleCache2.f6507b.exists()) {
            try {
                m2824m(simpleCache2.f6507b);
            } catch (Cache.CacheException e) {
                simpleCache2.f6516k = e;
                return;
            }
        }
        File[] fileArrListFiles = simpleCache2.f6507b.listFiles();
        if (fileArrListFiles == null) {
            String strValueOf = String.valueOf(simpleCache2.f6507b);
            StringBuilder sb = new StringBuilder(strValueOf.length() + 38);
            sb.append("Failed to list cache directory files: ");
            sb.append(strValueOf);
            String string = sb.toString();
            Log.e("SimpleCache", string);
            simpleCache2.f6516k = new Cache.CacheException(string);
            return;
        }
        int length = fileArrListFiles.length;
        int i = 0;
        while (true) {
            if (i >= length) {
                j = -1;
                break;
            }
            File file = fileArrListFiles[i];
            String name = file.getName();
            if (name.endsWith(".uid")) {
                try {
                    j = Long.parseLong(name.substring(0, name.indexOf(46)), 16);
                    break;
                } catch (NumberFormatException unused) {
                    String strValueOf2 = String.valueOf(file);
                    StringBuilder sb2 = new StringBuilder(strValueOf2.length() + 20);
                    sb2.append("Malformed UID file: ");
                    sb2.append(strValueOf2);
                    Log.e("SimpleCache", sb2.toString());
                    file.delete();
                }
            }
            i++;
        }
        simpleCache2.f6514i = j;
        if (j == -1) {
            try {
                simpleCache2.f6514i = m2825n(simpleCache2.f6507b);
            } catch (IOException e2) {
                String strValueOf3 = String.valueOf(simpleCache2.f6507b);
                StringBuilder sb3 = new StringBuilder(strValueOf3.length() + 28);
                sb3.append("Failed to create cache UID: ");
                sb3.append(strValueOf3);
                String string2 = sb3.toString();
                Log2.m3039b("SimpleCache", string2, e2);
                simpleCache2.f6516k = new Cache.CacheException(string2, e2);
                return;
            }
        }
        try {
            simpleCache2.f6509d.m2797e(simpleCache2.f6514i);
            CacheFileMetadataIndex cacheFileMetadataIndex = simpleCache2.f6510e;
            if (cacheFileMetadataIndex != null) {
                cacheFileMetadataIndex.m2788b(simpleCache2.f6514i);
                Map<String, CacheFileMetadata> mapM2787a = simpleCache2.f6510e.m2787a();
                simpleCache2.m2838p(simpleCache2.f6507b, true, fileArrListFiles, mapM2787a);
                simpleCache2.f6510e.m2789c(((HashMap) mapM2787a).keySet());
            } else {
                simpleCache2.m2838p(simpleCache2.f6507b, true, fileArrListFiles, null);
            }
            CachedContentIndex cachedContentIndex = simpleCache2.f6509d;
            Iterator itMo6251j = ImmutableSet2.m6281m(cachedContentIndex.f6478a.keySet()).mo6251j();
            while (itMo6251j.hasNext()) {
                cachedContentIndex.m2798f((String) itMo6251j.next());
            }
            try {
                simpleCache2.f6509d.m2799g();
            } catch (IOException e3) {
                Log2.m3039b("SimpleCache", "Storing index file failed", e3);
            }
        } catch (IOException e4) {
            String strValueOf4 = String.valueOf(simpleCache2.f6507b);
            StringBuilder sb4 = new StringBuilder(strValueOf4.length() + 36);
            sb4.append("Failed to initialize cache indices: ");
            sb4.append(strValueOf4);
            String string3 = sb4.toString();
            Log2.m3039b("SimpleCache", string3, e4);
            simpleCache2.f6516k = new Cache.CacheException(string3, e4);
        }
    }

    /* JADX INFO: renamed from: m */
    public static void m2824m(File file) throws Cache.CacheException {
        if (file.mkdirs() || file.isDirectory()) {
            return;
        }
        String strValueOf = String.valueOf(file);
        StringBuilder sb = new StringBuilder(strValueOf.length() + 34);
        sb.append("Failed to create cache directory: ");
        sb.append(strValueOf);
        String string = sb.toString();
        Log.e("SimpleCache", string);
        throw new Cache.CacheException(string);
    }

    /* JADX INFO: renamed from: n */
    public static long m2825n(File file) throws IOException {
        long jNextLong = new SecureRandom().nextLong();
        long jAbs = jNextLong == Long.MIN_VALUE ? 0L : Math.abs(jNextLong);
        String strValueOf = String.valueOf(Long.toString(jAbs, 16));
        File file2 = new File(file, ".uid".length() != 0 ? strValueOf.concat(".uid") : new String(strValueOf));
        if (file2.createNewFile()) {
            return jAbs;
        }
        String strValueOf2 = String.valueOf(file2);
        throw new IOException(outline.m857j(strValueOf2.length() + 27, "Failed to create UID file: ", strValueOf2));
    }

    @Override // com.google.android.exoplayer2.upstream.cache.Cache
    /* JADX INFO: renamed from: a */
    public synchronized File mo2826a(String str, long j, long j2) throws Cache.CacheException {
        CachedContent cachedContent;
        File file;
        AnimatableValueParser.m426D(true);
        m2836l();
        cachedContent = this.f6509d.f6478a.get(str);
        Objects.requireNonNull(cachedContent);
        AnimatableValueParser.m426D(cachedContent.m2792a(j, j2));
        if (!this.f6507b.exists()) {
            m2824m(this.f6507b);
            m2840r();
        }
        this.f6508c.mo2785a(this, str, j, j2);
        file = new File(this.f6507b, Integer.toString(this.f6512g.nextInt(10)));
        if (!file.exists()) {
            m2824m(file);
        }
        return SimpleCacheSpan.m2843h(file, cachedContent.f6471a, j, System.currentTimeMillis());
    }

    @Override // com.google.android.exoplayer2.upstream.cache.Cache
    /* JADX INFO: renamed from: b */
    public synchronized ContentMetadata2 mo2827b(String str) {
        CachedContent cachedContent;
        AnimatableValueParser.m426D(true);
        cachedContent = this.f6509d.f6478a.get(str);
        return cachedContent != null ? cachedContent.f6475e : DefaultContentMetadata.f6498a;
    }

    @Override // com.google.android.exoplayer2.upstream.cache.Cache
    /* JADX INFO: renamed from: c */
    public synchronized void mo2828c(String str, ContentMetadataMutations contentMetadataMutations) throws Cache.CacheException {
        AnimatableValueParser.m426D(true);
        m2836l();
        CachedContentIndex cachedContentIndex = this.f6509d;
        CachedContent cachedContentM2796d = cachedContentIndex.m2796d(str);
        cachedContentM2796d.f6475e = cachedContentM2796d.f6475e.m2817a(contentMetadataMutations);
        if (!r5.equals(r2)) {
            cachedContentIndex.f6482e.mo2804c(cachedContentM2796d);
        }
        try {
            this.f6509d.m2799g();
        } catch (IOException e) {
            throw new Cache.CacheException(e);
        }
    }

    @Override // com.google.android.exoplayer2.upstream.cache.Cache
    /* JADX INFO: renamed from: d */
    public synchronized void mo2829d(CacheSpan cacheSpan) {
        AnimatableValueParser.m426D(true);
        m2839q(cacheSpan);
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x0059 A[PHI: r20
      0x0059: PHI (r20v6 b.i.a.c.e3.b0.s) = (r20v3 b.i.a.c.e3.b0.s), (r20v7 b.i.a.c.e3.b0.s) binds: [B:23:0x0056, B:18:0x0049] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x005b A[PHI: r20
      0x005b: PHI (r20v4 b.i.a.c.e3.b0.s) = (r20v3 b.i.a.c.e3.b0.s), (r20v3 b.i.a.c.e3.b0.s), (r20v7 b.i.a.c.e3.b0.s), (r20v7 b.i.a.c.e3.b0.s) binds: [B:21:0x0050, B:24:0x0058, B:16:0x0044, B:19:0x004b] A[DONT_GENERATE, DONT_INLINE]] */
    @Override // com.google.android.exoplayer2.upstream.cache.Cache
    @Nullable
    /* JADX INFO: renamed from: e */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public synchronized CacheSpan mo2830e(String str, long j, long j2) throws Cache.CacheException {
        SimpleCacheSpan simpleCacheSpan;
        boolean z2;
        boolean z3;
        AnimatableValueParser.m426D(true);
        m2836l();
        SimpleCacheSpan simpleCacheSpanM2837o = m2837o(str, j, j2);
        if (simpleCacheSpanM2837o.f6468m) {
            return m2841s(str, simpleCacheSpanM2837o);
        }
        CachedContent cachedContentM2796d = this.f6509d.m2796d(str);
        long j3 = simpleCacheSpanM2837o.f6467l;
        int i = 0;
        while (true) {
            if (i >= cachedContentM2796d.f6474d.size()) {
                simpleCacheSpan = simpleCacheSpanM2837o;
                cachedContentM2796d.f6474d.add(new CachedContent.a(j, j3));
                z2 = true;
                break;
            }
            CachedContent.a aVar = cachedContentM2796d.f6474d.get(i);
            long j4 = aVar.f6476a;
            if (j4 <= j) {
                simpleCacheSpan = simpleCacheSpanM2837o;
                long j5 = aVar.f6477b;
                z3 = j5 == -1 || j4 + j5 > j;
            } else {
                simpleCacheSpan = simpleCacheSpanM2837o;
                if (j3 == -1 || j + j3 > j4) {
                }
            }
            if (z3) {
                z2 = false;
                break;
            }
            i++;
            simpleCacheSpanM2837o = simpleCacheSpan;
        }
        if (z2) {
            return simpleCacheSpan;
        }
        return null;
    }

    @Override // com.google.android.exoplayer2.upstream.cache.Cache
    /* JADX INFO: renamed from: f */
    public synchronized CacheSpan mo2831f(String str, long j, long j2) throws InterruptedException, Cache.CacheException {
        CacheSpan cacheSpanMo2830e;
        AnimatableValueParser.m426D(true);
        m2836l();
        while (true) {
            cacheSpanMo2830e = mo2830e(str, j, j2);
            if (cacheSpanMo2830e == null) {
                wait();
            }
        }
        return cacheSpanMo2830e;
    }

    @Override // com.google.android.exoplayer2.upstream.cache.Cache
    /* JADX INFO: renamed from: g */
    public synchronized void mo2832g(File file, long j) throws Cache.CacheException {
        boolean z2 = true;
        AnimatableValueParser.m426D(true);
        if (file.exists()) {
            if (j == 0) {
                file.delete();
                return;
            }
            SimpleCacheSpan simpleCacheSpanM2842g = SimpleCacheSpan.m2842g(file, j, -9223372036854775807L, this.f6509d);
            Objects.requireNonNull(simpleCacheSpanM2842g);
            CachedContent cachedContentM2795c = this.f6509d.m2795c(simpleCacheSpanM2842g.f6465j);
            Objects.requireNonNull(cachedContentM2795c);
            AnimatableValueParser.m426D(cachedContentM2795c.m2792a(simpleCacheSpanM2842g.f6466k, simpleCacheSpanM2842g.f6467l));
            long jM2814a = ContentMetadata.m2814a(cachedContentM2795c.f6475e);
            if (jM2814a != -1) {
                if (simpleCacheSpanM2842g.f6466k + simpleCacheSpanM2842g.f6467l > jM2814a) {
                    z2 = false;
                }
                AnimatableValueParser.m426D(z2);
            }
            if (this.f6510e == null) {
                m2835k(simpleCacheSpanM2842g);
                this.f6509d.m2799g();
                notifyAll();
                return;
            }
            try {
                this.f6510e.m2790d(file.getName(), simpleCacheSpanM2842g.f6467l, simpleCacheSpanM2842g.f6470o);
                m2835k(simpleCacheSpanM2842g);
                try {
                    this.f6509d.m2799g();
                    notifyAll();
                    return;
                } catch (IOException e) {
                    throw new Cache.CacheException(e);
                }
            } catch (IOException e2) {
                throw new Cache.CacheException(e2);
            }
        }
    }

    @Override // com.google.android.exoplayer2.upstream.cache.Cache
    /* JADX INFO: renamed from: h */
    public synchronized long mo2833h() {
        AnimatableValueParser.m426D(true);
        return this.f6515j;
    }

    @Override // com.google.android.exoplayer2.upstream.cache.Cache
    /* JADX INFO: renamed from: i */
    public synchronized void mo2834i(CacheSpan cacheSpan) {
        AnimatableValueParser.m426D(true);
        CachedContent cachedContentM2795c = this.f6509d.m2795c(cacheSpan.f6465j);
        Objects.requireNonNull(cachedContentM2795c);
        long j = cacheSpan.f6466k;
        for (int i = 0; i < cachedContentM2795c.f6474d.size(); i++) {
            if (cachedContentM2795c.f6474d.get(i).f6476a == j) {
                cachedContentM2795c.f6474d.remove(i);
                this.f6509d.m2798f(cachedContentM2795c.f6472b);
                notifyAll();
            }
        }
        throw new IllegalStateException();
    }

    /* JADX INFO: renamed from: k */
    public final void m2835k(SimpleCacheSpan simpleCacheSpan) {
        this.f6509d.m2796d(simpleCacheSpan.f6465j).f6473c.add(simpleCacheSpan);
        this.f6515j += simpleCacheSpan.f6467l;
        ArrayList<Cache.InterfaceC10774a> arrayList = this.f6511f.get(simpleCacheSpan.f6465j);
        if (arrayList != null) {
            int size = arrayList.size();
            while (true) {
                size--;
                if (size < 0) {
                    break;
                } else {
                    arrayList.get(size).mo2820d(this, simpleCacheSpan);
                }
            }
        }
        this.f6508c.mo2820d(this, simpleCacheSpan);
    }

    /* JADX INFO: renamed from: l */
    public synchronized void m2836l() throws Cache.CacheException {
        Cache.CacheException cacheException = this.f6516k;
        if (cacheException != null) {
            throw cacheException;
        }
    }

    /* JADX INFO: renamed from: o */
    public final SimpleCacheSpan m2837o(String str, long j, long j2) {
        SimpleCacheSpan simpleCacheSpanFloor;
        long j3;
        CachedContent cachedContent = this.f6509d.f6478a.get(str);
        if (cachedContent == null) {
            return new SimpleCacheSpan(str, j, j2, -9223372036854775807L, null);
        }
        while (true) {
            SimpleCacheSpan simpleCacheSpan = new SimpleCacheSpan(cachedContent.f6472b, j, -1L, -9223372036854775807L, null);
            simpleCacheSpanFloor = cachedContent.f6473c.floor(simpleCacheSpan);
            if (simpleCacheSpanFloor == null || simpleCacheSpanFloor.f6466k + simpleCacheSpanFloor.f6467l <= j) {
                SimpleCacheSpan simpleCacheSpanCeiling = cachedContent.f6473c.ceiling(simpleCacheSpan);
                if (simpleCacheSpanCeiling != null) {
                    long jMin = simpleCacheSpanCeiling.f6466k - j;
                    if (j2 != -1) {
                        jMin = Math.min(jMin, j2);
                    }
                    j3 = jMin;
                } else {
                    j3 = j2;
                }
                simpleCacheSpanFloor = new SimpleCacheSpan(cachedContent.f6472b, j, j3, -9223372036854775807L, null);
            }
            if (!simpleCacheSpanFloor.f6468m || simpleCacheSpanFloor.f6469n.length() == simpleCacheSpanFloor.f6467l) {
                break;
            }
            m2840r();
        }
        return simpleCacheSpanFloor;
    }

    /* JADX INFO: renamed from: p */
    public final void m2838p(File file, boolean z2, @Nullable File[] fileArr, @Nullable Map<String, CacheFileMetadata> map) {
        if (fileArr == null || fileArr.length == 0) {
            if (z2) {
                return;
            }
            file.delete();
            return;
        }
        for (File file2 : fileArr) {
            String name = file2.getName();
            if (z2 && name.indexOf(46) == -1) {
                m2838p(file2, false, file2.listFiles(), map);
            } else if (!z2 || (!name.startsWith("cached_content_index.exi") && !name.endsWith(".uid"))) {
                long j = -1;
                long j2 = -9223372036854775807L;
                CacheFileMetadata cacheFileMetadataRemove = map != null ? map.remove(name) : null;
                if (cacheFileMetadataRemove != null) {
                    j = cacheFileMetadataRemove.f6459a;
                    j2 = cacheFileMetadataRemove.f6460b;
                }
                SimpleCacheSpan simpleCacheSpanM2842g = SimpleCacheSpan.m2842g(file2, j, j2, this.f6509d);
                if (simpleCacheSpanM2842g != null) {
                    m2835k(simpleCacheSpanM2842g);
                } else {
                    file2.delete();
                }
            }
        }
    }

    /* JADX INFO: renamed from: q */
    public final void m2839q(CacheSpan cacheSpan) {
        boolean z2;
        CachedContent cachedContentM2795c = this.f6509d.m2795c(cacheSpan.f6465j);
        if (cachedContentM2795c != null) {
            if (cachedContentM2795c.f6473c.remove(cacheSpan)) {
                File file = cacheSpan.f6469n;
                if (file != null) {
                    file.delete();
                }
                z2 = true;
            } else {
                z2 = false;
            }
            if (z2) {
                this.f6515j -= cacheSpan.f6467l;
                if (this.f6510e != null) {
                    String name = cacheSpan.f6469n.getName();
                    try {
                        CacheFileMetadataIndex cacheFileMetadataIndex = this.f6510e;
                        Objects.requireNonNull(cacheFileMetadataIndex.f6463c);
                        try {
                            cacheFileMetadataIndex.f6462b.getWritableDatabase().delete(cacheFileMetadataIndex.f6463c, "name = ?", new String[]{name});
                        } catch (SQLException e) {
                            throw new DatabaseIOException(e);
                        }
                    } catch (IOException unused) {
                        String strValueOf = String.valueOf(name);
                        Log.w("SimpleCache", strValueOf.length() != 0 ? "Failed to remove file index entry for: ".concat(strValueOf) : new String("Failed to remove file index entry for: "));
                    }
                }
                this.f6509d.m2798f(cachedContentM2795c.f6472b);
                ArrayList<Cache.InterfaceC10774a> arrayList = this.f6511f.get(cacheSpan.f6465j);
                if (arrayList != null) {
                    int size = arrayList.size();
                    while (true) {
                        size--;
                        if (size < 0) {
                            break;
                        } else {
                            arrayList.get(size).mo2818b(this, cacheSpan);
                        }
                    }
                }
                this.f6508c.mo2818b(this, cacheSpan);
            }
        }
    }

    /* JADX INFO: renamed from: r */
    public final void m2840r() {
        ArrayList arrayList = new ArrayList();
        Iterator it = Collections.unmodifiableCollection(this.f6509d.f6478a.values()).iterator();
        while (it.hasNext()) {
            for (SimpleCacheSpan simpleCacheSpan : ((CachedContent) it.next()).f6473c) {
                if (simpleCacheSpan.f6469n.length() != simpleCacheSpan.f6467l) {
                    arrayList.add(simpleCacheSpan);
                }
            }
        }
        for (int i = 0; i < arrayList.size(); i++) {
            m2839q((CacheSpan) arrayList.get(i));
        }
    }

    /* JADX INFO: renamed from: s */
    public final SimpleCacheSpan m2841s(String str, SimpleCacheSpan simpleCacheSpan) {
        File file;
        if (!this.f6513h) {
            return simpleCacheSpan;
        }
        File file2 = simpleCacheSpan.f6469n;
        Objects.requireNonNull(file2);
        String name = file2.getName();
        long j = simpleCacheSpan.f6467l;
        long jCurrentTimeMillis = System.currentTimeMillis();
        boolean z2 = false;
        CacheFileMetadataIndex cacheFileMetadataIndex = this.f6510e;
        if (cacheFileMetadataIndex != null) {
            try {
                cacheFileMetadataIndex.m2790d(name, j, jCurrentTimeMillis);
            } catch (IOException unused) {
                Log.w("SimpleCache", "Failed to update index with new touch timestamp.");
            }
        } else {
            z2 = true;
        }
        CachedContent cachedContent = this.f6509d.f6478a.get(str);
        AnimatableValueParser.m426D(cachedContent.f6473c.remove(simpleCacheSpan));
        File file3 = simpleCacheSpan.f6469n;
        Objects.requireNonNull(file3);
        if (z2) {
            File parentFile = file3.getParentFile();
            Objects.requireNonNull(parentFile);
            File fileM2843h = SimpleCacheSpan.m2843h(parentFile, cachedContent.f6471a, simpleCacheSpan.f6466k, jCurrentTimeMillis);
            if (file3.renameTo(fileM2843h)) {
                file = fileM2843h;
            } else {
                String strValueOf = String.valueOf(file3);
                String strValueOf2 = String.valueOf(fileM2843h);
                Log.w("CachedContent", outline.m861l(strValueOf2.length() + strValueOf.length() + 21, "Failed to rename ", strValueOf, " to ", strValueOf2));
                file = file3;
            }
        } else {
            file = file3;
        }
        AnimatableValueParser.m426D(simpleCacheSpan.f6468m);
        SimpleCacheSpan simpleCacheSpan2 = new SimpleCacheSpan(simpleCacheSpan.f6465j, simpleCacheSpan.f6466k, simpleCacheSpan.f6467l, jCurrentTimeMillis, file);
        cachedContent.f6473c.add(simpleCacheSpan2);
        ArrayList<Cache.InterfaceC10774a> arrayList = this.f6511f.get(simpleCacheSpan.f6465j);
        if (arrayList != null) {
            int size = arrayList.size();
            while (true) {
                size--;
                if (size < 0) {
                    break;
                }
                arrayList.get(size).mo2819c(this, simpleCacheSpan, simpleCacheSpan2);
            }
        }
        this.f6508c.mo2819c(this, simpleCacheSpan, simpleCacheSpan2);
        return simpleCacheSpan2;
    }
}
