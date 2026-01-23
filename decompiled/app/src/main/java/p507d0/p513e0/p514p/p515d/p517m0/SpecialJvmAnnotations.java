package p507d0.p513e0.p514p.p515d.p517m0;

import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.JvmAnnotationNames;
import p507d0.p513e0.p514p.p515d.p517m0.p548g.ClassId;
import p507d0.p513e0.p514p.p515d.p517m0.p548g.FqName;
import p507d0.p580t.Collections2;

/* JADX INFO: renamed from: d0.e0.p.d.m0.a, reason: use source file name */
/* JADX INFO: compiled from: SpecialJvmAnnotations.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class SpecialJvmAnnotations {

    /* JADX INFO: renamed from: a */
    public static final SpecialJvmAnnotations f22449a = new SpecialJvmAnnotations();

    /* JADX INFO: renamed from: b */
    public static final Set<ClassId> f22450b;

    static {
        List listListOf = Collections2.listOf((Object[]) new FqName[]{JvmAnnotationNames.f23147a, JvmAnnotationNames.f23154h, JvmAnnotationNames.f23155i, JvmAnnotationNames.f23149c, JvmAnnotationNames.f23150d, JvmAnnotationNames.f23152f});
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        Iterator it = listListOf.iterator();
        while (it.hasNext()) {
            linkedHashSet.add(ClassId.topLevel((FqName) it.next()));
        }
        f22450b = linkedHashSet;
    }

    public final Set<ClassId> getSPECIAL_ANNOTATIONS() {
        return f22450b;
    }
}
