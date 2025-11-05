package d0.z.d;

import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: TypeParameterReference.kt */
/* loaded from: classes3.dex */
public final class f0 implements d0.e0.h {
    public static final a j = new a(null);

    /* compiled from: TypeParameterReference.kt */
    public static final class a {
        public a(DefaultConstructorMarker defaultConstructorMarker) {
        }

        public final String toString(d0.e0.h hVar) {
            m.checkNotNullParameter(hVar, "typeParameter");
            StringBuilder sb = new StringBuilder();
            int iOrdinal = hVar.getVariance().ordinal();
            if (iOrdinal == 1) {
                sb.append("in ");
            } else if (iOrdinal == 2) {
                sb.append("out ");
            }
            sb.append(hVar.getName());
            String string = sb.toString();
            m.checkNotNullExpressionValue(string, "StringBuilder().apply(builderAction).toString()");
            return string;
        }
    }
}
