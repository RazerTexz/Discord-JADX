package com.facebook.cache.disk;

import android.content.Context;
import b.f.b.a.d;
import b.f.b.a.e;
import b.f.b.b.g;
import com.discord.api.permission.Permission;
import com.facebook.common.internal.Supplier;
import java.io.File;
import java.util.Objects;

/* loaded from: classes.dex */
public class DiskCacheConfig {
    public final int a;

    /* renamed from: b, reason: collision with root package name */
    public final String f2882b;
    public final Supplier<File> c;
    public final long d;
    public final long e;
    public final long f;
    public final g g;
    public final b.f.b.a.a h;
    public final b.f.b.a.b i;
    public final b.f.d.a.a j;
    public final Context k;

    public class a implements Supplier<File> {
        public a() {
        }

        @Override // com.facebook.common.internal.Supplier
        public File get() {
            Objects.requireNonNull(DiskCacheConfig.this.k);
            return DiskCacheConfig.this.k.getApplicationContext().getCacheDir();
        }
    }

    public static class b {

        /* renamed from: b, reason: collision with root package name */
        public Supplier<File> f2883b;
        public final Context e;
        public String a = "image_cache";
        public long c = 41943040;
        public g d = new b.f.b.b.b();

        public b(Context context, a aVar) {
            this.e = context;
        }
    }

    public DiskCacheConfig(b bVar) {
        d dVar;
        e eVar;
        b.f.d.a.b bVar2;
        Context context = bVar.e;
        this.k = context;
        b.c.a.a0.d.C((bVar.f2883b == null && context == null) ? false : true, "Either a non-null context or a base directory path or supplier must be provided.");
        if (bVar.f2883b == null && context != null) {
            bVar.f2883b = new a();
        }
        this.a = 1;
        String str = bVar.a;
        Objects.requireNonNull(str);
        this.f2882b = str;
        Supplier<File> supplier = bVar.f2883b;
        Objects.requireNonNull(supplier);
        this.c = supplier;
        this.d = bVar.c;
        this.e = 10485760L;
        this.f = Permission.SPEAK;
        g gVar = bVar.d;
        Objects.requireNonNull(gVar);
        this.g = gVar;
        synchronized (d.class) {
            if (d.a == null) {
                d.a = new d();
            }
            dVar = d.a;
        }
        this.h = dVar;
        synchronized (e.class) {
            if (e.a == null) {
                e.a = new e();
            }
            eVar = e.a;
        }
        this.i = eVar;
        synchronized (b.f.d.a.b.class) {
            if (b.f.d.a.b.a == null) {
                b.f.d.a.b.a = new b.f.d.a.b();
            }
            bVar2 = b.f.d.a.b.a;
        }
        this.j = bVar2;
    }
}
