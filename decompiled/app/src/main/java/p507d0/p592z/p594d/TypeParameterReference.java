package p507d0.p592z.p594d;

import kotlin.jvm.internal.DefaultConstructorMarker;
import p507d0.p513e0.KTypeParameter;

/* JADX INFO: renamed from: d0.z.d.f0, reason: use source file name */
/* JADX INFO: compiled from: TypeParameterReference.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class TypeParameterReference implements KTypeParameter {

    /* JADX INFO: renamed from: j */
    public static final a f25289j = new a(null);

    /* JADX INFO: renamed from: d0.z.d.f0$a */
    /* JADX INFO: compiled from: TypeParameterReference.kt */
    public static final class a {
        public a(DefaultConstructorMarker defaultConstructorMarker) {
        }

        public final String toString(KTypeParameter kTypeParameter) {
            Intrinsics3.checkNotNullParameter(kTypeParameter, "typeParameter");
            StringBuilder sb = new StringBuilder();
            int iOrdinal = kTypeParameter.getVariance().ordinal();
            if (iOrdinal == 1) {
                sb.append("in ");
            } else if (iOrdinal == 2) {
                sb.append("out ");
            }
            sb.append(kTypeParameter.getName());
            String string = sb.toString();
            Intrinsics3.checkNotNullExpressionValue(string, "StringBuilder().apply(builderAction).toString()");
            return string;
        }
    }
}
