package p507d0.p513e0.p514p.p515d.p517m0.p531e.p541b;

import androidx.exifinterface.media.ExifInterface;
import kotlin.NoWhenBranchMatchedException;
import p007b.p100d.p104b.p105a.outline;
import p507d0.p513e0.p514p.p515d.p517m0.p518b.PrimitiveType;
import p507d0.p513e0.p514p.p515d.p517m0.p531e.p541b.methodSignatureMapping;
import p507d0.p513e0.p514p.p515d.p517m0.p552k.p560y.JvmClassName;
import p507d0.p513e0.p514p.p515d.p517m0.p552k.p560y.JvmPrimitiveType;
import p507d0.p579g0.Strings4;
import p507d0.p592z.p594d.Intrinsics3;

/* compiled from: methodSignatureMapping.kt */
/* renamed from: d0.e0.p.d.m0.e.b.m, reason: use source file name */
/* loaded from: classes3.dex */
public final class methodSignatureMapping2 implements typeSignatureMapping3<methodSignatureMapping> {

    /* renamed from: a */
    public static final methodSignatureMapping2 f23629a = new methodSignatureMapping2();

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p531e.p541b.typeSignatureMapping3
    public /* bridge */ /* synthetic */ methodSignatureMapping boxType(methodSignatureMapping methodsignaturemapping) {
        return boxType2(methodsignaturemapping);
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p531e.p541b.typeSignatureMapping3
    public /* bridge */ /* synthetic */ methodSignatureMapping createFromString(String str) {
        return createFromString(str);
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p531e.p541b.typeSignatureMapping3
    /* renamed from: createObjectType, reason: avoid collision after fix types in other method */
    public /* bridge */ /* synthetic */ methodSignatureMapping createObjectType2(String str) {
        return createObjectType(str);
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p531e.p541b.typeSignatureMapping3
    public /* bridge */ /* synthetic */ methodSignatureMapping createPrimitiveType(PrimitiveType primitiveType) {
        return createPrimitiveType(primitiveType);
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p531e.p541b.typeSignatureMapping3
    public /* bridge */ /* synthetic */ methodSignatureMapping getJavaLangClassType() {
        return getJavaLangClassType();
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p531e.p541b.typeSignatureMapping3
    public /* bridge */ /* synthetic */ String toString(methodSignatureMapping methodsignaturemapping) {
        return toString2(methodsignaturemapping);
    }

    /* renamed from: boxType, reason: avoid collision after fix types in other method */
    public methodSignatureMapping boxType2(methodSignatureMapping methodsignaturemapping) {
        Intrinsics3.checkNotNullParameter(methodsignaturemapping, "possiblyPrimitiveType");
        if (!(methodsignaturemapping instanceof methodSignatureMapping.d)) {
            return methodsignaturemapping;
        }
        methodSignatureMapping.d dVar = (methodSignatureMapping.d) methodsignaturemapping;
        if (dVar.getJvmPrimitiveType() == null) {
            return methodsignaturemapping;
        }
        String internalName = JvmClassName.byFqNameWithoutInnerClasses(dVar.getJvmPrimitiveType().getWrapperFqName()).getInternalName();
        Intrinsics3.checkNotNullExpressionValue(internalName, "byFqNameWithoutInnerClasses(possiblyPrimitiveType.jvmPrimitiveType.wrapperFqName).internalName");
        return createObjectType(internalName);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // p507d0.p513e0.p514p.p515d.p517m0.p531e.p541b.typeSignatureMapping3
    public methodSignatureMapping createFromString(String str) {
        JvmPrimitiveType jvmPrimitiveType;
        methodSignatureMapping cVar;
        Intrinsics3.checkNotNullParameter(str, "representation");
        str.length();
        char cCharAt = str.charAt(0);
        JvmPrimitiveType[] jvmPrimitiveTypeArrValues = JvmPrimitiveType.values();
        int i = 0;
        while (true) {
            if (i >= 8) {
                jvmPrimitiveType = null;
                break;
            }
            jvmPrimitiveType = jvmPrimitiveTypeArrValues[i];
            if (jvmPrimitiveType.getDesc().charAt(0) == cCharAt) {
                break;
            }
            i++;
        }
        if (jvmPrimitiveType != null) {
            return new methodSignatureMapping.d(jvmPrimitiveType);
        }
        if (cCharAt == 'V') {
            return new methodSignatureMapping.d(null);
        }
        if (cCharAt == '[') {
            String strSubstring = str.substring(1);
            Intrinsics3.checkNotNullExpressionValue(strSubstring, "(this as java.lang.String).substring(startIndex)");
            cVar = new methodSignatureMapping.a(createFromString(strSubstring));
        } else {
            if (cCharAt == 'L') {
                Strings4.endsWith$default((CharSequence) str, ';', false, 2, (Object) null);
            }
            String strSubstring2 = str.substring(1, str.length() - 1);
            Intrinsics3.checkNotNullExpressionValue(strSubstring2, "(this as java.lang.Strin…ing(startIndex, endIndex)");
            cVar = new methodSignatureMapping.c(strSubstring2);
        }
        return cVar;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p531e.p541b.typeSignatureMapping3
    public methodSignatureMapping createObjectType(String str) {
        Intrinsics3.checkNotNullParameter(str, "internalName");
        return new methodSignatureMapping.c(str);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // p507d0.p513e0.p514p.p515d.p517m0.p531e.p541b.typeSignatureMapping3
    public methodSignatureMapping createPrimitiveType(PrimitiveType primitiveType) {
        Intrinsics3.checkNotNullParameter(primitiveType, "primitiveType");
        switch (primitiveType) {
            case BOOLEAN:
                return methodSignatureMapping.f23617a.getBOOLEAN$descriptors_jvm();
            case CHAR:
                return methodSignatureMapping.f23617a.getCHAR$descriptors_jvm();
            case BYTE:
                return methodSignatureMapping.f23617a.getBYTE$descriptors_jvm();
            case SHORT:
                return methodSignatureMapping.f23617a.getSHORT$descriptors_jvm();
            case INT:
                return methodSignatureMapping.f23617a.getINT$descriptors_jvm();
            case FLOAT:
                return methodSignatureMapping.f23617a.getFLOAT$descriptors_jvm();
            case LONG:
                return methodSignatureMapping.f23617a.getLONG$descriptors_jvm();
            case DOUBLE:
                return methodSignatureMapping.f23617a.getDOUBLE$descriptors_jvm();
            default:
                throw new NoWhenBranchMatchedException();
        }
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // p507d0.p513e0.p514p.p515d.p517m0.p531e.p541b.typeSignatureMapping3
    public methodSignatureMapping getJavaLangClassType() {
        return createObjectType("java/lang/Class");
    }

    /* renamed from: toString, reason: avoid collision after fix types in other method */
    public String toString2(methodSignatureMapping methodsignaturemapping) {
        String desc;
        Intrinsics3.checkNotNullParameter(methodsignaturemapping, "type");
        if (methodsignaturemapping instanceof methodSignatureMapping.a) {
            return Intrinsics3.stringPlus("[", toString2(((methodSignatureMapping.a) methodsignaturemapping).getElementType()));
        }
        if (methodsignaturemapping instanceof methodSignatureMapping.d) {
            JvmPrimitiveType jvmPrimitiveType = ((methodSignatureMapping.d) methodsignaturemapping).getJvmPrimitiveType();
            return (jvmPrimitiveType == null || (desc = jvmPrimitiveType.getDesc()) == null) ? ExifInterface.GPS_MEASUREMENT_INTERRUPTED : desc;
        }
        if (!(methodsignaturemapping instanceof methodSignatureMapping.c)) {
            throw new NoWhenBranchMatchedException();
        }
        StringBuilder sbM829Q = outline.m829Q('L');
        sbM829Q.append(((methodSignatureMapping.c) methodsignaturemapping).getInternalName());
        sbM829Q.append(';');
        return sbM829Q.toString();
    }
}
