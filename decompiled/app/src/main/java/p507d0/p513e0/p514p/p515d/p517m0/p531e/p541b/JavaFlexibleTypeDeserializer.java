package p507d0.p513e0.p514p.p515d.p517m0.p531e.p541b;

import p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p535i0.p537m.RawType2;
import p507d0.p513e0.p514p.p515d.p517m0.p543f.C11692q;
import p507d0.p513e0.p514p.p515d.p517m0.p543f.p544a0.JvmProtoBuf;
import p507d0.p513e0.p514p.p515d.p517m0.p562l.p563b.FlexibleTypeDeserializer;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.ErrorUtils;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.KotlinType;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.KotlinType4;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.KotlinTypeFactory;
import p507d0.p592z.p594d.Intrinsics3;

/* JADX INFO: renamed from: d0.e0.p.d.m0.e.b.h, reason: use source file name */
/* JADX INFO: compiled from: JavaFlexibleTypeDeserializer.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class JavaFlexibleTypeDeserializer implements FlexibleTypeDeserializer {

    /* JADX INFO: renamed from: a */
    public static final JavaFlexibleTypeDeserializer f23613a = new JavaFlexibleTypeDeserializer();

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p562l.p563b.FlexibleTypeDeserializer
    public KotlinType create(C11692q c11692q, String str, KotlinType4 kotlinType4, KotlinType4 kotlinType42) {
        Intrinsics3.checkNotNullParameter(c11692q, "proto");
        Intrinsics3.checkNotNullParameter(str, "flexibleId");
        Intrinsics3.checkNotNullParameter(kotlinType4, "lowerBound");
        Intrinsics3.checkNotNullParameter(kotlinType42, "upperBound");
        if (Intrinsics3.areEqual(str, "kotlin.jvm.PlatformType")) {
            if (c11692q.hasExtension(JvmProtoBuf.f23657g)) {
                return new RawType2(kotlinType4, kotlinType42);
            }
            KotlinTypeFactory kotlinTypeFactory = KotlinTypeFactory.f24748a;
            return KotlinTypeFactory.flexibleType(kotlinType4, kotlinType42);
        }
        KotlinType4 kotlinType4CreateErrorType = ErrorUtils.createErrorType("Error java flexible type with id: " + str + ". (" + kotlinType4 + ".." + kotlinType42 + ')');
        Intrinsics3.checkNotNullExpressionValue(kotlinType4CreateErrorType, "createErrorType(\"Error java flexible type with id: $flexibleId. ($lowerBound..$upperBound)\")");
        return kotlinType4CreateErrorType;
    }
}
