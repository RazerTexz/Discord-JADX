package d0.e0.p.d.m0.e.b;

import androidx.exifinterface.media.ExifInterface;
import com.discord.models.domain.ModelAuditLogEntry;
import d0.e0.p.d.m0.c.u0;
import d0.e0.p.d.m0.e.b.p;
import d0.e0.p.d.m0.e.b.s;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;

/* compiled from: AbstractBinaryClassAnnotationAndConstantLoader.kt */
/* loaded from: classes3.dex */
public final class b implements p.d {
    public final /* synthetic */ d0.e0.p.d.m0.e.b.a<A, C> a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ HashMap<s, List<A>> f3364b;
    public final /* synthetic */ HashMap<s, C> c;

    /* compiled from: AbstractBinaryClassAnnotationAndConstantLoader.kt */
    public final class a extends C0532b implements p.e {
        public final /* synthetic */ b d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(b bVar, s sVar) {
            super(bVar, sVar);
            d0.z.d.m.checkNotNullParameter(bVar, "this$0");
            d0.z.d.m.checkNotNullParameter(sVar, "signature");
            this.d = bVar;
        }

        @Override // d0.e0.p.d.m0.e.b.p.e
        public p.a visitParameterAnnotation(int i, d0.e0.p.d.m0.g.a aVar, u0 u0Var) {
            d0.z.d.m.checkNotNullParameter(aVar, "classId");
            d0.z.d.m.checkNotNullParameter(u0Var, "source");
            s sVarFromMethodSignatureAndParameterIndex = s.a.fromMethodSignatureAndParameterIndex(this.a, i);
            List arrayList = (List) this.d.f3364b.get(sVarFromMethodSignatureAndParameterIndex);
            if (arrayList == null) {
                arrayList = new ArrayList();
                this.d.f3364b.put(sVarFromMethodSignatureAndParameterIndex, arrayList);
            }
            return d0.e0.p.d.m0.e.b.a.access$loadAnnotationIfNotSpecial(this.d.a, aVar, u0Var, arrayList);
        }
    }

    /* compiled from: AbstractBinaryClassAnnotationAndConstantLoader.kt */
    /* renamed from: d0.e0.p.d.m0.e.b.b$b, reason: collision with other inner class name */
    public class C0532b implements p.c {
        public final s a;

        /* renamed from: b, reason: collision with root package name */
        public final ArrayList<A> f3365b;
        public final /* synthetic */ b c;

        public C0532b(b bVar, s sVar) {
            d0.z.d.m.checkNotNullParameter(bVar, "this$0");
            d0.z.d.m.checkNotNullParameter(sVar, "signature");
            this.c = bVar;
            this.a = sVar;
            this.f3365b = new ArrayList<>();
        }

        @Override // d0.e0.p.d.m0.e.b.p.c
        public p.a visitAnnotation(d0.e0.p.d.m0.g.a aVar, u0 u0Var) {
            d0.z.d.m.checkNotNullParameter(aVar, "classId");
            d0.z.d.m.checkNotNullParameter(u0Var, "source");
            return d0.e0.p.d.m0.e.b.a.access$loadAnnotationIfNotSpecial(this.c.a, aVar, u0Var, this.f3365b);
        }

        @Override // d0.e0.p.d.m0.e.b.p.c
        public void visitEnd() {
            if (!this.f3365b.isEmpty()) {
                this.c.f3364b.put(this.a, this.f3365b);
            }
        }
    }

    public b(d0.e0.p.d.m0.e.b.a<A, C> aVar, HashMap<s, List<A>> map, HashMap<s, C> map2) {
        this.a = aVar;
        this.f3364b = map;
        this.c = map2;
    }

    @Override // d0.e0.p.d.m0.e.b.p.d
    public p.c visitField(d0.e0.p.d.m0.g.e eVar, String str, Object obj) {
        d0.z.d.m.checkNotNullParameter(eVar, ModelAuditLogEntry.CHANGE_KEY_NAME);
        d0.z.d.m.checkNotNullParameter(str, "desc");
        s.a aVar = s.a;
        String strAsString = eVar.asString();
        d0.z.d.m.checkNotNullExpressionValue(strAsString, "name.asString()");
        s sVarFromFieldNameAndDesc = aVar.fromFieldNameAndDesc(strAsString, str);
        if (obj != null) {
            Objects.requireNonNull((c) this.a);
            d0.z.d.m.checkNotNullParameter(str, "desc");
            d0.z.d.m.checkNotNullParameter(obj, "initializer");
            if (d0.g0.w.contains$default((CharSequence) "ZBCS", (CharSequence) str, false, 2, (Object) null)) {
                int iIntValue = ((Integer) obj).intValue();
                int iHashCode = str.hashCode();
                if (iHashCode == 66) {
                    if (str.equals("B")) {
                        obj = Byte.valueOf((byte) iIntValue);
                    }
                    throw new AssertionError(str);
                }
                if (iHashCode == 67) {
                    if (str.equals("C")) {
                        obj = Character.valueOf((char) iIntValue);
                    }
                    throw new AssertionError(str);
                }
                if (iHashCode == 83) {
                    if (str.equals(ExifInterface.LATITUDE_SOUTH)) {
                        obj = Short.valueOf((short) iIntValue);
                    }
                    throw new AssertionError(str);
                }
                if (iHashCode == 90 && str.equals("Z")) {
                    obj = Boolean.valueOf(iIntValue != 0);
                }
                throw new AssertionError(str);
            }
            d0.e0.p.d.m0.k.v.g<?> gVarCreateConstantValue = d0.e0.p.d.m0.k.v.h.a.createConstantValue(obj);
            if (gVarCreateConstantValue != null) {
                this.c.put(sVarFromFieldNameAndDesc, gVarCreateConstantValue);
            }
        }
        return new C0532b(this, sVarFromFieldNameAndDesc);
    }

    @Override // d0.e0.p.d.m0.e.b.p.d
    public p.e visitMethod(d0.e0.p.d.m0.g.e eVar, String str) {
        d0.z.d.m.checkNotNullParameter(eVar, ModelAuditLogEntry.CHANGE_KEY_NAME);
        d0.z.d.m.checkNotNullParameter(str, "desc");
        s.a aVar = s.a;
        String strAsString = eVar.asString();
        d0.z.d.m.checkNotNullExpressionValue(strAsString, "name.asString()");
        return new a(this, aVar.fromMethodNameAndDesc(strAsString, str));
    }
}
