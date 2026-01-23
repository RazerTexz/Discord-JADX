package p507d0.p513e0.p514p.p515d.p517m0.p562l.p563b;

import p507d0.p513e0.p514p.p515d.p517m0.p543f.C11692q;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.KotlinType;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.KotlinType4;
import p507d0.p592z.p594d.Intrinsics3;

/* JADX INFO: renamed from: d0.e0.p.d.m0.l.b.q, reason: use source file name */
/* JADX INFO: compiled from: FlexibleTypeDeserializer.kt */
/* JADX INFO: loaded from: classes3.dex */
public interface FlexibleTypeDeserializer {

    /* JADX INFO: renamed from: d0.e0.p.d.m0.l.b.q$a */
    /* JADX INFO: compiled from: FlexibleTypeDeserializer.kt */
    public static final class a implements FlexibleTypeDeserializer {

        /* JADX INFO: renamed from: a */
        public static final a f24677a = new a();

        @Override // p507d0.p513e0.p514p.p515d.p517m0.p562l.p563b.FlexibleTypeDeserializer
        public KotlinType create(C11692q c11692q, String str, KotlinType4 kotlinType4, KotlinType4 kotlinType42) {
            Intrinsics3.checkNotNullParameter(c11692q, "proto");
            Intrinsics3.checkNotNullParameter(str, "flexibleId");
            Intrinsics3.checkNotNullParameter(kotlinType4, "lowerBound");
            Intrinsics3.checkNotNullParameter(kotlinType42, "upperBound");
            throw new IllegalArgumentException("This method should not be used.");
        }
    }

    KotlinType create(C11692q c11692q, String str, KotlinType4 kotlinType4, KotlinType4 kotlinType42);
}
