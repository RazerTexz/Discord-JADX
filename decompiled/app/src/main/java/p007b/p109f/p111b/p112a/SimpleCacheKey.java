package p007b.p109f.p111b.p112a;

import com.facebook.cache.common.CacheKey;
import java.util.Objects;

/* compiled from: SimpleCacheKey.java */
/* renamed from: b.f.b.a.f, reason: use source file name */
/* loaded from: classes.dex */
public class SimpleCacheKey implements CacheKey {

    /* renamed from: a */
    public final String f3019a;

    /* renamed from: b */
    public final boolean f3020b;

    public SimpleCacheKey(String str) {
        Objects.requireNonNull(str);
        this.f3019a = str;
        this.f3020b = false;
    }

    @Override // com.facebook.cache.common.CacheKey
    /* renamed from: a */
    public boolean mo929a() {
        return this.f3020b;
    }

    @Override // com.facebook.cache.common.CacheKey
    /* renamed from: b */
    public String mo930b() {
        return this.f3019a;
    }

    @Override // com.facebook.cache.common.CacheKey
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof SimpleCacheKey) {
            return this.f3019a.equals(((SimpleCacheKey) obj).f3019a);
        }
        return false;
    }

    @Override // com.facebook.cache.common.CacheKey
    public int hashCode() {
        return this.f3019a.hashCode();
    }

    public String toString() {
        return this.f3019a;
    }
}
