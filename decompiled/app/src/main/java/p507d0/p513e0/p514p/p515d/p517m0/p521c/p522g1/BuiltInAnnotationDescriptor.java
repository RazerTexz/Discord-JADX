package p507d0.p513e0.p514p.p515d.p517m0.p521c.p522g1;

import java.util.Map;
import kotlin.Lazy;
import kotlin.jvm.functions.Function0;
import p507d0.Lazy5;
import p507d0.LazyJVM;
import p507d0.p513e0.p514p.p515d.p517m0.p518b.KotlinBuiltIns;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.SourceElement;
import p507d0.p513e0.p514p.p515d.p517m0.p548g.FqName;
import p507d0.p513e0.p514p.p515d.p517m0.p548g.Name;
import p507d0.p513e0.p514p.p515d.p517m0.p552k.p557v.AbstractC11815g;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.KotlinType;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.KotlinType4;
import p507d0.p592z.p594d.Intrinsics3;
import p507d0.p592z.p594d.Lambda;

/* compiled from: BuiltInAnnotationDescriptor.kt */
/* renamed from: d0.e0.p.d.m0.c.g1.j, reason: use source file name */
/* loaded from: classes3.dex */
public final class BuiltInAnnotationDescriptor implements AnnotationDescriptor {

    /* renamed from: a */
    public final KotlinBuiltIns f22739a;

    /* renamed from: b */
    public final FqName f22740b;

    /* renamed from: c */
    public final Map<Name, AbstractC11815g<?>> f22741c;

    /* renamed from: d */
    public final Lazy f22742d;

    /* compiled from: BuiltInAnnotationDescriptor.kt */
    /* renamed from: d0.e0.p.d.m0.c.g1.j$a */
    public static final class a extends Lambda implements Function0<KotlinType4> {
        public a() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ KotlinType4 invoke() {
            return invoke();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final KotlinType4 invoke() {
            return BuiltInAnnotationDescriptor.access$getBuiltIns$p(BuiltInAnnotationDescriptor.this).getBuiltInClassByFqName(BuiltInAnnotationDescriptor.this.getFqName()).getDefaultType();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public BuiltInAnnotationDescriptor(KotlinBuiltIns kotlinBuiltIns, FqName fqName, Map<Name, ? extends AbstractC11815g<?>> map) {
        Intrinsics3.checkNotNullParameter(kotlinBuiltIns, "builtIns");
        Intrinsics3.checkNotNullParameter(fqName, "fqName");
        Intrinsics3.checkNotNullParameter(map, "allValueArguments");
        this.f22739a = kotlinBuiltIns;
        this.f22740b = fqName;
        this.f22741c = map;
        this.f22742d = LazyJVM.lazy(Lazy5.PUBLICATION, new a());
    }

    public static final /* synthetic */ KotlinBuiltIns access$getBuiltIns$p(BuiltInAnnotationDescriptor builtInAnnotationDescriptor) {
        return builtInAnnotationDescriptor.f22739a;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.p522g1.AnnotationDescriptor
    public Map<Name, AbstractC11815g<?>> getAllValueArguments() {
        return this.f22741c;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.p522g1.AnnotationDescriptor
    public FqName getFqName() {
        return this.f22740b;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.p522g1.AnnotationDescriptor
    public SourceElement getSource() {
        SourceElement sourceElement = SourceElement.f23099a;
        Intrinsics3.checkNotNullExpressionValue(sourceElement, "NO_SOURCE");
        return sourceElement;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.p522g1.AnnotationDescriptor
    public KotlinType getType() {
        Object value = this.f22742d.getValue();
        Intrinsics3.checkNotNullExpressionValue(value, "pyright 2010-2017 JetBrains s.r.o.\n *\n * Licensed under the Apache License, Version 2.0 (the \"License\");\n * you may not use this file except in compliance with the License.\n * You may obtain a copy of the License at\n *\n * http://www.apache.org/licenses/LICENSE-2.0\n *\n * Unless required by applicable law or agreed to in writing, software\n * distributed under the License is distributed on an \"AS IS\" BASIS,\n * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.\n * See the License for the specific language governing permissions and\n * limitations under the License.\n */\n\npackage org.jetbrains.kotlin.descriptors.annotations\n\nimport org.jetbrains.kotlin.builtins.KotlinBuiltIns\nimport org.jetbrains.kotlin.descriptors.SourceElement\nimport org.jetbrains.kotlin.name.FqName\nimport org.jetbrains.kotlin.name.Name\nimport org.jetbrains.kotlin.resolve.constants.ConstantValue\nimport org.jetbrains.kotlin.types.KotlinType\nimport kotlin.LazyThreadSafetyMode.PUBLICATION\n\nclass BuiltInAnnotationDescriptor(\n        private val builtIns: KotlinBuiltIns,\n        override val fqName: FqName,\n        override val allValueArguments: Map<Name, ConstantValue<*>>\n) : AnnotationDescriptor {\n    override val type: KotlinType by lazy(PUBLICATION) {\n        builtIns.getBuiltInClassByFqName(fqName).defaultType\n    }");
        return (KotlinType) value;
    }
}
