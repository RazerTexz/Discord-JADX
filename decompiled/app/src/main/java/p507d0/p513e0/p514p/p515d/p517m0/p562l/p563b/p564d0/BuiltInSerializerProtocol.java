package p507d0.p513e0.p514p.p515d.p517m0.p562l.p563b.p564d0;

import com.discord.widgets.chat.input.MentionUtils;
import java.util.List;
import p507d0.p513e0.p514p.p515d.p517m0.p543f.C11677b;
import p507d0.p513e0.p514p.p515d.p517m0.p543f.C11678c;
import p507d0.p513e0.p514p.p515d.p517m0.p543f.C11679d;
import p507d0.p513e0.p514p.p515d.p517m0.p543f.C11682g;
import p507d0.p513e0.p514p.p515d.p517m0.p543f.C11684i;
import p507d0.p513e0.p514p.p515d.p517m0.p543f.C11687l;
import p507d0.p513e0.p514p.p515d.p517m0.p543f.C11689n;
import p507d0.p513e0.p514p.p515d.p517m0.p543f.C11692q;
import p507d0.p513e0.p514p.p515d.p517m0.p543f.C11694s;
import p507d0.p513e0.p514p.p515d.p517m0.p543f.C11696u;
import p507d0.p513e0.p514p.p515d.p517m0.p543f.p546y.BuiltInsProtoBuf;
import p507d0.p513e0.p514p.p515d.p517m0.p548g.FqName;
import p507d0.p513e0.p514p.p515d.p517m0.p550i.ExtensionRegistryLite;
import p507d0.p513e0.p514p.p515d.p517m0.p550i.GeneratedMessageLite;
import p507d0.p513e0.p514p.p515d.p517m0.p562l.SerializerExtensionProtocol;
import p507d0.p579g0.StringsJVM;
import p507d0.p592z.p594d.Intrinsics3;

/* JADX INFO: renamed from: d0.e0.p.d.m0.l.b.d0.a, reason: use source file name */
/* JADX INFO: compiled from: BuiltInSerializerProtocol.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class BuiltInSerializerProtocol extends SerializerExtensionProtocol {

    /* JADX INFO: renamed from: m */
    public static final BuiltInSerializerProtocol f24515m = new BuiltInSerializerProtocol();

    /* JADX WARN: Illegal instructions before constructor call */
    public BuiltInSerializerProtocol() {
        ExtensionRegistryLite extensionRegistryLiteNewInstance = ExtensionRegistryLite.newInstance();
        BuiltInsProtoBuf.registerAllExtensions(extensionRegistryLiteNewInstance);
        Intrinsics3.checkNotNullExpressionValue(extensionRegistryLiteNewInstance, "newInstance().apply(BuiltInsProtoBuf::registerAllExtensions)");
        GeneratedMessageLite.f<C11687l, Integer> fVar = BuiltInsProtoBuf.f24000a;
        Intrinsics3.checkNotNullExpressionValue(fVar, "packageFqName");
        GeneratedMessageLite.f<C11679d, List<C11677b>> fVar2 = BuiltInsProtoBuf.f24002c;
        Intrinsics3.checkNotNullExpressionValue(fVar2, "constructorAnnotation");
        GeneratedMessageLite.f<C11678c, List<C11677b>> fVar3 = BuiltInsProtoBuf.f24001b;
        Intrinsics3.checkNotNullExpressionValue(fVar3, "classAnnotation");
        GeneratedMessageLite.f<C11684i, List<C11677b>> fVar4 = BuiltInsProtoBuf.f24003d;
        Intrinsics3.checkNotNullExpressionValue(fVar4, "functionAnnotation");
        GeneratedMessageLite.f<C11689n, List<C11677b>> fVar5 = BuiltInsProtoBuf.f24004e;
        Intrinsics3.checkNotNullExpressionValue(fVar5, "propertyAnnotation");
        GeneratedMessageLite.f<C11689n, List<C11677b>> fVar6 = BuiltInsProtoBuf.f24005f;
        Intrinsics3.checkNotNullExpressionValue(fVar6, "propertyGetterAnnotation");
        GeneratedMessageLite.f<C11689n, List<C11677b>> fVar7 = BuiltInsProtoBuf.f24006g;
        Intrinsics3.checkNotNullExpressionValue(fVar7, "propertySetterAnnotation");
        GeneratedMessageLite.f<C11682g, List<C11677b>> fVar8 = BuiltInsProtoBuf.f24008i;
        Intrinsics3.checkNotNullExpressionValue(fVar8, "enumEntryAnnotation");
        GeneratedMessageLite.f<C11689n, C11677b.b.c> fVar9 = BuiltInsProtoBuf.f24007h;
        Intrinsics3.checkNotNullExpressionValue(fVar9, "compileTimeValue");
        GeneratedMessageLite.f<C11696u, List<C11677b>> fVar10 = BuiltInsProtoBuf.f24009j;
        Intrinsics3.checkNotNullExpressionValue(fVar10, "parameterAnnotation");
        GeneratedMessageLite.f<C11692q, List<C11677b>> fVar11 = BuiltInsProtoBuf.f24010k;
        Intrinsics3.checkNotNullExpressionValue(fVar11, "typeAnnotation");
        GeneratedMessageLite.f<C11694s, List<C11677b>> fVar12 = BuiltInsProtoBuf.f24011l;
        Intrinsics3.checkNotNullExpressionValue(fVar12, "typeParameterAnnotation");
        super(extensionRegistryLiteNewInstance, fVar, fVar2, fVar3, fVar4, fVar5, fVar6, fVar7, fVar8, fVar9, fVar10, fVar11, fVar12);
    }

    public final String getBuiltInsFileName(FqName fqName) {
        String strAsString;
        Intrinsics3.checkNotNullParameter(fqName, "fqName");
        if (fqName.isRoot()) {
            strAsString = "default-package";
        } else {
            strAsString = fqName.shortName().asString();
            Intrinsics3.checkNotNullExpressionValue(strAsString, "fqName.shortName().asString()");
        }
        return Intrinsics3.stringPlus(strAsString, ".kotlin_builtins");
    }

    public final String getBuiltInsFilePath(FqName fqName) {
        Intrinsics3.checkNotNullParameter(fqName, "fqName");
        StringBuilder sb = new StringBuilder();
        String strAsString = fqName.asString();
        Intrinsics3.checkNotNullExpressionValue(strAsString, "fqName.asString()");
        sb.append(StringsJVM.replace$default(strAsString, '.', MentionUtils.SLASH_CHAR, false, 4, (Object) null));
        sb.append(MentionUtils.SLASH_CHAR);
        sb.append(getBuiltInsFileName(fqName));
        return sb.toString();
    }
}
