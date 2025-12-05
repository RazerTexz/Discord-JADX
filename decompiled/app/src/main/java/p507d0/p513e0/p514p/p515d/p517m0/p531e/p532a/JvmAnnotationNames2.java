package p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import p507d0.p513e0.p514p.p515d.p517m0.p548g.FqName;
import p507d0.p580t.Collections2;
import p507d0.p580t._Sets;

/* compiled from: JvmAnnotationNames.kt */
/* renamed from: d0.e0.p.d.m0.e.a.b0, reason: use source file name */
/* loaded from: classes3.dex */
public final class JvmAnnotationNames2 {

    /* renamed from: a */
    public static final FqName f23174a;

    /* renamed from: b */
    public static final FqName f23175b;

    /* renamed from: c */
    public static final FqName f23176c;

    /* renamed from: d */
    public static final List<FqName> f23177d;

    /* renamed from: e */
    public static final FqName f23178e;

    /* renamed from: f */
    public static final FqName f23179f;

    /* renamed from: g */
    public static final List<FqName> f23180g;

    /* renamed from: h */
    public static final FqName f23181h;

    /* renamed from: i */
    public static final FqName f23182i;

    /* renamed from: j */
    public static final FqName f23183j;

    /* renamed from: k */
    public static final FqName f23184k;

    /* renamed from: l */
    public static final List<FqName> f23185l;

    /* renamed from: m */
    public static final List<FqName> f23186m;

    static {
        FqName fqName = new FqName("org.jspecify.annotations.Nullable");
        f23174a = fqName;
        FqName fqName2 = new FqName("org.jspecify.annotations.NullnessUnspecified");
        f23175b = fqName2;
        FqName fqName3 = new FqName("org.jspecify.annotations.DefaultNonNull");
        f23176c = fqName3;
        List<FqName> listListOf = Collections2.listOf((Object[]) new FqName[]{JvmAnnotationNames.f23155i, new FqName("androidx.annotation.Nullable"), new FqName("androidx.annotation.Nullable"), new FqName("android.annotation.Nullable"), new FqName("com.android.annotations.Nullable"), new FqName("org.eclipse.jdt.annotation.Nullable"), new FqName("org.checkerframework.checker.nullness.qual.Nullable"), new FqName("javax.annotation.Nullable"), new FqName("javax.annotation.CheckForNull"), new FqName("edu.umd.cs.findbugs.annotations.CheckForNull"), new FqName("edu.umd.cs.findbugs.annotations.Nullable"), new FqName("edu.umd.cs.findbugs.annotations.PossiblyNull"), new FqName("io.reactivex.annotations.Nullable")});
        f23177d = listListOf;
        FqName fqName4 = new FqName("javax.annotation.Nonnull");
        f23178e = fqName4;
        f23179f = new FqName("javax.annotation.CheckForNull");
        List<FqName> listListOf2 = Collections2.listOf((Object[]) new FqName[]{JvmAnnotationNames.f23154h, new FqName("edu.umd.cs.findbugs.annotations.NonNull"), new FqName("androidx.annotation.NonNull"), new FqName("androidx.annotation.NonNull"), new FqName("android.annotation.NonNull"), new FqName("com.android.annotations.NonNull"), new FqName("org.eclipse.jdt.annotation.NonNull"), new FqName("org.checkerframework.checker.nullness.qual.NonNull"), new FqName("lombok.NonNull"), new FqName("io.reactivex.annotations.NonNull")});
        f23180g = listListOf2;
        FqName fqName5 = new FqName("org.checkerframework.checker.nullness.compatqual.NullableDecl");
        f23181h = fqName5;
        FqName fqName6 = new FqName("org.checkerframework.checker.nullness.compatqual.NonNullDecl");
        f23182i = fqName6;
        FqName fqName7 = new FqName("androidx.annotation.RecentlyNullable");
        f23183j = fqName7;
        FqName fqName8 = new FqName("androidx.annotation.RecentlyNonNull");
        f23184k = fqName8;
        _Sets.plus((Set<? extends FqName>) _Sets.plus((Set<? extends FqName>) _Sets.plus((Set<? extends FqName>) _Sets.plus((Set<? extends FqName>) _Sets.plus((Set<? extends FqName>) _Sets.plus((Set<? extends FqName>) _Sets.plus((Set<? extends FqName>) _Sets.plus(_Sets.plus((Set<? extends FqName>) _Sets.plus((Set) new LinkedHashSet(), (Iterable) listListOf), fqName4), (Iterable) listListOf2), fqName5), fqName6), fqName7), fqName8), fqName), fqName2), fqName3);
        f23185l = Collections2.listOf((Object[]) new FqName[]{JvmAnnotationNames.f23157k, JvmAnnotationNames.f23158l});
        f23186m = Collections2.listOf((Object[]) new FqName[]{JvmAnnotationNames.f23156j, JvmAnnotationNames.f23159m});
    }

    public static final FqName getANDROIDX_RECENTLY_NON_NULL_ANNOTATION() {
        return f23184k;
    }

    public static final FqName getANDROIDX_RECENTLY_NULLABLE_ANNOTATION() {
        return f23183j;
    }

    public static final FqName getCOMPATQUAL_NONNULL_ANNOTATION() {
        return f23182i;
    }

    public static final FqName getCOMPATQUAL_NULLABLE_ANNOTATION() {
        return f23181h;
    }

    public static final FqName getJAVAX_CHECKFORNULL_ANNOTATION() {
        return f23179f;
    }

    public static final FqName getJAVAX_NONNULL_ANNOTATION() {
        return f23178e;
    }

    public static final FqName getJSPECIFY_DEFAULT_NOT_NULL() {
        return f23176c;
    }

    public static final FqName getJSPECIFY_NULLABLE() {
        return f23174a;
    }

    public static final FqName getJSPECIFY_NULLNESS_UNKNOWN() {
        return f23175b;
    }

    public static final List<FqName> getMUTABLE_ANNOTATIONS() {
        return f23186m;
    }

    public static final List<FqName> getNOT_NULL_ANNOTATIONS() {
        return f23180g;
    }

    public static final List<FqName> getNULLABLE_ANNOTATIONS() {
        return f23177d;
    }

    public static final List<FqName> getREAD_ONLY_ANNOTATIONS() {
        return f23185l;
    }
}
