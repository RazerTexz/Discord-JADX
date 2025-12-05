package p507d0.p513e0.p514p.p515d.p517m0.p531e.p541b;

import com.discord.widgets.chat.input.MentionUtils;
import p007b.p100d.p104b.p105a.outline;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11469v0;
import p507d0.p513e0.p514p.p515d.p517m0.p543f.C11687l;
import p507d0.p513e0.p514p.p515d.p517m0.p543f.p544a0.JvmProtoBuf;
import p507d0.p513e0.p514p.p515d.p517m0.p543f.p544a0.p545b.JvmMetadataVersion;
import p507d0.p513e0.p514p.p515d.p517m0.p543f.p547z.NameResolver;
import p507d0.p513e0.p514p.p515d.p517m0.p543f.p547z.ProtoBufUtil;
import p507d0.p513e0.p514p.p515d.p517m0.p548g.ClassId;
import p507d0.p513e0.p514p.p515d.p517m0.p548g.Name;
import p507d0.p513e0.p514p.p515d.p517m0.p550i.GeneratedMessageLite;
import p507d0.p513e0.p514p.p515d.p517m0.p552k.p560y.JvmClassName;
import p507d0.p513e0.p514p.p515d.p517m0.p562l.p563b.IncompatibleVersionErrorData;
import p507d0.p513e0.p514p.p515d.p517m0.p562l.p563b.p565e0.DeserializedContainerSource;
import p507d0.p513e0.p514p.p515d.p517m0.p562l.p563b.p565e0.DeserializedContainerSource2;
import p507d0.p579g0.Strings4;
import p507d0.p592z.p594d.Intrinsics3;

/* compiled from: JvmPackagePartSource.kt */
/* renamed from: d0.e0.p.d.m0.e.b.j, reason: use source file name */
/* loaded from: classes3.dex */
public final class JvmPackagePartSource implements DeserializedContainerSource2 {

    /* renamed from: b */
    public final JvmClassName f23614b;

    /* renamed from: c */
    public final JvmClassName f23615c;

    /* renamed from: d */
    public final KotlinJvmBinaryClass f23616d;

    public JvmPackagePartSource(JvmClassName jvmClassName, JvmClassName jvmClassName2, C11687l c11687l, NameResolver nameResolver, IncompatibleVersionErrorData<JvmMetadataVersion> incompatibleVersionErrorData, boolean z2, DeserializedContainerSource deserializedContainerSource, KotlinJvmBinaryClass kotlinJvmBinaryClass) {
        Intrinsics3.checkNotNullParameter(jvmClassName, "className");
        Intrinsics3.checkNotNullParameter(c11687l, "packageProto");
        Intrinsics3.checkNotNullParameter(nameResolver, "nameResolver");
        Intrinsics3.checkNotNullParameter(deserializedContainerSource, "abiStability");
        this.f23614b = jvmClassName;
        this.f23615c = jvmClassName2;
        this.f23616d = kotlinJvmBinaryClass;
        GeneratedMessageLite.f<C11687l, Integer> fVar = JvmProtoBuf.f23663m;
        Intrinsics3.checkNotNullExpressionValue(fVar, "packageModuleName");
        Integer num = (Integer) ProtoBufUtil.getExtensionOrNull(c11687l, fVar);
        if (num == null) {
            return;
        }
        nameResolver.getString(num.intValue());
    }

    public final ClassId getClassId() {
        return new ClassId(this.f23614b.getPackageFqName(), getSimpleName());
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.SourceElement
    public InterfaceC11469v0 getContainingFile() {
        InterfaceC11469v0 interfaceC11469v0 = InterfaceC11469v0.f23100a;
        Intrinsics3.checkNotNullExpressionValue(interfaceC11469v0, "NO_SOURCE_FILE");
        return interfaceC11469v0;
    }

    public final JvmClassName getFacadeClassName() {
        return this.f23615c;
    }

    public final KotlinJvmBinaryClass getKnownJvmBinaryClass() {
        return this.f23616d;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p562l.p563b.p565e0.DeserializedContainerSource2
    public String getPresentableString() {
        StringBuilder sbM833U = outline.m833U("Class '");
        sbM833U.append(getClassId().asSingleFqName().asString());
        sbM833U.append('\'');
        return sbM833U.toString();
    }

    public final Name getSimpleName() {
        String internalName = this.f23614b.getInternalName();
        Intrinsics3.checkNotNullExpressionValue(internalName, "className.internalName");
        Name nameIdentifier = Name.identifier(Strings4.substringAfterLast$default(internalName, MentionUtils.SLASH_CHAR, null, 2, null));
        Intrinsics3.checkNotNullExpressionValue(nameIdentifier, "identifier(className.internalName.substringAfterLast('/'))");
        return nameIdentifier;
    }

    public String toString() {
        return ((Object) JvmPackagePartSource.class.getSimpleName()) + ": " + this.f23614b;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public JvmPackagePartSource(KotlinJvmBinaryClass kotlinJvmBinaryClass, C11687l c11687l, NameResolver nameResolver, IncompatibleVersionErrorData<JvmMetadataVersion> incompatibleVersionErrorData, boolean z2, DeserializedContainerSource deserializedContainerSource) {
        Intrinsics3.checkNotNullParameter(kotlinJvmBinaryClass, "kotlinClass");
        Intrinsics3.checkNotNullParameter(c11687l, "packageProto");
        Intrinsics3.checkNotNullParameter(nameResolver, "nameResolver");
        Intrinsics3.checkNotNullParameter(deserializedContainerSource, "abiStability");
        JvmClassName jvmClassNameByClassId = JvmClassName.byClassId(kotlinJvmBinaryClass.getClassId());
        Intrinsics3.checkNotNullExpressionValue(jvmClassNameByClassId, "byClassId(kotlinClass.classId)");
        String multifileClassName = kotlinJvmBinaryClass.getClassHeader().getMultifileClassName();
        JvmClassName jvmClassNameByInternalName = null;
        if (multifileClassName != null) {
            if (multifileClassName.length() > 0) {
                jvmClassNameByInternalName = JvmClassName.byInternalName(multifileClassName);
            }
        }
        this(jvmClassNameByClassId, jvmClassNameByInternalName, c11687l, nameResolver, incompatibleVersionErrorData, z2, deserializedContainerSource, kotlinJvmBinaryClass);
    }
}
