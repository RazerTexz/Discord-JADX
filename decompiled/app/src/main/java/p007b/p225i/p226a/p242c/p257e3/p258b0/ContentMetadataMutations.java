package p007b.p225i.p226a.p242c.p257e3.p258b0;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/* compiled from: ContentMetadataMutations.java */
/* renamed from: b.i.a.c.e3.b0.m, reason: use source file name */
/* loaded from: classes3.dex */
public class ContentMetadataMutations {

    /* renamed from: a */
    public final Map<String, Object> f6496a = new HashMap();

    /* renamed from: b */
    public final List<String> f6497b = new ArrayList();

    /* renamed from: a */
    public static ContentMetadataMutations m2815a(ContentMetadataMutations contentMetadataMutations, long j) {
        Long lValueOf = Long.valueOf(j);
        Map<String, Object> map = contentMetadataMutations.f6496a;
        Objects.requireNonNull(lValueOf);
        map.put("exo_len", lValueOf);
        contentMetadataMutations.f6497b.remove("exo_len");
        return contentMetadataMutations;
    }
}
