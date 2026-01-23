package p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p540l0;

import androidx.exifinterface.media.ExifInterface;
import com.discord.models.domain.ModelAuditLogEntry;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Tuples2;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import p507d0.Tuples;
import p507d0.p512d0._Ranges;
import p507d0.p513e0.p514p.p515d.p517m0.p531e.p541b.SignatureBuildingComponents;
import p507d0.p513e0.p514p.p515d.p517m0.p552k.p560y.JvmPrimitiveType;
import p507d0.p580t.IndexedValue;
import p507d0.p580t.Iterables2;
import p507d0.p580t.MapsJVM;
import p507d0.p580t._Arrays;
import p507d0.p592z.p594d.Intrinsics3;

/* JADX INFO: renamed from: d0.e0.p.d.m0.e.a.l0.q, reason: use source file name */
/* JADX INFO: compiled from: predefinedEnhancementInfo.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class predefinedEnhancementInfo3 {

    /* JADX INFO: renamed from: a */
    public final Map<String, predefinedEnhancementInfo2> f23492a = new LinkedHashMap();

    public static final /* synthetic */ Map access$getSignatures$p(predefinedEnhancementInfo3 predefinedenhancementinfo3) {
        return predefinedenhancementinfo3.f23492a;
    }

    public final Map<String, predefinedEnhancementInfo2> build() {
        return this.f23492a;
    }

    /* JADX INFO: renamed from: d0.e0.p.d.m0.e.a.l0.q$a */
    /* JADX INFO: compiled from: predefinedEnhancementInfo.kt */
    public final class a {

        /* JADX INFO: renamed from: a */
        public final String f23493a;

        /* JADX INFO: renamed from: b */
        public final /* synthetic */ predefinedEnhancementInfo3 f23494b;

        public a(predefinedEnhancementInfo3 predefinedenhancementinfo3, String str) {
            Intrinsics3.checkNotNullParameter(predefinedenhancementinfo3, "this$0");
            Intrinsics3.checkNotNullParameter(str, "className");
            this.f23494b = predefinedenhancementinfo3;
            this.f23493a = str;
        }

        public final void function(String str, Function1<? super C13313a, Unit> function1) {
            Intrinsics3.checkNotNullParameter(str, ModelAuditLogEntry.CHANGE_KEY_NAME);
            Intrinsics3.checkNotNullParameter(function1, "block");
            Map mapAccess$getSignatures$p = predefinedEnhancementInfo3.access$getSignatures$p(this.f23494b);
            C13313a c13313a = new C13313a(this, str);
            function1.invoke(c13313a);
            Tuples2<String, predefinedEnhancementInfo2> tuples2Build = c13313a.build();
            mapAccess$getSignatures$p.put(tuples2Build.getFirst(), tuples2Build.getSecond());
        }

        public final String getClassName() {
            return this.f23493a;
        }

        /* JADX INFO: renamed from: d0.e0.p.d.m0.e.a.l0.q$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: predefinedEnhancementInfo.kt */
        public final class C13313a {

            /* JADX INFO: renamed from: a */
            public final String f23495a;

            /* JADX INFO: renamed from: b */
            public final List<Tuples2<String, predefinedEnhancementInfo4>> f23496b;

            /* JADX INFO: renamed from: c */
            public Tuples2<String, predefinedEnhancementInfo4> f23497c;

            /* JADX INFO: renamed from: d */
            public final /* synthetic */ a f23498d;

            public C13313a(a aVar, String str) {
                Intrinsics3.checkNotNullParameter(aVar, "this$0");
                Intrinsics3.checkNotNullParameter(str, "functionName");
                this.f23498d = aVar;
                this.f23495a = str;
                this.f23496b = new ArrayList();
                this.f23497c = Tuples.m10073to(ExifInterface.GPS_MEASUREMENT_INTERRUPTED, null);
            }

            public final Tuples2<String, predefinedEnhancementInfo2> build() {
                SignatureBuildingComponents signatureBuildingComponents = SignatureBuildingComponents.f23636a;
                String className = this.f23498d.getClassName();
                String functionName = getFunctionName();
                List<Tuples2<String, predefinedEnhancementInfo4>> list = this.f23496b;
                ArrayList arrayList = new ArrayList(Iterables2.collectionSizeOrDefault(list, 10));
                Iterator<T> it = list.iterator();
                while (it.hasNext()) {
                    arrayList.add((String) ((Tuples2) it.next()).getFirst());
                }
                String strSignature = signatureBuildingComponents.signature(className, signatureBuildingComponents.jvmDescriptor(functionName, arrayList, this.f23497c.getFirst()));
                predefinedEnhancementInfo4 second = this.f23497c.getSecond();
                List<Tuples2<String, predefinedEnhancementInfo4>> list2 = this.f23496b;
                ArrayList arrayList2 = new ArrayList(Iterables2.collectionSizeOrDefault(list2, 10));
                Iterator<T> it2 = list2.iterator();
                while (it2.hasNext()) {
                    arrayList2.add((predefinedEnhancementInfo4) ((Tuples2) it2.next()).getSecond());
                }
                return Tuples.m10073to(strSignature, new predefinedEnhancementInfo2(second, arrayList2));
            }

            public final String getFunctionName() {
                return this.f23495a;
            }

            public final void parameter(String str, typeQualifiers... typequalifiersArr) {
                predefinedEnhancementInfo4 predefinedenhancementinfo4;
                Intrinsics3.checkNotNullParameter(str, "type");
                Intrinsics3.checkNotNullParameter(typequalifiersArr, "qualifiers");
                List<Tuples2<String, predefinedEnhancementInfo4>> list = this.f23496b;
                if (typequalifiersArr.length == 0) {
                    predefinedenhancementinfo4 = null;
                } else {
                    Iterable<IndexedValue> iterableWithIndex = _Arrays.withIndex(typequalifiersArr);
                    LinkedHashMap linkedHashMap = new LinkedHashMap(_Ranges.coerceAtLeast(MapsJVM.mapCapacity(Iterables2.collectionSizeOrDefault(iterableWithIndex, 10)), 16));
                    for (IndexedValue indexedValue : iterableWithIndex) {
                        linkedHashMap.put(Integer.valueOf(indexedValue.getIndex()), (typeQualifiers) indexedValue.getValue());
                    }
                    predefinedenhancementinfo4 = new predefinedEnhancementInfo4(linkedHashMap);
                }
                list.add(Tuples.m10073to(str, predefinedenhancementinfo4));
            }

            public final void returns(String str, typeQualifiers... typequalifiersArr) {
                Intrinsics3.checkNotNullParameter(str, "type");
                Intrinsics3.checkNotNullParameter(typequalifiersArr, "qualifiers");
                Iterable<IndexedValue> iterableWithIndex = _Arrays.withIndex(typequalifiersArr);
                LinkedHashMap linkedHashMap = new LinkedHashMap(_Ranges.coerceAtLeast(MapsJVM.mapCapacity(Iterables2.collectionSizeOrDefault(iterableWithIndex, 10)), 16));
                for (IndexedValue indexedValue : iterableWithIndex) {
                    linkedHashMap.put(Integer.valueOf(indexedValue.getIndex()), (typeQualifiers) indexedValue.getValue());
                }
                this.f23497c = Tuples.m10073to(str, new predefinedEnhancementInfo4(linkedHashMap));
            }

            public final void returns(JvmPrimitiveType jvmPrimitiveType) {
                Intrinsics3.checkNotNullParameter(jvmPrimitiveType, "type");
                String desc = jvmPrimitiveType.getDesc();
                Intrinsics3.checkNotNullExpressionValue(desc, "type.desc");
                this.f23497c = Tuples.m10073to(desc, null);
            }
        }
    }
}
