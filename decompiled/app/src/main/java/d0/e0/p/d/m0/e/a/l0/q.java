package d0.e0.p.d.m0.e.a.l0;

import androidx.exifinterface.media.ExifInterface;
import com.discord.models.domain.ModelAuditLogEntry;
import d0.t.g0;
import d0.t.z;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* compiled from: predefinedEnhancementInfo.kt */
/* loaded from: classes3.dex */
public final class q {
    public final Map<String, k> a = new LinkedHashMap();

    public static final /* synthetic */ Map access$getSignatures$p(q qVar) {
        return qVar.a;
    }

    public final Map<String, k> build() {
        return this.a;
    }

    /* compiled from: predefinedEnhancementInfo.kt */
    public final class a {
        public final String a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ q f3351b;

        public a(q qVar, String str) {
            d0.z.d.m.checkNotNullParameter(qVar, "this$0");
            d0.z.d.m.checkNotNullParameter(str, "className");
            this.f3351b = qVar;
            this.a = str;
        }

        public final void function(String str, Function1<? super C0530a, Unit> function1) {
            d0.z.d.m.checkNotNullParameter(str, ModelAuditLogEntry.CHANGE_KEY_NAME);
            d0.z.d.m.checkNotNullParameter(function1, "block");
            Map mapAccess$getSignatures$p = q.access$getSignatures$p(this.f3351b);
            C0530a c0530a = new C0530a(this, str);
            function1.invoke(c0530a);
            Pair<String, k> pairBuild = c0530a.build();
            mapAccess$getSignatures$p.put(pairBuild.getFirst(), pairBuild.getSecond());
        }

        public final String getClassName() {
            return this.a;
        }

        /* compiled from: predefinedEnhancementInfo.kt */
        /* renamed from: d0.e0.p.d.m0.e.a.l0.q$a$a, reason: collision with other inner class name */
        public final class C0530a {
            public final String a;

            /* renamed from: b, reason: collision with root package name */
            public final List<Pair<String, w>> f3352b;
            public Pair<String, w> c;
            public final /* synthetic */ a d;

            public C0530a(a aVar, String str) {
                d0.z.d.m.checkNotNullParameter(aVar, "this$0");
                d0.z.d.m.checkNotNullParameter(str, "functionName");
                this.d = aVar;
                this.a = str;
                this.f3352b = new ArrayList();
                this.c = d0.o.to(ExifInterface.GPS_MEASUREMENT_INTERRUPTED, null);
            }

            public final Pair<String, k> build() {
                d0.e0.p.d.m0.e.b.w wVar = d0.e0.p.d.m0.e.b.w.a;
                String className = this.d.getClassName();
                String functionName = getFunctionName();
                List<Pair<String, w>> list = this.f3352b;
                ArrayList arrayList = new ArrayList(d0.t.o.collectionSizeOrDefault(list, 10));
                Iterator<T> it = list.iterator();
                while (it.hasNext()) {
                    arrayList.add((String) ((Pair) it.next()).getFirst());
                }
                String strSignature = wVar.signature(className, wVar.jvmDescriptor(functionName, arrayList, this.c.getFirst()));
                w second = this.c.getSecond();
                List<Pair<String, w>> list2 = this.f3352b;
                ArrayList arrayList2 = new ArrayList(d0.t.o.collectionSizeOrDefault(list2, 10));
                Iterator<T> it2 = list2.iterator();
                while (it2.hasNext()) {
                    arrayList2.add((w) ((Pair) it2.next()).getSecond());
                }
                return d0.o.to(strSignature, new k(second, arrayList2));
            }

            public final String getFunctionName() {
                return this.a;
            }

            public final void parameter(String str, e... eVarArr) {
                w wVar;
                d0.z.d.m.checkNotNullParameter(str, "type");
                d0.z.d.m.checkNotNullParameter(eVarArr, "qualifiers");
                List<Pair<String, w>> list = this.f3352b;
                if (eVarArr.length == 0) {
                    wVar = null;
                } else {
                    Iterable<z> iterableWithIndex = d0.t.k.withIndex(eVarArr);
                    LinkedHashMap linkedHashMap = new LinkedHashMap(d0.d0.f.coerceAtLeast(g0.mapCapacity(d0.t.o.collectionSizeOrDefault(iterableWithIndex, 10)), 16));
                    for (z zVar : iterableWithIndex) {
                        linkedHashMap.put(Integer.valueOf(zVar.getIndex()), (e) zVar.getValue());
                    }
                    wVar = new w(linkedHashMap);
                }
                list.add(d0.o.to(str, wVar));
            }

            public final void returns(String str, e... eVarArr) {
                d0.z.d.m.checkNotNullParameter(str, "type");
                d0.z.d.m.checkNotNullParameter(eVarArr, "qualifiers");
                Iterable<z> iterableWithIndex = d0.t.k.withIndex(eVarArr);
                LinkedHashMap linkedHashMap = new LinkedHashMap(d0.d0.f.coerceAtLeast(g0.mapCapacity(d0.t.o.collectionSizeOrDefault(iterableWithIndex, 10)), 16));
                for (z zVar : iterableWithIndex) {
                    linkedHashMap.put(Integer.valueOf(zVar.getIndex()), (e) zVar.getValue());
                }
                this.c = d0.o.to(str, new w(linkedHashMap));
            }

            public final void returns(d0.e0.p.d.m0.k.y.d dVar) {
                d0.z.d.m.checkNotNullParameter(dVar, "type");
                String desc = dVar.getDesc();
                d0.z.d.m.checkNotNullExpressionValue(desc, "type.desc");
                this.c = d0.o.to(desc, null);
            }
        }
    }
}
