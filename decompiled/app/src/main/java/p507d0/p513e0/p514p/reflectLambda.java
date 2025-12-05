package p507d0.p513e0.p514p;

import java.io.IOException;
import kotlin.Tuples2;
import kotlin.jvm.functions.Function2;
import kotlin.reflect.KDeclarationContainer;
import kotlin.reflect.KFunction;
import p507d0.Function3;
import p507d0.p513e0.p514p.p515d.EmptyContainerForLocal;
import p507d0.p513e0.p514p.p515d.KFunctionImpl;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.SimpleFunctionDescriptor;
import p507d0.p513e0.p514p.p515d.p517m0.p543f.C11684i;
import p507d0.p513e0.p514p.p515d.p517m0.p543f.C11695t;
import p507d0.p513e0.p514p.p515d.p517m0.p543f.p544a0.p545b.JvmMetadataVersion;
import p507d0.p513e0.p514p.p515d.p517m0.p543f.p544a0.p545b.JvmNameResolver;
import p507d0.p513e0.p514p.p515d.p517m0.p543f.p544a0.p545b.JvmProtoBufUtil;
import p507d0.p513e0.p514p.p515d.p517m0.p543f.p547z.TypeTable;
import p507d0.p513e0.p514p.p515d.p517m0.p562l.p563b.MemberDeserializer;
import p507d0.p513e0.p514p.p515d.util2;
import p507d0.p592z.p594d.FunctionReference;
import p507d0.p592z.p594d.Intrinsics3;
import p507d0.p592z.p594d.Reflection2;

/* compiled from: reflectLambda.kt */
/* renamed from: d0.e0.p.c, reason: use source file name */
/* loaded from: classes3.dex */
public final class reflectLambda {

    /* compiled from: reflectLambda.kt */
    /* renamed from: d0.e0.p.c$a */
    public static final /* synthetic */ class a extends FunctionReference implements Function2<MemberDeserializer, C11684i, SimpleFunctionDescriptor> {

        /* renamed from: j */
        public static final a f22318j = new a();

        public a() {
            super(2);
        }

        @Override // p507d0.p592z.p594d.CallableReference, kotlin.reflect.KCallable
        public final String getName() {
            return "loadFunction";
        }

        @Override // p507d0.p592z.p594d.CallableReference
        public final KDeclarationContainer getOwner() {
            return Reflection2.getOrCreateKotlinClass(MemberDeserializer.class);
        }

        @Override // p507d0.p592z.p594d.CallableReference
        public final String getSignature() {
            return "loadFunction(Lorg/jetbrains/kotlin/metadata/ProtoBuf$Function;)Lorg/jetbrains/kotlin/descriptors/SimpleFunctionDescriptor;";
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final SimpleFunctionDescriptor invoke2(MemberDeserializer memberDeserializer, C11684i c11684i) {
            Intrinsics3.checkNotNullParameter(memberDeserializer, "p1");
            Intrinsics3.checkNotNullParameter(c11684i, "p2");
            return memberDeserializer.loadFunction(c11684i);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ SimpleFunctionDescriptor invoke(MemberDeserializer memberDeserializer, C11684i c11684i) {
            return invoke2(memberDeserializer, c11684i);
        }
    }

    public static final <R> KFunction<R> reflect(Function3<? extends R> function3) throws IOException {
        Intrinsics3.checkNotNullParameter(function3, "$this$reflect");
        Metadata metadata = (Metadata) function3.getClass().getAnnotation(Metadata.class);
        if (metadata != null) {
            String[] strArrM10883d1 = metadata.m10883d1();
            if (strArrM10883d1.length == 0) {
                strArrM10883d1 = null;
            }
            if (strArrM10883d1 != null) {
                Tuples2<JvmNameResolver, C11684i> functionDataFrom = JvmProtoBufUtil.readFunctionDataFrom(strArrM10883d1, metadata.m10884d2());
                JvmNameResolver jvmNameResolverComponent1 = functionDataFrom.component1();
                C11684i c11684iComponent2 = functionDataFrom.component2();
                JvmMetadataVersion jvmMetadataVersion = new JvmMetadataVersion(metadata.m10886mv(), (metadata.m10888xi() & 8) != 0);
                Class<?> cls = function3.getClass();
                C11695t typeTable = c11684iComponent2.getTypeTable();
                Intrinsics3.checkNotNullExpressionValue(typeTable, "proto.typeTable");
                SimpleFunctionDescriptor simpleFunctionDescriptor = (SimpleFunctionDescriptor) util2.deserializeToDescriptor(cls, c11684iComponent2, jvmNameResolverComponent1, new TypeTable(typeTable), jvmMetadataVersion, a.f22318j);
                if (simpleFunctionDescriptor != null) {
                    return new KFunctionImpl(EmptyContainerForLocal.f22320m, simpleFunctionDescriptor);
                }
            }
        }
        return null;
    }
}
